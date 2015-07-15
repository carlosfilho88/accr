package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.ConnectionFactory;
import entidades.Movimentacao;
import entidades.Perfil;
import entidades.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class MovimentacaoDAO implements DAOInterface {

    private static Logger logger;
    private static final String CREATE_QUERY = "INSERT INTO movimentacoes (perfil_id, cpf, nome, data_nascimento) VALUES (?,?,?,?)";
    private static final String READ_QUERY = "SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM movimentacoes WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE movimentacoes SET perfil_id = ?, cpf = ?, nome = ?, senha = ?, data_nascimento = ?, modified = ?, status = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM movimentacoes WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM movimentacoes";
    
    public <Movimentacao> int insert(Movimentacao movimentacao) {
        return -1;
    }
 
    public <Movimentacao> int update(Movimentacao movimentacao) {
        return -1;
    }
 
    public <Movimentacao> int delete(Movimentacao movimentacao) {
        return -1;
    }

    public Usuario findById(int id) {
        return null;
    }

    public List<Usuario> findAll() {
        return null;
    }

    public List<Movimentacao> findByColumn(String columnName, String value) {
      return null;
    }

    public List<Movimentacao> findByCriteria(String criteria, ArrayList<String> values) {
        List<Movimentacao> movimentacoes = null;
        Movimentacao movimentacao = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM movimentacao WHERE " + criteria);
            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setString(i+1, values.get(i));
            }
            //System.out.println(preparedStatement.asSql());
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            movimentacoes = new ArrayList<Movimentacao>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
            while(result != null && result.next()) {
                movimentacao = new Movimentacao();
                Perfil perfil = new Perfil();
                movimentacao.setId(result.getInt(1));
                perfil.setId(result.getInt(2));
                movimentacoes.add(movimentacao);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                logger.error(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                logger.error(sse.getMessage());
            }
            try {
                conn.close();
            } catch (Exception cse) {
                logger.error(cse.getMessage());
            }
        }
 
        return movimentacoes;
    }

}