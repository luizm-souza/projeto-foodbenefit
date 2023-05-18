import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Tela_Cadastro_Doador extends JFrame {
	
	public Tela_Cadastro_Doador() {
		setTitle("Cadastro");
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel painel = new JPanel();
		painel.setLayout(null);
		painel.setSize(900,700);
		painel.setBackground(Color.decode("#DCDCDC"));
		
		
		
		JLabel lbCadastre = new JLabel("Cadastre seus dados");
		lbCadastre.setFont(new Font("Arial", Font.BOLD, 22));
		lbCadastre.setBounds(330,50,230,30);
		
		
		
		JLabel lbNome = new JLabel("*Nome Completo:");
		lbNome.setFont(new Font("Arial", Font.PLAIN,18));
		lbNome.setBounds(50,150,170,30);
		
		
		
		JTextField tfNome = new JTextField("");
		tfNome.setSize(320,35);
		tfNome.setColumns(50);
		tfNome.setBounds(210,150,320,35);
		
		
		
		JLabel lbEmail = new JLabel("*E-mail:");
		lbEmail.setFont(new Font("Arial", Font.PLAIN,18));
		lbEmail.setBounds(50,210,80,30);
		
		
		
		JTextField tfEmail = new JTextField("");
		tfEmail.setSize(280,35);
		tfEmail.setColumns(50);
		tfEmail.setBounds(135,210,280,35);
		
		
		
		JLabel lbEndereco = new JLabel("*Endereço:");
		lbEndereco.setFont(new Font("Arial", Font.PLAIN,18));
		lbEndereco.setBounds(50,270,110,30);
		
		
		
		JTextField tfEndereco = new JTextField("");
		tfEndereco.setSize(280,35);
		tfEndereco.setColumns(50);
		tfEndereco.setBounds(160,270,280,35);
		
		
		
		JLabel lbNumero = new JLabel("*Nº:");
		lbNumero.setFont(new Font("Arial", Font.PLAIN,18));
		lbNumero.setBounds(460,270,50,30);
		
		
		
		JTextField tfNumero = new JTextField("");
		tfNumero.setSize(50,35);
		tfNumero.setColumns(50);
		tfNumero.setBounds(510,270,50,35);
		
		
		
		JLabel lbBairro = new JLabel("*Bairro:");
		lbBairro.setFont(new Font("Arial", Font.PLAIN,18));
		lbBairro.setBounds(580,270,100,30);
		
		
		
		JTextField tfBairro = new JTextField("");
		tfBairro.setSize(180,35);
		tfBairro.setColumns(50);
		tfBairro.setBounds(650,270,180,35);
		
		
		
		JLabel lbSenha = new JLabel("*Senha:");
		lbSenha.setFont(new Font("Arial", Font.PLAIN,18));
		lbSenha.setBounds(50,380,80,30);
		
		
		
		JPasswordField pfSenha = new JPasswordField("");
		pfSenha.setSize(280,35);
		pfSenha.setColumns(50);
		pfSenha.setBounds(135,380,280,35);
		
		
		
		JLabel lbConfirmacaoSenha = new JLabel("*Confirme a senha:");
		lbConfirmacaoSenha.setFont(new Font("Arial", Font.PLAIN,18));
		lbConfirmacaoSenha.setBounds(50,440,160,30);
		
		
		
		JPasswordField pfConfirmacaoSenha = new JPasswordField("");
		pfConfirmacaoSenha.setSize(280,35);
		pfConfirmacaoSenha.setColumns(50);
		pfConfirmacaoSenha.setBounds(230,440,280,35);
		
		
		
		JButton btCadastrar = new JButton("CADASTRAR");
		btCadastrar.setFont(new Font("Arial", Font.BOLD,15));
		btCadastrar.setBackground(Color.decode("#808080"));
		btCadastrar.setSize(150,50);
		btCadastrar.setBounds(370,550,150,50);
		btCadastrar.setForeground(Color.white);
		
		
		
		btCadastrar.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String senha = pfSenha.getText();
						String confsenha = pfConfirmacaoSenha.getText();
						if (tfNome.getText().isEmpty() || tfEmail.getText().isEmpty() || tfEndereco.getText().isEmpty() || tfNumero.getText().isEmpty() || tfBairro.getText().isEmpty() || pfSenha.getText().isEmpty() || pfConfirmacaoSenha.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos");
						}else if(senha.equals(confsenha)){
							String nome = tfNome.getText();
							String email = tfEmail.getText();
							String endereco = tfEndereco.getText();
							int numero = Integer.parseInt(tfNumero.getText());
							String bairro = tfBairro.getText();
							
							
							Doador d = new Doador(nome,email,endereco,numero,bairro,senha);
							
							DAO doadorDAO = new DAO();
							try {
								doadorDAO.salvarDadosDoador(d);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							dispose();
							new Tela_Login_Doador().setVisible(true);
							
							JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
						}else {
							JOptionPane.showMessageDialog(null, "As senhas não coincidem");
						}
					}
					
				}
				
				);
		
		
		
		JLabel lbAtencao = new JLabel("Os campos com * são obrigatórios");
		lbAtencao.setFont(new Font("Arial", Font.PLAIN,18));
		lbAtencao.setBounds(580,620,300,30);
		lbAtencao.setForeground(Color.RED);
		
		
		
		
		painel.add(lbCadastre);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbEmail);
		painel.add(tfEmail);
		painel.add(lbEndereco);
		painel.add(tfEndereco);
		painel.add(lbNumero);
		painel.add(tfNumero);
		painel.add(lbBairro);
		painel.add(tfBairro);
		painel.add(lbSenha);
		painel.add(pfSenha);
		painel.add(lbConfirmacaoSenha);
		painel.add(pfConfirmacaoSenha);
		painel.add(btCadastrar);
		painel.add(lbAtencao);
		
		add(painel);
		setVisible(true);
	}
}
