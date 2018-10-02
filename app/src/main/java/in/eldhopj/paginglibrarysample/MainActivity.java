package in.eldhopj.paginglibrarysample;
/**When to use : Helps load data gradually if there is a huge set of data into recyclerView this saves a lot of bandwidth*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.eldhopj.paginglibrarysample.ModelClasses.StackOverflow;
import in.eldhopj.paginglibrarysample.Network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call <StackOverflow> call = RetrofitClient.getInstance().getApi().getAnswers(1,50,"stackoverflow");
        call.enqueue(new Callback<StackOverflow>() {
            @Override
            public void onResponse(Call<StackOverflow> call, Response<StackOverflow> response) {
                if (!response.isSuccessful()) { // Prevents error like 404
                    Toast.makeText(getApplicationContext(), "Code : " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StackOverflow stackResponse = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(stackResponse.getItems().size()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<StackOverflow> call, Throwable t) {

            }
        });
    }
}
