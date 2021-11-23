package ie.Lyit.Book;

import java.util.*;

public class Menu
{
	private int option;
	
	public Menu()
	{
		option = 0;
	}
	
	public void display()
	{
		System.out.println("\t\tBOOK MENU\n");
		System.out.println("\t1. ADD");
		System.out.println("\t2. list");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");
	}
	
	
	public void readOption()
	{
		Scanner KbInt = new Scanner (System.in);
		System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
		option = KbInt.nextInt();
	}
	
	public int getOption()
	{
		return option;
	}
}
