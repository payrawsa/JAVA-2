
import javax.swing.JOptionPane;

public class ex3main extends Thread {

	MTQue que = null;

	public ex3main(MTQue q) {
		que = q;
	}

	public void run() {
		

		String id = "";
		String playersname = "";
		String playersteam = "";
		String skill = "";
		String date = "";
		int integerId = 0;

		String command = "";

		while (true) {

			try {

				command = JOptionPane.showInputDialog("Enter a command: new or end").toLowerCase();

				switch (command) {

				case "new":

					// enter ID
					integerId = -1;
					int lengID = 0;
					while (integerId <= 0 || 21 <= integerId) {
						try {
							id = JOptionPane.showInputDialog("Enter a positive integer ID between 1 and 20");
							integerId = Integer.parseInt(id);
							lengID = id.length();
							for (int i = 0; i < (5 - lengID); i++) {
								id += " ";
							}
							if (integerId <= 0 || 21 <= integerId) {
								throw new NumberFormatException();
							}
						} catch (NullPointerException | NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error: You must enter a positive integer ID");
						}
					}

					// enter player's name
					playersname = JOptionPane.showInputDialog("what is the player's name?");

					if (playersname.length() > 26) {
						playersname = playersname.substring(0, 25);
					}

					int lengNam = playersname.length();
					for (int i = 0; i < (26 - lengNam); i++) {
						playersname += " ";
					}

					// enter player's team
					playersteam = JOptionPane.showInputDialog("what is the player's team name?");

					if (playersteam.length() > 26) {
						playersteam = playersteam.substring(0, 25);
					}

					int lengTeam = playersteam.length();
					for (int i = 0; i < (26 - lengTeam); i++) {
						playersteam += " ";
					}

					// enter player's skill level
					int intskill = -1;
					int lengSkill = 0;
					while (intskill < 0 || intskill > 99) {
						try {
							skill = JOptionPane
									.showInputDialog("What is the player's skill level? Enter and integer from 0-99");
							intskill = Integer.parseInt(skill);

							lengSkill = skill.length();
							for (int i = 0; i < (5 - lengSkill); i++) {
								skill += " ";
							}
							if (intskill < 0 || intskill > 99) {
								throw new NumberFormatException();
							}
						} catch (NullPointerException | NumberFormatException a) {
							JOptionPane.showMessageDialog(null, "Error: You must enter a proper skill level");
						}
					}

					// enter draft date
					date = JOptionPane.showInputDialog("Enter draft date in the format (25Jun2014)");
					int lengDate = date.length();
					while (lengDate != 9) {
						JOptionPane.showMessageDialog(null, "Error: You must enter a proper draft date");
						date = JOptionPane.showInputDialog("Enter draft date in the format (25Jun2014)");
						lengDate = date.length();
					}
					for (int i = 0; i < (9 - lengDate); i++) {
						date += " ";
					}

					// combine inputs
					String record = id + playersname + playersteam + skill + date;
					que.MTPut(record); // record 0
					System.out.println("Update is scheduled");

					break;

				case "end":

					JOptionPane.showMessageDialog(null, "Thank you!");
					System.exit(0);

					break;

				default:
					JOptionPane.showMessageDialog(null, "You must enter new or end");
					break;

				}

			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "You must enter new or end");
			}
		}

	}
}
