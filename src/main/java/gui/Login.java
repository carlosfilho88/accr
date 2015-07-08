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
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fieldUser;
	private JTextField fieldPass;

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
		
		fieldUser = new JTextField();
		fieldUser.setBounds(66, 53, 167, 31);
		panel.add(fieldUser);
		fieldUser.setColumns(10);
		
		fieldPass = new JTextField();
		fieldPass.setBounds(66, 111, 167, 31);
		panel.add(fieldPass);
		fieldPass.setColumns(10);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(SystemColor.info);
		btnAcessar.setBounds(10, 189, 89, 23);
		panel.add(btnAcessar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fieldUser.setText(null);
				fieldPass.setText(null);
			}
		});
		btnLimpar.setBackground(SystemColor.info);
		btnLimpar.setBounds(111, 189, 89, 23);
		panel.add(btnLimpar);
		
		JLabel lblNewLabel = new JLabel("LibSystem");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Airon\\git\\accr\\src\\main\\java\\images\\images.png"));
		lblNewLabel.setBounds(188, 6, 55, 37);
		panel.add(lblNewLabel);
		
		JLabel lblLibsystem = new JLabel("LibSystem");
		lblLibsystem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblLibsystem.setBounds(111, 16, 75, 16);
		panel.add(lblLibsystem);
	}

}
