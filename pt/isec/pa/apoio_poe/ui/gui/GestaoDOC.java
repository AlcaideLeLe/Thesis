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
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;

import java.util.ArrayList;

public class GestaoDOC extends BorderPane {

    apoio_poeContext context;
    GridPane gridButtons;
    Button ButtonInserirUmDocente;
    Button ButtonInserirDocentes;
    Button ButtonRemoverDocente;
    Button ButtonEditarDocente;
    Button ButtonConsultarDocentes;
    Button ButtonConsultarUmDocente;
    Button ButtonVoltar;
    Label mensagemEscolha;
    Label listaDeDocentes;

    public GestaoDOC(apoio_poeContext context) {
        this.context = context;
        createViews();
        registerHandlers();
        update();
    }

    public void registerHandlers(){

        context.addPropertyChangeListener(context.PROP_FASE, ev->update());
        ButtonInserirDocentes.setOnAction(ev->context.addDocente());
        ButtonInserirUmDocente.setOnAction(ev->{
            Stage stage = new Stage();
            InserirDocente root = new InserirDocente(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        ButtonConsultarDocentes.setOnAction(ev->{
            Stage stage = new Stage();
            MostraDocentes root = new MostraDocentes(context);
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Inserir aluno");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
        //ButtonConsultarUmDocente.setOnAction(ev->context.consultaAluno());
        //ButtonRemoverDocente.setOnAction(ev->context.removerAluno());
        //ButtonEditarDocente.setOnAction(ev->context.editarAluno());
        ButtonVoltar.setOnAction(ev->context.changeFromGestaoDOCtoBase());

    }

    public void update(){
        if(context.getState() == apoio_poeState.GESTAO_DOC){
            this.setVisible(true);
            System.out.println(context.getState());
        }
        else{
            this.setVisible(false);
        }
    }

    public void createViews(){
        //toolBar = new WindowToolBar(context);
        //toolBar.createViews();
        gridButtons = new GridPane();
        gridButtons.setAlignment(Pos.CENTER);
        //gap
        gridButtons.setHgap(0);
        gridButtons.setVgap(10);
        //create buttons
        mensagemEscolha = new Label();
        mensagemEscolha.setText("Escolha uma das opcoes: ");
        ButtonInserirDocentes = new Button();
        ButtonInserirDocentes.setText("Inserir docentes a partir de um ficheiro");
        ButtonInserirUmDocente = new Button();
        ButtonInserirUmDocente.setText("Inserir um docente");
        ButtonConsultarUmDocente = new Button();
        ButtonConsultarUmDocente.setText("Consultar um docente");
        ButtonConsultarDocentes = new Button();
        ButtonConsultarDocentes.setText("Consultar todos os docentes");
        ButtonRemoverDocente = new Button();
        ButtonRemoverDocente.setText("Remover docente");
        ButtonEditarDocente = new Button();
        ButtonEditarDocente.setText("Editar docente");
        ButtonVoltar = new Button();
        ButtonVoltar.setText("Voltar");
        listaDeDocentes = new Label();


        //organizar coordenadas

        gridButtons.add(mensagemEscolha, 0, 0);
        gridButtons.add(ButtonInserirDocentes, 0, 2);
        gridButtons.add(ButtonInserirUmDocente, 0, 4);
        gridButtons.add(ButtonConsultarUmDocente, 0, 6);
        gridButtons.add(ButtonConsultarDocentes, 0, 8);
        gridButtons.add(ButtonRemoverDocente, 0, 10);
        gridButtons.add(ButtonEditarDocente, 0, 12);
        gridButtons.add(ButtonVoltar, 0, 14);
        gridButtons.add(listaDeDocentes, 0, 16);

        this.setCenter(gridButtons);
    }

}