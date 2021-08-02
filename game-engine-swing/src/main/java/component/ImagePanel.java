package component;

import java.awt.image.BufferedImage;

import component.commons.Element;
import engine.Abs;

@SuppressWarnings("serial")
public class ImagePanel extends Element{
	private BufferedImage image;
	public ImagePanel(String path) {
		image = Abs.getLoader().getImage(path);
	}
}