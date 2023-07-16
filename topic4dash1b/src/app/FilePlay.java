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
		
		copyFile("InUsers.txt","OutFile.txt");
		
		int err = FilePlay.copyFile("InUsers.txt", "OutUsers.txt");
		switch(err) {
		case 0 :
			System.out.println("File was copied succesfully");
			break;
			
		case -1 :
			System.out.println("File could not be opened");
			break;
		case -2:
			System.out.println("File I/O error");
			break;
		}

	}
	 /**
     * Copies data from the input file to the output file.
     *
     * @param inFile  The name of the input file
     * @param outFile The name of the output file
     * @return An integer value representing the result of the file copying process:
     *         0 for success, -1 for file not found, -2 for I/O error
     * @throws IOException If an I/O error occurs during file copying
     */
	private static int copyFile(String inFile, String outFile) throws IOException  {
		
		BufferedReader  in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader(inFile));
			out = new BufferedWriter(new FileWriter(outFile));
            
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            
            System.out.println("File copied successfully.");
            return 0;
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            return -1;
        } catch (IOException e) {
            System.err.println("I/O error occurred.");
            return -2;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
    }


		
		
		
	}


