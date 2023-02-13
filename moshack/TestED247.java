// Interface que define o TAD conjunto de numeros inteiros
public interface IntSet {
    public boolean contains(int x);       // Retorna true se x esta no conjunto
    public boolean add(int x);            // Adiciona x ao conjunto (devolve true se conseguir)
    public boolean remove(int x);         // Remove x do conjunto (devolve true se conseguir)
    public int     size();                // Retorna o numero de elementos do conjunto
    public void    clear();               // Limpa o conjunto (torna-o vazio)
    // Metodos a adicionar (nao existentes na classe base)
    public boolean equals(IntSet s);      // Retorna true se ambos os conjuntos sao iguais
    public IntSet intersection(IntSet s); // devolve um novo conjunto: a intersecao de ambos
}


class ArrayListIntSet implements IntSet{
    private int size;
    private int[] elem;   //equivalente a: private int elem[]

    ArrayListIntSet(int maxSize){
        elem = new int[maxSize];
        size = 0;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
    }

    public boolean contains(int x){
        for (int i=0; i<size; i++){
            if (elem[i] == x)
                return true;
        }
        return false;
    }

    public boolean add(int x){
        if (!contains(x)){
            elem[size] = x;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int x){
        if (contains(x)){
            int pos=0;
            while(elem[pos]!=x) pos++;
            size--;
            elem[pos] = elem[size];
            return true;
        }
        return false;
    }

    public boolean equals(IntSet s){

        if (this.size() != s.size()){return false;}
        for (int i=0; i<s.size();i++){
            if (this.contains(elem[i])==false){return false;}
        }
        return true;
    }

    public IntSet intersection (IntSet s){
        IntSet b = new ArrayListIntSet(size);

        for (int i=0;i<size; i++){
            if (s.contains(this.elem[i]) == true){
                b.add(elem[i]);
            }
        }
        return b;
    }

    public String toString() {
        String res = "{";
        for (int i=0; i<size; i++) {
            if (i>0) res += ",";
            res += elem[i];
        }
        res += "}";
        return res;
    }

}


public class TestED247 {
    public static void main(String[] args) {
	IntSet s1 = new ArrayListIntSet(100);
	IntSet s2 = new ArrayListIntSet(100);

	for (int i=1; i<=5; i++)
	    s1.add(i);
	System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

	for (int i=3; i<=7; i++)
	    s2.add(i);
	System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

	IntSet s3 = s1.intersection(s2);
	System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

	IntSet s4 = s2.intersection(s1);
	System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

	System.out.println("s1.equals(s2) = " + s1.equals(s2));
	System.out.println("s3.equals(s4) = " + s3.equals(s4));
    }
}
