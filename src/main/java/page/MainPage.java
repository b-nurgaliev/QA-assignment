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
	public static final By SECOND_QUESTION_LOCATOR = By.xpath("//div[@class='card']/ul/li[2]/div[@class='question__question']");
	public static final By THIRD_QUESTION_LOCATOR = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]");
	public static final By QUESTION_FIELD_LOCATOR = By.name("question");
	public static final By ANSWER_FIELD_LOCATOR = By.name("answer");

	public static final By QUESTION_LOCATOR = By.xpath("//div[@class='question__question']");
	public static final By EMPTY_QUESTIONS_LOCATOR = By.xpath("//div[@class='alert alert-danger']");
	public static final By ANSWER_LOCATOR = By.xpath("//p[@class='question__answer ']");

	public Integer getNumberOfAnswers()
	{
		return Integer.parseInt(String.valueOf(getDriver().findElements(ANSWER_LOCATOR).size()));
	}

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


	public MainPage clickSecondQuestion() {
		getDriver().findElement(SECOND_QUESTION_LOCATOR).click();
		return this;
	}

	public WebElement getThirdQuestion() {
		return getDriver().findElement(THIRD_QUESTION_LOCATOR);
	}


	public MainPage compareAddedQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(1).getText().contains(PENGUINS_QUESTION));
		return this;
	}

	public MainPage compareAddedAnswer() {
		Assertions.assertTrue(getDriver().findElement(ANSWER_LOCATOR).getText().contains(PENGUINS_ANSWER));
		return this;
	}

	public void validateThatQuestionsCleared() {
		Assertions.assertTrue(getDriver().findElement(EMPTY_QUESTIONS_LOCATOR).getText().contains(NO_QUESTIONS));
	}

	public MainPage checkNumericQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(0).getText().contains(NUMERIC_QUESTION));
		return this;
	}

	public MainPage checkPenguinsQuestion() {
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(1).getText().contains(PENGUINS_QUESTION));
		return this;
	}

	public MainPage checkDefaultQuestion(){
		Assertions.assertTrue(getDriver().findElements(QUESTION_LOCATOR).get(2).getText().contains(DEFAULT_QUESTION));
		return this;
	}

	public Integer getQuestionsCountBefore() {
		return Integer.parseInt(String.valueOf(getDriver().findElements(QUESTION_LOCATOR).size()));
	}

	public Integer getQuestionsCountAfter() {
		return Integer.parseInt(String.valueOf(getDriver().findElements(QUESTION_LOCATOR).size()));
	}

	public MainPage compareQuestionsSize(int numberOfQuestions, int numberOfQuestionsNew) {
		Assertions.assertEquals(numberOfQuestions, numberOfQuestionsNew);
		return  this;
	}

	public int getAnswersCountBefore() {
		return Integer.parseInt(String.valueOf(getDriver().findElements(ANSWER_LOCATOR).size()));
	}

	public int getAnswersCountAfter() {
		return Integer.parseInt(String.valueOf(getDriver().findElements(ANSWER_LOCATOR).size()));
	}

	public void compareAnswersSize(int numberOfAnswers, int numberOfAnswersNew){
		Assertions.assertEquals(numberOfAnswers, numberOfAnswersNew);
	}
}
