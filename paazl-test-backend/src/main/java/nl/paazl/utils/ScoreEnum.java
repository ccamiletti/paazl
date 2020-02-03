package nl.paazl.utils;

public enum ScoreEnum {
	
	RANGE_1("Junior developer", 0, 3),
	RANGE_2("Medior developer", 4, 7),
	RANGE_3("Senior developer", 8, 11);
	
	private String description;
	private Integer rangeInit;
	private Integer rangeEnd;

	private ScoreEnum(String description, Integer rangeInit, Integer rangeEnd) {
		this.description = description;
		this.rangeInit = rangeInit;
		this.rangeEnd = rangeEnd;
	}
	
	public String description() {
		return description;
	}
	public Integer rangeInit() {
		return rangeInit;
	}
	
	public Integer rangeEnd() {
		return rangeEnd;
	}
	
}
