package net.one97.paytm.phoenix.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.a.a;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.data.PhoenixMenuDialogItems;
import net.one97.paytm.phoenix.data.PhoenixMiniAppDialogItems;
import net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider;
import net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProviderCallback;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.g;
import net.one97.paytm.phoenix.util.j;
import org.json.JSONObject;

public final class b extends androidx.fragment.app.b implements a.C1145a {

    /* renamed from: a  reason: collision with root package name */
    public List<PhoenixMenuDialogItems> f59375a;

    /* renamed from: b  reason: collision with root package name */
    final PhoenixActivity f59376b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f59377c;

    /* renamed from: d  reason: collision with root package name */
    private a f59378d;

    /* renamed from: e  reason: collision with root package name */
    private PhoenixMiniAppDialogItems f59379e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f59380f;

    public b(PhoenixActivity phoenixActivity) {
        k.c(phoenixActivity, "phoenixActivity");
        this.f59376b = phoenixActivity;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data") : null;
        if (!(serializable instanceof PhoenixMiniAppDialogItems)) {
            serializable = null;
        }
        this.f59379e = (PhoenixMiniAppDialogItems) serializable;
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.ph5_phoenix_menu_dialog_layout, viewGroup, false);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setGravity(8388661);
        }
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0050, code lost:
        r4 = r4.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r4, r0)
            super.onViewCreated(r4, r5)
            net.one97.paytm.phoenix.a.a r5 = new net.one97.paytm.phoenix.a.a
            java.util.List<net.one97.paytm.phoenix.data.PhoenixMenuDialogItems> r0 = r3.f59375a
            r1 = r3
            net.one97.paytm.phoenix.a.a$a r1 = (net.one97.paytm.phoenix.a.a.C1145a) r1
            r5.<init>(r0, r1)
            r3.f59378d = r5
            int r5 = net.one97.paytm.phoenix.R.id.recyclerView
            android.view.View r4 = r4.findViewById(r5)
            java.lang.String r5 = "view.findViewById(R.id.recyclerView)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            r3.f59377c = r4
            androidx.recyclerview.widget.RecyclerView r4 = r3.f59377c
            if (r4 != 0) goto L_0x002c
            java.lang.String r5 = "recyclerView"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x002c:
            net.one97.paytm.phoenix.a.a r5 = r3.f59378d
            if (r5 != 0) goto L_0x0035
            java.lang.String r0 = "dialogSheetAdapter"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0035:
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r4.setAdapter(r5)
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r0 = r4.getContext()
            r1 = 1
            r2 = 0
            r5.<init>(r0, r1, r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r5
            r4.setLayoutManager(r5)
            android.app.Dialog r4 = r3.getDialog()
            if (r4 == 0) goto L_0x005b
            android.view.Window r4 = r4.getWindow()
            if (r4 == 0) goto L_0x005b
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
            goto L_0x005c
        L_0x005b:
            r4 = 0
        L_0x005c:
            if (r4 == 0) goto L_0x0062
            r5 = 54
            r4.y = r5
        L_0x0062:
            android.app.Dialog r5 = r3.getDialog()
            if (r5 == 0) goto L_0x0071
            android.view.Window r5 = r5.getWindow()
            if (r5 == 0) goto L_0x0071
            r5.setAttributes(r4)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.a.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        if (window != null) {
            window.setLayout(H5PullContainer.DEFALUT_DURATION, -2);
        }
    }

    public final void a(PhoenixMenuDialogItems phoenixMenuDialogItems) {
        String str;
        String deeplink;
        String deeplink2;
        k.c(phoenixMenuDialogItems, "bottomSheetItem");
        j jVar = j.f59646a;
        StringBuilder sb = new StringBuilder("data: ");
        PhoenixMiniAppDialogItems phoenixMiniAppDialogItems = this.f59379e;
        String str2 = null;
        sb.append(phoenixMiniAppDialogItems != null ? phoenixMiniAppDialogItems.getShortlable() : null);
        sb.append(' ');
        PhoenixMiniAppDialogItems phoenixMiniAppDialogItems2 = this.f59379e;
        sb.append(phoenixMiniAppDialogItems2 != null ? phoenixMiniAppDialogItems2.getLongLable() : null);
        sb.append(' ');
        PhoenixMiniAppDialogItems phoenixMiniAppDialogItems3 = this.f59379e;
        sb.append(phoenixMiniAppDialogItems3 != null ? phoenixMiniAppDialogItems3.getDeeplink() : null);
        sb.append(' ');
        PhoenixMiniAppDialogItems phoenixMiniAppDialogItems4 = this.f59379e;
        sb.append(phoenixMiniAppDialogItems4 != null ? phoenixMiniAppDialogItems4.getIcon() : null);
        j.b("PhoenixBottomSheetFragment", sb.toString());
        Bundle sParamsBundle = PhoenixManager.INSTANCE.getSParamsBundle();
        if (sParamsBundle == null) {
            sParamsBundle = new Bundle();
        }
        j jVar2 = j.f59646a;
        j.b("PhoenixBottomSheetFragment", "key-value pair " + sParamsBundle.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        g gVar = g.f59641a;
        g.a(sParamsBundle, jSONObject2);
        jSONObject.put("sparams", jSONObject2);
        j jVar3 = j.f59646a;
        j.b("PhoenixBottomSheetFragment", "sparams json ".concat(String.valueOf(jSONObject)));
        String jSONObject3 = jSONObject.toString();
        k.a((Object) jSONObject3, "json.toString()");
        Charset charset = d.f47971a;
        if (jSONObject3 != null) {
            byte[] bytes = jSONObject3.getBytes(charset);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            j jVar4 = j.f59646a;
            j.b("PhoenixBottomSheetFragment", "encodeToString ".concat(String.valueOf(encodeToString)));
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems5 = this.f59379e;
            Boolean valueOf = (phoenixMiniAppDialogItems5 == null || (deeplink2 = phoenixMiniAppDialogItems5.getDeeplink()) == null) ? null : Boolean.valueOf(p.a((CharSequence) deeplink2, (CharSequence) AppConstants.AND_SIGN, false));
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                PhoenixMiniAppDialogItems phoenixMiniAppDialogItems6 = this.f59379e;
                List c2 = ab.c((phoenixMiniAppDialogItems6 == null || (deeplink = phoenixMiniAppDialogItems6.getDeeplink()) == null) ? null : p.a((CharSequence) deeplink, new String[]{AppConstants.AND_SIGN}));
                String str3 = c2 != null ? (String) c2.get(0) : null;
                String str4 = c2 != null ? (String) c2.get(1) : null;
                j jVar5 = j.f59646a;
                j.b("PhoenixBottomSheetFragment", "get ".concat(String.valueOf(str3)));
                j jVar6 = j.f59646a;
                j.b("PhoenixBottomSheetFragment", "get1 ".concat(String.valueOf(str4)));
                Boolean valueOf2 = str4 != null ? Boolean.valueOf(p.a((CharSequence) str4, (CharSequence) "data=", false)) : null;
                if (valueOf2 == null) {
                    k.a();
                }
                if (valueOf2.booleanValue()) {
                    str = (k.a(str3, (Object) AppConstants.AND_SIGN) + "data=") + encodeToString;
                } else {
                    j jVar7 = j.f59646a;
                    j.b("PhoenixBottomSheetFragment", "get else ".concat(String.valueOf(str3)));
                    str = str3;
                }
            } else {
                j jVar8 = j.f59646a;
                j.b("PhoenixBottomSheetFragment", "else");
                PhoenixMiniAppDialogItems phoenixMiniAppDialogItems7 = this.f59379e;
                str = phoenixMiniAppDialogItems7 != null ? phoenixMiniAppDialogItems7.getDeeplink() : null;
            }
            j jVar9 = j.f59646a;
            j.b("PhoenixBottomSheetFragment", "newdeepLink ".concat(String.valueOf(str)));
            j jVar10 = j.f59646a;
            StringBuilder sb2 = new StringBuilder("data: ");
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems8 = this.f59379e;
            sb2.append(phoenixMiniAppDialogItems8 != null ? phoenixMiniAppDialogItems8.getShortlable() : null);
            sb2.append(' ');
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems9 = this.f59379e;
            sb2.append(phoenixMiniAppDialogItems9 != null ? phoenixMiniAppDialogItems9.getLongLable() : null);
            sb2.append(' ');
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems10 = this.f59379e;
            sb2.append(phoenixMiniAppDialogItems10 != null ? phoenixMiniAppDialogItems10.getDeeplink() : null);
            sb2.append(' ');
            PhoenixMiniAppDialogItems phoenixMiniAppDialogItems11 = this.f59379e;
            sb2.append(phoenixMiniAppDialogItems11 != null ? phoenixMiniAppDialogItems11.getIcon() : null);
            j.b("PhoenixBottomSheetFragment", sb2.toString());
            if (p.a(phoenixMenuDialogItems.getDescription(), "Invite friends", true)) {
                this.f59376b.G.put("event_label", "share button tapped");
                PhoenixActivity phoenixActivity = this.f59376b;
                phoenixActivity.a(phoenixActivity.G, GAUtil.CUSTOM_EVENT);
                JSONObject jSONObject4 = new JSONObject();
                j jVar11 = j.f59646a;
                j.b("PhoenixBottomSheet", "splitDeeplink: ".concat(String.valueOf(str)));
                JSONObject jSONObject5 = new JSONObject();
                List b2 = str != null ? p.a((CharSequence) str, new String[]{"?"}) : null;
                if (b2 != null) {
                    jSONObject4.put("af_scheme", ab.c(b2).get(0));
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("aId");
                    String queryParameter2 = parse.getQueryParameter("data");
                    jSONObject5.put("aId", queryParameter);
                    jSONObject5.put("data", queryParameter2);
                    j jVar12 = j.f59646a;
                    j.b("PhoenixBottomSheet", "splitDeeplink af_scheme_parameter: " + jSONObject5.toString());
                    jSONObject4.put("af_scheme_parameter", jSONObject5.toString());
                    jSONObject4.put("af_url_parameter", "");
                    jSONObject4.put("af_dp", str);
                    jSONObject4.put("af_url", "");
                    j jVar13 = j.f59646a;
                    j.b("PhoenixBottomSheet", "splitDeeplink jsonObject: " + jSONObject4.toString());
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject4.keys();
                    k.a((Object) keys, "jsonObject.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        k.a((Object) next, "key");
                        String optString = jSONObject4.optString(next);
                        k.a((Object) optString, "jsonObject.optString(key)");
                        hashMap.put(next, optString);
                    }
                    PhoenixMiniAppDialogItems phoenixMiniAppDialogItems12 = this.f59379e;
                    if (phoenixMiniAppDialogItems12 != null) {
                        str2 = phoenixMiniAppDialogItems12.getAppName();
                    }
                    f b3 = c.f59399a.b();
                    String name = PhoenixGenerateShortLinkProvider.class.getName();
                    k.a((Object) name, "PhoenixGenerateShortLinkProvider::class.java.name");
                    PhoenixGenerateShortLinkProvider phoenixGenerateShortLinkProvider = (PhoenixGenerateShortLinkProvider) b3.a(name);
                    if (phoenixGenerateShortLinkProvider != null) {
                        phoenixGenerateShortLinkProvider.generateShortLink(this.f59376b, hashMap, new a(this, str2));
                    }
                    Dialog dialog = getDialog();
                    if (dialog != null) {
                        dialog.dismiss();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            } else if (p.a(phoenixMenuDialogItems.getDescription(), "Add To Homescreen", true)) {
                this.f59376b.G.put("event_label", "Add to HomeScreen Tapped");
                PhoenixActivity phoenixActivity2 = this.f59376b;
                phoenixActivity2.a(phoenixActivity2.G, GAUtil.CUSTOM_EVENT);
                JSONObject jSONObject6 = new JSONObject();
                PhoenixMiniAppDialogItems phoenixMiniAppDialogItems13 = this.f59379e;
                String shortlable = phoenixMiniAppDialogItems13 != null ? phoenixMiniAppDialogItems13.getShortlable() : null;
                PhoenixMiniAppDialogItems phoenixMiniAppDialogItems14 = this.f59379e;
                String longLable = phoenixMiniAppDialogItems14 != null ? phoenixMiniAppDialogItems14.getLongLable() : null;
                if (TextUtils.isEmpty((CharSequence) null)) {
                    shortlable = longLable;
                }
                String valueOf3 = String.valueOf(System.currentTimeMillis() / 1000);
                jSONObject6.put("shortLabel", shortlable);
                jSONObject6.put("longLabel", longLable);
                jSONObject6.put("deeplink", str);
                PhoenixMiniAppDialogItems phoenixMiniAppDialogItems15 = this.f59379e;
                if (phoenixMiniAppDialogItems15 != null) {
                    str2 = phoenixMiniAppDialogItems15.getIcon();
                }
                jSONObject6.put(H5ResourceHandlerUtil.IMAGE, str2);
                jSONObject6.put("uniqueId", valueOf3);
                jSONObject6.put("disabledMessage", "disabled");
                j jVar14 = j.f59646a;
                j.b("PhoenixBottomSheetFragment", "add to homescreen " + jSONObject6.toString());
                H5Event h5Event = new H5Event("createAppShortcut", com.alipay.mobile.h5container.api.H5Event.TYPE_CALL, jSONObject6, (String) null, false, 24, (kotlin.g.b.g) null);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    k.a((Object) activity, "it");
                    h5Event.setActivity(activity);
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    c cVar = c.f59399a;
                    k.a((Object) activity2, "it");
                    net.one97.paytm.phoenix.api.b a2 = cVar.a(activity2);
                    if (a2 != null) {
                        c.f59399a.a().a(h5Event, a2);
                    }
                }
                Dialog dialog2 = getDialog();
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final class a implements PhoenixGenerateShortLinkProviderCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f59381a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59382b;

        a(b bVar, String str) {
            this.f59381a = bVar;
            this.f59382b = str;
        }

        public final void onResult(Object obj) {
            k.c(obj, "shortLink");
            j jVar = j.f59646a;
            j.b("PhoenixDialogSheetFragment", "shortLink: ".concat(String.valueOf(obj)));
            if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "Try " + this.f59382b + " on Paytm Mini Apps: " + obj);
                intent.setType("text/plain");
                this.f59381a.f59376b.startActivity(Intent.createChooser(intent, (CharSequence) null));
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        j jVar = j.f59646a;
        j.b("PhoenixDialogSheetFragment", "ondestroy");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final void onDetach() {
        super.onDetach();
        j jVar = j.f59646a;
        j.b("PhoenixDialogSheetFragment", "onDetach");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f59380f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
