package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constants.Constants.*;
import static utils.DriverSetting.getDriver;

public class MainPage {

	public static final By CREATE_QUESTION_LOCATOR = By.xpath("//button[contains(text(),'Create question')]");
	public static final By SORT_QUESTIONS_LOCATOR = By.xpath("//button[contains(text(),'Sort questions')]");
	public static final By REMOVE_QUESTIONS_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/button[2]");
	public static final By DEFAULT_QUESTION_LOCATOR = By.xpath("//div[contains(text(),'How to add a question?')]");
	public static final By FIRST_QUESTION_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]");
	public static final By FIRST_ANSWER_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/p[1]");
	public static final By NO_QUESTIONS_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]");
	public static final By SECOND_QUESTION_LOCATOR = By.xpath("//div[@class='card']/ul/li[2]/div[@class='question__question']");
	public static final By SECOND_ANSWER_LOCATOR = By.xpath("//div[@class='card']/ul/li[2]/p[@class='question__answer']");
	public static final By THIRD_QUESTION_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]");
	public static final By THIRD_ANSWER_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[3]/p[1]");
	public static final By QUESTION_FIELD_LOCATOR = By.name("question");
	public static final By ANSWER_FIELD_LOCATOR = By.name("answer");

	public static final By QUESTION_LOCATOR = By.xpath("//div[@class='question__question']");
	public static final By EMPTY_QUESTIONS_LOCATOR = By.xpath("//div[@class='alert alert-danger']");
	public static final By ANSWER_LOCATOR = By.xpath("//p[@class='question__answer ']");
	public static final By HIDDEN_ANSWER_LOCATOR = By.xpath("//p[@class='question__answer hidden-xl-down']");


	public MainPage sendQuestion(String question) {
		getDriver().findElement(QUESTION_FIELD_LOCATOR).sendKeys(question);
		return this;
	}

	public MainPage sendAnswer(String answer) {
		getDriver().findElement(ANSWER_FIELD_LOCATOR).sendKeys(answer);
		return this;
	}

	public MainPage clickCreateQuestionButton() {
		getDriver().findElement(CREATE_QUESTION_LOCATOR).click();
		return this;
	}

	public WebElement getSortQuestionsButton() {
		return getDriver().findElement(SORT_QUESTIONS_LOCATOR);
	}

	public MainPage clickSortQuestionsButton() {
		getSortQuestionsButton().click();
		return this;
	}

	public WebElement getRemoveQuestionsButton() {
		return getDriver().findElement(REMOVE_QUESTIONS_LOCATOR);
	}

	public MainPage clickRemoveQuestionsButton() {
		getRemoveQuestionsButton().click();
		return this;
	}

	public WebElement getDefaultQuestion() {
		return getDriver().findElement(DEFAULT_QUESTION_LOCATOR);
	}

	public MainPage clickDefaultQuestion() {
		getDefaultQuestion().click();
		return this;
	}

	public WebElement getFirstQuestion() {
		return getDriver().findElement(FIRST_QUESTION_LOCATOR);
	}

	public MainPage clickFirstQuestion() {
		getFirstQuestion().click();
		return this;
	}

	public WebElement getNewSecondQuestion() {
		return getDriver().findElements(QUESTION_LOCATOR).get(1);
	}

	public MainPage clickNewSecondQuestion() {
		getDriver().findElements(QUESTION_LOCATOR).get(1).click();
		return this;
	}

	public WebElement getSecondQuestion() {
		return getDriver().findElement(SECOND_QUESTION_LOCATOR);
	}

	public MainPage clickSecondQuestion() {
		getDriver().findElement(SECOND_QUESTION_LOCATOR).click();
		return this;
	}

	public WebElement getThirdQuestion() {
		return getDriver().findElement(THIRD_QUESTION_LOCATOR);
	}

	public MainPage clickThirdQuestion() {
		getThirdQuestion().click();
		return this;
	}

	public WebElement getFirstAnswer() {
		return getDriver().findElement(FIRST_ANSWER_LOCATOR);
	}

	public WebElement getSecondAnswer() {
		return getDriver().findElement(SECOND_ANSWER_LOCATOR);
	}

	public WebElement getThirdAnswer() {
		return getDriver().findElement(THIRD_ANSWER_LOCATOR);
	}

	public WebElement getNoQuestionsMessage() {
		return getDriver().findElement(NO_QUESTIONS_LOCATOR);
	}

	public MainPage compareQuestions() {
		String actualQuestionResult = getDriver().findElement(SECOND_QUESTION_LOCATOR).getText();
		Assertions.assertTrue(actualQuestionResult.contains(PENGUINS_QUESTION));
		return this;
	}
	public void compareActualAnswers() {
		String actualAnswerResult = getDriver().findElement(SECOND_ANSWER_LOCATOR).getText();
		Assertions.assertTrue(actualAnswerResult.contains(PENGUINS_ANSWER));
	}

	public void compareAddedQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(1).getText().contains(PENGUINS_QUESTION));
	}

	public void compareAddedAnswer() {
		Assertions.assertTrue(getDriver().findElement(ANSWER_LOCATOR).getText().contains(PENGUINS_ANSWER));
	}

	public void validateThatQuestionsCleared() {
		Assertions.assertTrue(getDriver().findElement(EMPTY_QUESTIONS_LOCATOR).getText().contains(NO_QUESTIONS));
	}

	public void checkNumericQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(0).getText().contains(NUMERIC_QUESTION));
	}

	public void checkPenguinsQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(1).getText().contains(PENGUINS_QUESTION));
	}

	public void checkDefaultQuestion(){
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(2).getText().contains(DEFAULT_QUESTION));
	}

	public void getQuestionsCountBefore() {
		int numberOfQuestions = getDriver().findElements(QUESTION_LOCATOR).size();
	}

	public void getQuestionsCountAfter() {
		int numberOfQuestionsNew = getDriver().findElements(QUESTION_LOCATOR).size();
	}

	public void compareQuestionsSize(int numberOfQuestions, int numberOfQuestionsNew) {
		Assertions.assertEquals(numberOfQuestions, numberOfQuestionsNew);
	}

	public void getAnswersCountBefore() {
		int numberOfAnswers = getDriver().findElements(ANSWER_LOCATOR).size();
	}

	public void getAnswersCountAfter() {
		int numberOfAnswersNew = getDriver().findElements(ANSWER_LOCATOR).size();
	}

	public void compareAnswersSize(int numberOfAnswers, int numberOfAnswersNew){
		Assertions.assertEquals(numberOfAnswers, numberOfAnswersNew);
	}
}