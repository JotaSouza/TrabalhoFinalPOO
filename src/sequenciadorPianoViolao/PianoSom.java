/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequenciadorPianoViolao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class PianoSom extends Piano {
    
    private String[] notaSequencia;
    private int[] indiceSequencia;
    private String conteudoComp;
    private int notaSequenciaLength;
    private Thread pianoThread;

    public PianoSom(String conteudo) {
        this.conteudoComp = conteudo;
        notaSequencia = analisaComposicao(conteudo);
        indiceSequencia = converteStringSequenciaParaIndexar(notaSequencia);
    }

    private String[] analisaComposicao(String conteudo) {
        String composicaoOriginal = conteudo;
        String delims = "[ ]+";
        String[] notaSequenc =  composicaoOriginal.split(delims);
        notaSequenciaLength = notaSequenc.length;
        
        return notaSequenc;
    }
    
    public void playSequencia()
    {   inicializaNotas();
        if (notaSequencia == null)
        {   
           System.out.println("Sequencia de Notas nula");
        }
        
    else if (indiceSequencia == null)  {
            System.out.println("Sequencia nula");
        }
        
    else {
         pianoThread = new Thread(new Runnable() {
            @Override
            public void run()
            {   for (int i = 0; i<notaSequenciaLength; i++)
                {   playNotas(indiceSequencia[i]);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PianoSom.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                }
                
                
                
            }
        });
        pianoThread.start();
        
        
        
        }
        
    }

    private int[] converteStringSequenciaParaIndexar(String[] stringSequencia) {
       int length = stringSequencia.length;
        int[] intArray = new int[length];
        
        for (int i = 0; i<length; i++)
        {   switch(stringSequencia[i]) {
            
            case "C0":
                intArray[i]=0;
                break;
            case "Db":
                intArray[i]=1;
                break;
            case "D":
                intArray[i]=2;
                break;
            case "Eb":
                intArray[i]=3;
                break;
            case "E":
                intArray[i]=4;
                break;
            case "F":
                intArray[i]=5;
                break;
            case "Gb":
                intArray[i]=6;
                break;
            case "G":
                intArray[i]=7;
                break;
            case "Ab":
                intArray[i]=8;
                break;
            case "A":
                intArray[i]=9;
                break;
            case "Bb":
                intArray[i]=10;
                break;
            case "B":
                intArray[i]=11;
                break;
            case "C1":
                intArray[i]=12;
                break;
            }
        }
        
        return intArray;
    }
    
    
}
