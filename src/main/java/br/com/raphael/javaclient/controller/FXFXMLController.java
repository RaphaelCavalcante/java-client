package br.com.raphael.javaclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.raphael.javaclient.model.EmployeeComplete;
import br.com.raphael.javaclient.service.EmployeeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXFXMLController {

	@Autowired
	private EmployeeService empService;

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

	@FXML
	private TableView table;

	@FXML
	private TextField employeeName;
	@FXML
	private TextField employeeEmail;
	@FXML
	private TextField employeePhone;
	@FXML
	private TextField companyName;
	@FXML
	private TextField departmentName;
	@FXML
	private TextField positionsName;

	public FXFXMLController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void addPerson(ActionEvent event) {
		ObservableList<EmployeeComplete> data = this.table.getItems();

		List<EmployeeComplete> complete = this.empService.getAllComplete();
		complete.forEach(comp -> {
			data.add(comp);
		});
	}

	@FXML
	private void addNew() {
		System.out.println("TESTE");
	}
}
