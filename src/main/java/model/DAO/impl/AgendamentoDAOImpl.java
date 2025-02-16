/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO.impl;

import model.DAO.AgendamentoDAO;
import model.Agendamento;
import model.DAO.impl.ClienteDAOImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import model.Cliente;
import model.Servico;

public class AgendamentoDAOImpl implements AgendamentoDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/barbearia"; // Substitua pelo nome do seu banco de dados
        String user = "root"; // Substitua pelo usuário do banco de dados
        String password = ""; // Substitua pela senha do banco de dados
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void adicionar(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (cliente_id, servico_id, valor, data, observacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agendamento.getCliente().getId());
            stmt.setInt(2, agendamento.getServico().getID());
            stmt.setFloat(3, agendamento.getValor());
            stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(agendamento.getData()));
            stmt.setString(5, agendamento.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Agendamento buscarPorId(int id) {
        String sql = "SELECT * FROM agendamentos WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return criarAgendamento(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Agendamento> buscarTodos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                agendamentos.add(criarAgendamento(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamentos;
    }

    @Override
    public void atualizar(Agendamento agendamento) {
        String sql = "UPDATE agendamentos SET cliente_id = ?, servico_id = ?, valor = ?, data = ?, observacao = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agendamento.getCliente().getId());
            stmt.setInt(2, agendamento.getServico().getID());
            stmt.setFloat(3, agendamento.getValor());
            stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(agendamento.getData()));
            stmt.setString(5, agendamento.getObservacao());
            stmt.setInt(6, agendamento.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Agendamento criarAgendamento(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Cliente cliente = new ClienteDAOImpl().buscarPorId(rs.getInt("cliente_id"));
        Servico servico = new ServicoDAOImpl().buscarPorId(rs.getInt("servico_id"));
        float valor = rs.getFloat("valor");
        String dataStr = rs.getString("data");
        String observacao = rs.getString("observacao");

        Agendamento agendamento = null;
        agendamento = new Agendamento(id, cliente, servico, valor, dataStr);
        agendamento.setObservacao(observacao);
        return agendamento;
    }
}
