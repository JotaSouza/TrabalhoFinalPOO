/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequenciadorPianoViolao;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Usuário
 */
public class Violao implements Instrumento {
    
    private ArrayList<Media> sons;
    private MediaPlayer violaoPlayer;

    public Violao() {
        inicializaNotas();
    }
    
    

    @Override
    public void inicializaNotas() {//O método inicializa a lista de mídias da mídia, carregando em cada MP3 a ser acessado.
        sons = new ArrayList<Media>(13);
        
        sons.add(new Media(this.getClass().getResource("Cmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Dbmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Dmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Ebmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Emaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Fmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Gbmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Gmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Abmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Amaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Bbmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("Bmaj.mp3").toExternalForm()) );
        sons.add(new Media(this.getClass().getResource("C1maj.mp3").toExternalForm()) );
    }

    @Override
    public void playNotas(int i) {
          violaoPlayer = new MediaPlayer(sons.get(i));
          violaoPlayer.play();
    }
    
}
