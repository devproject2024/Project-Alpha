package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragmentlistner;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;

public interface FragmentIntractionWithActivityListner {
    void onShowErrorDialog(String str, FeedParticipationEnum feedParticipationEnum);

    void onSuccessResult(String str, FeedDetail feedDetail);
}
