package examples.aaronhoskins.com.mvpexample.view.activities.randomuserresultsactivity;

import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;

public class RandomUserResultsPresenter {
    private RandomUserResults randomUserResults;
    private RandomUserResultsContract randomUserResultsContract;

    public RandomUserResultsPresenter(RandomUserResults randomUserResults, RandomUserResultsContract randomUserResultsContract) {
        this.randomUserResults = randomUserResults;
        this.randomUserResultsContract = randomUserResultsContract;
    }

    public RandomUserResults getRandomUserResults() {
        return randomUserResults;
    }

    public void setRandomUserResults(RandomUserResults randomUserResults) {
        this.randomUserResults = randomUserResults;
    }

    public void getAdapter() {

    }

}
