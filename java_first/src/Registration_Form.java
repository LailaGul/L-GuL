
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;

public class Registration_Form extends Application{
	
	String record;
	String a;
	
	public void start(Stage Stage){
		
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(20);
		
		root.setPadding(new Insets(10,10,10,10));
		Scene scene = new Scene(root,500,500);
		
		root.setAlignment(Pos.CENTER);
		
		Text textName = new Text("NAME");
		Text textPassword = new Text("Password");
		Text textEmail = new Text("Email");
		Text textGender = new Text("Gender");
		Text textDepartment = new Text("Department");
		Text textTerms = new Text("Terms and Conditions");

		TextField textFieldName = new TextField();
		textFieldName.setPromptText("Enter Name");
		PasswordField passFieldName = new PasswordField();
		passFieldName.setPromptText("Enter Paswword");
		TextField textFieldEmail = new TextField();
		textFieldEmail.setPromptText("Enter Email");
		
		RadioButton rb1 = new RadioButton();
		rb1.setText("MALE");
		RadioButton rb2 = new RadioButton();
		rb2.setText("FEMALE");

		ToggleGroup tg = new ToggleGroup();
		
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		
		Button btn=new Button("Register");
		Label lbl=new Label();
		
		ChoiceBox<String> dep = new ChoiceBox<String>(FXCollections.observableArrayList("MBA","SE","BBA","MEDIA SCIENCE"));
		
		CheckBox cb = new CheckBox("ACCEPT TERMS ");
		
		root.add(textName, 0, 0);
		root.add(textFieldName, 1, 0);
		root.add(textPassword, 0, 1);
		root.add(passFieldName, 1, 1);
		root.add(textEmail, 0, 2);
		root.add(textFieldEmail, 1, 2);
		root.add(textGender, 0, 3);
		root.add(btn,1, 7);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(rb1,rb2);
		root.add(hb, 1, 3);
		root.add(textDepartment, 0, 4);
		root.add(dep, 1,4 );
		root.add(textTerms, 0, 5);
		root.add(cb, 1, 5);
		root.add(lbl, 1, 10);

		
		Stage.setScene(scene);
		Stage.show();
		

		
		 btn.setOnAction(new EventHandler<ActionEvent>(){
				
				
			  public void handle(ActionEvent b){
				
				  
				  
				  
				  if(rb1.isSelected()){
					  
					  a="MALE";
					  
				  }
				  else
				  {
					  a="FEMALE";
				  }
		record=textFieldName.getText()+"|"+passFieldName.getText()+"|"+textFieldEmail.getText()+"|"+a+"|"+dep.getValue()+"\n";
	
		if(textFieldName.getText().equals("")||passFieldName.getText().equals("")||textFieldEmail.getText().equals("")||a==null||dep.getValue().equals(null))
		
		{
       lbl.setText("Invalid Input");
		}
		
		else{
		if(adddataToFile(record)){
			
			Alert alert =new Alert(Alert.AlertType.INFORMATION);

	  		alert.setTitle("Account Status");
	  		alert.setHeaderText(null);
	  		alert.setContentText(record);
	  		alert.showAndWait();
		}
	else 
	{
				
				Alert alert =new Alert(Alert.AlertType.ERROR);

		  		alert.setTitle("Account Status");
		  		alert.setHeaderText(null);
		  		alert.setContentText("Account Not Created");
		  		alert.showAndWait();
	}
				
	  		
	
		  Login l=new Login();
		 ((Stage)btn.getScene().getWindow()).close();

			  }
			  }
		});
	
	

	}

	public static void main(String[] args) {



		launch(args);
	}


public boolean adddataToFile(String record){
	
	String csvFile="C:/Users/laila/Desktop/New Text Document (2).txt";
	try{
		
		FileWriter fw=new FileWriter (csvFile,true);
		fw.write(record);
	
		fw.close();
		
	}catch(IOException e){
		e.printStackTrace();
		return false;
		
	}
	return true;

}
}
