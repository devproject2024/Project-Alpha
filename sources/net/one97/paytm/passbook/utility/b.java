package net.one97.paytm.passbook.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.b;

public class b extends h implements net.one97.paytm.passbook.b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f59228a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f59229b;

    public View a(int i2) {
        if (this.f59229b == null) {
            this.f59229b = new HashMap();
        }
        View view = (View) this.f59229b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f59229b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void d() {
        HashMap hashMap = this.f59229b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private static AlertDialog a(Context context, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        k.c(context, "context");
        k.c(onClickListener, "positiveClickListener");
        return b.a.a(context, alertDialog, onClickListener, onClickListener2);
    }

    public static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
        k.c(lottieAnimationView, "walletLoader");
        b.a.a(lottieAnimationView, bool);
    }

    public static boolean a(LottieAnimationView lottieAnimationView) {
        k.c(lottieAnimationView, "loader");
        return b.a.a(lottieAnimationView);
    }

    public final void a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        k.c(onClickListener, "positiveClickListener");
        Context context = getContext();
        if (context != null) {
            k.a((Object) context, "it");
            a(context, this.f59228a, onClickListener, onClickListener2);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f59228a = null;
        d();
    }
}
