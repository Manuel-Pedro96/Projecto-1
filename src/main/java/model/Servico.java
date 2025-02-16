/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Francisco Gimbi
 */
public class Servico {
    
    private int ID;
    private String Descricao;
    private float valor;

    public Servico(int ID, String Descricao, float valor) {
        this.ID = ID;
        this.Descricao = Descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    @Override
    public String toString() {
        return  "ID= " + ID + "\nDescricao= " + Descricao + "\nvalor= " + valor;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getID() {
        return ID;
    }
    
}
