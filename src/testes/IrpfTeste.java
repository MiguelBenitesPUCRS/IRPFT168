package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import business.Irpf;
import business.Pessoa;

public class IrpfTeste {

	Pessoa p1;
	
	@Before
	public void setUP(){
		p1 = new Pessoa("Miguel Benites", "88279502068",38);
		p1.setContriPrev(1500);
		p1.setTotalRend(35500);
	}
	
	@Test
	public void testaDeclaracaoSimplicada(){
		double ir;
		Irpf irpf = new Irpf();
		ir = irpf.declaracaoSimplicada(p1);
		//Declaração simplificada o assert é 2282.5, o retorno é em ir, e a flutuação 0.01
		assertEquals(2282.5,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompleta(){
		double ir;
		Irpf irpf = new Irpf();
		ir = irpf.declaracaoCompleta(p1);
		//Declaração simplificada o assert é 2563.0, o retorno é em ir, e a flutuação 0.01
		assertEquals(2563.0,ir,0.01);											
	}
	
}
