package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;

public interface IPostBottomSheetView extends BaseMvpView {
    void getFeedListSuccess(FeedResponsePojo feedResponsePojo);
}
