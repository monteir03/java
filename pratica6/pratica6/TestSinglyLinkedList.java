// -----------------------------------------------------------
// Estruturas de Dados 2022/2023 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2223/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------
public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++)
         list.addLast(i);
      System.out.println(list);

      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Escreve o primeiro e ultimo elementos
      System.out.println("getFirst() = " + list.getFirst());
      System.out.println("getLast() = " + list.getLast());

      SinglyLinkedList<Character> list_2 = new SinglyLinkedList<Character>();
      String s = "aeiou";
      for(int i=0; i<5; i++)
        list_2.addLast(s.charAt(i));

      System.out.println(list_2);

      SinglyLinkedList<Pair> list_3 = new SinglyLinkedList<>();
      Pair[] pairlist = new Pair[9];
      int c=0;
        for(int i=1; i<4; i++)
          for(int j=1; j<4; j++){
            Pair p = new Pair(i,j);
            pairlist[c]=p;
            c++;
        }                 ??????????
      for(int v=0; v<9; v++)
        System.out.println(pairlist[v]);

       System.out.println(list_3);
  }
}
