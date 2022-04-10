package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static constants.Constants.SOME_TEXT;
import static page.MainPage.ANSWER_LOCATOR;
import static utils.DriverSetting.getDriver;

public class NegativeTest extends BaseTest {
	MainPage mainPage = new MainPage();

	@Test
	public void addOnlyQuestion() {

		mainPage
				.getQuestionsCountBefore();

		mainPage
				.sendQuestion(SOME_TEXT)
				.clickCreateQuestionButton();

		mainPage
				.getQuestionsCountAfter();

		mainPage
				.compareQuestionsSize();

	}

	@Test
	public void addOnlyAnswer() {
		int numberOfAnswers = getDriver().findElements(ANSWER_LOCATOR).size();

		mainPage
				.sendAnswer(SOME_TEXT)
				.clickCreateQuestionButton();

		int numberOfAnswersNew = getDriver().findElements(ANSWER_LOCATOR).size();
		Assertions.assertEquals(numberOfAnswers, numberOfAnswersNew);
	}
}
