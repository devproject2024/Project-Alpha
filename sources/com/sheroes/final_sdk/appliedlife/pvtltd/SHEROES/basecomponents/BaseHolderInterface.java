package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.view.View;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;

public interface BaseHolderInterface<T extends BaseResponse> {
    void dataOperationOnClick(BaseResponse baseResponse);

    void handleOnClick(BaseResponse baseResponse, View view);

    void userCommentLikeRequest(BaseResponse baseResponse, int i2, int i3);
}
