package ie.Lyit.Serialze;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import ie.Lyit.Book.*;

public class BookSerialze 
{
	private ArrayList<Book> books;
	private final String FILENAME = "books.ser";
	
	public BookSerialze()
	{
		books = new ArrayList<Book>();
	}
	
	public void add()
	{
		Book book = new Book();
		book.read();
		books.add(book);
	}
	
	public void list()
	{
		for(Book tmpBook: books)
			System.out.println(tmpBook);
	}
	
	public Book view()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Library Number of Book : ");
		int bookToView = keyboard.nextInt();
		
		for (Book tmpBook:books)
		{
			if (tmpBook.getLibraryNumber() == bookToView)
			{
				System.out.print(tmpBook);
				return tmpBook;
			}
		}
		
		return null;
	}
	
	public void edit()
	{
		Book EditBook = view();
		
		if (EditBook != null)
		{
			int index = books.indexOf(EditBook);
			EditBook.read();
			books.set(index, EditBook);
		}
	}
	
	public void delete()
	{
		Book DeleteBook = view();
		
		if (DeleteBook != null)
		{
			books.remove(DeleteBook);
		}
	}
	
	public void serializeBooks()
	{
		try 
		{
		FileOutputStream fileStream = new FileOutputStream(FILENAME);
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		os.writeObject(books);
		os.close();
		}
		catch(FileNotFoundException fnFE)
		{
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	public void deserializeBooks()
	{
		try
		{
			FileInputStream fileStream = new FileInputStream(FILENAME);
			ObjectInputStream os = new ObjectInputStream(fileStream);
			
			//Book books = (Book)os.readObject();
			books = (ArrayList<Book>)os.readObject();
			os.close();
			
			}
			catch(FileNotFoundException fnFE)
			{
				System.out.println("Cannot create file " + FILENAME + ".");
			}
			catch(IOException ioE)
			{
			System.out.println(ioE.getMessage());
			}
			catch(ClassNotFoundException cNF)
			{
				System.out.println("Unknown");
			}

	}
	
}
