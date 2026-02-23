package StepDefinition14;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import Utilities.FetchDataFromPojo;
import Utilities.FetchDataFromProperty;
import Utilities.ReadDataFromExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Stepdefinition14 {
	
	
	String key_value=FetchDataFromProperty.getDataFromProperty().getProperty("x-api-key");
	String base_uri= FetchDataFromProperty.getDataFromProperty().getProperty("uri");
	String base_uri2=FetchDataFromProperty.getDataFromProperty().getProperty("uri2");
	String token=FetchDataFromProperty.getDataFromProperty().getProperty("bearer_token");
	RequestSpecification req,res;
	ResponseSpecification respec;
	Response response;
	
	
	
	@Given("user sends data to server")
	public void user_sends_data_to_server() {
		
		req=new RequestSpecBuilder().setBaseUri(base_uri).setContentType(ContentType.JSON).build();
	   
	}

	@When("user enters the data payload")
	public void user_enters_the_data_payload() throws JsonProcessingException {
		
	res=	given().log().all().headers("x-api-key",key_value)
		.relaxedHTTPSValidation().spec(req)
		.body(FetchDataFromPojo.createEmployee());
		
	   
	}

	@When("user submits the payload to the server with an endpoint as {string}")
	public void user_submits_the_payload_to_the_server_with_an_endpoint_as(String endpoint) {
	    
		respec=new ResponseSpecBuilder().build();
		response= res.when().post(endpoint).then().log().all().extract().response();
		
	}

	@Then("user validates the created data and confirms the status code as {string}")
	public void user_validates_the_created_data_and_confirms_the_status_code_as(String status_code) {
	    
		long resTime=response.getTime();
		if(resTime>5000)
		{
			throw new ArithmeticException("Longer than expected");
		
		}
		
		else
		{
			System.out.println("respose time is within threshold");
			System.out.println("demo statement");
		}
		
		Integer code=response.getStatusCode();
		String Actual_Code= code.toString();
		Assert.assertEquals(Actual_Code, status_code);
		
		
		
		
	}
	
	
	@Given("user opens the go rest site")
	public void user_opens_the_go_rest_site() {
		
		req=new RequestSpecBuilder().setBaseUri(base_uri2).setContentType(ContentType.JSON).build();	
		
	    
	}

	@When("user enters the payload data to go rest")
	public void user_enters_the_payload_data_to_go_rest() throws IOException {
		
		res=	given().log().all().headers("Authorization",token)
				.relaxedHTTPSValidation().spec(req)
				.body(ReadDataFromExcel.readValueFromExcel());	
	    
	}

	@When("user submits the payload to the  go rest server with an endpoint as {string}")
	public void user_submits_the_payload_to_the_go_rest_server_with_an_endpoint_as(String endpoint) {
	    
		respec=new ResponseSpecBuilder().build();
		response= res.when().post(endpoint).then().log().all().extract().response();
		
		
	}
	
	

}
