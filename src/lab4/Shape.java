package lab4;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class Shape {
    private double x;
    private double y;
    private Color color;
    private Color outlineColor;
    private int shapeType; //0=Cirkel, 1=Rectangle, 2=Triangle, 3=Line
    private boolean selected = false;

    public Shape(double x, double y, Color color, int shapeType) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.outlineColor = color;
        this.shapeType = shapeType;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract void drawYourself(GraphicsContext gc);

    public int getShapeType() {
        return shapeType;
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }


    public abstract void setOutline(GraphicsContext gc, Color color);

    public void moveShape(KeyEvent event) {
        double deltaX = 0;
        double deltaY = 0;

        // Adjust the movement distance based on your requirements
        double movementSpeed = 20.0;

        if (event.getCode() == KeyCode.RIGHT) {
            deltaX = movementSpeed;
            System.out.println("move to right");
        } else if (event.getCode() == KeyCode.LEFT) {
            deltaX = -movementSpeed;
        } else if (event.getCode() == KeyCode.DOWN) {
            deltaY = movementSpeed;
        } else if (event.getCode() == KeyCode.UP) {
            deltaY = -movementSpeed;
        }


        // Update the shape's position
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    public abstract Shape clone();

    public Color getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }

}
