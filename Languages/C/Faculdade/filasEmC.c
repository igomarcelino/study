1 //Bibliotecas
2 #include <stdio.h>
3 #include <stdlib.h>
4 #include <locale.h>
5
6 //Constantes
7 #define tamanho 20
8
9 //Estrutura da Senha
10 typedef struct tsenha {
11    int numero;
12    char tipo;
13 } tsenha;
14 
15 //Estrutura da Fila
16 struct tfilabanco {
17    tsenha dados[tamanho];
18    int ini;
19    int fim;
20 };
21
22 //Variáveis globais
23 struct tfilabanco fila;
24 int op, proximo;
25
26 //Protipação
27 void fila_entrar();
28 void fila_sair();
29 void fila_mostrar();
30 void menu_mostrar();
31
32 //Função principal
33 int main(){
34    setlocale(LC_ALL, "Portuguese");
35    op = 1;
36    proximo = 1;
37    fila.ini = 0;
38    fila.fim = 0;
39    while (op != 0) {
40        system("cls");
41        fila_mostrar();
42        menu_mostrar();
43        scanf("%d", &op);
44        switch (op) {
45            case 1:
46                fila_entrar();
47                break;
48            case 2:
49                fila_sair();
50                break;
51        }
52    }
53    return 0;
54 }
55
56 //Adicionar um elemento no final da Fila
57 void fila_entrar(){
58    if (fila.fim == tamanho) {
59        printf("\nA fila está cheia, volte outro dia!\n\n");
60        system("pause");
61        return;
62    }
63
64    char tipo;
65    printf("\nEscolha o tipo do atendimento:");
66    printf("\nC - Comum");
67    printf("\nP - Prioridade");
68    printf("\nR - Rápido: ");
69    scanf(" %c", &tipo);
70    if (tipo != 'C' && tipo != 'P' && tipo != 'R') {
71        printf("\nTipo de atendimento inválido!\n\n");
72        return;
73    }
74    fila.dados[fila.fim].tipo = tipo;
75    fila.dados[fila.fim].numero = proximo;
76    proximo++;
77    fila.fim++;
78 }
79
 //Retirar o primeiro elemento da Fila de acordo com o caixa
 void fila_sair() {
    if (fila.ini == fila.fim) {
        printf("\nFila vazia, mas logo aparece alguém!\n\n");
        system("pause");
    } else {
        int caixa;
        char tipoatendimento;
        printf("\nQual caixa vai atender (1 a 4)?: ");
        scanf("%d", &caixa);
        switch (caixa) {
            case 1:
                tipoatendimento = 'P';
                break;
            case 2:
            case 3:
                tipoatendimento = 'C';
                break;
            case 4:
                tipoatendimento = 'R';
                break;
            default:
                printf("\nValor inválido!");
                return;
        }
        // Define a posição do elemento aser removido como 0
        int posicao = 0;

        // Procura elemento do tipo correspondente
        for (int i = 0; i < tamanho; i++) {
            if (fila.dados[i].tipo == tipoatendimento) {
                posicao = i;
                break;
            }
        }

        printf("\n\n###### ATENDIMENTO #########\n");
        printf("Senha: %c-%d\n", fila.dados[posicao].tipo, fila.dados[posicao].numero);
        printf("Caixa: %d\n", caixa);
        printf("###### ATENDIMENTO #########\n\n");

        // Retira elemento da posição e move os demais
        for (int i = posicao; i < tamanho; i++) {
            fila.dados[i].numero = fila.dados[i+1].numero;
            fila.dados[i].tipo = fila.dados[i+1].tipo;
        }
        fila.dados[fila.fim].numero = 0;
        fila.dados[fila.fim].tipo = ' ';
        fila.fim--;
    }
 }

 //Mostrar o conteúdo da Fila
 void fila_mostrar() {
    int i;
    printf("[ ");
    for (i = 0; i < tamanho; i++) {
        printf("%c-%d ", fila.dados[i].tipo, fila.dados[i].numero);
    }
    printf("]\n\n");
 }

 //Mostrar o menu de opções
 void menu_mostrar() {
    printf("\nEscolha uma opção:\n");
    printf("1 - Nova senha\n");
    printf("2 - Atender\n");
    printf("0 - Sair\n\n");
 }