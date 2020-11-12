package br.com.projetoDAO.DAO;

import br.com.projetoDAO.Conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean consulta() {

        String sql = "Select * from pessoa";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "id", "nome", "profissao");

            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível acessar os dados: " + e);

            return false;
        } finally {
            Conexao.desconectar(con);
        }

    }

    public boolean inserir(Pessoa p) {

        String sql = "Insert into pessoa(nome,profissao) "
                + "values(?,?) ";
        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            int r = pst.executeUpdate();

            if (r > 0) {
                System.out.println("Dados inseridos com sucesso");
            }
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possivel inserir os dados" + e);

            return false;

        }

    }

    public boolean atualizar(Pessoa p) {

        String sql = "update pessoa set nome = ?,profissao=? where id = ?";
        con = Conexao.conectar();

        try {

            pst = con.prepareStatement(sql);

            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            pst.setInt(3, p.getId());

            int s = pst.executeUpdate();

            if (s > 0) {
                System.out.println("Dados atualizados com sucesso");
            }
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possivel atualizar os dados" + e);

            return false;
        }

    }

    public boolean delete() {
        String Sql = "DELETE from pessoa where id = ?";
        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(Sql);
            pst.setInt(1, 6);
            
           
            pst.executeUpdate();

            System.out.println("Dados deletado com sucesso");

            return true;
        } catch (Exception e) {
            System.out.println("Não foi possivel deletar os dados" + e);
            return false;
        }
    }

    public boolean consultaID() {

        String sql = "Select * frompessoa where id = ? ";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "id", "nome", "profissao");

            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível acessar os dados: " + e);

            return false;
        } finally {
            Conexao.desconectar(con);
        }

    }

}
