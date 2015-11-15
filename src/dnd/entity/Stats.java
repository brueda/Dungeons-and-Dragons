package src.dnd.entity;

public class Stats {
	int _maxHp;
	int _str;
	int _dex;
	int _con;
	int _int;
	int _wis;
	int _cha;
	int _size;
	int _speed;
	
	public void initStats(int maxHp, int str, int dex, int con, int intel, int wis, int cha, int size, int speed){
		_maxHp = maxHp;
		_str = str;
		_dex = dex;
		_con = con;
		_int = intel;
		_wis = wis;
		_cha = cha;
		_size = size;
		_speed = speed;
	}
	
	public int getStr(){
		return _str;
	}
	
	public int getDex(){
		return _dex;
	}
	
	public int getCon(){
		return _con;
	}
	
	public int getInt(){
		return _int;
	}
	
	public int getWis(){
		return _wis;
	}
	
	public int getCha(){
		return _cha;
	}
	
	public int getHP(){
		return _maxHp;
	}
}
