package src.dnd.item;

public class Armor extends Item{
	int _ac;
	int _maxDex;
	int _spellFailure;
	int _armorPenalty;
	
	public Armor(String name,int ac, int maxDex, int spellFailure, int armorPenalty, int value, int weight){
		this.setName(name);
		_ac = ac;
		_maxDex = maxDex;
		_spellFailure = spellFailure;
		_armorPenalty = armorPenalty;
		this.setValue(value);
		this.setWeight(weight);
	}
	
	
	public int getArmorClass(){
		return _ac;
	}
	
	public int getMaxDex(){
		return _maxDex;
	}
	
	public int getSpellFailure(){
		return _spellFailure;
	}
	
	public int getArmorPenalty(){
		return _armorPenalty;
	}
}
