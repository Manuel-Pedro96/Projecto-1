/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;



import model.DAO.UsuarioDAO;
import model.DAO.impl.UsuarioDAOImpl;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        
        // Adicionar um novo usuário
        Usuario novoUsuario = new Usuario("senha123", "admin", 1, "Francisco", 'M', "1990-01-01", "999999999", "francisco@example.com", "123456");
        usuarioDAO.adicionar(novoUsuario);
        
        // Buscar usuário por ID
        Usuario usuario = usuarioDAO.buscarPorId(1);
        System.out.println(usuario);
    }
}
