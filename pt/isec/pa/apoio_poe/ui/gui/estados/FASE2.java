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
import pt.isec.pa.apoio_poe.ui.gui.WindowToolBar;
import pt.isec.pa.apoio_poe.ui.gui.consultas.*;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class FASE2 extends BorderPane {
    GridPane gridButtons;

    Button ButtonGestaoCandidaturas;

    Button ButtonConsultaAlunosComAutoproposta;
    Button ButtonConsultarAlunosComCandidatura;
    Button ButtonConsultarAlunosSemCandidatura;
    Button ButtonConsultarListaDeAutopropostas;
    Button ButtonConsultarPropostasDeDocentes;
    Button ButtonConsultarPropostasComCandidaturas;
    Button ButtonConsultarPropostasSemCandidaturas;
    Button ButtonConsultaPropostas;

    Button ButtonAvancarFase;
    Button ButtonRecuarFase;
    Button ButtonFecharFase;
    Button ButtonSair;



    Label mensagemBoasVindas;
    apoio_poeContext context;
    WindowToolBar toolBar;

    public FASE2(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }


    public void registerHandlers(){
        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonGestaoCandidaturas.setOnAction(ev->context.changeToGestaoCAND());


        ButtonConsultarAlunosComCandidatura.setOnAction(ev->context.consultarAlunosComCandidatura());
        ButtonConsultarAlunosSemCandidatura.setOnAction(ev->context.consultarAlunosSemCandidatura());
        ButtonConsultarListaDeAutopropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraListaDeAutopropostas root = new MostraListaDeAutopropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de autoproposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasDeDocentes.setOnAction(ev-> {
            Stage stage = new Stage();
            MostraListaPropostasDocentes root = new MostraListaPropostasDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas de docentes");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasComCandidaturas.setOnAction(ev-> {
            Stage stage = new Stage();
            MostraPropostasComCandidaturas root = new MostraPropostasComCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas com candidaturas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarPropostasSemCandidaturas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostasSemCandidaturas root = new MostraPropostasSemCandidaturas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas sem candidaturas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaPropostas.setOnAction(ev->{
            Stage stage = new Stage();
            MostraPropostas root = new MostraPropostas(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de propostas");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosComCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComCandidatura root = new MostraAlunosComCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos com candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarAlunosSemCandidatura.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosSemCandidatura root = new MostraAlunosSemCandidatura(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos sem candidatura");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultaAlunosComAutoproposta.setOnAction(ev->{
            Stage stage = new Stage();
            MostraAlunosComAutoproposta root = new MostraAlunosComAutoproposta(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Lista de alunos com autoproposta");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });

        ButtonAvancarFase.setOnAction(ev->context.avancarFase());
        ButtonRecuarFase.setOnAction(ev->context.recuarFase());
        ButtonFecharFase.setOnAction(ev->context.fecharFase());

        ButtonSair.setOnAction(ev->System.exit(0));




    }

    public void update(){
        if(context.getState() == apoio_poeState.FASE2){
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

        ButtonAvancarFase = new Button();
        ButtonAvancarFase.setText("Avancar fase");
        ButtonAvancarFase.getStyleClass().add("buttonFase2");

        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Recuar Fase");
        ButtonRecuarFase.getStyleClass().add("buttonFase2");

        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Fechar Fase");
        ButtonFecharFase.getStyleClass().add("buttonFase2");

        ButtonSair = new Button();
        ButtonSair.setText("Sair");
        ButtonSair.getStyleClass().add("buttonFase2");

        ButtonGestaoCandidaturas = new Button();
        ButtonGestaoCandidaturas.setText("Gestao de Candidaturas");
        ButtonGestaoCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultaAlunosComAutoproposta = new Button();
        ButtonConsultaAlunosComAutoproposta.setText("Consultar alunos com auto-proposta");
        ButtonConsultaAlunosComAutoproposta.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosComCandidatura = new Button();
        ButtonConsultarAlunosComCandidatura.setText("Consultar alunos com candidatura");
        ButtonConsultarAlunosComCandidatura.getStyleClass().add("buttonFase2");

        ButtonConsultarAlunosSemCandidatura = new Button();
        ButtonConsultarAlunosSemCandidatura.setText("Consultar alunos sem candidatura");
        ButtonConsultarAlunosSemCandidatura.getStyleClass().add("buttonFase2");

        ButtonConsultarListaDeAutopropostas = new Button();
        ButtonConsultarListaDeAutopropostas.setText("Consultar auto-propostas");
        ButtonConsultarListaDeAutopropostas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasDeDocentes = new Button();
        ButtonConsultarPropostasDeDocentes.setText("Consultar propostas de docentes");
        ButtonConsultarPropostasDeDocentes.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasComCandidaturas = new Button();
        ButtonConsultarPropostasComCandidaturas.setText("Consultar propostas com candidatura");
        ButtonConsultarPropostasComCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultarPropostasSemCandidaturas = new Button();
        ButtonConsultarPropostasSemCandidaturas.setText("Consultar propostas sem candidatura");
        ButtonConsultarPropostasSemCandidaturas.getStyleClass().add("buttonFase2");

        ButtonConsultaPropostas = new Button();
        ButtonConsultaPropostas.setText("Consultar propostas");
        ButtonConsultaPropostas.getStyleClass().add("buttonFase2");


        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonGestaoCandidaturas, 0, 2);
        gridButtons.add(ButtonConsultarListaDeAutopropostas, 0, 4);
        gridButtons.add(ButtonConsultarPropostasDeDocentes, 0, 6);
        gridButtons.add(ButtonConsultarPropostasComCandidaturas, 0, 8);
        gridButtons.add(ButtonConsultarPropostasSemCandidaturas, 0, 10);
        gridButtons.add(ButtonConsultaPropostas, 0, 12);
        gridButtons.add(ButtonConsultarAlunosComCandidatura, 0, 14);
        gridButtons.add(ButtonConsultarAlunosSemCandidatura, 0, 16);
        gridButtons.add(ButtonConsultaAlunosComAutoproposta, 0, 18);


        gridButtons.add(ButtonFecharFase, 0, 20);
        gridButtons.add(ButtonRecuarFase, 0, 22);
        gridButtons.add(ButtonAvancarFase, 0, 24);

        this.setCenter(gridButtons);
    }






}