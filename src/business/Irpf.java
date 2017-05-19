package business;
//** Regra de Negocio **
//0,00              12.000,00
//|-----------------|                 24.000,00         >
//      Isento      |-----------------|
//                          15%       |----------------->
//                                            27,5%            
//|-----------------------------------------------------|
//
//** Exemplo **
//Base de Cálculo total: R$ 36.100,00
//
//Faixas:
//0,00              12.000,00
//|-----------------|                 24.000,00
//      Isento      |-----------------|                 36.100,100
//                          15%       |-----------------|
//                                            27,5%           
//|-----------------------------------------------------|
//       0,00            1.800,00           3.327,50    = 5.127,50


public class Irpf {

	static double FAIXA_A = 12000; //Ate 12000 Isento, entre 12001 e 24000 15% 
	static double FAIXA_B = 24000; //Acima de 24000 27,5%
	
	//Declaracao de imposto Simplificada...
	public double declaracaoSimplificada(Pessoa pessoa) {
		double baseCalculo = (pessoa.getTotalRend() - pessoa.getContriPrev());
		double vlrDesconto = ((baseCalculo * 5.0) / 100);
		baseCalculo = baseCalculo - vlrDesconto;
		if (baseCalculo <= FAIXA_A) {
			return 0.0;
		} else if (baseCalculo > FAIXA_A && baseCalculo < FAIXA_B) {
			return (((baseCalculo - FAIXA_A) * 15.0) / 100);
		} else {
			//primeira faixa Isento, segunda faixa 15%, terceira faixa 27,5%
			return ((((FAIXA_A) * 15.0) / 100) + (((baseCalculo - FAIXA_B) * 27.5) / 100));
		} 
	}
	
	//Declaracao de imposto Completa...
	public double declaracaoCompleta(Pessoa pessoa) {
		double baseCalculo = (pessoa.getTotalRend() - pessoa.getContriPrev());
		double vlrDesconto;
		int idade = pessoa.getIdade();
		int dependentes = pessoa.getNumDep();
		if (idade < 65) {
			if (dependentes <= 2) {
				// 2%
				vlrDesconto = ((baseCalculo * 2.0) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			} else if (dependentes > 2 && dependentes < 5) {
				// 3,5%
				vlrDesconto = ((baseCalculo * 3.5) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			} else {
				// 5%
				vlrDesconto = ((baseCalculo * 5.0) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			}
		} else {
			if (dependentes <= 2) {
				// 3%
				vlrDesconto = ((baseCalculo * 3.0) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			} else if (dependentes > 2 && dependentes < 5) {
				// 4,5%
				vlrDesconto = ((baseCalculo * 4.5) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			} else {
				// 6%
				vlrDesconto = ((baseCalculo * 6.0) / 100);
				baseCalculo = baseCalculo - vlrDesconto;
			}
		}
		if (baseCalculo <= FAIXA_A) {
			return 0.0;
		} else if (baseCalculo > FAIXA_A && baseCalculo < FAIXA_B) {
			return (((baseCalculo - FAIXA_A) * 15.0) / 100);
		} else {
			//primeira faixa Isento, segunda faixa 15%, terceira faixa 27,5%
			return ((((FAIXA_A) * 15.0) / 100) + (((baseCalculo - FAIXA_B) * 27.5) / 100));
		}
	}
}
