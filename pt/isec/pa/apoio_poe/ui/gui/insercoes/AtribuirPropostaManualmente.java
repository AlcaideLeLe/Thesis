package pt.isec.pa.apoio_poe.ui.gui.insercoes;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeState;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class AtribuirPropostaManualmente extends BorderPane {
    apoio_poeContext context;


    TextField textNrAluno;
    TextField textIDProposta;


    CheckBox isAcesso;
    Button buttonConfirm;
    Button buttonClose;

    Label labelNrAluno;
    Label labelIDProposta;


    GridPane grid;



    public AtribuirPropostaManualmente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();


    }

    private void registerHandlers(){

        buttonConfirm.setOnAction(ev->{
            context.atribuirPropostaManualmente(Long.parseLong(textNrAluno.getText()), textIDProposta.getText());

        });

    }

    private void createViews() {
        CSSManager.applyCSS(this,"mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);



        labelNrAluno = new Label("");
        labelNrAluno.setText("Insira o numero do aluno a quem vai associar a proposta");
        grid.add(labelNrAluno, 0, 0);
        labelNrAluno.getStyleClass().add("labelInsereAluno");

        labelIDProposta = new Label("");
        labelIDProposta.setText("Insira o ID da proposta que quer associar");
        grid.add(labelIDProposta, 0, 3);
        labelIDProposta.getStyleClass().add("labelInsereAluno");


        textNrAluno = new TextField("");
        grid.add(textNrAluno, 0, 1);

        textIDProposta = new TextField("");
        grid.add(textIDProposta, 0, 4);


        buttonConfirm = new Button("Confirmar atribuicao de proposta");
        grid.add(buttonConfirm, 2, 4);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.fitToWidthProperty().set(true);


        this.setCenter(scrollPane);
    }
}