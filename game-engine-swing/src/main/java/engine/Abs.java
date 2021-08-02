package engine;

import engine.gameobject.GameObject;
import engine.gameworld.GameWorld;

public class Abs {
	private static Loader loader;
	
	private static GameEngine gameEngine;
	
	private static GameWorld gameWorld;
	
	public static void init() {
		gameEngine = new GameEngine();
		gameEngine.init();
	}
	
	public static GameEngine getGameEngine() throws Exception {
		if(gameEngine == null) {
			throw new Exception("The gameengine is not initialized");
		}
		return gameEngine;
	}
	
	public static Loader getLoader() {
		if(loader == null) {
			loader = new Loader();
		}
		return loader;
	}
	
	public static GameWorld getGameWorld() {
		if(gameWorld == null) 
		{
			gameWorld = new GameWorld();
		}
		return gameWorld;
	}
	
	public static GameObject createGameObject() {
		return new GameObject();
	}
}
