import java.util.*;

class med
{
	private String name;
	private int price;
	private int quantity;
	
	public med(String n,int p,int q)
	{
		name = n;
		price = p;
		quantity = q;

	}
	public void addQuantity(int q)
	{
		quantity+=q;
	}
	public void changePrice(int p)
	{
		price=p;
	}
	public String getName()
	{

		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public int getPrice()
	{
		return price;
	}
	public int buy(int n)
	{
		if(n > quantity)
			return -1;
		else
		{
			quantity-=n;
			return 1;
		}	
	}



}





public class medInv
{
	private static ArrayList<med> list;
	public medInv()
	{
		list = new ArrayList<med>();
	} 
	public static void main(String[] args)
	{		
		medInv mi = new medInv();
		Scanner reader = new Scanner(System.in);
		int n;
		String mname=null;
		int mq,mp;
		int total=0;
		int flag=0;
		int nm,flag1=0;
		
		char ch;



	do
	{
		System.out.println("Enter the mode ");
		System.out.println("1.Inventory mode");
		System.out.println("2.Purchase mode");
		System.out.println("3.View mode");		
		n=reader.nextInt();
		total=0;
		flag=0;
		switch(n)
		{
			case 1:
				System.out.println("Enter medicine name and quantity to add to the Inventory");
				System.out.println("Name :");
				mname = reader.next();
				System.out.println("Quantity :");
				mq = reader.nextInt();
				for(med temp : list)
				{
					if(temp.getName().equals(mname))
					{
						temp.addQuantity(mq);
						flag=1;
						break;
					}
				
				}
				if(flag==0)
				{
					System.out.println("Price for new one:");
					mp = reader.nextInt();
					med tmed = new med(mname,mp,mq);
					list.add(tmed);
				}		
				break;
			case 2:
				System.out.println("Enter number of types of medicine:");
				nm = reader.nextInt();
				for(int i=0;i<nm;i++)
				{
					flag1=0;
					System.out.println("Name:");
					mname=reader.next();
					System.out.println("Quantity:");
					mq=reader.nextInt();
					for(med temp1:list)
					{
						if(temp1.getName().equals(mname))
						{
							if(temp1.buy(mq)==-1)
								System.out.println("No enough stock");
							else
							{
								System.out.println("Purchased "+mname);
								total+=(temp1.getPrice()*mq);
							}
							flag1=1;			
				
						}
					
					}		
					if(flag1==0)
						System.out.println("Not in inventory");
				}
				System.out.println("Total price: "+total);
				break;
			case 3:
				System.out.println("Name		Quantity");
				for(med temp:list)
				{
					System.out.println(temp.getName()+"		"+temp.getQuantity());


				}
				break;
		}
		System.out.println("Continue(y/n)?");
		ch = reader.next().charAt(0);
		}
		while(ch =='y');
	}




}
