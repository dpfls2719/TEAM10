package Structure;
public class Header extends Structure{
  private static Boolean isAtx=false;
  private static int headerSize;
  public Header ()
  {
  }
  public Header(int size)
  {
	headerSize = size;
  }

  public static void setAtx(){
	  if(getLine().charAt(0)=='#')
	  {
		  isAtx=true;
	  }
  }

  public static void setHeaderSize(int size)
  {
  	headerSize = size;
  }
  public static int getHeaderSize()
  {
    return headerSize;
  }
  public String createText()
  {
	setAtx();
	toText.setAtx(isAtx);
	translated = toText.translate(this);
	return translated;
  }
}
