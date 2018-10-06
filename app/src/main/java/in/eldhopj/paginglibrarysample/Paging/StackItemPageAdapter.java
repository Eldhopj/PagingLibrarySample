package in.eldhopj.paginglibrarysample.Paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;
import in.eldhopj.paginglibrarysample.R;

/**Paging adapter loads data into recycler view
 * There are different kinds of paging adapters for different usages here we get data as per page so we use PagedListAdapter*/
public class StackItemPageAdapter extends PagedListAdapter<Item,StackItemPageAdapter.ViewHolder> {

    private Context mCtx;
    Item listItem;

    /**Create a constructor*/
    public StackItemPageAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    /**diffCallback helps us to determine whether 2 objects or 2 list objects are same or not*/
    private static  DiffUtil.ItemCallback <Item>  DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Item>() {
                @Override
                public boolean areItemsTheSame(Item oldItem, Item newItem) { // checks whether the items are same or not
                    return oldItem.getAnswerId().equals(newItem.getAnswerId()); // Checks old unique id and new unique id are same or not
                }

                @Override
                public boolean areContentsTheSame(Item oldItem, Item newItem) {
                    return oldItem.equals(newItem); // check whether the old items contents are same as new items content
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        listItem = getItem(position);
        if (listItem != null) {
            holder.name.setText(listItem.getOwner().getDisplayName());
            Picasso.get().load(listItem.getOwner().getProfileImage()).into(holder.displayPic);
        }
    }

    /**Create an inner class ViewHolder which extends RecyclerView.ViewHolder*/
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView displayPic;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            displayPic = itemView.findViewById(R.id.displayPic);
        }
    }


}
