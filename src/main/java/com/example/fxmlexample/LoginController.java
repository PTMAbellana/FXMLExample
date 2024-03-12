package com.example.fxmlexample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LoginController {
    
    public AnchorPane pnMain;

    public PasswordField txtPassword;
    public TextField txtUsername;
    public Text lblResult;
    
    public GridPane pnLogin;
    public AnchorPane pnLogout;
    public VBox pnHome;

    @FXML private Text actiontarget;
    UserList userlist = new UserList();
    @FXML protected void onSigninClick() throws Exception {
        Parent next = FXMLLoader.load(Login.class.getResource("home-view.fxml"));
        boolean found = false;
        for(User u : userlist.users){

            if(u.name.equals(txtUsername.getText())){
                if(u.password.equals(txtPassword.getText())){
                    lblResult.setText("LOGIN SUCCESSFUL");
                    found = true;
                }
            }
        }
        if(!found){
            lblResult.setText("Invalid Credentials");
        }else{
            AnchorPane p = (AnchorPane) pnLogin.getParent();
            p.getChildren().remove(pnLogin);
            p.getChildren().add(next);
        }

//        pnMain.getScene().getStylesheets().clear();
//        pnMain.getScene().getStylesheets().add(getClass().getResource("hello.css").toExternalForm());

    }
    @FXML protected void onLogout() throws Exception {
        Parent root = FXMLLoader.load(Login.class.getResource("login-view.fxml"));
        BufferedWriter bw;
        try{
            bw = new BufferedWriter(new FileWriter(getClass().getResource("user.css").getPath()));
           // bw.write(".root { -fx-background-image: url(\"bg.jpg\");}");
            bw.write(".Vbox { -fx-background-color: green");
            bw.newLine();
           bw.write(".button { -fx-background-color: #00bfff" );
           bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        AnchorPane p = (AnchorPane) pnHome.getParent();
        p.getChildren().remove(pnHome);
        p.getChildren().add(root);


//        pnMain.getScene().getStylesheets().clear();
//        pnMain.getScene().getStylesheets().add(getClass().getResource("hello.css").toExternalForm());

    }


}
