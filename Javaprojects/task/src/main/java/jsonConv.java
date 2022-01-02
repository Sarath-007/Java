import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;
public class jsonconv {
    public static void main(String[] args) {
        try {
            int[]sum=new int[10];
            int a=0;
            JSONObject jsonObject = new JSONObject();
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse("Resources\\emp2.xml");
            //System.out.println(doc.getDocumentElement().getNodeName());
            NodeList list=doc.getElementsByTagName("department");
            for(int i=0; i<list.getLength();i++)
            {
                String c=Integer.toString(i+1);
                NodeList sal=doc.getElementsByTagName("dept");
                System.out.println(sal.getLength());
               // NodeList sal=doc.getElementsByTagName("employee"+c);
               // System.out.println("employee length="+sal.getLength());
                 //   NodeList salary = doc.getElementsByTagName("salary" + c);
                 //   System.out.println(salary.getLength());
                    Node n = list.item(i);
                    //System.out.println(n.getNodeName());
                    Element e = (Element) n;
                    for (int k = 0; k < salary.getLength(); k++) {
                   //     String s = e.getElementsByTagName("salary" + c).item(k).getTextContent();
                        a = Integer.parseInt(s);
                        sum[i] += a;
                        System.out.println(sum[i]);

                        jsonObject.put("Department" + c, sum[i]);
                    }

            }
            FileWriter file = new FileWriter("output2.json");
            file.write(jsonObject.toJSONString());
            file.close();
            System.out.println("Departments: "+jsonObject);



        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}

