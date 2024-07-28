package com.paytmmall.clpartifact.listeners;

import android.app.Activity;

public interface ITimerListener {
    Activity getView();

    void onTick();
}
