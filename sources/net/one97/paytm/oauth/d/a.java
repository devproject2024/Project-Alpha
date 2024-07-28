package net.one97.paytm.oauth.d;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.one97.paytm.oauth.R;

public final class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f52596a = ((TextView) findViewById(R.id.w_custom_dialog_title));

    /* renamed from: b  reason: collision with root package name */
    public Context f52597b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52598c = ((TextView) findViewById(R.id.w_custom_dialog_title_with_drawable));

    /* renamed from: d  reason: collision with root package name */
    private Button f52599d = ((Button) findViewById(R.id.w_custom_dialog_btn_positive));

    /* renamed from: e  reason: collision with root package name */
    private TextView f52600e = ((TextView) findViewById(R.id.w_custom_dialog_btn_negative));

    /* renamed from: f  reason: collision with root package name */
    private TextView f52601f = ((TextView) findViewById(R.id.w_custom_dialog_message));

    public a(Context context) {
        super(context, 16973936);
        this.f52597b = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.auth_custom_dialog);
    }

    public final void setTitle(CharSequence charSequence) {
        this.f52598c.setVisibility(8);
        this.f52596a.setVisibility(0);
        if (TextUtils.isEmpty(charSequence)) {
            this.f52596a.setText(this.f52597b.getString(R.string.alert));
        } else {
            this.f52596a.setText(charSequence);
        }
    }

    public final void a(CharSequence charSequence) {
        this.f52601f.setText(charSequence);
    }

    public final void a(int i2, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (i2 == -1) {
            this.f52599d.setText(charSequence);
            this.f52599d.setOnClickListener(onClickListener);
        } else if (i2 == -2) {
            this.f52600e.setVisibility(0);
            this.f52600e.setText(charSequence);
            this.f52600e.setOnClickListener(onClickListener);
        } else if (i2 == -3) {
            this.f52600e.setVisibility(8);
            this.f52599d.setText(charSequence);
            this.f52599d.setOnClickListener(onClickListener);
        }
    }

    public static void a(Context context, String str, View.OnClickListener onClickListener) {
        a aVar = new a(context);
        aVar.setTitle((CharSequence) null);
        aVar.a(str);
        aVar.setCancelable(false);
        aVar.a(-1, (CharSequence) context.getString(R.string.ok), (View.OnClickListener) new View.OnClickListener(onClickListener, aVar) {
            private final /* synthetic */ View.OnClickListener f$0;
            private final /* synthetic */ a f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                a.a(this.f$0, this.f$1, view);
            }
        });
        aVar.show();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View.OnClickListener onClickListener, a aVar, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        aVar.dismiss();
    }
}
