package APITest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APIEndpoints.endpointPage;
import io.restassured.response.Response;

// Using DataProvider

public class bookStoreApi {
	
	endpointPage pageRequest = new endpointPage();
	
    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{
                {"testQA", "Test@1234"},
                {"testQA", "Test@12351"},
                
        };
    }
    
  @Test(dataProvider = "userData")
  public void testCreateUserRequest(String username, String password)
  {
		     
	  Response response = pageRequest.createUser(username, password);
	  
	  int statusCode = response.getStatusCode();
      String responseBody = response.getBody().asString();
      
      //Print Response
      System.out.println("Response: " + responseBody);
      
      // Assert that status code is either 201 or 406
      Assert.assertTrue(statusCode == 201 || statusCode == 406, 
              "Unexpected status code: " + statusCode);

      // If status code is 406, check response message
      if (statusCode == 406) {
          JSONObject jsonResponse = new JSONObject(responseBody);
          String message = jsonResponse.getString("message");
          Assert.assertEquals(message, "User exists!", "Incorrect error message");
      }	  
      
  }
  
  @Test(dataProvider = "userData")
  public void testGetAuthorize(String username, String password)
  {
		     
	  Response response = pageRequest.getAuthorize(username, password);
	  
	  int statusCode = response.getStatusCode();
      String responseBody = response.getBody().asString();
      
      //Print Response
      System.out.println("Response: " + responseBody);
      
      // Assert that status code is either 201 or 406
      Assert.assertTrue(statusCode == 200, "Unexpected status code: " + statusCode);
 
      
  }
  
  @Test
  public void testGetBooks()
  {
		     
	  Response response = pageRequest.getBooks();
	  
	  int statusCode = response.getStatusCode();
      String responseBody = response.getBody().asString();
      
      //Print Response
      System.out.println("Response: " + responseBody);
      
      // Assert that status code is either 201 or 406
      Assert.assertTrue(statusCode == 200, "Unexpected status code: " + statusCode);
 
      
  }
  
}
