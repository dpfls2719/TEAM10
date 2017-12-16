package markdown.Structure;

import java.io.File;
import java.io.IOEXception;

// private Text span;
// private Header header;
private String line;
private enum whatKind = {Empty, Header, Block, QuotedBlock, ItemList, Code, Horizental}
private Structure nextBlock;

class Structure() implements MDElement{
  whatKind = Empty;
  this.line = "";
}

class Structure(String line){
  whatKind = Empty;
  this.line = line;
}

// allocate new Structure.
public static Structure create(String line){
  return new Structure(line);
}

// return current Structure object
public static Structure getStructure(){
  return this.Structure;
}

// return current kind of current structure
public enum getWhatKind(){
  return whatKind;
}

// set next structure after this object.
public static void setNextStructure(Structure nextStructure){
  this.nextStruct = nextStructure;
}

// retrun Next Structure of current structure
public static Structure getNextStructure(Structure nextStructure){
  return nextStructure;
}

public static String getLine(){
  return this.line;
}

public static void setLine(String line){
  this.line = line;
}
