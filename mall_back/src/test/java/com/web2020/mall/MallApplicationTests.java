package com.web2020.mall;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = MallApplication.class)
class MallApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void seleniumTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.itest.info");
        String title = driver.getTitle();
        System.out.printf(title);
        driver.close();
    }

}
