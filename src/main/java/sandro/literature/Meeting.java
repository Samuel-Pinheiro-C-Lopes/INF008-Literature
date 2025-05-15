package sandro.literature;

import java.util.Date;

import sandro.literature.abstractions.ReaderCollection;

public class Meeting extends ReaderCollection implements Comparable<Meeting>{
	private static Integer seqId = 0;
	private String theme;
	private Date date;

	public Meeting(String theme, Date date) {
		super();
		this.theme = theme;
		this.date = date;
	}

	public String getTheme() {
		return this.theme;
	}

	public Date getDate() {
		return this.date;
	}

	@Override
	protected Integer nextId() {
		return this.seqId++;
	}

	@Override
	public int compareTo(Meeting meeting) {
		return meeting.getDate().compareTo(this.getDate());
	}
}
