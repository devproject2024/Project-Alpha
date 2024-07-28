package com.travel.train.viewholder;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.j.o;
import java.util.HashMap;
import net.one97.paytm.common.utility.d;

public final class u extends RecyclerView.v implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f28245a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f28246b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f28247c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f28248d;

    /* renamed from: e  reason: collision with root package name */
    public final View f28249e;

    /* renamed from: f  reason: collision with root package name */
    public final View f28250f;

    /* renamed from: g  reason: collision with root package name */
    public Context f28251g = this.itemView.getContext();

    /* renamed from: h  reason: collision with root package name */
    private TextView f28252h;

    public u(View view) {
        super(view);
        this.f28245a = (EditText) view.findViewById(R.id.mobile_edit);
        this.f28245a.setOnFocusChangeListener(this);
        this.f28246b = (EditText) view.findViewById(R.id.email_edit);
        this.f28246b.setOnFocusChangeListener(this);
        this.f28247c = (TextView) view.findViewById(R.id.mobile_error);
        this.f28248d = (TextView) view.findViewById(R.id.email_error);
        this.f28249e = view.findViewById(R.id.mobile_below_view);
        this.f28250f = view.findViewById(R.id.email_id_view);
        this.f28252h = (TextView) view.findViewById(R.id.contact_info_text);
        this.f28245a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() > 0) {
                    u.this.f28247c.setVisibility(8);
                    u.this.f28249e.setBackgroundColor(u.this.f28251g.getResources().getColor(R.color.payment_success_line_grey));
                }
            }
        });
        this.f28246b.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() > 0) {
                    u.this.f28248d.setVisibility(8);
                    u.this.f28250f.setBackgroundColor(u.this.f28251g.getResources().getColor(R.color.payment_success_line_grey));
                }
            }
        });
        if (g.f27551a != null && !TextUtils.isEmpty(g.f27551a.getContactInfoText())) {
            this.f28252h.setText(g.f27551a.getContactInfoText());
        }
        if (b.l(this.f28251g) != null) {
            this.f28245a.setText(b.l(this.f28251g));
            this.f28245a.clearFocus();
        }
        if (b.m(this.f28251g) != null && !TextUtils.isEmpty(b.m(this.f28251g))) {
            this.f28246b.setText(b.m(this.f28251g));
            this.f28246b.clearFocus();
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            int id = view.getId();
            if (id == R.id.email_edit) {
                HashMap hashMap = new HashMap();
                hashMap.put(d.q, this.f28251g.getString(R.string.email));
                o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_field_clicked", "/trains/traveller-details", this.f28251g, hashMap);
            } else if (id == R.id.mobile_edit) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(d.q, this.f28251g.getString(R.string.mobile));
                o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_field_clicked", "/trains/traveller-details", this.f28251g, hashMap2);
            }
        }
    }
}
