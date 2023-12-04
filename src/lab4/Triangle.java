package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    private double size = 40.0;
    private double[] xPoints;
    private double[] yPoints;

    public Triangle(double x, double y, Color color, int shapeType) {
        super(x, y, color, 2);
    }

    @Override
    public void drawYourself(GraphicsContext gc) {
        gc.setFill(getColor());

        xPoints = new double[]{getX() - size, getX(), getX() + size};
        yPoints = new double[]{getY() + size, getY() - size, getY() + size};
        gc.fillPolygon(xPoints, yPoints, 3);

        if (getColor() != getOutlineColor()) {
            gc.setStroke(getOutlineColor());
            gc.setLineWidth(3);
            gc.strokePolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public void setOutline(GraphicsContext gc, Color color) {
        gc.setStroke(color);
        gc.setLineWidth(3);
        gc.strokePolygon(xPoints, yPoints, 3);


    }

    @Override
    public Triangle clone() {
        Triangle clonedTriangle = new Triangle(getX(), getY(), getColor(), getShapeType());
        return clonedTriangle;
    }
}
