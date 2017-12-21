package Structure;

public class Quoted extends Structure{
// private Text span;
// private Header header;
  private static Boolean isAtx=false;
  private static int quotedSize;

	public Quoted()
	{
	}

	public void setAtx(){
	  if(getLine().charAt(0)=='<')
	  {
		  isAtx=true;
	  }
  }

  public static void setQuotedSize(int size)
  {
  	quotedSize = size;
  }
  public static int getQuotedSize()
  {
    return quotedSize;
  }
  public String createText()
  {
	setAtx();
	toText.setAtx(isAtx);
	translated = toText.translate(this);
	return translated;
  }

}
