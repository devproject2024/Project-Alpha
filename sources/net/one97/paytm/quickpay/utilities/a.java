package net.one97.paytm.quickpay.utilities;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f60114a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.quickpay.c.a f60115b;

    /* renamed from: c  reason: collision with root package name */
    private String f60116c;

    /* renamed from: d  reason: collision with root package name */
    private Context f60117d;

    /* renamed from: e  reason: collision with root package name */
    private int f60118e;

    /* renamed from: f  reason: collision with root package name */
    private String f60119f;

    public static a a(net.one97.paytm.quickpay.c.a aVar, String str, int i2) {
        a aVar2 = new a();
        aVar2.f60115b = aVar;
        aVar2.f60116c = str;
        aVar2.f60118e = i2;
        return aVar2;
    }

    public static a a(net.one97.paytm.quickpay.c.a aVar, String str, String str2) {
        a aVar2 = new a();
        aVar2.f60115b = aVar;
        aVar2.f60116c = str;
        aVar2.f60118e = 1;
        aVar2.f60119f = str2;
        return aVar2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f60114a = layoutInflater.inflate(R.layout.confirm_delete_bottom_sheet, (ViewGroup) null);
        this.f60114a.findViewById(R.id.recent_delete_btn).setOnClickListener(this);
        this.f60114a.findViewById(R.id.recent_cancel_btn).setOnClickListener(this);
        int i2 = this.f60118e;
        if (i2 == 1) {
            ((TextView) this.f60114a.findViewById(R.id.delete_message)).setText(Html.fromHtml(this.f60117d.getString(R.string.confirm_delete_msg, new Object[]{this.f60119f, this.f60116c})));
            ((TextView) this.f60114a.findViewById(R.id.txt_header)).setText(Html.fromHtml(this.f60117d.getString(R.string.qp_delete_heading)));
        } else if (i2 == 2) {
            ((TextView) this.f60114a.findViewById(R.id.delete_message)).setText(this.f60117d.getString(R.string.qp_mark_as_paid_body));
            ((TextView) this.f60114a.findViewById(R.id.txt_header)).setText(this.f60117d.getString(R.string.qp_mark_as_paid_heading));
        } else if (i2 == 3) {
            ((TextView) this.f60114a.findViewById(R.id.delete_message)).setText(this.f60117d.getString(R.string.qp_unmark_as_paid_body));
            ((TextView) this.f60114a.findViewById(R.id.txt_header)).setText(this.f60117d.getString(R.string.qp_unmark_as_paid_heading));
        }
        return this.f60114a;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.recent_delete_btn) {
            int i2 = this.f60118e;
            if (i2 == 1) {
                dismiss();
                this.f60115b.a(1);
            } else if (i2 == 2) {
                dismiss();
                this.f60115b.a(5);
            } else if (i2 == 3) {
                dismiss();
                this.f60115b.a(5);
            }
        } else if (id == R.id.recent_cancel_btn) {
            dismiss();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f60117d = context;
    }
}
