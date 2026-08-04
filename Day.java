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
	public ArrayList<String> getArrayEvents() {
		return events;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int n) {
		num =n;
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