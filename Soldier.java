package flyweight;

public class Soldier 
{
	Dress dress;
	Kit kit;
	int id;
	
	public Soldier(int id)
	{
		this.id=id;
	}
	public void setDress(Dress dress)
	{
		this.dress=dress;
	}
	public void setKit(Kit kit)
	{
		this.kit=kit;
	}
}