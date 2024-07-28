package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.h5paytmsdk.c.y;

public final class d extends ad {
    public d() {
        super("createAppShortcut");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        ShortcutManager shortcutManager;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!b(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        e param = h5Event.getParam();
        String string = param.getString("uniqueId");
        String string2 = param.getString("shortLabel");
        String string3 = param.getString("longLabel");
        String string4 = param.getString("deeplink");
        String string5 = param.getString("disabledMessage");
        if (string5 == null) {
            string5 = "disabled";
        }
        String str = string5;
        String string6 = param.getString(H5ResourceHandlerUtil.IMAGE);
        if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(string6)) {
            a(H5Event.Error.INVALID_PARAM, "Message empty!");
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Activity activity = h5Event.getActivity();
                if (activity == null || (shortcutManager = (ShortcutManager) activity.getSystemService(ShortcutManager.class)) == null) {
                    return true;
                }
                k.a((Object) string6, H5ResourceHandlerUtil.IMAGE);
                H5ImageListener aVar = new a(shortcutManager, activity, this, string6, string4, string, string2, string3, str);
                if (p.b(string6, "http://", false) || p.b(string6, "https://", false)) {
                    Nebula.loadImage(string6, aVar);
                    return true;
                }
                byte[] decode = Base64.decode(string6, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                k.a((Object) decodeByteArray, "BitmapFactory.decodeByte…ytes, 0, imageBytes.size)");
                aVar.onImage(decodeByteArray);
                return true;
            }
            a(H5Event.Error.FORBIDDEN, "Not supported");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            a(H5Event.Error.FORBIDDEN, "Not supported");
            return true;
        }
    }

    static final class a implements H5ImageListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShortcutManager f16981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f16982b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f16983c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f16984d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f16985e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f16986f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f16987g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f16988h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f16989i;

        a(ShortcutManager shortcutManager, Activity activity, d dVar, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f16981a = shortcutManager;
            this.f16982b = activity;
            this.f16983c = dVar;
            this.f16984d = str;
            this.f16985e = str2;
            this.f16986f = str3;
            this.f16987g = str4;
            this.f16988h = str5;
            this.f16989i = str6;
        }

        public final void onImage(Bitmap bitmap) {
            if (bitmap == null) {
                this.f16983c.a(H5Event.Error.UNKNOWN_ERROR, "bitmap downloading failed");
                return;
            }
            ShortcutManager shortcutManager = this.f16981a;
            Activity activity = this.f16982b;
            String str = this.f16985e;
            k.a((Object) str, "deeplink");
            String str2 = this.f16986f;
            k.a((Object) str2, "uniqueId");
            String str3 = this.f16987g;
            k.a((Object) str3, "shortLabel");
            String str4 = this.f16988h;
            k.a((Object) str4, "longLabel");
            d.a(shortcutManager, activity, str, str2, str3, str4, this.f16989i, bitmap);
            d dVar = this.f16983c;
            ShortcutManager shortcutManager2 = this.f16981a;
            Activity activity2 = this.f16982b;
            String str5 = this.f16986f;
            k.a((Object) str5, "uniqueId");
            d.a(dVar, shortcutManager2, activity2, str5);
        }
    }

    public static final /* synthetic */ void a(ShortcutManager shortcutManager, Activity activity, String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        Intent intent;
        List arrayList = new ArrayList();
        H5ProviderManager providerManager = Nebula.getProviderManager();
        y yVar = (y) (providerManager != null ? providerManager.getProvider(y.class.getName()) : null);
        if (yVar != null) {
            Context context = activity;
            intent = yVar.a(str, context);
            ArrayList<ShortcutInfo> a2 = yVar.a(context);
            if (a2 != null) {
                for (ShortcutInfo add : a2) {
                    arrayList.add(add);
                }
            }
        } else {
            intent = null;
        }
        ShortcutInfo.Builder icon = new ShortcutInfo.Builder(activity, str2).setShortLabel(str3).setLongLabel(str4).setDisabledMessage(str5).setIcon(Icon.createWithBitmap(bitmap));
        if (intent == null) {
            k.a();
        }
        ShortcutInfo build = icon.setIntent(intent).build();
        k.a((Object) build, "miniAppShortcut");
        arrayList.add(build);
        shortcutManager.setDynamicShortcuts(arrayList);
    }

    public static final /* synthetic */ void a(d dVar, ShortcutManager shortcutManager, Activity activity, String str) {
        if (shortcutManager.isRequestPinShortcutSupported()) {
            Context context = activity;
            ShortcutInfo build = new ShortcutInfo.Builder(context, str).build();
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, shortcutManager.createShortcutResultIntent(build), 0);
            k.a((Object) broadcast, "successCallback");
            shortcutManager.requestPinShortcut(build, broadcast.getIntentSender());
            dVar.a("success", (Object) Boolean.TRUE);
            dVar.a((Object) null);
        }
    }
}
