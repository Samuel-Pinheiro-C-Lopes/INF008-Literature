package sandro.literature;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Iterator;

import sandro.literature.abstractions.ReaderCollection;
import sandro.literature.Meeting;
import sandro.literature.Member;
import sandro.literature.Book;
import sandro.literature.Recommendation;

public class Club extends ReaderCollection {
	private HashMap<Book, HashSet<Member>> recommendations = new HashMap<Book, HashSet<Member>>();
	private PriorityQueue<Meeting> meetings = new PriorityQueue<Meeting>();

    public static void main(String[] args) { /* Check the ClubTest */ }

	public boolean addMeeting(Meeting meeting) {
		if (this.meetings.contains(meeting)) 
			return false;
		this.meetings.offer(meeting);
		return true;
	}

	public Iterator<Meeting> getMeetings() {
		return this.meetings.iterator();
	}

	public Meeting getMostRecentMeeting() {
		return this.meetings.peek();
	}

	public Book getMostRecommendedBook() {
		if (this.recommendations.size() == 0)
			return null;

		Iterator<Map.Entry<Book, HashSet<Member>>> iteratorRecommendations = this.recommendations.entrySet().iterator();
		Map.Entry<Book, HashSet<Member>> current = null;
		Map.Entry<Book, HashSet<Member>> mostRecommended = iteratorRecommendations.next();
		while (iteratorRecommendations.hasNext()) {
			current = iteratorRecommendations.next();
			if (current.getValue().size() > mostRecommended.getValue().size())
				mostRecommended = current;
		}

		return mostRecommended.getKey();
	}

	public void addRecommendation(Book book, Member member) {
		if (this.recommendations.containsKey(book)) {
			this.recommendations.get(book).add(member);
			return;
		}

		HashSet<Member> memberSet = new HashSet<Member>();
		memberSet.add(member);
		this.recommendations.put(book, memberSet);
	}

	@Override
	protected Integer nextId() {
		return 1;
	}


	// ---- Abandonned implementation of Recommendation class
	
	/*
	 
	private PriorityQueue<Recommendation> recommendations;

	public Book mostRecommendedBook () {
		return this.recommendations.peek().getBook();
	}

	public boolean addRecommendation(Recommendation recommendation) {
		if (this.recommendations.contains(recommendation)) 
			return false;
		else if (!this.hasBook(recommendation.getBook()))
			return false;

		this.recommendations.offer(recommendation);
		return true;
	}
	*/

}

