package markdown;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class MDParser{
  // private static boolean isHeader(String s);
  // private static boolean isList(String s);
  // private static boolean isQuoted(String s);
  // private static boolean isCode(String s);
  // private static boolean isHorizental(String s);
  // private static Structure classifyBlock(String line);

  private static char getChar(String line, int cur_place);

  private static String line;
  private static int cur_place = 0;
  char cur_word = 0;

  public MDParser(){

  }

  public MDParser(String line){
//    System.out.println(line);
    setLine(line);
  }

  public void setLine(String line){
    this.line = line;
  }

  public static void parse(){
    System.out.println(line);
    classifyBlock(line);
    cur_word = getChar(line, cur_place++);


  }

  private static void classifyBlock(String line){
    if(isHeader(line)){
      Structure header = new Structure(line);
    } else if(isList(line)){

    } else if(isQuoted(line)){

    } else if(isCode(line)){

    } else if(isHorizental(line)){

    }
  }

  private static char getChar(String line, int cur_place){
    return line.charAt(cur_place);
  }

  private static boolean isHeader(String s){


    return true;
  }
  private static boolean isList(String s){
    return true;
  }
  private static boolean isQuoted(String s){
    return true;
  }
  private static boolean isCode(String s){
    return true;
  }
  private static boolean isHorizental(String s){
    return true;
  }
}
