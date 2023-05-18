import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tela_Escolha extends JFrame{
	
	public Tela_Escolha(){
		
		setTitle("Escolha");
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900,700);
		painel.setBackground(Color.decode("#DCDCDC"));
		
		
		
		JLabel lbLogo = new JLabel("");
		Icon logo = new ImageIcon(getClass().getResource("images/logo_p.png"));
		lbLogo.setIcon(logo);
		lbLogo.setBounds(340,10,250,137);
		
		
		
		JLabel lbSelecionar = new JLabel("Selecione uma das opções a seguir: ");
		lbSelecionar.setFont(new Font("Arial", Font.BOLD, 25));
		lbSelecionar.setBounds(250,230,450,30);
		
		
		
		JButton doar = new JButton("DOAR");
		doar.setBackground(Color.decode("#808080"));
		doar.setSize(150,50);
		doar.setBounds(390,370,150,50);
		doar.setForeground(Color.white);
		
		
		doar.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						dispose();
						new Tela_Login_Doador().setVisible(true);
					}
					
				}
				
				);
		
		
		
		JButton receber = new JButton("RECEBER");
		receber.setBackground(Color.decode("#808080"));
		receber.setSize(150,50);
		receber.setBounds(390,500,150,50);
		receber.setForeground(Color.white);
		
		
		receber.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						dispose();
						new Tela_Login_Donatario().setVisible(true);
					}
					
				}
				
				);
		
		
		
		painel.add(doar);
		painel.add(receber);
		painel.add(lbLogo);
		painel.add(lbSelecionar);
		add(painel);
		setVisible(true);
	}

}
