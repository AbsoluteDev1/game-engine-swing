package component.commons;

import javax.swing.JPanel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class Element extends JPanel{
	int width;
	int height;
	int x;
	int y;
}
