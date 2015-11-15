package src.dnd.race;

import src.dnd.constants.DnDRaceConst;

public class Dwarf extends DnDRace{
	
	
	public Dwarf(){
		this._raceQuery = DnDRaceConst.QUERY_DWARF;
		this._raceName = "Dwarf";
		this.constructJSON();
		this.parseStats();
	}
}
