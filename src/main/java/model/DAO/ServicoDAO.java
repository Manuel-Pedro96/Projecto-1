/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.Servico;
import java.util.List;

public interface ServicoDAO {
    void adicionar(Servico servico);
    Servico buscarPorId(int id);
    List<Servico> buscarTodos();
    void atualizar(Servico servico);
    void remover(int id);
}