package lab4;

import java.awt.MouseInfo;
import java.awt.Point;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DrawingPanel extends Pane {

	private DrawingModel model;
	private Canvas canvas;
	private Shape selectedShape = null;
	private Shape copiedShape = null;

	public DrawingPanel(DrawingModel model) {
		this.model = model;
		this.canvas = new Canvas(1300, 900); //500, 500
		getChildren().add(canvas);

		canvas.setFocusTraversable(true);

		canvas.setOnKeyPressed(event -> {
			Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
			double mouseX = mouseLocation.getX();
			double mouseY = mouseLocation.getY();

			Point2D canvasMouseLocation = canvas.sceneToLocal(mouseX, mouseY);
			System.out.println(canvasMouseLocation);

			if (selectedShape != null) {
				selectedShape.moveShape(event);
				redrawCanvas();

				if (event.getCode() == KeyCode.C) {
					copiedShape = selectedShape.clone();
					System.out.println("Copied!");
				}

				if (event.getCode() == KeyCode.V) {
					if (copiedShape != null) {
						Shape newShape = copiedShape.clone();
						newShape.setX(canvasMouseLocation.getX());
						newShape.setY(canvasMouseLocation.getY());
						model.addShape(newShape);
						redrawCanvas();
						System.out.println("Pasted!");
					}
				}

				if (event.getCode() == KeyCode.F) {
					// Move the selected shape forwards in the shapes list
					moveShapeForwards();
				}

				if (event.getCode() == KeyCode.B) {
					// Move the selected shape backwards in the shapes list
					moveShapeBackwards();
				}

			}
		});

		canvas.setOnMouseClicked(event -> {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

			for (Shape shape : model.getShapes()) {
				shape.drawYourself(gc);
			}

			if (event.getButton() == MouseButton.PRIMARY) {
				if (selectedShape != null) {
					selectedShape.setOutlineColor(model.getColor());
					selectedShape = null;
					redrawCanvas();
				} else {
					generateShape(event.getX(), event.getY());
				}

			} else if (event.getButton() == MouseButton.SECONDARY) {
				selectShape(event.getX(), event.getY());
			}
		});

		Button clearButton = new Button("Clear");
		clearButton.setOnAction(event -> {
			model.clearShapes();
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});

		HBox buttonBox = new HBox(clearButton);
		buttonBox.setTranslateY(900 - 30);
		getChildren().add(buttonBox);

		Text hiText = new Text("Welcome to our Drawing program! | Right click to Select | Press C/V to Copy/Paste | Press F/B to move shape Forwards/Backwards");
		hiText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hiText.setFill(Color.BLACK);
		hiText.setTranslateX(10);
		hiText.setTranslateY(30);
		getChildren().add(hiText);

	}

	private void redrawCanvas() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for (Shape shape : model.getShapes()) {
			shape.drawYourself(gc);
		}

		if (selectedShape != null) {
			selectedShape.setOutline(gc, Color.BLACK);
		}
	}

	private void selectShape(double x, double y) {
		GraphicsContext gc = canvas.getGraphicsContext2D();

		if (selectedShape != null) {
			selectedShape.setOutline(gc, selectedShape.getColor());
		}

		selectedShape = model.getShapeSelected(x, y);

		if (selectedShape != null) {
			Color myColor = Color.BLACK;
			selectedShape.setOutline(gc, myColor);
		}
	}

	public void generateShape(double x, double y) {
		if (model.getShapeType() == 0) {
			Shape shape = new Circle(x, y, model.getColor(), model.getShapeType());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			model.addShape(shape);
			shape.drawYourself(gc);
		} else if (model.getShapeType() == 1) {
			Shape shape = new Rectangle(x, y, model.getColor(), model.getShapeType());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			model.addShape(shape);
			shape.drawYourself(gc);
		} else if (model.getShapeType() == 2) {
			Shape shape = new Triangle(x, y, model.getColor(), model.getShapeType());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			model.addShape(shape);
			shape.drawYourself(gc);
		} else if (model.getShapeType() == 3) {
			Shape shape = new Line(x, y, model.getColor(), model.getShapeType());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			model.addShape(shape);
			shape.drawYourself(gc);
		}
	}

	private void moveShapeForwards() {
		if (selectedShape != null) {
			int index = model.getShapes().indexOf(selectedShape);
			if (index < model.getShapes().size() - 1) {
				// Swap the selected shape with the shape after it
				Shape temp = model.getShapes().get(index + 1);
				model.getShapes().set(index + 1, selectedShape);
				model.getShapes().set(index, temp);

				// Redraw the canvas
				redrawCanvas();
			}
		}
	}

	private void moveShapeBackwards() {
		if (selectedShape != null) {
			int index = model.getShapes().indexOf(selectedShape);
			if (index > 0) {
				// Swap the selected shape with the shape before it
				Shape temp = model.getShapes().get(index - 1);
				model.getShapes().set(index - 1, selectedShape);
				model.getShapes().set(index, temp);

				// Redraw the canvas
				redrawCanvas();
			}
		}
	}


}
