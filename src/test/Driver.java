package src.test;

import src.dnd.sheet.*;
import src.dnd.util.FreshPlayerParser;
import src.dnd.constants.*;

public class Driver {
	public static void main(String args[]){
		Driver drive = new Driver();
		drive.barbTest();
		new FreshPlayerParser().generateTemplateCharSheet();
	}
	
	public void walletTest(){
		CharacterSheet character = new CharacterSheet(DnDClassConst.BARD, DnDRaceConst.HUMAN);
		int[] currencyAdd = {100,10,3};
		character.getWallet().addCurrency(currencyAdd);
		character.getWallet().printStats();
		currencyAdd[0] = 43;
		currencyAdd[1] = 0;
		currencyAdd[2] = 0;
		character.getWallet().addCurrency(currencyAdd);
		character.getWallet().printStats();
		
		currencyAdd[0] = 0;
		currencyAdd[1] = 12;
		currencyAdd[2] = 0;
		character.getWallet().subCurrency(currencyAdd);
		character.getWallet().printStats();
	}
	
	public void barbTest(){
		CharacterSheet character = new CharacterSheet(DnDClassConst.BARBARIAN, DnDRaceConst.HALF_ORC);
		character.getDnDClass().printStatus();
	}
}
