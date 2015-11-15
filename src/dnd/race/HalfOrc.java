package dnd.race;

import dnd.constants.DnDRaceConst;

public class HalfOrc extends DnDRace{
	
	public HalfOrc(){
		this._raceQuery = DnDRaceConst.QUERY_HALF_ORC;
		this._raceName = "Half-Orc";
		this.constructJSON();
		this.parseStats();
	}

}
