package business;

public class Pessoa {
	
	String nome;
	String cpf;
	int idade;
	int numDep;
	double contriPrev;
	double totalRend;
	
	public Pessoa(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getNumDep() {
		return numDep;
	}
	public void setNumDep(int numDep) {
		this.numDep = numDep;
	}
	public double getContriPrev() {
		return contriPrev;
	}
	public void setContriPrev(double contriPrev) {
		this.contriPrev = contriPrev;
	}
	public double getTotalRend() {
		return totalRend;
	}
	public void setTotalRend(double totalRend) {
		this.totalRend = totalRend;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", numDep=" + numDep + ", contriPrev="
				+ contriPrev + ", totalRend=" + totalRend + "]";
	}
}
