package ie.gmit.sw.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>FileParser</h1>
 * Contains methods for reading in files and parsing to strings.
 * 
 * @author johnmalcolm
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html">StringBuffer</a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html">BufferedReader</a>
 *
 */
public class FileParser { 
	
	/**
	 * Parse plain text file into a string using the StringBuffer and BufferedReader.
	 * 
	 * @param file The URI of the file for parsing.
	 * @return String containing text the from the text file.
	 * @throws IOException Regular IOException.
	 * 
	 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#replaceAll(java.lang.String,%20java.lang.String)">String.replaceAll()</a>
	 */
	public static String parsePlainText(String file) throws IOException{
		// Initialize and instantiate files.
		StringBuffer sb = new StringBuffer();
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String line = null;
		
		// While the Buffered Reader is not null read and append to StringBuffer.
		while ((line = br.readLine()) != null) {
			/* Regex is used via the String class for data sanitizing. All characters that are 
			 * outside of the range a-z are removed. All characters are also converted to uppercase for consistency. */
			sb.append(line.replaceAll("[^a-zA-Z]+", "").toUpperCase());
		}
		br.close();
		
		return sb.toString();
		
	}
}
