package examples.aaronhoskins.com.mvpexample.view.activities.randomuserresultsactivity;

import android.os.Bundle;

import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;
import examples.aaronhoskins.com.mvpexample.view.adapters.RandomUserResultsRecyclerViewAdapter;

public class RandomUserResultsPresenter {
    private RandomUserResults randomUserResults;
    private RandomUserResultsContract randomUserResultsContract;

    public RandomUserResultsPresenter(Bundle randomUserResults, RandomUserResultsContract randomUserResultsContract) {
        this.randomUserResults = randomUserResults.getParcelable("results");
        this.randomUserResultsContract = randomUserResultsContract;
    }

    public RandomUserResults getRandomUserResults() {
        return randomUserResults;
    }

    public void setRandomUserResults(RandomUserResults randomUserResults) {
        this.randomUserResults = randomUserResults;
    }

    public void getAdapter() {
        RandomUserResultsRecyclerViewAdapter adapter
                = new RandomUserResultsRecyclerViewAdapter(randomUserResults);
        randomUserResultsContract.onAdapterReady(adapter);
    }

}
