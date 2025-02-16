/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.helper.LoginHelper;
import model.DAO.UsuarioDAO;
import model.DAO.impl.UsuarioDAOImpl;
import model.Usuario;
import view.Login;

/**
 *
 * @author Francisco Gimbi
 */
public class LoginContrller {
    private final Login view;
    private LoginHelper helper;
    private UsuarioDAO usuarioDAO;
    
    public LoginContrller(Login view) {
        this.view=view;
        this.helper= new LoginHelper(view);
        this.usuarioDAO=new UsuarioDAOImpl();
    }
    
    public void entrarNoSistema(){
         if (helper.autenticar()) {
            // Acesso permitido
            view.exibirMensagem("Bem-vindo ao sistema!");
            // Continue com o fluxo do sistema
        } else {
            // Acesso negado
            view.exibirMensagem("Usuário ou senha inválidos");
        }
    }
    public void fizTarefa(){
        System.out.println("Busquei algo no banco de dados");
        this.view.exibirMensagem("Executei o fiz tarefa");
    }
}
