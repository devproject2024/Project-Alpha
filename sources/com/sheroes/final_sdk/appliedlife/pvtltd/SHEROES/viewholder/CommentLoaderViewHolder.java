package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.PostDetailCallBack;

public class CommentLoaderViewHolder extends RecyclerView.v {
    private LinearLayout mAddContainer;
    private PostDetailCallBack mPostDetailCallBack;
    private ProgressBar mProgress;

    public CommentLoaderViewHolder(View view) {
        super(view);
        this.mProgress = (ProgressBar) view.findViewById(R.id.sheroes_progress_bar);
        this.mAddContainer = (LinearLayout) view.findViewById(R.id.sheroes_add_container);
        this.mAddContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommentLoaderViewHolder.this.onLoadMoreClick();
            }
        });
    }

    public void bindData(int i2, boolean z, PostDetailCallBack postDetailCallBack) {
        this.mPostDetailCallBack = postDetailCallBack;
        if (z) {
            this.mProgress.setVisibility(0);
            this.mAddContainer.setVisibility(8);
            return;
        }
        this.mProgress.setVisibility(8);
        this.mAddContainer.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void onLoadMoreClick() {
        this.mPostDetailCallBack.loadMoreComments();
    }
}
