/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Hugo_Carvalho
 */
public class GraficoDePizza {
    
    public GraficoDePizza() {

    }

    public PieDataset creatDataSet(ArrayList<Dados> listaDeDados) {

        DefaultPieDataset dataSet = new DefaultPieDataset();

        for (Dados tec : listaDeDados) {

            for (int i = 0; i < tec.getDados().size(); i++) {
                dataSet.setValue(tec.getData().get(i), tec.getDados().get(i));
            }
        }

        return dataSet;
    }

    public JFreeChart creatPizzaChart(PieDataset dataSet) {

        JFreeChart graficosPizza = ChartFactory.createPieChart3D("", dataSet, false, true, false);
        
        Plot p = graficosPizza.getPlot();
        
        p.setBackgroundPaint(Color.WHITE);
        p.setOutlinePaint(Color.BLACK);

        graficosPizza.setBackgroundPaint(Color.WHITE);


        return graficosPizza;

    }

    public ChartPanel criarGrafico(ArrayList<Dados> listaDeDados) {

        PieDataset dataSet = this.creatDataSet(listaDeDados);
        JFreeChart grafico = this.creatPizzaChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico);

        return painelDoGrafico;
    }

}
