public class HashTable {
    private  int qtdColisoes;
    private Linha[] tabela;
    private int capacidade;
    private int minhaCapacidade;
    private int maiorQuantidade;
    private int indice;
    private int antepenultimo;
    private int penultimo;
    private int ultimo;

    public HashTable(){
        this.capacidade = 100;
        this.tabela = new Linha[capacidade];

        for(int i = 0; i < capacidade; i++){
            tabela[i] = new Linha(-1);
        }
        this.minhaCapacidade = capacidade;
        this.maiorQuantidade = 0;
        this.indice = -1;
        this.qtdColisoes = 0;

        this.ultimo = 0;
        this.penultimo = 0;
        this.antepenultimo = 0;
    }


    public int getIndice() {
        return indice;
    }

    public int getMinhaCapacidade() {
        return minhaCapacidade;
    }

    public Linha[] getTabela() {
        return tabela;
    }

    public int getQtdColisoes(){
        return qtdColisoes;
    }


    public  int funcaoHash(int chave){
        return chave % capacidade;
    }

    public void inserirHash(int chave){


        int valorLinha = funcaoHash(chave);
        if(tabela[valorLinha].getChave() == -1){
            tabela[valorLinha].setChave(chave);
            minhaCapacidade-= 1;

        }else{
            tabela[valorLinha].getValor().InserirElemento(chave);


            if(tabela[valorLinha].getValor().getQuantidade() > maiorQuantidade){
                maiorQuantidade = tabela[valorLinha].getValor().getQuantidade();
                indice = valorLinha;
            }

            if(tabela[valorLinha].getValor().getQuantidade() == 1){
                qtdColisoes += 1;
            }

            antepenultimo = penultimo ;
            penultimo = ultimo;
            ultimo = chave;



        }
    }

    public void MaiorLista(){
        System.out.println("Quantidade : " + tabela[this.indice].getValor().getQuantidade());
    }

    public void posicoesVazias(){
        System.out.println("Posições Vazias: " + getMinhaCapacidade());
    }
    public void ultimosTresValores(){System.out.println("Ultimos 3 Valores: " + antepenultimo + " " + penultimo + " " + ultimo);}




}
