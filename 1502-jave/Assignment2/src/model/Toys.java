package model;

public class Toys {


	protected String SerialNumber;
	protected String name;
	protected String brand;
	private double price;
	private int availableCount;
	private int ageappropriate;
	
	
	public Toys() {
		
	}
	
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getAgeappropriate() {
		return ageappropriate;
	}
	public void setAgeappropriate(int ageappropriate) {
		this.ageappropriate = ageappropriate;
	}
	/**
	A method to format the Toy object properties to a readable string for display on the screen
	@return a formatted string with the toy's properties
	*/
    public String formatToScreen(){
		String c = this.getClass().getName();
		c = c.replaceAll("model.", "");
		if (this.getClass().getName().contains("Animals")){
			Animals a = (Animals) this;
			return "category:" +c+ ", SerialNumber:"+SerialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageappropriate+", Material:"+a.getMaterial()+", Size:"+a.getSize();
		}
		if (this.getClass().getName().contains("BoardGames")){
			BoardGames b = (BoardGames) this;
			return "category:" +c+ ", SerialNumber:"+SerialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageappropriate+"; Number of min Players:"+b.getMinPlayers()+"; Number of max Players:"+b.getMaxPlayers()+"; Designer:"+b.getDesigner();
		}
		if (this.getClass().getName().contains("Figures")){
			Figures f = (Figures) this;
			return "category:" +c+ ", SerialNumber:"+SerialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageappropriate+"; Classification:"+f.getClassification();
		}
		if (this.getClass().getName().contains("Puzzles")){
			Puzzles p = (Puzzles) this;
			return "category:" +c+ ", SerialNumber:"+SerialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageappropriate+"; Puzzle Type:"+p.getPuzzletype();
		}
		return "type invalid";
	}
	/**
	A method to format the Toy object properties to a string for writing to a file
	@return a formatted string with the toy's properties
	*/
	public String formatToFile(){
		if (this.getClass().getName().contains("Animals")){
			Animals a = (Animals) this;
			return SerialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageappropriate+";"+a.getMaterial()+";"+a.getSize();
		}
		if (this.getClass().getName().contains("BoardGames")){
			BoardGames b = (BoardGames) this;
			return SerialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageappropriate+";"+b.getMinPlayers()+"-"+b.getMaxPlayers()+";"+b.getDesigner();
		}
		if (this.getClass().getName().contains("Figures")){
			Figures f = (Figures) this;
			return SerialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageappropriate+";"+f.getClassification();
		}
		if (this.getClass().getName().contains("Puzzles")){
			Puzzles p = (Puzzles) this;
			return SerialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageappropriate+";"+p.getPuzzletype();
		}
		return "type invalid";
	}
}
