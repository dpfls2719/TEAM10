package Converter;

import java.util.Scanner;
import java.io.*;
//import java.io.IOException;


class SeFileReader{
  private static String option;
  private static String inputFileName;
  private static Scanner scan = new Scanner(System.in);
  private static String[] s= new String[100];
  
  public SeFileReader(){

  }

  /* Read file for user
   * Input : inputFileName is input
   *
   *
   */
  public static void setFileReaer(String inputFileName){
    System.out.println("file name in converting : " + inputFileName);
    System.out.println("This is file reader");
    try{
      if(!(inputFileName.contains(".md") | inputFileName.contains(".MD"))){
        throw new Exception("Input exact file. Extention is md\n");
      }
    } catch(Exception e){
      e.printStackTrace();
    }

    // this.inputFileName = inputFileName;

    try{
      BufferedReader in = new BufferedReader(new FileReader(new File(inputFileName)));
	  int numLine= 0;

      while((s[numLine] = in.readLine()) != null){
          System.out.println(s[numLine]);
          numLine++;
      }

      in.close();
    } catch (IOException e) {
      System.err.println(e);
      System.exit(1);
    }

    // System.out.println("This is for " + inputFileName + ".");
    //printOption();
  }

  /*
   * it just print options
   * User input some options to covert style
   * Style is one of plain, stylish, slide.
  */
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
      else if(option.toLowerCase().equals("")){
        option = "plain";
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
  
  public static String[] getWhole()
  {
	  return s; 
  }

  public static String getLine (int lineNum)
  {
    return s[lineNum];

  }
}
