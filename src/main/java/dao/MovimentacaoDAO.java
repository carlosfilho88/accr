package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.ConnectionFactory;
import entidades.Item;
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
        Usuario usuario = null;
        Item item = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        String baseSql = "SELECT item.descricao, movimentacoes.tipo_movimentacao, movimentacoes.created, movimentacoes.modified, usuario.nome "
                                + "FROM movimentacoes"
                                + " INNER JOIN item ON item.id = movimentacoes.item_id"
                                + " INNER JOIN usuario ON usuario.id = movimentacoes.user_id_modified";
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            
            if(criteria != null && !criteria.isEmpty()) {
                baseSql += " WHERE " + criteria;
                preparedStatement = (PreparedStatement) conn.prepareStatement(baseSql);
                for (int i = 0; i < values.size(); i++) {
                    if (i == values.size())
                        preparedStatement.setString(i+1, "%" + values.get(i) + "%");
                    else
                        preparedStatement.setString(i+1, values.get(i));
                }
            } else
                preparedStatement = (PreparedStatement) conn.prepareStatement(baseSql);
            
            System.out.println(preparedStatement.asSql());
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            movimentacoes = new ArrayList<Movimentacao>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
            while(result != null && result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2) + " ");
                
                movimentacao = new Movimentacao();
                item = new Item();
                item.setDescricao(result.getString(1));
                movimentacao.setItem(item);
                movimentacao.setTipoMovimentacao(result.getString(2));
                if(result.getString(3) != null)
                    movimentacao.setCreated(result.getDate(3));
                if(result.getString(4) != null)
                    movimentacao.setModified(result.getDate(4));
                usuario = new Usuario();
                usuario.setNome(result.getString(5));
                movimentacao.setUsuario(usuario);
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