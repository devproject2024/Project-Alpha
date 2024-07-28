package net.one97.paytm.feed.utility;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.core.content.b;
import net.one97.paytm.feed.R;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f35388a = new e();

    private e() {
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f35389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f35390b;

        public a(Dialog dialog, View.OnClickListener onClickListener) {
            this.f35389a = dialog;
            this.f35390b = onClickListener;
        }

        public final void onClick(View view) {
            this.f35389a.dismiss();
            this.f35390b.onClick(view);
        }
    }

    public static Dialog a(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(b.c(context, R.color.feed_transparent)));
        }
        dialog.setContentView(R.layout.dialog_with_title_cta);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.show();
        return dialog;
    }
}
