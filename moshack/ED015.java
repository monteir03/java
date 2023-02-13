import java.util.Scanner;

public class ED015{
    static char[][] lermapa(int l, int c, Scanner in){
        char mapa[][] = new char[l][c];
        in.useDelimiter("");
        for (int i=0; i<l; i++){
            for (int j=0; j<c; j++){
                if ((mapa[i][j] = in.next().charAt(0)) == '\n')
                    mapa[i][j] = in.next().charAt(0);
            }
        }
        return mapa;
    }

    static String escreve(int lins, int cols, char[][] mapa) {
        String ans = "";
        for (int i=0; i<lins; i++) {
            for (int j=0; j<cols; j++)
                ans += mapa[i][j];
            ans += "\n";
        }
        return ans;
    }

    static char[][] mapapont(int l, int c){
        char mapa[][] = new char[l][c];
        for (int i=0; i<l; i++){
            for (int j=0; j<c; j++){
                mapa[i][j] = '.';
            }
        }
        return mapa;
    }

    static char[][] procura(char mapa[][], char mapa_fim[][], String p, int l, int c){
        int t=0;
        int t2 = 0;
        for (int i=0; i<l; i++){
            for (int j=0; j<c; j++){
                if (mapa[i][j] == p.charAt(t)){
                    if (cima(p, mapa, i, l, j)){
                        while (t < p.length()){
                            mapa_fim[i+t][j] = p.charAt(t);
                            t += 1;
                        }
                    return mapa_fim;
                    }

                    else if (baixo(p, mapa, i, l, j)){
                        while (t < p.length()){
                            mapa_fim[i+t2][j] = p.charAt(t);
                            t += 1;
                            t2 -= 1;
                        }
                    return mapa_fim;
                    }

                    else if (direita(p, mapa, i, c, j)){
                        while (t < p.length()){
                            mapa_fim[i][j+t] = p.charAt(t);
                            t += 1;
                        }
                    return mapa_fim;
                    }

                    else if (esquerda(p, mapa, i, c, j)){
                        while (t < p.length()){
                            mapa_fim[i][j+t2] = p.charAt(t);
                            t += 1;
                            t2 -= 1;
                        }
                        return mapa_fim;
                    }
                }
            }
        }
        return mapa_fim;
    }

    static boolean cima(String p, char[][] mapa, int i, int l, int j){
        int t = 0;
        if (i+p.length()-1 < l){
            while (t < p.length() && mapa[i+t][j] == p.charAt(t)){
                t += 1;
            }
            if (t == p.length()){
                return true;
            }
        }
        return false;
    }

    static boolean baixo(String p, char[][] mapa, int i, int l, int j){
        int t = 0;
        int t2 = 0;
        if (i-p.length()+1 >= 0 ){
            while (t2 < p.length() && mapa[i+t][j] == p.charAt(t2)){
                t -= 1;
                t2 += 1;
            }
            if (t2 == p.length()){
                return true;
            }
        }
        return false;
    }

    static boolean direita(String p, char[][] mapa, int i, int c, int j){
        int t = 0;
        if (j+p.length()-1 < c){
            while (t < p.length() && mapa[i][j+t] == p.charAt(t)){
                t += 1;
            }
            if (t == p.length()){
                return true;
            }
        }
        return false;
    }

    static boolean esquerda(String p, char[][] mapa, int i, int c, int j){
        int t = 0;
        int t2 = 0;
        if (j-p.length()+1 >= 0){
            while (t2 < p.length() && mapa[i][j+t] == p.charAt(t2)){
                t -= 1;
                t2 += 1;
            }
            if (t2 == p.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int lins = stdin.nextInt();
        int cols = stdin.nextInt();
        int n = 0;
        while (lins != 0 && cols != 0){
            n +=1;
            char mapa[][], mapa_fim[][];
            mapa_fim = new char[lins][cols];
            mapa = lermapa(lins,cols,stdin);
            mapa_fim = mapapont(lins, cols);
            stdin.useDelimiter("\n|\\s");
            int n_pala = stdin.nextInt();
            while (n_pala != 0){
                n_pala -= 1;
                String pala = stdin.next();
                mapa_fim = procura(mapa, mapa_fim, pala, lins, cols);
            }
            System.out.printf("Input #%d\n",n);
            System.out.print(escreve(lins, cols, mapa_fim));
            lins = stdin.nextInt();
            cols = stdin.nextInt();
        }
    }
}
