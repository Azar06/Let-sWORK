package persistence;

public interface Savable {
	public abstract void save() throws SaveException;
}
