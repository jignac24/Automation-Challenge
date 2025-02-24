package APIEndpoints;

import org.json.JSONObject;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class endpointPage {	
	
	private static final String BASE_URL = "https://demoqa.com/Account/v1/";
	
    public Response createUser(String username, String password)
    {    	
    	RestAssured.baseURI = BASE_URL;
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	
        // Create JSON body
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", username);
        requestBody.put("password", password);
    	
    	System.out.println("Body Request: " + requestBody);
        // Response response = request.body("{ \"userName\":\"" + username + "\", \"password\":\"" + password + "\"}").post("/User");
        
    	// Print and return response
    	return request.body(requestBody.toString()).post("/User");

	}	
    
    public Response getAuthorize(String username, String password)
    {    	
    	RestAssured.baseURI = BASE_URL;
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	
        // Create JSON body
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", username);
        requestBody.put("password", password);
    	
    	System.out.println("Body Request: " + requestBody);
        // Response response = request.body("{ \"userName\":\"" + username + "\", \"password\":\"" + password + "\"}").post("/User");
        
    	// Print and return response
    	return request.body(requestBody.toString()).post("/Authorized");

	}
    
    public Response getBooks()
    {    	
    	RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");

    	// Print and return response
    	return request.get("/Books");

	}

}
