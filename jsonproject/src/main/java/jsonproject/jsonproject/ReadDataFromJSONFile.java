package jsonproject.jsonproject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class demonstrates reading data from a JSON file in Java.
 */
public class ReadDataFromJSONFile {

    /**
     * The main method of the ReadDataFromJSONFile class.
     *
     * @param args Command-line arguments (not used in this program).
     * @throws IOException    If an I/O error occurs while reading the JSON file.
     * @throws ParseException If the JSON file cannot be parsed.
     */
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jparse = new JSONParser();

        FileReader reader = new FileReader("/jsonproject/jsonFiles/employee.json");

        Object obj = jparse.parse(reader);

        JSONObject empjsonobj = (JSONObject) obj;

        String fname = (String) empjsonobj.get("firstName");
        String lname = (String) empjsonobj.get("lastName");

        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
    }
}
