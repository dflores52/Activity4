package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePlay {
	
	 /**
     * The main method of the FilePlay class.
     *
     * @param args Command-line arguments (not used in this program)
     * @throws IOException If an I/O error occurs during file copying
     */

	public static void main(String[] args) throws IOException {
		
		try 
		{
			FilePlay.copyFile("InUsers.txt","OutUsers.txt");
			System.out.println("File copied Successfully");
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("File could not be opened");
			
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("File I/O error");
			
		}

	}
	/**
     * Copies data from the input file to the output file.
     *
     * @param inFile The name of the input file
     * @param outFile The name of the output file
     * @throws FileNotFoundException If the input file is not found
     * @throws IOException If an I/O error occurs during file copying
     */

	private static void copyFile(String inFile, String outFile) throws FileNotFoundException,IOException  {
		
		BufferedReader  in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader(inFile));
			out = new BufferedWriter(new FileWriter(outFile));
            
            String line;
            
            while ((line = in.readLine()) != null) {
            	
            	String[] tokens = line.split("\\|");
                out.write(String.format("Name is %s %s of age %s \n", tokens[0], tokens[1], tokens[2]));
            }
		
		System.out.println("File copied successfully");
		}
            finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            }
        
		
    


		
		
		
	}


