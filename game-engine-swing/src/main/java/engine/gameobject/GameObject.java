package engine.gameobject;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import component.RectanglePanel;
import component.commons.Element;
import engine.Abs;
import engine.gameobject.component.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
public class GameObject{
	@Getter @Setter
	private double x;
	@Getter @Setter
	private double y;
	@Getter @Setter
	private int rotation;
	@Getter
	private String id;
	@Getter
	private Element view;
	
	private Map<Class<?>,Component> components = new HashMap<>();
	
	public GameObject() {
		id = UUID.randomUUID().toString();
	}
	
	public void onUpdate(double delta) {
		components.values().forEach(c -> c.onUpdate(delta));
	}
	
	public void setView(Element view) {
		this.view = view;
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warning("The current view component added is null");
		}
	}
	
	public void setPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void onRender(Graphics2D context) {
		if(view != null) {
			view.setX(x);
			view.setY(y);
			draw(context);
		}
	}
	
	public void draw(Graphics2D context) {
		if(view instanceof RectanglePanel) {
			context.setColor(((RectanglePanel) view).getColor());
			context.fillRect((int)this.x, (int)this.y, this.view.getWidth(), this.view.getHeight());
		}
	}
	
	public void addToWorld() {
		Abs.getGameWorld().addGameObject(this);
	}
	
	public void addComponent(Component c) {
		c.setGameObject(this);
		components.put(c.getClass(),c);
	}
	
	@SuppressWarnings("unchecked")
	public <T>T getComponent(T component) {
		return (T) components.get(component);
	}
}
