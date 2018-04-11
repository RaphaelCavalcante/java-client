package br.com.raphael.javaclient.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.raphael.javaclient.model.EmployeeComplete;
import br.com.raphael.javaclient.service.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@Component
public class FXFXMLController {
	private RestTemplate restTemp = new RestTemplate();
	@Autowired
	private EmployeeService empService;
	@FXML
	private ChoiceBox<String> filters;
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
	private TableView<EmployeeComplete> completeEmployeeList;

	@FXML
	private TableColumn<EmployeeComplete, Long> empId;
	@FXML
	private TableColumn<EmployeeComplete, String> empName;
	@FXML
	private TableColumn<EmployeeComplete, String> empEmail;
	@FXML
	private TableColumn<EmployeeComplete, String> empPhone;
	@FXML
	private TableColumn<EmployeeComplete, String> empCompany;
	@FXML
	private TableColumn<EmployeeComplete, String> empDepartment;
	@FXML
	private TableColumn<EmployeeComplete, String> empPosition;
	
	public FXFXMLController() {

	}

	@FXML
	private void initialize() {
		this.filters.getItems().addAll("Nome", "Email", "Telefone", "Empresa", "Setor", "Cargo");
		
		EmployeeComplete[] employees = this.restTemp
				.getForObject("http://localhost:8000/api/employee/findAll", EmployeeComplete[].class);
		
//		empId.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, Long>("employee_id"));
//		empName.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, String>("employee_name"));
//		empPhone.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, String>("employee_phone"));
//		empCompany.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, String>("employee_company"));
//		empDepartment.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, String>("employee_department"));
//		empPosition.setCellValueFactory(new PropertyValueFactory<EmployeeComplete, String>("employee_position"));
		
		if (employees.length > 0) {
			Set<EmployeeComplete> employeeList = new HashSet<>();
			for(EmployeeComplete complete: employees) {
				employeeList.add(complete);
			}
			this.completeEmployeeList.getItems().setAll(employeeList);
		}

	}
	
	@FXML
	private void addPerson(ActionEvent event) {

	}

	@FXML
	private void addNew(ActionEvent ae) {
		Parent para;

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getClassLoader().getResource("AddEmployeelayout.fxml"));
			loader.setController(new EmployeeController());
			para = loader.load();
			Scene addEmployeeScene = new Scene(para, 645, 547);
			Parent source = ((Node) ae.getSource()).getParent();
			Stage mainStage = (Stage) source.getScene().getWindow();
			mainStage.setScene(addEmployeeScene);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Platform.runLater(()->{
		// });
		// List<EmployeeComplete> complete = this.empService.getAllComplete();
		// Platform.runLater(()->{
		// System.out.println(complete);
		// });
	}
}
