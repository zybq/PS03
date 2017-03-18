package pkgException;

import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book ErrorBook;
	public BookException(Catalog cat, String id){
		super();
		this.ErrorBook = new Book();
		ErrorBook.setId(id);
	}
	
	public BookException(Book book){
		super();
		this.ErrorBook = book;
	}

	public Book getErrorBook() {
		return ErrorBook;
	}
	
	
}
