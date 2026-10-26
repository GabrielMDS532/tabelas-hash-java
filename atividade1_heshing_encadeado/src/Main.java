import java.util.Random;
public class Main {
    static void main(String[] args){
        long seed = 1090;
        Random r = new Random(seed);
        HashTable valor = new HashTable();


        for(int i = 0; i < 1000; i ++){
            int valorGerado = r.nextInt(100_001);
            valor.inserirHash(valorGerado);
        }




        System.out.println("========////////========");
        System.out.println("Índice: " + valor.getIndice());
        System.out.println("Chave: " + valor.getTabela()[valor.getIndice()].getChave());
        System.out.println("Maior Lista: ");
        valor.getTabela()[valor.getIndice()].getValor().exibeLista();
        valor.MaiorLista();

        System.out.println("==========/////////========");
        System.out.println("Quantidade de Listas com Colisões: " + valor.getQtdColisoes());
        valor.posicoesVazias();

        System.out.println("=======//////////=========");
        valor.ultimosTresValores();

    }

}
