package sequenciadorPianoViolao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioStream;

/**
 *
 * @author Usuário
 */
public class Nota {
  
    private URL arquivoSom;
    private Clip clip;
    
    public Nota() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        
        InputStream stream = this.getClass().getResourceAsStream("A.mp3");
        if (stream == null){ 
            System.out.println("Não foi possível carregar o arquivo!"); 
        }
        AudioInputStream audioIS = AudioSystem.getAudioInputStream(stream);
    }
    
    public void play() {
      
         if (clip.isRunning()){   
             clip.stop(); 
         } 
         clip.setFramePosition(0); 
         clip.start();   
      
   }
}
