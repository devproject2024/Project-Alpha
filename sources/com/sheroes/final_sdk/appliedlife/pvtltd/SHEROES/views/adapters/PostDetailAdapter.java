package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.CommentCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.PostDetailCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.CommentLoaderViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommentNewViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.UserPostHolder;
import java.util.ArrayList;
import java.util.List;

public class PostDetailAdapter extends RecyclerView.a<RecyclerView.v> {
    private static final int TYPE_COMMENT = 3;
    private static final int TYPE_LOADER = 1;
    private static final int TYPE_USER_POST = 2;
    private boolean hasMoreItem = false;
    private int loaderPostion;
    private final CommentCallBack mCommentCallback;
    private final Context mContext;
    private List<BaseResponse> mFeedDetail;
    private final PostDetailCallBack mPostDetailCallback;
    private boolean showLoader = false;

    public PostDetailAdapter(Context context, PostDetailCallBack postDetailCallBack, CommentCallBack commentCallBack) {
        this.mContext = context;
        this.mFeedDetail = new ArrayList();
        this.mPostDetailCallback = postDetailCallBack;
        this.mCommentCallback = commentCallBack;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (i2 == 1) {
            return new CommentLoaderViewHolder(from.inflate(R.layout.comment_sheroes_loader_view, viewGroup, false));
        }
        if (i2 == 2) {
            return new UserPostHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_sheroes_post, viewGroup, false), this.mPostDetailCallback);
        }
        if (i2 != 3) {
            return null;
        }
        return new CommentNewViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_sheroes_item_new_layout, viewGroup, false), this.mCommentCallback);
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null) {
            int itemViewType = vVar.getItemViewType();
            if (itemViewType == 1) {
                ((CommentLoaderViewHolder) vVar).bindData(vVar.getAdapterPosition(), this.showLoader, this.mPostDetailCallback);
            } else if (itemViewType == 2) {
                ((UserPostHolder) vVar).bindData((FeedDetail) this.mFeedDetail.get(i2), this.mContext, i2);
            } else if (itemViewType == 3) {
                ((CommentNewViewHolder) vVar).bindData((Comment) this.mFeedDetail.get(i2), this.mContext, i2);
            }
        }
    }

    public int getItemCount() {
        List<BaseResponse> list = this.mFeedDetail;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<BaseResponse> list) {
        this.mFeedDetail = list;
        notifyDataSetChanged();
    }

    public void setItem(BaseResponse baseResponse, int i2) {
        this.mFeedDetail.set(i2, baseResponse);
        notifyItemChanged(i2);
    }

    public int getItemViewType(int i2) {
        BaseResponse baseResponse = this.mFeedDetail.get(i2);
        if (baseResponse instanceof UserPostSolrObj) {
            return 2;
        }
        return baseResponse instanceof Comment ? 3 : 1;
    }

    public void addData(BaseResponse baseResponse, int i2) {
        this.mFeedDetail.add(i2, baseResponse);
        notifyItemInserted(i2);
    }

    public void addData(BaseResponse baseResponse) {
        int size = this.mFeedDetail.size();
        this.mFeedDetail.add(baseResponse);
        notifyItemInserted(size);
    }

    public void commentStartedLoading() {
        if (!this.showLoader) {
            this.showLoader = true;
            int loaderPostion2 = getLoaderPostion();
            if (loaderPostion2 != -1) {
                notifyItemChanged(loaderPostion2);
            }
        }
    }

    public void commentFinishedLoading() {
        if (this.showLoader) {
            int loaderPostion2 = getLoaderPostion();
            this.showLoader = false;
            if (loaderPostion2 != -1) {
                notifyItemChanged(loaderPostion2);
            }
        }
    }

    public int getLoaderPostion() {
        return (!this.hasMoreItem || CommonUtil.isEmpty(this.mFeedDetail) || !(this.mFeedDetail.get(0) instanceof UserPostSolrObj)) ? -1 : 1;
    }

    public void setHasMoreComments(boolean z) {
        if (!z) {
            int loaderPostion2 = getLoaderPostion();
            this.mFeedDetail.remove(loaderPostion2);
            notifyItemRemoved(loaderPostion2);
        }
        this.hasMoreItem = z;
    }

    public void addDatas(int i2, List<Comment> list) {
        this.mFeedDetail.addAll(i2, list);
        notifyItemRangeInserted(i2, list.size());
    }

    public void removeData(int i2) {
        this.mFeedDetail.remove(i2);
        notifyItemRemoved(i2);
    }

    public void setData(int i2, BaseResponse baseResponse) {
        this.mFeedDetail.set(i2, baseResponse);
        notifyItemChanged(i2);
    }
}
