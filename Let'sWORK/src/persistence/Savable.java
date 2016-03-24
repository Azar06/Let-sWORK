package persistence;

import persistence.exception.SaveException;

public interface Savable {
	public abstract void save() throws SaveException;
}
