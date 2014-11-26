package org.sample.springmvc.extra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired ServletContext context;

    @RequestMapping(method=RequestMethod.GET)
    public void login(Model model) {
        model.addAttribute("viewordownload", new ViewOrDownload());
    }
    
    @RequestMapping(method=RequestMethod.POST, params="view")
    public String view() {
        return "welcome";
    }
    
    @RequestMapping(method=RequestMethod.POST, params="download")
    public void download(HttpServletResponse response) throws IOException {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + "fileABC.txt");
            String path = context.getRealPath("/WEB-INF/download.txt");
            Path src = Paths.get(path);
            Files.copy(src, response.getOutputStream());
    }
}