package sandro.literature;

import java.util.HashSet;

import sandro.literature.abstractions.MemberCollection;
import sandro.literature.Book;
import sandro.literature.Member;

// CURRENCTLY NOT IN USE
public class Recommendation extends MemberCollection implements Comparable<Recommendation>{
	private static Integer seqId = 0;
	private Book book;

	public Recommendation(Book book) {
		super();
		this.book = book;
	}

	public Book getBook() {
		return this.book;
	}

	@Override
	protected Integer nextId() {
		return this.seqId++;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Recommendation)
			return this.book.equals(o);
		return super.equals(o);
	}

	@Override
	public int compareTo(Recommendation recommendation) {
		return new Integer(this.sizeMembers()).compareTo(new Integer(recommendation.sizeMembers()));
	}
}
