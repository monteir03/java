import java.util.Scanner;

class Losango{

public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();

    int j = 1;
    int k = 0;
    int s = 2;

    while(s<n){
      for(int i=0; i<n; i++){
        if(i>=(n/2+1)){

            for(int b=0; b<(s/2); b++)
              System.out.print('.');
            for(int a=0; a<(n-s); a++)
              System.out.print('#');
            for(int b=0; b<(s/2); b++)
              System.out.print('.');
            s+=2;
        }
        else{
          for(int l= 0; l<((n-(i+j))/2); l++)
              System.out.print('.');
          for(k=1; k<=(i+j); k++)
              System.out.print('#');
          for(int l= 0; l<((n-(i+j))/2); l++)
              System.out.print('.');
          j++;
        }
        System.out.println();
       }
      }
  }
}
