import java.util.Random;
public class Main {
    static void main(String[] args){
        long seed = 1090;
        Random r = new Random(seed);
        HashTable valor = new HashTable();


        for(int i = 0; i < 100; i ++){
            int valorGerado = r.nextInt(100_001);
            valor.inserirHash(valorGerado);
        }

        System.out.println("=======/////////////===========");
        valor.qtdDeColisoes();
        System.out.println("======///////////========");
        System.out.println("Elementos que mais Colidiram!");
        System.out.println("Primeiro: " + valor.getPrimeiro_elemento() + " Colisões: " + valor.getQtdcolisoes_elemento1()
        + " Segundo: " + valor.getSegundo_elemento() + " Colisões :" + valor.getQtdcolisoes_elemento2() + " Terceiro: " + valor.getTerceiro_elemento()
         + " Colisões: " + valor.getQtdcolsioes_elemento3());
        System.out.println("======///////////========");
        System.out.println("Índice de Posições que ficaram vazias: ");
        valor.posicoesVazias();
    }

}
