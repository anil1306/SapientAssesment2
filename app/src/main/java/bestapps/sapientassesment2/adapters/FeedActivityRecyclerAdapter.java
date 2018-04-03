package bestapps.sapientassesment2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import bestapps.sapientassesment2.R;
import bestapps.sapientassesment2.interfaces.ItemClickListener;
import bestapps.sapientassesment2.model.Row;

/**
 * Created by Anil on 4/3/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class FeedActivityRecyclerAdapter extends RecyclerView.Adapter {
    private static ItemClickListener mItemClickListener;
    private final Context context;
    private List<Row> rows = new ArrayList<>();

    public FeedActivityRecyclerAdapter(final Context context) {
        this.context = context;
    }

    /**
     * @param mListRowFeed : Rows feed from json
     */
    public void mRecyclerViewAdapterData(List<Row> mListRowFeed) {
        this.rows = mListRowFeed;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FeedActivityRecyclerAdapter.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_view, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Row getDataAdapter = rows.get(position);
        ((ViewHolder) holder).feed_Desc.setText(getDataAdapter.getDescription());
        ((ViewHolder) holder).feed_title.setText(getDataAdapter.getTitle());
        Glide.with(context).load(getDataAdapter.getImageHref())
                .error(R.drawable.placeholder)
                .into(((ViewHolder) holder).imageFromURL);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void setOnItemClickListener(ItemClickListener clickListener) {
        FeedActivityRecyclerAdapter.mItemClickListener = clickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView feed_Desc;
        public final TextView feed_title;
        public final ImageView imageFromURL;
        public ViewHolder(View itemView) {
            super(itemView);
            feed_Desc = (TextView) itemView.findViewById(R.id.textView_desc);
            feed_title=(TextView) itemView.findViewById(R.id.textView_by);
            imageFromURL = (ImageView) itemView.findViewById(R.id.image_Href);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(getAdapterPosition());
        }
    }

}