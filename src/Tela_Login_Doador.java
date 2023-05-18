import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Tela_Login_Doador extends JFrame{
	
	public Tela_Login_Doador(){
		
		setTitle("Login");
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900,700);
		painel.setBackground(Color.decode("#DCDCDC"));
		
		
		
		JLabel lbLogin = new JLabel("Login");
		lbLogin.setFont(new Font("Arial", Font.BOLD, 22));
		lbLogin.setBounds(400,100,80,30);
		
		
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Arial", Font.PLAIN,18));
		lbEmail.setBounds(300,180,80,30);
		
		
		
		JTextField tfEmail = new JTextField("");
		tfEmail.setSize(280,35);
		tfEmail.setColumns(50);
		tfEmail.setBounds(300,220,280,35);
		
		
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Arial", Font.PLAIN,18));
		lbSenha.setBounds(300,320,80,30);
		
		
		
		JPasswordField pfSenha = new JPasswordField("");
		pfSenha.setSize(280,35);
		pfSenha.setColumns(50);
		pfSenha.setBounds(300,360,280,35);
		
		
		
		JButton btLogin = new JButton("LOGIN");
		btLogin.setFont(new Font("Arial", Font.BOLD,15));
		btLogin.setBackground(Color.decode("#808080"));
		btLogin.setSize(150,50);
		btLogin.setBounds(370,500,150,50);
		btLogin.setForeground(Color.white);
		
		
		btLogin.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String email = tfEmail.getText();
						String senha = pfSenha.getText();
						
						boolean validacao = false;
						
						DAO d = new DAO();
						try {
							validacao = d.validarLoginDoador(email, senha);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						if(validacao) {
							dispose();
							new Tela_Principal_Doador().setVisible(true);
						}
					}
					
				}
				
				);
		
		
		
		JLabel lbNovaconta = new JLabel("Não tem uma conta?");
		lbNovaconta.setFont(new Font("Arial", Font.PLAIN, 15));
		lbNovaconta.setBounds(335,570,150,30);
		
		
		
		JLabel lbCriarconta = new JLabel("Criar agora");
		lbCriarconta.setFont(new Font("Arial", Font.BOLD, 15));
		lbCriarconta.setBounds(490,570,100,30);
		lbCriarconta.setForeground(Color.RED);
		
		
		
		lbCriarconta.addMouseListener(
				
				new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						dispose();
						new Tela_Cadastro_Doador().setVisible(true);
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				}
				
				);
		
		
		
		painel.add(lbLogin);
		painel.add(lbEmail);
		painel.add(tfEmail);
		painel.add(lbSenha);
		painel.add(pfSenha);
		painel.add(btLogin);
		painel.add(lbNovaconta);
		painel.add(lbCriarconta);
		
		add(painel);
		setVisible(true);
	}

}
