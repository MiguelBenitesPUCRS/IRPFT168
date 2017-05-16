package business;

public class Irpf {

	static double FAIXA_A     = 12000;
	static double FAIXA_B_IN  = 12001;
	static double FAIXA_B_OUT = 24000;
	static double FAIXA_C     = 24001;
	
	//Declaracao de imposto Simplificada...
	public double declaracaoSimplicada(Pessoa pessoa) {
		double baseCalculo = (pessoa.getTotalRend() - pessoa.getContriPrev());
		double vlrDesconto = ((baseCalculo * 5.0) / 100);
		baseCalculo = baseCalculo - vlrDesconto;
		if (baseCalculo <= 12000) {
			return 0.0;
		} else if (baseCalculo > 12000 && baseCalculo < 24000) {
			return (((baseCalculo - 12000) * 15.0) / 100);
		} else {
			//primeira faixa Isento, segunda faixa 15%, terceira faixa 27,5%
			return ((((12000) * 15.0) / 100) + (((baseCalculo - 24000) * 27.5) / 100));
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
		if (baseCalculo <= 12000) {
			return 0.0;
		} else if (baseCalculo > 12000 && baseCalculo < 24000) {
			return (((baseCalculo - 12000) * 15.0) / 100);
		} else {
			//primeira faixa Isento, segunda faixa 15%, terceira faixa 27,5%
			return ((((12000) * 15.0) / 100) + (((baseCalculo - 24000) * 27.5) / 100));
		}
	}
}
