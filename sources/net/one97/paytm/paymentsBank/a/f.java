package net.one97.paytm.paymentsBank.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.model.PBCJRHomePageItem;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private Context f17316a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f17317b;

    /* renamed from: c  reason: collision with root package name */
    private List<PBCJRHomePageItem> f17318c;

    /* renamed from: d  reason: collision with root package name */
    private String f17319d = "";

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public f(Context context, List<PBCJRHomePageItem> list) {
        this.f17316a = context;
        this.f17318c = list;
        this.f17317b = (LayoutInflater) this.f17316a.getSystemService("layout_inflater");
    }

    public final int getCount() {
        return this.f17318c.size();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f17317b.inflate(R.layout.pb_payments_bank_intro_item, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.payments_bank_intro_iv);
        PBCJRHomePageItem pBCJRHomePageItem = this.f17318c.get(i2);
        inflate.setTag(pBCJRHomePageItem);
        try {
            w.a().a(pBCJRHomePageItem.getImageUrl()).a(R.drawable.pb_homepage_default_icon).a(imageView, (e) new e() {
                public final void onError(Exception exc) {
                }

                public final void onSuccess() {
                }
            });
        } catch (Exception unused) {
        }
        viewGroup.addView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        PBCJRHomePageItem pBCJRHomePageItem;
        if (b.c(this.f17316a) && (pBCJRHomePageItem = (PBCJRHomePageItem) view.getTag()) != null) {
            String url = pBCJRHomePageItem.getURL();
            if (TextUtils.isEmpty(url) || !url.startsWith("paytmmp://")) {
                String uRLType = pBCJRHomePageItem.getURLType();
                if (uRLType != null && !TextUtils.isEmpty(uRLType) && uRLType.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED)) {
                    a(pBCJRHomePageItem.getURLType(), pBCJRHomePageItem, "", this.f17316a);
                    return;
                }
                return;
            }
            if (url.contains("manage_debit") || url.contains("request_atm")) {
                c.a(this.f17316a, "bank_saving_account", "personalized_atm_card_strip_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            }
            a(pBCJRHomePageItem.getURLType(), pBCJRHomePageItem, "", this.f17316a);
        }
    }

    private static void a(String str, IJRPaytmDataModel iJRPaytmDataModel, String str2, Context context) {
        if (context != null) {
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("nolink")) {
                o.a().loadPageActivityNavigation(context, str, iJRPaytmDataModel, (String) null, 0, (ArrayList) null, false, str2, (Object) null);
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((LinearLayout) obj);
    }
}
