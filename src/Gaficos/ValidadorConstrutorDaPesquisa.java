/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hugo_Carvalho
 */
public class ValidadorConstrutorDaPesquisa {

    private CriadorDeGraficosTabelas criadorDeGraficosTabelas;
    private CapturadorDeCelulas capturadorDeCelulas;
    private BuscadorManipuladorDeDados buscadorManipuladorDeDados;

    public ValidadorConstrutorDaPesquisa() throws IOException {

        criadorDeGraficosTabelas = new CriadorDeGraficosTabelas();
        capturadorDeCelulas = new CapturadorDeCelulas();
        buscadorManipuladorDeDados = new BuscadorManipuladorDeDados();
    }

    public Component executarPesquisa(int numLinhaTecSelecionado, int totalTecs, int duplicadosSelecionado, int tabelaDeControlePorTecTempoSelecionado,
            int abertosPendentesSolucionadosAtrasadosTempoSelecionado, int porTecTotalSelecionado, int mesSelecionado, int requisicoesIncidentesTotalSelecionado,
            int semanaSelecionada) throws IOException {

        ArrayList<Integer> primeirosTecsDasSemanas = buscadorManipuladorDeDados.buscarPrimeiroTecDasSemanas(mesSelecionado);

        if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 1 && porTecTotalSelecionado == 1) {

            if (semanaSelecionada == 6) {

                ArrayList<String> datas = new ArrayList<>();
                datas.add("Semana 1");
                datas.add("Semana 2");
                datas.add("Semana 3");
                datas.add("Semana 4");
                datas.add("Semana 5");
                datas.add("Semana 6");

                ArrayList<Integer> totais = new ArrayList<>(), requisicoes = new ArrayList<>(), incidentes = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    totais.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    requisicoes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    incidentes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(30, 144, 255), totais, requisicoes, incidentes, datas));

            } else {

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(30, 144, 255),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(semanaSelecionada)))
                ));
            }
        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 2 && porTecTotalSelecionado == 1) {

            if (semanaSelecionada == 6) {

                ArrayList<String> datas = new ArrayList<>();
                datas.add("Semana 1");
                datas.add("Semana 2");
                datas.add("Semana 3");
                datas.add("Semana 4");
                datas.add("Semana 5");
                datas.add("Semana 6");

                ArrayList<Integer> totais = new ArrayList<>(), requisicoes = new ArrayList<>(), incidentes = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    totais.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    requisicoes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    incidentes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(139, 0, 0), totais, requisicoes, incidentes, datas));

            } else {

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(139, 0, 0),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(semanaSelecionada)))
                ));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 3 && porTecTotalSelecionado == 1 && numLinhaTecSelecionado != totalTecs - 1) {

            if (semanaSelecionada == 6) {

                ArrayList<String> datas = new ArrayList<>();
                datas.add("Semana 1");
                datas.add("Semana 2");
                datas.add("Semana 3");
                datas.add("Semana 4");
                datas.add("Semana 5");
                datas.add("Semana 6");

                ArrayList<Integer> totais = new ArrayList<>(), requisicoes = new ArrayList<>(), incidentes = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    totais.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    requisicoes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                    incidentes.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(0, 100, 0), totais, requisicoes, incidentes, datas));

            } else {

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalRequisicoesIncidentes(new Color(0, 100, 0),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada))),
                        buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(semanaSelecionada)))
                ));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 1 && porTecTotalSelecionado == 2) {

            if (duplicadosSelecionado == 0) {

                ArrayList<Integer> valores = new ArrayList<>();
                ArrayList<String> datas = new ArrayList<>(), tecnicosDaSemana;

                for (int i = 0; i < 6; i++) {

                    int somaDoPrimeiroDiaDaSemana = 0, somaDoSegundoDiaDaSemana = 0, somaDoTerceiroDiaDaSemana = 0, somaDoQuartoDiaDaSemana = 0, somaDoQuintoDiaDaSemana = 0, somaDoSextoDiaDaSemana = 0, somaDoSetimoDiaDaSemana = 0;
                    tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i));

                    for (int j = 0; j < tecnicosDaSemana.size(); j++) {

                        switch (requisicoesIncidentesTotalSelecionado) {

                            case 0:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;

                            case 1:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;

                            case 2:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;
                        }
                    }

                    valores.add(somaDoPrimeiroDiaDaSemana);
                    valores.add(somaDoSegundoDiaDaSemana);
                    valores.add(somaDoTerceiroDiaDaSemana);
                    valores.add(somaDoQuartoDiaDaSemana);
                    valores.add(somaDoQuintoDiaDaSemana);
                    valores.add(somaDoSextoDiaDaSemana);
                    valores.add(somaDoSetimoDiaDaSemana);
                    datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                }

                return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(30, 144, 255), valores, datas));
            } else {

                ArrayList<Integer> valores = new ArrayList<>();
                ArrayList<String> datas = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    int linhaTotalSemDuplicadas = buscadorManipuladorDeDados.buscarLinhaUltimoTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i)) + 1;

                    switch (requisicoesIncidentesTotalSelecionado) {

                        case 0:
                            valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;

                        case 1:
                            valores.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;

                        case 2:
                            valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;
                    }
                }

                return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(30, 144, 255), valores, datas));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 2 && porTecTotalSelecionado == 2) {

            if (duplicadosSelecionado == 0) {

                ArrayList<Integer> valores = new ArrayList<>();
                ArrayList<String> datas = new ArrayList<>(), tecnicosDaSemana;

                for (int i = 0; i < 6; i++) {

                    int somaDoPrimeiroDiaDaSemana = 0, somaDoSegundoDiaDaSemana = 0, somaDoTerceiroDiaDaSemana = 0, somaDoQuartoDiaDaSemana = 0, somaDoQuintoDiaDaSemana = 0, somaDoSextoDiaDaSemana = 0, somaDoSetimoDiaDaSemana = 0;
                    tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i));

                    for (int j = 0; j < tecnicosDaSemana.size(); j++) {

                        switch (requisicoesIncidentesTotalSelecionado) {

                            case 0:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;

                            case 1:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;

                            case 2:
                                somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                break;
                        }
                    }

                    valores.add(somaDoPrimeiroDiaDaSemana);
                    valores.add(somaDoSegundoDiaDaSemana);
                    valores.add(somaDoTerceiroDiaDaSemana);
                    valores.add(somaDoQuartoDiaDaSemana);
                    valores.add(somaDoQuintoDiaDaSemana);
                    valores.add(somaDoSextoDiaDaSemana);
                    valores.add(somaDoSetimoDiaDaSemana);
                    datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                }

                return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(139, 0, 0), valores, datas));
            } else {

                ArrayList<Integer> valores = new ArrayList<>();
                ArrayList<String> datas = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    int linhaTotalSemDuplicadas = buscadorManipuladorDeDados.buscarLinhaUltimoTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i)) + 1;

                    switch (requisicoesIncidentesTotalSelecionado) {

                        case 0:
                            valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesPendentesPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;

                        case 1:
                            valores.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesPendentesPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;

                        case 2:
                            valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalPendentesPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                            datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                            break;
                    }
                }

                return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(139, 0, 0), valores, datas));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 3 && porTecTotalSelecionado == 2) {

            if (tabelaDeControlePorTecTempoSelecionado == 1) {

                ArrayList<String> tecnicos = buscadorManipuladorDeDados.buscarNomesTecMes(mesSelecionado), tecnicosDaSemana, tempos = new ArrayList<>(), temposCapturados;
                ArrayList<Integer> solucionados = new ArrayList<>();
                String tecnico, somaTempo;
                int somaSolucionados;

                for (int i = 0; i < tecnicos.size(); i++) {

                    somaSolucionados = 0;
                    temposCapturados = new ArrayList<>();
                    tecnico = tecnicos.get(i);

                    for (int j = 0; j < 6; j++) {

                        tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(j));

                        for (int k = 0; k < tecnicosDaSemana.size(); k++) {
                            if (tecnico.equals(tecnicosDaSemana.get(k))) {

                                switch (requisicoesIncidentesTotalSelecionado) {

                                    case 0:

                                        somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        break;

                                    case 1:
                                        somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        break;

                                    case 2:
                                        somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                        break;
                                }
                            }
                        }
                    }

                    solucionados.add(somaSolucionados);
                    somaTempo = buscadorManipuladorDeDados.consolidarTempos(temposCapturados);
                    tempos.add(somaTempo);
                }

                return (criadorDeGraficosTabelas.criarTabelaDeControleTempoTec(tecnicos, solucionados, tempos));

            } else {

                if (duplicadosSelecionado == 0) {

                    ArrayList<Integer> valores = new ArrayList<>();
                    ArrayList<String> datas = new ArrayList<>(), tecnicosDaSemana;

                    for (int i = 0; i < 6; i++) {

                        int somaDoPrimeiroDiaDaSemana = 0, somaDoSegundoDiaDaSemana = 0, somaDoTerceiroDiaDaSemana = 0, somaDoQuartoDiaDaSemana = 0, somaDoQuintoDiaDaSemana = 0, somaDoSextoDiaDaSemana = 0, somaDoSetimoDiaDaSemana = 0;
                        tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i));

                        for (int j = 0; j < tecnicosDaSemana.size(); j++) {

                            switch (requisicoesIncidentesTotalSelecionado) {

                                case 0:
                                    somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                    somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                    somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                    somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                    somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                    somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                    somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                    break;

                                case 1:
                                    somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                    somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                    somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                    somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                    somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                    somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                    somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                    break;

                                case 2:
                                    somaDoPrimeiroDiaDaSemana = somaDoPrimeiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(0);
                                    somaDoSegundoDiaDaSemana = somaDoSegundoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(1);
                                    somaDoTerceiroDiaDaSemana = somaDoTerceiroDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(2);
                                    somaDoQuartoDiaDaSemana = somaDoQuartoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(3);
                                    somaDoQuintoDiaDaSemana = somaDoQuintoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(4);
                                    somaDoSextoDiaDaSemana = somaDoSextoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(5);
                                    somaDoSetimoDiaDaSemana = somaDoSetimoDiaDaSemana + buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))).get(6);
                                    break;
                            }
                        }

                        valores.add(somaDoPrimeiroDiaDaSemana);
                        valores.add(somaDoSegundoDiaDaSemana);
                        valores.add(somaDoTerceiroDiaDaSemana);
                        valores.add(somaDoQuartoDiaDaSemana);
                        valores.add(somaDoQuintoDiaDaSemana);
                        valores.add(somaDoSextoDiaDaSemana);
                        valores.add(somaDoSetimoDiaDaSemana);
                        datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                    }

                    return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(0, 100, 0), valores, datas));
                } else {

                    ArrayList<Integer> valores = new ArrayList<>();
                    ArrayList<String> datas = new ArrayList<>();

                    for (int i = 0; i < 6; i++) {

                        int linhaTotalSemDuplicadas = buscadorManipuladorDeDados.buscarLinhaUltimoTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i)) + 1;

                        switch (requisicoesIncidentesTotalSelecionado) {

                            case 0:
                                valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                                break;

                            case 1:
                                valores.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                                break;

                            case 2:
                                valores.addAll(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                datas.addAll(buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(i))));
                                break;
                        }
                    }

                    return (criadorDeGraficosTabelas.criarGraficoDeLinhaDoMes(mesSelecionado, new Color(0, 100, 0), valores, datas));
                }
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 4 && porTecTotalSelecionado == 1 && numLinhaTecSelecionado != totalTecs - 1) {

            if (semanaSelecionada == 6) {

                ArrayList<String> datas = new ArrayList<>();
                datas.add("Semana 1");
                datas.add("Semana 2");
                datas.add("Semana 3");
                datas.add("Semana 4");
                datas.add("Semana 5");
                datas.add("Semana 6");

                ArrayList<Integer> abertos = new ArrayList<>(), solucionados = new ArrayList<>(), atrasados = new ArrayList<>();

                for (int i = 0; i < 6; i++) {

                    switch (requisicoesIncidentesTotalSelecionado) {

                        case 0:
                            abertos.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            solucionados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            atrasados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            break;

                        case 1:
                            abertos.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            solucionados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            atrasados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            break;

                        case 2:
                            abertos.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            solucionados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            atrasados.add(buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i))))
                                    + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)))));
                            break;
                    }
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalAbertosSolucionadosAtrasados(abertos, solucionados, atrasados, datas));

            } else {

                ArrayList<Integer> abertos = new ArrayList<>(), solucionados = new ArrayList<>(), atrasados = new ArrayList<>();

                switch (requisicoesIncidentesTotalSelecionado) {

                    case 0:
                        abertos = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        solucionados = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        atrasados = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        break;

                    case 1:
                        abertos = buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        solucionados = buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        atrasados = buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        break;

                    case 2:
                        abertos = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalAbertosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        solucionados = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));

                        ArrayList<Integer> requisicoesAtrasadas = buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));
                        ArrayList<Integer> incidentesAtrasados = buscadorManipuladorDeDados.buscarValores(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(semanaSelecionada)));

                        for (int i = 0; i < requisicoesAtrasadas.size(); i++) {

                            atrasados.add(requisicoesAtrasadas.get(i) + incidentesAtrasados.get(i));
                        }

                        break;
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalAbertosSolucionadosAtrasados(abertos, solucionados, atrasados,
                        buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(semanaSelecionada)))
                ));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 4 && porTecTotalSelecionado == 2) {

            ArrayList<String> datas = new ArrayList<>(), tecnicosDaSemana;
            datas.add("Janeiro");
            datas.add("Fevereiro");
            datas.add("Março");
            datas.add("Abril");
            datas.add("Maio");
            datas.add("Junho");
            datas.add("Julho");
            datas.add("Agosto");
            datas.add("Setembro");
            datas.add("Outubro");
            datas.add("Novembro");
            datas.add("Dezembro");

            if (duplicadosSelecionado == 0) {

                ArrayList<Integer> abertos = new ArrayList<>(), solucionados = new ArrayList<>(), atrasados = new ArrayList<>();

                for (int i = 0; i < 12; i++) {

                    int somaAbertos = 0, somaSolucionados = 0, somaAtrasados = 0;

                    for (int j = 0; j < 6; j++) {

                        primeirosTecsDasSemanas = buscadorManipuladorDeDados.buscarPrimeiroTecDasSemanas(i);
                        tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(i, primeirosTecsDasSemanas.get(j));

                        for (int k = 0; k < tecnicosDaSemana.size(); k++) {

                            switch (requisicoesIncidentesTotalSelecionado) {

                                case 0:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    break;

                                case 1:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(i, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(i, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    break;

                                case 2:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.totalAbertosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(k, primeirosTecsDasSemanas.get(j))))
                                            + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(k, primeirosTecsDasSemanas.get(j))));
                                    break;
                            }
                        }
                    }

                    abertos.add(somaAbertos);
                    solucionados.add(somaSolucionados);
                    atrasados.add(somaAtrasados);
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalAbertosSolucionadosAtrasados(abertos, solucionados, atrasados, datas));
            } else {

                ArrayList<Integer> abertos = new ArrayList<>(), solucionados = new ArrayList<>(), atrasados = new ArrayList<>();

                for (int i = 0; i < 12; i++) {

                    int somaAbertos = 0, somaSolucionados = 0, somaAtrasados = 0;

                    for (int j = 0; j < 6; j++) {

                        primeirosTecsDasSemanas = buscadorManipuladorDeDados.buscarPrimeiroTecDasSemanas(i);
                        tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(i, primeirosTecsDasSemanas.get(j));
                        int linhaTotalSemDuplicadas = buscadorManipuladorDeDados.buscarLinhaUltimoTecSemana(i, primeirosTecsDasSemanas.get(j)) + 1;

                        for (int k = 0; k < tecnicosDaSemana.size(); k++) {

                            switch (requisicoesIncidentesTotalSelecionado) {

                                case 0:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesAbertasPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(linhaTotalSemDuplicadas, 0)));
                                    break;

                                case 1:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(i, capturadorDeCelulas.incidentesAbertosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValoresEmFormaDeIncidentes(i, capturadorDeCelulas.incidentesSolucionadosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(linhaTotalSemDuplicadas, 0)));
                                    break;

                                case 2:
                                    somaAbertos = somaAbertos + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.totalAbertosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaSolucionados = somaSolucionados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.totalSolucionadosPorTecNaSemana(linhaTotalSemDuplicadas, 0)));
                                    somaAtrasados = somaAtrasados + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.requisicoesSolucionadasAtrasadasPorTeccNaSemana(linhaTotalSemDuplicadas, 0)))
                                            + buscadorManipuladorDeDados.consolidarDados(buscadorManipuladorDeDados.buscarValores(i, capturadorDeCelulas.incidentesSolucionadosAtrasadosPorTeccNaSemana(linhaTotalSemDuplicadas, 0)));
                                    break;
                            }
                        }
                    }

                    abertos.add(somaAbertos);
                    solucionados.add(somaSolucionados);
                    atrasados.add(somaAtrasados);
                }

                return (criadorDeGraficosTabelas.criarGraficoDeBarraTotalAbertosSolucionadosAtrasados(abertos, solucionados, atrasados, datas));
            }

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 5 && porTecTotalSelecionado == 2) {

            ArrayList<Integer> porcentagens;
            ArrayList<String> datasComTempos = new ArrayList<>(), tempos = new ArrayList<>(), temposCapturados, tecnicosDaSemana;
            String somaTempo;

            for (int i = 0; i < 6; i++) {

                temposCapturados = new ArrayList<>();
                tecnicosDaSemana = buscadorManipuladorDeDados.buscarNomesTecSemana(mesSelecionado, primeirosTecsDasSemanas.get(i));

                for (int j = 0; j < tecnicosDaSemana.size() - 1; j++) {

                    switch (requisicoesIncidentesTotalSelecionado) {

                        case 0:
                            temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))));
                            break;

                        case 1:
                            temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))));
                            break;

                        case 2:
                            temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))));
                            temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(j, primeirosTecsDasSemanas.get(i))));
                            break;
                    }
                }

                somaTempo = buscadorManipuladorDeDados.consolidarTempos(temposCapturados);
                tempos.add(somaTempo);
            }

            datasComTempos.add("Semana 1 - " + tempos.get(0));
            datasComTempos.add("Semana 2 - " + tempos.get(1));
            datasComTempos.add("Semana 3 - " + tempos.get(2));
            datasComTempos.add("Semana 4 - " + tempos.get(3));
            datasComTempos.add("Semana 5 - " + tempos.get(4));
            datasComTempos.add("Semana 6 - " + tempos.get(5));

            porcentagens = buscadorManipuladorDeDados.tirarPercentualDasHoras(tempos);

            return (criadorDeGraficosTabelas.criarGraficoDePizzaTempo(porcentagens, datasComTempos));

        } else if (abertosPendentesSolucionadosAtrasadosTempoSelecionado == 5 && porTecTotalSelecionado == 1) {

            ArrayList<Integer> porcentagens;
            ArrayList<String> datasComTempos = new ArrayList<>(), tempos = new ArrayList<>(), temposCapturados = new ArrayList<>(), datas;
            String somaTempo;

            for (int i = 0; i < 6; i++) {

                switch (requisicoesIncidentesTotalSelecionado) {

                    case 0:
                        temposCapturados = buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)));
                        break;

                    case 1:
                        temposCapturados = buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)));
                        break;

                    case 2:
                        temposCapturados = buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.requisicoesSolucionadasTempoPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i)));
                        temposCapturados.addAll(buscadorManipuladorDeDados.buscarValoresEmFormaDeHora(mesSelecionado, capturadorDeCelulas.incidentesSolucionadosTempoPorTecNaSemana(numLinhaTecSelecionado, primeirosTecsDasSemanas.get(i))));
                        break;
                }

                somaTempo = buscadorManipuladorDeDados.consolidarTempos(temposCapturados);
                tempos.add(somaTempo);
            }

            datas = buscadorManipuladorDeDados.buscarData(mesSelecionado, capturadorDeCelulas.datasDaSemana(primeirosTecsDasSemanas.get(semanaSelecionada)));

            for (int i = 0; i < 6; i++) {

                datasComTempos.add(datas.get(i) + " - " + tempos.get(i));
            }

            porcentagens = buscadorManipuladorDeDados.tirarPercentualDasHoras(tempos);

            return (criadorDeGraficosTabelas.criarGraficoDePizzaTempo(porcentagens, datasComTempos));
        }

        return null;
    }

    public BuscadorManipuladorDeDados getBuscadorManipuladorDeDados() {
        return buscadorManipuladorDeDados;
    }
}
