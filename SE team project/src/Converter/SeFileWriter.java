package Converter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SeFileWriter {

	private static String outputFileName;
	

	public void setOutName(String outputFileName)
	{
		this.outputFileName = outputFileName;
	}
	
	
	public void outFile(String [] lines)
	{
		int i =0;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(this.outputFileName));
			while(lines[i]!=null)
			{
				out.write(lines[i]);
				out.newLine();
				i++;
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
