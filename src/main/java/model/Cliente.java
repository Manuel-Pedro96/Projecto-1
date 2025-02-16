/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Francisco Gimbi
 */
public class Cliente extends Pessoa{
  
    private String endereco;
    private String CPF;

    public Cliente(String endereco, String CPF, int ID, String nome, char sexo,
            String data_nascimento, String telefone, String email, String RG) {
        
        super(ID, nome, sexo, data_nascimento, telefone, email, RG);
        this.endereco = endereco;
        this.CPF = CPF;
    }

    public Cliente(String endereco, String CPF, int ID, String nome) {
        super(ID, nome);
        this.endereco = endereco;
        this.CPF = CPF;
    }

    public Cliente(int ID, String nome, char sexo, String data_nascimento, String telefone, String email, String RG) {
        super(ID, nome, sexo, data_nascimento, telefone, email, RG);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "endereco=" + endereco + ", CPF=" + CPF + '}';
    }

   
    
    
}
