package pt.isec.pa.apoio_poe.ui.gui.questiona;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;
import pt.isec.pa.apoio_poe.ui.gui.consultas.ConsultarOrientacaoDeDocente;
import pt.isec.pa.apoio_poe.ui.gui.resources.CSSManager;

public class QuestionaDocente extends BorderPane {
    apoio_poeContext context;

    TextField textEmail;

    Label labelEmail;

    Button buttonConfirm;

    GridPane grid;

    public QuestionaDocente(apoio_poeContext context) {
        super();
        this.context = context;
        createViews();
        registerHandlers();

    }

    private void registerHandlers(){
        buttonConfirm.setOnAction(ev->{
            Stage stage = new Stage();
            System.out.println(textEmail.getText());
            ConsultarOrientacaoDeDocente root = new ConsultarOrientacaoDeDocente(context, textEmail.getText());
            Scene scene = new Scene(root,700,400);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Docente");
            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.show();
        });
    }

    private void createViews() {
        CSSManager.applyCSS(this, "mystyles.css");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        labelEmail = new Label("");
        labelEmail.setText("Insira o e-mail do Docente que pretende consultar");
        grid.add(labelEmail, 0, 0);

        textEmail = new TextField("");
        grid.add(textEmail, 0, 1);

        buttonConfirm = new Button("Consultar Docente");
        grid.add(buttonConfirm, 2, 22);
        buttonConfirm.getStyleClass().add("buttonConfirm");

        this.setCenter(grid);
    }
}
