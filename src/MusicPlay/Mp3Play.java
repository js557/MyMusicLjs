package MusicPlay;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Mp3Play {
	private String fileName;
	private Player player;

	public Mp3Play(String fileName) {
		this.fileName = fileName;
	}

	public void play() {
		try {
			BufferedInputStream buff = new BufferedInputStream(
					new FileInputStream(fileName));
			player = new Player(buff);
			player.play();
			
			buff.close();//!!!
		
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
