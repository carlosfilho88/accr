package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexao.ConnectionFactory;
import entidades.Usuario;


public class UsuarioDAO implements DAOInterface{

	private static Logger logger;
    private static final String CREATE_QUERY = "INSERT INTO usuarios (nome, cpf) VALUES (?,?)";
    private static final String READ_QUERY = "SELECT id, nome, cpf FROM usuarios WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE usuarios SET nome=? , cpf=? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM usuarios WHERE id = ?";
    
    public <Usuario> int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ((entidades.Usuario) usuario).getNome());
            preparedStatement.setString(2, ((entidades.Usuario) usuario).getCpf());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
 
            if (result.next() && result != null) {
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
 
    public <Usuario> int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, ((entidades.Usuario) usuario).getNome());
            preparedStatement.setString(2, ((entidades.Usuario) usuario).getCpf());
            preparedStatement.setInt(3, ((entidades.Usuario) usuario).getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
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
        return 0;
    }
 
    public <Usuario> int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, ((entidades.Usuario) usuario).getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
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
        return 0;
    }

    public Usuario findById(int id) {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                usuario = new Usuario();
                usuario.setId(result.getInt(1));
                usuario.setNome(result.getString(2));
                usuario.setCpf(result.getString(3));
            } else {
                // TODO
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
 
        return usuario;
    }

}