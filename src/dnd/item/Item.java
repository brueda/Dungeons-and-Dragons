package src.dnd.item;

public class Item {
	String _name;
	String _desc;
	
	int _value;
	int _weight;
	
	public void setName(String name){
		_name = name;
	}
	
	public void setDesc(String desc){
		_desc = desc;
	}
	
	public void setValue(int value){
		_value = value;
	}
	
	public void setWeight(int weight){
		_weight = weight;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getDesc(){
		return _desc;
	}
	
	public int getValue(){
		return _value;
	}
	
	public int getWeight(){
		return _weight;
	}
}
