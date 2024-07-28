package com.travel.citybus.best.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.h;
import com.travel.citybus.R;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23053a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str, String str2) {
            k.c(context, "context");
            k.c(str, "title");
            k.c(str2, "message");
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                h hVar = new h(context);
                if (TextUtils.isEmpty(str)) {
                    str = context.getString(R.string.brts_alert);
                }
                k.a((Object) str, "if (TextUtils.isEmpty(ti…ng.brts_alert) else title");
                hVar.setTitle(str);
                hVar.a(str2);
                hVar.a(-3, context.getResources().getString(R.string.brts_ok), new C0445a(hVar));
                hVar.show();
            }
        }

        /* renamed from: com.travel.citybus.best.e.d$a$a  reason: collision with other inner class name */
        static final class C0445a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f23054a;

            C0445a(h hVar) {
                this.f23054a = hVar;
            }

            public final void onClick(View view) {
                this.f23054a.cancel();
            }
        }
    }
}
