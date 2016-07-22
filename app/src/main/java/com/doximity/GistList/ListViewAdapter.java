package com.doximity.GistList;

import com.google.common.base.Strings;

import com.doximity.GistList.models.AttachedFile;
import com.doximity.GistList.models.Gist;
import com.doximity.GistList.models.Owner;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kayvan on 7/21/16.
 */
public class ListViewAdapter extends BaseAdapter {

    ArrayList<Gist> items;

    public ListViewAdapter(ArrayList<Gist> items) {
        this.items = items;
    }

    @Override public int getCount() {
        return items.size();
    }

    @Override public Object getItem(int position) {
        return items.get(position);
    }

    @Override public long getItemId(int position) {
        return 0;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: 7/22/16 Task 1
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
        TextView tvFileName = (TextView) view.findViewById(R.id.item_file_name);
        TextView tvFileType = (TextView) view.findViewById(R.id.item_file_type);
        TextView tvFileLanguage = (TextView) view.findViewById(R.id.item_language);
        TextView tvFileSize = (TextView) view.findViewById(R.id.item_file_size);

        Gist item = (Gist) getItem(position);
        Owner owner = item.owner;
        if (owner != null) {
            String imageUrl = owner.avatarUrl;
            if (!Strings.isNullOrEmpty(imageUrl)) {
                Picasso.with(view.getContext()).load(imageUrl).into(imageView);
            }
        }

        Iterator<AttachedFile> iterator = item.files.values().iterator();
        if (iterator.hasNext()) {
            AttachedFile file = iterator.next();
            tvFileName.setText(file.filename);
            tvFileType.setText(file.type);
            tvFileLanguage.setText(file.language);
            tvFileSize.setText(String.valueOf(file.size));
        }

        return view;
    }

}
