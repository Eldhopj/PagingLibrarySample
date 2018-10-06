package in.eldhopj.paginglibrarysample;
/**When to use : Helps load data gradually if there is a huge set of data into recyclerView this saves a lot of bandwidth*/

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
import in.eldhopj.paginglibrarysample.Paging.StackItemPageAdapter;
import in.eldhopj.paginglibrarysample.Paging.StackItemViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    StackItemPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

        //Making instance of view model
        StackItemViewModel viewModel = ViewModelProviders.of(this)// to which activity lifecycle it is scoped to
                .get(StackItemViewModel.class); //Getting instance of the particular view model class
        viewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {
                adapter.submitList(items); /** Submitting new values into adapter*/
            }
        });
    }

    /**Initializing recyclerView*/
    private void initRecyclerView(){
        /**bind with xml*/
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); // setting it to true allows some optimization to our view , avoiding validations when mRecyclerAdapter content changes
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)); //it can be GridLayoutManager or StaggeredGridLayoutManager
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL)); // Divider decorations
        adapter = new StackItemPageAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }
}
