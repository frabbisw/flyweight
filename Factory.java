package flyweight;

import java.awt.Color;

public class Factory 
{
	Kit kit=null;
	Dress dress=null;
	int made=0;
	public Factory()
	{
		this.kit=new Kit(Color.DARK_GRAY,5,"A");
		this.dress=new Dress(Color.DARK_GRAY,40,"X");
	}
	
	public Soldier getNewSoldierDefault()
	{
		Soldier soldier = new Soldier(made++);
		kit=new Kit(Color.DARK_GRAY,5,"A");
		dress=new Dress(Color.DARK_GRAY,40,"X");
		
		soldier.setDress(dress);
		soldier.setKit(kit);
		return soldier;
	}
	public Soldier getNewSoldierFlyWeight()
	{
		Soldier soldier = new Soldier(made++);
		soldier.setDress(dress);
		soldier.setKit(kit);
		return soldier;
	}
}
