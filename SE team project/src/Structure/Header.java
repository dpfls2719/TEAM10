package Structure;
public class Header extends Structure{
  private Boolean isAtx=false;
  private int headerSize; 
  public Header ()
  {
  }
  public Header(int size)
  {
	headerSize = size;
  }
  
  public int getLinesAdded()
  {
	  if(isAtx)
		  return 0;
	  else
		  return 1;
  }
  
  public void setAtx(){
	  if(getLine().charAt(0)=='#')
	  {
		  isAtx=true;
	  }
  }
  
  public Boolean getIsAtx()
  {
	  return isAtx;
  }
  
  public void setHeaderSize(int size)
  {
  	headerSize = size;
  }
  public int getHeaderSize()
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
