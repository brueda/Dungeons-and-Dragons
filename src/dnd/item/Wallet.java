package dnd.item;

public class Wallet {
	final int WEIGHT_MOD = 10; // every 10 coins is 1lb
	final int DENOM = 100; //denomination per piece
	int _weight;
	int _gold;
	int _silver;
	int _copper;
	
	private void addGold(int gold){
		_gold += gold;
	}
	
	private void addSilver(int silver){
		if(silver + _silver > DENOM-1){
			int gold = (silver + _silver) / DENOM;
			addGold(gold);
			_silver = (silver + _silver) - gold*DENOM;
		}else{
			_silver += silver;
		}
	}
	
	private void addCopper(int copper){
		if(copper + _copper > DENOM-1){
			int silver = (copper + _copper) / DENOM;
			addSilver(silver);
			_copper = (copper + _copper) - silver*DENOM;
		}else{
			_copper += copper;
		}
	}
	
	private void subGold(int gold){
		_gold -= gold;
	}
	
	private void subSilver(int silver){
		if(silver>_silver){
			subGold(1);
			_silver = _silver + DENOM;
		}
		_silver -= silver;
	}
	
	private void subCopper(int copper){
		if(copper>_copper){
			subSilver(1);
			_copper = _copper + DENOM;
		}
		_copper -= copper;
	}
	
	private int getTotalWorth(){
		return _gold*(DENOM*DENOM) + _silver*DENOM + _copper;
	}
	
	public int getTotalWeight(){
		return getTotalWorth() / WEIGHT_MOD;
	}
	
	public void addCurrency(int[] currency){
		addCopper(currency[0]);
		addSilver(currency[1]);
		addGold(currency[2]);
	}
	
	public void subCurrency(int[] currency){
		if(getTotalWorth() < (currency[2]*(DENOM*DENOM)) + (currency[1]*DENOM) + currency[0]) {
			System.out.println("Not enough currency");
			return;
		}
		subGold(currency[2]);
		subSilver(currency[1]);
		subCopper(currency[0]);
	}
	
	public void printStats(){
		System.out.println("Gold = " + _gold + "\nSilver = " + _silver + "\nCopper = " + _copper);
		System.out.println("Total Worth in Copper = " + getTotalWorth());
		System.out.println("Total Weight = " + getTotalWeight() + " lbs");
	}
	
}