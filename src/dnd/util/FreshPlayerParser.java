package dnd.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import dnd.sheet.CharacterSheet;

public class FreshPlayerParser {
	final String FRESH_PLAYERS_DIR = "players/fresh_sheets/";
	CharacterSheet _curSheet;
	
	public void generateTemplateCharSheet(){
		
		try {
			PrintWriter writer = new PrintWriter("template.txt", "UTF-8");
			writer.println("Name:");
			writer.println("Character Name:");
			writer.println("Gender:");
			writer.println("Height");
			writer.println("Weight");
			writer.println("Alignment:");
			writer.println("Class:");
			writer.println("Race:");
			writer.println("Roll.Strength:");
			writer.println("Roll.Dexterity:");
			writer.println("Roll.Constituation:");
			writer.println("Roll.Intelligence:");
			writer.println("Roll.Wisdom:");
			writer.println("Roll.Charisma:");
			writer.println("Speed:");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<CharacterSheet> generateFreshCharacters(){
		ArrayList<CharacterSheet> characters = new ArrayList<CharacterSheet>();
		File files[] = new File(FRESH_PLAYERS_DIR).listFiles();
		for(File file:files){
			characters.add(parseFreshCharacter(file));
		}
		return characters;
	}
	
	private CharacterSheet parseFreshCharacter(File file){
		_curSheet = new CharacterSheet();
		int[] stats = new int[9];
		int rollDie;
		int size;
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String elements[] = line.split(":");
				String type = elements[0].replaceAll("[^A-Za-z0-9]", "").toLowerCase();
				
				
				//I'm ashamed of myself
				if(type.equals("name")){
					
				}else if(type.equals("charactername")){
					
				}else if(type.equals("gender")){
					
				}else if(type.equals("height")){
					
				}else if(type.equals("weight")){
					
				}else if(type.equals("alignment")){
					
				}else if(type.equals("class")){
					
				}else if(type.equals("race")){
					
				}else if(type.equals("rollstrength")){
					stats[1] = Integer.getInteger(elements[1]);
				}else if(type.equals("rolldexterity")){
					stats[2] = Integer.getInteger(elements[1]);
				}else if(type.equals("rollconstituation")){
					stats[3] = Integer.getInteger(elements[1]);
				}else if(type.equals("rollintelligence")){
					stats[4] = Integer.getInteger(elements[1]);
				}else if(type.equals("rollwisdom")){
					stats[5] = Integer.getInteger(elements[1]);
				}else if(type.equals("rollcharisma")){
					stats[6] = Integer.getInteger(elements[1]);
				}else if(type.equals("speed")){
					stats[8] = Integer.getInteger(elements[1]);
				}else{
					System.err.println("Ooops, shouldn't be here");
				}
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		return _curSheet;
	}
}
