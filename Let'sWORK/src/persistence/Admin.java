package persistence;

public abstract class Admin extends UserRole {
	@Override
	public Right getRight() {
		return Right.ADMIN;
	}
}
