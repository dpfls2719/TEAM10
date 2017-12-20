package Structure;
import java.io.File;
import java.io.IOException;

import Converter.Text;


public class Structure{
// private Text span;
// private Header header;
	private static String line;
	public String translated;
	private Structure nextBlock;
	public Text toText = new Text();

	public Structure(){
	  this.line = "";
	}

	public Structure(String line){
	  this.line = line;
	}

	// allocate new Structure.
	public static Structure create(String line){
	  return new Structure(line);
	}


	// set next structure after this object.
	public void setNextStructure(Structure nextStructure){
	  this.nextBlock = nextStructure;
	}

	// return Next Structure of current structure
	public static Structure getNextStructure(Structure nextStructure){
	  return nextStructure;
	}

	public static String getLine(){
	  return line;
	}

	public void setLine(String line){
	  this.line = line;
	}

	public String createText()
	{
		translated = toText.translate(this);
		return translated;
	}

}
