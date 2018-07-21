/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugo_Carvalho
 */
public class Inicial extends javax.swing.JFrame {

    private ValidadorConstrutorDaPesquisa validadorConstrutorDaPesquisa;
    private boolean programaIniciado;

    public Inicial() throws FileNotFoundException, IOException {

        initComponents();
        this.setLocationRelativeTo(null);

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy");
        int anoAtual = Integer.parseInt(formatarDate.format(data));

        for (int ano = 2017; ano <= anoAtual; ano++) {
            jComboAnoDaPlanilhaCarregada.addItem("" + ano);
        }

        formatarDate = new SimpleDateFormat("MM");
        int mesAtual = Integer.parseInt(formatarDate.format(data));
        jComboMes.setSelectedIndex(mesAtual - 1);

        validadorConstrutorDaPesquisa = new ValidadorConstrutorDaPesquisa();

        jComboAnoDaPlanilhaCarregada.setSelectedItem("" + validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().getAnoExecuntando());
        jComboTecnicos.setVisible(false);
        jComboMes.setVisible(false);
        jComboSemana.setVisible(false);
        jComboRequisicoesIncidentesTotal.setVisible(false);
        jCheckDupli.setVisible(false);
        jCheckTabelaDeControlePorTecTempo.setVisible(false);

        jComboSemana.setSelectedIndex(0);

        programaIniciado = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Pesquisar = new javax.swing.JButton();
        jComboAbertosPendentesSolucionadosSForaDoPrazoTempo = new javax.swing.JComboBox<>();
        jComboPorTecTotal = new javax.swing.JComboBox<>();
        jComboTecnicos = new javax.swing.JComboBox<>();
        jComboMes = new javax.swing.JComboBox<>();
        jComboSemana = new javax.swing.JComboBox<>();
        jComboRequisicoesIncidentesTotal = new javax.swing.JComboBox<>();
        jCheckTabelaDeControlePorTecTempo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboAnoDaPlanilhaCarregada = new javax.swing.JComboBox<>();
        jCheckDupli = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        grafico = new javax.swing.JPanel();
        AbrirPlanilha = new javax.swing.JLabel();
        Assisnatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Montreal Informática");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        Pesquisar.setText("Pesquisar");
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });

        jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Abertos", "Pendentes", "Solucionados", "-- Atrasados", "-- Tempo Gasto" }));
        jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAbertosPendentesSolucionadosSForaDoPrazoTempoActionPerformed(evt);
            }
        });

        jComboPorTecTotal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Por Tecnico", "Total" }));
        jComboPorTecTotal.setEnabled(false);
        jComboPorTecTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPorTecTotalActionPerformed(evt);
            }
        });

        jComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));
        jComboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMesActionPerformed(evt);
            }
        });

        jComboSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semana 1", "Semana 2", "Semana 3", "Semana 4", "Semana 5", "Semana 6", "TOTAL" }));
        jComboSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSemanaActionPerformed(evt);
            }
        });

        jComboRequisicoesIncidentesTotal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REQUISIÇÔES", "INCIDENTES", "TOTAL" }));

        jCheckTabelaDeControlePorTecTempo.setText("Tabela de controle por tec - tempo");
        jCheckTabelaDeControlePorTecTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckTabelaDeControlePorTecTempoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Pesquisar:");

        jComboAnoDaPlanilhaCarregada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ano..." }));
        jComboAnoDaPlanilhaCarregada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAnoDaPlanilhaCarregadaActionPerformed(evt);
            }
        });

        jCheckDupli.setText("Sem duplicatas");

        jButton1.setText("PC");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboAnoDaPlanilhaCarregada, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jButton1))
                            .addComponent(jCheckTabelaDeControlePorTecTempo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboAbertosPendentesSolucionadosSForaDoPrazoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckDupli))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboRequisicoesIncidentesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pesquisar))
                            .addComponent(jComboPorTecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboAbertosPendentesSolucionadosSForaDoPrazoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboPorTecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboAnoDaPlanilhaCarregada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckTabelaDeControlePorTecTempo)
                                .addComponent(jCheckDupli))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboRequisicoesIncidentesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Pesquisar)))
                        .addGap(24, 24, 24))))
        );

        grafico.setBackground(new java.awt.Color(255, 255, 255));
        grafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        grafico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grafico.setFont(new java.awt.Font("Arial", 1, 3)); // NOI18N

        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico);
        grafico.setLayout(graficoLayout);
        graficoLayout.setHorizontalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1852, Short.MAX_VALUE)
        );
        graficoLayout.setVerticalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        AbrirPlanilha.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        AbrirPlanilha.setText("Abrir planilha de controle dos técnicos");
        AbrirPlanilha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AbrirPlanilha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbrirPlanilhaMouseClicked(evt);
            }
        });

        Assisnatura.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        Assisnatura.setText("by: Hugo Carvalho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AbrirPlanilha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Assisnatura)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AbrirPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Assisnatura))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed

        grafico.removeAll();
        grafico.repaint();

        this.grafico.setLayout(new BorderLayout());

        int duplicado = 0, tabelaDeControlePorTecTempo = 0, numLinhaTecSelecionado = jComboTecnicos.getSelectedIndex();

        if (jCheckDupli.isSelected()) {
            duplicado = 1;
        }

        if (jCheckTabelaDeControlePorTecTempo.isSelected()) {
            tabelaDeControlePorTecTempo = 1;
        }

        try {

            grafico.add(validadorConstrutorDaPesquisa.executarPesquisa(numLinhaTecSelecionado, jComboTecnicos.getItemCount(), duplicado, tabelaDeControlePorTecTempo,
                    jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex(), jComboPorTecTotal.getSelectedIndex(), jComboMes.getSelectedIndex(),
                    jComboRequisicoesIncidentesTotal.getSelectedIndex(), jComboSemana.getSelectedIndex())
            );

        } catch (IOException ex) {

            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*catch (java.lang.NullPointerException ex) {

            JOptionPane.showMessageDialog(null, "Pesquisa inválida!");
        }*/

//JOptionPane.showMessageDialog(null, "Pesquisa Invalida!");
        grafico.validate();
    }//GEN-LAST:event_PesquisarActionPerformed


    private void jComboAbertosPendentesSolucionadosSForaDoPrazoTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAbertosPendentesSolucionadosSForaDoPrazoTempoActionPerformed
        switch (jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex()) {
            case 0:
                jComboPorTecTotal.setEnabled(false);
                jComboPorTecTotal.setSelectedIndex(0);
                jComboTecnicos.setVisible(false);
                jComboMes.setVisible(false);
                jComboSemana.setVisible(false);
                jComboRequisicoesIncidentesTotal.setVisible(false);
                break;
            default:
                jComboPorTecTotal.setEnabled(true);
                jComboPorTecTotal.setSelectedIndex(jComboPorTecTotal.getSelectedIndex());
                break;
        }

    }//GEN-LAST:event_jComboAbertosPendentesSolucionadosSForaDoPrazoTempoActionPerformed

    private void jComboPorTecTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPorTecTotalActionPerformed

        switch (jComboPorTecTotal.getSelectedIndex()) {
            case 0:
                jComboTecnicos.setVisible(false);
                jComboMes.setVisible(false);
                jComboSemana.setVisible(false);
                jComboRequisicoesIncidentesTotal.setVisible(false);
                jCheckDupli.setVisible(false);
                break;
            case 1:
                jComboTecnicos.setVisible(true);
                jComboMes.setVisible(true);
                jComboSemana.setVisible(true);
                if (jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex() == 5 || jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex() == 4) {
                    jComboRequisicoesIncidentesTotal.setVisible(true);
                } else {
                    jComboRequisicoesIncidentesTotal.setVisible(false);
                }
                jCheckDupli.setVisible(false);
                break;
            case 2:
                jComboTecnicos.setVisible(false);
                if (jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex() != 4) {
                    jComboMes.setVisible(true);
                } else {
                    jComboMes.setVisible(false);
                }
                jComboSemana.setVisible(false);
                jComboRequisicoesIncidentesTotal.setVisible(true);
                if (jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex() != 5) {
                    jCheckDupli.setVisible(true);
                } else {
                    jCheckDupli.setVisible(false);
                }
                if (jComboAbertosPendentesSolucionadosSForaDoPrazoTempo.getSelectedIndex() == 3) {
                    jCheckTabelaDeControlePorTecTempo.setVisible(true);
                } else {
                    jCheckTabelaDeControlePorTecTempo.setVisible(false);
                    jCheckTabelaDeControlePorTecTempo.setSelected(false);
                    jCheckDupli.setEnabled(true);
                }
                break;
        }

    }//GEN-LAST:event_jComboPorTecTotalActionPerformed

    private void jComboSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSemanaActionPerformed

        if (programaIniciado) {

            ArrayList<String> tecsSemana;

            try {

                ArrayList<Integer> primeiroTecDasSemanas = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarPrimeiroTecDasSemanas(jComboMes.getSelectedIndex());

                switch (jComboSemana.getSelectedIndex()) {
                    case 0:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(0));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;

                    case 1:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(1));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                    case 2:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(2));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                    case 3:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(3));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                    case 4:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(4));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                    case 5:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecSemana(jComboMes.getSelectedIndex(), primeiroTecDasSemanas.get(5));
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                    case 6:
                        tecsSemana = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarNomesTecMes(jComboMes.getSelectedIndex());
                        jComboTecnicos.removeAllItems();

                        for (int i = 0; i < tecsSemana.size(); i++) {
                            jComboTecnicos.addItem(tecsSemana.get(i));
                        }
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Inicial.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_jComboSemanaActionPerformed

    private void jComboAnoDaPlanilhaCarregadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAnoDaPlanilhaCarregadaActionPerformed
        if (jComboAnoDaPlanilhaCarregada.getSelectedIndex() > 0 && programaIniciado) {

            int itemAnteriorSelecionado = jComboAnoDaPlanilhaCarregada.getSelectedIndex() - 1;
            try {

                Splash splash = new Splash();
                splash.setVisible(true);
                boolean buscouArquivo = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarArquivo(jComboAnoDaPlanilhaCarregada.getItemAt(jComboAnoDaPlanilhaCarregada.getSelectedIndex()));
                splash.dispose();

                if (!buscouArquivo) {
                    JOptionPane.showMessageDialog(null, "Planilha não encontrada!");
                    jComboAnoDaPlanilhaCarregada.setSelectedIndex(itemAnteriorSelecionado);
                }
            } catch (IOException ex) {
                Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboAnoDaPlanilhaCarregadaActionPerformed

    private void AbrirPlanilhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbrirPlanilhaMouseClicked
        try {
            validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().getArquivo().abrirArquivo();
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AbrirPlanilhaMouseClicked

    private void jCheckTabelaDeControlePorTecTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckTabelaDeControlePorTecTempoActionPerformed
        if (jCheckTabelaDeControlePorTecTempo.isSelected()) {
            jCheckDupli.setEnabled(false);
            jCheckDupli.setSelected(false);
        } else {
            jCheckDupli.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckTabelaDeControlePorTecTempoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int itemAnteriorSelecionado = jComboAnoDaPlanilhaCarregada.getSelectedIndex() - 1;
        String itemSelecionado;

        try {

            Splash splash = new Splash();
            splash.setVisible(true);
            boolean buscouArquivo = false;
            try {

                buscouArquivo = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().buscarArquivo();
            } catch (org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException e) {
                JOptionPane.showMessageDialog(null, "Formato não suportado, verifique se a extenção do arquivo é .xlsx!");
            }
            itemSelecionado = validadorConstrutorDaPesquisa.getBuscadorManipuladorDeDados().getArquivo().getDiretorio().toString().split("- ")[1];
            itemSelecionado = itemSelecionado.split(Pattern.quote("."))[0];
            jComboAnoDaPlanilhaCarregada.setSelectedItem(itemSelecionado);
            splash.dispose();

            if (!buscouArquivo) {
                JOptionPane.showMessageDialog(null, "Planilha não encontrada!");
                jComboAnoDaPlanilhaCarregada.setSelectedIndex(itemAnteriorSelecionado);
            }
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMesActionPerformed

        jComboSemana.setSelectedIndex(jComboSemana.getSelectedIndex());
    }//GEN-LAST:event_jComboMesActionPerformed

    public static void main(String args[]) throws IOException {

        Splash splash = new Splash();

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splash.setVisible(true);
            }
        });
        Inicial inicial = new Inicial();
        splash.dispose();
        inicial.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AbrirPlanilha;
    private javax.swing.JLabel Assisnatura;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JPanel grafico;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckDupli;
    private javax.swing.JCheckBox jCheckTabelaDeControlePorTecTempo;
    private javax.swing.JComboBox<String> jComboAbertosPendentesSolucionadosSForaDoPrazoTempo;
    private javax.swing.JComboBox<String> jComboAnoDaPlanilhaCarregada;
    private javax.swing.JComboBox<String> jComboMes;
    private javax.swing.JComboBox<String> jComboPorTecTotal;
    private javax.swing.JComboBox<String> jComboRequisicoesIncidentesTotal;
    private javax.swing.JComboBox<String> jComboSemana;
    private javax.swing.JComboBox<String> jComboTecnicos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
