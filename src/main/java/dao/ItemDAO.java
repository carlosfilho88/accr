package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexao.ConnectionFactory;
import entidades.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Airon
 */
public class ItemDAO implements DAOInterface{

    private static Logger logger;
    private static final String CREATE_QUERY = "INSERT INTO item (descricao, quantidade) VALUES (?,?)";
    private static final String READ_QUERY = "SELECT id, descricao, quantidade, ano, edicao, autor, created, modified, status FROM item WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE item SET descricao = ?, quantidade = ?, ano = ?, edicao = ?, autor = ?, modified = ?, status = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM item WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM item";
    
    
    public <Item> int insert(Item item) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ((entidades.Item) item).getDescricao());
            preparedStatement.setInt(2, ((entidades.Item) item).getQuantidade());
            preparedStatement.executeUpdate();
            result = preparedStatement.getGeneratedKeys();
 
            if (result != null && result.next()) {
                return result.getInt(1);
            } else {
                return -1;
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
 
        return -1;
    }

    
    public <Item> int update(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public <Item> int delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public <T> T findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Item> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Item> findByColumn(String columnName, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Item> findByCriteria(String criteria, ArrayList<String> values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
