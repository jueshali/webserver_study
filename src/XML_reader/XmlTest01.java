package XML_reader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：webserver_study
 * 描述：解析
 *
 * @author : Lpc
 * @date : 2019-07-09 21:34
 **/
public class XmlTest01 {

    public static void main(String[] args) {
        //获取解析工厂
        SAXParserFactory factory =SAXParserFactory.newInstance();
        //从解析工厂获取解析器
        try {
            SAXParser parser = factory.newSAXParser();
            //加载文档document注册处理器

            //编写处理器
            PHandler pHandler = new PHandler();

            try {
                parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("XML_reader/n.xml"),pHandler);
                List<Person> personList = pHandler.getPersons();
                for (Person p:personList
                     ) {
                    System.out.println(p.getName());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
class PHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;//存储操作的标签

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
        System.out.println("解析开始");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if ("person".equals(tag)){
                person = new Person();
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)){
            persons.add(person);
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if (tag!=null){
            if ("name".equals(tag)){
                person.setName(contents);
            }
            if ("age".equals(tag)){
                person.setAge(Integer.valueOf(contents));
            }
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}