import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class MAIN {
	public static RandomAccessFile records=null;
	static String filelocation = "";
	static String filename = "";
	static File file = null;
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			try {
				filelocation = "/Users/Payraw/"
						+ JOptionPane.showInputDialog("Where would you like to store the file?");
				filename = JOptionPane.showInputDialog("What would you like to name the file?");
				file = new File(filelocation + "/" + filename);
				records = new RandomAccessFile(file, "rw");
				System.out.println("file location: " + filelocation);
				System.out.println("file name: " + filename);
				break;
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid information");
			}
		}

		String Dummy = "";
		for (int i = 0; i < 71; i++) {
			Dummy += "a";
		}
		int answer = JOptionPane.showConfirmDialog(null,
				"Is this a old file? (Note: if selected No option, this will erase all previous entries in the file");
		if (answer == 1) {
			for (int i = 0; i < 20; ++i) {
				try {
					records.writeUTF(Dummy);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				} // Fill file with dummy records.
			}
		}
		MTQue que = new MTQue();
		UpdateThread upd = new UpdateThread(que, records);
		ex3main ent = new ex3main(que);

		upd.start();
		ent.start();

	}
}
