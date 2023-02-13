public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }



    public void removeAll(T value){
      Node<T> cur = first;
      int index = 0;
      for(cur=first; cur!=null; cur = cur.getNext()){
          if(cur.getValue().equals(value)){
              remove(index);
          }
          else{index++;}
      }
  }

   //193moshak
   public int count(T v){
     int count = 0;
     Node<T> cur;
     for(cur=first; cur!=null; cur=cur.getNext())
      if(v.equals(cur.getValue()))
        count++;
     return count;
   }
   //192 moshak

   public SinglyLinkedList<T> copy() {
      SinglyLinkedList<T> copy = new SinglyLinkedList<>();
      Node<T> cur;
      for(cur = first; cur!=null; cur = cur.getNext())
        copy.addLast(cur.getValue());
    return copy;
   }
   //190moshack

   public void duplicate(){
     Node<T> cur=first;
     for(cur=first; cur!=null; cur=cur.getNext().getNext()){
      Node<T> clone = new Node<>(cur.getValue(),cur.getNext());
      cur.setNext(clone);
      size++;
     }
   }

  //191

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

  public T get(int pos){
     Node<T> cur = first;
     for(int i=0; i<size; i++){
       if(i==pos)
          return cur.getValue();
      cur = cur.getNext();
    }
    return null;
   }
  //  188



  public T remove(int pos){
    T v = get(pos);
    if(pos<0 || pos>=size)
      return null;
    else if(pos==0)
      removeFirst();
    else if(pos==(size-1))
      removeLast();
    else{
      Node<T> cur = first;
      for(int i=1; i<pos ; i++){
          cur=cur.getNext();
        }
      cur.setNext(cur.getNext().getNext());
      size--;
      }
    return v;
  }
  //  189

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";
      }
      str += "}";
      return str;
   }
}
