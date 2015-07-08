package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(SystemColor.window);
		setTitle("LibSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), null));
		panel.setBounds(5, 6, 429, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(10, 60, 46, 14);
		panel.add(lblUser);
		
		JLabel lblPass = new JLabel("Senha");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(10, 119, 46, 14);
		panel.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(66, 53, 167, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 111, 167, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(SystemColor.info);
		btnAcessar.setBounds(10, 189, 89, 23);
		panel.add(btnAcessar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(SystemColor.info);
		btnLimpar.setBounds(111, 189, 89, 23);
		panel.add(btnLimpar);
	}

}
