
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class UpdateThread extends Thread {

	private String record = "";
	private RandomAccessFile records;
	private MTQue que = null;
	private int id = 0;

	public UpdateThread(MTQue q, RandomAccessFile records2) {
		que = q;
		records = records2;

	}

	public void run() {

		while (true) {

			try {
				record = que.MTGet();
				while (record == null) {
					Thread.sleep(2000);
					record = que.MTGet();
				}
				if (record.substring(0, 2).contains(" ")) {
					id = Integer.parseInt(record.substring(0, 1));
				} else {
					id = Integer.parseInt(record.substring(0, 2));
				}

				records.seek(73 * (id - 1));
				records.writeUTF(record);

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

				System.out.println("data was written");

			} catch (NullPointerException | IOException | InterruptedException a) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}

			}
		}

	}
}
