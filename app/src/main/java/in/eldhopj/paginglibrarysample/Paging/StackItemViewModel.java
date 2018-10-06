package in.eldhopj.paginglibrarysample.Paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
import in.eldhopj.paginglibrarysample.Utils.StackItemConfig;

/**The view model is responsible for creating the PagedList along with its configurations and send it to the activity
 *  so it can observe the data changes and pass it to the adapter*/

public class StackItemViewModel extends ViewModel {

    private LiveData<PageKeyedDataSource<Integer,Item>> liveDataSource;

    /**PagedList is a wrapper list that holds your data items and invokes the DataSource to load the elements.
     * It typically consists of a background executor (which fetches the data) and the foreground executor (which updates the UI with the data).*/
    public LiveData<PagedList<Item>> itemPagedList;

    public StackItemViewModel() {
        StackItemDataSourceFactory dataSourceFactory = new StackItemDataSourceFactory(); // Instance of StackItemDataSourceFactory

        liveDataSource = dataSourceFactory.getLiveDataSource();//with the help of this dataSourceFactory we will get our liveDataSource

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(16) //The number of items to load initially.
                .setPageSize(StackItemConfig.PAGE_SIZE)
                .setPrefetchDistance(8) // Loads 8 items initially when the screen loads
                .build();

        itemPagedList = new LivePagedListBuilder(dataSourceFactory,config).build();
    }
}