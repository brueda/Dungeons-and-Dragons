package src.dnd.race;

import src.dnd.constants.DnDRaceConst;

public class Halfling extends DnDRace{

	public Halfling(){
		this._raceQuery = DnDRaceConst.QUERY_HALFLING;
		this._raceName = "Halfling";
		this.constructJSON();
		this.parseStats();
	}
}
