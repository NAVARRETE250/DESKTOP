package kahootManagement;

import java.awt.Component;
import java.util.Hashtable;

public class KahootQuestion extends Component {
	private String questionText;
	Hashtable<String, Boolean> answers;
	
	public KahootQuestion(String questionText, Hashtable<String, Boolean> answers) {
		this.questionText = questionText;
		this.answers = answers;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Hashtable<String, Boolean> getAnswers() {
		return answers;
	}

	public void setAnswers(Hashtable<String, Boolean> answers) {
		this.answers = answers;
	}
}
