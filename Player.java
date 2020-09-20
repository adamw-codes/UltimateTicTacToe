package tictactoe;

public class Player {
	private String name;
	private String mark;
	
	// when the player is given a name and mark argument
	public Player(String name, String mark) {
		// uses set methods to store them
		this.setName(name);
		this.setMark(mark);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public int randomNumber(int range) {
		// randomly generates a random in any range given using the Math class
		return (int)(Math.random() * range);
	}
	
}
