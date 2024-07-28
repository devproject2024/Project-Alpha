package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.e;
import net.one97.paytm.phoenix.util.i;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag extends net.one97.paytm.phoenix.core.a {
    public ag() {
        super("paytmOpenGallery", "paytmShareText", "paytmShareTextAndImage", "paytmCaptureImageFromCamera", "paytmPickFile", "openInBrowser");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        String action$phoenix_debug;
        Activity activity;
        Activity activity2;
        boolean z;
        H5Event h5Event2 = h5Event;
        k.c(h5Event2, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        if (!a(h5Event) || (action$phoenix_debug = h5Event.getAction$phoenix_debug()) == null) {
            return true;
        }
        String str = "*/*";
        switch (action$phoenix_debug.hashCode()) {
            case -724697319:
                if (!action$phoenix_debug.equals("openInBrowser")) {
                    return true;
                }
                JSONObject params = h5Event.getParams();
                if (params == null) {
                    params = new JSONObject();
                }
                String optString = params.optString("url");
                CharSequence charSequence = optString;
                if ((charSequence == null || charSequence.length() == 0) || (activity = h5Event.getActivity()) == null) {
                    return true;
                }
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(optString)));
                    a("success", (Object) Boolean.TRUE);
                    a(h5Event2, (Object) null, true);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success", false);
                    a(h5Event2, jSONObject);
                    return true;
                }
            case 600163783:
                if (!action$phoenix_debug.equals("paytmOpenGallery")) {
                    return true;
                }
                if (a(h5Event2, "android.permission.READ_EXTERNAL_STORAGE")) {
                    JSONObject params2 = h5Event.getParams();
                    if (params2 == null) {
                        params2 = new JSONObject();
                    }
                    int optInt = params2.optInt("requestCode");
                    Object opt = params2.opt("type");
                    if (opt == null) {
                        opt = H5ResourceHandlerUtil.IMAGE;
                    }
                    String optString2 = params2.optString("title");
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    if (k.a(opt, (Object) H5ResourceHandlerUtil.IMAGE)) {
                        str = "image/*";
                    }
                    intent.setType(str);
                    Activity activity3 = h5Event.getActivity();
                    if (activity3 == null || !(activity3 instanceof PhoenixActivity)) {
                        return true;
                    }
                    PhoenixActivity phoenixActivity = (PhoenixActivity) activity3;
                    if (intent.resolveActivity(phoenixActivity.getPackageManager()) != null) {
                        phoenixActivity.p.addObserver(new d(activity3, this, intent, h5Event, optString2, optInt));
                        CharSequence charSequence2 = optString2;
                        if (TextUtils.isEmpty(charSequence2)) {
                            activity3.startActivityForResult(intent, optInt);
                            return true;
                        }
                        activity3.startActivityForResult(Intent.createChooser(intent, charSequence2), optInt);
                        return true;
                    }
                    a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "No matching activity found");
                    return true;
                }
                b(h5Event2, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "Not authorized to access Photos, first use the request permissions bridge to get access to Photos!");
                return true;
            case 700206469:
                if (!action$phoenix_debug.equals("paytmCaptureImageFromCamera")) {
                    return true;
                }
                if (a(h5Event2, "android.permission.CAMERA")) {
                    b(h5Event);
                    return true;
                }
                b(h5Event2, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "CaptureImageFromCameraHandler: Not authorized to access Camera, first use the request permissions bridge to get access to Camera!");
                return true;
            case 1142855791:
                if (!action$phoenix_debug.equals("paytmShareTextAndImage")) {
                    return true;
                }
                JSONObject params3 = h5Event.getParams();
                if (params3 == null) {
                    params3 = new JSONObject();
                }
                String optString3 = params3.optString("subject");
                String optString4 = params3.optString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                String optString5 = params3.optString("title");
                String optString6 = params3.optString(H5ResourceHandlerUtil.IMAGE);
                if (p.a(optString6, "null", true)) {
                    optString6 = "";
                }
                CharSequence charSequence3 = optString6;
                if (TextUtils.isEmpty(charSequence3) || (activity2 = h5Event.getActivity()) == null || androidx.core.content.b.a((Context) activity2, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.SUBJECT", optString3);
                    intent2.putExtra("android.intent.extra.TEXT", optString4);
                    Activity activity4 = h5Event.getActivity();
                    if (activity4 == null) {
                        return true;
                    }
                    if (!TextUtils.isEmpty(charSequence3)) {
                        byte[] decode = Base64.decode(optString6, 0);
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                        i iVar = i.f59645a;
                        k.a((Object) decodeByteArray, "decodedImage");
                        Uri a2 = i.a(activity4, decodeByteArray);
                        if (a2 != null) {
                            intent2.setType("image/png");
                            intent2.putExtra("android.intent.extra.STREAM", a2);
                            intent2.addFlags(1);
                        }
                    }
                    if (intent2.resolveActivity(activity4.getPackageManager()) == null) {
                        return true;
                    }
                    CharSequence charSequence4 = optString5;
                    if (TextUtils.isEmpty(charSequence4)) {
                        activity4.startActivity(intent2);
                    } else {
                        activity4.startActivity(Intent.createChooser(intent2, charSequence4));
                    }
                    a("success", (Object) Boolean.TRUE);
                    net.one97.paytm.phoenix.core.a.a(this, h5Event2, (Object) null, false, 6);
                    return true;
                }
                a(h5Event2, net.one97.paytm.phoenix.api.a.FORBIDDEN, "storage permission needed");
                return true;
            case 1306974590:
                if (!action$phoenix_debug.equals("paytmPickFile")) {
                    return true;
                }
                JSONObject params4 = h5Event.getParams();
                Boolean valueOf = params4 != null ? Boolean.valueOf(params4.has("isChunk")) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue()) {
                    JSONObject params5 = h5Event.getParams();
                    if (k.a(params5 != null ? params5.get("isChunk") : null, (Object) Boolean.TRUE)) {
                        JSONObject params6 = h5Event.getParams();
                        if (params6 == null) {
                            params6 = new JSONObject();
                        }
                        int optInt2 = params6.optInt("requestCode");
                        JSONArray optJSONArray = params6.optJSONArray("extensionsAllowed");
                        long optLong = params6.optLong("maxLengthPerFile");
                        if (optLong <= 0) {
                            optLong = 5242880;
                        }
                        long j = optLong;
                        int optInt3 = params6.optInt("maxNumberOfFiles");
                        int i2 = optInt3 <= 0 ? 5 : optInt3;
                        String optString7 = params6.optString("title");
                        Activity activity5 = h5Event.getActivity();
                        if (activity5 == null) {
                            return true;
                        }
                        if (androidx.core.content.b.a((Context) activity5, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                            a(h5Event2, net.one97.paytm.phoenix.api.a.FORBIDDEN, "Please request storage permission first");
                            return true;
                        }
                        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                        if (Build.VERSION.SDK_INT >= 18) {
                            intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                        }
                        intent3.putExtra("android.intent.extra.LOCAL_ONLY", true);
                        intent3.setType(str);
                        if (!(activity5 instanceof PhoenixActivity)) {
                            return true;
                        }
                        PhoenixActivity phoenixActivity2 = (PhoenixActivity) activity5;
                        if (intent3.resolveActivity(phoenixActivity2.getPackageManager()) != null) {
                            phoenixActivity2.q.addObserver(new c(activity5, this, h5Event, i2, j, optJSONArray, optString7, optInt2));
                            CharSequence charSequence5 = optString7;
                            if (TextUtils.isEmpty(charSequence5)) {
                                activity5.startActivityForResult(intent3, optInt2);
                                return true;
                            }
                            activity5.startActivityForResult(Intent.createChooser(intent3, charSequence5), optInt2);
                            return true;
                        }
                        a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "No matching activity found");
                        return true;
                    }
                }
                JSONObject params7 = h5Event.getParams();
                if (params7 == null) {
                    params7 = new JSONObject();
                }
                int optInt4 = params7.optInt("requestCode");
                JSONArray optJSONArray2 = params7.optJSONArray("extensionsAllowed");
                long optLong2 = params7.optLong("maxLengthPerFile");
                if (optLong2 <= 0) {
                    optLong2 = 5242880;
                }
                long j2 = optLong2;
                int optInt5 = params7.optInt("maxNumberOfFiles");
                int i3 = optInt5 <= 0 ? 5 : optInt5;
                String optString8 = params7.optString("title");
                Activity activity6 = h5Event.getActivity();
                if (activity6 == null) {
                    return true;
                }
                if (androidx.core.content.b.a((Context) activity6, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    a(h5Event2, net.one97.paytm.phoenix.api.a.FORBIDDEN, "Please request storage permission first");
                    return true;
                }
                Intent intent4 = new Intent("android.intent.action.GET_CONTENT");
                if (Build.VERSION.SDK_INT >= 18) {
                    z = true;
                    intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                } else {
                    z = true;
                }
                intent4.putExtra("android.intent.extra.LOCAL_ONLY", z);
                intent4.setType(str);
                if (!(activity6 instanceof PhoenixActivity)) {
                    return true;
                }
                PhoenixActivity phoenixActivity3 = (PhoenixActivity) activity6;
                if (intent4.resolveActivity(phoenixActivity3.getPackageManager()) != null) {
                    phoenixActivity3.q.addObserver(new b(activity6, this, h5Event, i3, j2, optJSONArray2, optString8, optInt4));
                    CharSequence charSequence6 = optString8;
                    if (TextUtils.isEmpty(charSequence6)) {
                        activity6.startActivityForResult(intent4, optInt4);
                        return true;
                    }
                    activity6.startActivityForResult(Intent.createChooser(intent4, charSequence6), optInt4);
                    return true;
                }
                a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "No matching activity found");
                return true;
            case 1739661707:
                if (!action$phoenix_debug.equals("paytmShareText")) {
                    return true;
                }
                JSONObject params8 = h5Event.getParams();
                if (params8 == null) {
                    params8 = new JSONObject();
                }
                String optString9 = params8.optString("subject");
                String optString10 = params8.optString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                String optString11 = params8.optString("title");
                Intent intent5 = new Intent("android.intent.action.SEND");
                intent5.setType("text/plain");
                intent5.putExtra("android.intent.extra.SUBJECT", optString9);
                intent5.putExtra("android.intent.extra.TEXT", optString10);
                Activity activity7 = h5Event.getActivity();
                if (activity7 == null || intent5.resolveActivity(activity7.getPackageManager()) == null) {
                    return true;
                }
                CharSequence charSequence7 = optString11;
                if (TextUtils.isEmpty(charSequence7)) {
                    activity7.startActivity(intent5);
                    return true;
                }
                activity7.startActivity(Intent.createChooser(intent5, charSequence7));
                return true;
            default:
                return true;
        }
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f59468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ag f59469b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f59470c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f59471d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f59472e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONArray f59473f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f59474g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f59475h;

        b(Activity activity, ag agVar, H5Event h5Event, int i2, long j, JSONArray jSONArray, String str, int i3) {
            this.f59468a = activity;
            this.f59469b = agVar;
            this.f59470c = h5Event;
            this.f59471d = i2;
            this.f59472e = j;
            this.f59473f = jSONArray;
            this.f59474g = str;
            this.f59475h = i3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c9, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            kotlin.f.a.a(r3, r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cd, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r14, java.lang.Object r15) {
            /*
                r13 = this;
                java.lang.String r14 = "Error!"
                net.one97.paytm.phoenix.d.ag r0 = r13.f59469b
                boolean r1 = r15 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x011e
                r1 = r15
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                int r1 = r1.size()
                int r2 = r13.f59471d
                if (r1 <= r2) goto L_0x001d
                net.one97.paytm.phoenix.api.H5Event r14 = r13.f59470c
                net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.FORBIDDEN
                java.lang.String r1 = "Number of files exceeded"
                r0.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r1)
                return
            L_0x001d:
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ IOException -> 0x0112 }
                r1.<init>()     // Catch:{ IOException -> 0x0112 }
                java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ IOException -> 0x0112 }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ IOException -> 0x0112 }
            L_0x0028:
                boolean r2 = r15.hasNext()     // Catch:{ IOException -> 0x0112 }
                r3 = 4
                r4 = 0
                if (r2 == 0) goto L_0x010c
                java.lang.Object r2 = r15.next()     // Catch:{ IOException -> 0x0112 }
                java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0112 }
                if (r2 == 0) goto L_0x0104
                r6 = r2
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0112 }
                r5.<init>(r6)     // Catch:{ IOException -> 0x0112 }
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ IOException -> 0x00f8 }
                r6.<init>()     // Catch:{ IOException -> 0x00f8 }
                r7 = 1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x00f8 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r8 = "errorCode"
                java.lang.String r9 = "errorMessage"
                if (r2 == 0) goto L_0x0059
                java.lang.String r2 = "Can't read this file"
                r6.put(r9, r2)     // Catch:{ IOException -> 0x00f8 }
                r6.put(r8, r3)     // Catch:{ IOException -> 0x00f8 }
                r7 = 0
            L_0x0059:
                long r2 = r5.length()     // Catch:{ IOException -> 0x00f8 }
                long r10 = r13.f59472e     // Catch:{ IOException -> 0x00f8 }
                int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x006d
                java.lang.String r2 = "File max size limit exceeded"
                r6.put(r9, r2)     // Catch:{ IOException -> 0x00f8 }
                r2 = 2
                r6.put(r8, r2)     // Catch:{ IOException -> 0x00f8 }
                r7 = 0
            L_0x006d:
                org.json.JSONArray r2 = r13.f59473f     // Catch:{ IOException -> 0x00f8 }
                if (r2 == 0) goto L_0x00a0
                java.lang.String r2 = kotlin.f.b.a(r5)     // Catch:{ IOException -> 0x00f8 }
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x00f8 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x00f8 }
                if (r2 != 0) goto L_0x00a0
                org.json.JSONArray r2 = r13.f59473f     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = "extensionsAllowed.toString()"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ IOException -> 0x00f8 }
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = kotlin.f.b.a(r5)     // Catch:{ IOException -> 0x00f8 }
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IOException -> 0x00f8 }
                boolean r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, false)     // Catch:{ IOException -> 0x00f8 }
                if (r2 != 0) goto L_0x00a0
                java.lang.String r2 = "Extension not supported"
                r6.put(r9, r2)     // Catch:{ IOException -> 0x00f8 }
                r2 = 3
                r6.put(r8, r2)     // Catch:{ IOException -> 0x00f8 }
                r7 = 0
            L_0x00a0:
                if (r7 == 0) goto L_0x00ce
                long r2 = r5.length()     // Catch:{ IOException -> 0x00f8 }
                int r3 = (int) r2     // Catch:{ IOException -> 0x00f8 }
                int r3 = r3 + 100
                byte[] r2 = new byte[r3]     // Catch:{ IOException -> 0x00f8 }
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00f8 }
                r3.<init>(r5)     // Catch:{ IOException -> 0x00f8 }
                java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ IOException -> 0x00f8 }
                r7 = r3
                java.io.FileInputStream r7 = (java.io.FileInputStream) r7     // Catch:{ all -> 0x00c7 }
                int r7 = r7.read(r2)     // Catch:{ all -> 0x00c7 }
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r4, r7, r4)     // Catch:{ all -> 0x00c7 }
                java.lang.String r4 = "base64"
                r6.put(r4, r2)     // Catch:{ all -> 0x00c7 }
                r2 = 0
                kotlin.f.a.a(r3, r2)     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00ce
            L_0x00c7:
                r15 = move-exception
                throw r15     // Catch:{ all -> 0x00c9 }
            L_0x00c9:
                r1 = move-exception
                kotlin.f.a.a(r3, r15)     // Catch:{ IOException -> 0x00f8 }
                throw r1     // Catch:{ IOException -> 0x00f8 }
            L_0x00ce:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ IOException -> 0x00f8 }
                r2.<init>()     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = "fileName"
                java.lang.String r4 = r5.getName()     // Catch:{ IOException -> 0x00f8 }
                r2.put(r3, r4)     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = "fileType"
                java.lang.String r4 = kotlin.f.b.a(r5)     // Catch:{ IOException -> 0x00f8 }
                r2.put(r3, r4)     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = "fileSize"
                long r4 = r5.length()     // Catch:{ IOException -> 0x00f8 }
                r2.put(r3, r4)     // Catch:{ IOException -> 0x00f8 }
                java.lang.String r3 = "meta"
                r6.put(r3, r2)     // Catch:{ IOException -> 0x00f8 }
                r1.put(r6)     // Catch:{ IOException -> 0x00f8 }
                goto L_0x0028
            L_0x00f8:
                r15 = move-exception
                r15.printStackTrace()     // Catch:{ IOException -> 0x0112 }
                net.one97.paytm.phoenix.api.H5Event r15 = r13.f59470c     // Catch:{ IOException -> 0x0112 }
                net.one97.paytm.phoenix.api.a r1 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR     // Catch:{ IOException -> 0x0112 }
                r0.a((net.one97.paytm.phoenix.api.H5Event) r15, (net.one97.paytm.phoenix.api.a) r1, (java.lang.String) r14)     // Catch:{ IOException -> 0x0112 }
                return
            L_0x0104:
                kotlin.u r15 = new kotlin.u     // Catch:{ IOException -> 0x0112 }
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
                r15.<init>(r1)     // Catch:{ IOException -> 0x0112 }
                throw r15     // Catch:{ IOException -> 0x0112 }
            L_0x010c:
                net.one97.paytm.phoenix.api.H5Event r15 = r13.f59470c     // Catch:{ IOException -> 0x0112 }
                net.one97.paytm.phoenix.core.a.a(r0, r15, r1, r4, r3)     // Catch:{ IOException -> 0x0112 }
                goto L_0x012f
            L_0x0112:
                r15 = move-exception
                r15.printStackTrace()
                net.one97.paytm.phoenix.api.H5Event r15 = r13.f59470c
                net.one97.paytm.phoenix.api.a r1 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                r0.a((net.one97.paytm.phoenix.api.H5Event) r15, (net.one97.paytm.phoenix.api.a) r1, (java.lang.String) r14)
                goto L_0x012f
            L_0x011e:
                java.lang.Boolean r14 = java.lang.Boolean.FALSE
                boolean r14 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r14)
                if (r14 == 0) goto L_0x012f
                net.one97.paytm.phoenix.api.H5Event r14 = r13.f59470c
                net.one97.paytm.phoenix.api.a r15 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                java.lang.String r1 = "action cancelled!"
                r0.a((net.one97.paytm.phoenix.api.H5Event) r14, (net.one97.paytm.phoenix.api.a) r15, (java.lang.String) r1)
            L_0x012f:
                android.app.Activity r14 = r13.f59468a
                net.one97.paytm.phoenix.ui.PhoenixActivity r14 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r14
                net.one97.paytm.phoenix.ui.PhoenixActivity$g r14 = r14.q
                java.util.Observable r14 = (java.util.Observable) r14
                r14.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ag.b.update(java.util.Observable, java.lang.Object):void");
        }
    }

    static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f59476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ag f59477b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f59478c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f59479d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f59480e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONArray f59481f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f59482g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f59483h;

        c(Activity activity, ag agVar, H5Event h5Event, int i2, long j, JSONArray jSONArray, String str, int i3) {
            this.f59476a = activity;
            this.f59477b = agVar;
            this.f59478c = h5Event;
            this.f59479d = i2;
            this.f59480e = j;
            this.f59481f = jSONArray;
            this.f59482g = str;
            this.f59483h = i3;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:63|64|(1:66)(3:95|69|70)) */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0152, code lost:
            if (r9 >= r12) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r0 = ((net.one97.paytm.phoenix.ui.PhoenixActivity) r1.f59476a).A;
            r14 = "Chunk_".concat(java.lang.String.valueOf(r11));
            r15 = r7.length() - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x019e, code lost:
            if (r7 != null) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a0, code lost:
            r15 = r7.substring(r9, r15);
            kotlin.g.b.k.a((java.lang.Object) r15, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r0.b(r13.put(r14, r15));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b9, code lost:
            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0188 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r18, java.lang.Object r19) {
            /*
                r17 = this;
                r1 = r17
                r0 = r19
                java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                java.lang.String r4 = "Chunk_"
                java.lang.String r5 = "Error!"
                net.one97.paytm.phoenix.d.ag r6 = r1.f59477b
                boolean r7 = r0 instanceof java.util.ArrayList
                if (r7 == 0) goto L_0x01e9
                r7 = r0
                java.util.ArrayList r7 = (java.util.ArrayList) r7
                int r7 = r7.size()
                int r8 = r1.f59479d
                if (r7 <= r8) goto L_0x0027
                net.one97.paytm.phoenix.api.H5Event r0 = r1.f59478c
                net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.FORBIDDEN
                java.lang.String r3 = "Number of files exceeded"
                r6.a((net.one97.paytm.phoenix.api.H5Event) r0, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r3)
                return
            L_0x0027:
                org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ IOException -> 0x01dd }
                r7.<init>()     // Catch:{ IOException -> 0x01dd }
                java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ IOException -> 0x01dd }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x01dd }
            L_0x0032:
                boolean r7 = r0.hasNext()     // Catch:{ IOException -> 0x01dd }
                if (r7 == 0) goto L_0x01fa
                java.lang.Object r7 = r0.next()     // Catch:{ IOException -> 0x01dd }
                java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x01dd }
                if (r7 == 0) goto L_0x01d5
                r9 = r7
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x01dd }
                r8.<init>(r9)     // Catch:{ IOException -> 0x01dd }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ IOException -> 0x01c9 }
                r9.<init>()     // Catch:{ IOException -> 0x01c9 }
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ IOException -> 0x01c9 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r10 = "errorCode"
                java.lang.String r11 = "errorMessage"
                if (r7 == 0) goto L_0x0062
                java.lang.String r7 = "Can't read this file"
                r9.put(r11, r7)     // Catch:{ IOException -> 0x01c9 }
                r7 = 4
                r9.put(r10, r7)     // Catch:{ IOException -> 0x01c9 }
                r7 = 0
                goto L_0x0063
            L_0x0062:
                r7 = 1
            L_0x0063:
                long r14 = r8.length()     // Catch:{ IOException -> 0x01c9 }
                long r12 = r1.f59480e     // Catch:{ IOException -> 0x01c9 }
                int r16 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
                if (r16 <= 0) goto L_0x0078
                java.lang.String r7 = "File max size limit exceeded"
                r9.put(r11, r7)     // Catch:{ IOException -> 0x01c9 }
                r7 = 2
                r9.put(r10, r7)     // Catch:{ IOException -> 0x01c9 }
                r13 = 0
                goto L_0x0079
            L_0x0078:
                r13 = r7
            L_0x0079:
                org.json.JSONArray r7 = r1.f59481f     // Catch:{ IOException -> 0x01c9 }
                if (r7 == 0) goto L_0x00ac
                java.lang.String r7 = kotlin.f.b.a(r8)     // Catch:{ IOException -> 0x01c9 }
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ IOException -> 0x01c9 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x01c9 }
                if (r7 != 0) goto L_0x00ac
                org.json.JSONArray r7 = r1.f59481f     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = "extensionsAllowed.toString()"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r12)     // Catch:{ IOException -> 0x01c9 }
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = kotlin.f.b.a(r8)     // Catch:{ IOException -> 0x01c9 }
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ IOException -> 0x01c9 }
                boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r12, false)     // Catch:{ IOException -> 0x01c9 }
                if (r7 != 0) goto L_0x00ac
                java.lang.String r7 = "Extension not supported"
                r9.put(r11, r7)     // Catch:{ IOException -> 0x01c9 }
                r7 = 3
                r9.put(r10, r7)     // Catch:{ IOException -> 0x01c9 }
                r13 = 0
            L_0x00ac:
                if (r13 == 0) goto L_0x01c3
                long r9 = r8.length()     // Catch:{ IOException -> 0x01c9 }
                int r7 = (int) r9     // Catch:{ IOException -> 0x01c9 }
                int r7 = r7 + 100
                byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x01c9 }
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ IOException -> 0x01c9 }
                r9.<init>(r8)     // Catch:{ IOException -> 0x01c9 }
                java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ IOException -> 0x01c9 }
                r10 = r9
                java.io.FileInputStream r10 = (java.io.FileInputStream) r10     // Catch:{ all -> 0x01ba }
                int r10 = r10.read(r7)     // Catch:{ all -> 0x01ba }
                r11 = 0
                java.lang.String r7 = android.util.Base64.encodeToString(r7, r11, r10, r11)     // Catch:{ all -> 0x01ba }
                java.lang.String r10 = "android.util.Base64.enco…                        )"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ all -> 0x01ba }
                kotlin.x r10 = kotlin.x.f47997a     // Catch:{ all -> 0x01ba }
                r10 = 0
                kotlin.f.a.a(r9, r10)     // Catch:{ IOException -> 0x01c9 }
                int r9 = r7.length()     // Catch:{ IOException -> 0x01c9 }
                r10 = 48000(0xbb80, float:6.7262E-41)
                int r9 = r9 / r10
                int r11 = r7.length()     // Catch:{ IOException -> 0x01c9 }
                int r11 = r11 % r10
                if (r11 == 0) goto L_0x00e6
                int r9 = r9 + 1
            L_0x00e6:
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ IOException -> 0x01c9 }
                r11.<init>()     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = "fileName"
                java.lang.String r13 = r8.getName()     // Catch:{ IOException -> 0x01c9 }
                r11.put(r12, r13)     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = "fileType"
                java.lang.String r13 = kotlin.f.b.a(r8)     // Catch:{ IOException -> 0x01c9 }
                r11.put(r12, r13)     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = "fileSize"
                long r13 = r8.length()     // Catch:{ IOException -> 0x01c9 }
                r11.put(r12, r13)     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r8 = "total_chunks"
                r11.put(r8, r9)     // Catch:{ IOException -> 0x01c9 }
                android.app.Activity r8 = r1.f59476a     // Catch:{ IOException -> 0x01c9 }
                net.one97.paytm.phoenix.ui.PhoenixActivity r8 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r8     // Catch:{ IOException -> 0x01c9 }
                net.one97.paytm.phoenix.ui.PhoenixActivity$f r8 = r8.A     // Catch:{ IOException -> 0x01c9 }
                r8.b(r11)     // Catch:{ IOException -> 0x01c9 }
                kotlin.j.d r8 = new kotlin.j.d     // Catch:{ IOException -> 0x01c9 }
                int r9 = r7.length()     // Catch:{ IOException -> 0x01c9 }
                r11 = 0
                r8.<init>(r11, r9)     // Catch:{ IOException -> 0x01c9 }
                kotlin.j.b r8 = (kotlin.j.b) r8     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r9 = "$this$step"
                kotlin.g.b.k.d(r8, r9)     // Catch:{ IOException -> 0x01c9 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x01c9 }
                java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r12 = "step"
                kotlin.g.b.k.d(r9, r12)     // Catch:{ IOException -> 0x01c9 }
                kotlin.j.b$a r9 = kotlin.j.b.f47938d     // Catch:{ IOException -> 0x01c9 }
                int r9 = r8.f47939a     // Catch:{ IOException -> 0x01c9 }
                int r12 = r8.f47940b     // Catch:{ IOException -> 0x01c9 }
                int r8 = r8.f47941c     // Catch:{ IOException -> 0x01c9 }
                if (r8 <= 0) goto L_0x0140
                r8 = 48000(0xbb80, float:6.7262E-41)
                goto L_0x0143
            L_0x0140:
                r8 = -48000(0xffffffffffff4480, float:NaN)
            L_0x0143:
                kotlin.j.b r8 = kotlin.j.b.a.a(r9, r12, r8)     // Catch:{ IOException -> 0x01c9 }
                int r9 = r8.f47939a     // Catch:{ IOException -> 0x01c9 }
                int r12 = r8.f47940b     // Catch:{ IOException -> 0x01c9 }
                int r8 = r8.f47941c     // Catch:{ IOException -> 0x01c9 }
                if (r8 < 0) goto L_0x0152
                if (r9 > r12) goto L_0x01c3
                goto L_0x0154
            L_0x0152:
                if (r9 < r12) goto L_0x01c3
            L_0x0154:
                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ IOException -> 0x01c9 }
                r13.<init>()     // Catch:{ IOException -> 0x01c9 }
                r14 = 1
                int r11 = r11 + r14
                android.app.Activity r14 = r1.f59476a     // Catch:{ Exception -> 0x0186 }
                net.one97.paytm.phoenix.ui.PhoenixActivity r14 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r14     // Catch:{ Exception -> 0x0186 }
                net.one97.paytm.phoenix.ui.PhoenixActivity$f r14 = r14.A     // Catch:{ Exception -> 0x0186 }
                java.lang.String r15 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0186 }
                java.lang.String r15 = r4.concat(r15)     // Catch:{ Exception -> 0x0186 }
                r19 = r0
                int r0 = r9 + r10
                if (r7 == 0) goto L_0x0180
                java.lang.String r0 = r7.substring(r9, r0)     // Catch:{ Exception -> 0x0188 }
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0188 }
                org.json.JSONObject r0 = r13.put(r15, r0)     // Catch:{ Exception -> 0x0188 }
                r14.b(r0)     // Catch:{ Exception -> 0x0188 }
                r16 = 1
                goto L_0x01ae
            L_0x0180:
                kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x0188 }
                r0.<init>(r2)     // Catch:{ Exception -> 0x0188 }
                throw r0     // Catch:{ Exception -> 0x0188 }
            L_0x0186:
                r19 = r0
            L_0x0188:
                android.app.Activity r0 = r1.f59476a     // Catch:{ IOException -> 0x01c9 }
                net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0     // Catch:{ IOException -> 0x01c9 }
                net.one97.paytm.phoenix.ui.PhoenixActivity$f r0 = r0.A     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r14 = java.lang.String.valueOf(r11)     // Catch:{ IOException -> 0x01c9 }
                java.lang.String r14 = r4.concat(r14)     // Catch:{ IOException -> 0x01c9 }
                int r15 = r7.length()     // Catch:{ IOException -> 0x01c9 }
                r16 = 1
                int r15 = r15 + -1
                if (r7 == 0) goto L_0x01b4
                java.lang.String r15 = r7.substring(r9, r15)     // Catch:{ IOException -> 0x01c9 }
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)     // Catch:{ IOException -> 0x01c9 }
                org.json.JSONObject r13 = r13.put(r14, r15)     // Catch:{ IOException -> 0x01c9 }
                r0.b(r13)     // Catch:{ IOException -> 0x01c9 }
            L_0x01ae:
                if (r9 == r12) goto L_0x01c5
                int r9 = r9 + r8
                r0 = r19
                goto L_0x0154
            L_0x01b4:
                kotlin.u r0 = new kotlin.u     // Catch:{ IOException -> 0x01c9 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x01c9 }
                throw r0     // Catch:{ IOException -> 0x01c9 }
            L_0x01ba:
                r0 = move-exception
                r2 = r0
                throw r2     // Catch:{ all -> 0x01bd }
            L_0x01bd:
                r0 = move-exception
                r3 = r0
                kotlin.f.a.a(r9, r2)     // Catch:{ IOException -> 0x01c9 }
                throw r3     // Catch:{ IOException -> 0x01c9 }
            L_0x01c3:
                r19 = r0
            L_0x01c5:
                r0 = r19
                goto L_0x0032
            L_0x01c9:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ IOException -> 0x01dd }
                net.one97.paytm.phoenix.api.H5Event r0 = r1.f59478c     // Catch:{ IOException -> 0x01dd }
                net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR     // Catch:{ IOException -> 0x01dd }
                r6.a((net.one97.paytm.phoenix.api.H5Event) r0, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r5)     // Catch:{ IOException -> 0x01dd }
                return
            L_0x01d5:
                kotlin.u r0 = new kotlin.u     // Catch:{ IOException -> 0x01dd }
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
                r0.<init>(r2)     // Catch:{ IOException -> 0x01dd }
                throw r0     // Catch:{ IOException -> 0x01dd }
            L_0x01dd:
                r0 = move-exception
                r0.printStackTrace()
                net.one97.paytm.phoenix.api.H5Event r0 = r1.f59478c
                net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                r6.a((net.one97.paytm.phoenix.api.H5Event) r0, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r5)
                goto L_0x01fa
            L_0x01e9:
                java.lang.Boolean r2 = java.lang.Boolean.FALSE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
                if (r0 == 0) goto L_0x01fa
                net.one97.paytm.phoenix.api.H5Event r0 = r1.f59478c
                net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                java.lang.String r3 = "action cancelled!"
                r6.a((net.one97.paytm.phoenix.api.H5Event) r0, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r3)
            L_0x01fa:
                android.app.Activity r0 = r1.f59476a
                net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
                net.one97.paytm.phoenix.ui.PhoenixActivity$g r0 = r0.q
                java.util.Observable r0 = (java.util.Observable) r0
                r0.deleteObservers()
                android.app.Activity r0 = r1.f59476a
                net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
                net.one97.paytm.phoenix.ui.PhoenixActivity$f r0 = r0.A
                java.util.Observable r0 = (java.util.Observable) r0
                r0.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ag.c.update(java.util.Observable, java.lang.Object):void");
        }
    }

    static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f59484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ag f59485b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Intent f59486c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59487d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f59488e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f59489f;

        d(Activity activity, ag agVar, Intent intent, H5Event h5Event, String str, int i2) {
            this.f59484a = activity;
            this.f59485b = agVar;
            this.f59486c = intent;
            this.f59487d = h5Event;
            this.f59488e = str;
            this.f59489f = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x008b, code lost:
            r10 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            kotlin.f.a.a(r2, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008f, code lost:
            throw r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r9, java.lang.Object r10) {
            /*
                r8 = this;
                java.lang.String r9 = "base64"
                net.one97.paytm.phoenix.d.ag r0 = r8.f59485b
                boolean r1 = r10 instanceof java.lang.String
                if (r1 == 0) goto L_0x00a8
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x009a }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ IOException -> 0x009a }
                r1.<init>(r10)     // Catch:{ IOException -> 0x009a }
                java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009a }
                r10.<init>(r1)     // Catch:{ IOException -> 0x009a }
                android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x009a }
                r2.<init>()     // Catch:{ IOException -> 0x009a }
                r3 = 1
                r2.inJustDecodeBounds = r3     // Catch:{ IOException -> 0x009a }
                r3 = r10
                java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ IOException -> 0x009a }
                r4 = 0
                android.graphics.BitmapFactory.decodeStream(r3, r4, r2)     // Catch:{ IOException -> 0x009a }
                r10.close()     // Catch:{ IOException -> 0x009a }
                java.lang.String r10 = r2.outMimeType     // Catch:{ IOException -> 0x009a }
                if (r10 == 0) goto L_0x0090
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ IOException -> 0x009a }
                java.lang.String r2 = "image"
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x009a }
                boolean r10 = kotlin.m.p.a((java.lang.CharSequence) r10, (java.lang.CharSequence) r2, false)     // Catch:{ IOException -> 0x009a }
                if (r10 == 0) goto L_0x0090
                long r2 = r1.length()     // Catch:{ IOException -> 0x009a }
                int r10 = (int) r2     // Catch:{ IOException -> 0x009a }
                int r10 = r10 + 100
                byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x009a }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009a }
                r2.<init>(r1)     // Catch:{ IOException -> 0x009a }
                java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ IOException -> 0x009a }
                r3 = r2
                java.io.FileInputStream r3 = (java.io.FileInputStream) r3     // Catch:{ all -> 0x0089 }
                int r3 = r3.read(r10)     // Catch:{ all -> 0x0089 }
                r5 = 0
                java.lang.String r10 = android.util.Base64.encodeToString(r10, r5, r3, r5)     // Catch:{ all -> 0x0089 }
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)     // Catch:{ all -> 0x0089 }
                r0.a((java.lang.String) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x0089 }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
                r9.<init>()     // Catch:{ all -> 0x0089 }
                java.lang.String r10 = "imageName"
                java.lang.String r3 = r1.getName()     // Catch:{ all -> 0x0089 }
                r9.put(r10, r3)     // Catch:{ all -> 0x0089 }
                java.lang.String r10 = "imageType"
                java.lang.String r3 = kotlin.f.b.a(r1)     // Catch:{ all -> 0x0089 }
                r9.put(r10, r3)     // Catch:{ all -> 0x0089 }
                java.lang.String r10 = "imageSize"
                long r6 = r1.length()     // Catch:{ all -> 0x0089 }
                r9.put(r10, r6)     // Catch:{ all -> 0x0089 }
                java.lang.String r10 = "meta"
                r0.a((java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0089 }
                net.one97.paytm.phoenix.api.H5Event r9 = r8.f59487d     // Catch:{ all -> 0x0089 }
                r10 = 6
                net.one97.paytm.phoenix.core.a.a(r0, r9, r4, r5, r10)     // Catch:{ all -> 0x0089 }
                kotlin.x r9 = kotlin.x.f47997a     // Catch:{ all -> 0x0089 }
                kotlin.f.a.a(r2, r4)     // Catch:{ IOException -> 0x009a }
                goto L_0x00b9
            L_0x0089:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x008b }
            L_0x008b:
                r10 = move-exception
                kotlin.f.a.a(r2, r9)     // Catch:{ IOException -> 0x009a }
                throw r10     // Catch:{ IOException -> 0x009a }
            L_0x0090:
                net.one97.paytm.phoenix.api.H5Event r9 = r8.f59487d     // Catch:{ IOException -> 0x009a }
                net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.FORBIDDEN     // Catch:{ IOException -> 0x009a }
                java.lang.String r1 = "Not an image file!"
                r0.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)     // Catch:{ IOException -> 0x009a }
                goto L_0x00b9
            L_0x009a:
                r9 = move-exception
                r9.printStackTrace()
                net.one97.paytm.phoenix.api.H5Event r9 = r8.f59487d
                net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                java.lang.String r1 = "Error!"
                r0.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)
                goto L_0x00b9
            L_0x00a8:
                java.lang.Boolean r9 = java.lang.Boolean.FALSE
                boolean r9 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r9)
                if (r9 == 0) goto L_0x00b9
                net.one97.paytm.phoenix.api.H5Event r9 = r8.f59487d
                net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
                java.lang.String r1 = "action cancelled!"
                r0.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)
            L_0x00b9:
                android.app.Activity r9 = r8.f59484a
                net.one97.paytm.phoenix.ui.PhoenixActivity r9 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r9
                net.one97.paytm.phoenix.ui.PhoenixActivity$h r9 = r9.p
                java.util.Observable r9 = (java.util.Observable) r9
                r9.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ag.d.update(java.util.Observable, java.lang.Object):void");
        }
    }

    private static boolean a(H5Event h5Event, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        boolean z = false;
        for (String str2 : arrayList) {
            Activity activity = h5Event.getActivity();
            if (activity != null && androidx.core.content.b.a((Context) activity, str2) == 0) {
                z = true;
            }
        }
        return z;
    }

    private final void b(H5Event h5Event) {
        File file;
        H5Event h5Event2 = h5Event;
        JSONObject params = h5Event.getParams();
        if (params == null) {
            params = new JSONObject();
        }
        int optInt = params.optInt("requestCode");
        Object opt = params.opt("useFrontCamera");
        Uri uri = null;
        if (!(opt instanceof Boolean)) {
            opt = null;
        }
        Boolean bool = (Boolean) opt;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        params.optString("title");
        String action$phoenix_debug = h5Event.getAction$phoenix_debug();
        Activity activity = h5Event.getActivity();
        if (activity != null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "No matching activity found");
            } else if (intent.resolveActivity(activity.getPackageManager()) != null) {
                try {
                    i iVar = i.f59645a;
                    file = i.a(activity, (String) null, ".jpg", 2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Exception while creating file");
                    file = null;
                }
                if (file != null) {
                    try {
                        uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        a(h5Event2, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Exception while getting uri for file");
                    }
                    if (uri != null) {
                        intent.putExtra("output", uri);
                        for (ResolveInfo resolveInfo : activity.getPackageManager().queryIntentActivities(intent, 65536)) {
                            activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
                        }
                        if (activity instanceof PhoenixActivity) {
                            PhoenixActivity phoenixActivity = (PhoenixActivity) activity;
                            phoenixActivity.o.addObserver(new a(file, intent, activity, this, h5Event, booleanValue, optInt, action$phoenix_debug));
                            if (booleanValue) {
                                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                            }
                            phoenixActivity.a(intent, optInt, action$phoenix_debug);
                        }
                    }
                }
            }
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f59460a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f59461b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f59462c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ag f59463d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f59464e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f59465f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f59466g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f59467h;

        a(File file, Intent intent, Activity activity, ag agVar, H5Event h5Event, boolean z, int i2, String str) {
            this.f59460a = file;
            this.f59461b = intent;
            this.f59462c = activity;
            this.f59463d = agVar;
            this.f59464e = h5Event;
            this.f59465f = z;
            this.f59466g = i2;
            this.f59467h = str;
        }

        public final void update(Observable observable, Object obj) {
            ag agVar = this.f59463d;
            if (k.a(obj, (Object) Boolean.TRUE)) {
                try {
                    Bitmap a2 = e.a(this.f59460a);
                    x.d dVar = new x.d();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (a2 != null) {
                        a2.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String encodeToString = Base64.encodeToString(byteArray, 0);
                    k.a((Object) encodeToString, "Base64.encodeToString(byteArray, Base64.DEFAULT)");
                    agVar.a(ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64, (Object) encodeToString);
                    dVar.element = (long) byteArray.length;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("imageName", this.f59460a.getName());
                    jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_TYPE, kotlin.f.b.a(this.f59460a));
                    jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_IMAGE_SIZE, dVar.element);
                    agVar.a("meta", (Object) jSONObject);
                    net.one97.paytm.phoenix.core.a.a(agVar, this.f59464e, (Object) null, false, 6);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    agVar.a(this.f59464e, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Error!");
                }
            } else {
                agVar.a(this.f59464e, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "action cancelled!");
            }
            ((PhoenixActivity) this.f59462c).o.deleteObservers();
        }
    }
}
