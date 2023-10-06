package tests;

import manader.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init();
    }
}
