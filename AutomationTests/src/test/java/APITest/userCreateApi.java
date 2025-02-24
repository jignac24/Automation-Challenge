package APITest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import APIEndpoints.endpointPage;
import io.restassured.response.Response;


// Using JSON file - As params

public class userCreateApi {
	
	endpointPage pageRequest = new endpointPage();
	
    @DataProvider(name = "userData")
    public Object[][] getUserData() throws Exception {
    	
    	String filePath = "C:\\Users\\ADMIN\\eclipse-workspace\\AutomationTests\\testData\\users.json";
        String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = new JSONArray(jsonData);
        Object[][] data = new Object[jsonArray.length()][2];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            data[i][0] = user.getString("userName");
            data[i][1] = user.getString("password");
        }
        return data;
    }

  @Test(dataProvider = "userData")
  public void testCreateUser(String username, String password) {
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
}
