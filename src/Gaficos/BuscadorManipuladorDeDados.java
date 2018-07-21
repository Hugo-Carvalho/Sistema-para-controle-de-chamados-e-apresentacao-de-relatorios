/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Hugo_Carvalho
 */
public class BuscadorManipuladorDeDados {

    private XSSFSheet sheet;
    private Arquivo arquivo;
    private int anoExecuntando;

    public BuscadorManipuladorDeDados() throws IOException {

        arquivo = new Arquivo();

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy");
        anoExecuntando = Integer.parseInt(formatarDate.format(data));

        arquivo.construirDiretorio("" + anoExecuntando);
        if (arquivo.diretorioExiste()) {
            arquivo.executarArquivoAno();
        } else {
            while (!arquivo.diretorioExiste()) {

                JOptionPane.showMessageDialog(null, "Planilha de " + anoExecuntando + " não encontrada!");
                anoExecuntando = anoExecuntando - 1;

                if (anoExecuntando == 2016) {
                    int simNao = JOptionPane.showConfirmDialog(null, "Nenhuma planilha foi encontrada!\nDeseja procurar no PC?");
                    switch (simNao) {
                        case 0:
                            boolean arquivoConstruido = false;
                            while (!arquivoConstruido) {
                                
                                try {
                                    
                                    arquivoConstruido = arquivo.construirDiretorioManual();
                                    
                                    if (arquivoConstruido) {
                                        
                                        arquivo.executarArquivoAno();
                                    }
                                } catch (org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException e) {
                                    JOptionPane.showMessageDialog(null, "Formato não suportado, verifique se a extenção do arquivo é .xlsx!");
                                    arquivoConstruido = false;
                                }
                            }   
                            break;
                            
                        default:
                            System.exit(0);
                    }
                } else {
                    arquivo.construirDiretorio("" + anoExecuntando);
                }
            }

            arquivo.executarArquivoAno();
        }
    }

    public boolean buscarArquivo(String anoExecuntando) throws IOException {

        arquivo.encerrarArquivoAno();
        arquivo.construirDiretorio(anoExecuntando);

        if (arquivo.diretorioExiste()) {

            arquivo.executarArquivoAno();
            return true;
        }

        return false;
    }

    public boolean buscarArquivo() throws IOException {

        arquivo.encerrarArquivoAno();
        boolean arquivoConstruido = arquivo.construirDiretorioManual();

        if (arquivoConstruido) {

            arquivo.executarArquivoAno();
            return true;
        }

        return false;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public int getAnoExecuntando() {
        return anoExecuntando;
    }

    public ArrayList<String> buscarNomesTecMes(int mesRequerido) throws IOException {

        int intervaloDeLinhas = 10, linha = 8;

        sheet = arquivo.buscarPlanilhaMes(mesRequerido);
        String nome = "";
        ArrayList<String> nomes = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            while (!nome.equals("NÃO ATRIBUIDOS")) {

                CellReference cellReference = new CellReference("A" + linha);
                Row row = sheet.getRow(cellReference.getRow());
                Cell cell = row.getCell(cellReference.getCol());

                nome = cell.getStringCellValue();
                nomes.add(nome);
                linha = linha + 1;
            }

            linha = linha + intervaloDeLinhas;
        }

        // EXCLUIR OS REPETIDOS.....
        for (int i = 0; i < nomes.size(); i++) {
            for (int j = i + 1; j < nomes.size(); j++) {
                if (nomes.get(i).equals(nomes.get(j)) || nomes.get(j).equals("Selecione...") || nomes.get(j).equals("NÃO ATRIBUIDOS")) {
                    nomes.remove(j);
                    i = -1;
                    break;
                }
            }
        }

        return nomes;
    }

    public ArrayList<String> buscarNomesTecSemana(int mesRequerido, int linhaDoPrimeiroTecDaSemana) throws FileNotFoundException, IOException {

        sheet = arquivo.buscarPlanilhaMes(mesRequerido);
        String nome = "";
        ArrayList<String> nomes = new ArrayList<>();

        while (!nome.equals("NÃO ATRIBUIDOS")) {

            CellReference cellReference = new CellReference("A" + linhaDoPrimeiroTecDaSemana);
            Row row = sheet.getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());

            nome = cell.getStringCellValue();
            nomes.add(nome);
            linhaDoPrimeiroTecDaSemana = linhaDoPrimeiroTecDaSemana + 1;
        }

        return nomes;

    }

    public int buscarLinhaUltimoTecSemana(int mesRequerido, int linha) throws FileNotFoundException, IOException {

        sheet = arquivo.buscarPlanilhaMes(mesRequerido);
        String nome = "";

        while (!nome.equals("NÃO ATRIBUIDOS")) {

            CellReference cellReference = new CellReference("A" + linha);
            Row row = sheet.getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());

            nome = cell.getStringCellValue();
            linha = linha + 1;
        }

        return linha;

    }

    public ArrayList<Integer> buscarPrimeiroTecDasSemanas(int mesRequerido) throws IOException {

        int intervaloDeLinhas = 10;

        int primeiroTecSem1 = 8;
        int ultimoTecSem1 = buscarLinhaUltimoTecSemana(mesRequerido, primeiroTecSem1);

        int primeiroTecSem2 = ultimoTecSem1 + intervaloDeLinhas;
        int ultimoTecSem2 = buscarLinhaUltimoTecSemana(mesRequerido, primeiroTecSem2);

        int primeiroTecSem3 = ultimoTecSem2 + intervaloDeLinhas;
        int ultimoTecSem3 = buscarLinhaUltimoTecSemana(mesRequerido, primeiroTecSem3);

        int primeiroTecSem4 = ultimoTecSem3 + intervaloDeLinhas;
        int ultimoTecSem4 = buscarLinhaUltimoTecSemana(mesRequerido, primeiroTecSem4);

        int primeiroTecSem5 = ultimoTecSem4 + intervaloDeLinhas;
        int ultimoTecSem5 = buscarLinhaUltimoTecSemana(mesRequerido, primeiroTecSem5);

        int primeiroTecSem6 = ultimoTecSem5 + intervaloDeLinhas;

        ArrayList<Integer> primeirosTecsDasSemanas = new ArrayList<>();
        primeirosTecsDasSemanas.add(primeiroTecSem1);
        primeirosTecsDasSemanas.add(primeiroTecSem2);
        primeirosTecsDasSemanas.add(primeiroTecSem3);
        primeirosTecsDasSemanas.add(primeiroTecSem4);
        primeirosTecsDasSemanas.add(primeiroTecSem5);
        primeirosTecsDasSemanas.add(primeiroTecSem6);

        return primeirosTecsDasSemanas;
    }

    public ArrayList<Integer> buscarValores(int mesRequerido, ArrayList<String> cells) throws FileNotFoundException, IOException {

        ArrayList<Integer> nums = new ArrayList<>();

        sheet = arquivo.buscarPlanilhaMes(mesRequerido);
        for (int i = 0; i < cells.size(); i++) {
            CellReference cellReference = new CellReference(cells.get(i));
            Row row = sheet.getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());
            nums.add((int) cell.getNumericCellValue());
        }

        return nums;

    }

    public ArrayList<Integer> buscarValoresEmFormaDeIncidentes(int mesRequerido, ArrayList<String> c) throws IOException {

        ArrayList<Integer> numsI = buscarValores(mesRequerido, c);

        int NUM1 = numsI.get(0) + numsI.get(1) + numsI.get(2);
        int NUM2 = numsI.get(3) + numsI.get(4) + numsI.get(5);
        int NUM3 = numsI.get(6) + numsI.get(7) + numsI.get(8);
        int NUM4 = numsI.get(9) + numsI.get(10) + numsI.get(11);
        int NUM5 = numsI.get(12) + numsI.get(13) + numsI.get(14);
        int NUM6 = numsI.get(15) + numsI.get(16) + numsI.get(17);
        int NUM7 = numsI.get(18) + numsI.get(19) + numsI.get(20);

        numsI.clear();
        numsI.add(NUM1);
        numsI.add(NUM2);
        numsI.add(NUM3);
        numsI.add(NUM4);
        numsI.add(NUM5);
        numsI.add(NUM6);
        numsI.add(NUM7);

        return numsI;
    }

    public ArrayList<String> buscarValoresEmFormaDeTempo(int mesRequerido, ArrayList<String> cells) {

        ArrayList<String> times = new ArrayList<>();
        sheet = arquivo.buscarPlanilhaMes(mesRequerido);

        String time;
        Date suaData;
        CellReference cellReference;
        Row row;
        Cell cell;
        int dias;

        for (int i = 0; i < cells.size(); i++) {

            cellReference = new CellReference(cells.get(i));
            row = sheet.getRow(cellReference.getRow());
            cell = row.getCell(cellReference.getCol());

            suaData = cell.getDateCellValue();

            SimpleDateFormat formatarDate = new SimpleDateFormat("HH:mm");
            time = formatarDate.format(suaData);
            dias = suaData.getDay();
            if (dias < 10) {
                times.add("0" + dias + "|" + time);
            } else {
                times.add(dias + "|" + time);
            }
        }

        return times;
    }

    public ArrayList<String> buscarValoresEmFormaDeHora(int mesRequerido, ArrayList<String> c) throws IOException {

        ArrayList<String> valores = buscarValoresEmFormaDeTempo(mesRequerido, c);

        int hora, min, dia;

        ArrayList<String> times = new ArrayList<>();

        String[] tempo;

        for (int i = 0; i < valores.size(); i++) {

            tempo = valores.get(i).split(Pattern.quote("|"));
            dia = Integer.parseInt(tempo[0]);
            tempo = tempo[1].split(Pattern.quote(":"));
            hora = Integer.parseInt(tempo[0]);
            min = Integer.parseInt(tempo[1]);

            while (dia > 0) {
                hora = hora + 24;
                dia = dia - 1;
            }

            while (min > 59) {
                hora = hora + 1;
                min = min - 60;
            }

            if (hora < 10 && min > 9) {
                times.add("0" + hora + ":" + min);
            } else if (hora > 9 && min < 10) {
                times.add(hora + ":0" + min);
            } else if (hora < 10 && min < 10) {
                times.add("0" + hora + ":0" + min);
            } else if (hora > 9 && min > 9) {
                times.add(hora + ":" + min);
            }
        }

        return times;
    }

    public ArrayList<Integer> tirarPercentualDasHoras(ArrayList<String> tempos) throws IOException {

        ArrayList<Integer> porcentagens = new ArrayList<>(), somas = new ArrayList<>();

        String[] time;
        int hora, min;

        for (int i = 0; i < tempos.size(); i++) {

            time = tempos.get(i).split(Pattern.quote(":"));
            hora = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);

            while (hora > 0) {
                hora = hora - 1;
                min = min + 60;
            }

            somas.add(min);
        }

        int porcentTotal = 0;
        for (int i = 0; i < somas.size(); i++) {

            porcentTotal = porcentTotal + somas.get(i);
        }

        if (porcentTotal != 0) {

            for (int i = 0; i < somas.size(); i++) {

                porcentagens.add((somas.get(i) * 100) / porcentTotal);
            }
        } else {

            return null;
        }

        return porcentagens;
    }

    public int consolidarDados(ArrayList<Integer> dados) {

        int soma = 0;
        for (int i = 0; i < dados.size(); i++) {
            soma = soma + dados.get(i);
        }

        return soma;
    }

    public String consolidarTempos(ArrayList<String> tempos) {

        String[] time;
        int hora = 0, min = 0;
        for (int i = 0; i < tempos.size(); i++) {

            time = tempos.get(i).split(Pattern.quote(":"));
            hora = hora + Integer.parseInt(time[0]);
            min = min + Integer.parseInt(time[1]);

            while (min > 59) {
                hora = hora + 1;
                min = min - 60;
            }
        }

        String horaTotal = "";
        if (hora < 10 && min > 9) {
            horaTotal = "0" + hora + ":" + min;
        } else if (hora > 9 && min < 10) {
            horaTotal = hora + ":0" + min;
        } else if (hora < 10 && min < 10) {
            horaTotal = "0" + hora + ":0" + min;
        } else if (hora > 9 && min > 9) {
            horaTotal = hora + ":" + min;
        }

        return horaTotal;
    }

    public ArrayList<String> buscarData(int mesRequerido, ArrayList<String> cells) throws FileNotFoundException, IOException {

        ArrayList<String> datas = new ArrayList<>();

        sheet = arquivo.buscarPlanilhaMes(mesRequerido);

        String dia, mes;
        Date suaData;
        Calendar calendario;
        CellReference cellReference;
        Row row;
        Cell cell;

        for (int i = 0; i < cells.size(); i++) {

            cellReference = new CellReference(cells.get(i));
            row = sheet.getRow(cellReference.getRow());
            cell = row.getCell(cellReference.getCol());

            suaData = cell.getDateCellValue();
            calendario = Calendar.getInstance();
            calendario.setTime(suaData);

            dia = "" + calendario.get(Calendar.DATE);
            if (Integer.parseInt(dia) < 10) {
                dia = "0" + dia;
            }

            mes = "" + calendario.get(Calendar.MONTH) + 1;

            if (Integer.parseInt(mes) < 10) {
                mes = "0" + mes;
            }

            datas.add(dia + "/" + mes + "/" + calendario.get(Calendar.YEAR));
        }

        return datas;

    }
}
