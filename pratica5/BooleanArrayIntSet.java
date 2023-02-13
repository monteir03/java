public class BooleanArrayIntSet implements IntSet{
  private boolean[] set;
  private int size;

  BooleanArrayIntSet(int input){
    set = new boolean[input+1];
    size=0;
  }

  public boolean contains(int x){
    if(set[x]==true)
      return true;
    return false;
  }

  public boolean add(int x){
    if(!contains(x)){
      if(size==1000001)
        throw new RuntimeException("Maximum Size");
      set[x]=true;
      size+=1;
      return true;
    }
    return false;
  }

  public boolean remove(int x){
    if(contains(x)){
      set[x]=false;
      size-=1;
      return true;
    }
    return false;
  }

  public int size(){
    return size;
  }

  public void clear(){
    for(int i=1; i<1000001; i++){
      set[i]=false;
    size=0;
    }
  }

  public boolean equals(IntSet s){
    if(this.size()!=s.size())
      return false;
    for(int i=1; i<1000001; i++)
      if(set[i]==true && s.contains(i)==false)
        return false;
    return true;
  }

  public IntSet intersection(IntSet s){
    IntSet conj = new BooleanArrayIntSet(1000001);
    for(int i=1; i<1000001; i++){
      if(set[i]==true && s.contains(i))
        conj.add(i);
    }
    return conj;
  }


}
