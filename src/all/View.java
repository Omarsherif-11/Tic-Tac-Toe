package all;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class View extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		GridPane root = new GridPane();
		root.setPrefSize(800,800);
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Button s = new Button();
				final int x = i;
				final int y = j;
				s.setPrefSize(800/3, 800/3);
				s.setStyle("-fx-border-color: white; -fx-background-color: Black;");
				s.setOnMouseEntered(e -> {
					s.setStyle("-fx-border-color: white; -fx-background-color: Gray;");
				});
				s.setOnMouseExited(e -> {
					s.setStyle("-fx-border-color: white; -fx-background-color: Black;");
				});
				s.setOnMouseClicked(e -> {
					ImageView v = new ImageView(Game.Inturn+".png");
					v.setFitWidth(800/3 - 20);
					Game.board[x][y] = Game.Inturn;
					v.setFitHeight(800/3 - 20);
					s.setAlignment(Pos.CENTER);
					s.setGraphic(v);
					Game.change();
					Font font = Font.font("Tahoma", FontWeight.BOLD, 28);
					if(Game.checkDraw()) {
						for(int k = 0;k < 3;k++) {
							for(int l = 0;l<3;l++) {
								Game.board[k][l] = null;
							}
						}
						for(int k = 0;k < 9;k++) {
							((Button)root.getChildren().get(k)).setGraphic(null);
						}
					}
					if(Game.checkWin("x")) {
						Popup pop = new Popup();
						Label l = new Label("             X has Won !             ");
						l.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(60), null)));
						pop.getContent().add(l);
						l.setTextFill(Color.WHITE);
						l.setPrefHeight(800 / 6);
						l.setPrefWidth(800/2);
						l.setFont(font);
						l.setCenterShape(true);
						for(int k = 0;k < 9;k++) {
						root.getChildren().get(k).setOnMouseClicked(null);
						}
						pop.show(stage);
					}
					if(Game.checkWin("o")) {
						Popup pop = new Popup();
						Label l = new Label("             O has Won !             ");
						l.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(60), null)));
						pop.getContent().add(l);
						l.setTextFill(Color.WHITE);
						l.setPrefHeight(800 / 6);
						l.setPrefWidth(800/2);
						l.setFont(font);
						l.setCenterShape(true);
						pop.show(stage);
						for(int k = 0;k < 9;k++) {
							root.getChildren().get(k).setOnMouseClicked(null);
							}
					}
				});
				root.add(s, j, i);
			}
		}
		root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
   public static void main(String[] args) {
	   Game.Start();
	try {
		launch(args);
	}catch(Exception e) {
		
	}
   }
}
