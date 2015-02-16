package quizcards;

public class QuizCard {
	private String question, answer;
	
	QuizCard(String q, String a){
		question = q;
		answer = a;
	} // ctor
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer(){
		return answer;
	}
}
