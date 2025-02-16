/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import model.DAO.UsuarioDAO;
import model.DAO.impl.UsuarioDAOImpl;
import model.Usuario;
import view.Login;

/**
 *
 * @author Francisco Gimbi
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
         //ao usuario"usuario ou senha invalida"
        String nome =view.getTxtUser().getText();
        String senha=view.getTxtSenha().getText();
        Usuario modelo=new Usuario(0,nome,senha);
        
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome=modelo.getNome();
        String senha=modelo.getSenha();
        view.getTxtUser().setText(nome);
        view.getTxtSenha().setText(senha);
    }
    public void limparTela(){
        view.getTxtUser().setText("");
        view.getTxtSenha().setText("");
    }
     public boolean autenticar() {
        Usuario usuario = obterModelo();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuarioEncontrado = usuarioDAO.buscarPorNomeESenha(usuario.getNome(), usuario.getSenha());
        return usuarioEncontrado != null;
    }
    
}
