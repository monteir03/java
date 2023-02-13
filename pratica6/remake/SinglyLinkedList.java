public class SinglyLinkedList<T>{
  private Node<T> first;
  private int size;

  SinglyLinkedList(){  // metoddo Construtor
    first=null;         // first é nullo ou seja a lista foi
    size=0;            // criada mas não possui valores
  }


  //retornar size
  public int getsize(){
    return size;
  }
  //verificar se a lista está vazia
  public  boolean isEmpty(){
    return (size==0);
  }
  //adicionar ao inicio da lista
  public void addFirst(T v){
    Node<T> newnode = new Node(v,first);
    first=newnode;
    size++;
  }

  public void addLast(T v){
    Node<T> newnode = new Node(v, null);
    if(isEmpty()){ newnode=first;}
    else{
      Node<T>cur = first;
      while(cur.getnext()!=null){
        cur=cur.getnext();
      }
      cur.setnext(newnode);
    }
    size++;
  }
  // Retorna o primeiro valor da lista (ou null se a lista for vazia)
  public T getFirst() {
     if (isEmpty()) return null;
     return first.getvalue();
  }

  // Retorna o ultimo valor da lista (ou null se a lista for vazia)
  public T getLast() {
     if (isEmpty()) return null;
     Node<T> cur = first;
     while (cur.getnext() != null)
        cur = cur.getnext();
     return cur.getvalue();
  }

  public void removefirst(){
    if(!isEmpty()){
      first=first.getnext();
      size--;  // nao esquecer de atualizar size please
    }
    return;
  }

  public void removeLast(){
    if(isEmpty()) return;
    if(getsize()==1) first = null;
    else{
      Node<T> cur = first;
      while(cur.getnext().getnext()!=null){
        cur=cur.getnext();
        }
        cur.setnext(null);
      }
    size--;
  }

  public String toString(){
    String ans = "{";
    Node<T> cur = first;
    for(int i=0, i<size-1, i++){
      ans += cur.getvalue();
      cur.getnext();
    }
    ans+= cur.getvalue();


  }

}
