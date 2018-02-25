package com.doximity.GistList;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doximity.GistList.databinding.ItemBinding;
import com.doximity.GistList.models.AttachedFile;
import com.doximity.GistList.models.Gist;

import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by kayvan on 7/21/16.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    private static final long ANIMATION_DURATION = 250L;

    private RecyclerView recyclerView;

    private List<Gist> items;
    private Observable<Boolean> showImageStream;
    private boolean showImage;
    private float imageWidth;

    public ListViewAdapter(List<Gist> items, Observable<Boolean> showImageStream, boolean showImage, float imageWidth) {
        this.items = items;
        this.showImageStream = showImageStream;
        this.showImage = showImage;
        this.imageWidth = imageWidth;
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

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;

        ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            subscribeToImageUpdates();
        }

        private void bind(Gist gist, AttachedFile file) {
            binding.setGist(gist);
            binding.setFile(file);
            binding.executePendingBindings();

            binding.image.setVisibility(showImage ? View.VISIBLE : View.GONE);
            binding.image.setAlpha(showImage ? 1f : 0f);
            binding.getRoot().setTranslationX(0f);
        }

        private void subscribeToImageUpdates() {
            // no need for subscription management since the number of ViewHolders is fixed
            // and stream updates are synchronous on the main thread
            showImageStream.subscribe(new Action1<Boolean>() {
                @Override
                public void call(final Boolean showImage) {
                    ListViewAdapter.this.showImage = showImage;

                    // don't animate image update if ViewHolder is not visible
                    if (isViewHolderOffscreen()) {
                        binding.image.setVisibility(showImage ? View.VISIBLE : View.GONE);
                        binding.image.setAlpha(showImage ? 1f : 0f);
                        return;
                    }

                    // when showing the image: translate first, fade second
                    // when hiding  the image: fade first, translate second
                    binding.image.animate()
                            .setStartDelay(showImage ? ANIMATION_DURATION : 0)
                            .setDuration(ANIMATION_DURATION)
                            .alpha(showImage ? 1f : 0f)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationStart(Animator animation) {
                                    if (showImage) {
                                        // after translation, show image before fading in
                                        binding.image.setVisibility(View.VISIBLE);
                                    }
                                }
                            });

                    binding.getRoot().animate()
                            .setStartDelay(showImage ? 0 : ANIMATION_DURATION)
                            .setDuration(ANIMATION_DURATION)
                            .translationX(showImage ? imageWidth : -imageWidth)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    // reset translation since the image's visibility will fix it into position
                                    binding.getRoot().setTranslationX(0f);

                                    if (!showImage) {
                                        binding.image.setVisibility(View.GONE);
                                    }
                                }
                            });
                }
            });
        }

        private boolean isViewHolderOffscreen() {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int position = getAdapterPosition();
            return position < layoutManager.findFirstVisibleItemPosition() || position > layoutManager.findLastVisibleItemPosition();
        }
    }
}
