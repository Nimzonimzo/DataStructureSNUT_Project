package lab4;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ColorButton extends StackPane {
	private Circle circle;
	private boolean selected;
	private Color color;

	public ColorButton(Color color, boolean selec, SidePanel sidePanel) {
		this.color = color;
		this.selected = selec;

		setPadding(new Insets(4));

		// STARTING COLOR GETS MARKED
		if (this.selected == true) {
			setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		} else {
			setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
		}

		setOnMouseClicked(event -> {
			this.selected = true;
			sidePanel.updateColorButtons(this);
			updateBackground();
		});

		circle = new Circle(15, color);
		getChildren().add(circle);
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		updateBackground();
	}

	public Color getColor() {
		return color;
	}

	private void updateBackground() {

		if (selected) {
			setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
		} else {
			setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
		}
	}
}
