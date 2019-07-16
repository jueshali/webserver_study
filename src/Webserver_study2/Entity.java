package Webserver_study2;

/**
 * 项目名：webserver_study
 * 描述：一个实体类
 *
 * @author : Lpc
 * @date : 2019-07-16 16:39
 **/
public class Entity {
    private String name;
    private String clz;

    public Entity() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }
}
