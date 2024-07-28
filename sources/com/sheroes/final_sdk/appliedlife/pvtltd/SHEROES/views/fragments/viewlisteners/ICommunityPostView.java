package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;

public interface ICommunityPostView extends BaseMvpView {
    void finishActivity();

    void linkRenderResponse(LinkRenderResponse linkRenderResponse);

    void onPostSend(FeedDetail feedDetail);
}
