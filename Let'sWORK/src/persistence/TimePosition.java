package persistence;

public enum TimePosition {
	Morning(0, "Morning"),
	Noon(1, "Noon"),
	Afternoon(2, "Afternoon"),
	Evening(3, "Evening"),
	Night(4, "Night");
	
	private static TimePosition[] positions;
	static {
		positions = new TimePosition[5];
		positions[0] = Morning;
		positions[1] = Noon;
		positions[2] = Afternoon;
		positions[3] = Evening;
		positions[4] = Night;
	}
	
	public static TimePosition getPosition(int i) {
		TimePosition pos = null;
		if(i >= 0 && i < 5) {
			pos = TimePosition.positions[i];
		}
		return pos;
	}
	
	private int value;
	private String title;
	
	private TimePosition(int value, String title) {
		this.value = value;
		this.title = title;
	}
	
	public int getValue() {
		return value;
	}

	public String getTitle() {
		return title;
	}
}
