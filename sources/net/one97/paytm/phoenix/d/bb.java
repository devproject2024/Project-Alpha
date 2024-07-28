package net.one97.paytm.phoenix.d;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.k;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.paytmmall.clpartifact.utils.GAUtil;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.m.l;
import kotlin.m.p;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.phoenix.R;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider;
import net.one97.paytm.phoenix.provider.TitleBarImageProvider;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

public final class bb extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59538a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineScope f59539b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    /* renamed from: c  reason: collision with root package name */
    private final String f59540c = "Startup Params PhoenixTitleBarPlugin";

    public bb() {
        super(H5Param.LONG_SHOW_TITLEBAR, "paytmShowTitleBar", "paytmChangeStatusBarColor", H5Plugin.CommonEvents.SET_TITLE, H5Plugin.CommonEvents.SET_TITLE_COLOR, "setTransparentTitle", H5Plugin.CommonEvents.SET_BACK_BUTTON, H5Plugin.CommonEvents.SHOW_BACK_BUTTON, H5Plugin.CommonEvents.HIDE_BACK_BUTTON, "paytmChangeBackButtonColor", "paytmCustomizeTitleBar", H5Plugin.InternalEvents.H5_TITLEBAR_TITLE_CLICK, H5Param.LONG_BACKBTN_TEXTCOLOR);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02e3, code lost:
        if (r13.equals("paytmShowTitleBar") != false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02e5, code lost:
        if (r1 == null) goto L_0x02ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e7, code lost:
        r13 = r1.showToolbar();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ec, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02ed, code lost:
        if (r13 != null) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ef, code lost:
        r13 = r12.getParams();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f3, code lost:
        if (r13 == null) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f5, code lost:
        r3 = java.lang.Boolean.valueOf(r13.optBoolean("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02ff, code lost:
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0304, code lost:
        return a(r12, r2, r13, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r13.equals(com.alipay.mobile.h5container.api.H5Param.LONG_SHOW_TITLEBAR) != false) goto L_0x02e5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r12, net.one97.paytm.phoenix.api.b r13) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r13, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13)
            java.lang.String r13 = r12.getBridgeName()
            r0 = 0
            if (r13 == 0) goto L_0x0305
            net.one97.paytm.phoenix.core.c r1 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r1 = r1.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider> r2 = net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider.class
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "PhoenixTitleBarProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object r1 = r1.a(r2)
            net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider r1 = (net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider) r1
            android.app.Activity r2 = r12.getActivity()
            r3 = 0
            if (r2 == 0) goto L_0x0050
            android.app.Activity r2 = r12.getActivity()
            if (r2 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            boolean r2 = r2 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r2 == 0) goto L_0x0050
            android.app.Activity r2 = r12.getActivity()
            if (r2 == 0) goto L_0x0048
            net.one97.paytm.phoenix.ui.PhoenixActivity r2 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r2
            goto L_0x0051
        L_0x0048:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r12.<init>(r13)
            throw r12
        L_0x0050:
            r2 = r3
        L_0x0051:
            if (r2 != 0) goto L_0x0054
            return r0
        L_0x0054:
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r11.f59540c
            java.lang.String r5 = java.lang.String.valueOf(r13)
            java.lang.String r6 = "action"
            java.lang.String r5 = r6.concat(r5)
            net.one97.paytm.phoenix.util.j.b(r4, r5)
            int r4 = r13.hashCode()
            java.lang.String r5 = "#"
            java.lang.String r7 = "showTitleBar"
            java.lang.String r8 = "activity.intent"
            r9 = 1
            java.lang.String r10 = "color"
            switch(r4) {
                case -1994296199: goto L_0x02dd;
                case -1912171269: goto L_0x02c6;
                case -1799460336: goto L_0x02a1;
                case -1322984979: goto L_0x0230;
                case -986139725: goto L_0x01c7;
                case -794464810: goto L_0x01b8;
                case 311193025: goto L_0x0161;
                case 723153117: goto L_0x0154;
                case 1038753243: goto L_0x0145;
                case 1202279592: goto L_0x0122;
                case 1358379897: goto L_0x0100;
                case 1405084438: goto L_0x007f;
                case 1572967608: goto L_0x0077;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x0305
        L_0x0077:
            boolean r13 = r13.equals(r7)
            if (r13 == 0) goto L_0x0305
            goto L_0x02e5
        L_0x007f:
            java.lang.String r1 = "setTitle"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0305
            org.json.JSONObject r13 = r12.getParams()
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x00be
            java.lang.String r0 = "title"
            java.lang.String r0 = r13.optString(r0)
            java.lang.String r1 = "params.optString(\"title\")"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = "subtitle"
            java.lang.String r1 = r13.optString(r1)
            java.lang.String r3 = "params.optString(\"subtitle\")"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r3 = "image"
            java.lang.String r3 = r13.optString(r3)
            java.lang.String r4 = "params.optString(\"image\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = "isResultRequired"
            boolean r5 = r13.has(r4)
            if (r5 == 0) goto L_0x00c0
            boolean r13 = r13.getBoolean(r4)
            r5 = r13
            goto L_0x00c1
        L_0x00be:
            r1 = r0
            r3 = r1
        L_0x00c0:
            r5 = 1
        L_0x00c1:
            net.one97.paytm.phoenix.data.H5EventTitle r13 = new net.one97.paytm.phoenix.data.H5EventTitle
            r13.<init>(r0, r1, r3)
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.TitleBarImageProvider> r1 = net.one97.paytm.phoenix.provider.TitleBarImageProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r3 = "TitleBarImageProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.Object r0 = r0.a(r1)
            r4 = r0
            net.one97.paytm.phoenix.provider.TitleBarImageProvider r4 = (net.one97.paytm.phoenix.provider.TitleBarImageProvider) r4
            if (r4 == 0) goto L_0x00f7
            java.lang.String r0 = r13.getImage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00f7
            java.lang.String r3 = r13.getImage()
            r0 = r11
            r1 = r12
            boolean r12 = r0.a(r1, r2, r3, r4, r5)
            return r12
        L_0x00f7:
            java.lang.String r13 = r13.getTitle()
            boolean r12 = r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2, (java.lang.String) r13, (boolean) r5)
            return r12
        L_0x0100:
            java.lang.String r4 = "paytmChangeBackButtonColor"
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0305
            if (r1 == 0) goto L_0x010f
            java.lang.String r13 = r1.getBackButtonColor()
            goto L_0x0110
        L_0x010f:
            r13 = r3
        L_0x0110:
            if (r13 != 0) goto L_0x011d
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x011c
            java.lang.String r3 = r13.optString(r10)
        L_0x011c:
            r13 = r3
        L_0x011d:
            boolean r12 = r11.d(r12, r2, r13, true)
            return r12
        L_0x0122:
            java.lang.String r1 = "setTransparentTitle"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0305
            r13 = r2
            android.content.Context r13 = (android.content.Context) r13
            r0 = 17170445(0x106000d, float:2.461195E-38)
            int r13 = androidx.core.content.b.c(r13, r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 0
            r6 = 0
            r7 = 48
            r0 = r11
            r1 = r12
            boolean r12 = a(r0, r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x0145:
            java.lang.String r3 = "hideBackButton"
            boolean r13 = r13.equals(r3)
            if (r13 == 0) goto L_0x0305
            java.lang.String r13 = "hide"
            boolean r12 = r11.a((java.lang.String) r13, (net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider) r1, (net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2)
            return r12
        L_0x0154:
            java.lang.String r1 = "paytmCustomizeTitleBar"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0305
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2)
            goto L_0x0305
        L_0x0161:
            java.lang.String r1 = "backBtnTextColor"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0305
            net.one97.paytm.phoenix.util.j r1 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r1 = r11.f59540c
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r13 = r6.concat(r13)
            net.one97.paytm.phoenix.util.j.b(r1, r13)
            org.json.JSONObject r13 = r12.getParams()     // Catch:{ Exception -> 0x01a7 }
            if (r13 == 0) goto L_0x0187
            int r13 = r13.getInt(r10)     // Catch:{ Exception -> 0x01a7 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x0188
        L_0x0187:
            r13 = r3
        L_0x0188:
            if (r13 != 0) goto L_0x0192
            net.one97.paytm.phoenix.api.a r13 = net.one97.paytm.phoenix.api.a.INVALID_PARAM     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "value empty!"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.a) r13, (java.lang.String) r1)     // Catch:{ Exception -> 0x01a7 }
            return r0
        L_0x0192:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a7 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x01a7 }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r13 = java.lang.Integer.toHexString(r13)     // Catch:{ Exception -> 0x01a7 }
            r1.append(r13)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r13 = r1.toString()     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01b3
        L_0x01a7:
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x01b2
            java.lang.String r3 = r13.getString(r10)
        L_0x01b2:
            r13 = r3
        L_0x01b3:
            boolean unused = r11.d(r12, r2, r13, true)
            goto L_0x0305
        L_0x01b8:
            java.lang.String r3 = "showBackButton"
            boolean r13 = r13.equals(r3)
            if (r13 == 0) goto L_0x0305
            java.lang.String r13 = "show"
            boolean r12 = r11.a((java.lang.String) r13, (net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider) r1, (net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2)
            return r12
        L_0x01c7:
            java.lang.String r4 = "paytmChangeStatusBarColor"
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0305
            if (r1 == 0) goto L_0x01d6
            java.lang.String r13 = r1.getStatusBarColor()
            goto L_0x01d7
        L_0x01d6:
            r13 = r3
        L_0x01d7:
            if (r13 != 0) goto L_0x01e5
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x01e4
            java.lang.String r13 = r13.optString(r10)
            goto L_0x01e5
        L_0x01e4:
            r13 = r3
        L_0x01e5:
            android.content.Intent r0 = r2.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            android.os.Bundle r0 = r0.getExtras()
            org.json.JSONObject r0 = r2.a((android.os.Bundle) r0)
            boolean r0 = r0.optBoolean(r7)
            android.content.Intent r1 = r2.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            android.os.Bundle r1 = r1.getExtras()
            org.json.JSONObject r1 = r2.a((android.os.Bundle) r1)
            java.lang.String r4 = "renderWithinSafeArea"
            boolean r1 = r1.optBoolean(r4)
            if (r0 != 0) goto L_0x0219
            if (r1 != 0) goto L_0x0219
            net.one97.paytm.phoenix.api.a r13 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r0 = "Not allowed as translucent flag is enabled"
            r11.b(r12, r13, r0)
            return r9
        L_0x0219:
            kotlinx.coroutines.CoroutineScope r0 = r11.f59539b
            r4 = 0
            r5 = 0
            net.one97.paytm.phoenix.d.bb$d r1 = new net.one97.paytm.phoenix.d.bb$d
            r1.<init>(r2, r3)
            r6 = r1
            kotlin.g.a.m r6 = (kotlin.g.a.m) r6
            r7 = 3
            r8 = 0
            r3 = r0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
            boolean r12 = r11.c(r12, r2, r13, r9)
            return r12
        L_0x0230:
            java.lang.String r1 = "setTitleColor"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0305
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x0247
            int r0 = r13.optInt(r10)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0248
        L_0x0247:
            r0 = r3
        L_0x0248:
            if (r13 == 0) goto L_0x0254
            java.lang.String r1 = "reset"
            boolean r13 = r13.optBoolean(r1)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
        L_0x0254:
            net.one97.paytm.phoenix.data.H5EventTitleColor r13 = new net.one97.paytm.phoenix.data.H5EventTitleColor
            r13.<init>(r0, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.Integer r1 = r13.getColor()
            if (r1 != 0) goto L_0x0267
            kotlin.g.b.k.a()
        L_0x0267:
            int r1 = r1.intValue()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r0 = android.graphics.Color.parseColor(r0)
            android.content.Intent r1 = r2.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            android.os.Bundle r1 = r1.getExtras()
            org.json.JSONObject r1 = r2.a((android.os.Bundle) r1)
            java.lang.String r3 = "appTypeMerchant"
            boolean r6 = r1.optBoolean(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Boolean r4 = r13.getReset()
            r5 = 0
            r7 = 16
            r0 = r11
            r1 = r12
            boolean r12 = a(r0, r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x02a1:
            java.lang.String r1 = "titleClick"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0305
            androidx.lifecycle.k r13 = r2.getLifecycle()
            java.lang.String r1 = "activity.lifecycle"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            androidx.lifecycle.k$b r13 = r13.a()
            androidx.lifecycle.k$b r1 = androidx.lifecycle.k.b.DESTROYED
            if (r13 == r1) goto L_0x0305
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            java.lang.String r1 = "success"
            r11.a((java.lang.String) r1, (java.lang.Object) r13)
            r13 = 6
            net.one97.paytm.phoenix.core.a.a(r11, r12, r3, r0, r13)
            goto L_0x0305
        L_0x02c6:
            java.lang.String r4 = "setBackButton"
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0305
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x02d8
            java.lang.String r3 = r13.optString(r6)
        L_0x02d8:
            boolean r12 = r11.a((java.lang.String) r3, (net.one97.paytm.phoenix.provider.PhoenixTitleBarProvider) r1, (net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2)
            return r12
        L_0x02dd:
            java.lang.String r4 = "paytmShowTitleBar"
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0305
        L_0x02e5:
            if (r1 == 0) goto L_0x02ec
            java.lang.Boolean r13 = r1.showToolbar()
            goto L_0x02ed
        L_0x02ec:
            r13 = r3
        L_0x02ed:
            if (r13 != 0) goto L_0x0300
            org.json.JSONObject r13 = r12.getParams()
            if (r13 == 0) goto L_0x02ff
            java.lang.String r0 = "value"
            boolean r13 = r13.optBoolean(r0)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
        L_0x02ff:
            r13 = r3
        L_0x0300:
            boolean r12 = r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.ui.PhoenixActivity) r2, (java.lang.Boolean) r13, (boolean) r9)
            return r12
        L_0x0305:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.bb.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    private final boolean a(String str, PhoenixTitleBarProvider phoenixTitleBarProvider, H5Event h5Event, PhoenixActivity phoenixActivity) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "handleShowBackButton:");
        Boolean showBackButton = phoenixTitleBarProvider != null ? phoenixTitleBarProvider.showBackButton() : null;
        net.one97.paytm.phoenix.util.j jVar2 = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "handleShowBackButton isShow:".concat(String.valueOf(showBackButton)));
        if (showBackButton == null) {
            return b(h5Event, phoenixActivity, str, true);
        }
        return b(h5Event, phoenixActivity, showBackButton.booleanValue() ? "show" : "hide", true);
    }

    private final boolean a(H5Event h5Event, PhoenixActivity phoenixActivity, Boolean bool, boolean z) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, H5Param.LONG_SHOW_TITLEBAR.concat(String.valueOf(bool)));
        if (bool != null || !z) {
            H5Event h5Event2 = h5Event;
            androidx.lifecycle.k lifecycle = phoenixActivity.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
            if (lifecycle.a() == k.b.DESTROYED) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new k(this, bool, phoenixActivity, z, h5Event, (kotlin.d.d) null), 3, (Object) null);
            return true;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    private final boolean a(H5Event h5Event, PhoenixActivity phoenixActivity, String str, boolean z) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "setTitleBarText:".concat(String.valueOf(str)));
        if (str != null || !z) {
            H5Event h5Event2 = h5Event;
            x.a aVar = new x.a();
            aVar.element = false;
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new i(this, phoenixActivity, str, z, h5Event, aVar, (kotlin.d.d) null), 3, (Object) null);
            return aVar.element;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    private final boolean a(H5Event h5Event, PhoenixActivity phoenixActivity, Integer num, boolean z) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "setTitleTextColor:".concat(String.valueOf(num)));
        if (num != null) {
            num.intValue();
        }
        x.a aVar = new x.a();
        aVar.element = false;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new j(this, phoenixActivity, num, z, false, h5Event, aVar, (kotlin.d.d) null), 3, (Object) null);
        return aVar.element;
    }

    private final boolean a(H5Event h5Event, PhoenixActivity phoenixActivity, String str, TitleBarImageProvider titleBarImageProvider, boolean z) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "setTitleBarImage:".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str) || !z) {
            H5Event h5Event2 = h5Event;
            x.a aVar = new x.a();
            aVar.element = false;
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new h(this, phoenixActivity, str, titleBarImageProvider, z, h5Event, aVar, (kotlin.d.d) null), 3, (Object) null);
            return aVar.element;
        }
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    private static /* synthetic */ boolean a(bb bbVar, H5Event h5Event, PhoenixActivity phoenixActivity, Integer num, Boolean bool, boolean z, boolean z2, int i2) {
        return bbVar.a(h5Event, phoenixActivity, num, bool, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? false : z2);
    }

    private final boolean a(H5Event h5Event, PhoenixActivity phoenixActivity, Integer num, Boolean bool, boolean z, boolean z2) {
        Integer num2 = num;
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "setTitleBarColor:".concat(String.valueOf(num)));
        x.e eVar = new x.e();
        eVar.element = num2;
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue() || num2 != null || !z) {
            H5Event h5Event2 = h5Event;
            androidx.lifecycle.k lifecycle = phoenixActivity.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
            if (lifecycle.a() == k.b.DESTROYED) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new g(this, bool, eVar, phoenixActivity, z2, z, h5Event, (kotlin.d.d) null), 3, (Object) null);
            return true;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean b(H5Event h5Event, PhoenixActivity phoenixActivity, String str, boolean z) {
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "setBackButton:".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str) || !z) {
            H5Event h5Event2 = h5Event;
            androidx.lifecycle.k lifecycle = phoenixActivity.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
            if (lifecycle.a() == k.b.DESTROYED) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new f(this, str, phoenixActivity, z, h5Event, (kotlin.d.d) null), 3, (Object) null);
            return true;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    private final boolean c(H5Event h5Event, PhoenixActivity phoenixActivity, String str, boolean z) {
        String str2 = str;
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "changeStatusBarColor:".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str2) || !z) {
            H5Event h5Event2 = h5Event;
            x.e eVar = new x.e();
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            eVar.element = str2;
            if (!p.b((String) eVar.element, "#", false)) {
                eVar.element = "#" + ((String) eVar.element);
            }
            androidx.lifecycle.k lifecycle = phoenixActivity.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
            if (lifecycle.a() == k.b.DESTROYED) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new c(this, phoenixActivity, eVar, z, h5Event, (kotlin.d.d) null), 3, (Object) null);
            return true;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean d(H5Event h5Event, PhoenixActivity phoenixActivity, String str, boolean z) {
        String str2 = str;
        net.one97.paytm.phoenix.util.j jVar = net.one97.paytm.phoenix.util.j.f59646a;
        net.one97.paytm.phoenix.util.j.b(this.f59540c, "changeBackButtonColor:".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str2) || !z) {
            H5Event h5Event2 = h5Event;
            x.e eVar = new x.e();
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            eVar.element = str2;
            if (!p.b((String) eVar.element, "#", false)) {
                eVar.element = "#" + ((String) eVar.element);
            }
            androidx.lifecycle.k lifecycle = phoenixActivity.getLifecycle();
            kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
            if (lifecycle.a() == k.b.DESTROYED) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f59539b, (kotlin.d.f) null, (CoroutineStart) null, new b(this, phoenixActivity, eVar, z, h5Event, (kotlin.d.d) null), 3, (Object) null);
            return true;
        }
        H5Event h5Event3 = h5Event;
        a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "value empty!");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(net.one97.paytm.phoenix.api.H5Event r26, net.one97.paytm.phoenix.ui.PhoenixActivity r27) {
        /*
            r25 = this;
            r8 = r25
            r9 = r26
            r10 = r27
            java.lang.String r0 = "backBtnTextColor"
            net.one97.paytm.phoenix.util.j r1 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r1 = r8.f59540c
            java.lang.String r2 = "customizeToolbar:"
            net.one97.paytm.phoenix.util.j.b(r1, r2)
            org.json.JSONObject r1 = r26.getParams()
            if (r1 == 0) goto L_0x0022
            java.lang.String r2 = "showTitleBar"
            boolean r1 = r1.optBoolean(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            org.json.JSONObject r2 = r26.getParams()
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = "showBackButton"
            boolean r2 = r2.optBoolean(r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            org.json.JSONObject r3 = r26.getParams()
            java.lang.String r4 = "paytmChangeStatusBarColor"
            if (r3 == 0) goto L_0x0042
            java.lang.String r3 = r3.optString(r4)
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            org.json.JSONObject r5 = r26.getParams()
            java.lang.String r6 = "paytmChangeBackButtonColor"
            if (r5 == 0) goto L_0x0050
            java.lang.String r5 = r5.optString(r6)
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            org.json.JSONObject r7 = r26.getParams()
            java.lang.String r12 = "titleColor"
            if (r7 == 0) goto L_0x005e
            java.lang.String r7 = r7.optString(r12)
            goto L_0x005f
        L_0x005e:
            r7 = 0
        L_0x005f:
            org.json.JSONObject r13 = r26.getParams()
            java.lang.String r14 = "titleBarColor"
            if (r13 == 0) goto L_0x006c
            java.lang.String r13 = r13.optString(r14)
            goto L_0x006d
        L_0x006c:
            r13 = 0
        L_0x006d:
            org.json.JSONObject r15 = r26.getParams()
            if (r15 == 0) goto L_0x007a
            java.lang.String r11 = "appIconUrl"
            java.lang.String r11 = r15.optString(r11)
            goto L_0x007b
        L_0x007a:
            r11 = 0
        L_0x007b:
            org.json.JSONObject r15 = r26.getParams()
            r16 = r6
            if (r15 == 0) goto L_0x008b
            java.lang.String r6 = "defaultTitle"
            java.lang.String r6 = r15.optString(r6)
            r15 = r6
            goto L_0x008c
        L_0x008b:
            r15 = 0
        L_0x008c:
            org.json.JSONObject r6 = r26.getParams()
            r17 = r15
            java.lang.String r15 = "statusBarStyle"
            if (r6 == 0) goto L_0x00a1
            int r6 = r6.optInt(r15)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r18 = r6
            goto L_0x00a3
        L_0x00a1:
            r18 = 0
        L_0x00a3:
            org.json.JSONObject r6 = r26.getParams()
            r19 = r0
            if (r6 == 0) goto L_0x00b8
            java.lang.String r0 = "showMenuButton"
            boolean r0 = r6.optBoolean(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r20 = r0
            goto L_0x00ba
        L_0x00b8:
            r20 = 0
        L_0x00ba:
            org.json.JSONObject r0 = r26.getParams()
            if (r0 == 0) goto L_0x00cb
            java.lang.String r6 = "appTypeMerchant"
            boolean r0 = r0.optBoolean(r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x00cc
        L_0x00cb:
            r0 = 0
        L_0x00cc:
            org.json.JSONObject r6 = r26.getParams()
            r21 = r12
            if (r6 == 0) goto L_0x00df
            java.lang.String r12 = "showStatusBar"
            boolean r6 = r6.optBoolean(r12)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x00e0
        L_0x00df:
            r6 = 0
        L_0x00e0:
            org.json.JSONObject r12 = r26.getParams()
            r22 = r15
            if (r12 == 0) goto L_0x00f3
            java.lang.String r15 = "overrideCrossToBack"
            boolean r12 = r12.optBoolean(r15)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x00f4
        L_0x00f3:
            r12 = 0
        L_0x00f4:
            net.one97.paytm.phoenix.util.j r15 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r15 = r8.f59540c
            r23 = r12
            java.lang.String r12 = java.lang.String.valueOf(r1)
            r24 = r4
            java.lang.String r4 = "paytmShowTitleBar:"
            java.lang.String r4 = r4.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r15, r4)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r2)
            java.lang.String r15 = "showBackButton:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r3)
            java.lang.String r15 = "changeStatusBarColor:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r5)
            java.lang.String r15 = "CHANGE_BACK_BUTTON_COLOR:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r7)
            java.lang.String r15 = "SET_TITLE_TEXT_COLOR:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r13)
            java.lang.String r15 = "SET_TITLE_BAR_COLOR:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r11)
            java.lang.String r15 = "TITLE_BAR_APP_ICON:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r0)
            java.lang.String r15 = "appTypeMerchant:"
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            net.one97.paytm.phoenix.util.j r4 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r4 = r8.f59540c
            java.lang.String r12 = java.lang.String.valueOf(r6)
            java.lang.String r15 = "showStatusBar: "
            java.lang.String r12 = r15.concat(r12)
            net.one97.paytm.phoenix.util.j.b(r4, r12)
            if (r6 != 0) goto L_0x0196
            kotlin.g.b.k.a()
        L_0x0196:
            boolean r4 = r6.booleanValue()
            if (r4 != 0) goto L_0x01a7
            android.view.Window r4 = r27.getWindow()
            if (r4 == 0) goto L_0x01a7
            r6 = 1024(0x400, float:1.435E-42)
            r4.setFlags(r6, r6)
        L_0x01a7:
            if (r0 != 0) goto L_0x01ac
            kotlin.g.b.k.a()
        L_0x01ac:
            boolean r0 = r0.booleanValue()
            r12 = 1
            r4 = -1
            r15 = 0
            if (r0 == 0) goto L_0x02ac
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Boolean) r1, (boolean) r15)
            net.one97.paytm.phoenix.util.g r0 = net.one97.paytm.phoenix.util.g.f59641a
            r1 = r24
            kotlin.o r0 = net.one97.paytm.phoenix.util.g.a(r10, r14, r1)
            java.lang.Object r1 = r0.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.component2()
            java.lang.String r0 = (java.lang.String) r0
            net.one97.paytm.phoenix.util.g r2 = net.one97.paytm.phoenix.util.g.f59641a
            r5 = r21
            r3 = r22
            kotlin.o r2 = net.one97.paytm.phoenix.util.g.b(r10, r5, r3)
            java.lang.Object r3 = r2.component1()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.component2()
            java.lang.Integer r2 = (java.lang.Integer) r2
            r8.c(r9, r10, r0, r15)
            a((net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Integer) r2)
            if (r3 == 0) goto L_0x01f7
            int r0 = a(r3)
            if (r0 == r4) goto L_0x01f7
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Integer) r0, (boolean) r12)
        L_0x01f7:
            if (r1 == 0) goto L_0x0210
            int r0 = a(r1)
            if (r0 == r4) goto L_0x0210
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 0
            r6 = 1
            r0 = r25
            r1 = r26
            r2 = r27
            r0.a(r1, r2, r3, r4, r5, r6)
        L_0x0210:
            androidx.appcompat.widget.Toolbar r0 = r27.e()
            if (r20 != 0) goto L_0x0219
            kotlin.g.b.k.a()
        L_0x0219:
            boolean r1 = r20.booleanValue()
            java.lang.String r2 = "toolbar.findViewById<ImageView>(R.id.ivDots)"
            if (r1 == 0) goto L_0x0230
            int r1 = net.one97.paytm.phoenix.R.id.ivDots
            android.view.View r0 = r0.findViewById(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r15)
            goto L_0x0240
        L_0x0230:
            int r1 = net.one97.paytm.phoenix.R.id.ivDots
            android.view.View r0 = r0.findViewById(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = 8
            r0.setVisibility(r1)
        L_0x0240:
            java.lang.String r0 = "enable"
            r8.b((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.String) r0, (boolean) r15)
            net.one97.paytm.phoenix.util.j r0 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r0 = r8.f59540c
            java.lang.String r1 = java.lang.String.valueOf(r23)
            java.lang.String r2 = "overrideCrossToBack: "
            java.lang.String r1 = r2.concat(r1)
            net.one97.paytm.phoenix.util.j.b(r0, r1)
            if (r23 != 0) goto L_0x025b
            kotlin.g.b.k.a()
        L_0x025b:
            boolean r0 = r23.booleanValue()
            if (r0 == 0) goto L_0x0298
            androidx.appcompat.widget.Toolbar r0 = r27.e()
            int r1 = net.one97.paytm.phoenix.R.id.ivCrossButton
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            r0.setImageResource(r15)
            androidx.appcompat.widget.Toolbar r0 = r27.e()
            int r1 = net.one97.paytm.phoenix.R.id.ivCrossButton
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            int r1 = net.one97.paytm.phoenix.R.drawable.ic_back
            r0.setImageResource(r1)
            androidx.appcompat.widget.Toolbar r0 = r27.e()
            int r1 = net.one97.paytm.phoenix.R.id.ivCrossButton
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            net.one97.paytm.phoenix.d.bb$e r1 = new net.one97.paytm.phoenix.d.bb$e
            r1.<init>(r10)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            goto L_0x02a9
        L_0x0298:
            androidx.appcompat.widget.Toolbar r0 = r27.e()
            int r1 = net.one97.paytm.phoenix.R.id.ivCrossButton
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            int r1 = net.one97.paytm.phoenix.R.drawable.ic_group_new
            r0.setImageResource(r1)
        L_0x02a9:
            r0 = 1
            goto L_0x03b6
        L_0x02ac:
            org.json.JSONObject r0 = r26.getParams()     // Catch:{ Exception -> 0x02db }
            r6 = r19
            if (r0 == 0) goto L_0x02bf
            int r0 = r0.getInt(r6)     // Catch:{ Exception -> 0x02bd }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02c0
        L_0x02bd:
            goto L_0x02dd
        L_0x02bf:
            r0 = 0
        L_0x02c0:
            if (r0 == 0) goto L_0x02d9
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            java.lang.String r12 = "#"
            r14.<init>(r12)     // Catch:{ Exception -> 0x02bd }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = java.lang.Integer.toHexString(r0)     // Catch:{ Exception -> 0x02bd }
            r14.append(r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r14.toString()     // Catch:{ Exception -> 0x02bd }
            goto L_0x02e7
        L_0x02d9:
            r0 = 0
            goto L_0x02e7
        L_0x02db:
            r6 = r19
        L_0x02dd:
            org.json.JSONObject r0 = r26.getParams()
            if (r0 == 0) goto L_0x02d9
            java.lang.String r0 = r0.getString(r6)
        L_0x02e7:
            net.one97.paytm.phoenix.util.j r12 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r12 = r8.f59540c
            java.lang.String r14 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "BACK_BUTTON_TEXT_COLOR:"
            java.lang.String r4 = r4.concat(r14)
            net.one97.paytm.phoenix.util.j.b(r12, r4)
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Boolean) r1, (boolean) r15)
            java.lang.String r1 = "show"
            if (r2 == 0) goto L_0x030a
            r2.booleanValue()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x030a
            java.lang.String r1 = "hide"
        L_0x030a:
            r8.b((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.String) r1, (boolean) r15)
            r8.c(r9, r10, r3, r15)
            r1 = r18
            a((net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Integer) r1)
            if (r5 == 0) goto L_0x032d
            net.one97.paytm.phoenix.util.g r1 = net.one97.paytm.phoenix.util.g.f59641a
            java.util.Map r1 = net.one97.paytm.phoenix.util.g.a()
            r2 = r16
            java.lang.Object r1 = r1.get(r2)
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x032d
            r8.d(r9, r10, r5, r15)
            goto L_0x0346
        L_0x032d:
            if (r0 == 0) goto L_0x0343
            net.one97.paytm.phoenix.util.g r1 = net.one97.paytm.phoenix.util.g.f59641a
            java.util.Map r1 = net.one97.paytm.phoenix.util.g.a()
            java.lang.Object r1 = r1.get(r6)
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0343
            r8.d(r9, r10, r0, r15)
            goto L_0x0346
        L_0x0343:
            r8.d(r9, r10, r5, r15)
        L_0x0346:
            if (r7 == 0) goto L_0x0357
            int r0 = a(r7)
            r1 = -1
            if (r0 == r1) goto L_0x0358
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.Integer) r0, (boolean) r15)
            goto L_0x0358
        L_0x0357:
            r1 = -1
        L_0x0358:
            if (r13 == 0) goto L_0x0373
            int r0 = a(r13)
            if (r0 == r1) goto L_0x0373
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 0
            r6 = 0
            r7 = 32
            r0 = r25
            r1 = r26
            r2 = r27
            a(r0, r1, r2, r3, r4, r5, r6, r7)
        L_0x0373:
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.TitleBarImageProvider> r1 = net.one97.paytm.phoenix.provider.TitleBarImageProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "TitleBarImageProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r0 = r0.a(r1)
            r4 = r0
            net.one97.paytm.phoenix.provider.TitleBarImageProvider r4 = (net.one97.paytm.phoenix.provider.TitleBarImageProvider) r4
            org.json.JSONObject r0 = r26.getParams()
            if (r0 == 0) goto L_0x0397
            java.lang.String r0 = r0.optString(r11)
            r3 = r0
            goto L_0x0398
        L_0x0397:
            r3 = 0
        L_0x0398:
            if (r4 == 0) goto L_0x03af
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03af
            r5 = 0
            r0 = r25
            r1 = r26
            r2 = r27
            r0.a(r1, r2, r3, r4, r5)
            goto L_0x02a9
        L_0x03af:
            r6 = r17
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.ui.PhoenixActivity) r10, (java.lang.String) r6, (boolean) r15)
            goto L_0x02a9
        L_0x03b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.bb.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.ui.PhoenixActivity):boolean");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59541a;

        e(PhoenixActivity phoenixActivity) {
            this.f59541a = phoenixActivity;
        }

        public final void onClick(View view) {
            this.f59541a.G.put("event_label", "back_button_tapped");
            PhoenixActivity phoenixActivity = this.f59541a;
            phoenixActivity.a(phoenixActivity.G, GAUtil.CUSTOM_EVENT);
            this.f59541a.onBackPressed();
        }
    }

    private static int a(String str) {
        Boolean bool;
        if (str != null) {
            bool = Boolean.valueOf(new l("\\d+").matches(str));
        } else {
            bool = null;
        }
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue()) {
            str = "#" + Integer.toHexString(Integer.parseInt(str));
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static void a(PhoenixActivity phoenixActivity, Integer num) {
        Window window = null;
        if (num == null || num.intValue() != 1) {
            if (phoenixActivity != null) {
                window = phoenixActivity.getWindow();
            }
            kotlin.g.b.k.a((Object) window, "activity?.window");
            View decorView = window.getDecorView();
            kotlin.g.b.k.a((Object) decorView, "activity?.window.decorView");
            decorView.setSystemUiVisibility(0);
        } else if (Build.VERSION.SDK_INT >= 23) {
            if (phoenixActivity != null) {
                window = phoenixActivity.getWindow();
            }
            kotlin.g.b.k.a((Object) window, "activity?.window");
            View decorView2 = window.getDecorView();
            kotlin.g.b.k.a((Object) decorView2, "activity?.window.decorView");
            decorView2.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$changeBackButtonColor$1")
    static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ x.e $formattedColor;
        final /* synthetic */ boolean $isResultRequired;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bb bbVar, PhoenixActivity phoenixActivity, x.e eVar, boolean z, H5Event h5Event, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$activity = phoenixActivity;
            this.$formattedColor = eVar;
            this.$isResultRequired = z;
            this.$event = h5Event;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$activity, this.$formattedColor, this.$isResultRequired, this.$event, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    Drawable navigationIcon = this.$activity.e().getNavigationIcon();
                    if (navigationIcon != null) {
                        navigationIcon.setColorFilter(Color.parseColor((String) this.$formattedColor.element), PorterDuff.Mode.SRC_ATOP);
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (this.$isResultRequired) {
                    this.this$0.a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$changeStatusBarColor$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ x.e $color;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bb bbVar, PhoenixActivity phoenixActivity, x.e eVar, boolean z, H5Event h5Event, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$activity = phoenixActivity;
            this.$color = eVar;
            this.$isResultRequired = z;
            this.$event = h5Event;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$activity, this.$color, this.$isResultRequired, this.$event, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        Window window = this.$activity.getWindow();
                        if (window != null) {
                            window.addFlags(Integer.MIN_VALUE);
                        }
                        Window window2 = this.$activity.getWindow();
                        if (window2 != null) {
                            window2.setStatusBarColor(Color.parseColor((String) this.$color.element));
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (this.$isResultRequired) {
                    this.this$0.a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$handleEvent$1$1")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PhoenixActivity phoenixActivity, kotlin.d.d dVar) {
            super(2, dVar);
            this.$activity = phoenixActivity;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            d dVar2 = new d(this.$activity, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                Window window = this.$activity.getWindow();
                if (window != null) {
                    window.clearFlags(67108864);
                }
                LinearLayout linearLayout = (LinearLayout) this.$activity.a(R.id.main_layout);
                kotlin.g.b.k.a((Object) linearLayout, "activity.main_layout");
                linearLayout.setFitsSystemWindows(true);
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$setBackButton$1")
    static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ String $action;
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(bb bbVar, String str, PhoenixActivity phoenixActivity, boolean z, H5Event h5Event, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$action = str;
            this.$activity = phoenixActivity;
            this.$isResultRequired = z;
            this.$event = h5Event;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            f fVar = new f(this.this$0, this.$action, this.$activity, this.$isResultRequired, this.$event, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                String str = this.$action;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1298848381:
                            if (str.equals("enable")) {
                                this.$activity.getSupportActionBar();
                                this.$activity.f59607e = true;
                                break;
                            }
                            break;
                        case 3202370:
                            if (str.equals("hide")) {
                                ActionBar supportActionBar = this.$activity.getSupportActionBar();
                                if (supportActionBar != null) {
                                    supportActionBar.b(false);
                                }
                                this.$activity.getSupportActionBar();
                                this.$activity.f59607e = true;
                                break;
                            }
                            break;
                        case 3529469:
                            if (str.equals("show")) {
                                ActionBar supportActionBar2 = this.$activity.getSupportActionBar();
                                if (supportActionBar2 != null) {
                                    supportActionBar2.b(true);
                                }
                                this.$activity.getSupportActionBar();
                                this.$activity.f59607e = true;
                                break;
                            }
                            break;
                        case 1671308008:
                            if (str.equals("disable")) {
                                this.$activity.getSupportActionBar();
                                this.$activity.f59607e = false;
                                break;
                            }
                            break;
                    }
                }
                if (this.$isResultRequired) {
                    this.this$0.a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$setTitleBarColor$1")
    static final class g extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ boolean $appTypeMerchant;
        final /* synthetic */ x.e $color;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        final /* synthetic */ Boolean $reset;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(bb bbVar, Boolean bool, x.e eVar, PhoenixActivity phoenixActivity, boolean z, boolean z2, H5Event h5Event, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$reset = bool;
            this.$color = eVar;
            this.$activity = phoenixActivity;
            this.$appTypeMerchant = z;
            this.$isResultRequired = z2;
            this.$event = h5Event;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            g gVar = new g(this.this$0, this.$reset, this.$color, this.$activity, this.$appTypeMerchant, this.$isResultRequired, this.$event, dVar);
            gVar.p$ = (CoroutineScope) obj;
            return gVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                if (this.$reset.booleanValue()) {
                    this.$color.element = Integer.valueOf(androidx.core.content.b.c(this.$activity, 17170443));
                }
                try {
                    Toolbar e2 = this.$activity.e();
                    Integer num = (Integer) this.$color.element;
                    if (num == null) {
                        kotlin.g.b.k.a();
                    }
                    e2.setBackgroundColor(num.intValue());
                    if (this.$appTypeMerchant) {
                        View a2 = this.$activity.a(R.id.toolbar_separator);
                        Integer num2 = (Integer) this.$color.element;
                        if (num2 == null) {
                            kotlin.g.b.k.a();
                        }
                        a2.setBackgroundColor(num2.intValue());
                    }
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                }
                if (this.$isResultRequired) {
                    this.this$0.a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$setTitleBarImage$1")
    static final class h extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ TitleBarImageProvider $imageProvider;
        final /* synthetic */ boolean $isResultRequired;
        final /* synthetic */ x.a $result;
        final /* synthetic */ String $titleBarImageUrl;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(bb bbVar, PhoenixActivity phoenixActivity, String str, TitleBarImageProvider titleBarImageProvider, boolean z, H5Event h5Event, x.a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$activity = phoenixActivity;
            this.$titleBarImageUrl = str;
            this.$imageProvider = titleBarImageProvider;
            this.$isResultRequired = z;
            this.$event = h5Event;
            this.$result = aVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            h hVar = new h(this.this$0, this.$activity, this.$titleBarImageUrl, this.$imageProvider, this.$isResultRequired, this.$event, this.$result, dVar);
            hVar.p$ = (CoroutineScope) obj;
            return hVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                TextView textView = (TextView) this.$activity.findViewById(R.id.tv_toolbar_title);
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = (ImageView) this.$activity.findViewById(R.id.iv_toolbar_logo);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                androidx.lifecycle.k lifecycle = this.$activity.getLifecycle();
                kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
                if (lifecycle.a() != k.b.DESTROYED) {
                    int dimensionPixelSize = this.$activity.getResources().getDimensionPixelSize(R.dimen.dimen_48dp);
                    int dimensionPixelSize2 = this.$activity.getResources().getDimensionPixelSize(R.dimen.dimen_48dp);
                    if (!TextUtils.isEmpty(this.$titleBarImageUrl)) {
                        TitleBarImageProvider titleBarImageProvider = this.$imageProvider;
                        kotlin.g.b.k.a((Object) imageView, "imageView");
                        String str = this.$titleBarImageUrl;
                        if (str == null) {
                            kotlin.g.b.k.a();
                        }
                        titleBarImageProvider.setTitleBarImage(dimensionPixelSize, dimensionPixelSize2, imageView, str);
                    }
                    if (this.$isResultRequired) {
                        this.this$0.a("success", (Object) Boolean.TRUE);
                        net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, true, 2);
                    }
                    this.$result.element = true;
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$setTitleBarText$1")
    static final class i extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        final /* synthetic */ x.a $result;
        final /* synthetic */ String $titleBarText;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(bb bbVar, PhoenixActivity phoenixActivity, String str, boolean z, H5Event h5Event, x.a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$activity = phoenixActivity;
            this.$titleBarText = str;
            this.$isResultRequired = z;
            this.$event = h5Event;
            this.$result = aVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            i iVar = new i(this.this$0, this.$activity, this.$titleBarText, this.$isResultRequired, this.$event, this.$result, dVar);
            iVar.p$ = (CoroutineScope) obj;
            return iVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((i) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                ImageView imageView = (ImageView) this.$activity.findViewById(R.id.iv_toolbar_logo);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                TextView b2 = this.$activity.b();
                b2.setVisibility(0);
                PhoenixActivity phoenixActivity = this.$activity;
                Intent intent = phoenixActivity.getIntent();
                kotlin.g.b.k.a((Object) intent, "activity.intent");
                if (phoenixActivity.a(intent.getExtras()).optBoolean("showTitleLoading")) {
                    this.$activity.c().setVisibility(0);
                }
                androidx.lifecycle.k lifecycle = this.$activity.getLifecycle();
                kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
                if (lifecycle.a() != k.b.DESTROYED) {
                    b2.setText(this.$titleBarText);
                    this.$activity.e().invalidate();
                    if (this.$isResultRequired) {
                        this.this$0.a("success", (Object) Boolean.TRUE);
                        net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, true, 2);
                    }
                    this.$result.element = true;
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$setTitleTextColor$1")
    static final class j extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ boolean $appTypeMerchant;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        final /* synthetic */ x.a $result;
        final /* synthetic */ Integer $textColor;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(bb bbVar, PhoenixActivity phoenixActivity, Integer num, boolean z, boolean z2, H5Event h5Event, x.a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$activity = phoenixActivity;
            this.$textColor = num;
            this.$appTypeMerchant = z;
            this.$isResultRequired = z2;
            this.$event = h5Event;
            this.$result = aVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            j jVar = new j(this.this$0, this.$activity, this.$textColor, this.$appTypeMerchant, this.$isResultRequired, this.$event, this.$result, dVar);
            jVar.p$ = (CoroutineScope) obj;
            return jVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((j) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                TextView b2 = this.$activity.b();
                androidx.lifecycle.k lifecycle = this.$activity.getLifecycle();
                kotlin.g.b.k.a((Object) lifecycle, "activity.lifecycle");
                if (lifecycle.a() != k.b.DESTROYED) {
                    Integer num = this.$textColor;
                    if (num == null) {
                        kotlin.g.b.k.a();
                    }
                    b2.setTextColor(num.intValue());
                    if (this.$appTypeMerchant) {
                        ((AppCompatImageView) this.$activity.e().findViewById(R.id.ivCrossButton)).setColorFilter(this.$textColor.intValue(), PorterDuff.Mode.SRC_IN);
                        ((AppCompatImageView) this.$activity.e().findViewById(R.id.ivDots)).setColorFilter(this.$textColor.intValue());
                    }
                    if (this.$isResultRequired) {
                        this.this$0.a("success", (Object) Boolean.TRUE);
                        net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                    }
                    this.$result.element = true;
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.d.b.a.f(b = "PhoenixTitleBarPlugin.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.phoenix.plugin.PhoenixTitleBarPlugin$showTitleBar$1")
    static final class k extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ PhoenixActivity $activity;
        final /* synthetic */ H5Event $event;
        final /* synthetic */ boolean $isResultRequired;
        final /* synthetic */ Boolean $showTitleBar;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bb this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(bb bbVar, Boolean bool, PhoenixActivity phoenixActivity, boolean z, H5Event h5Event, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = bbVar;
            this.$showTitleBar = bool;
            this.$activity = phoenixActivity;
            this.$isResultRequired = z;
            this.$event = h5Event;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            k kVar = new k(this.this$0, this.$showTitleBar, this.$activity, this.$isResultRequired, this.$event, dVar);
            kVar.p$ = (CoroutineScope) obj;
            return kVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((k) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                Toolbar e2 = this.$activity.e();
                Boolean bool = this.$showTitleBar;
                if (bool == null) {
                    kotlin.g.b.k.a();
                }
                e2.setVisibility(bool.booleanValue() ? 0 : 8);
                if (this.$isResultRequired) {
                    this.this$0.a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this.this$0, this.$event, (Object) null, false, 6);
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
