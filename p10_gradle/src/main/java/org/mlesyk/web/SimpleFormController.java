package org.mlesyk.web;

import org.mlesyk.model.TestBean;
import org.mlesyk.model.TestBean2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/simpleForm")
@SessionAttributes("testBean")
public class SimpleFormController {

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        TestBean testBean = new TestBean();
        TestBean2 testBean2 = new TestBean2();
        testBean.setField4(testBean2);
        model.addAttribute("testBean", testBean);
        return "simpleForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String sumbitForm(
            @ModelAttribute("testBean") @Valid TestBean testBean,
            BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "simpleForm";
        } else {
            status.setComplete();
            return "redirect:submitSuccess";
        }
    }


}
