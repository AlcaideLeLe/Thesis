package pt.isec.pa.apoio_poe.ui.gui.graficos;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.fsm.apoio_poeContext;

import java.util.HashMap;

public class GraficoEmpresas extends BorderPane {
    apoio_poeContext context;
    double d;

    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    BarChart barChart = new BarChart(xAxis, yAxis);
    XYChart.Series dataSeries1 = new XYChart.Series();



    public GraficoEmpresas(apoio_poeContext context) {
        this.context = context;
        this.d = d;
        createViews();

    }

    public void createViews(){

        HashMap<String, Number> top5 = context.EmpresasComMaisEstagios();
        for (int i = 0; i < top5.size(); i++) {
            dataSeries1.getData().add(new XYChart.Data(top5.keySet().toArray()[i], top5.get(top5.keySet().toArray()[i])));
        }
        dataSeries1.setName("Companies");

        barChart.getData().add(dataSeries1);

        this.setCenter(barChart);

    }
}
