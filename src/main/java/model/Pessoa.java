/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Pessoa {

    protected int id;
    protected String nome;
    protected char sexo;
    protected Date data_nascimento;
    protected String telefone;
    protected String email;
    protected String RG;

    public Pessoa(int ID, String nome) {
        this.id = ID;
        this.nome = nome;
    }

    public Pessoa(int ID, String nome, char sexo, String data_nascimento, String telefone, String email, String RG) {
        this.id = ID;
        this.nome = nome;
        this.sexo = sexo;
        try {
            this.data_nascimento = new SimpleDateFormat("yyyy-MM-dd").parse(data_nascimento);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.telefone = telefone;
        this.email = email;
        this.RG = RG;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "ID=" + id + ", nome=" + nome + ", sexo=" + sexo + ", data_nascimento=" + data_nascimento + ", telefone=" + telefone + ", email=" + email + ", RG=" + RG + '}';
    }
}
