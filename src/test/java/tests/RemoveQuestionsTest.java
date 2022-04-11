package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

@DisplayName("Checking that questions removing works")
public class RemoveQuestionsTest extends BaseTest {
	MainPage mainPage = new MainPage();

	@Test
	@DisplayName("Checking if remove questions button works properly")
	public void removeQuestions() {
		mainPage
				.clickRemoveQuestionsButton();

		mainPage
				.validateThatQuestionsCleared();
	}
}
