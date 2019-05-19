package edu.trv.selenium.testcases;

import edu.trv.Application;
import edu.trv.fixtures.RestHelpers;
import edu.trv.selenium.configurations.MainPageConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
      classes = {Application.class, MainPageConfiguration.class}
    , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractSeleniumTestCase {

    // -----------------------------------------------------------------------------------------------------------------

    @LocalServerPort
    private int port;

    private static boolean init = false;

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private WebDriver driver;

    // -----------------------------------------------------------------------------------------------------------------

    @BeforeEach
    void getTab(){
        if (!init) {
            driver.get(RestHelpers.toLocalRestUrl(port));
            init = true;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

}
