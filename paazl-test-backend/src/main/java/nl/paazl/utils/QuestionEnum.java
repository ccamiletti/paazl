package nl.paazl.utils;

public enum QuestionEnum {

	QUESTION_1("A Thread is a process", 'N'),
	QUESTION_2("A List cannot contain duplicates", 'N'),
	QUESTION_3("A Set can contain duplicates", 'N'),
	QUESTION_4("Java is platform independent", 'Y'),
	QUESTION_5("Java supports copy constructors like C++", 'Y'),
	QUESTION_6("The primitive data types supported by the " + 
			"Java programming language are: byte, " + 
			"short, int, long, float, double, boolean, char", 'Y'),
	QUESTION_7("Constructor overloading is similar to method " + 
			"overloading in Java", 'N'),
	QUESTION_8("The purpose of garbage collection in Java " + 
			"is to reclaim and reuse objects which are no " + 
			"longer used", 'Y'),
	QUESTION_9("Autoboxing is the automatic conversion " + 
			"made by the Java compiler between the " + 
			"primitive types and their corresponding " + 
			"object wrapper classes", 'Y'),
	QUESTION_10("JDBC is an abstraction layer that allows " + 
			"users to choose between databases", 'Y'),
	QUESTION_11("Java supports the usage of pointers", 'N');
	
	private String text;
	private Character answer;

	QuestionEnum(String text, Character answer) {
		this.text = text;
		this.answer = answer;
	}
	
	public String text() {
		return text;
	}
	public Character answer() {
		return answer;
	}
	
}
