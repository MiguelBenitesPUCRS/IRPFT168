# IRPFT168


### Regras
Um sistema é usado para o cadastramento de contribuintes (pessoas físicas) e cálculo do imposto de renda.<br/>
O cálculo pode ser feito visando a declaração completa ou a declaração simplificada. Os dados necessários para a 
declaração completa são:

* Nome(1) 
* CPF(1) 
* Idade(2)
* Número de dependentes(2)
* Contribuição previdenciária oficial(3)
* Total de rendimentos(3)

(1) Campos obrigatórios para todos os contribuintes<br/>
(2) Campos obrigatórios para os contribuintes que fazem declaração completa<br/>
(3) Campos obrigatórios para permitir o cálculo do imposto (qualquer modalidade)<br/>

## Cálculo do imposto (decl. simplificada)<br/>
A base de cálculo é obtida descontando-se do total de rendimentos a contribuição previdenciária oficial.<br/>
Aplica-se um desconto único de 5% sobre a base de cálculo.<br/>
O imposto a pagar é obtido a partir da base de cálculo:<br/>
* Se a base de cálculo é de até R$ 12.000,00 então o contribuinte está isento (imposto a pagar zero).<br/>
* Se a base de cálculo for maior que R$ 12.000,00 e inferior a R$24.000,00, então o imposto a pagar corresponde a 15% do valor da base de cálculo que excede o valor da faixa anterior.<br/>
* Se a base de cálculo for maior ou igual a R$ 24.000,00, então o imposto a pagar é equivalente ao imposto devido na faixa anterior mais 27,5% do valor da base de cálculo que excede a faixa anterior.<br/>

## Cálculo do imposto (declaração completa)<br/>
A base de cálculo é obtida descontando-se do total de rendimentos a contribuição previdenciária oficial.<br/>
Em função da idade e do número de dependentes do contribuinte deve se aplicar um desconto sobre a base de cálculo.<br/>
* Para contribuintes com menos de 65 anos o desconto é de:
  * 2% se o contribuinte tem até 2 dependentes
  * 3,5% se contribuinte tem entre 3 e 5 dependentes
  * 5% se o contribuinte tem mais de 5 dependentes
* Para contribuintes com 65 anos ou mais o desconto é de:
  * 3% se o contribuinte tem até 2 dependentes
  * 4,5% se contribuinte tem entre 3 e 5 dependentes
  * 6% se o contribuinte tem mais de 5 dependentes

## O imposto a pagar é obtido a partir da base de cálculo:<br/>
* Se a base de cálculo é de até R$ 12.000,00 então o contribuinte está isento (imposto a pagar zero).
* Se a base de cálculo for maior que R$ 12.000,00 e inferior a R$ 24.000,00, então o imposto a pagar corresponde a 15% do valor da base de cálculo que excede o valor da faixa anterior.
* Se a base de cálculo for maior ou igual a R$ 24.000,00, então o imposto a pagar é equivalente ao imposto devido na faixa anterior mais 27,5% do valor da base de cálculo que excede a faixa anterior.
