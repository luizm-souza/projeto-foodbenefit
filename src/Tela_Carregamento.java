import java.awt.*;

import javax.swing.*;

public class Tela_Carregamento extends JFrame{
	
	
	
	public Tela_Carregamento(){
		
		setTitle("Carregando");
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900,700);
		painel.setBackground(Color.decode("#DCDCDC"));
		
		
		
		JLabel lbLogo = new JLabel("");
		Icon logo = new ImageIcon(getClass().getResource("images/logo_g.png"));
		lbLogo.setIcon(logo);
		lbLogo.setBounds(260,50,400,220);
		
		
		
		JLabel lbCarregar = new JLabel("");
		Icon carregar = new ImageIcon(getClass().getResource("images/loader.gif"));
		lbCarregar.setIcon(carregar);
		lbCarregar.setBounds(365,400,250,150);
		
		
		
		
	
		
		painel.add(lbLogo);
		painel.add(lbCarregar);
		add(painel);
		setVisible(true);
	}
	
	

}
