package grails.xml.config.controllers;

import com.test.GoogleJsonResponse;
import com.test.GoogleJsonResponseDummy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MvcController {
    @RequestMapping(value = "/mvc/testJson.dispatch", method = RequestMethod.GET)
    public ModelAndView getText() {
        System.out.println("IN MvcController..");
        return new ModelAndView("/mvc/test", new ModelMap("text", "from MVC controller"));
    }

//    @RequestMapping(value = "/mvc/test.dispatch", method = RequestMethod.GET)
//    public
//    @ResponseBody
//    GoogleJsonResponse getJsonText(HttpServletResponse response, HttpServletRequest request) {

//        response.setStatus(HttpServletResponse.SC_OK);
 //       GoogleJsonResponse ret = new GoogleJsonResponse();
//        ret.addColl("string", "Year");
//        ret.addColl("number", "Austria");
//        ret.addColl("number", "Bulgaria");
//        ret.addColl("number", "Denmark");
//        ret.addColl("number", "Greece");
//        ret.addRow(new GoogleJsonResponse.Cell("2003"), new GoogleJsonResponse.Cell(1336060), new GoogleJsonResponse.Cell(400361), new GoogleJsonResponse.Cell(1001582), new GoogleJsonResponse.Cell(
//                997974));
//        ret.addRow(new GoogleJsonResponse.Cell("2004"), new GoogleJsonResponse.Cell(1538156), new GoogleJsonResponse.Cell(366849), new GoogleJsonResponse.Cell(1119450), new GoogleJsonResponse.Cell(
//                941795));
//        ret.addRow(new GoogleJsonResponse.Cell("2005"), new GoogleJsonResponse.Cell(1576579), new GoogleJsonResponse.Cell(440514), new GoogleJsonResponse.Cell(993360), new GoogleJsonResponse.Cell(
//                930593));
//        ret.addRow(new GoogleJsonResponse.Cell("2006"), new GoogleJsonResponse.Cell(1600652), new GoogleJsonResponse.Cell(434552), new GoogleJsonResponse.Cell(1004163), new GoogleJsonResponse.Cell(
//                897127));
//        ret.addRow(new GoogleJsonResponse.Cell("2007"), new GoogleJsonResponse.Cell(1968113), new GoogleJsonResponse.Cell(393032), new GoogleJsonResponse.Cell(979198), new GoogleJsonResponse.Cell(
//                1080887));
//        ret.addRow(new GoogleJsonResponse.Cell("2008"), new GoogleJsonResponse.Cell(1901067), new GoogleJsonResponse.Cell(517206), new GoogleJsonResponse.Cell(916965), new GoogleJsonResponse.Cell(
//                1056036));1056036
//        return null;
//    }
    @RequestMapping(value = "/mvc/test.dispatch", method = RequestMethod.GET)
    public ResponseEntity<GoogleJsonResponse> getAccessToken(@RequestParam(value = "grant_type", required = false) String grantType, @RequestParam Map<String, String> parameters) {

        GoogleJsonResponse token = new GoogleJsonResponseDummy();

        return getResponse(token);



    }

    private ResponseEntity<GoogleJsonResponse> getResponse(GoogleJsonResponse accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<GoogleJsonResponse>(accessToken, headers, HttpStatus.OK);
    }
//    public ResponseEntity<Msg> getAccessToken(@RequestParam(value = "grant_type", required = false) String grantType,
//                                              @RequestParam Map<String, String> parameters) {
//
//    }
//
//    private ResponseEntity<Msg> getResponse(OAuth2AccessToken accessToken) {
//        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
//        headers.set("Cache-Control", "no-store");
//        headers.set("Pragma", "no-cache");
//        return new ResponseEntity<Msg>(accessToken, headers, HttpStatus.OK);
//    }
//
//    @org.codehaus.jackson.map.annotate.JsonSerialize(using = OAuth2AccessTokenJackson1Serializer.class)
//    @org.codehaus.jackson.map.annotate.JsonDeserialize(using = OAuth2AccessTokenJackson1Deserializer.class)
//    @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = OAuth2AccessTokenJackson2Serializer.class)
//    @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = OAuth2AccessTokenJackson2Deserializer.class)
//    class Msg {
//        String text;
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//    }
}