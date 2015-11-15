package dnd.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import dnd.constants.DnDClassConst;
import dnd.constants.DnDEntityConst;
import dnd.constants.DnDRaceConst;
import dnd.sheet.CharacterSheet;

public class FreshPlayerParser {
	String workingDir = System.getProperty("user.dir");
	String newDir = workingDir.substring(0,workingDir.length()-3);
	final String FRESH_PLAYERS_DIR = "players/fresh_sheets/";
	CharacterSheet _curSheet;
	
	public void generateTemplateCharSheet(){
		
		try {
			PrintWriter writer = new PrintWriter("template.txt", "UTF-8");
			writer.println("Name:");
			writer.println("Character Name:");
			writer.println("Gender:");
			writer.println("Height:");
			writer.println("Weight:");
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
		System.out.println(FRESH_PLAYERS_DIR);
		for(File file:files){
			characters.add(parseFreshCharacter(file));
		}
		return characters;
	}
	
	private CharacterSheet parseFreshCharacter(File file){
		_curSheet = new CharacterSheet();
		
		int rollDie = 0;
		int size;
		int[] stats = new int[9];
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String elements[] = line.split(":");
				String type = elements[0].replaceAll("[^A-Za-z0-9]", "").toLowerCase();
				
				
				//I'm ashamed of myself
				if(type.equals("name")){
					_curSheet.setName(elements[1]);
				}else if(type.equals("charactername")){
					_curSheet.setCharacterName(elements[1]);
				}else if(type.equals("gender")){
					_curSheet.setGender(elements[1]);
				}else if(type.equals("height")){
					_curSheet.setHeight(elements[1]);
				}else if(type.equals("weight")){
					_curSheet.setWeight(elements[1]);
				}else if(type.equals("alignment")){
					_curSheet.setAlignment(elements[1]);
				}else if(type.equals("class")){
					int clas = _curSheet.setClass(findClass(elements[1].replaceAll("[^A-Za-z0-9]", "").toLowerCase()));
					rollDie = diceCheck(clas);
				}else if(type.equals("race")){
					int race = _curSheet.setRace(findRace(elements[1].replaceAll("[^A-Za-z0-9]", "").toLowerCase()));
					if(race == DnDRaceConst.HALFLING || race == DnDRaceConst.GNOME){
						size = DnDEntityConst.SIZE_SMALL;
					}else{
						size = DnDEntityConst.SIZE_MEDIUM;
					}
					stats[7] = size;
				}else if(type.equals("rollstrength")){
					
					stats[1] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("rolldexterity")){
					stats[2] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("rollconstituation")){
					stats[3] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("rollintelligence")){
					stats[4] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("rollwisdom")){
					stats[5] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("rollcharisma")){
					stats[6] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else if(type.equals("speed")){
					stats[8] = Integer.parseInt(elements[1].replaceAll("[^A-Za-z0-9]", ""));
				}else{
					System.err.println("Ooops, shouldn't be here");
				}
				
			}
			
			//calc for health
			stats[0] = (stats[3] + _curSheet.getRace().getConMod()-10)/2 + rollDie;
			_curSheet.makeStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], stats[6], stats[7], stats[8]);
			_curSheet.printStats();
			scanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		return _curSheet;
	}
	
	private int findRace(String element){
		if(element.equals("human")){
			return DnDRaceConst.HUMAN;
		}else if(element.equals("elf")){
			return DnDRaceConst.ELF;
		}else if(element.equals("gnome")){
			return DnDRaceConst.GNOME;
		}else if(element.equals("dwarf")){
			return DnDRaceConst.DWARF;
		}else if(element.equals("halfelf")){
			return DnDRaceConst.HALF_ELF;
		}else if(element.equals("halforc")){
			return DnDRaceConst.HALF_ORC;
		}else if(element.equals("halfling")){
			return DnDRaceConst.HALFLING;
		}else{
			return -1;
		}
	}
	
	private int findClass(String element){
		if(element.equals("barbarian")){
			return DnDClassConst.BARBARIAN;
		}else if(element.equals("bard")){
			return DnDClassConst.BARD;
		}else if(element.equals("cleric")){
			return DnDClassConst.CLERIC;
		}else if(element.equals("druid")){
			return DnDClassConst.DRUID;
		}else if(element.equals("fighter")){
			return DnDClassConst.FIGHTER;
		}else if(element.equals("monk")){
			return DnDClassConst.MONK;
		}else if(element.equals("paladin")){
			return DnDClassConst.PALADIN;
		}else if(element.equals("ranger")){
			return DnDClassConst.RANGER;
		}else if(element.equals("rogue")){
			return DnDClassConst.ROGUE;
		}else if(element.equals("sorcerer")){
			return DnDClassConst.SORCERER;
		}else if(element.equals("wizard")){
			return DnDClassConst.WIZARD;
		}
		return -1;
	}
	
	private int diceCheck(int classId){
		if(classId == DnDClassConst.BARBARIAN){
			return 12;
		}
		if(classId == DnDClassConst.PALADIN || classId == DnDClassConst.FIGHTER){
			return 10;
		}
		if(classId == DnDClassConst.BARD || classId == DnDClassConst.ROGUE){
			return 6;
		}
		if(classId == DnDClassConst.WIZARD || classId == DnDClassConst.SORCERER){
			return 4;
		}
		return 8;
	}
}
