package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.ImageSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.LoaderViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.HeaderRecyclerViewAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CarouselViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommunityFlatViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedCommunityPostHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.HomeHeaderViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.ImageViewHolder;
import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends HeaderRecyclerViewAdapter {
    public static final String LIST_FEED = "FEED";
    public static final String TAG = "feedAdapter";
    private static final int TYPE_ARTICLE = 1;
    private static final int TYPE_CAROUSEL = 3;
    private static final int TYPE_CHALLENGE = 5;
    private static final int TYPE_COMMUNITY = 12;
    private static final int TYPE_EVENT = 6;
    private static final int TYPE_HOME_FEED_HEADER = 13;
    private static final int TYPE_IMAGE = 14;
    private static final int TYPE_INRO = 8;
    private static final int TYPE_JOB = 4;
    private static final int TYPE_LEADER = 11;
    private static final int TYPE_LOADER = -1;
    private static final int TYPE_MENTOR_COMPACT = 10;
    private static final int TYPE_MENTOR_SUGGESTION_CAROSEL = 9;
    private static final int TYPE_ORGANIZATION = 7;
    private static final int TYPE_USER_POST = 2;
    private BaseHolderInterface mBaseHolderInterface;
    private final Context mContext;
    private List<FeedDetail> mFeedDetailList;
    private SparseArray<Parcelable> scrollStatePositionsMap = new SparseArray<>();
    private boolean showLoader = false;

    public void bindHeaderViewHolder(HeaderRecyclerViewAdapter.HeaderViewHolder headerViewHolder) {
    }

    public FeedAdapter(Context context, BaseHolderInterface baseHolderInterface) {
        this.mContext = context;
        this.mFeedDetailList = new ArrayList();
        this.mBaseHolderInterface = baseHolderInterface;
    }

    public RecyclerView.v customOnCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (i2 == -1) {
            return new LoaderViewHolder(from.inflate(R.layout.infinite_sheroes_loading, viewGroup, false));
        }
        if (i2 == 2) {
            return new FeedCommunityPostHolder(from.inflate(R.layout.feed_sheroes_comunity_user_post_normal, viewGroup, false), this.mBaseHolderInterface);
        }
        if (i2 == 9) {
            return new CarouselViewHolder(from.inflate(R.layout.mentor_sheroes_suggested_card_holder, viewGroup, false), this.mBaseHolderInterface);
        }
        switch (i2) {
            case 12:
                return new CommunityFlatViewHolder(from.inflate(R.layout.community_sheroes_flat_layout, viewGroup, false), this.mBaseHolderInterface);
            case 13:
                return new HomeHeaderViewHolder(from.inflate(R.layout.header_sheroes_view_layout, viewGroup, false), this.mBaseHolderInterface);
            case 14:
                return new ImageViewHolder(from.inflate(R.layout.image_sheroes_item, viewGroup, false), this.mBaseHolderInterface);
            default:
                return null;
        }
    }

    public void customOnBindViewHolder(RecyclerView.v vVar, int i2) {
        int itemViewType = vVar.getItemViewType();
        if (itemViewType == -1) {
            ((LoaderViewHolder) vVar).bindData(vVar.getAdapterPosition(), this.showLoader);
        } else if (itemViewType == 2) {
            ((FeedCommunityPostHolder) vVar).bindData((FeedDetail) (UserPostSolrObj) this.mFeedDetailList.get(i2), this.mContext, i2);
        } else if (itemViewType != 9) {
            switch (itemViewType) {
                case 12:
                    ((CommunityFlatViewHolder) vVar).bindData((FeedDetail) (CommunityFeedSolrObj) this.mFeedDetailList.get(i2), this.mContext, i2);
                    return;
                case 13:
                    ((HomeHeaderViewHolder) vVar).bindData(this.mFeedDetailList.get(i2), this.mContext, i2);
                    return;
                case 14:
                    ((ImageViewHolder) vVar).bindData(this.mFeedDetailList.get(i2), this.mContext, i2);
                    return;
                default:
                    return;
            }
        } else {
            ((CarouselViewHolder) vVar).bindData((CarouselDataObj) this.mFeedDetailList.get(i2), this.mContext, i2);
        }
    }

    public int customGetItemViewType(int i2) {
        if (i2 >= getDataItemCount() || getDataItemCount() <= 0) {
            return -1;
        }
        FeedDetail feedDetail = this.mFeedDetailList.get(i2);
        if (feedDetail instanceof UserPostSolrObj) {
            UserPostSolrObj userPostSolrObj = (UserPostSolrObj) feedDetail;
            if (userPostSolrObj.getCommunityId().longValue() != 299 || userPostSolrObj.getCommunityTypeId() == 10) {
                return (userPostSolrObj.getCommunityTypeId() != 10 || userPostSolrObj.isCommentAllowed()) ? 2 : 7;
            }
            return 6;
        } else if (feedDetail.getSubType().equalsIgnoreCase(AppConstants.APP_INTRO_SUB_TYPE)) {
            return 8;
        } else {
            if (feedDetail instanceof CarouselDataObj) {
                return 9;
            }
            if (feedDetail instanceof UserSolrObj) {
                return 10;
            }
            if (feedDetail instanceof CommunityFeedSolrObj) {
                return 12;
            }
            if (feedDetail instanceof ImageSolrObj) {
                return 14;
            }
            return feedDetail.getSubType().equalsIgnoreCase("HEADER") ? 13 : -1;
        }
    }

    public long getItemId(int i2) {
        if (getItemViewType(i2) == -1) {
            return -1;
        }
        return super.getItemId(i2);
    }

    public int customGetItemCount() {
        return getDataItemCount() + (this.showLoader ? 1 : 0);
    }

    public HeaderViewHolder getHeaderViewHolder(ViewGroup viewGroup) {
        LayoutInflater.from(this.mContext);
        return null;
    }

    public void feedStartedLoading() {
        if (!this.showLoader) {
            this.showLoader = true;
            notifyItemInserted(getLoaderPosition());
        }
    }

    public void feedFinishedLoading() {
        if (this.showLoader) {
            int loaderPosition = getLoaderPosition();
            this.showLoader = false;
            notifyItemRemoved(loaderPosition);
        }
    }

    public void setItem(int i2, FeedDetail feedDetail) {
        this.mFeedDetailList.set(i2, feedDetail);
        customNotifyItemChanged(i2);
    }

    public void setData(List<FeedDetail> list) {
        this.mFeedDetailList = list;
    }

    private int getLoaderPosition() {
        if (this.showLoader) {
            return getItemCount() - 1;
        }
        return -1;
    }

    private int getDataItemCount() {
        List<FeedDetail> list = this.mFeedDetailList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void showToolTip() {
        notifyDataSetChanged();
    }

    public void setData(int i2, FeedDetail feedDetail) {
        this.mFeedDetailList.set(i2, feedDetail);
        notifyItemChanged(i2);
    }

    public void setData(int i2, int i3, FeedDetail feedDetail) {
        FeedDetail feedDetail2 = this.mFeedDetailList.get(i2);
        if (feedDetail2 instanceof CarouselDataObj) {
            CarouselDataObj carouselDataObj = (CarouselDataObj) feedDetail2;
            carouselDataObj.getFeedDetails().get(i3);
            carouselDataObj.getFeedDetails().set(i3, feedDetail);
        }
        this.mFeedDetailList.set(i2, feedDetail2);
        notifyItemChanged(i2);
    }

    public void removeItem(int i2) {
        this.mFeedDetailList.remove(i2);
        notifyItemRemoved(i2);
    }

    public List<FeedDetail> getDataList() {
        return this.mFeedDetailList;
    }

    public void addAll(List<FeedDetail> list) {
        int size = this.mFeedDetailList.size();
        this.mFeedDetailList.addAll(list);
        notifyItemRangeChanged(size, this.mFeedDetailList.size());
    }

    public class HeaderViewHolder extends HeaderRecyclerViewAdapter.HeaderViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }
}
