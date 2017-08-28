package ch.teko.restexample.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ch.teko.restexample.R;


/**
 * Created by jonathan on 08.08.17.
 */

public class RepoRecyclerAdapter extends RecyclerView.Adapter<RepoRecyclerAdapter.RepoViewHolder> {
    public List<Repository> items;

    public RepoRecyclerAdapter() {
    }

    public RepoRecyclerAdapter(List<Repository> items) {
        this.items = items;
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public RepoViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RepoViewHolder pvh = new RepoViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.title.setText(items.get(position).name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Repository getItme(int position) {
        return items.get(position);
    }
}
