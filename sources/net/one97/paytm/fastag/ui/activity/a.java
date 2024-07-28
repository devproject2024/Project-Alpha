package net.one97.paytm.fastag.ui.activity;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.model.CJRAddress;

public final class a extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    C0189a f13833a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13834b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRAddress> f13835c;

    /* renamed from: net.one97.paytm.fastag.ui.activity.a$a  reason: collision with other inner class name */
    public interface C0189a {
        void a(int i2);

        void a(CJRAddress cJRAddress);
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final CharSequence getPageTitle(int i2) {
        return null;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(Context context, ArrayList<CJRAddress> arrayList, C0189a aVar) {
        this.f13834b = context;
        this.f13835c = arrayList;
        this.f13833a = aVar;
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i2) {
        final CJRAddress cJRAddress = this.f13835c.get(i2);
        if (cJRAddress.getName() == null) {
            return "";
        }
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f13834b).inflate(R.layout.address_item_view_ft, viewGroup, false);
        CheckBox checkBox = (CheckBox) viewGroup2.findViewById(R.id.address_select_radio_button_item_imageview);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.tvName);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.cart_text_address);
        TextView textView3 = (TextView) viewGroup2.findViewById(R.id.cart_text_mobile_number);
        TextView textView4 = (TextView) viewGroup2.findViewById(R.id.tv_edit);
        if (cJRAddress.getPriority() == 1) {
            checkBox.setChecked(true);
            cJRAddress.setChecked(true);
        }
        textView.setText(Html.fromHtml(cJRAddress.getName().trim()));
        textView2.setText(cJRAddress.getAddress1() + " " + cJRAddress.getAddress2() + " " + cJRAddress.getState() + " " + cJRAddress.getCity() + " - " + cJRAddress.getPin());
        StringBuilder sb = new StringBuilder("+91 ");
        sb.append(cJRAddress.getMobile());
        textView3.setText(sb.toString());
        viewGroup.addView(viewGroup2);
        textView4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f13833a.a(cJRAddress);
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRAddress cJRAddress = cJRAddress;
                if (cJRAddress != null) {
                    cJRAddress.setChecked(true);
                    cJRAddress.setPriority(1);
                    a.this.f13833a.a(i2);
                    a.this.a(i2);
                    a.this.notifyDataSetChanged();
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        return viewGroup2;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.f13835c.size();
    }

    public final float getPageWidth(int i2) {
        ArrayList<CJRAddress> arrayList = this.f13835c;
        return (arrayList == null || arrayList.size() <= 1) ? 1.0f : 0.9f;
    }

    public final void a(int i2) {
        b(i2);
        notifyDataSetChanged();
    }

    private void b(int i2) {
        for (int i3 = 0; i3 < this.f13835c.size(); i3++) {
            if (i3 == i2) {
                this.f13835c.get(i3).setChecked(true);
                this.f13835c.get(i3).setPriority(1);
            } else {
                this.f13835c.get(i3).setChecked(false);
                this.f13835c.get(i3).setPriority(0);
            }
        }
    }
}
