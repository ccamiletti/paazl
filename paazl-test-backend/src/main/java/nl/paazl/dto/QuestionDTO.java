package nl.paazl.dto;

public class QuestionDTO {
	
	private Long id;
	
	private String question;
	
	private Character anwserUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Character getAnwserUser() {
		return anwserUser;
	}
	public void setAnwserUser(Character anwserUser) {
		this.anwserUser = anwserUser;
	}
	
	
}
