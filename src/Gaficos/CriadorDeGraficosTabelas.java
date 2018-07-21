/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.Color;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Hugo_Carvalho
 */
public class CriadorDeGraficosTabelas {

    public ChartPanel criarGraficoDeBarraTotalRequisicoesIncidentes(Color color, ArrayList<Integer> totais, ArrayList<Integer> requisicoes, ArrayList<Integer> incidentes, ArrayList<String> datas) throws IOException {

        ArrayList<Dados> dados = new ArrayList<>();
        dados.add(new Dados("TOTAIS", datas, totais));
        dados.add(new Dados("REQUISIÇÕES", datas, requisicoes));
        dados.add(new Dados("INCIDENTES", datas, incidentes));

        GraficoDeBarra g = new GraficoDeBarra(color, new Color(255, 69, 0), new Color(128, 128, 128));
        return g.criarGrafico(dados);
    }

    public ChartPanel criarGraficoDeBarraTotalAbertosSolucionadosAtrasados(ArrayList<Integer> abertos, ArrayList<Integer> solucionados, ArrayList<Integer> atrasados, ArrayList<String> datas) throws IOException {

        ArrayList<Dados> dados = new ArrayList<>();
        dados.add(new Dados("ABERTOS", datas, abertos));
        dados.add(new Dados("TOTAL SOLUCIONADOS", datas, solucionados));
        dados.add(new Dados("SOLUCIONADOS FORA DO PRAZO", datas, atrasados));

        GraficoDeBarra g = new GraficoDeBarra(new Color(30, 144, 255), new Color(0, 100, 0), new Color(255, 0, 0));
        return g.criarGrafico(dados);
    }

    public ChartPanel criarGraficoDeLinhaDoMes(int mesRequerido, Color color, ArrayList<Integer> valores, ArrayList<String> datas) throws IOException {

        ArrayList<Integer> datasRemovidas = new ArrayList<>();
        ArrayList<String> diaDasDatas = new ArrayList<>();
        int dia, mes;
        String strDia;

        for (int i = 0; i < datas.size(); i++) {

            dia = Integer.parseInt(datas.get(i).substring(0, 2));
            mes = Integer.parseInt(datas.get(i).substring(3, 5));

            if (mes == mesRequerido) {

                if (dia < 10) {
                    strDia = "0" + dia;
                } else {
                    strDia = "" + dia;
                }

                diaDasDatas.add(strDia);

            } else {
                datasRemovidas.add(i);
            }
        }

        for (int i = 0; i < datasRemovidas.size(); i++) {
            valores.remove(datasRemovidas.get(i) - i);
        }

        ArrayList<Dados> dados = new ArrayList<>();
        dados.add(new Dados("", diaDasDatas, valores));

        GraficoDeLinha g = new GraficoDeLinha(color);
        return g.criarGrafico(dados);

    }

    public ChartPanel criarGraficoDePizzaTempo(ArrayList<Integer> porcentagens, ArrayList<String> datasComTempos) {

        ArrayList<Dados> dados = new ArrayList<>();
        dados.add(new Dados("", datasComTempos, porcentagens));

        GraficoDePizza g = new GraficoDePizza();
        return g.criarGrafico(dados);
    }

    public JTable criarTabelaDeControleTempoTec(ArrayList<String> tecnicos, ArrayList<Integer> solucionados, ArrayList<String> tempos) throws IOException {

        ArrayList<String> porcentagemSolucionados = new ArrayList<>();

        double total = 0;

        for (int i = 0; i < solucionados.size(); i++) {
            total = total + solucionados.get(i);
        }

        double porcentagem;
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 0; i < solucionados.size(); i++) {
            porcentagem = (solucionados.get(i) * 100) / total;
            porcentagemSolucionados.add(df.format(porcentagem));
        }

        JTable tabela = new JTable();

        DefaultTableModel val = new DefaultTableModel(null, new String[]{"Tecnicos", "Solucionados", "%", "Tempo", "%"}) {
            @Override

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        String[] linha = {"", "", "", "", ""};

        for (int i = 0; i < tecnicos.size(); i++) {
            linha[0] = tecnicos.get(i);
            linha[1] = "" + solucionados.get(i);
            linha[2] = porcentagemSolucionados.get(i);
            linha[3] = tempos.get(i);
            val.addRow(linha);
        }

        tabela.setModel(val);

        return tabela;
    }

}
