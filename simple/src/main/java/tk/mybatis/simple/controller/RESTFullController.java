package tk.mybatis.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.service.CountryService;


//restful风格的代码

@RestController
public class RESTFullController {

    @Autowired
    private CountryService countryService;


    @RequestMapping("/restful/select/{id}")
    public Object user(@PathVariable("id") long id){
        return countryService.selectById(id);
    }


    @RequestMapping("/restful/init/{id}/{name}/{code}")
    public Object init(@PathVariable("id") long id,@PathVariable("name") String name,@PathVariable("code") String code){
        Country country=new Country();
        country.setId(id);
        country.setCountryname(name);
        country.setCountrycode(code);
        return country;
    }
}
