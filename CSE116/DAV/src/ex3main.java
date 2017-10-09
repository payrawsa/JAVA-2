import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ex3main {
	public static String record;
	public static String command;
	public static RandomAccessFile file;

	public static void main(String[] args) throws IOException, InterruptedException {
		MTQue que = new MTQue();	
		UpdateThread update = new UpdateThread(que.MTGet());
		update.start();
		update.join();
		file=update.getRecords();
		try {
			command = JOptionPane.showInputDialog("Enter a command: new or end").toLowerCase();
		} catch (NullPointerException ex1) {

		}

		while (command.contains("new") == false && command.contains("end") == false) {
			try {
				command = JOptionPane
						.showInputDialog("You have entered an incorrect command!\nEnter a command: new or end");
			} catch (NullPointerException ex1) {

			}
			if ((command.contains("new") == true || command.contains("end") == true)) {
				break;
			}
		}
		while (command.contains("new") == true || command.contains("end") == true) {
			if (command.contains("new") == true) {

				int id = 0;
				String integerid = "";
				while (true) {
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
					}
				}

				String playersname = JOptionPane.showInputDialog("what is the player's name?");

				if (playersname.length() > 26) {
					playersname = playersname.substring(0, 25);
				}

				int lengNam = playersname.length();
				for (int i = 0; i < (26 - lengNam); i++) {
					playersname = playersname + " ";
				}

				String playersteam = JOptionPane.showInputDialog("what is the player's team name?");

				if (playersteam.length() > 26) {
					playersteam = playersteam.substring(0, 25);
				}

				int lengTeam = playersteam.length();
				for (int i = 0; i < (26 - lengTeam); i++) {
					playersteam = playersteam + " ";
				}
				int skills = 0;
				String skill = "";
				while (true) {
					try {

						skill = JOptionPane
								.showInputDialog("What is the player's skill level? Enter and integer from 0-99");
						skills = Integer.parseInt(skill);
						while (skills < 0 || skills > 99) {
							JOptionPane.showMessageDialog(null, "Error: You must enter a proper skill level");
							skills = Integer.parseInt(JOptionPane.showInputDialog("enter a valid skill level(0-99)"));
						}

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

				record = integerid + playersname + playersteam + skill + date;
				que.MTPut(record);
				update = new UpdateThread(que.MTGet());
				update.start();
				update.join();
				file=update.getRecords();
				try {
					command = JOptionPane.showInputDialog("Enter a command: new, end").toLowerCase();
					file=update.getRecords();

				} catch (NullPointerException ex1) {
					
				}
			} else {
				que.MTPut("end");
				update = new UpdateThread(que.MTGet());
				update.start();
				update.join();
				file=update.getRecords();

				try {
					command = JOptionPane.showInputDialog("Enter a command: new, end").toLowerCase();
					file=update.getRecords();

				} catch (NullPointerException ex1) {
					
				}
				/*
				 * records.seek(0); int read =
				 * JOptionPane.showConfirmDialog(null,
				 * "Would you like to read all entries in the file?"); String
				 * description = ""; if (read == 0) {
				 * 
				 * for (int i = 0; i < 20; i++) { records.seek((71 + 2) * (i));
				 * String apple = records.readUTF(); if (apple.contains(
				 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				 * )) { apple = Integer.toString(i + 1) +
				 * " has yet to be filled"; } description = description + "\n" +
				 * apple;
				 * 
				 * }
				 * 
				 * } JOptionPane.showMessageDialog(null, description);
				 * records.close(); break;
				 */
			}

		}
	}
	public RandomAccessFile getRecords() {
		return file;
	}

}
