import java.util.Arrays;

public class HashTable {
    private  int qtdColisoes;
    private Linha[] tabela;
    private int capacidade;
    private int minhaCapacidade;
    private int CAP_MAX;
    private int indice;
    private int qtd_colisoes;
    private int primeiro_elemento;
    private int segundo_elemento;
    private int terceiro_elemento;
    private int Qtdcolisoes_elemento1;
    private int Qtdcolisoes_elemento2;
    private int Qtdcolsioes_elemento3;

    public HashTable(){
        this.capacidade = 100;
        this.tabela = new Linha[capacidade];

        for(int i = 0; i < capacidade; i++){
            tabela[i] = new Linha(-1);
        }
        this.minhaCapacidade = 0;
        this.indice = -1;
        this.qtdColisoes = 0;
        this.CAP_MAX = (int) (capacidade * 0.9);
        this.qtd_colisoes = 0;
        this.primeiro_elemento = 0;
        this.segundo_elemento = 0;
        this.terceiro_elemento = 0;
        this.Qtdcolisoes_elemento1 = 0;
        this.Qtdcolisoes_elemento2 = 0;
        this.Qtdcolsioes_elemento3 = 0;
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
    public void setQtdColisoes(int qtdColisoes){
        this.qtdColisoes = qtdColisoes;
    }

    public int getCAP_MAX() {
        return CAP_MAX;
    }
    public int getQtd_colisoes(){
        return this.qtd_colisoes;
    }

    public void setQtd_colisoes(int qtd){
        this.qtd_colisoes = qtd;
    }
    public int getPrimeiro_elemento(){
        return this.primeiro_elemento;
    }
    public void setPrimeiro_elemento(int primeiroElemento){
        this.primeiro_elemento = primeiroElemento;
    }

    public int getSegundo_elemento() {
        return segundo_elemento;
    }

    public void setSegundo_elemento(int segundo_elemento) {
        this.segundo_elemento = segundo_elemento;
    }

    public int getTerceiro_elemento() {
        return terceiro_elemento;
    }

    public void setTerceiro_elemento(int terceiro_elemento) {
        this.terceiro_elemento = terceiro_elemento;
    }

    public int getQtdcolisoes_elemento1(){
        return this.Qtdcolisoes_elemento1;
    }
    public void setQtdcolisoes_elemento1(int quantidade){
        this.Qtdcolisoes_elemento1 = quantidade;
    }
    public int getQtdcolisoes_elemento2(){
        return this.Qtdcolisoes_elemento2;
    }
    public void setQtdcolisoes_elemento2(int quantidade){
        this.Qtdcolisoes_elemento2 = quantidade;
    }

    public int getQtdcolsioes_elemento3(){
        return this.Qtdcolsioes_elemento3;
    }
    public void setQtdcolisoes_elemento3(int quantidade){
        this.Qtdcolsioes_elemento3 = quantidade;
    }

    public  int funcaoHash(int chave){
        return chave % capacidade;
    }

    public int r(int chave){
        return (chave +1)% capacidade;
    }



    public void inserirHash(int chave){

        if(minhaCapacidade != getCAP_MAX()){

            int valorLinha = funcaoHash(chave);
            if(tabela[valorLinha].getChave() == -1){
                tabela[valorLinha].setChave(chave);
                minhaCapacidade+= 1;

            }else{

                valorLinha = busca_Heshing(chave);
                if(valorLinha != -1){
                    tabela[valorLinha].setChave(chave);
                    minhaCapacidade += 1;
                }

            }
        }

    }

    public int busca_Heshing(int chave){
        int i = funcaoHash(chave);
        setQtd_colisoes(0);
        while(tabela[i].getChave() != chave && tabela[i].getChave() != -1){
            i = r(i);
            setQtdColisoes(getQtdColisoes() + 1);
            setQtd_colisoes(getQtd_colisoes() + 1);
        }
        if(tabela[i].getChave() == -1){
            if(getQtd_colisoes() > getQtdcolisoes_elemento1()){
                setQtdcolisoes_elemento3(getQtdcolisoes_elemento2());
                setQtdcolisoes_elemento2(getQtdcolisoes_elemento1());
                setQtdcolisoes_elemento1(getQtd_colisoes());
                // -----------------------------------------------------

                setTerceiro_elemento(getSegundo_elemento());
                setSegundo_elemento(getPrimeiro_elemento());
                setPrimeiro_elemento(chave);
            }else{
                if(getQtd_colisoes() > getQtdcolisoes_elemento2()){
                    setQtdcolisoes_elemento3(getQtdcolisoes_elemento2());
                    setTerceiro_elemento(getSegundo_elemento());
                    setQtdcolisoes_elemento2(getQtd_colisoes());
                    setSegundo_elemento(chave);
                } else if (getQtd_colisoes() > getQtdcolsioes_elemento3()) {

                    setTerceiro_elemento(chave);
                    setQtdcolisoes_elemento3(getQtd_colisoes());


                }
            }
            return i;
        }else{
            return -1;
        }
    }

    public void posicoesVazias(){

        for(int i = 0; i < 100; i++){
            if(tabela[i].getChave() == -1){
                System.out.println("Posições Vazias: " +i);;
            }
        }
    }
    public void qtdDeColisoes(){
        System.out.println("QTD de Colisões: " + getQtdColisoes());
    }




}
