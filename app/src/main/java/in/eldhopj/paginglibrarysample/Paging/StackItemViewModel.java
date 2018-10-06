package in.eldhopj.paginglibrarysample.Paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
import in.eldhopj.paginglibrarysample.StackItemConfig;

public class StackItemViewModel extends ViewModel {

    private LiveData<PageKeyedDataSource<Integer,Item>> liveDataSource;
    public LiveData<PagedList<Item>> itemPagedList;

    public StackItemViewModel() {
        StackItemDataSourceFactory dataSourceFactory = new StackItemDataSourceFactory(); // Instance of StackItemDataSourceFactory

        liveDataSource = dataSourceFactory.getLiveDataSource();//with the help of this dataSourceFactory we will get our liveDataSource

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(StackItemConfig.PAGE_SIZE)
                .build();

        itemPagedList = new LivePagedListBuilder(dataSourceFactory,config).build();
    }
}
