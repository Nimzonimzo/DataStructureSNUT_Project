package lab4;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ShapePanel extends VBox {
    private ArrayList<ShapeButton> shapeButtons;

    public ShapePanel() {
        setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        shapeButtons = new ArrayList<>();
        shapeButtons.add(new ShapeButton(0, true, this));
        shapeButtons.add(new ShapeButton(1, false, this));
        shapeButtons.add(new ShapeButton(2, false, this));
        shapeButtons.add(new ShapeButton(3, false, this));

        getChildren().addAll(shapeButtons);
    }

    public Region getCanvas() {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<ShapeButton> getShapeButtons() {
        return shapeButtons;
    }

    public void updateShapeButtons(ShapeButton selectedButton) {
        for (ShapeButton button : shapeButtons) {
            button.setSelected(button == selectedButton);
        }
    }

    public int getSelectedShape() {
        for (ShapeButton button : shapeButtons) {
            if (button.isSelected()) {
                return button.getCurrentShape();
            }
        }
        return 0;
    }
}
