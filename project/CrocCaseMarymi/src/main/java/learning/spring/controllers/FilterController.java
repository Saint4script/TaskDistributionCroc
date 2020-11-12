package learning.spring.controllers;

import learning.spring.DAOs.FilterDAO;
import learning.spring.classes.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/filters")
public class FilterController {

    private FilterDAO filterDAO;

    @Autowired
    public FilterController(FilterDAO filterDAO) {
        this.filterDAO = filterDAO;
    }

    @GetMapping("/index")
    public String index(Model model) {
        System.out.println("PP");
        List<Filter> filters = filterDAO.index();
        System.out.println("filters " + filters);
        List<String> names = new ArrayList<>();
        for (Filter filter : filters) {
            System.out.println(filter.getName());
            names.add(filter.getName());
        }
        model.addAttribute("names", names);
        return "filters/index";
    }

    @GetMapping("/{name}")
    public String show(@PathVariable("name") String name, Model model){
        model.addAttribute("filter", filterDAO.show(name));
        return "filters/show";
    }

}
