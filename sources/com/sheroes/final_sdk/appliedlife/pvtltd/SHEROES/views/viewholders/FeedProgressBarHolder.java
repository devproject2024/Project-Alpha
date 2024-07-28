package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.view.View;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;

public class FeedProgressBarHolder extends BaseViewHolder<BaseResponse> {
    private BaseResponse dataItem;
    BaseHolderInterface viewInterface;

    public void bindData(BaseResponse baseResponse, Context context, int i2) {
    }

    public void onClick(View view) {
    }

    public void viewRecycled() {
    }

    public FeedProgressBarHolder(View view, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.viewInterface = baseHolderInterface;
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
    }
}
