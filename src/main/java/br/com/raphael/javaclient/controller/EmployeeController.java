package br.com.raphael.javaclient.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.raphael.javaclient.model.Company;
import br.com.raphael.javaclient.model.Department;
import br.com.raphael.javaclient.model.Employee;
import br.com.raphael.javaclient.model.Position;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class EmployeeController {
	private RestTemplate restTemp = new RestTemplate();
	private Employee newEmployee;
	@FXML
	private TextField employeeName;

	@FXML
	private TextField employeeEmail;

	@FXML
	private TextField employeePhoneNum;

	@FXML
	private ComboBox<String> company;

	@FXML
	private ComboBox<String> department;

	@FXML
	private ComboBox<String> position;

	@FXML
	private Button submit;

	@FXML
	private Button cancel;

	private boolean hasPositionId = false;

	public EmployeeController() {

		// this.companyService = new
		// CompanyService("http://localhost:8000/api/company");

	}

	@FXML
	private void initialize() {
		// System.out.println(this.companyService.getAllCompany());
		this.newEmployee = new Employee();

		Company[] compList = restTemp.getForObject("http://localhost:8000/api/company", Company[].class);

		for (int i = 0; i < compList.length; i++) {
			this.company.getItems().add(compList[i].getName());
		}
		this.company.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Company compItem = compList[newValue.intValue()];
				Department[] depList = restTemp.getForObject(
						"http://localhost:8000/api/company/" + compItem.getId() + "/departments", Department[].class);
				department.getItems().clear();
				setDepartmentList(depList);
			}

		});
	}

	private void setDepartmentList(Department[] depList) {
		for (Department dep : depList) {
			this.department.getItems().add(dep.getName());
		}
		this.department.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Department depItem = depList[newValue.intValue()];
				Position[] positionList = restTemp.getForObject(
						"http://localhost:8000/api/department/" + depItem.getId() + "/positions", Position[].class);
				setPositionList(positionList);
			}

		});
	}
	
	private void setPositionList(Position[] positionList) {
		for (Position pos : positionList) {
			this.position.getItems().add(pos.getName());
		}
		this.department.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				Position posItem = positionList[newValue.intValue()];
	
			}

		});
	}
	@FXML
	private void createNewEmployee(ActionEvent event) {
		
		newEmployee.setName(employeeName.getText());
		newEmployee.setEmail(employeeEmail.getText());
		newEmployee.setPhoneNum(employeePhoneNum.getText());
		newEmployee.setPositionId(restTemp.getForObject(
				"http://localhost:8000/api/position/get-by-name/"+this.position.getSelectionModel().getSelectedItem(), Position.class).getId());
		HttpEntity<Employee> request = new HttpEntity<>(newEmployee);
		restTemp.postForObject("http://localhost:8000/api/employee", request, Employee.class);
		try {
		Parent mainScene;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("AppLayout.fxml"));
			mainScene=loader.load();
			Parent source = ((Node) event.getSource()).getParent();
			Scene addEmployeeScene = new Scene(mainScene, 645, 547);
			Stage mainStage = (Stage)source.getScene().getWindow();
			mainStage.setScene(addEmployeeScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
