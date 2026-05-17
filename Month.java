import java.util.*;
class Month {
	private String name;
	private Day[][] days = new Day[5][7];
	
	public Month(String n) {
		name = n;
	}

	public void setDays() {
		Scanner input = new Scanner(System.in);

		
		int i = 0;
		int w = 0;
		int d = 0;
		
		System.out.println("\n***********\n");
		while (w < 5) {
			while (d < 7) {
				System.out.print("     Day " + (i + 1) + " >>> ");
				String event = input.nextLine();
				days[w][d] = new Day(event, i + 1);
				i++;
				d++;
			}
			d = 0;
			w++;
		}
		System.out.println("\n***********\n");
	}
	public void printDays() {
		String inv_on = "\u001B[7m";
        String inv_off = "\u001B[27m";
		int w = 0;
		int d = 0;
		int i = 0;
		System.out.println("\n\n\n" + "\u2588".repeat(2) + inv_on + name + inv_off + "\u2588".repeat(maxLineLength() - 2 - name.length()));
		while (w < 5) {
			System.out.print("\u2588 ");
			while (d < 7) {
				System.out.print(days[w][d].getEvents());
				System.out.print(" ".repeat(maxColLength(d % 7) - days[w][d].getEvents().length()));
				System.out.print(" \u2588 ");
				i++;
				d++;
			}
			System.out.print("\n");
			System.out.print("\u2588 ");
			d = 0;
			while (d < 7) {
				System.out.print(" ".repeat(days[w][d].getEvents().length()));
				System.out.print(" ".repeat(maxColLength(d % 7) - days[w][d].getEvents().length()));
				System.out.print(" \u2588 ");
				d++;
			}
			System.out.print("\n");
			System.out.println("\u2588".repeat(maxLineLength()));
			d = 0;
			w++;
		}
		System.out.print("\n\n\n");
	}
	public String getName() {
		return name;
	}
	public void addEvent(int x, String y) {
		days[x/7][x%7 - 1].addEvent(y);
	}
	public void removeEvents(int x) {
		days[x/7][x%7 - 1].removeEvents();
	}
	public int lineLength(int week) {
		int len = 1;
		int i = 0;
		while (i < 7) {
			len += 3 + days[week][i].getEvents().length() + maxColLength(i % 7) - days[week][i].getEvents().length(); 
			i++;
		}
		return len;
	}
	public int maxLineLength() {
		int maxLen = 0;
		int week = 0;
		while (week < 5) {
			int len = lineLength(week);
			if (len > maxLen) {
				maxLen = len;
			}
			week++;
		}
		return maxLen;
	}
	public int maxColLength(int day) {
		int week = 0;
		int maxLen = 0;
		while (week < 5) {
			int len = days[week][day].getEvents().length();
			if (len > maxLen) {
				maxLen = len;
			}
			week++;
		}
		return maxLen;
	}
}