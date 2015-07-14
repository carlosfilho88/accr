/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import principal.Principal;

/**
 *
 * @author Airon
 */
public class TelaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form TelaAdministrador
     */
    public TelaAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuItem = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuSobre1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel do Administrador");

        menuCadastros.setText("Cadastros");

        menuUsuario.setText("Usuário");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(menuUsuario);

        menuItem.setText("Item");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItem);

        jMenuBar1.add(menuCadastros);

        menuAjuda.setText("Ajuda");
        menuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaActionPerformed(evt);
            }
        });

        menuSobre1.setText("Sobre");
        menuSobre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobre1ActionPerformed(evt);
            }
        });
        menuAjuda.add(menuSobre1);

        jMenuBar1.add(menuAjuda);

        jMenu1.setText("Sair");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        Principal.cadastroUsuario = new CadastroUsuario();
        Principal.cadastroUsuario.setVisible(true);
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActionPerformed
        Principal.cadastroItem = new CadastroItem();
        Principal.cadastroItem.setVisible(true);
    }//GEN-LAST:event_menuItemActionPerformed

    private void menuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaActionPerformed
        
    }//GEN-LAST:event_menuAjudaActionPerformed

    private void menuSobre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobre1ActionPerformed
        new TelaSobre().setVisible(true);
    }//GEN-LAST:event_menuSobre1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenuItem menuItem;
    private javax.swing.JMenuItem menuSobre1;
    private javax.swing.JMenuItem menuUsuario;
    // End of variables declaration//GEN-END:variables
}
