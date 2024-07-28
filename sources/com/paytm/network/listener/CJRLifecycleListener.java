package com.paytm.network.listener;

import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.paytm.network.b.d;
import com.paytm.utility.q;

public class CJRLifecycleListener implements p {
    @aa(a = k.a.ON_START)
    private void onAppForegrounded() {
        d.a();
        q.d("App in foreground");
    }
}
