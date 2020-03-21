package collectionCheatSheet;

public class StringCheatSheet {

  // Notes: Strings are immutable
  public static void main(String[] args) {


    // create, initialize
    String lang = new String("Java"); // many different constructor overloads

    String name = "Anshu";
    name += " ";
    name = name.concat("Kandhari");

    System.out.printf("length of name is %d and 8th character in it is %c :", name.length(), name.charAt(8));

    System.out.println("Checking == operator :"+ name =="anshu kandhari");
    System.out.println("Checking equals operator :"+name.equals("anshu kandhari")); // == equality operator tests identity, not equality
    System.out.println("Checking equalsIgnoreCase operator :"+name.equalsIgnoreCase("anshu kandhari"));

    System.out.println("Searching String inside string : "+ name.indexOf("hari"));
    System.out.println("Checking if String contains another string : "+ name.contains("hari"));
    System.out.println("Lexographically coomparing 2 strings: "+ "abcde".compareTo("abcdf"));


    // convert to char Array
    char[] chars = name.toCharArray();

    //char array to string
    String.valueOf(chars);


    // convert strings to numbers
    Integer v99 = Integer.valueOf("30");
    Float pi = Float.valueOf("3.141592654");

    //Converting numbers to string
    String v0 = String.valueOf(30);
    String v2 = new Integer(30).toString();
    String msg1 = "I am " + 30 + " years old";

    // OR
    String v3 = Integer.toString(42);
    String v4 = Double.toString(3.141592654);


    // common methods
    System.out.println("Substring of name from 1,8 is :"+ name.substring(1,8));
    System.out.println("Replacing Anshu with Roohi: "+ name.replace("Anshu", "Roohi"));

    String[] items = {"abc", "def", "ghi"};
    String joinedString = String.join(",", items); // abc,def,ghi

    String[] items2 = joinedString.split(",",0);



    // StringBuilder
    // - think of it as a muteable string
    // - normally use String, but if manipulating strings is slow, try StringBuilder
    StringBuilder sb = new StringBuilder();
    sb.append("ansh").append("u kandhari").append(123); // supports multiple datatypes and chaining
    sb.delete(2,4);
    sb.insert(2, "_hello_");
    sb.replace(3, 5, "************"); // inclusive, exclusive
    System.out.println(sb.reverse().toString().toUpperCase());


  }
}
