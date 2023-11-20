package lab4;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    private static final double SIZE = 40.0;
    private double[] xPoints;
    private double[] yPoints;

    public Triangle(double x, double y, Color color, int shapeType) {
        super(x, y, color, 2);
        initializePoints();
    }

    private void initializePoints() {
        xPoints = new double[]{getX() - SIZE, getX(), getX() + SIZE};
        yPoints = new double[]{getY() + SIZE, getY() - SIZE, getY() + SIZE};
    }

    @Override
    public void drawYourself(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillPolygon(xPoints, yPoints, 3);
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
