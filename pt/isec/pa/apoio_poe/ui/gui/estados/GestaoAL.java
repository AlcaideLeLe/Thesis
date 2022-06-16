package pt.isec.pa.apoio_poe.ui.gui.estados;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarAluno;
import pt.isec.pa.apoio_poe.ui.gui.consultas.MostraAlunos;
import pt.isec.pa.apoio_poe.ui.gui.insercoes.InserirAluno;
import pt.isec.pa.apoio_poe.ui.gui.questiona.QuestionaAlunoAEditar;
import pt.isec.pa.apoio_poe.ui.gui.remocoes.RemoverAluno;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class GestaoAL extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmAluno;
    Button ButtonInserirAlunos;
    Button ButtonRemoverAluno;
    Button ButtonEditarAluno;
    Button ButtonConsultarAlunos;
    Button ButtonConsultarUmAluno;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDeAlunos;


    public GestaoAL(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirAlunos.setOnAction(ev->context.addAluno());
        ButtonInserirUmAluno.setOnAction(ev->{
            Stage stage = new Stage();
            InserirAluno root = new InserirAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunos.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunos root = new MostraAlunos(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarUmAluno.setOnAction(ev->{
            Stage stage = new Stage();
            ConsultarAluno root = new ConsultarAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonRemoverAluno.setOnAction(ev->{
            Stage stage = new Stage();
            RemoverAluno root = new RemoverAluno(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonEditarAluno.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaAlunoAEditar root = new QuestionaAlunoAEditar(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoALtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_AL){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
       
        CSSManager.applyCSS(this,"mystyles.css");

        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);

        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");

        ButtonInserirAlunos = new Button();
        ButtonInserirAlunos.setText("Inserir alunos a partir de um ficheiro");
        ButtonInserirAlunos.getStyleClass().add("buttonGestaoAL");

        ButtonInserirUmAluno = new Button();
        ButtonInserirUmAluno.setText("Inserir um aluno");
        ButtonInserirUmAluno.getStyleClass().add("buttonGestaoAL");

        ButtonConsultarUmAluno = new Button();
        ButtonConsultarUmAluno.setText("Consultar um aluno");
        ButtonConsultarUmAluno.getStyleClass().add("buttonGestaoAL");

        ButtonConsultarAlunos = new Button();
        ButtonConsultarAlunos.setText("Consultar todos os alunos");
        ButtonConsultarAlunos.getStyleClass().add("buttonGestaoAL");

        ButtonRemoverAluno = new Button();
        ButtonRemoverAluno.setText("Remover aluno");
        ButtonRemoverAluno.getStyleClass().add("buttonGestaoAL");

        ButtonEditarAluno = new Button();
        ButtonEditarAluno.setText("Editar aluno");
        ButtonEditarAluno.getStyleClass().add("buttonGestaoAL");

        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        ButtonVoltar.getStyleClass().add("buttonVoltar");

        listaDeAlunos = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirAlunos, 0, 2);
        gridButtons.add(ButtonInserirUmAluno, 0, 4);
        gridButtons.add(ButtonConsultarUmAluno, 0, 6);
        gridButtons.add(ButtonConsultarAlunos, 0, 8);
        gridButtons.add(ButtonRemoverAluno, 0, 10);
        gridButtons.add(ButtonEditarAluno, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(listaDeAlunos, 0, 16);

        this.setCenter(gridButtons);
    }

}