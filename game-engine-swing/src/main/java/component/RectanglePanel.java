package component;

import java.awt.Color;

import component.commons.Element;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
public class RectanglePanel extends Element{
	@Getter @Setter
	private Color color;
	
	public RectanglePanel(int x,int y,int w,int h,Color c) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
		this.color = c;
	}
	
}