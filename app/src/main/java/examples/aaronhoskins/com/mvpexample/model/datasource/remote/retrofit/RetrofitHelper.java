package examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit;

import android.util.Log;

import examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.services.RandomUserService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.APIConstants.RANDOM_BASE_URL;

public class RetrofitHelper {
    private String baseURL;

    public RetrofitHelper(String baseURL) {
        this.baseURL = baseURL;
    }

    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RandomUserService getRandomUserService() {
        switch (baseURL) {
            case RANDOM_BASE_URL:
                return getRetrofitInstance().create(RandomUserService.class);
                default:
                    Log.e("TAG", "SERVICE FOR URL NOT INSTANTIATED");
                    return null;
        }
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
