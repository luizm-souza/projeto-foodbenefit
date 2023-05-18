
public class Donatario {
	
	private int id;
	private String nome;
	private String email;
	private int renda;
	private String endereco;
	private int numero;
	private String bairro;
	private String senha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRenda() {
		return renda;
	}
	public void setRenda(int renda) {
		this.renda = renda;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Donatario(String nome, String email, int renda, String endereco, int numero, String bairro, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.renda = renda;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.senha = senha;
	}
	
	
}
