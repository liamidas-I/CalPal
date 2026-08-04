import java.util.*;
class Month {
	private String name;
	private Day[][] days = new Day[6][7];
	private int start = 0;
	private int totalDays;
	
	public Month(String n, int i, int i2) {
		name = n;
		start = i - 7;
		totalDays = i2;
	}

	public void setDays() {
		Scanner input = new Scanner(System.in);

		
		int i = start;
		int w = 0;
		int d = 0;
		int j = 1;
	
		while (w < 6) {
			while (d < 7) {
				if (i < 1) {
					days[w][d] = new Day("", i);
					i++;
					d++;
				} else if (j > totalDays) {
					days[w][d] = new Day("", i);
					i++;
					d++;
				} else {
					days[w][d] = new Day("", j);
					i++;
					d++;
					j++;
				}
			}
			d = 0;
			w++;
		}

	}
	public void printDays() {
		String inv_on = "\u001B[7m";
        String inv_off = "\u001B[27m";
		int w = 0;
		int d = 0;
		int i = start;
		int o = start;
		int j = 0;
		System.out.println("\n\n" + "\u2588".repeat(2) + inv_on + name + inv_off + "\u2588".repeat(maxLineLength() - 2 - name.length()));
		while (w < 6) {
			System.out.print("\u2588");
			while (d < 7) {
				if (i < 1) {
					System.out.print("\u2588".repeat(maxColLength(d % 7) + 3));
					i++;
					d++;
				} else if (j >= totalDays) {
					System.out.print("\u2588".repeat(maxColLength(d % 7) + 3));
					i++;
					d++;
				} else {
					System.out.print(" " + days[w][d].getEvents());
					System.out.print(" ".repeat(maxColLength(d % 7) - days[w][d].getEvents().length()));
					System.out.print(" \u2588");
					i++;
					d++;
					j++;
				}
			}
			System.out.print("\n");
			System.out.print("\u2588");
			if (o < 1) {
				System.out.print("\u2588");
			}
			d = 0;
			while (d < 7) {
				if (o < 1 || o > totalDays) {
					System.out.print("\u2588".repeat(days[w][d].getEvents().length()));
					System.out.print("\u2588".repeat(maxColLength(d % 7) - days[w][d].getEvents().length()));
					System.out.print("\u2588\u2588");
					if (o != 0) {
						System.out.print("\u2588");
					}
					d++;
					o++;
				} else {
					System.out.print(" ".repeat(days[w][d].getEvents().length() + 1));
					System.out.print(" ".repeat(maxColLength(d % 7) - days[w][d].getEvents().length()));
					System.out.print(" \u2588");
					d++;
					o++;
				}
			}
			System.out.print("\n");
			System.out.println("\u2588".repeat(maxLineLength()));
			d = 0;
			w++;
		}
		System.out.print("\n\n");
	}
	public String getName() {
		return name;
	}
	public void setName(String s) {
		name = s;
	}
	public void addEvent(int x, String y) {
		int offset = (Math.abs(start) + x);
		days[offset/7][offset%7].addEvent(y);
	}
	public void removeEvents(int x) {
		int offset = (Math.abs(start) + x);
		days[offset/7][offset%7].removeEvents();
		
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
		for (int week = 0; week < 6; week++) {
			int len = lineLength(week);
			if (len > maxLen) {
				maxLen = len;
			}
		}
		return maxLen;
	}
	public int maxColLength(int day) {
		int maxLen = 0;
		for (Day[] week : days) {
			if (week[day] != null) {
				int len = week[day].getEvents().length();
				if (len > maxLen) {
					maxLen = len;
				}
			}
		}
		return maxLen;
	}
	public int getFirstM() {
		return start + 7;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public Day[][] getDaysArray() {
		return days;
	}
	public int getFreeestDay() {
		int x = 1;
		int maxGap = 0;
		int maxGapIndex = 1;
		int gap = 0;
		int gapIndex = 1;
		while (x <= totalDays) {
			if (days[(x - start)/7][(x - start)%7].getArrayEvents() == null || days[(x - start)/7][(x - start)%7].getArrayEvents().size() == 0) {
				if (gap == 0) {
					gapIndex = x;
				}
				gap++;
			} else {
				if (gap > maxGap) {
					maxGap = gap;
					maxGapIndex = gapIndex;
				}
				gap = 0;
			}
			x++;
			
		}
		if (gap > maxGap) {
			maxGap = gap;
			maxGapIndex = gapIndex;
		}
		if (maxGap == 0) {
			return (int) (Math.random() * totalDays) + 1;
		}
		int randFreeDay = (int) (Math.random() * maxGap) + maxGapIndex;
		return randFreeDay;
	}
}