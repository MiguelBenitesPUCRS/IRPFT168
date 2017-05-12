package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business.Irpf;
import business.Pessoa;

public class PessoaTeste {

	Pessoa pessoa;

	@Before
	public void setUP() {
		pessoa = new Pessoa("Ana", "12345678", 10);
	}

	@Test
	public void testeGetNome() {
		assertEquals(pessoa.getNome(), "Ana");
	}
	
	@Test
	public void testeGetCPF(){
		assertEquals(pessoa.getCpf(),"12345678");
	}
	
	@Test
	public void testeGetIdade(){
		assertEquals(pessoa.getIdade(),10);
	}
	
	@Test
	public void testeSetIdade(){
		pessoa.setIdade(26);
		assertEquals(pessoa.getIdade(),26);
	}
	
	@Test
	public void testeSetNome() {
		pessoa.setNome("Miguel");
		assertEquals(pessoa.getNome(), "Miguel");
	}
	
	@Test
	public void testeSetCPF(){
		pessoa.setCpf("88279502068");
		assertEquals(pessoa.getCpf(),"88279502068");
	}
	
	@Test
	public void testeGetNumDep() {
		assertEquals(pessoa.getNumDep(),0);
	}
	
	@Test
	public void testeSetNumDep() {
		pessoa.setNumDep(1);
		assertEquals(pessoa.getNumDep(),1);
	}
	
	@Test
	public void testeSetContriPrev() {
		pessoa.setContriPrev(1500.0);;
		assertEquals(1500.0,pessoa.getContriPrev(),0.01);
	}
	
	@Test
	public void testeSetTotalRend() {
		pessoa.setTotalRend(32000.0);;
		assertEquals(32000.0,pessoa.getTotalRend(),0.01);
	}
	
	@Test
	public void testeToStringPessoa(){
		//Pessoa [nome=Ana, cpf=12345678, idade=65, numDep=6, contriPrev=200.0, totalRend=12000.0] 0.0
	}
	
}
