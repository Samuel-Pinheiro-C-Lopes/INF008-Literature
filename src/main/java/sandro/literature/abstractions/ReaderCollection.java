package sandro.literature.abstractions;

import java.util.HashSet;
import java.util.Iterator;

import sandro.literature.Book;

public abstract class ReaderCollection extends MemberCollection {
	private HashSet<Book> books;

	protected ReaderCollection() {
		super();
		this.books = new HashSet<Book>();
	}

	public boolean addBook(Book book) {
		if (this.books.contains(book))
			return false;
		this.books.add(book);
		return true;
	}

	public Iterator<Book> getBooks() {
		return this.books.iterator();
	}

	public int sizeBooks() {
		return this.books.size();
	}
	
	public void clear() {
		this.books.clear();
	}

	public boolean hasBook(Book book) {
		return this.books.contains(book);
	}

}
