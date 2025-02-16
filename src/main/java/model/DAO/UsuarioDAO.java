/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    void adicionar(Usuario usuario);
    Usuario buscarPorId(int id);
    List<Usuario> buscarTodos();
    void atualizar(Usuario usuario);
    void remover(int id);
    
    Usuario buscarPorNomeESenha(String nome, String senha); // Adicionar este método

}