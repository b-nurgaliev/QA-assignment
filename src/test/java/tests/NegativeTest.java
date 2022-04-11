package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static constants.Constants.SOME_TEXT;

@DisplayName("Negative tests to check that validation of question/answer fields is working")
public class NegativeTest extends BaseTest {
	MainPage mainPage = new MainPage();

	@Test
	@DisplayName("Trying to add question with empty answer field")
	public void addOnlyQuestion() {
		int numberOfQuestions = mainPage.getQuestionsCountBefore();

		mainPage
				.sendQuestion(SOME_TEXT)
				.clickCreateQuestionButton();
		int numberOfQuestionsNew = mainPage.getQuestionsCountAfter();

		mainPage
				.compareQuestionsSize(numberOfQuestions, numberOfQuestionsNew);
	}

	@Test
	@DisplayName("Trying to add question with empty question field")
	public void  addOnlyAnswer() {
		mainPage
				.clickDefaultQuestion();

		int numberOfAnswers = mainPage.getAnswersCountBefore();

		mainPage
				.sendAnswer(SOME_TEXT)
				.clickCreateQuestionButton();
		int numberOfAnswersNew = mainPage.getAnswersCountAfter();

		mainPage
				.compareAnswersSize(numberOfAnswers, numberOfAnswersNew);
	}
}
