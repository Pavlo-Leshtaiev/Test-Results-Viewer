package edu.trv.selenium.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.trv.selenium.model")
public class MainPageConfiguration {

    // -----------------------------------------------------------------------------------------------------------------

    @Bean(destroyMethod = "quit")
    public WebDriver getDriver() {
        return new ChromeDriver();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
