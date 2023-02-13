import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }

   public static Matrix identity(int n){
      Matrix m = new Matrix(n,n);
      for(int i=0; i<m.rows; i++)
        for(int j=0; j<m.cols; j++) {
            m.data[i][j]=0;               //cuidado fodasse asserio
            m.data[i][i]=1;
        }
     return m;
   }

   public Matrix transpose() {
     Matrix mt = new Matrix(cols, rows);
     for(int u=0; u<cols; u++)
      for(int d=0; d<rows; d++)
        mt.data[u][d] = data[d][u];
      return mt;






   }

   public Matrix sum(Matrix m){
     for(int i=0; i<rows; i++)            //se der erro pode ser isto
      for(int j=0; j<cols; j++)
        m.data[i][j]+=data[i][j];
      return m;
   }

   public Matrix multiply(Matrix m){
     Matrix mult = new Matrix(rows,m.cols);
     for(int i=0; i<rows; i++)
      for(int j=0; j<mult.cols; j++){
        int soma=0;
        for(int k=0;k<cols; k++)
          soma+= data[i][k]*m.data[k][j];
        mult.data[i][j]= soma;
      }
      return mult;
   }
}
