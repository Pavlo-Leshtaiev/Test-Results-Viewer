package edu.trv.selenium.model.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;


@Configuration
public class ChromeWebDriverConfiguration {

    // -----------------------------------------------------------------------------------------------------------------

    @Bean(destroyMethod = "quit")
    @Scope(SCOPE_SINGLETON)
    public WebDriver getDriver() {
        return new ChromeDriver();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
