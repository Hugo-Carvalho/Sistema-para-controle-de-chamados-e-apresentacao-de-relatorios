/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gaficos;

import java.util.ArrayList;

/**
 *
 * @author Hugo_Carvalho
 */
public class Dados {

    private String nome;
    private ArrayList<String> data = new ArrayList<>();
    private ArrayList<Integer> dados = new ArrayList<>();

    public Dados(String nome, ArrayList<String> data, ArrayList<Integer> dados) {

        this.nome = nome;
        for (int i = 0; i < data.size(); i++) {
            this.data.add(i, data.get(i));
        }
        for (int i = 0; i < dados.size(); i++) {
            this.dados.add(i, dados.get(i));
        }

    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public ArrayList<Integer> getDados() {
        return dados;
    }

}
