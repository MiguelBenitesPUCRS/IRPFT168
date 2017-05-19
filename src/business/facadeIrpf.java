package business;

public class facadeIrpf {
	
	//Classe fachada que inicia as outras classes;
	Irpf irpf;
	Pessoa p;
	
	public facadeIrpf() {
		irpf = new Irpf();
	}
		
	public double calculaImpostoSimplificado(){
		return irpf.declaracaoSimplificada(p);
	}

	public double calculaImpostoCompleto(){
		return irpf.declaracaoCompleta(p);
	}
	
	public void recebePessoa(String nome, String cpf, int idade,
			int nDep, double contribuicao, double totalRendimentos){
		p = new Pessoa(nome,cpf, idade);
		p.setNumDep(nDep);
		p.setContriPrev(contribuicao);
		p.setTotalRend(totalRendimentos);
	}
}
