/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package amedia;
import javafx.application.Application;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Nidhee Makwana
 */
public class FXMLDocumentController extends Application implements Initializable {
   
//    Parent root = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));

//   stage=new Stage();
//    stage.initModality(Modality.APPLICATION MODAL);

   private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;


    private String filePath;


    @FXML
    public void handleButtonAction(ActionEvent event) {
       FileChooser fileChooser = new FileChooser();
       FileChooser.ExtensionFilter filter =new FileChooser.ExtensionFilter("Select a Flie (*.mp4)", "*.mp4");
       fileChooser.getExtensionFilters().add(filter);
       File file = fileChooser.showOpenDialog(null);
       filePath=file.toURI().toString();
       if (filePath!=null)
       {
           Media media= new Media(filePath);
           mediaPlayer =new MediaPlayer(media);
           mediaView.setMediaPlayer(mediaPlayer);
           DoubleProperty width = mediaView.fitWidthProperty();
           DoubleProperty hight = mediaView.fitHeightProperty();

           width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
           hight.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));

           mediaPlayer.play();
       }

       }
    @FXML
    private void pauseVideo(ActionEvent event){
        mediaPlayer.pause();

    }
     @FXML
    private void playVideo(ActionEvent event){
        mediaPlayer.play();
        mediaPlayer.setRate(1);

    }
     @FXML
    private void stopVideo(ActionEvent event){
        mediaPlayer.stop();

    }
     @FXML
    private void fastVideo(ActionEvent event){
        mediaPlayer.setRate(1.5);
    }
     @FXML
    private void fasterVideo(ActionEvent event){
      mediaPlayer.setRate(2);
    }
     @FXML
    private void slowVideo(ActionEvent event){
      mediaPlayer.setRate(.75);
    }
     @FXML
    private void slowerVideo(ActionEvent event){
        mediaPlayer.setRate(.5);
    }
     @FXML
    private void exitVideo(ActionEvent event){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



public static void main(String[] args){
  launch(args);

}

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
}