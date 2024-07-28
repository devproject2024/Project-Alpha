package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.google.gson.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.di.helper.c;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Character> f61641a = ak.a('a', 'e', 'i', 'o', 'u');

    public static final <T> void a(q qVar, LiveData<T> liveData, b<? super T, x> bVar) {
        k.c(qVar, "$this$observeLiveData");
        k.c(bVar, "body");
        if (liveData != null) {
            liveData.observe(qVar, new h(bVar));
        }
    }

    public static final void a(a<x> aVar, a<x> aVar2) {
        k.c(aVar, "mocked");
        k.c(aVar2, "generic");
        aVar2.invoke();
    }

    public static final Fragment a(Context context, String str, a<? extends Fragment> aVar, a<? extends Fragment> aVar2) {
        k.c(context, "$this$tryDigitalCatalog");
        k.c(aVar, "digitalCatalogBlock");
        k.c(aVar2, "marketCatalogBlock");
        try {
            f fVar = new f();
            c cVar = c.f62654a;
            Object a2 = fVar.a(c.O(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (p.a("release", "debug", true)) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put("77409", "8.12.2");
            }
            if (!TextUtils.isEmpty(str) && hashMap != null) {
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (map.containsKey(str)) {
                    return (Fragment) aVar2.invoke();
                }
            }
            Fragment fragment = (Fragment) aVar.invoke();
            return fragment == null ? (Fragment) aVar2.invoke() : fragment;
        } catch (Exception unused) {
            Fragment fragment2 = (Fragment) aVar.invoke();
            return fragment2 == null ? (Fragment) aVar2.invoke() : fragment2;
        }
    }

    public static final boolean a(Context context, String str) {
        k.c(context, "$this$tryRevampOrderSummaryV8");
        ax.a aVar = ax.f61521a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        com.paytm.b.a.a a2 = ax.a.a(applicationContext);
        if (a2.b("debug.setting.recharge.post.os.revamp", false) && !a2.b("debug.setting.recharge.post.os.revamp", true, false)) {
            return false;
        }
        try {
            f fVar = new f();
            c cVar = c.f62654a;
            Object a3 = fVar.a(c.S(), HashMap.class);
            if (!(a3 instanceof HashMap)) {
                a3 = null;
            }
            HashMap hashMap = (HashMap) a3;
            if (p.a(SDKConstants.KEY_STAGING_API, "release", true)) {
                if (hashMap != null) {
                    hashMap.put("213436", "8.11.2");
                }
                if (hashMap != null) {
                    hashMap.put("26", "8.11.2");
                }
                if (hashMap != null) {
                    hashMap.put("215903", "8.11.2");
                }
            }
            if (!TextUtils.isEmpty(str) && hashMap != null) {
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (map.containsKey(str)) {
                    if (hashMap == null) {
                        k.a();
                    }
                    if (ba.c((String) hashMap.get(str), context)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean b(Context context, String str) {
        k.c(context, "$this$tryIMPSFlow");
        try {
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                return true;
            }
            f fVar = new f();
            c cVar = c.f62654a;
            Object a2 = fVar.a(c.bf(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (!TextUtils.isEmpty(str) && hashMap != null) {
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (map.containsKey(str)) {
                    if (hashMap == null) {
                        k.a();
                    }
                    if (ba.c((String) hashMap.get(str), context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static final String a(String str) {
        k.c(str, "inContactNumber");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (!z2) {
                z = true;
            } else {
                i2++;
            }
        }
        return new l(" ").replace((CharSequence) new l("[^\\d+]").replace((CharSequence) charSequence.subSequence(i2, length + 1).toString(), ""), "");
    }

    public static final String b(String str) {
        int i2;
        k.c(str, "inContactNumber");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z = false;
        while (i3 <= length) {
            boolean z2 = charSequence.charAt(!z ? i3 : length) <= ' ';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (!z2) {
                z = true;
            } else {
                i3++;
            }
        }
        String replace = new l("[^\\d+]").replace((CharSequence) charSequence.subSequence(i3, length + 1).toString(), "");
        if (p.b(replace, "+91", false)) {
            i2 = 3;
        } else if (p.b(replace, "91", false)) {
            i2 = 2;
        } else {
            i2 = p.b(replace, "0", false) ? 1 : 0;
        }
        int length2 = replace.length();
        if (replace != null) {
            String substring = replace.substring(i2, length2);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            CharSequence charSequence2 = substring;
            int length3 = charSequence2.length() - 1;
            int i4 = 0;
            boolean z3 = false;
            while (i4 <= length3) {
                boolean z4 = charSequence2.charAt(!z3 ? i4 : length3) <= ' ';
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length3--;
                } else if (!z4) {
                    z3 = true;
                } else {
                    i4++;
                }
            }
            return new l(" ").replace((CharSequence) charSequence2.subSequence(i4, length3 + 1).toString(), "");
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static final String d(String str) {
        k.c(str, "url");
        String c2 = p.c(str, "category/", "");
        return p.b(c2, "/", c2);
    }

    public static final boolean e(String str) {
        k.c(str, "string");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        k.a((Object) charArray, "(this as java.lang.String).toCharArray()");
        return f61641a.contains(Character.valueOf(Character.toLowerCase(charArray[0])));
    }

    public static final void a(MenuItem menuItem, int i2) {
        Spanned spanned;
        k.c(menuItem, "$this$setTitleColor");
        String hexString = Integer.toHexString(i2);
        k.a((Object) hexString, "Integer.toHexString(color)");
        if (hexString != null) {
            String upperCase = hexString.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            if (upperCase != null) {
                String substring = upperCase.substring(2);
                k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                String str = "<font color='#" + substring + "'>" + menuItem.getTitle() + "</font>";
                if (Build.VERSION.SDK_INT >= 24) {
                    spanned = Html.fromHtml(str, 0);
                    k.a((Object) spanned, "Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)");
                } else {
                    spanned = Html.fromHtml(str);
                    k.a((Object) spanned, "Html.fromHtml(this)");
                }
                menuItem.setTitle(spanned);
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
