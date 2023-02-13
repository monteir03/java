import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char[][] m;      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	     rows = r;
	     cols = c;
	     m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	     for (int i=0; i<rows; i++)
          m[i] = in.next().toCharArray();
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
      for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++)
          System.out.print(m[i][j]);
        System.out.println();
      }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
      int iniy, fimy, inix, fimx;
	    int count = 0;
      if(m[y][x]==ALIVE) count-=1;a

      if(y==0){iniy=0; fimy=iniy+2;}
      else if (y==(rows-1)){iniy=(y-1); fimy=iniy+2;}
      else {iniy=y-1; fimy=iniy+3;}

      if(x==0){ inix=0; fimx=inix+2;}
      else if (x==(cols-1)){inix=(x-1); fimx=inix+2;}
      else {inix=x-1; fimx=inix+3;}

      for(int i=iniy; i<fimy && i<(rows); i++)
        for(int j=inix; j<fimx && j<(cols); j++)
          if(m[i][j]==ALIVE)
            count+=1;
	    return count;
    }

    public int get_countAlive(int a, int b){
      return countAlive(a,b);                    //get para print de countAlive
    }
    //——————————————--------------------———————————————————————————————————————
    //----------------------------------------------------————-———------—-—----—-—-
    // Deve fazer uma iteracao; cria nova geracao a partir da actual
    public void iterate() {
      char[][] m2= new char[rows][cols];
      for(int i=0; i<rows; i++)
        for(int j=0; j<cols; j++){
            int num = get_countAlive(i,j);  // não preciso de usar m.method() basta method()
            if(m[i][j]==ALIVE){
              if(num<=1)
                m2[i][j]=DEAD;
              else if(num>=4)
                m2[i][j]=DEAD;
            }
            //erro de don't find simbol por isso estou a usar get
            else if(m[i][j]==DEAD){
              if(num==3)
                m2[i][j]=ALIVE;
            }
        }
        for(int i=0; i<rows; i++)
          for(int j=0; j<cols; j++)
            if(m2[i][j]==ALIVE) m[i][j]=ALIVE;
            else if(m2[i][j]==DEAD) m[i][j]=DEAD;
    }

}


// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	     int rows = in.nextInt();
	     int cols = in.nextInt();
	     int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	     Game g = new Game(rows, cols);

	     g.read(in);
       for(int w=0; w<n; w++)
         g.iterate();
       g.write();

    }
}
