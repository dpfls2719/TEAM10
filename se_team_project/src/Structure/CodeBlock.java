package Structure;

public class CodeBlock extends Structure{
// private Text span;
// private Header header;
  private static Boolean isAtx=false;
  private static int codeBlockSize;

	public CodeBlock()
	{
	}

  public CodeBlock(int size)
  {
    codeBlockSize = size;
  }

	public static void setAtx(){
	  if(getLine().charAt(0)=='<')
	  {
		  isAtx=true;
	  }
  }

  public static void setCodeBlockSize(int size)
  {
  	codeBlockSize = size;
  }
  public static int getcodeBlockSize()
  {
    return codeBlockSize;
  }
  public String createText()
  {
	setAtx();
	toText.setAtx(isAtx);
	translated = toText.translate(this);
	return translated;
  }

}
