package src.dnd.race;

import src.dnd.constants.DnDRaceConst;

public class Elf extends DnDRace{

	public Elf(){
		this._raceQuery = DnDRaceConst.QUERY_ELF;
		this._raceName = "Elf";
		this.constructJSON();
		this.parseStats();
	}
}
