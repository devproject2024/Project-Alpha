package net.one97.paytm.fastag.ui.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.google.android.material.bottomsheet.b;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.fastag.f.h;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f13848a;

    /* renamed from: b  reason: collision with root package name */
    private String f13849b;

    /* renamed from: c  reason: collision with root package name */
    private String f13850c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f13851d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13852e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13853f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13854g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13855h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f13856i;
    private BottomSheetBehavior.a j = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                c.this.dismiss();
            }
        }
    };

    public c() {
    }

    public c(String str, String str2) {
        this.f13849b = str;
        this.f13850c = str2;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setContentView(View.inflate(getContext(), net.one97.paytm.fastag.R.layout.dialog_view_breakup_fastag_ft, (ViewGroup) null));
        this.f13852e = (TextView) dialog.findViewById(net.one97.paytm.fastag.R.id.tag_price_tv);
        this.f13853f = (TextView) dialog.findViewById(net.one97.paytm.fastag.R.id.min_balance_tv);
        this.f13854g = (TextView) dialog.findViewById(net.one97.paytm.fastag.R.id.refundable_amount_tv);
        this.f13851d = (ImageView) dialog.findViewById(net.one97.paytm.fastag.R.id.iv_close);
        this.f13855h = (TextView) dialog.findViewById(net.one97.paytm.fastag.R.id.actual_amount_tv);
        this.f13856i = (TextView) dialog.findViewById(net.one97.paytm.fastag.R.id.discounted_amount_tv);
        this.f13849b = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.f13849b));
        this.f13850c = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.f13850c));
        h.b(String.format(getString(net.one97.paytm.fastag.R.string.rs_str), new Object[]{this.f13849b}), this.f13855h);
        h.b(String.format(getString(net.one97.paytm.fastag.R.string.rs_str), new Object[]{this.f13850c}), this.f13856i);
        TextView textView = this.f13855h;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.f13851d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.isAdded()) {
                    c.this.dismiss();
                }
            }
        });
        Map<String, String> map = this.f13848a;
        if (map != null && map.size() > 0) {
            if (this.f13848a.containsKey("tag_price")) {
                h.b(String.format(getString(net.one97.paytm.fastag.R.string.rs_str), new Object[]{this.f13848a.get("tag_price")}), this.f13852e);
            } else if (this.f13848a.containsKey("security")) {
                h.b(String.format(getString(net.one97.paytm.fastag.R.string.rs_str), new Object[]{this.f13848a.get("security")}), this.f13854g);
            } else if (this.f13848a.containsKey("threshold")) {
                h.b(String.format(getString(net.one97.paytm.fastag.R.string.rs_str), new Object[]{this.f13848a.get("threshold")}), this.f13853f);
            }
        }
    }
}
