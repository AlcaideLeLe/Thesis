package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import java.util.ArrayList;

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

        ButtonConsultaAlunosComAutoproposta.setOnAction(ev->context.consultaAlunosComAutoproposta());
        ButtonConsultarAlunosComCandidatura.setOnAction(ev->context.consultarAlunosComCandidatura());
        ButtonConsultarAlunosSemCandidatura.setOnAction(ev->context.consultarAlunosSemCandidatura());
        ButtonConsultarListaDeAutopropostas.setOnAction(ev->context.consultarListaDeAutopropostas());
        ButtonConsultarPropostasDeDocentes.setOnAction(ev->context.consultarPropostasDocentes());
        ButtonConsultarPropostasComCandidaturas.setOnAction(ev->context.consultarPropostasComCandidaturas());
        ButtonConsultarPropostasSemCandidaturas.setOnAction(ev->context.consultarPropostasSemCandidaturas());
        ButtonConsultaPropostas.setOnAction(ev->context.consultaPropostas());

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
        ButtonRecuarFase= new Button();
        ButtonRecuarFase.setText("Recuar Fase");
        ButtonFecharFase = new Button();
        ButtonFecharFase.setText("Fechar Fase");
        ButtonSair = new Button();
        ButtonSair.setText("Sair");

        ButtonGestaoCandidaturas = new Button();
        ButtonGestaoCandidaturas.setText("Gestao de Candidaturas");
        ButtonConsultaAlunosComAutoproposta = new Button();
        ButtonConsultaAlunosComAutoproposta.setText("Consultar alunos com auto-proposta");
        ButtonConsultarAlunosComCandidatura = new Button();
        ButtonConsultarAlunosComCandidatura.setText("Consultar alunos com candidatura");
        ButtonConsultarAlunosSemCandidatura = new Button();
        ButtonConsultarAlunosSemCandidatura.setText("Consultar alunos sem candidatura");
        ButtonConsultarListaDeAutopropostas = new Button();
        ButtonConsultarListaDeAutopropostas.setText("Consultar auto-propostas");
        ButtonConsultarPropostasDeDocentes = new Button();
        ButtonConsultarPropostasDeDocentes.setText("Consultar propostas de docentes");
        ButtonConsultarPropostasComCandidaturas = new Button();
        ButtonConsultarPropostasComCandidaturas.setText("Consultar propostas com candidatura");
        ButtonConsultarPropostasSemCandidaturas = new Button();
        ButtonConsultarPropostasSemCandidaturas.setText("Consultar propostas sem candidatura");
        ButtonConsultaPropostas = new Button();
        ButtonConsultaPropostas.setText("Consultar propostas");

        //organizar coordenadas
        gridButtons.add(mensagemBoasVindas, 0, 0);
        gridButtons.add(ButtonGestaoCandidaturas, 0, 2);
        gridButtons.add(ButtonConsultaAlunosComAutoproposta, 0, 4);
        gridButtons.add(ButtonConsultarAlunosComCandidatura, 0, 6);
        gridButtons.add(ButtonConsultarAlunosSemCandidatura, 0, 8);
        gridButtons.add(ButtonConsultarListaDeAutopropostas, 0, 10);
        gridButtons.add(ButtonConsultarPropostasDeDocentes, 0, 12);
        gridButtons.add(ButtonConsultarPropostasComCandidaturas, 0, 14);
        gridButtons.add(ButtonConsultarPropostasSemCandidaturas, 0, 16);
        gridButtons.add(ButtonConsultaPropostas, 0, 18);


        gridButtons.add(ButtonAvancarFase, 0, 22);
        gridButtons.add(ButtonRecuarFase, 1, 22);
        gridButtons.add(ButtonFecharFase, 2, 22);

        this.setCenter(gridButtons);
    }






}