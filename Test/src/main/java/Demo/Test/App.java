package Demo.Test;

/**
 * Hello world!
 *
 */
/*public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
*/
public class App   
{  
// main method  
public static void main(String argvs[])  
{  
  
// input string  
String str = "For learning Java, JavaTpoint is a very good site.";  
  
System.out.println(str);  
  
String regex = "//"; // the regular expression is not valid.  
  
// invoking the replaceAll() method raises the PatternSyntaxException  
str = str.replaceAll("[₹,]","");  
  
System.out.println(str); 

}  
}  
