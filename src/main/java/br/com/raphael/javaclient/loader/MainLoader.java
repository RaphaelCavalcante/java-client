package br.com.raphael.javaclient.loader;

import org.springframework.context.ConfigurableApplicationContext;

import javafx.fxml.FXMLLoader;

public class MainLoader {
	private static FXMLLoader loader;
	private static Class<?> instance;
//	private static <T> T sprinGgBean;
	private MainLoader(FXMLLoader fxmlLoader, Class<?> classe) {
		loader = fxmlLoader;
		instance = classe;
//		FXMLLoader mainLoader = new FXMLLoader();
//		mainLoader.setControllerFactory(context::getBean);
	}
	public static MainLoader getInstance(Class<?> classe){
		//classe.getClassLoader().getResource("AppLayout.fxml")
		return new MainLoader(new  FXMLLoader(), classe);
	}
	
	public void setClassLoader(String resource) {
		loader.setLocation(instance.getClassLoader().getResource(resource));
	}
	
	public void setContext(ConfigurableApplicationContext context) {
		loader.setControllerFactory(context::getBean);
	}
	public static FXMLLoader getLoader() {
		return loader;
	}
}
