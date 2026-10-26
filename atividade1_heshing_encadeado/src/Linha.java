public class Linha {
    private int chave;
    private ListaEncadeada valor;

    public Linha(int chave){
        this.chave = chave;
        this.valor = new ListaEncadeada();

    }

    public int getChave() {
        return this.chave;
    }
    public void setChave(int Novachave){
        this.chave = Novachave;
    }

    public ListaEncadeada getValor() {
        return this.valor;
    }


}
