package sandro.literature.abstractions;

import sandro.literature.abstractions.Entity;
import java.util.HashSet;
import java.util.Iterator;

import sandro.literature.Member;

public abstract class MemberCollection extends Entity<Integer> {
	private HashSet<Member> members;

	protected MemberCollection() {
		super();
		this.members = new HashSet<Member>();
	}

	public boolean addMember(Member member) {
		if (this.members.contains(member))
			return false;
		this.members.add(member);
		return true;
	}

	public Iterator<Member> getMembers() {
		return this.members.iterator();
	}

	public int sizeMembers() {
		return this.members.size();
	}

	public boolean hasMember(Member member) {
		return this.members.contains(member);
	}

	public void clear() {
		this.members.clear();
	}
}
