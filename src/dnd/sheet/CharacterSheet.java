package dnd.sheet;

import java.util.ArrayList;

import dnd.item.*;
import dnd.race.*;
import dnd.classification.*;
import dnd.constants.*;
import dnd.entity.Stats;

public class CharacterSheet {
	String _playerName;
	String _characterName;
	String _gender;
	String _height;
	String _weight; //Height and Weight are kept as strings for fun and because we don't care about them
	String _alignment;
	
	int _level;
	int _expToNextLvl;
	int _exp;
	
	Wallet _wallet;
	DnDClass _class;
	DnDRace _race;
	Stats _stats;
	
	ArrayList<Item> _inventory; // All non equipment items;
	ArrayList<Item> _equipment;
	
	public CharacterSheet(){
		
	}
	
	public CharacterSheet(int classId, int raceId){
		_wallet = new Wallet();
		_level = 1;
		_exp = 0;
		_expToNextLvl = 0;
		_inventory = new ArrayList<Item>();
		_equipment = new ArrayList<Item>();
		
		calcExpToLvl();
		setClass(classId);
		setRace(raceId);
	}
	
	public void makeStats(int maxHp, int str, int dex, int con, int intel, int wis, int cha, int size, int speed){
		_stats = new Stats();
		_stats.initStats(maxHp, str, dex, con, intel, wis, cha, size, speed);
	}

	public int getStrMod(){
		int total = _race.getStrMod() + _stats.getStr();
		return calcStat(total);
	}
	
	public int getDexMod(){
		int total = _race.getDexMod() + _stats.getDex();
		return calcStat(total);
	}
	
	public int getConMod(){
		int total = _race.getConMod() + _stats.getCon();
		return calcStat(total);
	}
	
	public int getIntMod(){
		int total = _race.getIntMod() + _stats.getInt();
		return calcStat(total);
	}
	
	public int getWisMod(){
		int total = _race.getWisMod() + _stats.getWis();
		return calcStat(total);
	}
	
	public int getChaMod(){
		int total = _race.getChaMod() + _stats.getCha();
		return calcStat(total);
	}
	
 	public Wallet getWallet(){
		return _wallet;
	}
 	
 	public String getPlayerName(){
 		return _playerName;
 	}
 	
 	public String getCharacterName(){
 		return _characterName;
 	}
 	
 	public String getGender(){
 		return _gender;
 	}
 	
 	public String getWeight(){
 		return _weight;
 	}
 	
 	public String getHeight(){
 		return _height;
 	}
 	
 	public String getAlignment(){
 		return _alignment;
 	}
	
	public void addExp(int exp){
		_exp += exp;
		if(_exp >= _expToNextLvl){
			handleLevelUp();
		}
	}
	
	public DnDClass getDnDClass(){
		return _class;
	}
	
	private void calcExpToLvl(){
		if(_level < 6){
			_expToNextLvl += 200;
		}else{
			_expToNextLvl += 500;
		}
	}
	
	private void handleLevelUp(){
		_exp = 0;
		calcExpToLvl();
		_level ++;
	}
	
	public int setClass(int classId){
		switch(classId){
		case DnDClassConst.BARBARIAN:
			_class = new Barbarian();
			return DnDClassConst.BARBARIAN;
//			break;
		case DnDClassConst.BARD:
			_class = new Bard();
			return DnDClassConst.BARD;
//			break;
		case DnDClassConst.CLERIC:
			_class = new Cleric();
			return DnDClassConst.CLERIC;
//			break;
		case DnDClassConst.DRUID:
			_class = new Druid();
			return DnDClassConst.DRUID;
//			break;
		case DnDClassConst.FIGHTER:
			_class = new Fighter();
			return DnDClassConst.FIGHTER;
//			break;
		case DnDClassConst.MONK:
			_class = new Monk();
			return DnDClassConst.MONK;
//			break;
		case DnDClassConst.PALADIN:
			_class = new Paladin();
			return DnDClassConst.PALADIN;
//			break;
		case DnDClassConst.RANGER:
			_class = new Ranger();
			return DnDClassConst.RANGER;
//			break;
		case DnDClassConst.ROGUE:
			_class = new Rogue();
			return DnDClassConst.ROGUE;
//			break;
		case DnDClassConst.SORCERER:
			_class = new Sorcerer();
			return DnDClassConst.SORCERER;
//			break;
		case DnDClassConst.WIZARD:
			_class = new Wizard();
			return DnDClassConst.WIZARD;
//			break;
		default:
			System.err.println("Error: Character ID not recognized.");
			break;
				
		}
		return -1;
	}
	
	public int setRace(int raceId){
		switch(raceId){
		case DnDRaceConst.HUMAN:
			_race = new Human();
			return DnDRaceConst.HUMAN;
//			break;
		case DnDRaceConst.ELF:
			_race = new Elf();
			return DnDRaceConst.ELF;
//			break;
		case DnDRaceConst.DWARF:
			_race = new Dwarf();
			return DnDRaceConst.DWARF;
//			break;
		case DnDRaceConst.HALF_ELF:
			_race = new HalfElf();
			return DnDRaceConst.HALF_ELF;
//			break;
		case DnDRaceConst.GNOME:
			_race = new Gnome();
			return DnDRaceConst.GNOME;
//			break;
		case DnDRaceConst.HALF_ORC:
			_race = new HalfOrc();
			return DnDRaceConst.HALF_ORC;
//			break;
		case DnDRaceConst.HALFLING:
			_race = new Halfling();
			return DnDRaceConst.HALFLING;
//			break;
		default:
			System.err.println("Error: Race ID not recognized");
			break;
		}
		return -1;
	}
	
	public ArrayList<Item> getInventory(){
		return _inventory;
	}
	
	public ArrayList<Item> getEquipment(){
		return _equipment;
	}
	
	public void addItem(String name, String desc, int value, int weight){
		Item toAdd = new Item();
		toAdd.setName(name);
		toAdd.setDesc(desc);
		toAdd.setValue(value);
		toAdd.setWeight(weight);
		_inventory.add(toAdd);
	}
	
	public void addWeapon(String name,String desc, String dmgDice, int critMult, int critRange, int phyRange, int value, int weight){
		Item toAdd = new Weapon(name,dmgDice,critMult,critRange,phyRange,value,weight);
		toAdd.setDesc(desc);
		_equipment.add(toAdd);
	}
	
	public void addArmor(String name,String desc,int ac, int maxDex, int spellFailure, int armorPenalty, int value, int weight){
		Item toAdd = new Armor(name,ac,maxDex,spellFailure,armorPenalty,value,weight);
		toAdd.setDesc(desc);
		_equipment.add(toAdd);
	}

	private int calcStat(int total){
		return (total-10)/2;
	}
	
	public void setName(String name){
		_playerName = name;
	}
	
	public void setCharacterName(String name){
		_characterName = name;
	}
	
	public void setGender(String gender){
		_gender = gender;
	}
	
	public void setHeight(String height){
		_height = height;
	}
	
	public void setWeight(String weight){
		_weight = weight;
	}
	
	public void setAlignment(String alignment){
		_alignment = alignment;
	}
	
	public void printStats(){
		System.out.println("Player Name: " + _playerName);
		System.out.println("Character Name: " + _characterName);
		System.out.println("Gender: " + _gender);
		System.out.println("Weight: " + _weight);
		System.out.println("Height: " + _height);
		System.out.println("Alignment: " + _alignment);
	}
	
	
}
