/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;
import model.Cliente;
import java.util.List;

public interface ClienteDAO {
    void adicionar(Cliente cliente);
    Cliente buscarPorId(int id);
    List<Cliente> buscarTodos();
    void atualizar(Cliente cliente);
    void remover(int id);
}