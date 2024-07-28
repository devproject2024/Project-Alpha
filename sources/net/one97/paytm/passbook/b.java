package net.one97.paytm.passbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;

public interface b {

    public static final class a {
        public static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
            k.c(lottieAnimationView, "walletLoader");
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                lottieAnimationView.setVisibility(0);
                net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
                return;
            }
            lottieAnimationView.setVisibility(8);
            net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
        }

        public static AlertDialog a(Context context, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            k.c(context, "context");
            k.c(onClickListener, "positiveClickListener");
            if (alertDialog != null && alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getString(R.string.no_connection));
            builder.setMessage(context.getString(R.string.no_internet));
            builder.setPositiveButton(context.getString(R.string.network_retry_yes), onClickListener);
            if (onClickListener2 != null) {
                builder.setNegativeButton(context.getString(R.string.cancel), onClickListener2);
                builder.setCancelable(false);
            }
            AlertDialog create = builder.create();
            if (create != null) {
                create.show();
            }
            return create;
        }

        public static boolean a(LottieAnimationView lottieAnimationView) {
            k.c(lottieAnimationView, "loader");
            return lottieAnimationView.isShown();
        }
    }
}
