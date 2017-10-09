import javax.swing.JOptionPane;
import java.io.*;

public class update {
	public static void main(String[] args) throws IOException {
		RandomAccessFile records = null;
		while (true) {
			try {
				String filelocation = "C:\\" + "Users\\" + "payraw\\"
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
		String command = JOptionPane.showInputDialog("Enter a command: new or end").toLowerCase();
		;

		while (command.contains("new") == false && command.contains("end") == false) {
			command = JOptionPane.showInputDialog("You have entered an incorrect command! Enter a command: new or end");
			if ((command.contains("new") == true || command.contains("end") == true)) {
				break;
			}
		}
		while (command.contains("new") == true || command.contains("end") == true) {
			while (command.contains("new") == false && command.contains("end") == false) {
				command = JOptionPane
						.showInputDialog("You have entered an incorrect command! Enter a command: new or end");
				if ((command.contains("new") == true || command.contains("end") == true)) {
					continue;
				}
			}
			if (command.contains("new") == true) {
				try {
					String integerid = JOptionPane.showInputDialog("enter a positive integer ID between 1 and 20");
					int id = Integer.parseInt(integerid);
					if (id < 0 || id > 20) {
						throw new NumberFormatException();
					}
					for (int i = 0; i < (5 - integerid.length()); i++) {
						integerid = integerid + " ";
					}
					System.out.println(integerid);
					String playersname = JOptionPane.showInputDialog("what is the player's name?");
					if (playersname.length() > 26) {
						playersname = playersname.substring(0, 25);
					}
					for (int i = 0; i < (26 - playersname.length()); i++) {
						playersname = playersname + " ";
					}

					System.out.println(playersname);
					String playersteam = JOptionPane.showInputDialog("what is the player's team name?");
					if (playersteam.length() > 26) {
						playersteam = playersteam.substring(0, 25);
					}
					for (int i = 0; i < (26 - playersteam.length()); i++) {
						playersteam = playersteam + " ";
					}
					System.out.println(playersteam);
					String skill = JOptionPane
							.showInputDialog("What is the player's skill level? Enter and integer from 0-99");
					int skills = Integer.parseInt(skill);
					if (skills < 0 || skills > 99) {
						throw new NumberFormatException();
					}
					for (int i = 0; i < (5 - skill.length()); i++) {
						skill = skill + " ";
					}
					System.out.println(skill);
					String date = JOptionPane.showInputDialog("Enter today's date in the format 25Jun2014");
					for (int i = 0; i < (9 - date.length()); i++) {
						date = date + " ";
					}
					System.out.println(date);
					String record = integerid + playersname + playersteam + skill + date;
					System.out.println(record.lastIndexOf("4"));
					records.seek(73 * (id - 1));
					records.writeUTF(record);
					command = JOptionPane.showInputDialog("Enter a command: new, old, end");
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null,
							"You must enter a proper integer within the range!!! Start over...");
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
