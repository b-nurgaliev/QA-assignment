package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static constants.Constants.*;

@DisplayName("Checking that SORT button works")
public class SortQuestionsTest extends BaseTest {
	MainPage mainPage = new MainPage();

	@Test
	@DisplayName("Checking that questions are sorted correctly")
	public void sortQuestionsCheck() {
		mainPage
				.sendQuestion(NUMERIC_QUESTION)
				.sendAnswer(NUMERIC_ANSWER)
				.clickCreateQuestionButton()
				.sendQuestion(PENGUINS_QUESTION)
				.sendAnswer(PENGUINS_ANSWER)
				.clickCreateQuestionButton()
				.clickSortQuestionsButton();

		mainPage
				.checkNumericQuestion();
		mainPage
				.checkPenguinsQuestion();
		mainPage
				.checkDefaultQuestion();
	}
}
