/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hugo_Carvalho
 */
public class CapturadorDeCelulas {

    public ArrayList<String> datasDaSemana(int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();
        cells.add("D" + (primeiroTecDaSemana - 4));
        cells.add("U" + (primeiroTecDaSemana - 4));
        cells.add("AL" + (primeiroTecDaSemana - 4));
        cells.add("BC" + (primeiroTecDaSemana - 4));
        cells.add("BT" + (primeiroTecDaSemana - 4));
        cells.add("CK" + (primeiroTecDaSemana - 4));
        cells.add("DB" + (primeiroTecDaSemana - 4));

        return cells;
    }

    public ArrayList<String> requisicoesAbertasPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("E" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("V" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AM" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BD" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BU" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CL" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DC" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> incidentesAbertosPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("F" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("G" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("H" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("W" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("X" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("Y" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AN" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AO" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BE" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BF" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BG" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BV" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BW" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BX" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CM" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CN" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CO" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DD" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DE" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DF" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> totalAbertosPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("D" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("U" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AL" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BC" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BT" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CK" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DB" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> requisicoesPendentesPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("J" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AA" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AR" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BI" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BZ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CQ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DH" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> incidentesPendentesPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("K" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("L" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("M" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AB" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AC" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AD" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AS" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AT" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AU" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BJ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BK" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BL" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CA" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CB" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CC" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CR" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CS" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CT" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DI" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DJ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DK" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> totalPendentesPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("I" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("Z" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AQ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BH" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BY" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DG" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> requisicoesSolucionadasPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("O" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AF" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AW" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BN" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CE" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CV" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DM" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> incidentesSolucionadosPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("Q" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("R" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("S" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AH" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AI" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AJ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AY" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AZ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BA" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BQ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BR" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CG" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CH" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CI" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CX" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CY" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CZ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DO" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DQ" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> totalSolucionadosPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("N" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AE" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AV" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BM" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CD" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CU" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DL" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> requisicoesSolucionadasAtrasadasPorTeccNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("P" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AG" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AX" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BO" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CF" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CW" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DN" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> incidentesSolucionadosAtrasadosPorTeccNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("T" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AK" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("AB" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("BS" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CJ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("CA" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("DR" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> requisicoesSolucionadasTempoPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) throws IOException {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("HZ" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("IX" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("JV" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("KT" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("LR" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("MP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("NN" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }

    public ArrayList<String> incidentesSolucionadosTempoPorTecNaSemana(int numLinhaTecSelecionado, int primeiroTecDaSemana) throws IOException {

        ArrayList<String> cells = new ArrayList<>();

        cells.add("EF" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("ER" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("FD" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("FP" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("GB" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("GN" + (primeiroTecDaSemana + numLinhaTecSelecionado));
        cells.add("GZ" + (primeiroTecDaSemana + numLinhaTecSelecionado));

        return cells;
    }
}
