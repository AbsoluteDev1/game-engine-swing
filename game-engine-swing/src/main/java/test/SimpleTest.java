package test;

import engine.Abs;

public class SimpleTest {

	public static void main(String[] args) {
		          
		Abs.init();
		try {
			Abs.getGameEngine().start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
