package strings;

public class ExcelColumnName {

  public static String getColName(int n){
    StringBuffer sb = new StringBuffer();

    char c;
    while(n > 0){
      if(n%26 == 0){
        c = 'Z';
        n = n/26-1;
      } else {
        c =(char)('A'+n%26-1);
        n = n/26;
      }

      sb.append(c);
    }



    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(getColName(26));
    System.out.println(getColName(51));
    System.out.println(getColName(52));
    System.out.println(getColName(80));
    System.out.println(getColName(676));
    System.out.println(getColName(702));
    System.out.println(getColName(705));
    System.out.println(getColName(700));
  }

}
