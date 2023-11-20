package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;

    public Rectangle(double x, double y, Color color, int shapeType) {
        super(x, y, color, shapeType);
    }

    @Override
    public void drawYourself(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getX() - WIDTH / 2, getY() - HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public void setOutline(GraphicsContext gc, Color color) {
        gc.setStroke(color);
        gc.setLineWidth(3);
        gc.strokeRect(getX() - WIDTH / 2, getY() - HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public Rectangle clone() {
        Rectangle clonedRectangle = new Rectangle(getX(), getY(), getColor(), getShapeType());
        return clonedRectangle;
    }
}
