package engine;

public class Abs {
	private static Loader loader;
	
	private static GameEngine gameEngine;
	
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
}
