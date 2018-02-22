package com.doximity.GistList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.doximity.GistList.databinding.ItemBinding;
import com.doximity.GistList.models.AttachedFile;
import com.doximity.GistList.models.Gist;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kayvan on 7/21/16.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private List<Gist> items;

    public ListViewAdapter(List<Gist> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBinding binding = ItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gist gist = items.get(position);

        Iterator<AttachedFile> iterator = gist.files.values().iterator();
        AttachedFile file = null;
        if (iterator.hasNext()) {
            file = iterator.next();
        }

        holder.bind(gist, file);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;

        ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Gist gist, AttachedFile file) {
            binding.setGist(gist);
            binding.setFile(file);
            binding.executePendingBindings();
        }
    }

}
