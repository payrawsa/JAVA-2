
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class UpdateThread extends Thread {

	public String record;
	public int id;
	private RandomAccessFile records;

	public UpdateThread(String rec) {
		record = rec;
	}

	public void add(String input) {
		if (record.contains("end")) {
			System.out.println("command=end");
		} else {
			System.out.println("command=new");

			try {
				String stId = input.substring(0, 2);
				String l = input.substring(1, 2);
				if (l.contains(" ")) {
					stId = stId.substring(0, 1);
				}
				id = Integer.parseInt(stId);

				getRecords().seek(73 * (id - 1));
				getRecords().writeUTF(input);

				String ID = "ID          : " + input.substring(0, 2) + "\n";
				String NA = "Player Name : " + input.substring(5, 31) + "\n";
				String TNA = "Team Name   : " + input.substring(31, 57) + "\n";
				String SKI = "Skill Level : " + input.substring(57, 62) + "\n";
				String DDA = "Draft Date  : " + input.substring(62, 71) + "\n";

				System.out.println(ID);
				System.out.println(NA);
				System.out.println(TNA);
				System.out.println(SKI);
				System.out.println(DDA);

			} catch (IOException | NumberFormatException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();

			}
		}
	}

	public void run() {
		records = ex3main.file;
		if (records != null) {
			System.out.println("using previous file");
			
		}
		else{
		while (true) {

			try {
				String filelocation = "C:\\Users\\payraw\\"
						+ JOptionPane.showInputDialog("Where would you like to store the file?");
				String filename = JOptionPane.showInputDialog("What would you like to name the file?");
				File file = new File(filelocation + "\\" + filename);
				setRecords(new RandomAccessFile(file, "rw"));
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
				try {
					getRecords().writeUTF(Dummy);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Fill file with dummy records.
			}}
		}
		if (record == null) {

		} else if (record.contains("end") == true) {
			System.out.println("command=end");
			
			int read = JOptionPane.showConfirmDialog(null, "Would you like to read all entries in the file?");
			String description = "";
			if (read == 0) {

				for (int i = 0; i < 20; i++) {
					try {
						getRecords().seek((71 + 2) * (i));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String apple = null;
					try {
						apple = getRecords().readUTF();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (apple.contains("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
						apple = Integer.toString(i + 1) + " has yet to be filled";
					}
					description = description + "\n" + apple;

				}

			}
			JOptionPane.showMessageDialog(null, description);
			
		} else {
			System.out.println("command=new");

			try {
				String stId = record.substring(0, 2);
				String l = record.substring(1, 2);
				if (l.contains(" ")) {
					stId = stId.substring(0, 1);
				}
				id = Integer.parseInt(stId);

				getRecords().seek(73 * (id - 1));
				getRecords().writeUTF(record);

				String ID = "ID          : " + record.substring(0, 2) + "\n";
				String NA = "Player Name : " + record.substring(5, 31) + "\n";
				String TNA = "Team Name   : " + record.substring(31, 57) + "\n";
				String SKI = "Skill Level : " + record.substring(57, 62) + "\n";
				String DDA = "Draft Date  : " + record.substring(62, 71) + "\n";

				System.out.println(ID);
				System.out.println(NA);
				System.out.println(TNA);
				System.out.println(SKI);
				System.out.println(DDA);

			} catch (IOException | NumberFormatException a) {
				// TODO Auto-generated catch block
				System.out.println("waiting for user inputs...");

			}
		}

	}

	public static void main(String[] args) {
		//
	}

	public RandomAccessFile getRecords() {
		return records;
	}

	public void setRecords(RandomAccessFile records) {
		this.records = records;
	}
}