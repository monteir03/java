import java.util.Scanner;

class Palindromo{

  static boolean is_palindrome(String str){
    String str1 = str.toLowerCase();
    String str2 = str1.replaceAll("[^a-z]", "");

    for(int i=0; i < str2.length();  i++)
      if(str2.charAt(i) != str2.charAt((str2.length()-1)-i)) return  false;
    return true;
  }

  public static void main(String[] args) {
    Scanner text = new Scanner(System.in);
    int n=text.nextInt();
    text.nextLine();
    System.out.println(n);

    while(text.hasNextLine()){
      String strr=text.nextLine();
      if(is_palindrome(strr)) System.out.println("sim");
      else System.out.println("nao");
    }
  }

}
