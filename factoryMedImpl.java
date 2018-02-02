interface Medicine
{
	String getName();
	int getQuantity();
	int getPrice();
	void addQuantity(int q);


}

abstract class MedClass implements Medicine
{
	private int quantity;
	private int price;
	public MedClass(int p,int q)
	{
		price=p;
		quantity=q;

	}


	abstract public String getName();
	public int getQuantity(){ return quantity;}
	public int getPrice(){ return price;}
	public void addQuantity(int q){ quantity+=q;}
 

}
class abc extends MedClass
{

	public abc(int p,int q){super(p,q);}

	public String getName(){ return "abc";}
 

}
class pqr extends MedClass
{
	public pqr(int p,int q){super(p,q);}
	public String getName(){ return "pqr";}
 

}
class MedicineFactory
{
	public static MedClass getMedicine(String name,int p,int q)
	{
		if("abc".equalsIgnoreCase(name))
		{
			return new abc(p,q);
		}
		else if("pqr".equalsIgnoreCase(name))
		{
			return new pqr(p,q);
		}
		else
			return null;


	}


}

public class factoryMedImpl
{
	public static void main(String[] args)
	{
		MedClass m1 = MedicineFactory.getMedicine("abc",50,2);
		MedClass m2 = MedicineFactory.getMedicine("pqr",100,3);
		System.out.println("Medicine 1:"+m1.getName());
		System.out.println("Medicine 2:"+m2.getName());

	}

}

