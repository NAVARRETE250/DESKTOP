package xmlReading;

//Desktop Template Class for testing xml file reading
public class DesktopTemplate {
	private String language;
    private String timeout;
    private String maxQuestions;
     
	 public static void main(String[] args) {
		DesktopTemplate dt = new DesktopTemplate();
		dt.readConfigFile();
		
		//Show saved values
		System.out.println("Language: " + dt.getLanguage());
        System.out.println("Timeout: " + dt.getTimeout());
        System.out.println("Max Questions: " + dt.getMaxQuestions());
		  }

	private void readConfigFile() {
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
