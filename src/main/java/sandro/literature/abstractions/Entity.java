package sandro.literature.abstractions;

public abstract class Entity<T> {
	private final T id;

	public Entity() {
		this.id = this.nextId();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Entity)
			return this.id == ((Entity) o).id;
		return super.equals(o);
	}

	protected abstract T nextId();

	public T getId() {
		return this.id;
	}
}
