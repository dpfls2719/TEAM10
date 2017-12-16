package markdown;

import java.util.Scanner;
import java.io.*;


class SeFileReader{
  private static String option;
  // private static String inputFileName;
  private static Scanner scan = new Scanner(System.in);
  private static String[] line;
  private static String buf;
  /*
  * Read file for user
  * Input : inputFileName is input
  */

  public SeFileReader(){
    line = new String[100];
    System.out.println("Input File name\n");
    System.exit(1);
  }

  public SeFileReader(String inputFileName){
    line = new String[300];
    setLine(inputFileName);
    printOption();
  }

  public static void setLine(String inputFileName){
    /* System.out.println("file name in converting : " + inputFileName);
    // System.out.println("This is file reader");
    // System.out.println("input file : " + inputFileName);
    */
    try{
      if(!(inputFileName.contains(".md") | inputFileName.contains(".MD"))){
        throw new Exception("Input exact file. Extention is vd\n");
      }
    } catch(Exception e){
      e.printStackTrace();
    }

    // this.inputFileName = inputFileName;

    try{
      BufferedReader in = new BufferedReader(new FileReader(new File("C:\\SE_java\\MarkdownConvertHtml\\markdown\\" + inputFileName)));
      int lineIndex=0;

      /*
      * read from file, and store in buf.
      * Buf is stored in Line[lineIndex].
      */

      while((buf = in.readLine()) != null){
          line[lineIndex++] = buf;
      }

      /*
      // It's for test line variable.
      // System.out.println("Line Start");
      // for(int i=0;i<lineIndex;i++)
      //   System.out.println(line[i]);
      */

      in.close();
    } catch (IOException e) {
      System.err.println(e);
      System.exit(1);
  }
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
}
