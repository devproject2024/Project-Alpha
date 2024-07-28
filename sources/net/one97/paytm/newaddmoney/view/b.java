package net.one97.paytm.newaddmoney.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.helper.c;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRFlyoutBanner;

public final class b extends h implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55889a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f55890b;

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.networkResponse != null) {
            if (networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401 || networkCustomError.networkResponse.statusCode == 410) {
                c a2 = net.one97.paytm.helper.a.f50546a.a();
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    a2.a((Activity) activity, getClass().getCanonicalName(), (Bundle) null);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        ArrayList<CJRFlyoutBanner.Page> arrayList;
        ArrayList<CJRFlyoutBanner.Views> arrayList2;
        ArrayList<CJRHomePageItem> arrayList3;
        RelativeLayout relativeLayout;
        String name;
        TextView textView;
        if (iJRPaytmDataModel != null) {
            try {
                if (iJRPaytmDataModel instanceof CJRFlyoutBanner) {
                    String a2 = net.one97.paytm.helper.a.f50546a.a().a("addmoney_banner_sf_id", "8576");
                    String a3 = net.one97.paytm.helper.a.f50546a.a().a("addmoney_banner_page_id", "300741");
                    if (((CJRFlyoutBanner) iJRPaytmDataModel).page_id.equals(a2) && (arrayList = ((CJRFlyoutBanner) iJRPaytmDataModel).page) != null && (!arrayList.isEmpty())) {
                        CJRFlyoutBanner.Page page = new CJRFlyoutBanner.Page(a3);
                        if (arrayList.contains(page) && (arrayList2 = arrayList.get(arrayList.indexOf(page)).views) != null && !arrayList2.isEmpty()) {
                            CJRFlyoutBanner.Views views = new CJRFlyoutBanner.Views(a3);
                            if (arrayList2.contains(views) && (arrayList3 = arrayList2.get(arrayList2.indexOf(views)).items) != null && !arrayList3.isEmpty()) {
                                boolean z = false;
                                CJRHomePageItem cJRHomePageItem = arrayList3.get(0);
                                View view = getView();
                                if (view != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.offer_layout)) != null && cJRHomePageItem != null && (name = cJRHomePageItem.getName()) != null) {
                                    if (name.length() == 0) {
                                        z = true;
                                    }
                                    if (!z) {
                                        View view2 = getView();
                                        if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.tv_bank_addmoney)) == null)) {
                                            textView.setText(cJRHomePageItem.getName());
                                        }
                                        net.one97.paytm.newaddmoney.utils.c.a((View) relativeLayout, true);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r7.isFinishing() == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r5, android.view.ViewGroup r6, android.os.Bundle r7) {
        /*
            r4 = this;
            java.lang.String r7 = "inflater"
            kotlin.g.b.k.c(r5, r7)
            int r7 = net.one97.paytm.addmoney.R.layout.fragment_offer_banner
            r0 = 0
            android.view.View r5 = r5.inflate(r7, r6, r0)
            java.lang.String r6 = "inflater.inflate(R.layou…banner, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.os.Bundle r6 = r4.getArguments()
            if (r6 == 0) goto L_0x0021
            java.lang.String r7 = "url"
            java.lang.String r0 = ""
            java.lang.String r6 = r6.getString(r7, r0)
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00d9
            boolean r7 = android.webkit.URLUtil.isValidUrl(r6)
            if (r7 == 0) goto L_0x00d9
            androidx.fragment.app.FragmentActivity r7 = r4.getActivity()
            if (r7 != 0) goto L_0x004b
            androidx.fragment.app.FragmentActivity r7 = r4.getActivity()
            if (r7 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            java.lang.String r0 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            boolean r7 = r7.isFinishing()
            if (r7 != 0) goto L_0x00d9
        L_0x004b:
            androidx.fragment.app.FragmentActivity r7 = r4.getActivity()
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r6 = com.paytm.utility.b.e((android.content.Context) r7, (java.lang.String) r6)
            java.lang.String r7 = "bannerUrl"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            androidx.fragment.app.FragmentActivity r7 = r4.getActivity()     // Catch:{ Exception -> 0x00d5 }
            if (r7 == 0) goto L_0x00d9
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x00d5 }
            r7.<init>()     // Catch:{ Exception -> 0x00d5 }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r1 = "sso_token"
            androidx.fragment.app.FragmentActivity r2 = r4.getActivity()     // Catch:{ Exception -> 0x00d5 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = com.paytm.utility.d.a(r2)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r3 = "CJRNetUtility.getSSOToken(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00d5 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00d5 }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r1 = "user_id"
            androidx.fragment.app.FragmentActivity r2 = r4.getActivity()     // Catch:{ Exception -> 0x00d5 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r3 = "CJRAppCommonUtility.getUserId(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00d5 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00d5 }
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()     // Catch:{ Exception -> 0x00d5 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x00d5 }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ Exception -> 0x00d5 }
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.addmoney.common.a$a r0 = net.one97.paytm.addmoney.common.a.f48418a     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r0 = net.one97.paytm.addmoney.common.a.C0848a.b()     // Catch:{ Exception -> 0x00d5 }
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()     // Catch:{ Exception -> 0x00d5 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r0 = r0.a((android.content.Context) r1)     // Catch:{ Exception -> 0x00d5 }
            net.one97.paytm.wallet.newdesign.addmoney.model.CJRFlyoutBanner r1 = new net.one97.paytm.wallet.newdesign.addmoney.model.CJRFlyoutBanner     // Catch:{ Exception -> 0x00d5 }
            r1.<init>()     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r1)     // Catch:{ Exception -> 0x00d5 }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r7 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r7)     // Catch:{ Exception -> 0x00d5 }
            r0 = r4
            com.paytm.network.listener.b r0 = (com.paytm.network.listener.b) r0     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r7 = r7.a((com.paytm.network.listener.b) r0)     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.b r6 = r7.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00d5 }
            com.paytm.network.a r6 = r6.l()     // Catch:{ Exception -> 0x00d5 }
            r6.a()     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00d9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.b.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55890b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
