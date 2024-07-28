package com.travel.flight.flightorder.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.travel.flight.b.dq;
import com.travel.flight.flightorder.d.b;
import kotlin.g.b.k;

public final class j extends com.travel.flight.flightorder.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24523c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public dq f24524a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f24525b;

    public final void a(b.C0467b bVar) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(dq dqVar) {
        super(dqVar.getRoot());
        k.c(dqVar, "dataBinding");
        this.f24524a = dqVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void a(View view, String str) {
        k.c(view, "view");
        k.c(str, "url");
        b.a aVar = com.paytm.utility.b.b.f43744a;
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        b.a.C0750a a2 = b.a.a(context);
        a2.f43753a = str;
        a2.a((ImageView) null, (com.paytm.utility.b.b.b<?>) new b(view));
    }

    public static final class b implements com.paytm.utility.b.b.b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f24526a;

        public final void onError(Exception exc) {
        }

        b(View view) {
            this.f24526a = view;
        }

        public final /* synthetic */ void onSuccess(Object obj, c cVar) {
            this.f24526a.setBackgroundDrawable((Drawable) obj);
        }
    }
}
