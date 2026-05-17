import java.util.*;
class CalPal {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);


		System.out.print("USERNAME: ");
		String un = input.nextLine();
		System.out.print("PASSWORD: ");
		String pw = input.nextLine();

		Month month1 = null;
		ArrayList<Month> months = new ArrayList<>();

		System.out.print("     Name:  ");
		String action0 = input.nextLine();
		month1 = new Month(action0);
		month1.setDays();
		months.add(month1);
		
		while (true) {
			month1.printDays();
			System.out.print("\n\n\n>>>  ");
			String action = input.nextLine();
			if (action.equals("new month")) {
				System.out.print("     Name:  ");
				String action1 = input.nextLine();
				month1 = new Month(action1);
				month1.setDays();
				months.add(month1);
			} else if (action.equals("view month")) {
				month1.printDays();
			} else if (action.equals("view months")) {
				int i = 0;
				while (i < months.size()) {
					System.out.println("     " + i + ": " + months.get(i).getName());
					i++;
				}
			} else if (action.equals("change month")) {
				System.out.print("     To: ");
				int action2 = input.nextInt();
				input.nextLine();

				month1 = months.get(action2);
			} else if (action.equals("add event")) {
				System.out.print("     What: ");
				String action1 = input.nextLine();
				System.out.print("     To: ");
				int action2 = input.nextInt();
				input.nextLine();
				month1.addEvent(action2, action1);
			} else if (action.equals("remove events")) {
				System.out.print("     From: ");
				int action2 = input.nextInt();
				input.nextLine();
				month1.removeEvents(action2);
				
			}
		}
	}
}