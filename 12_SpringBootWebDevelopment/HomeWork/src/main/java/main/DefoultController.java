package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DefoultController
{
    @RequestMapping("")
    public Integer index()
    {
        Random random = new Random();
        return random.nextInt(10);
    }


}
