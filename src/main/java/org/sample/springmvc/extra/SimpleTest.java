package org.sample.springmvc.extra;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class SimpleTest {
    @Autowired MessageBean mb;

    @RequestMapping(method=RequestMethod.GET)
    public void login(/*Model model*/) {
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public void execute2(Model model, @Valid @ModelAttribute("mb") MessageBean mb, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAllAttributes(bindingResult.getModel());
        }
    }
}