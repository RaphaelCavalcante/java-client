package br.com.raphael.javaclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class FXFXMLController {
	@FXML
	private ChoiceBox box;
	@FXML
	private Button btn_add;
	@FXML
	private TextField filter;
	@FXML
	private Button viewButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	
	public FXFXMLController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void addNew() {
		System.out.println("TESTE");
	}
}
