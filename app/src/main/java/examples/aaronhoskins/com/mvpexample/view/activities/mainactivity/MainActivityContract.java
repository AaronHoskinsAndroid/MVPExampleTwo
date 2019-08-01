package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;

public interface MainActivityContract {
    void openResultsActivity(RandomUserResults passedResults);
}
