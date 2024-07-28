package com.paytm.android.chat.data.repository.datastores;

import com.google.firebase.iid.w;
import io.reactivex.rxjava3.a.y;

public interface IPCFirebaseInstanceIdWrapper {
    y<w> getInstanceId();
}
