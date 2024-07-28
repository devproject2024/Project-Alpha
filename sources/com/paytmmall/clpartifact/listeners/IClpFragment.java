package com.paytmmall.clpartifact.listeners;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public interface IClpFragment {
    Fragment getCLPFragment(IClpFragment iClpFragment);

    Object getWXSDKInstance();

    boolean isRendered();

    void onActivityResult(int i2, int i3, Intent intent);

    void setArguments(Bundle bundle);
}
