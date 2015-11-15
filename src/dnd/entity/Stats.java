package dnd.entity;

public class Stats {
	int _hp;
	int _str;
	int _dex;
	int _con;
	int _int;
	int _wis;
	int _cha;
	int _size;
	int _speed;
	
	public int removeHealth(int damage){
		_hp -= damage;
		if(_hp < 0){
			_hp = 0;
		}
		return _hp;
	}
	
	public void initStats(int hp, int str, int dex, int con, int intel, int wis, int cha, int size, int speed){
		_hp = hp;
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
		return _hp;
	}
}
