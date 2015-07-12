package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import conexao.ConnectionFactory;
import entidades.Perfil;
import entidades.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class UsuarioDAO implements DAOInterface {

    private static Logger logger;
    private static final String CREATE_QUERY = "INSERT INTO usuario (perfil_id, cpf, nome, senha, data_nascimento, modified, status) VALUES (?,?,?,?,?,?,?)";
    private static final String READ_QUERY = "SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM usuario WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE usuario SET nome = ?, cpf = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM usuario WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM usuario";
    
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

    public List<Usuario> findAll() {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Usuario> usuarios = null;
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(SELECT_ALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            usuarios = new ArrayList<Usuario>();
            
            while(result.next() && result != null) {
                usuario = new Usuario();
                usuario.setId(result.getInt(1));
                usuario.setNome(result.getString(2));
                usuario.setCpf(result.getString(3));
                usuario.setSenha(result.getString(4));
                usuarios.add(usuario);
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
 
        return usuarios;
    }

    public List<Usuario> findByColumn(String columnName, String value) {
        List<Usuario> usuarios = null;
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT id, perfil_id, cpf, nome, senha, created, modified, status FROM usuario WHERE " + columnName + " = ?");
            preparedStatement.setString(1, value);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            usuarios = new ArrayList<Usuario>();
 
            while(result.next() && result != null) {
                usuario = new Usuario();
                usuario.setId(result.getInt(1));
                usuario.setNome(result.getString(2));
                usuario.setCpf(result.getString(3));
                usuario.setSenha(result.getString(4));
                usuarios.add(usuario);
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
 
        return usuarios;
    }

    public List<Usuario> findByCriteria(String criteria, ArrayList<String> values) {
        List<Usuario> usuarios = null;
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT id, perfil_id, cpf, nome, senha, data_nascimento, created, modified, status FROM usuario WHERE " + criteria);
            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setString(i+1, values.get(i));
            }
            //System.out.println(preparedStatement.asSql());
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            usuarios = new ArrayList<Usuario>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
            while(result != null && result.next()) {
                usuario = new Usuario();
                Perfil perfil = new Perfil();
                usuario.setId(result.getInt(1));
                perfil.setId(result.getInt(2));
                usuario.setPerfil(perfil);
                usuario.setCpf(result.getString(3));
                usuario.setNome(result.getString(4));
                usuario.setSenha(result.getString(5));
                usuario.setDataNascimento(result.getDate(6));
                if(result.getString(7) != null)
                    usuario.setCreated(sdf.parse(result.getString(7)));
                if(result.getString(8) != null)
                    usuario.setModified(sdf.parse(result.getString(8)));
                usuario.setStatus(result.getInt(9));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
 
        return usuarios;
    }

}