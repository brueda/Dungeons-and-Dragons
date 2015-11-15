package dnd.race;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import dnd.constants.DnDRaceConst;

public class DnDRace {
	int _strMod;
	int _dexMod;
	int _conMod;
	int _intMod;
	int _wisMod;
	int _chaMod;
	int _spd;
	int _size;
	JSONObject _statsJSON;
	
	String _raceQuery;
	String _raceName;
	
	
	void parseStats(){
		JSONObject obj = (JSONObject)_statsJSON.get(_raceQuery);
		_strMod = (int)((long)obj.get(DnDRaceConst.STR_QUERY));
		_dexMod = (int)((long)obj.get(DnDRaceConst.DEX_QUERY));
		_conMod = (int)((long)obj.get(DnDRaceConst.CON_QUERY));
		_intMod = (int)((long)obj.get(DnDRaceConst.INT_QUERY));
		_wisMod = (int)((long)obj.get(DnDRaceConst.WIS_QUERY));
		_chaMod = (int)((long)obj.get(DnDRaceConst.CHA_QUERY));
		_spd = (int)((long)obj.get(DnDRaceConst.SPEED_QUERY));
		_size = (int)((long)obj.get(DnDRaceConst.SIZE_QUERY));
		
	}
	
	void constructJSON(){
		try {
			FileReader reader = new FileReader(DnDRaceConst.FILE_PATH);
			JSONParser jsonParser = new JSONParser();
			_statsJSON = (JSONObject) jsonParser.parse(reader);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getStrMod(){
		return _strMod;
	}
	
	public int getDexMod(){
		return _dexMod;
	}
	
	public int getConMod(){
		return _conMod;
	}
	
	public int getIntMod(){
		return _intMod;
	}
	
	public int getWisMod(){
		return _wisMod;
	}
	
	public int getChaMod(){
		return _chaMod;
	}
	
	public int getSpeed(){
		return _spd;
	}
	
	public int getSize(){
		return _size;
	}
	
	public String getRaceName(){
		return _raceName;
	}
}
