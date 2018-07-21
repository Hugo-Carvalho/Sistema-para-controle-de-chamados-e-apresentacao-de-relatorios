/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Arquivo {

    private File diretorio;
    private FileInputStream fisPlanilha;
    private XSSFWorkbook workbook;
    private boolean arquivoExecutando;

    public void construirDiretorio(String anoSelecionado) {

        diretorio = new File(new java.io.File("").getAbsolutePath() + "\\Acompanhamento dos Técnicos - " + anoSelecionado + ".xlsx");
    }

    public boolean construirDiretorioManual() throws IOException {

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo...");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("OK");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            return false;
        }

        diretorio = fc.getSelectedFile();
        return true;
    }

    public void executarArquivoAno() throws FileNotFoundException, IOException {

        fisPlanilha = new FileInputStream(diretorio);
        workbook = new XSSFWorkbook(fisPlanilha);
        arquivoExecutando = true;
    }

    public void encerrarArquivoAno() throws FileNotFoundException, IOException {

        workbook.close();
        fisPlanilha.close();
        arquivoExecutando = false;
    }

    public boolean diretorioExiste() {
        return diretorio.exists();
    }

    public XSSFSheet buscarPlanilhaMes(int mesRequerido) {
        return workbook.getSheetAt(mesRequerido);
    }

    public void abrirArquivo() throws IOException {
        java.awt.Desktop.getDesktop().open(diretorio);
    }

    public boolean isArquivoExecutando() {
        return arquivoExecutando;
    }

    public File getDiretorio() {
        return diretorio;
    }
}
