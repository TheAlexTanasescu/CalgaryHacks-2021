package javamusicthing;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class musictime {

	Clip clip;
	// plays music in a loop
	public void PlayMusicLoop(String MusicLocation) {
		
		
		try {
			
			File musicpath = new File(MusicLocation);
			
			if(musicpath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
			
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(clip.LOOP_CONTINUOUSLY);
				
			
			}
			else {
				System.out.println("Cant find audio file");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	// plays music once
public void PlayMusic(String MusicLocation) {
		
		
		try {
			
			File musicpath = new File(MusicLocation);
			
			if(musicpath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
			
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				
			
			}
			else {
				System.out.println("Cant find audio file");
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		
	}
	
 public void StopMusic() {
	
	clip.stop();
   }
	
	
	
}
