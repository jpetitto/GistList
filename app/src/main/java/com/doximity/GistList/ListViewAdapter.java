package com.doximity.GistList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doximity.GistList.models.AttachedFile;
import com.doximity.GistList.models.Gist;
import com.squareup.picasso.Picasso;

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
        return new ViewHolder(inflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gist item = items.get(position);

        Picasso.with(holder.itemView.getContext()).load(item.owner.avatarUrl).into(holder.imageView);

        Iterator<AttachedFile> iterator = item.files.values().iterator();
        AttachedFile file = null;
        if (iterator.hasNext()) {
            file = iterator.next();
        }

        if (file != null) {
            holder.tvFileName.setText(file.filename);
            holder.tvFileType.setText(file.type);
            holder.tvFileLanguage.setText(file.language);
            holder.tvFileSize.setText(String.valueOf(file.size));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvFileName;
        private TextView tvFileType;
        private TextView tvFileLanguage;
        private TextView tvFileSize;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            tvFileName = (TextView) itemView.findViewById(R.id.item_file_name);
            tvFileType = (TextView) itemView.findViewById(R.id.item_file_type);
            tvFileLanguage = (TextView) itemView.findViewById(R.id.item_language);
            tvFileSize = (TextView) itemView.findViewById(R.id.item_file_size);
        }
    }

}
