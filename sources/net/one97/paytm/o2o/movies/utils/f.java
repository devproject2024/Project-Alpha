package net.one97.paytm.o2o.movies.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.b;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.d;

public final class f {
    public static Dialog a(Context context, String str, List<String> list, String str2, View.OnClickListener onClickListener) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(b.c(context, R.color.translucent_black)));
        dialog.setContentView(R.layout.common_dialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_dialog_title);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.dialogMessageLL);
        if (!d.a((List) list)) {
            int i2 = 0;
            while (i2 < list.size()) {
                i2++;
                CJRDisclaimerView cJRDisclaimerView = new CJRDisclaimerView(context);
                cJRDisclaimerView.setData(i2, list.get(i2));
                linearLayout.addView(cJRDisclaimerView);
            }
        }
        View findViewById = dialog.findViewById(R.id.fadedView);
        ScrollView scrollView = (ScrollView) dialog.findViewById(R.id.dialogSv);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener(scrollView, findViewById) {
            private final /* synthetic */ ScrollView f$0;
            private final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onScrollChanged() {
                f.a(this.f$0, this.f$1);
            }
        });
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_two);
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
            textView2.setOnClickListener(new View.OnClickListener(dialog, onClickListener, textView2) {
                private final /* synthetic */ Dialog f$0;
                private final /* synthetic */ View.OnClickListener f$1;
                private final /* synthetic */ TextView f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    f.a(this.f$0, this.f$1, this.f$2, view);
                }
            });
        } else {
            textView2.setVisibility(8);
        }
        try {
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                dialog.show();
            } else {
                dialog.show();
            }
        } catch (Exception unused) {
        }
        return dialog;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(ScrollView scrollView, View view) {
        if (scrollView.canScrollVertically(1)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Dialog dialog, View.OnClickListener onClickListener, TextView textView, View view) {
        dialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(textView);
        }
    }
}
