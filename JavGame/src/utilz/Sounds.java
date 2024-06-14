package utilz;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sounds {
	
	 private Clip clip;
	 private String filePath;
	 
	 private boolean isPlaying;

	public Sounds(String momentOfSound)
	{
		   try {
			   if("MENU".equals(momentOfSound))
			   {				   
				   filePath = "Main-Menu";				  
			   }
			   else if("GAME".equals(momentOfSound))
			   {
				   filePath = "play_song";
			   }
			   else if("JUMP".equals(momentOfSound))
			   {
				   filePath = "Jump";
			   }
			   
			    
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/Background/" + filePath + ".wav"));
	            
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	  public void play() {
	        if (clip != null && !clip.isRunning() && !isPlaying) {
	            clip.setFramePosition(0);
	            clip.start();	 
	            isPlaying = true;
	        }
	    }

	    public void stop() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	            isPlaying = false;
	        }
	        
	    }
}
