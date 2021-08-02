package engine.gameobject.component;

import engine.gameobject.GameObject;
import lombok.Getter;
import lombok.Setter;

public class Component {
	
	@Getter @Setter
	protected GameObject gameObject;
	
	public void onUpdate(double delta) {
		
	}
	
	public void onRender() {
		
	}
}
