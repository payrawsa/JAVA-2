import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class exer2 {
	private static RandomAccessFile records;

	public static void main(String[] args) throws IOException {

		// String filelocation = JOptionPane.showInputDialog("Where would you
		// like to store the file?");
		// String filename = JOptionPane.showInputDialog("What would you like to
		// name the file?");

		// search or make file
		records = null;
		// try {
		// File file = new File(filelocation + "/" + filename);
		// records = new RandomAccessFile(file, "rw");
		// } catch (FileNotFoundException ex) {
		// try {
		// filename = "testcase";
		// File file = new File(filename);
		// records = new RandomAccessFile(file, "rw");
		// JOptionPane.showMessageDialog(null, "the file doesn't excist\ncreated
		// a new file name: \"" + filename
		// + "\"\nat /Users/kyotaro/Documents/workspace/exer2");
		// } catch (NullPointerException ex1) {
		// filename = "testcase";
		// JOptionPane.showMessageDialog(null, "create a new file name: \"" +
		// filename
		// + "\"\nat /Users/kyotaro/Documents/workspace/exer2");
		// File file = new File(filename);
		// records = new RandomAccessFile(file, "rw");
		// }
		// }

		while (true) {
			try {
				String filelocation = "C:\\Users\\payraw\\"
						+ JOptionPane.showInputDialog("Where would you like to store the file?");
				String filename = JOptionPane.showInputDialog("What would you like to name the file?");
				File file = new File(filelocation + "\\" + filename);
				records = new RandomAccessFile(file, "rw");
				break;
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid file location!");
			}
		}
		String Dummy = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		int answer = JOptionPane.showConfirmDialog(null,
				"Is this a new file? (Note: if selected Yes option, this will erase all previous entries in the file");
		System.out.println(answer);
		if (answer == 0) {
			for (int i = 0; i < 20; ++i) {
				records.writeUTF(Dummy); // Fill file with dummy records.
			}
		}
		// Enter Command
		String command = "";
		try {
			command = JOptionPane.showInputDialog("Enter a command: new, old, end").toLowerCase();
		} catch (NullPointerException ex1) {
			records.close();
			System.exit(0);
		}

		while (command.contains("new") == false && command.contains("old") == false
				&& command.contains("end") == false) {
			try {
				command = JOptionPane
						.showInputDialog("You have entered an incorrect command!\nEnter a command: new, old, end");
			} catch (NullPointerException ex1) {
				records.close();
				System.exit(0);
			}
			if ((command.contains("new") == true || command.contains("old") == true
					|| command.contains("end") == true)) {
				break;
			}
		}
		while (command.contains("new") == true || command.contains("old") == true || command.contains("end") == true) {
			if (command.contains("new") == true) {

				// enter ID
				int id=0;
				String integerid= "";
				while(true){
				try {
					integerid = JOptionPane.showInputDialog("enter a positive integer ID between 1 and 20");
					id = Integer.parseInt(integerid);

					while (id < 1 || id > 20) {
						JOptionPane.showMessageDialog(null, "Error: You must enter a proper integer");
						integerid = JOptionPane.showInputDialog("enter a positive integer ID between 1 and 20");
						id = Integer.parseInt(integerid);
					}

					int lengID = integerid.length();
					for (int i = 0; i < (5 - lengID); i++) {
						integerid = integerid + " ";
					}
					break;
				}

				catch (NullPointerException | NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "You must enter a proper value");
				}}

				// enter player's name
				String playersname = JOptionPane.showInputDialog("what is the player's name?");

				if (playersname.length() > 26) {
					playersname = playersname.substring(0, 25);
				}

				int lengNam = playersname.length();
				for (int i = 0; i < (26 - lengNam); i++) {
					playersname = playersname + " ";
				}

				// enter player's team
				String playersteam = JOptionPane.showInputDialog("what is the player's team name?");

				if (playersteam.length() > 26) {
					playersteam = playersteam.substring(0, 25);
				}

				int lengTeam = playersteam.length();
				for (int i = 0; i < (26 - lengTeam); i++) {
					playersteam = playersteam + " ";
				}
				int skills=0;
				String skill= "";
				while(true){
				try {

					skill = JOptionPane
							.showInputDialog("What is the player's skill level? Enter and integer from 0-99");
					 skills = Integer.parseInt(skill);
					while (skills < 0 || skills > 99) {
						JOptionPane.showMessageDialog(null, "Error: You must enter a proper skill level");
						skills = Integer.parseInt(JOptionPane.showInputDialog("enter a valid skill level(0-99)"));
					}

					// enter player's skill level
					int lengSkil = skill.length();
					for (int i = 0; i < (5 - lengSkil); i++) {
						skill = skill + " ";
					}
					break;
				}

				catch (NullPointerException | NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "You must enter a proper value");
				}
				}
				String date = JOptionPane.showInputDialog("Enter draft date in the format (25Jun2014)");
				int lengDate = date.length();
				for (int i = 0; i < (9 - lengDate); i++) {
					date = date + " ";
				}

				String record = integerid + playersname + playersteam + skill + date;
				records.seek(73 * (id - 1));
				records.writeUTF(record);

				try {
					command = JOptionPane.showInputDialog("Enter a command: new, old, end").toLowerCase();
				} catch (NullPointerException ex1) {
					records.close();
					System.exit(0);
				}

			} else if (command.contains("old") == true) {

				try {
					String integerid = JOptionPane
							.showInputDialog("Enter the positive integer ID of your player between 1 and 20");
					int id = Integer.parseInt(integerid);
					// while (id < 0 || id > 20) {
					// JOptionPane.showMessageDialog(null, "Error: You must
					// enter a proper integer");
					// integerid = JOptionPane.showInputDialog("enter a positive
					// integer ID between 1 and 20");
					// id = Integer.parseInt(integerid);
					// }

					records.seek((71 + 2) * (id - 1));
					String description = records.readUTF();
					System.out.println(description.length());
					if (description.contains(
							"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") == true) {
						description = Integer.toString(Integer.parseInt(integerid)) + " has yet to be filled";
						JOptionPane.showMessageDialog(null, description);

					} else {
						// show record as proper format
						String ID = "ID          : " + description.substring(0, 2) + "\n";
						String NA = "Player Name : " + description.substring(5, 31) + "\n";
						String TNA = "Team Name   : " + description.substring(31, 57) + "\n";
						String SKI = "Skill Level : " + description.substring(57, 62) + "\n";
						String DDA = "Draft Date  : " + description.substring(62, 71) + "\n";
						String out = ID + NA + TNA + SKI + DDA;
						JOptionPane.showMessageDialog(null, out);
					}

				} catch (EOFException | StringIndexOutOfBoundsException | NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: This ID doesn't exist");
				}

				try {
					command = JOptionPane.showInputDialog("Enter a command: new, old, end").toLowerCase();
				} catch (NullPointerException ex1) {
					records.close();
					System.exit(0);
				}

			} else {
				records.seek(0);
				int read = JOptionPane.showConfirmDialog(null, "Would you like to read all entries in the file?");
				String description = "";
				if (read == 0) {

					for (int i = 0; i < 20; i++) {
						records.seek((71 + 2) * (i));
						String apple = records.readUTF();
						if (apple.contains("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
							apple = Integer.toString(i + 1) + " has yet to be filled";
						}
						description = description + "\n" + apple;

					}

				}
				JOptionPane.showMessageDialog(null, description);
				records.close();
				break;
			}
		}
	}
}
