package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.clpCommon.View;

public interface IClickListener {
    void onLessItemCliked(Integer num, View view);

    void onMoreItemCliked(Integer num, View view);
}
