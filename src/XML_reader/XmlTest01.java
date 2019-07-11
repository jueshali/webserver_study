package XML_reader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

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

    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析开始");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}