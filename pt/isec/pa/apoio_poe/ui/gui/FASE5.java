package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

import java.util.ArrayList;

public class FASE5 extends BorderPane {
    GridPane gridButtons;

    Button ButtonConsultarAlunosComPropostaAtribuida;
    Button ButtonConsultarComCandidaturaESemProposta;
    Button ButtonConsultarPropostasDisponiveis;
    Button ButtonConsultarPropostasAtribuidas;
    Button ButtonConsultarDocentesComMenosOrientacoes;
    Button ButtonConsultarDocentesComMaisOrientacoes;
    Button ButtonConsultarMediaDeOrientacoesDocentes;
    Button ButtonExportarAlunosCSV;

    Button ButtonSair;



    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE5(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonConsultarAlunosComPropostaAtribuida.setOnAction(ev->context.consultarAlunosComPropostaAtribuida());
        ButtonConsultarComCandidaturaESemProposta.setOnAction(ev->context.consultarAlunosComCandidaturaESemProposta());
        ButtonConsultarPropostasDisponiveis.setOnAction(ev->context.consultarPropostasDisponiveis());
        ButtonConsultarPropostasAtribuidas.setOnAction(ev->context.consultarPropostasAtribuidas());
        ButtonConsultarDocentesComMenosOrientacoes.setOnAction(ev->context.consultarDocenteComMenosOrientacoes());
        ButtonConsultarDocentesComMaisOrientacoes.setOnAction(ev->context.consultarDocenteComMaisOrientacoes());
        ButtonConsultarMediaDeOrientacoesDocentes.setOnAction(ev->context.consultarMediaDeOrientacoesDosDocentes());
        ButtonExportarAlunosCSV.setOnAction(ev->{
            Stage stage = new Stage();
            QuestionaFicheiro root = new QuestionaFicheiro(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonSair.setOnAction(ev->System.exit(0));




    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE5){
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
        mensagemBoasVindas = new Label();
        mensagemBoasVindas.setText("Escolha uma das opcoes: ");



        ButtonConsultarAlunosComPropostaAtribuida = new Button();
        ButtonConsultarAlunosComPropostaAtribuida.setText("Consultar Alunos Com Proposta Atribuida");
        ButtonConsultarAlunosComPropostaAtribuida.getStyleClass().add("buttonFase2");

        ButtonConsultarComCandidaturaESemProposta = new Button();
        ButtonConsultarComCandidaturaESemProposta.setText("Consultar Alunos Com Candidatura E Sem Proposta");
        ButtonConsultarComCandidaturaESemProposta.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDisponiveis = new Button();
        ButtonConsultarPropostasDisponiveis.setText("Consultar Propostas Disponiveis");
        ButtonConsultarPropostasDisponiveis.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasAtribuidas = new Button();
        ButtonConsultarPropostasAtribuidas.setText("Consultar Propostas Atribuidas");
        ButtonConsultarPropostasAtribuidas.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMenosOrientacoes = new Button();
        ButtonConsultarDocentesComMenosOrientacoes.setText("Consultar docentes com menos orientacoes");
        ButtonConsultarDocentesComMenosOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarDocentesComMaisOrientacoes = new Button();
        ButtonConsultarDocentesComMaisOrientacoes.setText("Consultar docentes com mais orientacoes");
        ButtonConsultarDocentesComMaisOrientacoes.getStyleClass().add("buttonFase2");

        ButtonConsultarMediaDeOrientacoesDocentes = new Button();
        ButtonConsultarMediaDeOrientacoesDocentes.setText("Consultar media de orientacoes de docentes");
        ButtonConsultarMediaDeOrientacoesDocentes.getStyleClass().add("buttonFase2");


        ButtonExportarAlunosCSV = new Button();
        ButtonExportarAlunosCSV.setText("Exportar Alunos para CSV");
        ButtonExportarAlunosCSV.getStyleClass().add("buttonFase2");



        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonFase2");

        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonConsultarAlunosComPropostaAtribuida, 0, 2);
        gridButtons.add(ButtonConsultarComCandidaturaESemProposta, 0, 4);
        gridButtons.add(ButtonConsultarPropostasDisponiveis, 0, 6);
        gridButtons.add(ButtonConsultarPropostasAtribuidas, 0, 8);
        gridButtons.add(ButtonConsultarDocentesComMenosOrientacoes, 0, 10);
        gridButtons.add(ButtonConsultarDocentesComMaisOrientacoes, 0, 12);
        gridButtons.add(ButtonConsultarMediaDeOrientacoesDocentes, 0, 14);
        gridButtons.add(ButtonExportarAlunosCSV, 0, 16);



        this.setCenter(gridButtons);
    }






}
