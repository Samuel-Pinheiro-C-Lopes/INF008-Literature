package sandro.literature;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Date;

import sandro.literature.abstractions.ReaderCollection;
import sandro.literature.Meeting;
import sandro.literature.Member;
import sandro.literature.Book;
import sandro.literature.Recommendation;
import sandro.literature.Club;

public class ClubTest {
	private Club club = null;

    @Test
    public void idsSeqShouldWork() {
		Club club1 = new Club();
		Club club2 = new Club();
		assertTrue(club1.getId() == club2.getId() && club2.getId() == 1, "Club must only have 1 as an id");

		Member m1 = new Member("Paul");
		Member m2 = new Member("August");
		Member m3 = new Member("Isabel");
		assertTrue(m1.getId() == 0 && m2.getId() == 1 && m3.getId() == 2,  "Members ids should increment properly");

		Book b1 = new Book("The most notorious murder of paris");
		Book b2 = new Book("Once Upon a Crime");
		Book b3 = new Book("The Worst Chase Scenario!");
		assertTrue(b1.getId() == 0 && b2.getId() == 1 && b3.getId() == 2, "Books ids should increment properly");

		Meeting mt1 = new Meeting("Hard Work", new Date(2003, 9, 20));
		Meeting mt2 = new Meeting("Marriage", new Date(2005, 10, 25));
		Meeting mt3 = new Meeting("Funny Jokes", new Date(2005, 11, 20));
		assertTrue(mt1.getId() == 0 && mt2.getId() == 1 && mt3.getId() == 2, "Meetings ids should increment properly");

		Recommendation r1 = new Recommendation(b1);
		Recommendation r2 = new Recommendation(b2);
		Recommendation r3 = new Recommendation(b3);
		assertTrue(r1.getId() == 0 && r2.getId() == 1 && r3.getId() == 2, "Recommendations ids should increment properly");
    }

	@Test 
	public void shouldAddNotIncludedMembers() {
		this.club = new Club();
		this.club.addMember(new Member("August"));
		this.club.addMember(new Member("Josielle"));
		this.club.addMember(new Member("Thrudd"));
		assertTrue(this.club.sizeMembers() == 3, "Number of members should be 3");

		Member m1 = new Member("Laura");
		Member m2 = m1;
		Member m3 = m2;
		this.club.addMember(m1);
		this.club.addMember(m2);
		this.club.addMember(m3);
		assertTrue(this.club.sizeMembers() == 4, "Number of members should be only 4");
		this.club = null;
	}

	@Test 
	public void shouldAddNotIncludedBook() {
		this.club = new Club();
		this.club.addBook(new Book("Battle"));
		this.club.addBook(new Book("War"));
		this.club.addBook(new Book("Death would be better"));
		assertTrue(this.club.sizeBooks() == 3, "Number of books should be 3");

		Book m1 = new Book("Not so great once it's done");
		Book m2 = m1;
		Book m3 = m2;
		this.club.addBook(m1);
		this.club.addBook(m2);
		this.club.addBook(m3);
		assertTrue(this.club.sizeBooks() == 4, "Number of books should be only 4");
		this.club = null;
	}

	@Test 
	public void shouldAddRecommendationAndGetTheMostRecommendedBook() {
		this.club = new Club();
	
		Book b1 = new Book("The most notorious murder of paris");
		Book b2 = new Book("Once Upon a Crime");
		Book b3 = new Book("The Worst Chase Scenario!");

		Member m1 = new Member("Paul");
		Member m2 = new Member("August");
		Member m3 = new Member("Isabel");

		this.club.addRecommendation(b1, m1);
		this.club.addRecommendation(b1, m2);
		this.club.addRecommendation(b2, m1);
		this.club.addRecommendation(b3, m3);
		this.club.addRecommendation(b3, m2);
		this.club.addRecommendation(b1, m3);
		this.club.addRecommendation(b3, m2);

		assertEquals(this.club.getMostRecommendedBook(), b1, "The most recommended book should be b1");
		this.club = null;
	}

	@Test
	public void shouldAddMeetingAndGetTheMostRecent() {
		this.club = new Club();

		Meeting mt1 = new Meeting("Hard Work", new Date(2003, 9, 20));
		Meeting mt2 = new Meeting("Marriage", new Date(2005, 10, 25));
		Meeting mt3 = new Meeting("Funny Jokes", new Date(2005, 11, 20));

		this.club.addMeeting(mt1);
		this.club.addMeeting(mt2);
		this.club.addMeeting(mt3);

		assertEquals(this.club.getMostRecentMeeting(), mt3, "The most recent should be the head of the queue");
		this.club = null;
	}
}
