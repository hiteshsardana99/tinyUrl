package sardana.tinyUrl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

  private static final String HOME_PAGE_PATH = "index.html";
  private static final String NO_PAGE_FOUND = "noPageFound.html";


  @RequestMapping("/home")
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName(HOME_PAGE_PATH);
    return modelAndView;
  }

  @RequestMapping("/NoPageFound")
  public ModelAndView noPageFound() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName(NO_PAGE_FOUND);
    return modelAndView;
  }

}
