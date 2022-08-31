package ecommerce.ecommerce;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import io.restassured.*;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

public class restAssured {
	 RequestSpecification httpRequest;
	 Response response;
	@Test (priority =1)
	public void req() {

	httpRequest =RestAssured.given()
			.baseUri("https://demoqa.com/BookStore/v1")
					.basePath("/Books");
//	Response response = httpRequest.request(Method.GET, "");
	
	// Print the status and message body of the response received from the server 
//	System.out.println("Status received => " + response.getStatusLine()); 
//	System.out.println("Response=>" + response.prettyPrint());
		
	}
	@Test (priority =2)
	public void status_code() {
		RestAssured.given().spec(httpRequest);
		
		//get response data
		 response = httpRequest.get("");
		
		int status_code =response.getStatusCode();
		System.out.println(status_code);
		//assert the status code
			if(status_code==200)
			{
				System.out.println("yes it is equal");
			}
			else {System.out.println("no it is not equal");}
			
	String status_line = response.getStatusLine();
	System.out.print(status_line);
	}
	@Test (priority =3)
	public void header_content() {
		RestAssured.given().spec(httpRequest);
		
		// response data have been stored globally
		// fetch header from the body
		//validate response header
		String content_header = response.getHeader("Content-Type");
		System.out.println(content_header);
	}
	
	@Test (priority=4)
	public void all_header_content() {
		RestAssured.given().spec(httpRequest);
		Headers all_headers = response.getHeaders();
		for(Header header : all_headers )
		{
			System.out.println("keys" + header.getName() + "value " + header.getValue());
		}
			
	}
	
	@Test (priority=5)
	public void server_name() {
		RestAssured.given().spec(httpRequest);
		  String server_name = response.getHeader("Server");
		  System.out.println(server_name);
	
	}
	
}
