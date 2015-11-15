package dnd.sheet;

import dnd.entity.Stats;

public class EnemySheet {

	private String _name;
	private Stats _stats;
	private int _gold;
	private int _exp;
	
	public EnemySheet() {
		_name = "";
		_gold = 0;
		_exp = 1;
	}

	public String get_name() {
		return _name;
	}

	public Stats get_stats() {
		return _stats;
	}

	public int get_gold() {
		return _gold;
	}

	public int get_exp() {
		return _exp;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public void set_stats(Stats _stats) {
		this._stats = _stats;
	}

	public void set_gold(int _gold) {
		this._gold = _gold;
	}

	public void set_exp(int _exp) {
		this._exp = _exp;
	}

}
