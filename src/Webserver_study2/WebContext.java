package Webserver_study2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名：webserver_study
 * 描述：将传入的数据转换为Map
 *
 * @author : Lpc
 * @date : 2019-07-16 17:06
 **/
public class WebContext {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;
    private Map<String,String> entityMap;
    private Map<String,String> mappingMap;

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;
        entityMap = new HashMap<String,String>();
        for (Entity entity : entities){
            entityMap.put(entity.getName(),entity.getClz());

        }
        mappingMap = new HashMap<String,String>();
        for (Mapping mapping : mappings){
            for (String parrten:mapping.getPatterns()){
                mappingMap.put(parrten,mapping.getName());
            }
        }
    }

    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        System.out.println(name);
        return entityMap.get(name);
    }



}
