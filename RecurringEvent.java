class RecurringEvent {
	private int[] data = new int[2];
	private int[] dataInit = new int[2];
	private String description;
	private Month month1;
	public RecurringEvent(int i, int i2, String desc, Month m) {
		data[0] = i;
		dataInit[0] = i;
		data[1] = i2;
		dataInit[1] = i2;
		description = desc;
		month1 = m;
		addEvents();
	}
	private void addEvents() {
		while (data[1] > 0) {
			month1.addEvent(data[0], description);
			data[0] += 7;
			data[1]--;
		}
	}
	public int getTo() {
		return dataInit[0];
	}
	public int getTimes() {
		return dataInit[1];
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String s) {
		description = s;
	}
	public Month getMonth() {
		return month1;
	}
}