package readXML;
public class DesktopTemplate {
	private String language;
    private int timeout;
    private int maxQuestions;
     
	 public static void main(String[] args) {
		DesktopTemplate dt = new DesktopTemplate();
		dt.readConfigFile();
		
		//Show saved values
		System.out.println("Language: " + dt.getLanguage());
        System.out.println("Timeout: " + dt.getTimeout());
        System.out.println("Max Questions: " + dt.getMaxQuestions());
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

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int i) {
		this.timeout = i;
	}

	public int getMaxQuestions() {
		return maxQuestions;
	}

	public void setMaxQuestions(int maxQuestions) {
		this.maxQuestions = maxQuestions;
	}
	 
	 
}