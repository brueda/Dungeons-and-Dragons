package dnd.classification;

public interface DnDClass {
	
	public String getClassName();
	
	public int getBaseAttackMod();
	
	public int getFortSaveMod();
	
	public int getRefSaveMod();
	
	public int getWillSaveMod();
	
	public void printStatus();
}
