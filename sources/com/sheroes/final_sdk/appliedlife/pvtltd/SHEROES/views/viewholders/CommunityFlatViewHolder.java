package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
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

public class CommunityFlatViewHolder extends BaseViewHolder<FeedDetail> {
    private final String TAG = CommunityFlatViewHolder.class.getName();
    private CommunityFeedSolrObj mCommunityFeedObj;
    ImageView mCommunityIcon;
    int mCommunityIconSize;
    TextView mCommunityJoin;
    TextView mCommunityMemberCount;
    TextView mCommunityName;
    ImageView mFeatureImage;
    private BaseHolderInterface viewInterface;

    public void viewRecycled() {
    }

    public CommunityFlatViewHolder(View view, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.mFeatureImage = (ImageView) view.findViewById(R.id.sheroes_feature_image);
        this.mCommunityIcon = (ImageView) view.findViewById(R.id.sheroes_community_icon);
        this.mCommunityName = (TextView) view.findViewById(R.id.sheroes_community_name);
        this.mCommunityMemberCount = (TextView) view.findViewById(R.id.sheroes_community_member_count);
        this.mCommunityJoin = (TextView) view.findViewById(R.id.sheroes_community_join);
        this.mCommunityJoin.setOnClickListener(this);
        this.mCommunityIconSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        new Handler();
        this.viewInterface = baseHolderInterface;
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.mCommunityFeedObj = (CommunityFeedSolrObj) feedDetail;
        this.mCommunityFeedObj.setItemPosition(i2);
        if (!this.mCommunityFeedObj.isMember() && !this.mCommunityFeedObj.isOwner() && !this.mCommunityFeedObj.isRequestPending()) {
            this.mCommunityJoin.setTextColor(b.c(context, R.color.colorAccent));
            this.mCommunityJoin.setText(context.getString(R.string.sheroes_ID_JOIN));
            this.mCommunityJoin.setBackgroundResource(R.drawable.rectangle_sheroes_feed_commnity_join);
        } else if (this.mCommunityFeedObj.isOwner() || this.mCommunityFeedObj.isMember()) {
            this.mCommunityJoin.setTextColor(b.c(context, R.color.sheroes_white));
            this.mCommunityJoin.setText(context.getString(R.string.sheroes_ID_JOINED));
            this.mCommunityJoin.setBackgroundResource(R.drawable.rectangle_sheroes_feed_community_joined_active);
        }
        int windowWidth = (int) (((float) CommonUtil.getWindowWidth(context)) * 0.5f);
        this.mFeatureImage.getLayoutParams().height = windowWidth;
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getImageUrl())) {
            w.a().a(CommonUtil.getThumborUri(this.mCommunityFeedObj.getImageUrl(), CommonUtil.getWindowWidth(context), windowWidth)).a(this.mFeatureImage, (e) null);
        }
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getThumbnailImageUrl())) {
            String thumbnailImageUrl = this.mCommunityFeedObj.getThumbnailImageUrl();
            int i3 = this.mCommunityIconSize;
            w.a().a(CommonUtil.getThumborUri(thumbnailImageUrl, i3, i3)).a((ah) new CircleTransform(0.0f, 0)).a(this.mCommunityIcon, (e) null);
        }
        if (CommonUtil.isNotEmpty(this.mCommunityFeedObj.getNameOrTitle())) {
            this.mCommunityName.setText(this.mCommunityFeedObj.getNameOrTitle());
        }
        String quantityString = context.getResources().getQuantityString(R.plurals.numberOfMembers, this.mCommunityFeedObj.getNoOfMembers());
        TextView textView = this.mCommunityMemberCount;
        textView.setText(String.valueOf(StringUtil.numericToThousand(this.mCommunityFeedObj.getNoOfMembers()) + " " + quantityString));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sheroes_community_join) {
            onCommunityJoinUnjoinedClicked();
        }
    }

    private void onCommunityJoinUnjoinedClicked() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onCommunityJoinOrLeave(this.mCommunityFeedObj);
        }
    }
}
