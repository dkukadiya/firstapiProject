package todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static javax.swing.UIManager.get;

public class TodosStepDef
{
   RequestSpecification request;
   Response response;

   @Given("Base uri is {string}")
   public void base_uri_is(String baseUri) {
    System.out.println("baseUri" + baseUri);
    request=given().baseUri(baseUri);
   }
   @When("when use  {string} api")
   public void when_use_api(String basePath) {
      System.out.println("api" +basePath);
      request.basePath(basePath);
      when();
   }

  @When("query by {int}")
  public void query_by(Integer id) {
       response=request.get(String.valueOf(id))
               .then()
               .extract()
               .response();
       System.out.println(response.body().asString());

   }
  @Then("api response should have {int} and {string} and {int}")
   public void api_response_should_have_and_and(int statusCode, String title, int userId) {
       Assert.assertEquals(statusCode,response.statusCode());
       System.out.println(response.statusCode());
       JsonPath jsonPath=response.getBody().jsonPath();
       System.out.println(jsonPath.toString());
       Assert.assertEquals(title,jsonPath.getString("title"));
       System.out.println(jsonPath.getString("title"));
       Assert.assertEquals(userId,jsonPath.getInt("userId"));
       System.out.println(jsonPath.getInt("userId"));
   }

    @Then("api response should have {int} and {string} and {string} and {string} and {string}")
    public void api_response_should_have_and_and_and_and(int statusCode,String name,String street,String lat,String catchPhrase) {
        Assert.assertEquals(statusCode,response.statusCode());
        System.out.println(response.statusCode());
        JsonPath jsonPath=response.getBody().jsonPath();
        System.out.println(jsonPath.toString());
        Assert.assertEquals(name,jsonPath.getString("name"));
        System.out.println(jsonPath.getString("name"));
        Assert.assertEquals(street,jsonPath.getString("address.street"));
        System.out.println(jsonPath.getString("address.street"));
        Assert.assertEquals(lat,jsonPath.getString("address.geo.lat"));
        System.out.println(jsonPath.getString("address.geo.lat"));
        Assert.assertEquals(catchPhrase,jsonPath.getString("company.catchPhrase"));
        System.out.println(jsonPath.getString("company.catchPhrase"));
   }
    @Then("api response should have {int} and {string}")
    public void api_response_should_have_and(int userId, String title) {
        System.out.println(response.body().asString());
        JsonPath responseJosn=response.getBody().jsonPath();
        // to verify title using value  "userId": 2
        Assert.assertEquals(userId,responseJosn.getInt("userId"));
        System.out.println(responseJosn.getInt("userId"));
        //verify userid using value "title": "eveniet quod temporibus"
        Assert.assertEquals(title,responseJosn.getString("title"));
        System.out.println(responseJosn.getString("title"));


    }


}
