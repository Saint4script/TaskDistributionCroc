package learning.spring.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Filter {
    private String name;
    private int id;

    public Filter(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
