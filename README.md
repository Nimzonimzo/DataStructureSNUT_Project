# Drawing Program

School project aimed at creating an interactive drawing program with @oliviabrofors & @Turizten

## Overview
This program provides a graphical interface for drawing and manipulating various geometric shapes. It includes features such as selection, movement, copy-paste, color change, and the ability to reorder shapes backward and forward.

## Features
1. **Interactive Drawing:** Ability to create and manipulate circles, rectangles, triangles, and lines.
2. **Selection and Movement:** Selection of created shapes and movement on the canvas.
3. **Copy/Paste:** Copying a selected shape and pasting it to a new location.
4. **Color Change:** Choosing the color to draw the shapes.
5. **Reordering Shapes:** Move selected shapes backward or forward in the drawing order.

## Project Structure
- `Main.java`: Main class of the program, launches the application.
- `DrawingModel.java`: Manages the drawing model, shapes, and their manipulations.
- `DrawingPanel.java`: Graphic interface of the drawing canvas and event handling.
- `Shape.java`: Abstract class to represent geometric shapes.
- `Circle.java`, `Rectangle.java`, `Triangle.java`, `Line.java`: Classes derived from `Shape` for each type of shape.
- `SidePanel.java`: Side panel for color selection.
- `ColorButton.java`: Color selection button.
- `ShapePanel.java`: Side panel for shape selection.
- `ShapeButton.java`: Shape selection button.

## Technologies Used
- Java
- JavaFX
- IntelliJ IDEA
