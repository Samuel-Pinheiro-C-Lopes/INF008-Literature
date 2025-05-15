package sandro.literature;

import sandro.literature.abstractions.NamedEntity;

public class Book extends NamedEntity<Integer> {
	private static Integer seqId = 0;

	public Book(String name) {
		super(name);
	}

	@Override
	protected Integer nextId() {
		return this.seqId++;
	}
}
