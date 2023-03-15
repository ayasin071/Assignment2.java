package model;

public class BoardGames extends Toys{

	
	private int maxPlayers;
	private int minPlayers;
	private String designer;
	
	public int getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
}
