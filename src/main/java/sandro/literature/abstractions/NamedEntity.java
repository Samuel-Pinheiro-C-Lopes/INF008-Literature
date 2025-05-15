package sandro.literature.abstractions;

public abstract class NamedEntity<T> extends Entity<T> {
	private String name;

	protected NamedEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
