import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DAO {
	
	static Connection conn = null;
	boolean status = false;
	Alimentos alimentoDao;
	
	public void salvarDadosDoador (Doador pessoa) throws SQLException, ClassNotFoundException {
		
		conn = new ConexaoBanco().getConnection();
		String SQL = "insert into login_doador (nome, email, endereco, numero, bairro, senha) values(?,?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		psmt.setString(1, pessoa.getNome());
		psmt.setString(2, pessoa.getEmail());
		psmt.setString(3, pessoa.getEndereco());
		psmt.setInt(4, pessoa.getNumero());
		psmt.setString(5, pessoa.getBairro());
		psmt.setString(6, pessoa.getSenha());
		
		psmt.executeUpdate();
		
	}
	
	public void salvarDadosDonatario (Donatario pessoa) throws SQLException, ClassNotFoundException {
		
		conn = new ConexaoBanco().getConnection();
		String SQL = "insert into login_donatario (nome, email, renda, endereco, numero, bairro, senha) values(?,?,?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		psmt.setString(1, pessoa.getNome());
		psmt.setString(2, pessoa.getEmail());
		psmt.setInt(3, pessoa.getRenda());
		psmt.setString(4, pessoa.getEndereco());
		psmt.setInt(5, pessoa.getNumero());
		psmt.setString(6, pessoa.getBairro());
		psmt.setString(7, pessoa.getSenha());
		
		psmt.executeUpdate();
		
	}
	
	public void salvarDadosAlimento (Alimentos pessoa) throws SQLException, ClassNotFoundException {
		
		conn = new ConexaoBanco().getConnection();
		String SQL = "insert into alimento (nome,data,quantidade) values(?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		psmt.setString(1, pessoa.getNome());
		psmt.setString(2, pessoa.getData());
		psmt.setInt(3, pessoa.getQuantidade());
		
		psmt.executeUpdate();
		
	}
	
	
	public void atualizarDadosAlimento (Alimentos alimento) throws ClassNotFoundException, SQLException {
		
		conn = new ConexaoBanco().getConnection();
		String SQL = "update alimento set quantidade = ? where id = ?";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		
		psmt.setInt(1, alimento.getQuantidade());
		psmt.setInt(2, alimento.getId());
		
		
		int retorno = psmt.executeUpdate();
		
		if(retorno == 1) {
			JOptionPane.showMessageDialog(null, "Seu pedido de doação foi feito com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado com sua doação");
		}
	}
	
	
	public boolean validarLoginDoador(String email, String senha) throws ClassNotFoundException, SQLException {
		
		conn = new ConexaoBanco().getConnection();
		
		String SQL = "select * from login_doador where email = ? and senha = ?";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		
		psmt.setString(1, email);
		psmt.setString(2, senha);
		
		ResultSet rs = psmt.executeQuery();
		System.out.println(rs);
		
		if(rs.next()) {
			JOptionPane.showMessageDialog(null, "Login Validado");
			status = true;
		}else {
			JOptionPane.showMessageDialog(null, "Email ou senha incorreto");
		}
		
		return status;
	}
	
	
	public boolean validarLoginDonatario(String email, String senha) throws ClassNotFoundException, SQLException {
		
		conn = new ConexaoBanco().getConnection();
		
		String SQL = "select * from login_donatario where email = ? and senha = ?";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		
		psmt.setString(1, email);
		psmt.setString(2, senha);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()) {
			JOptionPane.showMessageDialog(null, "Login Validado");
			status = true;
		}else {
			JOptionPane.showMessageDialog(null, "Email ou senha incorreto");
		}
		
		return status;
	}
	
	public String validarDoacao(String nome, String data, int quantidade) throws ClassNotFoundException, SQLException {
		
		String id = "";
		conn = new ConexaoBanco().getConnection();
		
		String SQL = "select * from alimento where nome = ? and data = ? and quantidade = ?";
		PreparedStatement psmt = conn.prepareStatement(SQL);
		
		psmt.setString(1, nome);
		psmt.setString(2, data);
		psmt.setInt(3, quantidade);
		
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()) {
			id = rs.getString("id");
		}
		return id;
	}

}
