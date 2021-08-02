package engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import engine.gameworld.GameWorld;
import lombok.Getter;
import lombok.extern.java.Log;

@Log
public class GameEngine extends Canvas implements Runnable{
	
	private int ticks = 0;
	private int fps;
	private double timeFps = 1.0 / 60.0 * 1000.0;
	private long lastTime = 0;
	private long timer = 0;
	private long timerFps = 0;
	private static final int BUFFERS_COUNT = 3;



	private boolean enable = false;

	private boolean stopEngine = false;

	private boolean stopRender = false;

	private boolean canRender = true;
	
	private final int WIDTH = 500;
	private final int HEIGHT = 400;

	@Getter
	private JFrame frame;

	public void init() {
		
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
//		this.addKeyListener(new Keyboard());
//		this.addMouseMotionListener(new MousePicking());
//		this.addMouseListener(new Mouse());
//		this.addMouseMotionListener(new Mouse());
		frame.add(this,BorderLayout.WEST);
		frame.pack();


		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				enable = false;
				e.getWindow().dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
			

	}

	/**
	 * Start the gameloop.
	 */
	public void start() {

		if(!enable) {
			enable = true;
			System.out.println("start");
			new Thread(this).start();	
		}
	}

	public void resumeEngine() {
		stopEngine = false;
	}

	public void resumeRender() {
		stopRender = false;
	}

	public void stopEngine() {
		stopEngine = true;
	}

	public void stopRender() {
		stopRender = true;
	}

	public void update(double delta) {
		// TODO apply logic.
		Abs.getGameWorld().onUpdate(delta);
	}

	public synchronized void render() {
		// TODO render game.
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(BUFFERS_COUNT);
			return;
		}
		Graphics2D context = prepareCanvas(bs);
		
		Abs.getGameWorld().onRender(context);
		
		context.dispose();
		bs.show();
	}

	private Graphics2D prepareCanvas(BufferStrategy bs) {
		Graphics2D context = (Graphics2D) bs.getDrawGraphics().create();
		
		context.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		context.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		context.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		context.setColor(Color.white);
		context.fillRect(0, 0, WIDTH, HEIGHT);
		return context;
	}
	
	double deltaFrame = 0;
	@Override
	public void run() {
		while(enable) {
			long currentTime = System.currentTimeMillis();
			if(lastTime != 0) {						
				double delta = currentTime - lastTime;
				timerFps += delta;
				timer+=delta;
			}
			lastTime = currentTime;

			if(!stopEngine)
			{
				update(deltaFrame*0.001);
				ticks++;
			}
			
			if(timer>timeFps) {	
				deltaFrame = timer;
				if(canRender) {
					if(!stopRender) {
						render();
					}
					fps++;
				}						
				timer = 0;
			}
			if(timerFps>1000) {
				frame.setTitle("fps"+fps+" ticks:"+ticks);
				fps = 0;
				timerFps = 0;
				ticks = 0;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				log.warning(e.getMessage());
			}

		}

	}
}
