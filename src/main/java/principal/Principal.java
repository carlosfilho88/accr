package principal;

import conexao.ConnectionFactory;
import gui.CadastroItem;
import gui.CadastroUsuario;
import gui.TelaAdministrador;
import gui.TelaAluno;
import gui.TelaLogin;

public class Principal {
    
    public static CadastroUsuario cadastroUsuario;
    public static CadastroItem cadastroItem;
    public static TelaLogin telaLogin;
    public static TelaAluno telaAluno;
    public static TelaAdministrador telaAdministrador;

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.populate();
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        });
    }

}
