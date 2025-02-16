/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;

import model.Agendamento;
import java.util.List;

public interface AgendamentoDAO {
    void adicionar(Agendamento agendamento);
    Agendamento buscarPorId(int id);
    List<Agendamento> buscarTodos();
    void atualizar(Agendamento agendamento);
    void remover(int id);
}

