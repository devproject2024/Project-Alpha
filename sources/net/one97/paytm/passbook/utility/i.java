package net.one97.paytm.passbook.utility;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.utility.v;
import java.util.ArrayList;
import net.one97.paytm.i.f;

public class i extends f {

    /* renamed from: a  reason: collision with root package name */
    public a f59241a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RadioGroup f59242b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f59243c;

    /* renamed from: d  reason: collision with root package name */
    private String f59244d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f59245e;

    /* renamed from: f  reason: collision with root package name */
    private int f59246f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f59247g;

    /* renamed from: h  reason: collision with root package name */
    private BottomSheetBehavior.a f59248h = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                i.this.dismiss();
            }
        }
    };

    public interface a {
        void a(int i2);
    }

    public i() {
    }

    public i(String str, ArrayList<String> arrayList, int i2) {
        this.f59244d = str;
        this.f59245e = arrayList;
        this.f59246f = i2;
    }

    public final void a(a aVar) {
        this.f59241a = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_options_wallet_dialog, (ViewGroup) null);
        dialog.setContentView(inflate);
        this.f59243c = (ImageView) dialog.findViewById(net.one97.paytm.passbook.R.id.iv_close);
        this.f59247g = (TextView) dialog.findViewById(net.one97.paytm.passbook.R.id.title_tv);
        if (!v.a(this.f59244d)) {
            this.f59247g.setText(this.f59244d);
        }
        this.f59242b = (RadioGroup) dialog.findViewById(net.one97.paytm.passbook.R.id.radioGropFilter);
        this.f59243c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.dismiss();
            }
        });
        try {
            ((View) inflate.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
        ArrayList<String> arrayList = this.f59245e;
        if (!(arrayList == null || arrayList.size() == 0)) {
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            for (final int i3 = 0; i3 < this.f59245e.size(); i3++) {
                final RadioButton radioButton = (RadioButton) from.inflate(net.one97.paytm.passbook.R.layout.pass_options_layout, (ViewGroup) null);
                this.f59242b.addView(radioButton);
                radioButton.setText(this.f59245e.get(i3));
                radioButton.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        i.this.f59242b.clearCheck();
                        radioButton.setChecked(true);
                        if (i.this.f59241a != null) {
                            i.this.f59241a.a(i3);
                        }
                        i.this.dismiss();
                    }
                });
            }
        }
        this.f59242b.clearCheck();
        RadioButton radioButton2 = (RadioButton) this.f59242b.getChildAt(this.f59246f);
        radioButton2.setChecked(true);
        radioButton2.setTypeface((Typeface) null, 1);
    }
}
