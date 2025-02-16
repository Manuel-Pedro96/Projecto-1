package model.DAO.impl;

import model.DAO.UsuarioDAO;
import model.Usuario;
import main.java.conexao.ConnectionFactory;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection();
    }

    @Override
    public void adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, sexo, data_nascimento, telefone, email, RG, senha, nivel_acesso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, String.valueOf(usuario.getSexo()));
            stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(usuario.getData_nascimento()));
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getRG());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getNivel_acesso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(criarUsuario(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, sexo = ?, data_nascimento = ?, telefone = ?, email = ?, RG = ?, senha = ?, nivel_acesso = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, String.valueOf(usuario.getSexo()));
            stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(usuario.getData_nascimento()));
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getRG());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getNivel_acesso());
            stmt.setInt(9, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorNomeESenha(String nome, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Usuario criarUsuario(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        char sexo = rs.getString("sexo").charAt(0);
        String data_nascimento = rs.getString("data_nascimento");
        String telefone = rs.getString("telefone");
        String email = rs.getString("email");
        String RG = rs.getString("RG");
        String senha = rs.getString("senha");
        String nivel_acesso = rs.getString("nivel_acesso");

        return new Usuario(senha, nivel_acesso, id, nome, sexo, data_nascimento, telefone, email, RG);
    }
}