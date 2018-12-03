
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.*;
public class Login  {

Stage loginStage =new Stage();
	
	Login() {
		
		GridPane grid= new GridPane();
		HBox hb = new HBox();
		Scene mainScene = new Scene(grid,300,300);
		
		Text txt1 = new Text("User Name:");
		Text txt2 = new Text("Password:");
		
		
		Font f = new Font("Calibri",20);
		
		TextField userText = new TextField();
		userText.setPromptText(" User Name");
		PasswordField passText = new PasswordField();
		passText.setPromptText("Password");
		
		Button submitButton = new Button("Submit");
		Button clearButton = new Button("Clear");
		
	grid.setPadding(new Insets(15,15,15,10));
	
	grid.setHgap(10);
	grid.setVgap(10);
	
	
	grid.setGridLinesVisible(false);
		grid.add(txt1, 0, 0);
		grid.add(userText, 1, 0);
		grid.add(txt2, 0, 1);
		grid.add(passText, 1, 1);
		hb.getChildren().add(submitButton);
		hb.getChildren().add(clearButton);
		grid.add(hb, 1, 2);
	
		
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        userText.setText("");
		        passText.setText("");
		        
		    }
		});
		
		loginStage.
		setScene(mainScene);
		loginStage.setTitle("WELCOME");
		loginStage.show();
		
		



	
	String [][]fileRecords=getAccountsFromfile();
	


	submitButton.setOnAction(new EventHandler<ActionEvent>(){
			
			
		  public void handle(ActionEvent b){
			
	for(int i=0;i<fileRecords.length;i++){
	
		if(fileRecords[0][0].equals(userText.getText())&&fileRecords[0][1].equals(passText.getText()))
	{
		
		

		System.out.println("Register");
	}
	}
//WelcomeWindow w=new WelcomeWindow();
	}

	});
}
	
public String [][] getAccountsFromfile(){
	
	try{
		String file ="C:/Users/laila/Desktop/New Text Document (2).txt";
		FileReader Accountfile =new FileReader(file);
		BufferedReader br =new BufferedReader(Accountfile);
		
		
		
		String data[][];
		data=new String [9][];//records
		
	
	
		
		String []row =new String [7];//
		String record="";
		int rowNum=0;
		
		while((record=br.readLine())!=null){
			
			
			row=record.split("\\|");
			data[rowNum]=row;
			rowNum++;
	
		}
	br.close();
	return data;
	}catch(IOException e){
		System.out.println(e);
		return null;
	}
}
}


