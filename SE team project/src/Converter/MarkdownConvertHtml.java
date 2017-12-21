package Converter;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MarkdownConvertHtml{

  public static void main(String[] args) {
    String[] fileName = new String[10];
    String[] outString = new String[100];

    if(args.length == 0){
      System.err.println("Input file");
      System.exit(1);
    }

    int numberOfFile = args.length;

    // MarkdownConvert a = new MarkdownConvert();
    // MarkdownConvert convert = new MarkdownConvert();

    /*
    File Read part, and parsing part
    */
    for(int i = 0; i < numberOfFile; i++){
      fileName[i] = args[i];
      /*  for test
      System.out.println("fileName[" + i + "] : " + fileName[i]);
      */

	  String[] s = new String[100];
      MDParser parser = new MDParser();
      
      SeFileReader reader = new SeFileReader();
      reader.setFileReaer(fileName[i]);
      s=reader.getWhole();
      
      parser.setLine(s);
      parser.parse();
      
      outString = parser.getHTML();
      SeFileWriter writer= new SeFileWriter();
      writer.setOutName(fileName[i].substring(0, fileName[i].indexOf(".md"))+".html");
      writer.outFile(outString);
      //FileReader reader = new FileReader(fileName[i]);
    }
  }
}
