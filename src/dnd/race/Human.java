package dnd.race;

import dnd.constants.DnDRaceConst;

public class Human extends DnDRace{
	
	public Human(){
		this._raceQuery = DnDRaceConst.QUERY_HUMAN;
		this._raceName = "Human";
		this.constructJSON();
		this.parseStats();
	}
}
