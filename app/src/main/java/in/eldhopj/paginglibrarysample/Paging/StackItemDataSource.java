package in.eldhopj.paginglibrarysample.Paging;

/**There are 3 data sources
 *      item keyed data source
 *      paged keyed data source
 *      positional data source*/

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
import in.eldhopj.paginglibrarysample.ModelClasses.StackOverflow;
import in.eldhopj.paginglibrarysample.Network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static in.eldhopj.paginglibrarysample.StackItemConfig.FIRST_PAGE;
import static in.eldhopj.paginglibrarysample.StackItemConfig.PAGE_SIZE;
import static in.eldhopj.paginglibrarysample.StackItemConfig.SITE_NAME;

/**Choose the correct data source according to the API @See <a href https://developer.android.com/topic/libraries/architecture/paging/data#choose-data-source-type/>
 * Here we are using paged keyed data source since we get the data as page number*/
public class StackItemDataSource extends PageKeyedDataSource<Integer,Item> {
    private static final String TAG = "StackItemDataSource";

    private List<Item> mItemList;

    /**it will call once and it will load the initial data*/
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        Call<StackOverflow> call = RetrofitClient.getInstance().getApi().getAnswers(FIRST_PAGE,PAGE_SIZE,SITE_NAME);
        call.enqueue(new Callback<StackOverflow>() {
            @Override
            public void onResponse(Call<StackOverflow> call, Response<StackOverflow> response) {
                if (!response.isSuccessful()) { // Prevents error like 404
                    Log.d(TAG, "onResponse: "+response.code());
                    return;
                }
                mItemList = new ArrayList<>();//Inside this list item we get all our values
                StackOverflow stackResponse = response.body(); // The response come here as JSON

                mItemList = stackResponse.getItems();
                //We are using callback object to pass the result
                callback.onResult(
                        mItemList, // Pass the list items
                        null, // Initial page so there is no previous page
                        FIRST_PAGE+1 // Next page
                );
            }

            @Override
            public void onFailure(Call<StackOverflow> call, Throwable t) {

            }
        });
    }

    /**load the data when we scroll up , ie; fetch from previous page*/
    /**@param params from here we get the page number*/
    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        Call<StackOverflow> call = RetrofitClient.getInstance().getApi().getAnswers
                (params.key, // Get the page key
                PAGE_SIZE,
                SITE_NAME);
        call.enqueue(new Callback<StackOverflow>() {
            @Override
            public void onResponse(Call<StackOverflow> call, Response<StackOverflow> response) {
                if (!response.isSuccessful()) { // Prevents error like 404
                    Log.d(TAG, "onResponse: "+response.code());
                    return;
                }
                Integer Page;
                if (params.key >1) { // if its not in the first page load the previous page else set Page as NULL
                   Page = params.key -1;
                }else {
                    Page = null;
                }

                mItemList = new ArrayList<>();//Inside this list item we get all our values
                StackOverflow stackResponse = response.body(); // The response come here as JSON

                mItemList = stackResponse.getItems();
                //We are using callback object to pass the result
                callback.onResult(
                        mItemList, // Pass the list items
                        Page // Adjacent page Page
                );


            }

            @Override
            public void onFailure(Call<StackOverflow> call, Throwable t) {

            }
        });
    }

    /** Load data when we scroll down, ie; fetch from next page*/
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        Call<StackOverflow> call = RetrofitClient.getInstance().getApi().getAnswers
                (params.key, // Get the page key
                        PAGE_SIZE,
                        SITE_NAME);
        call.enqueue(new Callback<StackOverflow>() {
            @Override
            public void onResponse(Call<StackOverflow> call, Response<StackOverflow> response) {
                if (!response.isSuccessful()) { // Prevents error like 404
                    Log.d(TAG, "onResponse: "+response.code());
                    return;
                }

                mItemList = new ArrayList<>();//Inside this list item we get all our values
                StackOverflow stackResponse = response.body(); // The response come here as JSON

                Integer page;
                if (stackResponse.getHasMore()) { // Checks whether there is more pages or not
                    page = params.key +1;
                }else {
                    page = null;
                }

                mItemList = stackResponse.getItems();
                //We are using callback object to pass the result
                callback.onResult(
                        mItemList, // Pass the list items
                        page // Adjacent page page
                );


            }

            @Override
            public void onFailure(Call<StackOverflow> call, Throwable t) {

            }
        });
    }
}
