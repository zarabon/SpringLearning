package edu.example.controlers;

import edu.example.logic.SubscritionAPIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/subscriptions",method = RequestMethod.GET)
public class SubscriptionsController {
    @Autowired
    public SubscritionAPIManager subscritionAPIManager;

    @RequestMapping("/get")
    public String index(@RequestParam(name = "id") String id,
                        @RequestParam(name = "count",required = false,defaultValue = "20") Integer count,
                        ModelMap modelMap) {
        modelMap.put("subscriptions", subscritionAPIManager.getSubscritionsByID(id,count));
        return "comunities";
    }
}
