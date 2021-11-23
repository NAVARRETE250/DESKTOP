package main.java.readXML;
public class KahootConfiguration {
	private String language;
    private String timeout;
    private String maxQuestions;

	public KahootConfiguration() {
		 readConfigFile();
		
		//Show saved values
		System.out.println("Language: " + getLanguage());
        System.out.println("Timeout: " + getTimeout());
        System.out.println("Max Questions: " + getMaxQuestions());
	 }
	 
	public void readConfigFile() {
		//New XmlReader instance for configuration file reading
		ReadXmlDomParser rxmldp = new ReadXmlDomParser();
	    rxmldp.readXML();
	    //Set values for further use
	    setLanguage(rxmldp.getLanguage());
	    setTimeout(rxmldp.getTimeout());
	    setMaxQuestions(rxmldp.getMaxQuestions());
		
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getMaxQuestions() {
		return maxQuestions;
	}

	public void setMaxQuestions(String maxQuestions) {
		this.maxQuestions = maxQuestions;
	}
	 
	 
}