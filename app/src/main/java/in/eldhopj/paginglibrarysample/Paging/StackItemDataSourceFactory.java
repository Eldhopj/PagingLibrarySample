package in.eldhopj.paginglibrarysample.Paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
/**A DataSource.Factory is responsible for creating a DataSource.*/
public class StackItemDataSourceFactory extends DataSource.Factory {
    private static final String TAG = "StackItemDataSourceFact";

    /**The params (PageKeyedDataSource<Integer,Item>) are same as in the StackItemDataSource
     *MutableLiveData is a subclass of LiveData which is used for some of it’s properties (setValue/postValue) and using these properties we can easily notify the ui when onChange() is called*/
    private MutableLiveData <PageKeyedDataSource<Integer,Item>> liveDataSource = new MutableLiveData<>();

    @Override
    public DataSource create() { // This method will return our data source
        StackItemDataSource dataSource = new StackItemDataSource(); // Instance of DataSource
        liveDataSource.postValue(dataSource); // Putting value from DataSource into liveDataSource
        return dataSource;
    }

    //Generate a Getter
    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getLiveDataSource() {
        return liveDataSource;
    }
}
