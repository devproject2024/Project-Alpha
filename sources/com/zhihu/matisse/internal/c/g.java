package com.zhihu.matisse.internal.c;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

public final class g implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a  reason: collision with root package name */
    private MediaScannerConnection f45747a;

    /* renamed from: b  reason: collision with root package name */
    private String f45748b;

    /* renamed from: c  reason: collision with root package name */
    private a f45749c;

    public interface a {
        void a();
    }

    public g(Context context, String str, a aVar) {
        this.f45748b = str;
        this.f45749c = aVar;
        this.f45747a = new MediaScannerConnection(context, this);
        this.f45747a.connect();
    }

    public final void onMediaScannerConnected() {
        this.f45747a.scanFile(this.f45748b, (String) null);
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f45747a.disconnect();
        a aVar = this.f45749c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
