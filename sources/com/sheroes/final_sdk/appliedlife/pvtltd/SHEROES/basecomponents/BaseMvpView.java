package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;

public interface BaseMvpView {
    void showError(String str, FeedParticipationEnum feedParticipationEnum);

    void startProgressBar();

    void stopProgressBar();
}
