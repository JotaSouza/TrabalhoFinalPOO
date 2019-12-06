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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Usuário
 */
public class PianoController implements Initializable {
    @FXML
    private Rectangle keyC0;
    @FXML 
    private Rectangle keyDb;
    @FXML
    private Rectangle keyD;
    @FXML
    private Rectangle keyEb;
    @FXML 
    private Rectangle keyE;
    @FXML
    private Rectangle keyF;
    @FXML
    private Rectangle keyGb;
    @FXML 
    private Rectangle keyG;
    @FXML
    private Rectangle keyAb;
    @FXML
    private Rectangle keyA;
    @FXML 
    private Rectangle keyBb;
    @FXML
    private Rectangle keyB;
    @FXML 
    private Rectangle keyC1;
    
    private Scene pianoScene;
    private Scene violaoScene;
    private ViolaoController violaoController;
    
    public Boolean ativaScenePiano = TRUE;
    
    @FXML 
    private TextArea composicaoConteudo;
    
    @FXML
    private Button gravarBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button limparBtn;
    
    private Stage stage;
    
    @FXML 
    private AnchorPane background;
    
    @FXML 
    private MenuBar menu;
    
    @FXML 
    private HBox hbox;
    
    @FXML
    private AnchorPane org;
    
    @FXML 
    private Circle gravacaoHabilitada;
    
    private boolean gravando=FALSE;//Quando o botão de gravação é clicado, isso é definido como verdadeiro, permitindo a gravação.
    private int numClicouGravar=0;//
    
    private Piano piano;
    private PianoSom som;

    /**
     * Inicializa a classe Controller.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
    }  
    
    public void ready(Stage stage) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        
        this.stage=stage;
        pianoScene = stage.getScene();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instruções");
        alert.setHeaderText("Como usar o Sequenciador: ");
        alert.setContentText("Para tocar o instrumento, basta pressionar as teclas A, W, S, E, D, F, T, G, Y, H, U, J, K. Clique em Gravar para registrar sua sequência e, em seguida, \n"
                + "clique em reproduzir para ouvir a sequência novamente.");
        alert.showAndWait();
        
        composicaoConteudo.setEditable(FALSE);
        
        Piano piano = new Piano();
        
        if (gravando == FALSE)
            {   gravacaoHabilitada.setVisible(FALSE); }
        
        // Essa expressão Lambda funciona para detectar a tecla pressionada e emitir o som correto
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> { 
        if (null != event.getCode().toString() && ativaScenePiano == TRUE) switch (event.getCode().toString()) {
                case "A":
                    keyC0.setStrokeWidth(1);
                    piano.playNotas(0);
                    if (gravando == TRUE)
                        composicaoConteudo.appendText("C ");
                    break;
            
                case "W":
                    keyDb.setStrokeWidth(1);
                    piano.playNotas(1);
                    if (gravando == TRUE)
                        composicaoConteudo.appendText("Db ");
                    break;
            
                case "S":
                    keyD.setStrokeWidth(1);
                    piano.playNotas(2);
                    if (gravando == TRUE)
                        composicaoConteudo.appendText("D ");
                    break;
           
                case "E":
                    keyEb.setStrokeWidth(1);
                    piano.playNotas(3);
                    if (gravando ==TRUE)
                        composicaoConteudo.appendText("Eb ");
                    break;
                    
                case "D":
                    keyE.setStrokeWidth(1);
                    piano.playNotas(4);
                    if (gravando=TRUE)
                        composicaoConteudo.appendText("E ");
                    break;
                    
                case "F":
                    keyF.setStrokeWidth(1);
                    piano.playNotas(5);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("F ");
                    break;
                    
                case "T":
                    keyGb.setStrokeWidth(1);
                    piano.playNotas(6);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("Gb ");
                    break;
                    
                case "G":
                    keyG.setStrokeWidth(1);
                    piano.playNotas(7);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("G ");
                    break;
                    
                case "Y":
                    keyAb.setStrokeWidth(1);
                    piano.playNotas(8);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("Ab ");
                    break;
                    
                case "H":
                    keyA.setStrokeWidth(1);
                    piano.playNotas(9);
                  //  A.play();
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("A ");
                    break;
                    
                case "U":
                    keyBb.setStrokeWidth(1);
                    piano.playNotas(10);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("Bb ");
                    break;
                case "J":
                    keyB.setStrokeWidth(1);
                    piano.playNotas(11);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("B ");
                    break;
                    
                case "K":
                    keyC1.setStrokeWidth(1);
                    piano.playNotas(12);
                    if (gravando==TRUE)
                        composicaoConteudo.appendText("C1 ");
                    break;
                    
                default:
                    break;
            }
        });
        
        
        stage.addEventFilter(KeyEvent.KEY_RELEASED,(KeyEvent event) -> {
        if (null != event.getCode().toString() && ativaScenePiano == TRUE) switch (event.getCode().toString()) {
            case "A":
                    keyC0.setStrokeWidth(0);
                    break;
            
                case "W":
                    keyDb.setStrokeWidth(0);
                    break;
            
                case "S":
                    keyD.setStrokeWidth(0);
                    break;
           
                case "E":
                    keyEb.setStrokeWidth(0);
                    break;
                    
                case "D":
                    keyE.setStrokeWidth(0);
                    break;
                    
                case "F":
                    keyF.setStrokeWidth(0);
                    break;
                    
                case "T":
                    keyGb.setStrokeWidth(0);
                    break;
                    
                case "G":
                    keyG.setStrokeWidth(0);
                    break;
                    
                case "Y":
                    keyAb.setStrokeWidth(0);
                    break;
                    
                case "H":
                    keyA.setStrokeWidth(0);
                    break;
                    
                case "U":
                    keyBb.setStrokeWidth(0);
                    break;
                case "J":
                    keyB.setStrokeWidth(0);
                    break;
                case "K":
                    keyC1.setStrokeWidth(0);
                    break;
                    
                default:
                    break;
            
            
            
        }
        });
    }
    @FXML
    public void manipulaGravacao (ActionEvent event)
    {   if ( (numClicouGravar% 2) == 0 )
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
            System.out.println("Erro: Arquivo não existe");
            
        }
        
    }
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
    public void manipulaPlay() 
    {   if ("".equals(composicaoConteudo.getText()))
        { return; }
        if (ativaScenePiano == FALSE)
        {   return; }
        
        
        som = new PianoSom(composicaoConteudo.getText());
        som.playSequencia();
    }
    
    @FXML
    public void manipulaSobrePiano()
    {   
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Como usar o Sequenciador de Piano");
        alert.setHeaderText("Instruções: ");
        alert.setContentText("O sequenciador de piano permite que você toque um piano utilizando o teclado, bem como as sequências de gravação, carregamento e gravação de notas que o aplicativo pode utilizar para reprodução.\n" +
"Para tocar violão: Pressione as teclas A,W,S,E,D,F,T,G,Y,H,U,J e K e K para tocar as notas abrangendo a oitava C0-C1..\n" +
"\n" +
"Para gravar uma sequência: Pressione O botão de gravação e, em seguida, toque notas no piano. A área de texto será atualizada com notas à medida que são atingidas\n" +
"\n" +
"Para reproduzir uma sequência: Pressione o botão play para ouvir as notas gravadas na sequência.\n" +
"\n" +
"Para carregar uma sequência: No menu Arquivo, selecione \\ \"Carregar sequência \\\" e, em seguida, selecione um arquivo TXT criado anteriormente.\n" +
"\n" +
"Para salvar uma sequência: No menu Arquivo, selecione \\ \"Salvar sequência\". Para criar e salvar um arquivo TXT contendo o conteúdo da sequência.");
        
        alert.showAndWait();
        
        
        
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
    
    @FXML
    public void manipulaTrocaInstrumento() throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {   
        ativaScenePiano = FALSE;
        
        if (violaoScene == null)
        {   FXMLLoader loader = new FXMLLoader(getClass().getResource("Violao.FXML.fxml"));
                    
                   
                    
                    Parent violaoRoot = (Parent) loader.load();
                     violaoController = loader.getController();
                    violaoController.pianoScene = pianoScene;
                    violaoController.pianoController = this;
                    violaoScene = new Scene(violaoRoot);
                
        }
        stage.setScene(violaoScene);
        violaoController.violaoSceneAtiva = TRUE;
      
        violaoController.ready(stage);
        
    }
    
}
