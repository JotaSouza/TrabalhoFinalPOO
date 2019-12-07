/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequenciadorPianoViolao;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class ViolaoController implements Initializable {
    
    @FXML
    private Ellipse C0;
    @FXML
    private Ellipse Db;
    @FXML
    private Ellipse D;
    @FXML
    private Ellipse Eb;
    @FXML
    private Ellipse E;
    @FXML
    private Ellipse F;
    @FXML
    private Ellipse Gb;
    @FXML
    private Ellipse G;
    @FXML
    private Ellipse Ab;
    @FXML
    private Ellipse A;
    @FXML
    private Ellipse Bb;
    @FXML
    private Ellipse B;
    @FXML
    private Ellipse C1;
    
    private ViolaoSom som1;
    
    @FXML 
    private TextArea composicaoConteudo;
    
    @FXML
    private Button gravarBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button limparBtn;
    
    private Stage stage;
    
     private boolean gravando=FALSE;
     private int numClicouGravar=0;
     
    public Scene pianoScene;
    private Scene violaoScene;
    public PianoController pianoController;
    
    @FXML 
    private Circle gravacaoHabilitada;
    
    public Boolean violaoSceneAtiva = TRUE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
    } 
    
    public void ready(Stage stage) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        this.stage = stage;
        
        Violao violao = new Violao();
        composicaoConteudo.setEditable(FALSE);
        
        if (gravando == FALSE)
        {   gravacaoHabilitada.setVisible(FALSE); }
        
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> { 
        if (null != event.getCode().toString() && violaoSceneAtiva == TRUE) switch (event.getCode().toString()) {
            case "A":
                C0.setStrokeWidth(1);
                violao.playNotas(0);
                if (gravando)
                {
                    composicaoConteudo.appendText("CMaj7 ");
                }
                    
                break;
            case "W":
                Db.setStrokeWidth(1);
                violao.playNotas(1);
                if (gravando)
                {
                    composicaoConteudo.appendText("DbMaj7 ");
                }
                break;
            case "S":
                D.setStrokeWidth(1);
                violao.playNotas(2);
                if (gravando)
                {
                    composicaoConteudo.appendText("DMaj7 ");
                }
                break;
            case "E":
                Eb.setStrokeWidth(1);
                violao.playNotas(3);
                if (gravando)
                {
                    composicaoConteudo.appendText("EbMaj7 ");
                }
                break;
            case "D":
                E.setStrokeWidth(1);
                violao.playNotas(4);
                if (gravando)
                {
                    composicaoConteudo.appendText("EMaj7 ");
                }
                break;
            case "F":
                F.setStrokeWidth(1);
                violao.playNotas(5);
                if (gravando)
                {
                    composicaoConteudo.appendText("FMaj7 ");
                }
                break;
                
            case "T":
                Gb.setStrokeWidth(1);
                violao.playNotas(6);
                if (gravando)
                {
                    composicaoConteudo.appendText("GbMaj7 ");
                }
                break;
            case "G":
                G.setStrokeWidth(1);
                violao.playNotas(7);
                if (gravando)
                {
                    composicaoConteudo.appendText("GMaj7 ");
                }
                break;
            case "Y":
                Ab.setStrokeWidth(1);
                violao.playNotas(8);
                if (gravando)
                {
                    composicaoConteudo.appendText("AbMaj7 ");
                }
                break;
            case "H":
                A.setStrokeWidth(1);
                violao.playNotas(9);
                if (gravando)
                {
                    composicaoConteudo.appendText("AMaj7 ");
                }
                break;
            case "U":
                Bb.setStrokeWidth(1);
                violao.playNotas(10);
                if (gravando)
                {
                    composicaoConteudo.appendText("BbMaj7 ");
                }
                break;
            case "J":
                B.setStrokeWidth(1);
                violao.playNotas(11);
                if (gravando)
                {
                    composicaoConteudo.appendText("BMaj7 ");
                }
                break;
            case "K":
                C1.setStrokeWidth(1);
                violao.playNotas(12);
                if (gravando)
                {
                    composicaoConteudo.appendText("C1Maj7 ");
                }
                break;
            default:
                break;
                
            
            
        }
        });
        
         stage.addEventFilter(KeyEvent.KEY_RELEASED,(KeyEvent event) -> {
        if (null != event.getCode().toString() && violaoSceneAtiva == TRUE) switch (event.getCode().toString()) {
            case "A":
                    C0.setStrokeWidth(0);
                    break;
            
                case "W":
                    Db.setStrokeWidth(0);
                    break;
            
                case "S":
                    D.setStrokeWidth(0);
                    break;
           
                case "E":
                    Eb.setStrokeWidth(0);
                    break;
                    
                case "D":
                    E.setStrokeWidth(0);
                    break;
                    
                case "F":
                    F.setStrokeWidth(0);
                    break;
                    
                case "T":
                    Gb.setStrokeWidth(0);
                    break;
                    
                case "G":
                    G.setStrokeWidth(0);
                    break;
                    
                case "Y":
                    Ab.setStrokeWidth(0);
                    break;
                    
                case "H":
                    A.setStrokeWidth(0);
                    break;
                    
                case "U":
                    Bb.setStrokeWidth(0);
                    break;
                case "J":
                    B.setStrokeWidth(0);
                    break;
                case "K":
                    C1.setStrokeWidth(0);
                    break;
                    
                default:
                    break;
            
            
            
        }
        });
        
        
    }
    
    @FXML
    public void manipulaSaveSequencia(ActionEvent event) throws IOException
    {   FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        
        FileWriter writer = null;
        if (file != null)
        {
            try{
                writer =  new FileWriter(file);
                writer.write(composicaoConteudo.getText());
            }
            catch (IOException ioex)
            {
                System.out.println("\nErro ao Salvar");
            } catch (Exception ex)
            {
                System.out.println("\nErro ao Salvar");
            } finally {
                if (writer != null){
                    try { 
                            writer.close();
                    }
                    catch (Exception e)
                    {
                        
                    }
                }
            }
        }
    }
    
    
    @FXML 
    public void manipulaSobreMim()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre Jota Souza");
        alert.setHeaderText("Um pouco sobre o desenvolvedor: ");
        alert.setContentText("Jota Souza é um estudante do curso de Ciência da Computação no IFC - Campus Rio do Sul");
        
        alert.showAndWait();
        
        
    }
    @FXML void manipulaSobreViolao()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Como usar o Sequenciador de Violão");
        alert.setHeaderText("Instruções: ");
        alert.setContentText("O Sequenciador de Violão permite que você toque acordes de violão, através da utilização do teclado, bem como sequências de gravação,\n"
                + " carregamento e também gravação de notas que o sistema poderá utilizar na reprodução\n" +
"\n" +
"Para tocar violão: Pressione as teclas A,W,S,E,D,F,T,G,Y,H,U,J e K para tocar os sétimos acordes que abrangem a oitava C0-C1.\n" +
"\n" +
"Para gravar uma sequência: Pressione o botão de gravação e toque os acordes no piano. A área de texto será atualizada com as notas à medida que forem inseridas.\n" +
"\n" +
"Para reproduzir uma sequência: pressione o botão Play para ouvir as notas que estão preenchendo a sequência no momento.\n" +
"\n" +
"Para carregar uma sequência: Selecione \\ \"Carregar sequência \\\" no menu arquivo e selecione um arquivo TXT criado anteriormente.\n" +
"\n" +
"Para salvar uma sequência: Selecione \\ \"Salvar sequência \\\" no menu arquivo, para criar e salvar um arquivo TXT contendo o conteúdo da sequência.");
        
        alert.showAndWait();
        
    }
    
    @FXML 
    public void manipulaCarregamento (ActionEvent event) throws IOException
    {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        
        
        if (file != null)
        {   try{ 
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    
                    String line;
                    
                    while ( (line = bufferedReader.readLine()) != null) {
                        composicaoConteudo.setText(line);
                
            }
                    
                    
                    
        }
        catch (Exception e)
        {
            System.out.println("Erro ao carregar");
            
        }
        
    }
    }
    
    @FXML
    public void manipulaGravacao(ActionEvent event)
    {   if ( (numClicouGravar % 2) == 0 )
        {   gravando = TRUE;
            gravacaoHabilitada.setVisible(TRUE);
            numClicouGravar++;
        }
        
        else
            {   gravando = FALSE;
                gravacaoHabilitada.setVisible(FALSE);
                numClicouGravar++;
            
            }
    }
    
    @FXML
    public void manipulaLimpa(ActionEvent event)
    {   if (composicaoConteudo.getText() == null) {
        } else {
          composicaoConteudo.setText("");
    
        }
    }
    
    @FXML
    public void manipulaTrocaInstrumento()
    {   
        violaoSceneAtiva = FALSE;
        stage.setScene(pianoScene);
        pianoController.ativaScenePiano = TRUE;
    }
    
    @FXML
    public void manipulaPlay()
    {
        if ("".equals(composicaoConteudo.getText()))
        { return; }
        
        
        som1 = new ViolaoSom(composicaoConteudo.getText());
        som1.playSequencia();
    }
    
}
