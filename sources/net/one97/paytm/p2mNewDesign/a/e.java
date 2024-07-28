package net.one97.paytm.p2mNewDesign.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.List;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.wallet.R;

public final class e extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.PaymentOptions.b.a f13173a;

    /* renamed from: b  reason: collision with root package name */
    a f13174b;

    /* renamed from: c  reason: collision with root package name */
    private List<PayChannelOptionsV2> f13175c;

    /* renamed from: d  reason: collision with root package name */
    private Context f13176d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f13177e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f13178f;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final void onClick(View view) {
    }

    public e(List<PayChannelOptionsV2> list, Context context, net.one97.paytm.p2mNewDesign.PaymentOptions.b.a aVar, int i2) {
        this.f13175c = list;
        this.f13176d = context;
        this.f13173a = aVar;
        this.f13177e = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f13178f = i2;
    }

    public final int getCount() {
        return this.f13175c.size();
    }

    /* renamed from: a */
    public final PayChannelOptionsV2 getItem(int i2) {
        return this.f13175c.get(i2);
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f13182a;

        /* renamed from: b  reason: collision with root package name */
        RadioButton f13183b;

        public a() {
        }
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        final PayChannelOptionsV2 a2 = getItem(i2);
        this.f13174b = new a();
        if (view == null) {
            view = this.f13177e.inflate(R.layout.row_selectbanks_layout, (ViewGroup) null);
            this.f13174b.f13182a = (TextView) view.findViewById(R.id.selectbank_txt_bankname);
            this.f13174b.f13183b = (RadioButton) view.findViewById(R.id.selectbank_radio);
            view.setTag(this.f13174b);
        } else {
            this.f13174b = (a) view.getTag();
        }
        if (this.f13178f == i2) {
            a2.setSelected(Boolean.TRUE);
            this.f13174b.f13183b.setChecked(true);
        } else {
            a2.setSelected(Boolean.FALSE);
            this.f13174b.f13183b.setChecked(false);
        }
        this.f13174b.f13182a.setText(this.f13175c.get(i2).getChannelCode());
        this.f13174b.f13183b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.isPressed()) {
                    e.this.f13174b.f13183b.setChecked(z);
                    e.this.f13173a.a(a2, i2);
                }
            }
        });
        return view;
    }
}
