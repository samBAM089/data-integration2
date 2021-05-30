import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        //collecting search result for "junior java munich" from StackOverflow API
        XMLParser xmlParser = new XMLParser();
        List<JobItem> jobList = xmlParser.parseXMLToJavaObjects();

        //POST request to endpoint of localhost, encoding issue with "ü"
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(jobList.get(0));
            System.out.println(json);
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost("http://localhost:8080/api/resume");
            StringEntity params = new StringEntity(json);
            request.addHeader("content-type", "application/json; charset=UTF-8");
            request.setEntity(params);
            CloseableHttpResponse response = httpClient.execute(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
