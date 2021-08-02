package test;

import java.awt.Color;

import component.ImagePanel;
import component.RectanglePanel;
import engine.Abs;
import engine.gameobject.GameObject;
import engine.gameobject.component.VelocityComponent;

public class SimpleTest {

	public static void main(String[] args) {
		          
		Abs.init();
		try {
			Abs.getGameEngine().start();
			GameObject g = Abs.createGameObject();
//			g.setView(new RectanglePanel(0,0,100,100,Color.BLUE));
			g.setView(new RectanglePanel(0,0,100,100,Color.orange));
			g.addComponent(new VelocityComponent(1,0));
			g.addToWorld();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
