package homework;

public class Board {
	private String number;
	private String name;
	private String context;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Board(String number, String name, String context) {
		super();
		this.number = number;
		this.name = name;
		this.context = context;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
