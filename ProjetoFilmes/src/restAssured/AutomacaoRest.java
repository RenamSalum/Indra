package restAssured;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutomacaoRest {
	
	@Test
	public void restAPI(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";
		
		RestAssured.given().relaxedHTTPSValidation().contentType("application/json").when().post(RestAssured.baseURI);
		
		Assert.assertEquals(200, RestAssured.get().getStatusCode());
				
		String Json = RestAssured.when().request(Method.GET, "1").getBody().jsonPath().get("title");
		
		Assert.assertTrue(Json.contains("delectus aut autem"));
		
	    System.out.println("Mensagem  =>  " + Json );
	    
	    System.out.println("===================================================");
	    
	    RestAssured.when().request(Method.GET, "1").getBody().prettyPrint();
	    
	    System.out.println("===================================================");
	}
}

