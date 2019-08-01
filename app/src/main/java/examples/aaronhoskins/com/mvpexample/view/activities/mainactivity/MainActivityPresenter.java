package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import android.content.Intent;
import android.util.Log;

import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;
import examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.RetrofitHelper;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.APIConstants.RANDOM_BASE_URL;

public class MainActivityPresenter {
    MainActivityContract mainActivityContract;

    public MainActivityPresenter(MainActivityContract mainActivityContract) {
        this.mainActivityContract = mainActivityContract;
    }

    public void executeQuery(String numOfResults, String gender) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(RANDOM_BASE_URL);
        retrofitHelper.getRandomUserService().getRandomUserResults(numOfResults, gender)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RandomUserResults>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RandomUserResults randomUserResults) {
                        mainActivityContract.openResultsActivity(randomUserResults);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG_MAIN_PRESENTER", "onError: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
