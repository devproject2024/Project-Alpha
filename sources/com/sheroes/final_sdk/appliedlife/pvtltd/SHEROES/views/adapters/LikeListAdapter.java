package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CircleTransform;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;

public class LikeListAdapter extends RecyclerView.a<LikeListItemViewHolder> {
    private List<Comment> mCommentList = new ArrayList();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public LikeHolderListener onLikeClickListener;

    public interface LikeHolderListener {
        void onLikeRowItemClicked(LikeListItemViewHolder likeListItemViewHolder);
    }

    public LikeListAdapter(Context context, List<Comment> list) {
        this.mContext = context;
        this.mCommentList = list;
    }

    public LikeListAdapter(Context context, List<Comment> list, LikeHolderListener likeHolderListener) {
        this.mContext = context;
        this.mCommentList = list;
        this.onLikeClickListener = likeHolderListener;
    }

    public LikeListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new LikeListItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sheroes_user_liked_item, viewGroup, false));
    }

    public void onBindViewHolder(LikeListItemViewHolder likeListItemViewHolder, int i2) {
        likeListItemViewHolder.bindData(this.mCommentList.get(i2), i2);
    }

    public int getItemCount() {
        List<Comment> list = this.mCommentList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Comment getComment(int i2) {
        if (i2 < 0 || i2 >= this.mCommentList.size()) {
            return null;
        }
        return this.mCommentList.get(i2);
    }

    public class LikeListItemViewHolder extends RecyclerView.v {
        int authorPicSize;
        public TextView userName;
        public ImageView userPic;

        public LikeListItemViewHolder(View view) {
            super(view);
            this.userPic = (ImageView) view.findViewById(R.id.sheroes_user_pic);
            this.userName = (TextView) view.findViewById(R.id.sheroes_user_name);
            this.authorPicSize = LikeListAdapter.this.mContext.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
            view.setOnClickListener(new View.OnClickListener(LikeListAdapter.this) {
                public void onClick(View view) {
                    LikeListAdapter.this.onLikeClickListener.onLikeRowItemClicked(LikeListItemViewHolder.this);
                }
            });
        }

        public void bindData(Comment comment, int i2) {
            if (comment != null) {
                if (comment.getParticipantImageUrl() != null && CommonUtil.isNotEmpty(comment.getParticipantImageUrl())) {
                    String participantImageUrl = comment.getParticipantImageUrl();
                    int i3 = this.authorPicSize;
                    w.a().a(CommonUtil.getThumborUri(participantImageUrl, i3, i3)).a((ah) new CircleTransform(0.0f, 0)).a(this.userPic, (e) null);
                }
                this.userName.setText(comment.getParticipantName());
            }
        }
    }
}
