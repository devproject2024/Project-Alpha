package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.play.core.e.p;

final class b extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f36899a;

    public final void onReceiveResult(int i2, Bundle bundle) {
        p pVar;
        int i3 = 1;
        if (i2 == 1) {
            pVar = this.f36899a;
            i3 = -1;
        } else if (i2 != 2) {
            pVar = this.f36899a;
        } else {
            pVar = this.f36899a;
            i3 = 0;
        }
        pVar.b(Integer.valueOf(i3));
    }
}
