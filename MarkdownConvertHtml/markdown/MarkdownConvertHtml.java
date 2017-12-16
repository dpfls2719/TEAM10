package markdown;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MarkdownConvertHtml{
  private static String option;
  private static Scanner fileScan;

  public static void main(String[] args) {
    String[] fileName = new String[10];

    if(args.length == 0){
      System.err.println("Input file");
      System.exit(1);
    }

    int numberOfFile = args.length;

    // MarkdownConvert a = new MarkdownConvert();
    // MarkdownConvert convert = new MarkdownConvert();

    // File Read part
    for(int i = 0; i < numberOfFile; i++){
      fileName[i] = args[i];
      /*  for test
      System.out.println("fileName[" + i + "] : " + fileName[i]);
      */
    }
    fileName[0] = args[0];
    SeFileReader reader = new SeFileReader();
    reader.setFileReaer(fileName[0]);

    // parsing part
    for(int i=0; i < numberOfFile; i++){
      //MDParser parser = new MDParser(fileName[i]);
      //FileReader reader = new FileReader(fileName[i]);
    }
  }
}
