import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Tela_Principal_Doador extends JFrame{
	
	public Tela_Principal_Doador(){
		setTitle("Food Benefit");
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900,700);
		painel.setBackground(Color.decode("#DCDCDC"));
		
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu arquivos = new JMenu("Arquivos");
		menuBar.add(arquivos);
		
		
		JMenuItem miSair = new JMenuItem("Sair");
		arquivos.add(miSair);
		
		
		
		JLabel lbCadasto = new JLabel("Cadastre um alimento");
		lbCadasto.setFont(new Font("Arial", Font.BOLD,21));
		lbCadasto.setBounds(350,50,250,30);
		
		
		
		JLabel lbNome = new JLabel("Nome do Alimento:");
		lbNome.setFont(new Font("Arial", Font.PLAIN,18));
		lbNome.setBounds(20,280,170,30);
		
		
		
		JTextField tfNome = new JTextField("");
		tfNome.setSize(200,35);
		tfNome.setColumns(50);
		tfNome.setBounds(180,280,200,35);
		
		
		
		JLabel lbValidade = new JLabel("Data de Validade:");
		lbValidade.setFont(new Font("Arial", Font.PLAIN,18));
		lbValidade.setBounds(500,280,160,30);
		
		
		miSair.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						System.exit(0);
					}
					
				}
				
				);
		
		
		
		JTextField tfValidade = new JTextField("");
		tfValidade.setSize(100,35);
		tfValidade.setColumns(50);
		tfValidade.setBounds(650,280,100,35);
		
		
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		lbQuantidade.setFont(new Font("Arial", Font.PLAIN,18));
		lbQuantidade.setBounds(20,380,110,30);
		
		
		
		JTextField tfQuantidade = new JTextField("");
		tfQuantidade.setSize(50,35);
		tfQuantidade.setColumns(50);
		tfQuantidade.setBounds(130,380,50,35);
		
		
		
		JLabel lbId = new JLabel("Id:");
		lbId.setFont(new Font("Arial", Font.PLAIN,18));
		lbId.setBounds(20,200,50,30);
		
		
		
		JLabel lbIdProduto = new JLabel("");
		lbIdProduto.setFont(new Font("Arial", Font.PLAIN,18));
		lbIdProduto.setBounds(50,200,80,30);
		
		
		
		
		
		
		JButton btCadastrar = new JButton("CADASTRAR");
		btCadastrar.setFont(new Font("Arial", Font.BOLD,15));
		btCadastrar.setBackground(Color.decode("#808080"));
		btCadastrar.setSize(170,50);
		btCadastrar.setBounds(350,550,170,50);
		btCadastrar.setForeground(Color.white);
		
		
		btCadastrar.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (tfNome.getText().isEmpty() && tfValidade.getText().isEmpty() && tfQuantidade.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos");
						}else{
							String nome = tfNome.getText();
							String data = tfValidade.getText();
							int quantidade = Integer.parseInt(tfQuantidade.getText());
							
							
							Alimentos d = new Alimentos(nome,data,quantidade);
							
							DAO alimentosDAO = new DAO();
							try {
								alimentosDAO.salvarDadosAlimento(d);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								String id = alimentosDAO.validarDoacao(nome, data, quantidade);
								id.toString();
								lbIdProduto.setText(id);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
						}
					}
					
				}
				
				);
		
		
		
		setJMenuBar(menuBar);
		
		painel.add(lbCadasto);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbValidade);
		painel.add(tfValidade);
		painel.add(lbQuantidade);
		painel.add(tfQuantidade);
		painel.add(lbId);
		painel.add(lbIdProduto);
		painel.add(btCadastrar);
		add(painel);
		setVisible(true);
	}

}