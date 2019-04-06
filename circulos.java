package application;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class circulos extends Application {
	private static int size = 20;
	private static int radMin = 15;
	private static int radMax = 35;
	private static int xMin = 40;
	private static int xMax = 800;
	private static int yMin = 50;
	private static int yMax = 600;

	public void start(Stage primary) {
		Circle[] cir = new Circle[size];
		Random ran = new Random();

		for (int i = 0; i < size; i++) {
			cir[i] = new Circle();
			cir[i].setRadius(radMin + (radMax - radMin) * ran.nextDouble());
			cir[i].setCenterX(xMin + (xMax - yMin) * ran.nextDouble());
			cir[i].setCenterY(yMin + (yMax - yMin) * ran.nextDouble());
			cir[i].setFill(Color.BLACK);
			overlap(cir, i);
		}

		Group root = new Group(cir);
		Scene scene = new Scene(root, 900, 800);
		primary.setScene(scene);
		primary.setTitle("Circulos");
		primary.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void overlap(Circle[] c, int lugar) {
		double distance = 0;
		double rad = 0;
		for (int i = lugar - 1; i >= 0; i--) {
			distance = Math.sqrt(Math.pow(c[i].getCenterX() - c[lugar].getCenterX(), 2)
					+ Math.pow(c[i].getCenterY() - c[lugar].getCenterY(), 2));
			rad = c[lugar].getRadius() + c[i].getRadius();
			if (distance < rad) {
				c[lugar].setFill(Color.rgb(0, 0, 180, 0.3));
				c[i].setFill(Color.rgb(0, 0, 180, 0.3));
			}
		}
	}
}
