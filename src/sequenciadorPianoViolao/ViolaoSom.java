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
public class ViolaoSom extends Violao{
    
    private String[] notaSequencia;
    private int[] indiceSequencia;
    private Thread violaoThread;
    private String conteudoComp;
    private int notaSequenciaLength;

    public ViolaoSom(String conteudo) {
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

    private int[] converteStringSequenciaParaIndexar(String[] stringSequencia) {
        int length = stringSequencia.length;
        int[] intArray = new int[length];
        
        for (int i = 0; i<length; i++)
        {   switch(stringSequencia[i]) {
            
            case "CMaj7":
                intArray[i]=0;
                break;
            case "DbMaj7":
                intArray[i]=1;
                break;
            case "DMaj7":
                intArray[i]=2;
                break;
            case "EbMaj7":
                intArray[i]=3;
                break;
            case "EMaj7":
                intArray[i]=4;
                break;
            case "FMaj7":
                intArray[i]=5;
                break;
            case "GbMaj7":
                intArray[i]=6;
                break;
            case "GMaj7":
                intArray[i]=7;
                break;
            case "AbMaj7":
                intArray[i]=8;
                break;
            case "AMaj7":
                intArray[i]=9;
                break;
            case "BbMaj7":
                intArray[i]=10;
                break;
            case "BMaj7":
                intArray[i]=11;
                break;
            case "C1Maj7":
                intArray[i]=12;
                break;
            }
        }
        
        return intArray;
    }
    
    public void playSequencia(){
    
        inicializaNotas();
        
        
        if (notaSequencia == null)
        {   
            System.out.println("Sequencia de Notas nula");
        }
        
         else if (indiceSequencia == null)  {
            System.out.println("Indice de sequencia nula");
        }
         else { 
             violaoThread = new Thread(new Runnable() {
                 @Override 
                 public void run(){
                      for (int i = 0; i<notaSequenciaLength; i++)
                {   playNotas(indiceSequencia[i]);
                try {
                    Thread.sleep(525);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViolaoSom.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                }
                
                
                
            }
        });
        
            violaoThread.start();
        }
    }
    
}
