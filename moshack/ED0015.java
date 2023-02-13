import java.util.Scanner;

class SopaDeLetras{

  private int lins, cols;
  private char[][] sopa;
  private char[][] maux;

  SopaDeLetras(int x, int y){
    lins = x;
    cols = y;
    sopa = new char[x][y];

  }

  public void read(Scanner in){
    for(int i=0; i<lins; i++)
      sopa[i] = in.next().toCharArray();
  }

  public void write(){
    for(int i=0; i<lins; i++){
      for(int j=0; j<cols; j++)
        System.out.print(sopa[i][j]);
      System.out.println();
    }
  }

  public void matrix_auxiliar(){
    maux = new char[lins][cols];
    for(int i=0; i<lins; i++)
      for(int j=0; j<cols; j++)
        maux[i][j]='.';
  }

  public boolean verify_from_point(String s, int x, int y, int incrx,  int incry){ // word in line
    int len = s.length();
    char[] word = s.toCharArray();
    int xx, yy, i, count;
    int flag=0;
    for(i=0, count=1, xx=x, yy=y ; yy<cols && yy>=0 && xx<lins && xx>=0 && i<len; count++, i++, xx+=incrx, yy+=incry)
      if(sopa[xx][yy]!=word[i])
        return false;
    //if(i!=(len-1))´
  //    return false;
    return true;
  }



  public void is_in_matrix(String str){
    int len = str.length();
    int i;
    int j;
    for(i=0; i<lins; i++)
      for(j=0; j<cols; j++){
        if(verify_from_point(str,i,j,1,0))
          alterar_maux(len,str,i,j,1,0);
        else if(verify_from_point(str,i,j,-1,0))
          alterar_maux(len,str,i,j,-1,0);
        else if(verify_from_point(str,j,i,0,1))
          alterar_maux(len,str,j,i,0,1);
        else if(verify_from_point(str,j,i,0,-1))
          alterar_maux(len,str,j,i,0,-1);
    }
  }


  public void alterar_maux(int tamanho, String str, int startx, int starty, int incrx, int incry){   //atualizar em matriz
    char[] word = str.toCharArray();
    for(int i=0, xx=startx, yy=starty; i<tamanho && xx>=0 && xx<lins && yy>=0 && yy<cols; i++, xx+=incrx, yy+=incry)
      maux[xx][yy]=word[i];

  }


  public void verify_words(ListSopa l){
    for(int i=0; i<l.n_words; i++)
      is_in_matrix(l.list[i]);
  }

  public void atualizar(){
    for(int i=0; i<lins; i++)
      for(int j=0; j<cols; j++)
        sopa[i][j]=maux[i][j];
  }
}



class ListSopa{
  int n_words;
  String[] list;

  ListSopa(int x){
    n_words = x;
    list = new String[x];
  }

  public void read(Scanner in){
    for(int i=0; i<n_words; i++)
      list[i] = in.next();
  }

  public void write(){
    for(int i=0; i<n_words; i++)
     System.out.println(list[i]);
  }
}




public class ED0015{
  public static void main(String[] args) {
    int count=0;
    Scanner stdin = new Scanner(System.in);
    int lines = stdin.nextInt();
    int colus = stdin.nextInt();
    while(lines!=0 && colus!=0){
      //contador
      count++ ;
      // class SOPA
      SopaDeLetras sopa = new SopaDeLetras(lines,colus);
      sopa.read(stdin);
      System.out.println("Input #" + count);

      // class LISTA
      int words = stdin.nextInt();
      ListSopa lista = new ListSopa(words);
      lista.read(stdin);
      //jogar jogo
      sopa.matrix_auxiliar();
      sopa.verify_words(lista);
      sopa.atualizar();
      sopa.write();
      //atualizar para avaliar ciclo
      lines = stdin.nextInt();
      colus = stdin.nextInt();
    }
  }
}
