package engine.gameobject.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VelocityComponent extends Component{
	private int velocityX;
	private int velocityY;
	
	@Override
	public void onUpdate(double deltaFrame) {
		
		System.out.println(velocityX * deltaFrame);
		
		gameObject.setX((gameObject.getX() + velocityX * deltaFrame));
		gameObject.setY((gameObject.getY() + velocityY * deltaFrame));
	}
}
