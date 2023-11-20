package lab4;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SidePanel extends VBox {
    private ArrayList<ColorButton> colorButtons;

    public SidePanel() {
        setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        colorButtons = new ArrayList<>();
        colorButtons.add(new ColorButton(Color.BROWN, true, this));
        colorButtons.add(new ColorButton(Color.RED, false, this));
        colorButtons.add(new ColorButton(Color.GREEN, false, this));
        colorButtons.add(new ColorButton(Color.BLUE, false, this));
        colorButtons.add(new ColorButton(Color.YELLOW, false, this));
        colorButtons.add(new ColorButton(Color.ORANGE, false, this));
        colorButtons.add(new ColorButton(Color.PURPLE, false, this));
        colorButtons.add(new ColorButton(Color.GRAY, false, this));
        colorButtons.add(new ColorButton(Color.INDIGO, false, this));
        colorButtons.add(new ColorButton(Color.VIOLET, false, this));

        getChildren().addAll(colorButtons);
    }

    public Color getSelectedColor() {
        for (ColorButton button : colorButtons) {
            if (button.isSelected()) {
                return button.getColor();
            }
        }
        return Color.BLACK;
    }

    public ArrayList<ColorButton> getColorButtons() {
        return colorButtons;
    }

    public void updateColorButtons(ColorButton selectedButton) {
        for (ColorButton button : colorButtons) {
            button.setSelected(button == selectedButton);
        }
    }
}
