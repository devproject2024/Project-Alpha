package net.one97.paytm.passbook.subWallet.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.v;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.mapping.c;

public final class a extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    Context f58799a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f58800b = ((LayoutInflater) this.f58799a.getSystemService("layout_inflater"));

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRSubWallet> f58801c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f58802d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f58803e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f58804f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f58805g;

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(Context context, ArrayList<CJRSubWallet> arrayList) {
        this.f58799a = context;
        this.f58801c = arrayList;
    }

    public final int getCount() {
        return this.f58801c.size();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f58800b.inflate(R.layout.pass_subwallet_pager_item, viewGroup, false);
        this.f58802d = (TextView) inflate.findViewById(R.id.tv_issued_by);
        this.f58805g = (ImageView) inflate.findViewById(R.id.iv_issuer_image);
        this.f58803e = (TextView) inflate.findViewById(R.id.tv_amount_balance);
        this.f58804f = (TextView) inflate.findViewById(R.id.tv_request_expires);
        CJRSubWallet cJRSubWallet = this.f58801c.get(i2);
        if (!v.a(cJRSubWallet.getIssuerMetadata())) {
            this.f58802d.setText(cJRSubWallet.getIssuerMetadata());
        }
        if (!TextUtils.isEmpty(cJRSubWallet.getExpiry())) {
            this.f58804f.setText(String.format(this.f58799a.getResources().getString(R.string.food_wallet_expires), new Object[]{net.one97.paytm.passbook.mapping.a.Z(cJRSubWallet.getExpiry())}));
        }
        String format = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(cJRSubWallet.getBalance());
        c.b(this.f58799a.getString(R.string.subwallet_balance) + " " + format, this.f58803e);
        viewGroup.addView(inflate);
        if (cJRSubWallet.getSubWalletType() == 7 && cJRSubWallet.getmIssuerId() != null && cJRSubWallet.getmIssuerId().equalsIgnoreCase(this.f58799a.getString(R.string.pass_gamepind_wallet_issuer_id))) {
            this.f58804f.setVisibility(8);
        }
        return inflate;
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((LinearLayout) obj);
    }
}
