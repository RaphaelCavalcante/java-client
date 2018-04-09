package br.com.raphael.javaclient;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.raphael.javaclient.service.CompanyService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class App extends Application implements CommandLineRunner{
	@Autowired
	private CompanyService companyService;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		BorderPane border = new BorderPane();
//		
//	    final ListView<Company> list = new ListView<Company>();
//	    this.companyService.getAllCompany().stream().forEach(new Consumer<Company>() {
//			@Override
//			public void accept(Company company) {
//				list.getItems().add(company);
//			}
//		});
//	    list.setPadding(new Insets(10, 10, 10, 10));
//	    border.setCenter(list);
//	      // Set margin for top area.
//	    BorderPane.setMargin(list, new Insets(10, 10, 10, 10));
//		
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AppLayout.fxml"));
		Scene scene= new Scene(root, 645, 547);
		primaryStage.setTitle("Java Client");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void run(String... args) throws Exception {
		launch(args);
	}
}
