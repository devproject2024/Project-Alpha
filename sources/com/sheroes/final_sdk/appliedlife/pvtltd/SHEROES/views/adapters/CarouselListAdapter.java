package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.UserPostCompactViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CarouselViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommunityCompactViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.SeeMoreCompactViewHolder;
import java.util.ArrayList;
import java.util.List;

public class CarouselListAdapter extends RecyclerView.a<RecyclerView.v> {
    private static final int TYPE_COMMUNITY = 1;
    private static final int TYPE_MENTOR = 5;
    private static final int TYPE_SEE_MORE = 3;
    private static final int TYPE_USER = 2;
    private static final int TYPE_USER_POST = 4;
    private CarouselViewHolder carouselViewHolder;
    private BaseHolderInterface mBaseHolderInterface;
    private CarouselDataObj mCarouselDataObj;
    private final Context mContext;
    private List<FeedDetail> mFeedDetails = new ArrayList();

    public CarouselListAdapter(Context context, BaseHolderInterface baseHolderInterface, CarouselDataObj carouselDataObj, CarouselViewHolder carouselViewHolder2) {
        this.mContext = context;
        this.mBaseHolderInterface = baseHolderInterface;
        this.mCarouselDataObj = carouselDataObj;
        this.carouselViewHolder = carouselViewHolder2;
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new CommunityCompactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.community_sheroes_compact_layout, viewGroup, false), this.mBaseHolderInterface, this.carouselViewHolder);
        }
        if (i2 == 3) {
            return new SeeMoreCompactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sheroes_see_more_item, viewGroup, false), this.mBaseHolderInterface, this.mCarouselDataObj);
        }
        if (i2 != 4) {
            return null;
        }
        return new UserPostCompactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sheroes_user_post_compact_item, viewGroup, false), this.mContext, this.mBaseHolderInterface);
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null && vVar.getItemViewType() != -1) {
            int itemViewType = vVar.getItemViewType();
            int i3 = 0;
            if (itemViewType == 1) {
                CommunityCompactViewHolder communityCompactViewHolder = (CommunityCompactViewHolder) vVar;
                CommunityFeedSolrObj communityFeedSolrObj = (CommunityFeedSolrObj) this.mFeedDetails.get(i2);
                CarouselDataObj carouselDataObj = this.mCarouselDataObj;
                if (carouselDataObj != null) {
                    i3 = carouselDataObj.getItemPosition();
                }
                communityFeedSolrObj.setItemPosition(i3);
                communityCompactViewHolder.bindData((FeedDetail) communityFeedSolrObj, this.mContext, i2);
            } else if (itemViewType == 3) {
                ((SeeMoreCompactViewHolder) vVar).bindData();
            } else if (itemViewType == 4) {
                UserPostCompactViewHolder userPostCompactViewHolder = (UserPostCompactViewHolder) vVar;
                UserPostSolrObj userPostSolrObj = (UserPostSolrObj) this.mFeedDetails.get(i2);
                CarouselDataObj carouselDataObj2 = this.mCarouselDataObj;
                if (carouselDataObj2 != null) {
                    i3 = carouselDataObj2.getItemPosition();
                }
                userPostSolrObj.setItemPosition(i3);
                userPostCompactViewHolder.bindData(userPostSolrObj, this.mContext);
            }
        }
    }

    public int getItemViewType(int i2) {
        if (i2 < getDataItemCount() && getDataItemCount() > 0) {
            FeedDetail feedDetail = this.mFeedDetails.get(i2);
            if (feedDetail instanceof CommunityFeedSolrObj) {
                return 1;
            }
            if (feedDetail instanceof UserSolrObj) {
                return feedDetail.getEntityOrParticipantTypeId().intValue() == 7 ? 5 : 2;
            }
            if (feedDetail instanceof UserPostSolrObj) {
                return 4;
            }
        }
        return (i2 != getDataItemCount() || !CommonUtil.isNotEmpty(this.mCarouselDataObj.getEndPointUrl())) ? -1 : 3;
    }

    public int getItemCount() {
        if (getDataItemCount() <= 0 || CommonUtil.isNotEmpty(this.mCarouselDataObj.getEndPointUrl())) {
            List<FeedDetail> list = this.mFeedDetails;
            if (list == null) {
                return 0;
            }
            return list.size() + 1;
        }
        List<FeedDetail> list2 = this.mFeedDetails;
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    public void setData(List<FeedDetail> list) {
        this.mFeedDetails = null;
        this.mFeedDetails = list;
    }

    public void setData(FeedDetail feedDetail) {
        int findPositionById = findPositionById(feedDetail.getIdOfEntityOrParticipant());
        if (findPositionById != -1) {
            this.mFeedDetails.set(findPositionById, feedDetail);
            notifyItemChanged(findPositionById);
        }
    }

    public int findPositionById(long j) {
        if (CommonUtil.isEmpty(this.mFeedDetails)) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mFeedDetails.size(); i2++) {
            FeedDetail feedDetail = this.mFeedDetails.get(i2);
            if (feedDetail != null && feedDetail.getIdOfEntityOrParticipant() == j) {
                return i2;
            }
        }
        return -1;
    }

    private int getDataItemCount() {
        List<FeedDetail> list = this.mFeedDetails;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
