package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.common.e.k;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class h extends n.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f61058a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f61059b;

    /* renamed from: c  reason: collision with root package name */
    private k f61060c;

    /* renamed from: d  reason: collision with root package name */
    private Context f61061d;

    public h(View view, k kVar, Context context) {
        super(view);
        this.f61060c = kVar;
        this.f61061d = context;
        this.f61058a = (TextView) view.findViewById(R.id.txt_agency_name);
        this.f61059b = (TextView) view.findViewById(R.id.txt_agency_address);
        view.setOnClickListener(this);
    }

    public final void a(CJRAggsItem cJRAggsItem) {
        if (cJRAggsItem != null) {
            String gasAgencyName = cJRAggsItem.getGasAgencyName();
            String displayValue = cJRAggsItem.getDisplayValue();
            String string = this.f61058a.getContext().getString(R.string.lpg_agency_code_with_bracket, new Object[]{displayValue});
            String string2 = this.f61058a.getContext().getString(R.string.lpg_agency_name_with_code, new Object[]{gasAgencyName, string});
            SpannableString spannableString = new SpannableString(string2);
            int indexOf = string2.indexOf(string);
            spannableString.setSpan(new StyleSpan(0), indexOf, string.length() + indexOf, 33);
            this.f61058a.setText(spannableString);
            this.f61059b.setText(cJRAggsItem.getGasAgencyAddress());
            cJRAggsItem.setTempDisplayValue(this.f61058a.getText().toString());
            String gasAgencyName2 = cJRAggsItem.getGasAgencyName();
            String value = cJRAggsItem.getValue();
            String string3 = this.f61061d.getString(R.string.lpg_agency_code_with_bracket, new Object[]{value});
            cJRAggsItem.setTempFileterValue(this.f61061d.getString(R.string.lpg_agency_name_with_code, new Object[]{gasAgencyName2, string3}));
        }
    }

    public final void onClick(View view) {
        this.f61060c.c(getAdapterPosition());
    }
}
