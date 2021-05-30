import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws IOException {

        //collecting search result for "junior java munich" from StackOverflow API
        XMLParser xmlParser = new XMLParser();
        List<JobItem> jobList = xmlParser.parseXMLToJavaObjects();

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
