package dnd.race;

import dnd.constants.DnDRaceConst;

public class Gnome extends DnDRace{
	
	public Gnome(){
		this._raceQuery = DnDRaceConst.QUERY_GNOME;
		this._raceName = "Gnome";
		this.constructJSON();
		this.parseStats();
	}

}
