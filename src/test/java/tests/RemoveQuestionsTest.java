package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import page.MainPage;


public class RemoveQuestionsTest extends BaseTest {

	MainPage mainPage = new MainPage();

	@Test
	@Description("Checking if remove questions button works properly")
	public void removeQuestions() {
		mainPage
				.clickRemoveQuestionsButton();

		mainPage
				.validateThatQuestionsCleared();
	}
}
