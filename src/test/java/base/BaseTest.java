package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static utils.DriverSetting.getDriver;
import static utils.DriverSetting.initDriver;

public class BaseTest {

	public static final String WEBAPP_URL = "http://127.0.0.1:8000";

	@BeforeEach
	public void beforeEveryTest() {
		initDriver();
		openTestApp();
	}

	@AfterEach
	public void afterEveryTest() {
		getDriver().quit();
	}

	private void openTestApp() {
		getDriver().get(WEBAPP_URL);
	}
}
