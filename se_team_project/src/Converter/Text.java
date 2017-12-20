package Converter;

import java.io.*;
import java.io.IOException;

import Structure.CodeBlock;
import Structure.Header;
import Structure.Horizontal;
import Structure.Quoted;
import Structure.Structure;

public class Text {
	private static String HTML;
	private static Boolean isAtx= false;

	public Text(){

	}

	public void setAtx(Boolean isAtx)
	{
		this.isAtx = isAtx;
	}

	public static String translate(Structure line)
	{
		if(line instanceof Header)
		{
			if(isAtx)
			{
				Boolean atBack= false;
				while((line.getLine()).charAt(0)=='#')
					line.setLine(line.getLine().substring(1));
				while((line.getLine()).charAt(line.getLine().length()-1)=='#')
				{
					line.setLine(line.getLine().substring(0,line.getLine().length()-2));
					atBack=true;
				}
				line.setLine(line.getLine().substring(1));
				if(atBack)
					line.setLine(line.getLine().substring(0,line.getLine().length()-1));
			}
			if(((Header) line).getHeaderSize()==1)
				HTML="<h1>"+line.getLine()+"</h1>";
			else if (((Header) line).getHeaderSize()==2)
				HTML="<h2>"+line.getLine()+"</h2>";
		}
		else if(line instanceof Quoted)
		{
			//System.out.println("!!!!!!!!!!!!!!" + line.getLine().replaceAll("<", ""));
			line.setLine(line.getLine().replaceAll(">", ""));
			HTML = "<!--" + line.getLine() + "-->";
		}
		else if(line instanceof Horizontal)
		{
			HTML = "<br>";
		}
		else if(line instanceof CodeBlock)
		{
	    // 원래 Markdown doc에는 space가 4개이거나 1개의 tab 이 있어야 code block으로 간주할 수 있는데, 교수님이 주신 MD파일에는 그런 것이 없다.
	    // 그래서 교수님 파일에 맞게 space가 2개인 경우만 detect 한다.
			line.setLine(line.getLine().replaceFirst("  ", ""));
			// System.out.println("line of codeblock : " + line.getLine());
			line.setLine(line.getLine().replaceAll("&", "&amp;"));
			line.setLine(line.getLine().replaceAll("<", "&lt;"));
			line.setLine(line.getLine().replaceAll(">", "&gt;"));
			switch(((CodeBlock)line).getcodeBlockSize()){
				case 1:
					// System.out.println("1");
					HTML = "<pre><code>" + line.getLine() + "\n</code></pre>";
					break;
				case 2:
					// System.out.println("2");
					HTML = line.getLine();
					break;
				case 3:
					// System.out.println("3");
					HTML = line.getLine() + "\n</code></pre>";
					break;
			}
			// line.setLine(line.getLine().replaceFirst("\t", ""));
		}

		else
		{
			HTML= line.getLine();
		}
		// System.out.println("HTML in translate : " + HTML);
		HTML = translateSpan(HTML);

		return HTML;
	}

	public static String translateSpan(String HTML){
		if(isEmphasis(HTML)){
			while(HTML.contains("**") && !HTML.contains("\\**")){ // for backslah escape..
				HTML = HTML.replaceFirst("[*][*]", "<strong>");
				HTML = HTML.replaceFirst("[*][*]", "</strong>");
			}
			while(HTML.contains("*") && !HTML.contains("\\*")){	// for backslah escape..
				HTML = HTML.replaceFirst("[*]", "<em>");
				HTML = HTML.replaceFirst("[*]", "</em>");
			}
			// System.out.println("HTML in Emphasis : " + HTML);
		}
		if(isCodeSpan(HTML)){
			System.out.println("HTML in codeSpan : " + HTML);
			// if(HTML.contains("<code>") || HTML.contains("</code>"))
			// {
			// 	return HTML;
			// }

			while(HTML.contains("``"))
			{
				HTML = HTML.replaceFirst("[`][`]", "<code>");
				HTML = HTML.replaceFirst("[`][`]", "</code>");
			}

			while(HTML.contains("`"))
			{
				if(HTML.contains("\\`"))
					continue;
				HTML = HTML.replaceFirst("[`]", "<code>");
				HTML = HTML.replaceFirst("[`]", "</code>");
			}

		}
		return HTML;
	}

	private static boolean isEmphasis(String HTML){
		String regex = ".*[*].*[*].*";
		String regex2 = ".*[**].*[**].*";
		if(HTML.matches(regex) || HTML.matches(regex2)){
			return true;
		}
		return false;
	}

	private static boolean isCodeSpan(String HTML){
		String regex = ".*[`].*[`].*";
		// String regex2 = ".*[**].*[**].*";
		if(HTML.matches(regex)){
			return true;
		}
		return false;
	}
}
