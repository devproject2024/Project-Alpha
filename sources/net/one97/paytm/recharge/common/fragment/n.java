package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.paytm.ads.PaytmAdView;
import com.paytm.utility.q;
import com.paytm.utility.t;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class n extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61333a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f61334b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f61335c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("layoutId")) : null;
        if (valueOf == null) {
            k.a();
        }
        return layoutInflater.inflate(valueOf.intValue(), viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        PaytmAdView paytmAdView = (PaytmAdView) view.findViewById(R.id.paytmAdView);
        Bundle arguments = getArguments();
        String str2 = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("item") : null;
        if (!(serializable instanceof CJRHomePageItem)) {
            serializable = null;
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) serializable;
        if (cJRHomePageItem != null) {
            Bundle arguments2 = getArguments();
            int i2 = arguments2 != null ? arguments2.getInt(CLPConstants.ARGUMENT_KEY_POSITION) : -1;
            Bundle arguments3 = getArguments();
            boolean z = arguments3 != null ? arguments3.getBoolean("roundedCorner") : false;
            Bundle arguments4 = getArguments();
            if (arguments4 == null || (str = arguments4.getString("gaScreenName")) == null) {
                str = "";
            }
            this.f61334b = str;
            if (cJRHomePageItem.getDisplaymetadata() != null) {
                CJRHomePageItem.Displaymetadata displaymetadata = cJRHomePageItem.getDisplaymetadata();
                k.a((Object) displaymetadata, "pageItem.displaymetadata");
                if (displaymetadata.getMmetadata() != null) {
                    Bundle arguments5 = getArguments();
                    String string = arguments5 != null ? arguments5.getString("requestId") : null;
                    if (!TextUtils.isEmpty(string)) {
                        str2 = string + " + " + cJRHomePageItem.getItemID();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        k.a((Object) paytmAdView, "paytmAdView");
                        CJRHomePageItem.Displaymetadata displaymetadata2 = cJRHomePageItem.getDisplaymetadata();
                        k.a((Object) displaymetadata2, "pageItem.displaymetadata");
                        CJRHomePageLayoutV2.Displaymetadata.Metadata mmetadata = displaymetadata2.getMmetadata();
                        if (str2 == null) {
                            k.a();
                        }
                        if (mmetadata != null) {
                            try {
                                PaytmAdView a2 = paytmAdView.a(new com.paytm.ads.b(mmetadata.getVendor_key(), mmetadata.getVerification_parameters(), mmetadata.getJavascript_resource_url()));
                                a2.f40856e = str2;
                                a2.a(mmetadata.getImpression_pixel1()).a(mmetadata.getImpression_pixel2()).a(mmetadata.getImpression_pixel3());
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (z) {
                w.a().a(cJRHomePageItem.getImageUrl()).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_6dp), 0, true)).a(R.color.color_cee2ff).a((ImageView) paytmAdView);
            } else {
                w.a().a(cJRHomePageItem.getImageUrl()).a(R.color.color_cee2ff).a((ImageView) paytmAdView);
            }
            if (i2 != -1) {
                paytmAdView.setOnClickListener(new b(this, cJRHomePageItem, i2));
            }
        }
    }

    public final class b extends PaytmAdView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f61336a;

        /* renamed from: b  reason: collision with root package name */
        private final CJRHomePageItem f61337b;

        /* renamed from: c  reason: collision with root package name */
        private final int f61338c;

        public b(n nVar, CJRHomePageItem cJRHomePageItem, int i2) {
            k.c(cJRHomePageItem, "pageItem");
            this.f61336a = nVar;
            this.f61337b = cJRHomePageItem;
            this.f61338c = i2;
        }

        public final void onAdClick(View view) {
            n.a(this.f61336a, this.f61337b, this.f61338c);
        }
    }

    public static final /* synthetic */ void a(n nVar, CJRHomePageItem cJRHomePageItem, int i2) {
        q.d("Position is :".concat(String.valueOf(i2)));
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        Context context = nVar.getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        cJRRechargeUtilities.loadPage(context, cJRHomePageItem.getURLType(), cJRHomePageItem, "rechAdClp", i2, (ArrayList<? extends CJRItem>) null, false, "rechAdClp");
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context2 = nVar.getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            StringBuilder sb = new StringBuilder();
            String str = nVar.f61334b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append('/');
            net.one97.paytm.recharge.di.helper.b.a(cJRHomePageItem, context2, i2, "", sb.toString());
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61335c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
