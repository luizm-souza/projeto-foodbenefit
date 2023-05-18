import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tela_Principal_Donatario extends JFrame{
	
	public Tela_Principal_Donatario() throws ClassNotFoundException, SQLException{
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
		
		miSair.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						System.exit(0);
					}
					
				}
				
				);
		
		
		JButton btnBuscar = new JButton("Atualizar tabela: ");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN,15));
		btnBuscar.setBounds(335,50,200,50);
		btnBuscar.setBackground(Color.decode("#808080"));
		btnBuscar.setForeground(Color.white);
		
		
		
		Connection conn = new ConexaoBanco().getConnection();
		String SQL = "select * from alimento";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		ResultSet rs = psmt.executeQuery();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("nome");
		model.addColumn("data");
		model.addColumn("quantidade");
		while(rs.next()) {
			model.addRow(new Object[] {Integer.parseInt(rs.getString("id")),rs.getString("nome"),rs.getString("data"),Integer.parseInt(rs.getString("quantidade"))});
		}
		btnBuscar.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						try {
							String SQL = "select * from alimento";
							PreparedStatement psmt;
							psmt = conn.prepareStatement(SQL);
							ResultSet rs = psmt.executeQuery();
							
							
							while(rs.next()) {
								model.removeRow(0);
								model.addRow(new Object[] {Integer.parseInt(rs.getString("id")),rs.getString("nome"),rs.getString("data"),Integer.parseInt(rs.getString("quantidade"))});
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
				
				);
		
		
		
		
		
		/*String[] colunas = new String[]{"id", "nome", "data", "quantidade"};
		String[][] dados = new String[][]{};*/
		
		
		
		
		
		
		
		JTable tabela = new JTable();
		tabela.setModel(model);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(0,170,885,200);
		
		
		JLabel lbEscolha = new JLabel("Número do ID do alimento que você vai pegar:");
		lbEscolha.setFont(new Font("Arial", Font.PLAIN,18));
		lbEscolha.setBounds(05,450,400,30);
		
		
		JTextField tfEscolha = new JTextField("");
		tfEscolha.setSize(50,35);
		tfEscolha.setColumns(50);
		tfEscolha.setBounds(400,450,70,35);
		
		
		
		
		
		
		JButton btEscolha = new JButton("ESCOLHER");
		btEscolha.setFont(new Font("Arial", Font.BOLD,15));
		btEscolha.setBackground(Color.decode("#808080"));
		btEscolha.setSize(170,50);
		btEscolha.setBounds(350,550,170,50);
		btEscolha.setForeground(Color.white);
		
		
		btEscolha.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						Connection conn;
						try {
							conn = new ConexaoBanco().getConnection();
							String select = "select * from alimento where id = ?";
							PreparedStatement teste = conn.prepareStatement(select);
							
							teste.setInt(1, Integer.parseInt(tfEscolha.getText()));
							
							ResultSet rsteste = teste.executeQuery();
							
							int resultadot = 0;
							
							//resultadot = Integer.parseInt(rsteste.getString("quantidade"));
							while(rsteste.next()) {
								resultadot = Integer.parseInt(rsteste.getString("quantidade"));
							}
							
							if(resultadot<=0) {
								JOptionPane.showMessageDialog(null, "O alimento escolhido está esgotado, escolha outro");
								
								String SQL = "delete from alimento where id = ?";
								PreparedStatement psmt = conn.prepareStatement(SQL);
								
								psmt.setInt(1, Integer.parseInt(tfEscolha.getText()));
								
								psmt.execute();
								model.removeRow(Integer.parseInt(tfEscolha.getText()));
								
							}else {
								String SQL = "update alimento set quantidade = ? where id = ?";
								PreparedStatement psmt = conn.prepareStatement(SQL);
								resultadot = resultadot-1;
								psmt.setInt(1, resultadot);
								psmt.setInt(2, Integer.parseInt(tfEscolha.getText()));
								
								int retorno = psmt.executeUpdate();
								
								if(retorno == 1) {
									JOptionPane.showMessageDialog(null, "Seu pedido de doação foi feito com sucesso, aguarde a entrega");
								}else {
									JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado com sua doação");
								}
							}
							
							
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
				);
		
		
		
		setJMenuBar(menuBar);
		
		painel.add(btnBuscar);
		painel.add(scroll);
		painel.add(lbEscolha);
		painel.add(tfEscolha);
		painel.add(btEscolha);
		add(painel);
		setVisible(true);
	}

}