package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

	private int radius = 50;

	public Circle(double x, double y, Color color, int shapeType) {
		super(x, y, color, 0);
	}

	@Override
	public void drawYourself(GraphicsContext gc) {
		gc.setFill(getColor());
		gc.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);

		if (getColor() != getOutlineColor()) {
			gc.setStroke(getOutlineColor());
			gc.setLineWidth(3);
			gc.strokeOval(getX()-radius, getY()-radius, radius * 2, radius * 2);
		}
	}

	@Override
	public void setOutline(GraphicsContext gc, Color color) {
		gc.setStroke(color);
		gc.setLineWidth(3);
		gc.strokeOval(getX()-radius, getY()-radius, radius * 2, radius * 2);
	}

	@Override
	public Circle clone() {
		Circle clonedCircle = new Circle(getX(), getY(), getColor(), getShapeType());
		return clonedCircle;
	}
}
