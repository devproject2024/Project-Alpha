package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterItem;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;

public final class VoucherRadioBox extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    b<? super Integer, x> f21041a;

    /* renamed from: b  reason: collision with root package name */
    private VoucherFilterItem f21042b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f21043c;

    private View a(int i2) {
        if (this.f21043c == null) {
            this.f21043c = new HashMap();
        }
        View view = (View) this.f21043c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f21043c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherRadioBox(Context context, VoucherFilterItem voucherFilterItem) {
        super(context);
        k.c(context, "context");
        k.c(voucherFilterItem, "item");
        this.f21042b = voucherFilterItem;
        View inflate = LayoutInflater.from(context).inflate(R.layout.voucher_filter_status_item, (ViewGroup) null, false);
        String displayName = voucherFilterItem.getDisplayName();
        k.a((Object) displayName, "item.displayName");
        if (!(displayName.length() == 0)) {
            k.a((Object) inflate, "inflate");
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            k.a((Object) textView, "inflate.title");
            d.a aVar = d.f20859a;
            String displayName2 = voucherFilterItem.getDisplayName();
            k.a((Object) displayName2, "item.displayName");
            k.c(displayName2, "string");
            if (!(displayName2.length() == 0)) {
                StringBuilder sb = new StringBuilder();
                String substring = displayName2.substring(0, 1);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    String upperCase = substring.toUpperCase();
                    k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                    sb.append(upperCase);
                    String substring2 = displayName2.substring(1, displayName2.length());
                    k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring2);
                    displayName2 = sb.toString();
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            textView.setText(displayName2);
        }
        k.a((Object) inflate, "inflate");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.radiobutton);
        k.a((Object) imageView, "inflate.radiobutton");
        imageView.setSelected(voucherFilterItem.isSelected());
        inflate.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ VoucherRadioBox f21044a;

            {
                this.f21044a = r1;
            }

            public final void onClick(View view) {
                b<Integer, x> mLister = this.f21044a.getMLister();
                if (mLister != null) {
                    mLister.invoke(Integer.valueOf(this.f21044a.getId()));
                }
            }
        });
        addView(inflate);
    }

    public final b<Integer, x> getMLister() {
        return this.f21041a;
    }

    public final void setMLister(b<? super Integer, x> bVar) {
        this.f21041a = bVar;
    }

    public final VoucherFilterItem getModel() {
        return this.f21042b;
    }

    public final void setModel(VoucherFilterItem voucherFilterItem) {
        k.c(voucherFilterItem, "<set-?>");
        this.f21042b = voucherFilterItem;
    }

    public final void a(boolean z) {
        ImageView imageView = (ImageView) a(R.id.radiobutton);
        k.a((Object) imageView, "radiobutton");
        imageView.setSelected(z);
        this.f21042b.setSelected(false);
        invalidate();
    }
}
