
public class Alimentos {
	
	
	private int id;
	private String nome;
	private String data;
	private int quantidade;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Alimentos(String nome, String data, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.quantidade = quantidade;
	}
	
	
}
