/*
TEAM10 : Assignment 1_2
Code Summary : receives command line inputs from user
Last update : Nov. 12
*/

import java.lang.*;
import java.util.Scanner;

public class MarkdownConvertHtml{
  private static String option;
  
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String[] args){                           //main class
    printOption();
  }
  
  private static void printOption(){                                //class that gets input from the user 
    System.out.println("Select option what you want to do");    
    System.out.println("Input plain(default) / stylish / slide");   //three options : plain, stylish, slide
    option = scan.nextLine();
    option = scan.nextLine();
    
    try{      
      if(option.toLowerCase().equals("plain")){                     //when picked option plain
      }      
      else if(option.toLowerCase().equals("stylish")){              //when picked option stylish
      }      
      else if(option.toLowerCase().equals("slide")){                //when picked option slide
      }      
      else{                                                         //when input is illegal
        throw new Exception("Check option\n");      
      }    
    } catch(Exception e){                                           //error handling for illegal command
      e.printStackTrace();    
    } finally {                                                     //show option selected
      System.out.println("Option : " + option);    
    }  
  }

}
