package lab4;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class DrawingModel {

    private int shapeType;
    private Color color;
    private SidePanel sidePanel;
    private ShapePanel shapePanel;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public DrawingModel(SidePanel sidePanel, ShapePanel shapePanel) {
        this.sidePanel = sidePanel;
        this.shapePanel = shapePanel;
    }

    public Color getColor() {
        color = sidePanel.getSelectedColor();
        return color;
    }


    public int getShapeType() {
        shapeType = shapePanel.getSelectedShape();
        return shapeType;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void clearShapes() {
        shapes.clear();
    }

    public Shape getShapeSelected(double x, double y) {

        for (int i = shapes.size() - 1; i >= 0; i--) {
            Shape shape = shapes.get(i);

            if (hitBox(shape, x, y)) {
                return shape;
            }
        }

        return null;
    }

    private boolean hitBox(Shape shape, double x, double y) {

        double hitboxSize = 40; // Half of the hitbox size

        // Calculate the bounds of the hitbox
        double minX = shape.getX() - hitboxSize;
        double minY = shape.getY() - hitboxSize;
        double maxX = shape.getX() + hitboxSize;
        double maxY = shape.getY() + hitboxSize;

        // Check if the point (x, y) is within the hitbox bounds
        if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
            return true;
        }

        return false;
    }
}
