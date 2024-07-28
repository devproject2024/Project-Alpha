package net.one97.paytm.dynamic.module.h5sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.verifier.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class H5InternalDeeplinkHandler {
    public static final H5InternalDeeplinkHandler INSTANCE = new H5InternalDeeplinkHandler();

    private H5InternalDeeplinkHandler() {
    }

    public static final boolean handleDeeplink(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        k.c(context2, "context");
        k.c(str2, "deeplink");
        if (!canHandleDeeplink(str)) {
            return false;
        }
        List<String> a2 = p.a((CharSequence) p.a(str2, "paytmmp://mini-app?", "", false), new String[]{AppConstants.AND_SIGN});
        if (a2 != null) {
            List<String> c2 = ab.c(a2);
            x.e eVar = new x.e();
            eVar.element = "";
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromDeeplink", true);
            x.e eVar2 = new x.e();
            eVar2.element = "";
            x.e eVar3 = new x.e();
            eVar3.element = "";
            x.a aVar = new x.a();
            aVar.element = true;
            x.e eVar4 = new x.e();
            eVar4.element = null;
            bundle.putAll(PhoenixManagerImpl.INSTANCE.getDefaultBundleData(context2));
            String str3 = "";
            for (String str4 : c2) {
                if (p.b(str4, "sId=", false)) {
                    try {
                        int length = str4.length();
                        if (str4 != null) {
                            String substring = str4.substring(4, length);
                            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            eVar.element = p.b(p.a(substring, (CharSequence) "\""), (CharSequence) "\"");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                } else if (p.b(str4, "aId=", false)) {
                    try {
                        int length2 = str4.length();
                        if (str4 != null) {
                            String substring2 = str4.substring(4, length2);
                            k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            eVar.element = p.b(p.a(substring2, (CharSequence) "\""), (CharSequence) "\"");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } catch (Exception e3) {
                        q.b(e3.getMessage());
                    }
                } else if (p.b(str4, "data=", false)) {
                    try {
                        int length3 = str4.length();
                        if (str4 != null) {
                            String substring3 = str4.substring(5, length3);
                            k.a((Object) substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            byte[] decode = Base64.decode(p.b(p.a(substring3, (CharSequence) "\""), (CharSequence) "\""), 0);
                            k.a((Object) decode, "data");
                            Charset forName = Charset.forName(AppConstants.UTF_8);
                            k.a((Object) forName, "Charset.forName(\"UTF-8\")");
                            Object nextValue = new JSONTokener(new String(decode, forName)).nextValue();
                            if (nextValue != null) {
                                JSONObject jSONObject = (JSONObject) nextValue;
                                T optString = jSONObject.optString("params");
                                k.a((Object) optString, "jsonObject.optString(\"params\")");
                                eVar2.element = optString;
                                T optString2 = jSONObject.optString(H5TabbarUtils.MATCH_TYPE_PATH);
                                k.a((Object) optString2, "jsonObject.optString(\"path\")");
                                eVar3.element = optString2;
                                jSONObject.optInt(H5StartParamManager.index);
                                eVar4.element = jSONObject.optJSONObject("sparams");
                                q.d("params from deeplink: " + String.valueOf((JSONObject) eVar4.element));
                            } else {
                                throw new u("null cannot be cast to non-null type org.json.JSONObject");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } catch (Exception e4) {
                        q.b(e4.getMessage());
                    }
                } else if (p.b(str4, "url=", false)) {
                    try {
                        int length4 = str4.length();
                        if (str4 != null) {
                            String substring4 = str4.substring(4, length4);
                            k.a((Object) substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            str3 = p.b(p.a(substring4, (CharSequence) "\""), (CharSequence) "\"");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } catch (Exception e5) {
                        q.b(e5.getMessage());
                    }
                } else {
                    continue;
                }
            }
            new StringBuilder("handleDeeplink() appId:").append((String) eVar.element);
            new StringBuilder("handleDeeplink() sparams:").append(bundle);
            new StringBuilder("handleDeeplink() qParam:").append((String) eVar2.element);
            new StringBuilder("handleDeeplink() path:").append((String) eVar3.element);
            if (p.a((String) eVar.element)) {
                return false;
            }
            if (c.a()) {
                PhoenixManager.loadPage$default((String) eVar.element, str3 + ((String) eVar3.element) + ((String) eVar2.element), (PhoenixManager.a) null, bundle, (String) null, false, (List) null, (List) null, (Activity) null, 496, (Object) null);
                return true;
            }
            net.one97.paytm.h5.b.c.a(context2, (String) eVar.element, (c.a) new H5InternalDeeplinkHandler$handleDeeplink$2(eVar3, eVar2, eVar4, bundle, str, aVar, eVar));
            return true;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
    }

    /* access modifiers changed from: private */
    public final void addJsonDataInBundle(Bundle bundle, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        k.a((Object) keys, "it.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) opt).booleanValue());
            } else if (opt instanceof Byte) {
                bundle.putByte(next, ((Number) opt).byteValue());
            } else if (opt instanceof Character) {
                bundle.putChar(next, ((Character) opt).charValue());
            } else if (opt instanceof Short) {
                bundle.putShort(next, ((Number) opt).shortValue());
            } else if (opt instanceof Integer) {
                bundle.putInt(next, ((Number) opt).intValue());
            } else if (opt instanceof Long) {
                bundle.putLong(next, ((Number) opt).longValue());
            } else if (opt instanceof Float) {
                bundle.putFloat(next, ((Number) opt).floatValue());
            } else if (opt instanceof Double) {
                bundle.putDouble(next, ((Number) opt).doubleValue());
            } else if (opt instanceof BigDecimal) {
                bundle.putDouble(next, ((BigDecimal) opt).doubleValue());
            } else if (opt instanceof String) {
                bundle.putString(next, (String) opt);
            } else if (opt instanceof CharSequence) {
                bundle.putCharSequence(next, (CharSequence) opt);
            } else if (opt instanceof JSONArray) {
                bundle.putString(next, opt.toString());
            } else if (opt instanceof JSONObject) {
                bundle.putString(next, opt.toString());
            }
        }
    }

    public static final boolean canHandleDeeplink(String str) {
        k.c(str, "deeplink");
        return p.b(str, "paytmmp://mini-app?", false);
    }
}
