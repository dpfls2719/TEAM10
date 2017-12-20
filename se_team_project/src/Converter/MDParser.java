package Converter;


import java.util.Scanner;

import Structure.CodeBlock;
import Structure.Header;
import Structure.Horizontal;
import Structure.Quoted;
import Structure.Structure;

import java.io.File;
import java.io.IOException;

class MDParser{
  // private static boolean isHeader(String s);
  // private static boolean isList(String s);
  // private static boolean isQuoted(String s);
  // private static boolean isCode(String s);
  // private static boolean isHorizontal(String s);
  // private static Structure classifyBlock(String line);

  private static String[] line;
  private static int cur_HTML = 0;
  private static int cur_MD=0;
  static char cur_word = 0;
  private static String[] HTML = new String[100];
  Structure start =null;
  Structure before=null;
  Structure lineStruct;

  public MDParser(){

  }

  public MDParser(String[] line){
//    System.out.println(line);
    setLine(line);
  }


  public void setLine(String[] line){
    this.line = line;
  }

  public void parse(){
  	while(line[cur_MD]!=null)
  	{
  	    //cur_word = getChar(line, cur_place++);
  		if(line[cur_MD].isEmpty())
  		{
  			HTML[cur_HTML]=line[cur_MD];
  			cur_HTML++;
  			cur_MD++;
  			continue;
  		}
      // horizontal을 걸러내는 작업. regex라는 regular expression을 이용.
      String regex = "[*|-][[ ][*|-]]+";

      if(!line[cur_MD].matches(regex) && getChar(line[cur_MD], 0)=='-' || getChar(line[cur_MD], 0)=='=')
      {
      	cur_MD++;
      	continue;
      }

  		lineStruct=classifyBlock();

  		if(cur_MD==0)
  			start=lineStruct;

      lineStruct.setLine(line[cur_MD]);
      HTML[cur_HTML]=lineStruct.createText(); // translate 도 같이 진행. 그러면 여기서 translateSpan도 진행하자.
      System.out.println(HTML[cur_HTML]);

  		if(before!=null)
  		{
  			before.setNextStructure(lineStruct);
  		}

	    before = lineStruct;

	    cur_MD++;
	    cur_HTML++;
  	}

  }

  public String[] getHTML(){
	  return HTML;
  }

  private Structure classifyBlock(){
	 // System.out.println("classify : " + line[cur_MD]);
    if(isHorizontal())
    {
      return new Horizontal();
    }
    else if(isQuoted())
    {
    	if(!line[cur_MD + 1].isEmpty() && getChar(line[cur_MD + 1], 0) <= 'z')
      {
    		line[cur_MD + 1] = new StringBuffer(line[cur_MD + 1]).insert(0, ">").toString();
      }
      return new Quoted();
    }
    else if(isHeader())
    {
      int size;
      if(getChar(line[cur_MD], 1)==' ' || (!line[cur_MD+1].isEmpty()&&getChar(line[cur_MD+1], 0)=='='))
        size = 1;
      else
        size = 2;
      return new Header(size);
    }
    else if(isCodeBlock()) // List가 완성되면, 그걸 먼저 검사하여, codeblock이 뜨지 않게 해야 함.
    {
      int size;
      if(!line[cur_MD + 1].isEmpty() && (line[cur_MD + 1].charAt(0) == ' ') && (line[cur_MD + 1].charAt(1) == ' '))
      {
        size = 2; // more code block right after this code block.
      }
      else if( (line[cur_MD - 1].charAt(0) == ' ') && (line[cur_MD - 1].charAt(1) == ' ') )
      {
        size = 3; // la
      }
      else
        size = 1; // no more code block right after this code block.
      return new CodeBlock(size);
    }
    return new Structure();
    /* else if(isList()){

    }   */
  }

  private static char getChar(String line, int cur_place){
    return line.charAt(cur_place);
  }

  private static boolean isHeader(){
  	if(getChar(line[cur_MD], 0)=='#')
  		return true;
  	if(line[cur_MD+1]!=null){
  		if(line[cur_MD+1].isEmpty())
  			return false;
  		if(getChar(line[cur_MD+1], 0)=='=' || getChar(line[cur_MD+1], 0)=='-')
  			return true;
	  }
    return false;
  }
  private static boolean isList(){
    return true;
  }
  private static boolean isQuoted(){
    if(getChar(line[cur_MD], 0)=='>')
    	return true;
	  return false;
  }
  private static boolean isCodeBlock(){
    // 원래 Markdown doc에는 space가 4개이거나 1개의 tab 이 있어야 code block으로 간주할 수 있는데, 교수님이 주신 MD파일에는 그런 것이 없다.
    // 그래서 교수님 파일에 맞게 space가 2개인 경우만 detect 한다.
    if( (line[cur_MD].charAt(0) == ' ') && (line[cur_MD].charAt(1) == ' ') ){
      // System.out.println("contains \\t = " + line[cur_MD].charAt(0));
      return true;
    }
    return false;
  }
  private static boolean isHorizontal(){
//    String regex = "[*|-][ [*|-]]+";
//    System.out.println("line cur_md matches - - - Line[cur_MD] :  " + line[cur_MD] + " : " + line[cur_MD].matches(regex));
    if(line[cur_MD].equals("- - -"))
      return true;
    return false;
  }
}
