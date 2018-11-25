package MusicPlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import MusicGui.SongSheet;

public class FileChoose {
	private static JFileChooser fileChooser = null;
	private static String fileName = null;
	private static FileReader fileReader = null;

	SongSheet songSheet = new SongSheet();

	public void fileChoose() {

		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("D:/kugou")); // ！！！设置当前目录

		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(
				"mp3", "mp3");
		fileChooser.setFileFilter(fileNameExtensionFilter);// 设置当前文件过滤器
		int chosenSongCount = 0;
		while (chosenSongCount++ < 3) {
			fileChooser.showOpenDialog(null);// 弹出一个 "Open File" 文件选择器对话框

			songSheet.addSong(fileChooser.getSelectedFile().toString());
		}
		// try {
		// fileReader = new FileReader(fileChooser.getSelectedFile());
		// fileName = fileChooser.getSelectedFile().toString();
		// Mp3Play mp3Play = new Mp3Play(fileName);
		// mp3Play.play();
		//
		// fileReader.close();
		// JOptionPane.showMessageDialog(null, "Open Success", "Message", 1);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (NullPointerException e) {
		// System.out.println("没有选择文件");
		// }
	}

}
