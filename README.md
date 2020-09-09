# Enunciado para exercício sobre Problema da Mochila

1. Resolva o problema da mochila conforme o enuciado em sala de aula. 
   1. Ache uma solução que testa todas as combinações possíveis e seleciona a melhor, aplicando divisão-e-conquista ou não;
   1. Contabilize o número de iterações;
   1. Implemente e teste sua solução, para o caso exposto em aula e outros de mesmo porte (;-)).
1. Resolva o problema da mochila utilizando o algoritmo com programação dinâmica visto em aula, teste e contabilize o número de iterações.
1. Monte uma tabela com os resultados e número de iterações de ambas a implementações, para os testes de casos disponíveis no moodle.

```javascript
Inteiro backPackPD(Inteiro N, Inteiro C, Tupla<Inteiro, Inteiro> itens)
   N = número de produtos;
   C = capacidade real da mochila
   itens[N +1];   // (O índice 0 guarda null), Tupla com peso e valor
   maxTab[N+1][C+1];

   Inicialize com 0 toda a linha 0 e também a coluna 0;
   para i = 1 até N
      para j = 1 até C
         se item itens[i].peso <= j // se o item cabe na mochila atual
            maxTab[i][j] = Max(maxTab[i-1][j], 
                               itens[i].valor + 
                                 maxTab[i-1][j – itens[i].peso]);
         senão
            maxTab[i][j] = maxTab[i-1][j];

   retorne maxTab[N][C] // valor máximo para uma mochila de capacidade C e 		         
                        //que pode conter itens que vão do item 1 até o item N.
```
