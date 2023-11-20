package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {

    private int width = 160;
    private int height = 6;

    public Line(double x, double y, Color color, int shapeType) {
        super(x, y, color, shapeType);
    }

    @Override
    public void drawYourself(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getX() - width / 2, getY() - height / 2, width, height);
    }

    @Override
    public void setOutline(GraphicsContext gc, Color color) {
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeRect(getX() - width / 2, getY() - height / 2, width, height);
    }

    @Override
    public Line clone() {
        Line clonedLine = new Line(getX(), getY(), getColor(), getShapeType());
        return clonedLine;
    }
}
