package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;
import view.AppMenu;

/**
 * This class manages the toy store and implements the functionality of searching, purchasing, adding and removing toys.
 */
public class StoreManager {
	public ArrayList <Toys> listOfToys; // list of all toys in the store
	AppMenu appMen; // menu interface
	private final String FILE_PATH = "/Users/osmanmufti/Desktop/1502-jave/Assignment2/res/toys.txt"; // file path for storing toy data
	
	/**
	 * Creates a new StoreManager object with a new instance of the AppMenu class.
	 */
	public StoreManager(){
		appMen = new AppMenu();
	}
	
	/**
	 * Loads toy data from a file and populates the listOfToys ArrayList.
	 * @throws Exception if there is an error while reading from the file.
	 */
	public void loadData() throws Exception {
		listOfToys = new ArrayList<>(); // initialize list of toys
		File info = new File(FILE_PATH); // create file object
		String currentLine;
		String[] splittedLine;
		if(info.exists()) { // check if file exists
			Scanner fileReader = new Scanner(info); // create file reader object
			while (fileReader.hasNextLine()){ // loop through file
				currentLine = fileReader.nextLine(); // read a line
				splittedLine = currentLine.split(";"); // split the line by semicolon
				String SerialNumber = splittedLine[0];
				char firstchar = SerialNumber.charAt(0);
				if (firstchar == '0' || firstchar == '1') { // if toy is a figure
					Figures t = new Figures(); // create a new Figure object
					t.setSerialNumber(splittedLine[0]);
					t.setName(splittedLine[1]);
					t.setBrand(splittedLine[2]);
					t.setPrice(Double.parseDouble(splittedLine[3]));
					t.setAvailableCount(Integer.parseInt(splittedLine[4]));
					t.setAgeappropriate(Integer.parseInt(splittedLine[5]));
					t.setClassification(splittedLine[6]);
					listOfToys.add(t); // add the toy to the list
				}
				if (firstchar == '2' || firstchar == '3') { // if toy is an animal
					Animals t = new Animals(); // create a new Animal object
					t.setSerialNumber(splittedLine[0]);
					t.setName(splittedLine[1]);
					t.setBrand(splittedLine[2]);
					t.setPrice(Double.parseDouble(splittedLine[3]));
					t.setAvailableCount(Integer.parseInt(splittedLine[4]));
					t.setAgeappropriate(Integer.parseInt(splittedLine[5]));
					t.setMaterial(splittedLine[6]);
					t.setSize(splittedLine[7]);
					listOfToys.add(t); 
				}
				if (firstchar == '4' || firstchar == '5' || firstchar == '6') {
					Puzzles t = new Puzzles();
					t.setSerialNumber(splittedLine[0]);
					t.setName(splittedLine[1]);
					t.setBrand(splittedLine[2]);
					t.setPrice(Double.parseDouble(splittedLine[3]));
					t.setAvailableCount(Integer.parseInt(splittedLine[4]));
					t.setAgeappropriate(Integer.parseInt(splittedLine[5]));
					t.setPuzzletype(splittedLine[6]);
					listOfToys.add(t);
				}
				if (firstchar == '7' || firstchar == '8' || firstchar == '9') {
					BoardGames t = new BoardGames();
					t.setSerialNumber(splittedLine[0]);
					t.setName(splittedLine[1]);
					t.setBrand(splittedLine[2]);
					t.setPrice(Double.parseDouble(splittedLine[3]));
					t.setAvailableCount(Integer.parseInt(splittedLine[4]));
					t.setAgeappropriate(Integer.parseInt(splittedLine[5]));
					String[] maxmin = splittedLine[6].split("-");
					t.setMaxPlayers(Integer.parseInt(maxmin[1]));
					t.setMinPlayers(Integer.parseInt(maxmin[0]));
					t.setDesigner(splittedLine[7]);
					listOfToys.add(t);
				}
			
		}
		fileReader.close();
	}	
		else {
			System.out.print("File Not Found\n");
		}
		
	}

	public void lauch() throws FileNotFoundException{
		boolean flag = true;
		int option;
		while(flag){
			option = appMen.showmainmenu();
			switch(option){
			case 1 :
				searchAndPurchase();
				break;
			case 2 :
				Toys t = appMen.addnewtoy();
				addNewToy(t);
				appMen.ToyAddedMessgae();
				break;
			case 3 :
				String rem = appMen.removetoy();
				removeAToy(rem);
				break;
			case 4 :
				Save();
				flag = false;
				break;

				
			}
		}
	}
	public void searchAndPurchase(){
		boolean flag = true;
		int option;
		ArrayList<Toys> toys;
		while (flag){
			option = appMen.showSubMenu();
			Toys selectedtoy;
			switch(option){
				case 1 :
					String SN = appMen.getSerialNumber();
					toys = getToyBySerialNumber(SN);
					if (toys.size() == 0){
						appMen.notValid();
						break;
					} else{
						appMen.printToys(toys);
						selectedtoy = appMen.PurchaseListIndex(toys);
						purchaseToy(selectedtoy);
						break;
					}
				case 2 :
					String name = appMen.getToyName();
					toys = searchByName(name);
					if (toys.size() == 0){
						appMen.notValid();
						break;
					} else{
						appMen.printToys(toys);
						selectedtoy = appMen.PurchaseListIndex(toys);
						purchaseToy(selectedtoy);
						break;
					}
				case 3 :
					String type = appMen.getType();
					toys = ByType(type);
					if (toys.size() == 0){
						appMen.notValid();
						break;
					} else{
					appMen.printToys(toys);
					selectedtoy = appMen.PurchaseListIndex(toys);
					purchaseToy(selectedtoy);
					break;
					}
				case 4 :
					flag = false;
					break;
	
					
			}
		}
	}
	public void purchaseToy(Toys selectedToy){
		if (selectedToy == null){
			return ;
		}
		for (Toys t:listOfToys) {
            if (t.getSerialNumber().equals(selectedToy.getSerialNumber())) {
				int count = t.getAvailableCount();
				count = count -1;
                t.setAvailableCount(count);
				appMen.purchaseComplete();
			}
		}
	}
	public ArrayList <Toys> getToyBySerialNumber(String serialNumber) {
        ArrayList<Toys> toys = new ArrayList<>();
		for (Toys t:listOfToys) {
            if (t.getSerialNumber().equals(serialNumber)) {
                toys.add(t);
			}
		}
		return toys;
	}

	public ArrayList <Toys> ByType(String type){
		ArrayList<Toys> toys = new ArrayList<>();
		for(Toys t: listOfToys){
			if(t.getClass().getName().toLowerCase().contains(type)){
				toys.add(t);
			}
		}
		return toys;
	}
	


	public ArrayList <Toys> searchByName(String name) {
		ArrayList<Toys> toys = new ArrayList<>();
		for(Toys t: listOfToys){
			if (t.getName().toLowerCase().contains(name.toLowerCase())){
				toys.add(t);
			}
			
		}
		return toys;
	}

	public void addNewToy(Toys newToy){
		listOfToys.add(newToy);
	}
	
	public void removeAToy(String serialNumber) {
		for (Toys t:listOfToys) {
            if (t.getSerialNumber().equals(serialNumber)) {
                String option = appMen.toyToRemove(t);
				if (option.equals("y")){
					listOfToys.remove(t);
					appMen.toyRemoved();
				}
				return;
			}
		}
		appMen.noItem();
	}
	
	public void Save() throws FileNotFoundException {
		File info = new File(FILE_PATH );
		PrintWriter pw;
		pw = new PrintWriter(info);
		for (Toys t: listOfToys) {
			pw.println(t.formatToFile());
		}
		pw.close();
	}


}
	
