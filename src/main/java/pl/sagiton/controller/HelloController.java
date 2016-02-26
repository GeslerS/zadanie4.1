package pl.sagiton.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import pl.sagiton.model.Foo;
import pl.sagiton.model.Names;
import pl.sagiton.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


@Controller
public class HelloController{

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("hello", "command", new User());
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloSomeone(@ModelAttribute("hello")User name, ModelMap model) {

       String username = name.getName();

       if(username.equals("James") || username.equals("Donna")){
           try {
               model.addAttribute("attribute",getFieldValue(username));
               return getAnnotationValue(username);
           } catch (NoSuchFieldException e) {
               System.out.println("Something goes wrong");
           } catch (IllegalAccessException e) {
               System.out.println("Something goes wrong");
           }
       }else if(username.equals("Johny")) {
           throw new Iamateapot();
       }
           model.addAttribute("attribute", username);
           return "helloyou";

    }



        private String getAnnotationValue(String fieldName) throws NoSuchFieldException {

        Class  aClass = Names.class;
        Field field = aClass.getDeclaredField(fieldName.toLowerCase());
        field.setAccessible(true);
        Annotation annotation = field.getAnnotation(Foo.class);
        Foo myAnnotation = (Foo) annotation;

        return myAnnotation.value();
    }

    private String getFieldValue(String filedName) throws NoSuchFieldException, IllegalAccessException {

        Names t = new Names();
        Field field = Names.class.getDeclaredField(filedName.toLowerCase());
        field.setAccessible(true);

        return  (String) field.get(t);
    }

}

@ResponseStatus(value= HttpStatus.I_AM_A_TEAPOT, reason="I'm a teapot")
class Iamateapot extends RuntimeException {

}