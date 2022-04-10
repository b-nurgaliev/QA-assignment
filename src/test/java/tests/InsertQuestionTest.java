package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static constants.Constants.PENGUINS_ANSWER;
import static constants.Constants.PENGUINS_QUESTION;

@DisplayName("Testing that question and answer can be added")
public class InsertQuestionTest extends BaseTest {

	MainPage mainPage = new MainPage();

	@Test
	@DisplayName("Adding one question and checking if question is added and has correct answer")
	public void addingQuestionAndCheckingItsAnswer() {
		mainPage
				.sendQuestion(PENGUINS_QUESTION)
				.sendAnswer(PENGUINS_ANSWER)
				.clickCreateQuestionButton()
				.clickSecondQuestion();

		mainPage
				.compareAddedQuestion();
		mainPage
				.compareAddedAnswer();
	}
}
