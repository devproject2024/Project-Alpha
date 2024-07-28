package com.paytmmall.artifact.d.a;

import android.widget.ImageView;
import com.paytmmall.artifact.R;
import com.squareup.picasso.e;
import com.squareup.picasso.t;
import com.squareup.picasso.w;

public final class c {
    public static void a(String str, ImageView imageView) {
        a(str, imageView, R.drawable.mall_picasso_default_placeholder);
    }

    private static void a(String str, ImageView imageView, int i2) {
        a(str, imageView, i2, R.drawable.mall_picasso_default_placeholder);
    }

    private static void a(String str, ImageView imageView, int i2, int i3) {
        a(str, imageView, i2, i3, (b) null, (a) null);
    }

    public static void a(String str, ImageView imageView, int i2, int i3, b bVar, a aVar) {
        a(str, imageView, i2, i3, bVar, aVar, t.OFFLINE);
    }

    /* access modifiers changed from: private */
    public static void a(String str, ImageView imageView, int i2, int i3, final b bVar, final a aVar, final t tVar) {
        if (t.OFFLINE.equals(tVar)) {
            a(str, imageView, bVar, (a) new a(str, imageView, i2, i3, bVar, aVar) {
                private final /* synthetic */ String f$0;
                private final /* synthetic */ ImageView f$1;
                private final /* synthetic */ int f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ b f$4;
                private final /* synthetic */ a f$5;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void onError() {
                    c.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, t.NO_CACHE);
                }
            });
        } else {
            w.a().a(str).a(imageView.getContext().getResources().getDrawable(i2)).b(imageView.getContext().getResources().getDrawable(i2)).a(tVar).a(imageView, (e) new e() {
                public final void onSuccess() {
                    c.a(bVar, tVar);
                }

                public final void onError(Exception exc) {
                    c.a(aVar, tVar);
                }
            });
        }
    }

    private static void a(String str, ImageView imageView, final b bVar, final a aVar) {
        w.a().a(str).a(imageView, (e) new e() {
            public final void onSuccess() {
                c.a(bVar, t.OFFLINE);
            }

            public final void onError(Exception exc) {
                c.a(aVar, t.OFFLINE);
            }
        });
    }

    static /* synthetic */ void a(b bVar, t tVar) {
        new StringBuilder("Image Loaded, Network Policy -> ").append(tVar);
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    static /* synthetic */ void a(a aVar, t tVar) {
        new StringBuilder("Image loading failed, Network Policy -> ").append(tVar);
        if (aVar != null) {
            aVar.onError();
        }
    }
}
