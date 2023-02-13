import java.util.Scanner;

public class ReadNumbers {

   static void writemedia(int v[], int n) {
     int s=0;
     for(int i=0; i<n; i++)
      s+=v[i];
      float media=(float)s/n;

    System.out.printf("%.2f\n", media );
   }


   static void writeamplitude(int v[], int n){
     int min=v[0];
     int max=v[0];
      for(int i=1; i<n; i++){
        if( v[i]<min ) min=v[i];
        else if( v[i]>max) max=v[i];
      }
      int amp = max-min;
      System.out.println(max-min);
   }

   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      int v[] = new int[1000];     // Cria um novo array com espaço para 10 inteiros
      int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem

      for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
         v[i] = stdin.nextInt();

      writemedia(v,n);

      writeamplitude(v, n);


   }
}
