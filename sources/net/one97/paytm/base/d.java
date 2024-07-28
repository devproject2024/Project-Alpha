package net.one97.paytm.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.y;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.x;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.R;

public interface d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f49504d = a.f49505a;

    public static final class b {
        public static void a(LottieAnimationView lottieAnimationView) {
            k.c(lottieAnimationView, "loader");
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        }

        public static void b(LottieAnimationView lottieAnimationView) {
            k.c(lottieAnimationView, "loader");
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        }

        public static void a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
            k.c(context, "context");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(str);
            builder.setMessage(str2);
            if (str3 != null) {
                builder.setPositiveButton(str3, onClickListener);
            }
            builder.setNegativeButton(context.getString(R.string.cancel), a.f49510a);
            builder.show();
        }

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public static final a f49510a = new a();

            a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }

        public static void a(String str, kotlin.g.a.b<? super String, x> bVar) {
            k.c(bVar, H5Event.TYPE_CALL_BACK);
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                bVar.invoke(str);
            }
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f49505a = new a();

        private a() {
        }

        public final y<f> a(Context context, net.one97.paytm.network.d dVar) {
            k.c(context, "context");
            k.c(dVar, "request");
            x.e eVar = new x.e();
            eVar.element = null;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getString(R.string.no_connection));
            builder.setMessage(context.getString(R.string.no_internet));
            builder.setPositiveButton(context.getString(R.string.network_retry_yes), new C0881a(this, context, eVar, dVar));
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null && !activity.isFinishing()) {
                builder.show();
            }
            return (y) eVar.element;
        }

        /* renamed from: net.one97.paytm.base.d$a$a  reason: collision with other inner class name */
        static final class C0881a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f49506a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f49507b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.e f49508c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.network.d f49509d;

            C0881a(a aVar, Context context, x.e eVar, net.one97.paytm.network.d dVar) {
                this.f49506a = aVar;
                this.f49507b = context;
                this.f49508c = eVar;
                this.f49509d = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(this.f49507b)) {
                    this.f49508c.element = this.f49509d.c();
                    return;
                }
                this.f49506a.a(this.f49507b, this.f49509d);
            }
        }
    }
}
