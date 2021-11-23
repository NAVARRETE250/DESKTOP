package main.java.app;

import java.awt.EventQueue;

import main.java.readXML.KahootConfiguration;

public class MainDesktopApp {

	private KahootConfiguration configuration;
	
public static void main(String[] args) {
	/*
	 * Load configuration
	 */
	MainDesktopApp mda = new MainDesktopApp(new KahootConfiguration());
	
	mda.getConfiguration().readConfigFile();
	
	System.out.println(mda.getConfiguration().getLanguage());
	/**
	 * Launch the application.
	 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Login frame = new Pantalla_Login(new KahootConfiguration());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainDesktopApp(KahootConfiguration configuration) {
		setConfiguration(configuration);
	}
	
	private KahootConfiguration getConfiguration() {
		return this.configuration;
	}
	
	private void setConfiguration(KahootConfiguration configuration) {
		this.configuration = configuration;	
	}
	
}
