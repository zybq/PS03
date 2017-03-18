package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import pkgException.BookException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	

	@XmlElement(name="book")
	ArrayList<Book> books;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Book getBook(String id){
		try{
		for(Book b : this.getBooks()){
			if(b.getId().equals(id)){
				return b;
			}
		}
		throw new BookException(this, id);
		}
		catch (BookException be){
			System.out.println("could not find matching book with ID: " + id);
		}
		catch (Exception ex){
			throw ex;
		}
		return null;
	}

	public void addBook(String id, Book book){
		try{ 
			for (Book b: this.getBooks()){
				if(b.getId().equals(id)){
					throw new BookException(this, id);
				}
			}
			this.getBooks().add(book);
			
		}
		catch (BookException be){
			System.out.println(be.getErrorBook().getId() + " could not be added due to another book containing the same ID.");
		}
		catch (Exception ex){
			throw ex;
		}
	}

}
