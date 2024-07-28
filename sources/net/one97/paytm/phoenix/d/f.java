package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.d;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.p;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends net.one97.paytm.phoenix.core.a {

    static final class a extends l implements b<Byte, String> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).byteValue());
        }

        public final String invoke(byte b2) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            k.a((Object) format, "java.lang.String.format(this, *args)");
            return format;
        }
    }

    public f() {
        super("paytmSaveData", "paytmGetData", "paytmRemoveData");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        if (a(h5Event)) {
            String action$phoenix_debug = h5Event.getAction$phoenix_debug();
            if (action$phoenix_debug != null) {
                int hashCode = action$phoenix_debug.hashCode();
                if (hashCode != -26278136) {
                    if (hashCode != 128967615) {
                        if (hashCode == 991581775 && action$phoenix_debug.equals("paytmRemoveData")) {
                            JSONObject params = h5Event.getParams();
                            JSONArray optJSONArray = params != null ? params.optJSONArray("keys") : null;
                            Activity activity = h5Event.getActivity();
                            if (activity != null && (activity instanceof PhoenixActivity)) {
                                String a2 = a(((PhoenixActivity) activity).f59606d);
                                if (TextUtils.isEmpty(a2) || optJSONArray == null || optJSONArray.length() == 0) {
                                    z3 = false;
                                } else {
                                    int length = optJSONArray.length();
                                    z3 = false;
                                    for (int i2 = 0; i2 < length; i2++) {
                                        Object obj = optJSONArray.get(i2);
                                        if (obj instanceof String) {
                                            p.a aVar = p.f59656a;
                                            String str = (String) obj;
                                            k.c(str, "key");
                                            k.c(a2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a2).edit().remove(str).apply();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                            z3 = true;
                                        }
                                    }
                                }
                                if (z3) {
                                    a("success", (Object) Boolean.TRUE);
                                    net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, false, 6);
                                } else {
                                    a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "cannot remove data");
                                }
                                p.a aVar2 = p.f59656a;
                                p.a aVar3 = p.f59656a;
                                p.a.a(p.f59657b).edit().putBoolean(a2, true).apply();
                            }
                        }
                    } else if (action$phoenix_debug.equals("paytmGetData")) {
                        JSONObject params2 = h5Event.getParams();
                        JSONArray optJSONArray2 = params2 != null ? params2.optJSONArray("keys") : null;
                        Activity activity2 = h5Event.getActivity();
                        if (activity2 != null && (activity2 instanceof PhoenixActivity)) {
                            String a3 = a(((PhoenixActivity) activity2).f59606d);
                            if (!TextUtils.isEmpty(a3)) {
                                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                                    int length2 = optJSONArray2.length();
                                    for (int i3 = 0; i3 < length2; i3++) {
                                        Object obj2 = optJSONArray2.get(i3);
                                        if (obj2 instanceof String) {
                                            p.a aVar4 = p.f59656a;
                                            String str2 = (String) obj2;
                                            Object a4 = p.a.a(str2, a3);
                                            if (a4 == null) {
                                                a4 = "";
                                            }
                                            a(str2, a4);
                                        }
                                    }
                                }
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "cannot get data");
                            } else {
                                net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, false, 6);
                            }
                            p.a aVar5 = p.f59656a;
                            p.a aVar6 = p.f59656a;
                            p.a.a(p.f59657b).edit().putBoolean(a3, true).apply();
                        }
                    }
                } else if (action$phoenix_debug.equals("paytmSaveData")) {
                    JSONObject params3 = h5Event.getParams();
                    JSONObject optJSONObject = params3 != null ? params3.optJSONObject("data") : null;
                    Activity activity3 = h5Event.getActivity();
                    if (activity3 != null && (activity3 instanceof PhoenixActivity)) {
                        String a5 = a(((PhoenixActivity) activity3).f59606d);
                        if (!TextUtils.isEmpty(a5) && optJSONObject != null && optJSONObject.length() != 0) {
                            Iterator<String> keys = optJSONObject.keys();
                            loop2:
                            while (true) {
                                z = false;
                                while (true) {
                                    if (!keys.hasNext()) {
                                        break loop2;
                                    }
                                    String next = keys.next();
                                    Object opt = optJSONObject.opt(next);
                                    if (!TextUtils.isEmpty(next)) {
                                        if (opt instanceof Integer) {
                                            p.a aVar7 = p.f59656a;
                                            k.a((Object) next, "key");
                                            int intValue = ((Number) opt).intValue();
                                            k.c(next, "key");
                                            k.c(a5, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a5).edit().putInt(next, intValue).apply();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        } else if (opt instanceof Float) {
                                            p.a aVar8 = p.f59656a;
                                            k.a((Object) next, "key");
                                            float floatValue = ((Number) opt).floatValue();
                                            k.c(next, "key");
                                            k.c(a5, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a5).edit().putFloat(next, floatValue).apply();
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                            }
                                        } else if (opt instanceof Long) {
                                            p.a aVar9 = p.f59656a;
                                            k.a((Object) next, "key");
                                            long longValue = ((Number) opt).longValue();
                                            k.c(next, "key");
                                            k.c(a5, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a5).edit().putLong(next, longValue).apply();
                                            } catch (Exception e5) {
                                                e5.printStackTrace();
                                            }
                                        } else if (opt instanceof Boolean) {
                                            p.a aVar10 = p.f59656a;
                                            k.a((Object) next, "key");
                                            boolean booleanValue = ((Boolean) opt).booleanValue();
                                            k.c(next, "key");
                                            k.c(a5, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a5).edit().putBoolean(next, booleanValue).apply();
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                            }
                                        } else if (opt instanceof String) {
                                            p.a aVar11 = p.f59656a;
                                            k.a((Object) next, "key");
                                            String str3 = (String) opt;
                                            k.c(next, "key");
                                            k.c(str3, "value");
                                            k.c(a5, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                                            try {
                                                p.a.a(a5).edit().putString(next, str3).apply();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                        }
                                        z = true;
                                    }
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            a("success", (Object) Boolean.TRUE);
                            net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, false, 6);
                        } else {
                            a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "cannot handle this data type");
                        }
                        p.a aVar12 = p.f59656a;
                        p.a aVar13 = p.f59656a;
                        p.a.a(p.f59657b).edit().putBoolean(a5, true).apply();
                    }
                }
            }
            a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "invalid params");
        }
        return true;
    }

    private static String a(String str) {
        String b2 = b("fljarvis_" + str + "_flfriday");
        return b2 + "_flh5";
    }

    private static String b(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        Charset charset = d.f47971a;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            k.a((Object) digest, "bytes");
            return a(digest);
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    private static String a(byte[] bArr) {
        return kotlin.a.f.a(bArr, "", a.INSTANCE);
    }
}
