package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.content.Intent;

public interface PhoenixActivityResultProvider {
    Object onActivityResult(Context context, int i2, int i3, Intent intent);
}
