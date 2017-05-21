package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.FacadeIrpf;
import business.Pessoa;

public class facadeIrpfTeste {
	
	Pessoa p1;
	FacadeIrpf facade;
	
	@Before
	public void setUP(){
		facade = new FacadeIrpf();
		facade.recebePessoa("Viviane", "70849335016", 40, 2, 1500.00, 39000.00); //4996.88 - 5306.25
	}
	
	@Test
	public void testacalculaImpostoSimplificado(){
		double retorno = facade.calculaImpostoSimplificado();
		assertEquals(4996.88, retorno, 0.01);
	}
	
	@Test
	public void testacalculaImpostoCompleto(){
		double retorno = facade.calculaImpostoCompleto();
		assertEquals(5306.25, retorno, 0.01);		
	}
	
	@Test
	public void testaRecebePessoa(){
		Pessoa pessoa;
		facade.recebePessoa("Miguel", "1234567890", 38, 1, 1500.00, 39000.00); //4996.88 - 5306.25
		pessoa = facade.getPessoa();
		assertEquals("Miguel",pessoa.getNome());
		assertEquals("1234567890",pessoa.getCpf());
		assertEquals(38,pessoa.getIdade());
		assertEquals(1,pessoa.getNumDep());
		assertEquals(1500.00,pessoa.getContriPrev(),0.01);
		assertEquals(39000.00,pessoa.getTotalRend(),0.01);
	}
	

}
