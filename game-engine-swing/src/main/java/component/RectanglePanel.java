package component;

import java.awt.Color;
import java.awt.Graphics;

import component.commons.Element;

@SuppressWarnings("serial")
public class RectanglePanel extends Element{
	
	private Color color;
	
	public RectanglePanel(int x,int y,int w,int h) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.drawRect(this.getX(), this.getY(), this.getWidth(),this.getHeight());
	}
}