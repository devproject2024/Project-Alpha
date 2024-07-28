package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.an;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f62134a;

    /* renamed from: b  reason: collision with root package name */
    private an f62135b;

    /* renamed from: c  reason: collision with root package name */
    private String f62136c;

    /* renamed from: d  reason: collision with root package name */
    private Context f62137d;

    public static a a(an anVar, String str) {
        a aVar = new a();
        aVar.f62135b = anVar;
        aVar.f62136c = str;
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f62134a = layoutInflater.inflate(R.layout.confirm_delete_bottom_sheet, (ViewGroup) null);
        this.f62134a.findViewById(R.id.recent_delete_btn).setOnClickListener(this);
        this.f62134a.findViewById(R.id.recent_cancel_btn).setOnClickListener(this);
        ((TextView) this.f62134a.findViewById(R.id.delete_message)).setText(Html.fromHtml(this.f62137d.getString(R.string.confirm_delete_msg_recharge, new Object[]{this.f62136c})));
        return this.f62134a;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.recent_delete_btn) {
            this.f62135b.a();
        } else if (id == R.id.recent_cancel_btn) {
            dismiss();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f62137d = context;
    }
}
