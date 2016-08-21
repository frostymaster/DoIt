package frosty.com;

import frosty.com.dao.entity.BaseUser;
import frosty.com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lalka on 8/16/2016.
 */
@Controller
public class AdminController {

    @Autowired(required = true)
    private UserService adminService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(Model model) {
        model.addAttribute("admin", new BaseUser());
        BaseUser user = new BaseUser("gay");
        adminService.saveOrUpdate(user);
        return "/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(@ModelAttribute("admin") BaseUser admin, Model model) {
        if (admin.getLogin() != null) {
            BaseUser registeredAdmin = adminService.getAdmin(admin.getLogin());
            if(registeredAdmin!=null){
                model.addAttribute("message", "Welcome "+admin.getLogin());
                model.addAttribute("messageType","information");
            }else{
                model.addAttribute("message", "User not found");
                model.addAttribute("messageType","warning");
            }
        } else {
            model.addAttribute("message", "User not found");
            model.addAttribute("messageType","warning");
        }
        return "/index";
    }
}
