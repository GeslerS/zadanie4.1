package pl.sagiton.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import pl.sagiton.model.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by szymon on 20.02.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

    @Mock
    ModelMap modelMap;

    @Mock
    User user;


    private HelloController helloController = new HelloController();

    @Test
    public void helloJohnyTest() throws Iamateapot {
        when(user.getName()).thenReturn("James");
        assertEquals("Should be \"myjspfileJames\"","myjspfileJames",helloController.helloSomeone(user,modelMap));
    }

    @Test
    public void helloDonnaTest() throws Iamateapot {
        when(user.getName()).thenReturn("Donna");
        assertEquals("Should be \"myjspfileDonna\"","myjspfileDonna",helloController.helloSomeone(user,modelMap));
    }

    @Test
    public void helloCommonNameTest() throws Iamateapot {
        when(user.getName()).thenReturn("Szymon");
        assertEquals("Should be \"helloyou\"","helloyou",helloController.helloSomeone(user,modelMap));
    }

    @Test(expected = Iamateapot.class)
    public void teapotTest() throws Iamateapot {
       when(user.getName()).thenReturn("Johny");
       helloController.helloSomeone(user,modelMap);
    }



}
