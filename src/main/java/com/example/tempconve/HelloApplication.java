package com.example.tempconve;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Text tempLbl=new Text("Enter temperature");
        Text resLbl=new Text("Result");
        Text convLbl=new Text("Convert to");

        TextField tempTf=new TextField();
        TextField resTf=new TextField();

        CheckBox farBox=new CheckBox("Fahrenheit");
        CheckBox centBox=new CheckBox("Centigrade");

        HBox hbox=new HBox();
        hbox.setSpacing(30);
        hbox.setPadding(new Insets(0,0,0,0));
        hbox.getChildren().addAll(farBox,centBox);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800,400);
        gridPane.setVgap(20);
        gridPane.setHgap(40);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(tempLbl,1,1);
        gridPane.add(resLbl,3,1);
        gridPane.add(convLbl,1,3);

        gridPane.add(tempTf,2,1);
        gridPane.add(resTf,4,1);

        gridPane.add(hbox,2,3,2,1);

        //To Fahrenheit checkbox
        farBox.setOnAction((new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (tempTf.getText()==null || tempTf.getText().trim().isEmpty()) {
                    resTf.setText("Incorrect inputs");
                   }

                else {
                    double res_num=Double.parseDouble(tempTf.getText());
                    double ans=(res_num*1.8)+32;
                    resTf.setText(Double.toString(ans));}
            }
                }));

                //To Centigrade checkbox
                centBox.setOnAction((new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if((tempTf.getText()==null || tempTf.getText().trim().isEmpty())) {
                            resTf.setText("Incorrect inputs");
                        }
                        else {
                        double res_num=Double.parseDouble(tempTf.getText());
                        double ans=(res_num-32)*5/9;
                        resTf.setText(Double.toString(ans));
                        }
                    }
                }));


                //ensures decimal values only are accepted
                tempTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                        String in = tempTf.getText();
                        if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                            tempTf.setText("");
                        }
                    }
                }));

                // to ensure only one checkbox is selected ??


                Scene scene = new Scene(gridPane);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
            }

    public static void main(String[] args) {
        launch();
    }
}