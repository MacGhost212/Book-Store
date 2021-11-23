package ie.Lyit.Testers;
import ie.Lyit.Book.*;
import ie.Lyit.Serialze.*;

public class BookSerializerTester 
{
	public static void main(String[] args)
	{
		BookSerialze bookSerialze = new BookSerialze();
		
		bookSerialze.deserializeBooks();

		Menu menuObj = new Menu();
		
		do
		{
			menuObj.display();
			menuObj.readOption();
			switch(menuObj.getOption())
			{
			case 1 : bookSerialze.add();
			break;
			
			case 2 : bookSerialze.list();
			break;
			
			case 3 : bookSerialze.view();
			break;
			
			case 4 : bookSerialze.edit();
			break;
			
			case 5 : bookSerialze.delete();
			break;
			
			case 6 : break;
			default: System.out.println("Inval ID option ...");
			}
		}
		while(menuObj.getOption() !=6);
		
		bookSerialze.serializeBooks();
	}

}
