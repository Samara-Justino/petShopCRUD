/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;
import util.PetshopConexao;

/**
 *
 * @author Samara Justino
 */
public class AnimalDAO {

    public void cadastrar(Animal ani) throws ClassNotFoundException, SQLException {
        Connection con = PetshopConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into animal (nome, idade, tipo, sexo, porte, peso, raca, cor, deficiencia, observacao) values (?,?,?,?,?,?,?,?,?,?)");
        comando.setString(1, ani.getNome());
        comando.setString(2, ani.getIdade());
        comando.setString(3, ani.getTipo());
        comando.setString(4, ani.getSexo());
        comando.setString(5, ani.getPorte());
        comando.setDouble(6, ani.getPeso());
        comando.setString(7, ani.getRaca());
        comando.setString(8, ani.getCor());
        comando.setString(9, ani.getDeficiencia());
        comando.setString(10, ani.getObservacao());
        comando.execute();
        con.close();
    }

    public void deletar(Animal ani) throws ClassNotFoundException, SQLException {
        Connection con = PetshopConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from animal where id = ?");
        comando.setInt(1, ani.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Animal ani) throws ClassNotFoundException, SQLException {
        Connection con = PetshopConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update animal set nome = ?, idade = ?, tipo = ?, sexo = ?, porte = ?, peso = ?, raca = ?, cor = ?, deficiencia = ?, observacao = ? where id = ?");
        comando.setString(1, ani.getNome());
        comando.setString(2, ani.getIdade());
        comando.setString(3, ani.getTipo());
        comando.setString(4, ani.getSexo());
        comando.setString(5, ani.getPorte());
        comando.setDouble(6, ani.getPeso());
        comando.setString(7, ani.getRaca());
        comando.setString(8, ani.getCor());
        comando.setString(9, ani.getDeficiencia());
        comando.setString(10, ani.getObservacao());
        comando.setInt(11, ani.getId());
        comando.execute();
        con.close();
    }

    //public void atualizar (Prod prod) throws ClassNotFound
    public Animal consultarById(Animal ani) throws ClassNotFoundException, SQLException {
        Connection con = PetshopConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from animal where id=?");
        comando.setInt(1, ani.getId());
        ResultSet rs = comando.executeQuery();

        Animal a = new Animal();
        if (rs.next()) {
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setIdade(rs.getString("idade"));
            a.setTipo(rs.getString("tipo"));
            a.setSexo(rs.getString("sexo"));
            a.setPorte(rs.getString("porte"));
            a.setPeso(rs.getDouble("peso"));
            a.setRaca(rs.getString("raca"));
            a.setCor(rs.getString("cor"));
            a.setDeficiencia(rs.getString("deficiencia"));
            a.setObservacao(rs.getString("observacao"));
        }

        con.close();
        return a;
    }

    public List<Animal> consultarTodos() throws ClassNotFoundException, SQLException {

        Connection con = PetshopConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from animal");
        ResultSet rs = comando.executeQuery();
        List<Animal> lani = new ArrayList();
        while (rs.next()) {
            Animal ani = new Animal();
            ani.setId(rs.getInt("id"));
            ani.setNome(rs.getString("nome"));
            ani.setIdade(rs.getString("idade"));
            ani.setTipo(rs.getString("tipo"));
            ani.setSexo(rs.getString("sexo"));
            ani.setPorte(rs.getString("porte"));
            ani.setPeso(rs.getDouble("peso"));
            ani.setRaca(rs.getString("raca"));
            ani.setCor(rs.getString("cor"));
            ani.setDeficiencia(rs.getString("deficiencia"));
            ani.setObservacao(rs.getString("observacao"));
            lani.add(ani);
        }
        return lani;
    }
}
