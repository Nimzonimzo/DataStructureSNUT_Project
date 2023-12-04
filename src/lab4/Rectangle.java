package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    private int width = 80;
    private int height = 40;

    public Rectangle(double x, double y, Color color, int shapeType) {
        super(x, y, color, 1);
    }

    @Override
    public void drawYourself(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getX() - width / 2, getY() - height / 2, width, height);

        if (getColor() != getOutlineColor()) {
            gc.setStroke(getOutlineColor());
            gc.setLineWidth(3);
            gc.strokeRect(getX()-width / 2, getY()-height / 2, width, height);
        }
    }

    @Override
    public void setOutline(GraphicsContext gc, Color color) {
        gc.setStroke(color);
        gc.setLineWidth(3);
        gc.strokeRect(getX()-width / 2, getY()-height / 2, width, height);
    }

    @Override
    public Rectangle clone() {
        Rectangle clonedRectangle = new Rectangle(getX(), getY(), getColor(), getShapeType());
        return clonedRectangle;
    }
}
