public class Node<T>{
  private T value ;
  private Node<T> next; //um nó possui valor e referecia o próximo

  Node(T v, Node<T> n){
    value = v; // metodo construtuor, atribui valor ao nó e
    next = n; // define o next, ou seja
  }
  // como as variaveis sao do campo private
  //necessitamos de getters e de setters
  // get valor set valor get vnext set next sao os gets e sets
  // possiveis e necessários
  public T getvalue(){
    return value;
  }
  public void setvalue(T v){  // nao te esqueças do return tipe incluindo void
    value = v;
  }
  public Node<T> getnext(){
    return next;
  }
  public void setnext(Node<T> n){
    next = n;
  }

}
