package examples.aaronhoskins.com.mvpexample.view.activities.randomuserresultsactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import examples.aaronhoskins.com.mvpexample.R;
import examples.aaronhoskins.com.mvpexample.view.adapters.RandomUserResultsRecyclerViewAdapter;

public class RandomUserResultsActivity extends AppCompatActivity implements RandomUserResultsContract {
    RandomUserResultsPresenter randomUserResultsPresenter;
    RecyclerView rvRandomUserRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_user_results);
        Intent passedIntent = getIntent();
        Bundle passedBundle = passedIntent.getExtras();
        randomUserResultsPresenter = new RandomUserResultsPresenter(passedBundle, this);
        randomUserResultsPresenter.getAdapter();
    }

    @Override
    public void onAdapterReady(RandomUserResultsRecyclerViewAdapter adapter) {
        rvRandomUserRecyclerView  = findViewById(R.id.rvRandomUser);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvRandomUserRecyclerView.setLayoutManager(layoutManager);
        rvRandomUserRecyclerView.setAdapter(adapter);
    }
}
