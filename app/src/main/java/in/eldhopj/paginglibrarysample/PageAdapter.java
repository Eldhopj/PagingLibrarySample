package in.eldhopj.paginglibrarysample;

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

import java.util.List;

import in.eldhopj.paginglibrarysample.ModelClasses.Item;


/**There are different kinds of paging adapters for different usages here we get data as per page so we use PagedListAdapter*/
public class PageAdapter extends PagedListAdapter<Item,PageAdapter.ViewHolder> {

    private Context mCtx;
    private List<Item> mListItems; // List

    /**Create a constructor*/
    protected PageAdapter(Context mCtx) {
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
        Item listitem = mListItems.get(position);
        if (listitem != null) {
            holder.name.setText(listitem.getOwner().getDisplayName());
            Picasso.get().load(listitem.getOwner().getProfileImage()).into(holder.displayPic);
        }
    }

    @Override
    public int getItemCount() { // return the size of the list view , NOTE : this must be a fast process
        if (mListItems == null) {
            return 0;
        }
        return mListItems.size();
    }

    /**Create an inner class ViewHolder which extends RecyclerView.ViewHolder*/
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView displayPic;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            displayPic = itemView.findViewById(R.id.displayPic);
        }
    }


}
