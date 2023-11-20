package lab4;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

public class ShapeButton extends StackPane {
	private int shape;
	private boolean selected;
	private Circle circle;
	private Rectangle rectangle;
	private Polygon triangle;

	public ShapeButton(int shape, boolean selected, ShapePanel shapePanel) {
		this.shape = shape;
		this.selected = selected;

		setPadding(new Insets(8));

		// Making it so that a shape is selected in the beginning
		updateBackground();

		setOnMouseClicked(event -> {
			selected = true;
			shapePanel.updateShapeButtons(this);
			updateBackground();
		});

		// Here the shapes on the shape panel are drawn out
		if (shape == 0) {
			circle = new Circle(15, Color.BLACK);
			getChildren().add(circle);
		} else if (shape == 1) {
			rectangle = new Rectangle(40, 20, Color.BLACK);
			getChildren().add(rectangle);
		} else if (shape == 2) {
			triangle = new Polygon();
			triangle.getPoints().addAll(
					25.0, 5.0,   // x1, y1
					5.0, 45.0,   // x2, y2
					45.0, 45.0   // x3, y3
			);
			getChildren().add(triangle);
		} else if (shape == 3) {
			rectangle = new Rectangle(40, 3, Color.BLACK);
			getChildren().add(rectangle);
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		updateBackground();
	}

	public int getCurrentShape() {
		return shape;
	}

	private void updateBackground() {
		if (selected) {
			setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		} else {
			setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
		}
	}
}
