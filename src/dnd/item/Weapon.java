package src.dnd.item;

public class Weapon extends Item{
	String _dmgDice; // dice type and quant. Player dice rolls are still manual
	int _critMult;
	int _critRange;
	int _phyRange;
	
	
	public Weapon(String name, String dmgDice, int critMult, int critRange, int phyRange, int value, int weight){
		_dmgDice = dmgDice;
		_critMult = critMult;
		_critRange = critRange;
		_phyRange = phyRange;
		this.setName(name);
		this.setValue(value);
		this.setWeight(weight);
	}
	
	public String getDice(){
		return _dmgDice;
	}
	
	public int getCritMult(){
		return _critMult;
	}
	
	public int getCritRange(){
		return _critRange;
	}
	
	public int getPhysicalRange(){
		return _phyRange;
	}
}
