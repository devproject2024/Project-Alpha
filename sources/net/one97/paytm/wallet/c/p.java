package net.one97.paytm.wallet.c;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.i.g;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ao;

public class p extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f70103a;

    /* renamed from: b  reason: collision with root package name */
    private String f70104b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f70105c;

    /* renamed from: d  reason: collision with root package name */
    private Button f70106d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f70107e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f70108f;

    /* renamed from: g  reason: collision with root package name */
    private int f70109g = -1;

    public p() {
    }

    public p(String str, String str2, View.OnClickListener onClickListener) {
        this.f70103a = str;
        this.f70109g = R.drawable.group_3_copy;
        this.f70104b = str2;
        this.f70107e = onClickListener;
        ao.a(p.class, "consructor");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.alert_dialog_send_to_bank_success, viewGroup);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.CustomPincodeDialogAnimation;
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f70108f = (ImageView) inflate.findViewById(R.id.title_dialog_iv);
        this.f70105c = (RoboTextView) inflate.findViewById(R.id.txt3);
        this.f70106d = (Button) inflate.findViewById(R.id.btn_send_to_bank);
        this.f70105c.setText(this.f70103a);
        int i2 = this.f70109g;
        if (i2 > 0) {
            this.f70108f.setImageResource(i2);
        }
        if (!TextUtils.isEmpty(this.f70104b)) {
            this.f70106d.setText(this.f70104b);
        }
        View.OnClickListener onClickListener = this.f70107e;
        if (onClickListener != null) {
            this.f70106d.setOnClickListener(onClickListener);
        } else {
            this.f70106d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    p.this.getDialog().dismiss();
                }
            });
        }
        return inflate;
    }
}
