package engine.gameworld;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import engine.gameobject.GameObject;
import lombok.Getter;

public class GameWorld {
	@Getter
	private List<GameObject> gameObjects = new ArrayList<>();
	
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void onUpdate(double delta) {
		gameObjects.forEach(g -> g.onUpdate(delta));
	}
	
	public void onRender(Graphics2D context) {
		gameObjects.forEach(g-> g.onRender(context));
	}
}
