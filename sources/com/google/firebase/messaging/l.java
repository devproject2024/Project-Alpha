package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Callable;

final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final k f39018a;

    l(k kVar) {
        this.f39018a = kVar;
    }

    public final Object call() {
        k kVar = this.f39018a;
        String valueOf = String.valueOf(kVar.f39015a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        byte[] a2 = kVar.a();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(kVar.f39015a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(kVar.f39015a);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }
}
