public class  ListaEncadeada{
    private int quantidade = 0;

    public  int  getQuantidade(){
        return this.quantidade;
    }


    class No {
        private int dado;
        No proximo;
        No anterior;

        No(int elemento){
            this.dado = elemento;
            this.proximo = null;
            this.anterior = null;

        }
        public int getDado(){
            return this.dado;
        }

        public void setDado(int dado) {
            this.dado = dado;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
    No inicio = null;


    public void InserirElemento(int elemento) {
        No novoNo = new No(elemento);
        if(inicio == null) {
            inicio = novoNo;
            quantidade ++;
        }else{ // caso não seja nulo percorrer o Nó até achar o proximo nó nulo

            No atual = inicio;
            No anterior = atual;
            if(elemento < atual.dado){
                novoNo.setProximo(atual);
                inicio = novoNo;
                quantidade ++;

            }else{
                if(elemento > atual.dado){

                    while(atual.proximo != null && elemento > atual.dado){
                        anterior = atual;
                        atual = atual.proximo;
                    }

                    if(elemento > atual.dado){
                        atual.setProximo(novoNo);
                        quantidade ++;
                    } else if (elemento < atual.dado ) {

                        novoNo.setProximo(atual);
                        anterior.setProximo(novoNo);
                        quantidade ++;
                    }

                }

            }
        }
    }

    public void RemoveElemento(int elemento){
        if(inicio == null){
            return;
        }

        if(inicio.dado == elemento){
            inicio = inicio.proximo;
            return;
        }

        No atual = inicio;

        while(atual.proximo != null){
            if(atual.proximo.dado == elemento){
                atual.proximo = atual.proximo.proximo;
                return;
            } else{
                atual = atual.proximo;
            }
    }
}


public void exibeLista() {
    No atual = inicio;
    System.out.print("Lista: ");
    while (atual != null) {
        System.out.print(atual.dado + " ");
        atual = atual.proximo; // Move para o próximo nó
    }
    System.out.println();
}


public static void main() {
       ListaEncadeada lista = new ListaEncadeada();

        lista.InserirElemento(10);
        lista.InserirElemento(20);
        lista.InserirElemento(30);

        //lista.RemoveElemento(30);
        lista.exibeLista();
    }
}









