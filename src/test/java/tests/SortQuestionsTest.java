package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static constants.Constants.*;

public class SortQuestionsTest extends BaseTest {

	MainPage mainPage = new MainPage();

	@Test
	@Description("Checking that sort questions button works properly")
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
