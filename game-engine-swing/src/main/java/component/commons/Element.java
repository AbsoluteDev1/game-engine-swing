package component.commons;

import javax.swing.JPanel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class Element{
	int width;
	int height;
	double x;
	double y;
}
