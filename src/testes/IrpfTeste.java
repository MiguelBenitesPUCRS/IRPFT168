package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import business.Irpf;
import business.Pessoa;

public class IrpfTeste {

	Pessoa p1;
	Irpf irpf;
	
	@Before
	public void setUP(){
		irpf = new Irpf();
		p1 = new Pessoa("Miguel Benites", "88279502068",38);
		p1.setContriPrev(1500);
		p1.setTotalRend(35500);
	}
	
	@Test
	public void testaDeclaracaoSimplicada(){
		double ir;
		ir = irpf.declaracaoSimplificada(p1);
		//Declaracao simplificada, o Assert eh 4082.5, o retorno eh em ir, e a flutuacao 0.01
		assertEquals(4082.5,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoSimplicadaMenor12000(){
		double ir;
		p1.setContriPrev(200);
		p1.setTotalRend(12000);
		ir = irpf.declaracaoSimplificada(p1);
		assertEquals(0.0,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoSimplicadaMaior12000Menor24000(){
		double ir;
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		ir = irpf.declaracaoSimplificada(p1);
		assertEquals(309.0,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompleta(){
		double ir;
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(4363.0,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep2Menor65Anos(){
		double ir;
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		p1.setNumDep(3);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(342.3,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep6Menor65Anos(){
		double ir;
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		p1.setNumDep(6);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(309.0,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep2Maior65Anos(){
		double ir;
		p1.setIdade(65);
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		p1.setNumDep(2);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(353.4,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep4Maior65Anos(){
		double ir;
		p1.setIdade(65);
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		p1.setNumDep(4);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(320.1,ir,0.01);											
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep6Maior65Anos(){
		double ir;
		p1.setIdade(65);
		p1.setContriPrev(200);
		p1.setTotalRend(15000);
		p1.setNumDep(6);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(286.8,ir,0.01);	
	}
	
	@Test
	public void testaDeclaracaoCompletaNumDep6Maior65AnosBaseMenor(){
		double ir;
		p1.setIdade(65);
		p1.setContriPrev(200);
		p1.setTotalRend(12000);
		p1.setNumDep(6);
		ir = irpf.declaracaoCompleta(p1);
		assertEquals(0.0,ir,0.01);	
	}
	
}
