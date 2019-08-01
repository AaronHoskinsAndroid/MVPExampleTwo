package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import examples.aaronhoskins.com.mvpexample.R;
import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;
import examples.aaronhoskins.com.mvpexample.view.activities.randomuserresultsactivity.RandomUserResultsActivity;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    EditText etResultNum;
    EditText etGender;
    //Declare presenter
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenter(this);
        etGender = findViewById(R.id.etGender);
        etResultNum = findViewById(R.id.etNumOfResults);
    }

    @Override
    public void openResultsActivity(RandomUserResults passedResults) {
        Intent intent = new Intent(this, RandomUserResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("results", passedResults);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onClick(View view) {
        final String resultNum = etResultNum.getText().toString();
        final String gender = etGender.getText().toString();
        mainActivityPresenter.executeQuery(resultNum, gender);
    }
}
