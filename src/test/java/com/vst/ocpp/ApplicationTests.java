//package com.vst.ocpp;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.vst.ocpp.testProtocol_1_6.AuthorizeRequest;
//
//@SpringBootTest
//class ApplicationTests {
//
//	
//	    AuthorizeRequest request= new AuthorizeRequest() ;  
//	    
//	      @Test
//	      public void AuthrequestTest()
//	      {
//	         
//	        
//	          request.setIdTag("234567890123456789012");
//	         System.out.println(request.toJson()); 
//	        
//	          Assert.assertEquals("[2,\"key\",\"Authorize\",{\"idTag\":\"234567890123456789012\"}]", request.toJson());
//	          
//	          Assert.assertEquals("[2,\"key\",\"Authorize\",{\"idTag\":\"2345\"}]", request.toJson());
//
//	          Assert.assertEquals("[2,\"key\",\"Authorize\",{\"idTag\":\"1234567890\"}]", request.toJson());
//	          
//	        
//	      }
//
//}
