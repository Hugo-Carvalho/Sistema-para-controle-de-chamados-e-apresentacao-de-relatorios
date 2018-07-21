/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Hugo_Carvalho
 */
public class GraficoDeLinha {
    
    private Color color;

    public GraficoDeLinha(Color color) {
        this.color = color;
    }

    public CategoryDataset creatDataSet(ArrayList<Dados> listaDeDados) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (Dados tec : listaDeDados) {

            for (int i = 0; i < tec.getDados().size(); i++) {
                dataSet.addValue(tec.getDados().get(i), tec.getNome(), tec.getData().get(i));
            }
        }

        return dataSet;
    }

    public JFreeChart creatLineChart(CategoryDataset dataSet) {

        JFreeChart graficosLinha = ChartFactory.createLineChart("", "", "", dataSet, PlotOrientation.VERTICAL, false, true, true);

        graficosLinha.setBackgroundPaint(Color.WHITE);

        CategoryPlot l = graficosLinha.getCategoryPlot();

        l.getRenderer().setItemLabelFont(new Font("Arial", Font.BOLD, 15));

        l.getRangeAxis().setVisible(false);//oculta o eixo Y

        l.getRenderer(0).setSeriesPaint(0, color);

        l.getRenderer().setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0")));
        l.getRenderer().setItemLabelsVisible(true);
        l.setBackgroundPaint(Color.WHITE);

        return graficosLinha;

    }

    public ChartPanel criarGrafico(ArrayList<Dados> listaDeDados) {

        CategoryDataset dataSet = this.creatDataSet(listaDeDados);
        JFreeChart grafico = this.creatLineChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico);

        return painelDoGrafico;
    }

}
