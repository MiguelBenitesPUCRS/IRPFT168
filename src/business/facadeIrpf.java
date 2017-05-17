package business;

public class facadeIrpf {
	
	//Classe fachada que inicia as outras classes;
	Irpf irpf;
	
	public facadeIrpf() {
		irpf = new Irpf();
	}
		
	public double calculaImpostoSimplificado(Pessoa pessoa){
		return irpf.declaracaoSimplificada(pessoa);
	}

	public double calculaImpostoCompleto(Pessoa pessoa){
		return irpf.declaracaoCompleta(pessoa);
	}
}
