package engine;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import lombok.extern.java.Log;

@Log
public class Loader {
	public BufferedImage getImage(String path){
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(Loader.class.getClassLoader().getResourceAsStream("/assets/images/"+path));
		} catch (IOException e) {
			log.warning(String.format("Image not found : %s", path));
			
		}
		return bi;
	}
}
