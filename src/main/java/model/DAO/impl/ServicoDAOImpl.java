/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO.impl;

import model.DAO.ServicoDAO;
import model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAOImpl implements ServicoDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/barbearia"; // Substitua pelo nome do seu banco de dados
        String user = "root"; // Substitua pelo usuário do banco de dados
        String password = ""; // Substitua pela senha do banco de dados
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void adicionar(Servico servico) {
        String sql = "INSERT INTO servicos (descricao, valor) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setFloat(2, servico.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Servico buscarPorId(int id) {
        String sql = "SELECT * FROM servicos WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarServico(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Servico> buscarTodos() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM servicos";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                servicos.add(criarServico(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicos;
    }

    @Override
    public void atualizar(Servico servico) {
        String sql = "UPDATE servicos SET descricao = ?, valor = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setFloat(2, servico.getValor());
            stmt.setInt(3, servico.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM servicos WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Servico criarServico(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String descricao = rs.getString("descricao");
        float valor = rs.getFloat("valor");
        return new Servico(id, descricao, valor);
    }
}