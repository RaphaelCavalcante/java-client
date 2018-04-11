package br.com.raphael.javaclient;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.raphael.javaclient.loader.MainLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class App extends Application {
	private ConfigurableApplicationContext springContext;
	private MainLoader loader;
	private Parent rootNode;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {

		Application.launch(args);
	}
	@Override
	public void init() throws Exception {
		this.springContext = SpringApplication.run(App.class);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("AppLayout.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
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
		
		
//		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("AppLayout.fxml"));
//		loader.setControllerFactory(springContext::getBean);
//		rootNode = loader.load();
		primaryStage.setTitle("Java Client");
		primaryStage.setScene(new Scene(rootNode, 645, 547));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
