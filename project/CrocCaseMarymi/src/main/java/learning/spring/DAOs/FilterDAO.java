package learning.spring.DAOs;

import learning.spring.classes.Filter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterDAO {

    private List<Filter> filters;
    private int FILTERS_COUNT = 0;

    {
        filters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int tmp = FILTERS_COUNT++;
            filters.add(new Filter("Filter" + tmp, tmp));
        }
    }

    public List<Filter> index() {
        return filters;
    }


    public Filter show(String name) {
        return filters.stream().filter(filter -> filter.getName().equals(name)).findAny().orElse(null);
    }
}
