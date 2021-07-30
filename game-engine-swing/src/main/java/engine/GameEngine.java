package engine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import lombok.Getter;
import lombok.extern.java.Log;

@Log
public class GameEngine {

	private Thread gameloop;

	private boolean enable = true;

	private boolean stopEngine = false;

	private boolean stopRender = false;

	private boolean canRender = true;

	@Getter
	private JFrame frame;

	public void init() {
		frame=new JFrame();//creating instance of JFrame  
		frame.setSize(400,500);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible 

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

		initGameLoop();
	}
	private void initGameLoop() {
		gameloop = new Thread() {
			private int ticks = 0;
			private int fps;
			private double timeFps = 1.0 / 60.0 * 1000.0;
			private long lastTime = 0;
			private long timer = 0;
			private long timerFps = 0;
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
						update();
						ticks++;
					}
					if(timer>timeFps) {						
						if(canRender) {
							if(!stopRender) {
								render();
							}
							fps++;
						}						
						timer = 0;
					}
					if(timerFps>1000) {
						System.out.println("fps :"+fps);
						fps = 0;
						timerFps = 0;
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						log.warning(e.getMessage());
					}

				}

			}

		};
	}
	/**
	 * Start the gameloop.
	 */
	public void start() {
		gameloop.start();
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

	public void update() {
		// TODO apply logic.
	}

	public void render() {
		// TODO render game.
	}
}
