package Structure;
import java.io.File;
import java.io.IOException;

import Converter.MDParser;
import Converter.Text; 


public class Structure{
// private Text span;
// private Header header;
	private String line;
	public String translated;
	private Structure prevBlock =null;
	private Structure nextBlock=null;
	public Text toText = new Text();
	
	public Structure(){
	  this.line = "";
	}
	
	public Structure(String line){
	  this.line = line;
	}
	
	public int getLinesAdded()
	{
		return 0;
	}
	
	public void setPrevStructure(Structure prevStructure){
		this.prevBlock = prevStructure;
	}
	
	public Structure getPrevStructure()
	{
		return prevBlock;
	}
	
	
	// set next structure after this object.
	public void setNextStructure(Structure nextStructure){
	  this.nextBlock = nextStructure;
	}
	
	// return Next Structure of current structure
	public Structure getNextStructure(){
	  return nextBlock;
	}
	
	public String getLine(){
	  return line;
	}
	
	public void setLine(String line){
	  this.line = line;
	}
	
	public String createText()
	{
		return line; 
	}

}