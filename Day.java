import java.util.*;
class Day {
	private ArrayList<String> events = new ArrayList<>();
	private int num = 0;
	public Day(String ev, int n) {
		if (!ev.equals("")) {
			events.add(ev);
		}
		num = n;
	} 
	public String getEvents() {
		String output = "";
		int i = 0;
		while (i < events.size()) {
			output = output + events.get(i);
			if (i < events.size() - 1) {
				output += ", ";
			}
			i++;
		}
		return num + ": " + output;
	}
	public int getNum() {
		return num;
	}
	public void addEvent(String x) {
		if (!x.equals("")) {
			events.add(x);
		}
	}
	public void removeEvents() {
		events.clear();
	}
}