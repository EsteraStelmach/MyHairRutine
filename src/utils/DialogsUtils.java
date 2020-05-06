package utils;

import Controllers.LoginWindowController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    private static ResourceBundle bundle = ResourceBundle.getBundle("Bundles.messages");


    public static void userLoginOrPasswordIsNotCorrect(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("loginWindow.incorrectLoginOrPassword.title"));
        informationAlert.setHeaderText(bundle.getString("loginWindow.incorrectLoginOrPassword.message"));
        informationAlert.show();

    }

    public static Optional<ButtonType> exitApplication(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(bundle.getString("loginWindow.exit.title"));
        confirmationAlert.setHeaderText(bundle.getString("loginWindow.exit.message"));
        Optional<ButtonType> result  = confirmationAlert.showAndWait();
        return result;
    }

    public static void registerPasswordAreNotTheSame(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("registerWindow.incorrectPasswords.title"));
        informationAlert.setHeaderText(null);
        informationAlert.setContentText(bundle.getString("registerWindow.incorrectPasswords.message"));
        informationAlert.show();

    }

    public static void thisLoginAlreadyExistsAlert(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("registerWindow.thisLoginAlreadyExists.title"));
        informationAlert.setHeaderText(null);
        informationAlert.setContentText(bundle.getString("registerWindow.thisLoginAlreadyExists.message"));
        informationAlert.show();
    }

    public static void logOutAlert(){
        Alert confirmationAlert = new Alert((Alert.AlertType.CONFIRMATION));
        confirmationAlert.setTitle(bundle.getString("mainApplicationWidow.logOut.title"));
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText(bundle.getString("mainApplicationWidow.logOut.content"));

        ButtonType button1 = new ButtonType(bundle.getString("mainApplicationWidow.logOut.button1"));
        ButtonType button2 = new ButtonType(bundle.getString("mainApplicationWidow.logOut.button2"));
        ButtonType button3 = new ButtonType(bundle.getString("mainApplicationWidow.logOut.button3"));

        confirmationAlert.getButtonTypes().setAll(button1,button2,button3);
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        Stage stage = LoginWindowController.getWindow();

        if(result.get() == button2){
            LoginWindowController loginWindow = new LoginWindowController();
            stage.setScene(loginWindow.setLoginWindowScene());
            stage.show();
        }else if(result.get() == button3){
            stage.close();
        }
    }

    public static void errorDialogLoadingFXMLFiles(Exception error){
        Alert errorAlert = new Alert (Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.FXMLLoader.title"));
        errorAlert.setHeaderText(error.getMessage());
        

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);

        TextArea textArea = new TextArea(sw.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxHeight(Double.MAX_VALUE);
        textArea.setMaxWidth(Double.MAX_VALUE);

        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane.setVgrow(textArea,Priority.ALWAYS);

        GridPane root = new GridPane();
        root.setMaxWidth(Double.MAX_VALUE);
        root.add(textArea, 0,1);

        errorAlert.getDialogPane().setContent(root);
        errorAlert.show();

    }

    public static void errorDialogConnectingToDataBase(Exception error){
        Alert errorAlert = new Alert (Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.connectToDataBase.title"));
        errorAlert.setHeaderText(error.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        error.printStackTrace(pw);

        TextArea textArea = new TextArea(sw.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxHeight(Double.MAX_VALUE);
        textArea.setMaxWidth(Double.MAX_VALUE);

        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane.setVgrow(textArea,Priority.ALWAYS);

        GridPane root = new GridPane();
        root.setMaxWidth(Double.MAX_VALUE);
        root.add(textArea, 0,1);

        errorAlert.getDialogPane().setContent(root);
        errorAlert.show();

    }



















}
