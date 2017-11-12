import java.lang.*;
import java.util.Scanner;

public class MarkdownConvertHtml{ 
  private static String option;
  
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String[] args){    
    printOption();
  }
  
  private static void printOption(){    
    System.out.println("Select option what you want to do");    
    System.out.println("Input plain(default) / stylish / slide");    
    option = scan.nextLine();
    
    try{      
      if(option.toLowerCase().equals("plain")){
      }      
      else if(option.toLowerCase().equals("stylish")){
      }      
      else if(option.toLowerCase().equals("slide")){
      }      
      else{        
        throw new Exception("Check option\n");      
      }    
    } catch(Exception e){      
      e.printStackTrace();    
    } finally {     
      System.out.println("Option : " + option);    
    }  
  }

}
