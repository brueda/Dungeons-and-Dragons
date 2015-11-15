package src.dnd.classification;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import src.dnd.constants.DnDClassConst;


public class Druid implements DnDClass {
	final String ATTACK_GROWTH = DnDClassConst.WEAK_QUERY;
	final String FORT_GROWTH = DnDClassConst.STRONG_QUERY;
	final String REF_GROWTH = DnDClassConst.WEAK_QUERY;
	final String WILL_GROWTH = DnDClassConst.STRONG_QUERY;
	
	
	int _bonus[];
	JSONObject _levelBonus;
	
	public Druid(){
		_bonus = new int[4];
		constructJSON(DnDClassConst.STAT_GROWTH_PATH);
		updateBonus(20);
	}
	
	@Override
	public int getBaseAttackMod() {
		return _bonus[DnDClassConst.ATTACK_BONUS];
	}

	@Override
	public int getFortSaveMod() {
		return _bonus[DnDClassConst.FORT_SAVE];
	}

	@Override
	public int getRefSaveMod() {
		return _bonus[DnDClassConst.REF_SAVE];
	}

	@Override
	public int getWillSaveMod() {
		return _bonus[DnDClassConst.WILL_SAVE];
	}
	
	private void updateBonus(int level){
		if(level > 20){
			level = 20;
		}
		String lvlQuery = "lvl"+level;
		JSONObject obj = (JSONObject)_levelBonus.get(DnDClassConst.SAVE_QUERY);
		JSONObject fortObj = (JSONObject)obj.get(FORT_GROWTH);
		JSONObject refObj = (JSONObject)obj.get(REF_GROWTH);
		JSONObject willObj = (JSONObject)obj.get(WILL_GROWTH);
		obj = (JSONObject)_levelBonus.get(DnDClassConst.ATTACK_BONUS_QUERY);
		obj = (JSONObject)obj.get(ATTACK_GROWTH);
		
		_bonus[DnDClassConst.ATTACK_BONUS] = (int)((long)obj.get(lvlQuery));
		_bonus[DnDClassConst.FORT_SAVE] = (int)((long)fortObj.get(lvlQuery));
		_bonus[DnDClassConst.REF_SAVE] = (int)((long)refObj.get(lvlQuery));
		_bonus[DnDClassConst.WILL_SAVE] = (int)((long)willObj.get(lvlQuery));
	}
	
	private void constructJSON(String path){
			try {
				FileReader reader = new FileReader(path);
				JSONParser jsonParser = new JSONParser();
				_levelBonus = (JSONObject) jsonParser.parse(reader);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
	}
	@Override
	public void printStatus(){
		System.out.println("Attack Bonus = " + _bonus[DnDClassConst.ATTACK_BONUS] + "\nFort Save = " + _bonus[DnDClassConst.FORT_SAVE] + 
				"\nRef Save = " + _bonus[DnDClassConst.REF_SAVE] + "\nWill Save = " + _bonus[DnDClassConst.WILL_SAVE]);
	}

	@Override
	public String getClassName() {
		
		return "Druid";
	}
	
	

}
