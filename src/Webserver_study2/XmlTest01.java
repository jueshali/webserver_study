package Webserver_study2;

import XML_reader.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
            WebHandler webHandler = new WebHandler();

            try {
                parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Webserver_study2/web.xml"),webHandler);

                List<Mapping> mappings = webHandler.getMappings();
                List<Entity> entities = webHandler.getEntities();

                WebContext webContext = new WebContext(entities,mappings);
                //假设输入/login
                String name = webContext.getClz("/reg");
                try {
                    Class clz = Class.forName(name);
                    Service service = null;
                    try {
                        service = (Service)clz.getConstructor().newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    service.service();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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

class WebHandler extends DefaultHandler{
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Mapping mapping;
    private Entity entity;
    private boolean isMapping;
    private String tag;

    @Override
    public void startDocument() throws SAXException {
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
        isMapping = false;
        System.out.println("解析开始");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if ("servlet".equals(tag)){
                entity = new Entity();
                isMapping = false;
            }
            if ("servlet-mapping".equals(tag)){
                mapping = new Mapping();
                isMapping = true;
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if ("servlet".equals(qName)){
            entities.add(entity);
        }
        if ("servlet-mapping".equals(qName)){
            mappings.add(mapping);
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
            if (isMapping){
                if ("servlet-name".equals(tag)){
                    mapping.setName(contents);
                }
                if ("url-pattern".equals(tag)){
                    mapping.addPatttern(contents);
                }
            }else {
                if ("servlet-name".equals(tag)){
                    entity.setName(contents);
                }
                if ("servlet-class".equals(tag)){
                    entity.setClz(contents);
                }
            }

        }
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
    public List<Entity> getEntities() {
        return entities;
    }


}