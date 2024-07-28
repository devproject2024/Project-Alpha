package com.travel.bus.busticket.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f22124a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledExecutorService f22125b;

    /* renamed from: c  reason: collision with root package name */
    private int f22126c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f22127d;

    public e(Context context, ImageView imageView) {
        this.f22124a = context;
        this.f22127d = imageView;
    }

    public final void a() {
        if (this.f22125b == null) {
            this.f22125b = Executors.newSingleThreadScheduledExecutor();
        }
        if (this.f22127d != null) {
            this.f22126c = 0;
            this.f22125b.scheduleAtFixedRate(new Runnable() {
                public final void run() {
                    e.this.c();
                }
            }, 300, 300, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                e.this.d();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            if (this.f22124a != null) {
                if (this.f22126c % 3 == 0) {
                    ResourceUtils.loadBusImagesFromCDN(this.f22127d, "first_selected_seat_loader.png", false, false, n.a.V1);
                } else if (this.f22126c % 3 == 1) {
                    ResourceUtils.loadBusImagesFromCDN(this.f22127d, "second_selected_seat_loader.png", false, false, n.a.V1);
                } else {
                    ResourceUtils.loadBusImagesFromCDN(this.f22127d, "third_selected_seat_loader.png", false, false, n.a.V1);
                }
            }
        } catch (Exception unused) {
        }
        this.f22126c++;
    }

    public final void b() {
        ScheduledExecutorService scheduledExecutorService = this.f22125b;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.f22125b.shutdownNow();
        }
    }
}
