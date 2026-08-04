import java.util.*;
import java.io.File;
import java.io.PrintWriter;
class CalPal {
	public static void main(String args[]) throws Exception {
		Scanner input = new Scanner(System.in);

		boolean guest = false;

		Month month1 = null;
		ArrayList<Month> months = new ArrayList<>();
		ArrayList<RecurringEvent> recurr = new ArrayList<>();

		
		
		System.out.print("**USERNAME: ");
		String un = input.nextLine();
		String fileName = un + ".txt";
		File userFile = new File(fileName);
		while (!userFile.exists() && !un.equals("guest")) {
			System.out.println("Error: USERNAME DOES NOT EXIST");
			System.out.print("**USERNAME: ");
			un = input.nextLine();
			fileName = un + ".txt";
			userFile = new File(fileName);
		}

		String pw = "";
		
		if (un.equals("guest")) {
			guest = true;
		} else {
			System.out.print("**PASSWORD: ");
			pw = input.nextLine();
		}
		

		if (!guest) {
			Scanner fileReader = new Scanner(userFile);
			String savedPassword = fileReader.nextLine();
			while (!pw.equals(savedPassword)) {
				System.out.println("Error: INCORRECT PASSWORD");
				System.out.print("**PASSWORD: ");
				pw = input.nextLine();
			}
			System.out.println("Login successful");

			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] pieces = line.split(":");
				
				if (pieces[0].equals("MONTH")) {
					String monthName = pieces[1];
					int firstM = Integer.parseInt(pieces[2]);
					int totalDays1 = Integer.parseInt(pieces[3]);

					month1 = new Month(monthName, firstM, totalDays1);
					month1.setDays();
					months.add(month1);
				} else if (pieces[0].equals("EVENT")) {
					int day = Integer.parseInt(pieces[1]);
					String title = pieces[2];
					month1.addEvent(day, title);
				} else if (pieces[0].equals("RECURRING")) {
					int day = Integer.parseInt(pieces[1]);
					int times = Integer.parseInt(pieces[2]);
					String desc = pieces[3];
					RecurringEvent r1 = new RecurringEvent(day, times, desc, month1);
					recurr.add(r1);
				}				
			}
			fileReader.close();
			
		}


		
		String inv_on = "\u001B[7m";
        String inv_off = "\u001B[27m";

	

		

		if (guest) {
			System.out.println("\nWelcome guest. Your data will not be stored. Please enter your first month.");
			System.out.print("     Month name:  ");
			String actionA = input.nextLine();
			System.out.print("     Date of first monday:  ");
			int actionB = input.nextInt();
			input.nextLine();
			System.out.print("     Days in the month:	");
			int actionC = input.nextInt();
			input.nextLine();
			month1 = new Month(actionA, actionB, actionC);
			month1.setDays();
			months.add(month1);
		}

		boolean active = true;
		
		while (active) {
			month1.printDays();
			System.out.println(" " + "\u2581".repeat(93));
			System.out.println("\u2595 Add Event ............... 1  \u2591  Add Recurring Event ..... 4  \u2591  Change Selected Month ... 6 \u258E");
			System.out.println("\u2595 Remove Events ........... 2  \u2591  View Recurring Events ... 5  \u2591  Create New Month ........ 7 \u258E");
			System.out.println("\u2595 Add Event to Free-est ... 3  \u2591                               \u2591  View Month List ......... 8 \u258E");
			System.out.print("\u2595" + inv_on + " QUIT... 9   SAVE & EXIT.. 0 " + inv_off);
			System.out.print("\u2594".repeat(64));
	
			System.out.print("\n\n>>>  ");
			String action = input.nextLine();
			if (action.equals("7")) {
				System.out.print("     Month Name:  ");
				String action1 = input.nextLine();
				System.out.print("     Date of First Monday:  ");
				int action2 = input.nextInt();
				input.nextLine();
				System.out.print("     Days in the month:	");
				int action3 = input.nextInt();
				input.nextLine();
				month1 = new Month(action1, action2, action3);
				month1.setDays();
				months.add(month1);
			} else if (action.equals("8")) {
				int i = 0;
				while (i < months.size()) {
				System.out.println("    " + inv_on + " " + i + ": " + months.get(i).getName() + " " + inv_off);
					i++;
				}
			} else if (action.equals("6")) {
				System.out.print("     To: ");
				int action2 = input.nextInt();
				input.nextLine();
				month1 = months.get(action2);
			} else if (action.equals("1")) {
				System.out.print("     What: ");
				String action1 = input.nextLine();
				System.out.print("     To: ");
				int action2 = input.nextInt();
				input.nextLine();
				month1.addEvent(action2, action1);
			} else if (action.equals("2")) {
				System.out.print("     From: ");
				int action2 = input.nextInt();
				input.nextLine();
				month1.removeEvents(action2);
			} else if (action.equals("3")) {
				System.out.print("     What: ");
				String action1 = input.nextLine();
				month1.addEvent(month1.getFreeestDay(), action1);
			} else if (action.equals("4")) {
				System.out.print("     What: ");
				String action1 = input.nextLine();
				System.out.print("     To: ");
				int action2 = input.nextInt();
				input.nextLine();
				System.out.print("     This many weeks: ");
				int action3 = input.nextInt();
				input.nextLine();
				RecurringEvent r1 = new RecurringEvent(action2, action3, action1, month1);
				recurr.add(r1);
			} else if (action.equals("5")) {
				int i = 0;
				while (!recurr.isEmpty() && i < recurr.size()) {
				System.out.println("    " + inv_on + " " + i + ": " + recurr.get(i).getDesc() + " " + inv_off);
					i++;
				}
			} else if (action.equals("liam")) {
				
				int l = 0;
				while (l < 33) {
					month1.addEvent(month1.getFreeestDay(), "CalPal");
					month1.printDays();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
					l++;
				}
				
				active = false;
			} else if (action.equals("9")) {
				active = false;
			} else if (action.equals("0")) {
				if (!guest) {
					PrintWriter writer = new PrintWriter(userFile);
					writer.println(pw);

					for (Month m: months) {
						writer.println("MONTH:" + m.getName() + ":" + m.getFirstM() + ":" + m.getTotalDays());
						Day[][] grid = m.getDaysArray();

						for (int r = 0; r < 6; r++) {
							for (int c = 0; c < 7; c++) {
								Day currentDay = grid[r][c];

								if (currentDay != null && currentDay.getNum() >= 1 && currentDay.getNum() <= m.getTotalDays()) {
									for (String eventText : currentDay.getArrayEvents()) {
										boolean isRecurring = false;

										for (RecurringEvent rEvent: recurr) {
											if (eventText.equals(rEvent.getDesc())) {

												int checkDay = rEvent.getTo();
												int weeksLeft = rEvent.getTimes();
												while (weeksLeft > 0) {
													if (currentDay.getNum() == checkDay) {
														isRecurring = true;
													}
													checkDay += 7;
													weeksLeft--;
												}
											}
										}

										if (!isRecurring) {
											writer.println("EVENT:" + currentDay.getNum() + ":" + eventText);
										} 
									}
								}
							}
						}
						for (RecurringEvent rEvent : recurr) {
							if (rEvent.getMonth().equals(m)) {
								writer.println("RECURRING:" + rEvent.getTo() + ":" + rEvent.getTimes() + ":" + rEvent.getDesc());
							}
						}
					}

					writer.close();
					System.out.println("Success: Data saved to " + fileName);
				}

				active = false;
			}
			
		}
	}
}