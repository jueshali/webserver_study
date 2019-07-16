package Webserver_study2;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名：webserver_study
 * 描述：一个mapping类
 *
 * @author : Lpc
 * @date : 2019-07-16 16:40
 **/
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping(){
        patterns = new HashSet<String>();
    }
    public void addPatttern(String pattern){
        patterns.add(pattern);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setName(String name) {
        this.name = name;
    }
}
