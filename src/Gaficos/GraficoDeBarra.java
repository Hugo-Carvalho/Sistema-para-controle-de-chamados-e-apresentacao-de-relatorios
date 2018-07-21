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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Hugo_Carvalho
 */
public class GraficoDeBarra {
    
    private Color color1, color2, color3;

    public GraficoDeBarra(Color color1, Color color2, Color color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
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

    public JFreeChart creatBarChart(CategoryDataset dataSet) {

        JFreeChart graficosBarra = ChartFactory.createBarChart("", "", "", dataSet, PlotOrientation.VERTICAL, true, true, true);
        
        graficosBarra.setBackgroundPaint(Color.WHITE);
        
        CategoryPlot b = graficosBarra.getCategoryPlot();
        
        b.getRenderer(0).setSeriesPaint(0, color1);
        b.getRenderer(0).setSeriesPaint(1, color2);
        b.getRenderer(0).setSeriesPaint(2, color3);
        
        b.getRenderer().setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0")));
        b.getRenderer().setItemLabelFont(new Font("Arial", Font.BOLD, 12));
        b.getRenderer().setItemLabelsVisible(true, true);
        ((BarRenderer) b.getRenderer()).setBarPainter(new StandardBarPainter());
        
        b.setBackgroundPaint(Color.WHITE);
        
        return graficosBarra;

    }

    public ChartPanel criarGrafico(ArrayList<Dados> listaDeDados) {

        CategoryDataset dataSet = this.creatDataSet(listaDeDados);
        JFreeChart grafico = this.creatBarChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel (grafico);
        
        return painelDoGrafico;
    }

}
