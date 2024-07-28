package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.n;
import net.one97.paytm.recharge.common.activity.AJRReferApartmentActivity;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class a extends n.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f61002a;

    /* renamed from: b  reason: collision with root package name */
    private Context f61003b;

    public a(View view, Context context) {
        super(view);
        this.f61003b = context;
        this.f61002a = (TextView) view.findViewById(R.id.tv_refer_apartment);
        view.setOnClickListener(this);
    }

    public final void a(CJRAggsItem cJRAggsItem) {
        StringBuilder sb = new StringBuilder(this.f61003b.getResources().getString(R.string.apartment_not_listed));
        int length = sb.length();
        sb.append(" " + this.f61003b.getResources().getString(R.string.refer_apartment));
        SpannableString spannableString = new SpannableString(sb);
        spannableString.setSpan(new ForegroundColorSpan(this.f61003b.getResources().getColor(R.color.color_00b9f5)), length, sb.length(), 0);
        this.f61002a.setText(spannableString);
    }

    public final void onClick(View view) {
        this.f61003b.startActivity(new Intent(this.f61003b, AJRReferApartmentActivity.class));
    }
}
