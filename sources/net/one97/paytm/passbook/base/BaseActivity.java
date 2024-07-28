package net.one97.paytm.passbook.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.b;
import net.one97.paytm.passbook.d;

public class BaseActivity extends PaytmActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f57092a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f57093b;

    public View a(int i2) {
        if (this.f57093b == null) {
            this.f57093b = new HashMap();
        }
        View view = (View) this.f57093b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57093b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
        k.c(lottieAnimationView, "walletLoader");
        b.a.a(lottieAnimationView, bool);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        k.c(onClickListener, "positiveClickListener");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), onClickListener);
        builder.show();
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        if (d.a()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(d.b().a(context));
        a.a((Context) this);
    }

    public final void a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        k.c(onClickListener, "positiveClickListener");
        Context context = this;
        AlertDialog alertDialog = this.f57092a;
        k.c(context, "context");
        k.c(onClickListener, "positiveClickListener");
        this.f57092a = b.a.a(context, alertDialog, onClickListener, onClickListener2);
    }
}
