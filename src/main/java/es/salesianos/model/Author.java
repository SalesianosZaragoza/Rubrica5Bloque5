package es.salesianos.model;

public class Author {
	
	private Integer id;
	private String name;
	private String dayOfBirth;
	
	public Author(Integer id, String name, String dayOfBirth) {
		setId(id);
		setName(name);
		setDayOfBirth(dayOfBirth);
	}
	
	public Author() {
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}


}