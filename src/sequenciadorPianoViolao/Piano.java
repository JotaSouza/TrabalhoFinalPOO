/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequenciadorPianoViolao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Usuário
 */
public class Piano implements Instrumento {
    
    private Media[] sons;
    private MediaPlayer pianoPlayer;

    public Piano() {
        inicializaNotas();
    }   

    @Override
    public void inicializaNotas() {
        sons = new Media[13];
        sons[0] = new Media(this.getClass().getResource("C0.mp3").toExternalForm());
        sons[1] = new Media(this.getClass().getResource("Db.mp3").toExternalForm());
        sons[2] = new Media(this.getClass().getResource("D.mp3").toExternalForm());
        sons[3] = new Media(this.getClass().getResource("Eb.mp3").toExternalForm());
        sons[4] = new Media(this.getClass().getResource("E.mp3").toExternalForm());
        sons[5] = new Media(this.getClass().getResource("F.mp3").toExternalForm());
        sons[6] = new Media(this.getClass().getResource("Fb.mp3").toExternalForm());
        sons[7] = new Media(this.getClass().getResource("G.mp3").toExternalForm());
        sons[8] = new Media(this.getClass().getResource("Gb.mp3").toExternalForm());
        sons[9] = new Media(this.getClass().getResource("A.mp3").toExternalForm());
        sons[10] = new Media(this.getClass().getResource("Bb.mp3").toExternalForm());
        sons[11] = new Media(this.getClass().getResource("B.mp3").toExternalForm());
        sons[12] = new Media(this.getClass().getResource("C1.mp3").toExternalForm());
    }

    @Override
    public void playNotas(int i) {
        pianoPlayer = new MediaPlayer(sons[i]);
        pianoPlayer.play();
    }
    
}
