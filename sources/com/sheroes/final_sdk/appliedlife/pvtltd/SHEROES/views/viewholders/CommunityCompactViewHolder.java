package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.AllCommunityItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CircleTransform;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public class CommunityCompactViewHolder extends BaseViewHolder<FeedDetail> {
    private final String TAG = CommunityCompactViewHolder.class.getName();
    private CarouselViewHolder mCarouselViewHolder;
    private CommunityFeedSolrObj mCommunityFeedObj;
    ImageView mCommunityIcon;
    int mCommunityIconSize;
    TextView mCommunityJoin;
    TextView mCommunityMemberCount;
    TextView mCommunityName;
    private Context mContext;
    ImageView mFeatureImage;
    int mFeatureImageHeight;
    int mFeatureImageWidth;
    private Handler mHandler;
    private BaseHolderInterface viewInterface;

    private void textViewOperation(Context context) {
    }

    public void viewRecycled() {
    }

    public CommunityCompactViewHolder(View view, BaseHolderInterface baseHolderInterface, CarouselViewHolder carouselViewHolder) {
        super(view);
        this.mFeatureImage = (ImageView) view.findViewById(R.id.sheroes_feature_image);
        this.mCommunityIcon = (ImageView) view.findViewById(R.id.sheroes_community_icon);
        this.mCommunityName = (TextView) view.findViewById(R.id.sheroes_community_name);
        this.mCommunityMemberCount = (TextView) view.findViewById(R.id.sheroes_community_member_count);
        this.mCommunityJoin = (TextView) view.findViewById(R.id.sheroes_community_join);
        this.mCommunityJoin.setOnClickListener(this);
        this.mCommunityIconSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        this.mFeatureImageHeight = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_150);
        this.mFeatureImageWidth = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_300);
        this.mHandler = new Handler();
        this.viewInterface = baseHolderInterface;
        this.mCarouselViewHolder = carouselViewHolder;
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.mCommunityFeedObj = (CommunityFeedSolrObj) feedDetail;
        this.mContext = context;
        if (this.mCommunityFeedObj.isOwner() || this.mCommunityFeedObj.isMember()) {
            this.mCommunityJoin.setTextColor(b.c(this.mContext, R.color.sheroes_white));
            this.mCommunityJoin.setText(this.mContext.getString(R.string.sheroes_ID_JOINED));
            this.mCommunityJoin.setBackgroundResource(R.drawable.rectangle_sheroes_feed_community_joined_active);
        } else if (!this.mCommunityFeedObj.isMember() && !this.mCommunityFeedObj.isOwner() && !this.mCommunityFeedObj.isRequestPending()) {
            this.mCommunityJoin.setTextColor(b.c(this.mContext, R.color.colorAccent));
            this.mCommunityJoin.setText(this.mContext.getString(R.string.sheroes_ID_JOIN));
            this.mCommunityJoin.setBackgroundResource(R.drawable.rectangle_sheroes_feed_commnity_join);
        }
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getImageUrl())) {
            w.a().a(CommonUtil.getThumborUri(this.mCommunityFeedObj.getImageUrl(), this.mFeatureImageWidth, this.mFeatureImageHeight)).a(this.mFeatureImage, (e) null);
        }
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getThumbnailImageUrl())) {
            String thumbnailImageUrl = this.mCommunityFeedObj.getThumbnailImageUrl();
            int i3 = this.mCommunityIconSize;
            w.a().a(CommonUtil.getThumborUri(thumbnailImageUrl, i3, i3)).a((ah) new CircleTransform(0.0f, 0)).a(this.mCommunityIcon, (e) null);
        }
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getNameOrTitle())) {
            this.mCommunityName.setText(this.mCommunityFeedObj.getNameOrTitle());
        }
        String quantityString = this.mContext.getResources().getQuantityString(R.plurals.numberOfMembers, this.mCommunityFeedObj.getNoOfMembers());
        TextView textView = this.mCommunityMemberCount;
        textView.setText(String.valueOf(StringUtil.numericToThousand(this.mCommunityFeedObj.getNoOfMembers()) + " " + quantityString));
    }

    public void onClick(View view) {
        if (view == this.mCommunityJoin) {
            onCommunityJoinUnjoinedClicked();
        }
    }

    public void onCommunityJoinUnjoinedClicked() {
        if (this.viewInterface instanceof AllCommunityItemCallback) {
            if (this.mCommunityFeedObj.isMember()) {
                this.mCommunityFeedObj.setMember(false);
                CommunityFeedSolrObj communityFeedSolrObj = this.mCommunityFeedObj;
                communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() - 1);
                BaseHolderInterface baseHolderInterface = this.viewInterface;
                if (baseHolderInterface instanceof AllCommunityItemCallback) {
                    ((AllCommunityItemCallback) baseHolderInterface).unJoinCommunity(this.mCommunityFeedObj, this.mCarouselViewHolder);
                }
            } else {
                this.mCommunityFeedObj.setMember(true);
                CommunityFeedSolrObj communityFeedSolrObj2 = this.mCommunityFeedObj;
                communityFeedSolrObj2.setNoOfMembers(communityFeedSolrObj2.getNoOfMembers() + 1);
                BaseHolderInterface baseHolderInterface2 = this.viewInterface;
                if (baseHolderInterface2 instanceof AllCommunityItemCallback) {
                    ((AllCommunityItemCallback) baseHolderInterface2).joinRequestForOpenCommunity(this.mCommunityFeedObj, this.mCarouselViewHolder);
                }
            }
        }
        BaseHolderInterface baseHolderInterface3 = this.viewInterface;
        if (baseHolderInterface3 instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface3).onCommunityJoinOrLeave(this.mCommunityFeedObj);
        }
    }
}
