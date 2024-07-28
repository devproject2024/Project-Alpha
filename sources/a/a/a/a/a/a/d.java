package a.a.a.a.a.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f671a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f672b;

    /* renamed from: c  reason: collision with root package name */
    private final a f673c;

    /* renamed from: d  reason: collision with root package name */
    private final c f674d;

    /* renamed from: e  reason: collision with root package name */
    private float f675e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f671a = context;
        this.f672b = (AudioManager) context.getSystemService(H5ResourceHandlerUtil.AUDIO);
        this.f673c = aVar;
        this.f674d = cVar;
    }

    private float b() {
        int streamVolume = this.f672b.getStreamVolume(3);
        int streamMaxVolume = this.f672b.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f2 = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void c() {
        this.f674d.a(this.f675e);
    }

    public final void a() {
        this.f675e = b();
        c();
        this.f671a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float b2 = b();
        if (b2 != this.f675e) {
            this.f675e = b2;
            c();
        }
    }
}
