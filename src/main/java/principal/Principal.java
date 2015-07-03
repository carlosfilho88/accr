package principal;

import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {
		new ConnectionFactory();
		Usuario u = new Usuario();
		UsuarioDAO ud = new UsuarioDAO();
		u.setNome("Carlos");
		u.setCpf("03451889340");
		ud.insert(u);
		
	}

}
