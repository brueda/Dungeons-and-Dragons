package dnd.race;

import dnd.constants.DnDRaceConst;

public class HalfElf extends DnDRace{
	
	public HalfElf(){
		this._raceQuery = DnDRaceConst.QUERY_HALF_ELF;
		this._raceName = "Half-Elf";
		this.constructJSON();
		this.parseStats();
	}
}
