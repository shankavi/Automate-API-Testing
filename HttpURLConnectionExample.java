package usingJAVA_Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//Step to GET request : describe in the comment
public class HttpURLConnectionExample {
	
	public void getMethodExample () throws IOException{
	
//Create Object for URL	
	URL url = new URL("https://reqres.in/api/users?page=2");

//Open the URL connection and store it in its parent class
	HttpURLConnection connection = (HttpURLConnection)url.openConnection();

//Set the Request Type
	connection.setRequestMethod("GET");

//connect
	connection.connect();

//Get the Status code from the connection object and print
	int status_code = connection.getResponseCode();
	System.out.println("Status code is : "+status_code);

//Get the Status message from the connection object and print
	String status_message = connection.getResponseMessage();
	System.out.println("Status Code message is : "+status_message);
	
//Read the respoonce using getInputStream
	InputStream inputStream = connection.getInputStream();
	
//Create an input stram reader for reading the response body
	InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

//Create the buffer reader and pass the input stream reader
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//read the line using readline() 
//So how long do we have to read the lines? as long as the lines are available in the response
	//so loop the read action
	
//Create a String buffer and store the lines read inside the loop
	
//finally print the buffer
	
	String line;
	StringBuffer buffer = new StringBuffer(); 
	while ((line = bufferedReader.readLine()) != null) {
		// System.out.println(line);//print statement inside the loop it's works perfectly and print the body but it's not a best practics
		 //that's why we create a buffer to store the content body
	
		buffer.append(line); //buffer is mutable
	}
	System.out.println(buffer);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		HttpURLConnectionExample http = new HttpURLConnectionExample();
		http.getMethodExample();		
	}
	
}
