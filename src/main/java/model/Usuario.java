/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author Francisco Gimbi
 */
public class Usuario extends Pessoa{
    
    private String senha;
    private String nivel_acesso;

    public Usuario(String senha, String nivel_acesso, int ID, String nome, char sexo, String data_nascimento, String telefone, String email, String RG) {
        super(ID, nome, sexo, data_nascimento, telefone, email, RG);
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
    }

    public Usuario(String nivel_acesso, int ID, String nome, String senha) {
        super(ID, nome);
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
    }

    public Usuario(int ID, String nome, String senha) {
        super(ID, nome);
        this.senha = senha;
    }
    

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "senha=" + senha + ", nivel_acesso=" + nivel_acesso;
    }

     
}
