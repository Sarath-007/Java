import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class parser {
    public static void main(String[] args) {
        try {
            int s1 = 0,s2=0,s3=0;
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse("C:\\Users\\DELL\\IdeaProjects\\Java projects\\task\\src\\main\\java\\emp.xml");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList list=doc.getElementsByTagName("department1");
            for(int i=0; i<list.getLength();i++)
            {
                Node n= list.item(i);
                System.out.println(n.getNodeName());
                Element e=(Element)n;
                String s= e.getElementsByTagName("salary").item(1).getTextContent();
                String t=e.getElementsByTagName("salary").item(0).getTextContent();
                int a=Integer.parseInt(s);
                int b=Integer.parseInt(t);
                 s1=a+b;
                System.out.println("total salary= "+s1);

            }
            NodeList list1=doc.getElementsByTagName("department2");
            for(int i=0; i<list1.getLength();i++)
            {
                Node n= list1.item(i);
                System.out.println(n.getNodeName());
                Element e=(Element)n;
                String s= e.getElementsByTagName("salary").item(1).getTextContent();
                String t=e.getElementsByTagName("salary").item(0).getTextContent();
                int a=Integer.parseInt(s);
                int b=Integer.parseInt(t);
                s2=a+b;
                System.out.println("total salary= "+s2);
            }
            NodeList list2=doc.getElementsByTagName("department3");
            for(int i=0; i<list2.getLength();i++)
            {
                Node n= list2.item(i);
                System.out.println(n.getNodeName());
                Element e=(Element)n;

              String s= e.getElementsByTagName("salary").item(1).getTextContent();
              String t=e.getElementsByTagName("salary").item(0).getTextContent();
                int a=Integer.parseInt(s);
              int b=Integer.parseInt(t);
              s3=a+b;
                System.out.println("total salary= "+s3);
            }
            NodeList count1=doc.getElementsByTagName("salary");
            System.out.println(count1.getLength());
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("Department1", s1);
            jsonObject.put("Department2", s2);
            jsonObject.put("Department3", s3);

            FileWriter file = new FileWriter("output.json");
            file.write(jsonObject.toJSONString());
            file.close();
            System.out.println("Departments: "+jsonObject);



        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
