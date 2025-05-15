package sandro.literature;

import sandro.literature.abstractions.NamedEntity;

public class Member extends NamedEntity<Integer> {
	protected static Integer seqId = 0;

	public Member(String name) {
		super(name);
	}

	@Override
	protected Integer nextId() {
		return this.seqId++;
	}
}
