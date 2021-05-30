import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public List<JobItem> parseXMLToJavaObjects() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<JobItem> jobList = new ArrayList<>();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("https://stackoverflow.com/jobs/feed?q=java&l=Munich&u=Km&d=20&ms=Junior&mxs=Junior");
            NodeList itemList = doc.getElementsByTagName("item");



            for (int i = 0; i < itemList.getLength(); i++) {
                Node p = itemList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) p;
                    NodeList information = item.getChildNodes();
                    for (int j = 0; j < information.getLength(); j++) {
                        Node tags = information.item(j);
                        if (tags.getNodeType() == Node.ELEMENT_NODE) {
                            Element x = (Element) tags;
                            NodeList categoriesNl = item.getElementsByTagName("category");
                            List<String> categories = new ArrayList<>();
                            for (int k = 0; k < categoriesNl.getLength(); k++) {
                                categories.add(categoriesNl.item(k).getTextContent());
                            }
                            JobItem job = new JobItem(
                                    item.getElementsByTagName("link").item(0).getTextContent(),
                                    item.getElementsByTagName("a10:author").item(0).getTextContent(),
                                    categories,
                                    item.getElementsByTagName("title").item(0).getTextContent(),
                                    item.getElementsByTagName("description").item(0).getTextContent(),
                                    item.getElementsByTagName("pubDate").item(0).getTextContent(),
                                    item.getElementsByTagName("a10:updated").item(0).getTextContent(),
                                    item.getElementsByTagName("location").item(0).getTextContent()
                            );
                            jobList.add(job);

                            //System.out.println(x.getTagName() + " " + x.getTextContent());
                        }
                    }
                }
            }
            System.out.println(jobList.get(0));
        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        } catch (
                SAXException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return jobList;
    }
}
