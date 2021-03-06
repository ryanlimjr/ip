package ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;
    private String bitDialogColour = "#AEC6CF";

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        this.autosize();
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        HBox innerHBox = (HBox) tmp.get(0);
        ObservableList<Node> innerHBoxChildren = FXCollections.observableArrayList(innerHBox.getChildren());
        Collections.reverse(innerHBoxChildren);
        innerHBox.setAlignment(Pos.CENTER_LEFT);
        innerHBox.getChildren().setAll(innerHBoxChildren);
        setAlignment(Pos.TOP_LEFT);
        getChildren().setAll(tmp);
    }

    /**
     * sets the background colour for the duke bot dialog box
     */
    private void setBackgroundColour() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        HBox innerHBox = (HBox) tmp.get(0);
        String style = innerHBox.getStyle();
        innerHBox.setStyle("-fx-background-color: " + this.bitDialogColour + ";"
                + "-fx-background-radius: 50;");
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        db.setBackgroundColour();
        return db;
    }
}