package examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.services;

import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.APIConstants.API_PATH;
import static examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.APIConstants.QUERY_GENDER;
import static examples.aaronhoskins.com.mvpexample.model.datasource.remote.retrofit.APIConstants.QUERY_RESULTS;

public interface RandomUserService {
    @GET(API_PATH)//Retrofit Annotation for GET HTTP VERB
    Observable<RandomUserResults> getRandomUserResults(@Query(QUERY_RESULTS)String results, @Query(QUERY_GENDER) String gender);
    //@Query is the the Retrofit annotation stating this is a query statement to the api
}
