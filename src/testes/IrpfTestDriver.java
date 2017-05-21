package testes;

import business.Irpf;
import business.Pessoa;

public class IrpfTestDriver {

	static Irpf irpf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Pessoa p1 = new Pessoa("Ana", "12345678",10);
		
		p1.setContriPrev(1500.0);
		p1.setTotalRend(35500.0);
		p1.setIdade(10);
		p1.setNumDep(0);
		
		System.out.println(p1);
		
		irpf = new Irpf();
		
		//System.out.println(irpf.declaracaoSimplicada(p1));
		System.out.println(irpf.declaracaoCompleta(p1));
	}

}
