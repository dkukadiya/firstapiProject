import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonplaceHolder
{
 @Test
    public void verifyCode_Title_completedFalse()
 {
     Response response = given()
             .baseUri("https://jsonplaceholder.typicode.com/")
             .basePath("todos")
             .when()
             .get("29");

     System.out.println(response.body().asString());
     JsonPath responseJson=response.getBody().jsonPath();
     //verify that it returns status code 200
     Assert.assertEquals(200,response.statusCode());
     System.out.println(response.statusCode());
     //verify that title is "title": "laborum aut in quam"
     Assert.assertEquals(  "laborum aut in quam",responseJson.getString("title"));
     System.out.println(responseJson.getString("title"));
     //verify that completed is false using  "completed": false
     Assert.assertEquals("false",responseJson.getString("completed"));
     System.out.println(responseJson.getString("completed"));
 }
 @Test
    public void verifyStatusCode_Name_Street_lat()
 {
     Response response = given()
             .baseUri("https://jsonplaceholder.typicode.com/")
             .basePath("users")
             .when()
             .get("5");
     System.out.println(response.body().asString());
     JsonPath responseJson=response.getBody().jsonPath();
     //verify that status code is success
     Assert.assertEquals(200,response.statusCode());
     System.out.println(response.statusCode());
     // Assert.assertEquals("success",response.statusCode());
     //System.out.println("status code is success");
     //to verify that name": "Chelsey Dietrich"
     Assert.assertEquals("Chelsey Dietrich",responseJson.getString("name"));
     System.out.println(responseJson.getString("name"));
     //to verify that "street": "Skiles Walks"
     Assert.assertEquals("Skiles Walks",responseJson.getString("address.street"));
     System.out.println(responseJson.getString("address.street"));
     // to verify that lat": "-31.8129"
     Assert.assertEquals("-31.8129",responseJson.getString("address.geo.lat"));
     System.out.println(responseJson.getString("address.geo.lat"));
     //to  verify that "catchPhrase": "User-centric fault-tolerant solution"
     Assert.assertEquals("User-centric fault-tolerant solution",responseJson.getString("company.catchPhrase"));
     System.out.println(responseJson.getString("company.catchPhrase"));
 }
 @Test
    public void verify_userid_title()
 {
    Response response=given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .basePath("posts")
            .when()
            .get("15");
     System.out.println(response.body().asString());
     JsonPath responseJosn=response.getBody().jsonPath();
     // to verify title using value  "userId": 2
     Assert.assertEquals(2,responseJosn.getInt("userId"));
     System.out.println(responseJosn.getInt("userId"));
     //verify userid using value "title": "eveniet quod temporibus"
     Assert.assertEquals("eveniet quod temporibus",responseJosn.getString("title"));
     System.out.println(responseJosn.getString("title"));
 }
}
