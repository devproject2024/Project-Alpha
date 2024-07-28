package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.ImageSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.squareup.picasso.e;
import com.squareup.picasso.w;

public class ImageViewHolder extends BaseViewHolder<FeedDetail> {
    private ImageView mImage;
    private ImageSolrObj mImageSolrObj;
    BaseHolderInterface viewInterface;

    public void viewRecycled() {
    }

    public ImageViewHolder(View view, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.mImage = (ImageView) view.findViewById(R.id.sheroes_feature_image);
        this.mImage.setOnClickListener(this);
        this.viewInterface = baseHolderInterface;
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.mImageSolrObj = (ImageSolrObj) feedDetail;
        if (CommonUtil.isNotEmpty(this.mImageSolrObj.getImageUrl())) {
            int windowWidth = CommonUtil.getWindowWidth(context) / 2;
            this.mImage.setLayoutParams(new RelativeLayout.LayoutParams(-1, windowWidth));
            String thumborUri = CommonUtil.getThumborUri(this.mImageSolrObj.getImageUrl(), CommonUtil.getWindowWidth(context), windowWidth);
            if (CommonUtil.isNotEmpty(thumborUri)) {
                w.a().a(thumborUri).a(this.mImage, (e) null);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sheroes_feature_image) {
            onImageClicked();
        }
    }

    private void onImageClicked() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onImagePostClicked(this.mImageSolrObj);
        }
    }
}
