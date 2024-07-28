package net.one97.paytm.h5paytmsdk.b;

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
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class k extends ad {
    public k() {
        super("paytmOpenGallery", "paytmShareText", "paytmShareTextAndImage", "paytmCaptureImageFromCamera", "paytmPickFile");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action;
        boolean z;
        H5Event h5Event2 = h5Event;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!(!b(h5Event) || h5Event2 == null || (action = h5Event.getAction()) == null)) {
            int hashCode = action.hashCode();
            String str = "*/*";
            String str2 = H5ResourceHandlerUtil.IMAGE;
            switch (hashCode) {
                case 600163783:
                    String str3 = str2;
                    if (action.equals("paytmOpenGallery")) {
                        if (!a(h5Event2, "android.permission.READ_EXTERNAL_STORAGE")) {
                            a(2, "Not authorized to access Photos, first use the request permissions bridge to get access to Photos!");
                            break;
                        } else {
                            e param = h5Event.getParam();
                            String action2 = h5Event.getAction();
                            Integer integer = param.getInteger("requestCode");
                            String string = param.getString("type");
                            if (string == null) {
                                string = str3;
                            }
                            String string2 = param.getString("title");
                            Intent intent = new Intent("android.intent.action.GET_CONTENT");
                            if (string.hashCode() == 100313435 && string.equals(str3)) {
                                str = "image/*";
                            }
                            intent.setType(str);
                            Activity activity = h5Event.getActivity();
                            if (activity != null && (activity instanceof PaytmH5Activity)) {
                                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                                if (intent.resolveActivity(paytmH5Activity.getPackageManager()) == null) {
                                    a(H5Event.Error.UNKNOWN_ERROR, "No matching activity found");
                                    break;
                                } else {
                                    paytmH5Activity.f17105c.addObserver(new c(activity, this, intent, string2, integer, action2));
                                    CharSequence charSequence = string2;
                                    if (!TextUtils.isEmpty(charSequence)) {
                                        Intent createChooser = Intent.createChooser(intent, charSequence);
                                        kotlin.g.b.k.a((Object) integer, "requestCode");
                                        int intValue = integer.intValue();
                                        kotlin.g.b.k.a((Object) action2, "actionName");
                                        paytmH5Activity.a(createChooser, intValue, action2);
                                        break;
                                    } else {
                                        kotlin.g.b.k.a((Object) integer, "requestCode");
                                        int intValue2 = integer.intValue();
                                        kotlin.g.b.k.a((Object) action2, "actionName");
                                        paytmH5Activity.a(intent, intValue2, action2);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 700206469:
                    if (action.equals("paytmCaptureImageFromCamera")) {
                        if (!a(h5Event2, "android.permission.CAMERA")) {
                            a(2, "CaptureImageFromCameraHandler: Not authorized to access Camera, first use the request permissions bridge to get access to Camera!");
                            break;
                        } else {
                            c(h5Event);
                            break;
                        }
                    }
                    break;
                case 1142855791:
                    if (action.equals("paytmShareTextAndImage")) {
                        e param2 = h5Event.getParam();
                        String string3 = param2.getString("subject");
                        String string4 = param2.getString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                        String string5 = param2.getString("title");
                        String string6 = param2.getString(str2);
                        CharSequence charSequence2 = string6;
                        if (!TextUtils.isEmpty(charSequence2) && androidx.core.content.b.a((Context) h5Event.getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                            a(H5Event.Error.FORBIDDEN, "storage permission needed");
                            break;
                        } else {
                            Intent intent2 = new Intent("android.intent.action.SEND");
                            intent2.setType("text/plain");
                            intent2.putExtra("android.intent.extra.SUBJECT", string3);
                            intent2.putExtra("android.intent.extra.TEXT", string4);
                            Activity activity2 = h5Event.getActivity();
                            if (activity2 != null) {
                                if (!TextUtils.isEmpty(charSequence2)) {
                                    byte[] decode = Base64.decode(string6, 0);
                                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                                    net.one97.paytm.h5paytmsdk.d.c cVar = net.one97.paytm.h5paytmsdk.d.c.f17098a;
                                    kotlin.g.b.k.a((Object) decodeByteArray, "decodedImage");
                                    Uri a2 = net.one97.paytm.h5paytmsdk.d.c.a(activity2, decodeByteArray);
                                    if (a2 != null) {
                                        intent2.setType("image/png");
                                        intent2.putExtra("android.intent.extra.STREAM", a2);
                                        intent2.addFlags(1);
                                    }
                                }
                                if (intent2.resolveActivity(activity2.getPackageManager()) != null) {
                                    CharSequence charSequence3 = string5;
                                    if (TextUtils.isEmpty(charSequence3)) {
                                        activity2.startActivity(intent2);
                                    } else {
                                        activity2.startActivity(Intent.createChooser(intent2, charSequence3));
                                    }
                                    a("success", (Object) Boolean.TRUE);
                                    a((Object) null);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 1306974590:
                    if (action.equals("paytmPickFile")) {
                        e param3 = h5Event.getParam();
                        String action3 = h5Event.getAction();
                        Integer integer2 = param3.getInteger("requestCode");
                        com.alibaba.a.b jSONArray = param3.getJSONArray("extensionsAllowed");
                        Long l = param3.getLong("maxLengthPerFile");
                        if (l == null || l.longValue() <= 0) {
                            l = 5242880L;
                        }
                        Long l2 = l;
                        int intValue3 = param3.getIntValue("maxNumberOfFiles");
                        int i2 = intValue3 <= 0 ? 5 : intValue3;
                        String string7 = param3.getString("title");
                        Activity activity3 = h5Event.getActivity();
                        if (activity3 != null) {
                            if (androidx.core.content.b.a((Context) activity3, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                                Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                                if (Build.VERSION.SDK_INT >= 18) {
                                    z = true;
                                    intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                                } else {
                                    z = true;
                                }
                                intent3.putExtra("android.intent.extra.LOCAL_ONLY", z);
                                intent3.setType(str);
                                if (activity3 instanceof PaytmH5Activity) {
                                    PaytmH5Activity paytmH5Activity2 = (PaytmH5Activity) activity3;
                                    if (intent3.resolveActivity(paytmH5Activity2.getPackageManager()) == null) {
                                        a(H5Event.Error.UNKNOWN_ERROR, "No matching activity found");
                                        break;
                                    } else {
                                        PaytmH5Activity paytmH5Activity3 = paytmH5Activity2;
                                        paytmH5Activity2.f17106d.addObserver(new b(activity3, this, i2, l2, jSONArray, string7, integer2, action3));
                                        CharSequence charSequence4 = string7;
                                        if (TextUtils.isEmpty(charSequence4)) {
                                            kotlin.g.b.k.a((Object) integer2, "requestCode");
                                            int intValue4 = integer2.intValue();
                                            kotlin.g.b.k.a((Object) action3, "actionName");
                                            paytmH5Activity3.a(intent3, intValue4, action3);
                                        } else {
                                            Intent createChooser2 = Intent.createChooser(intent3, charSequence4);
                                            kotlin.g.b.k.a((Object) integer2, "requestCode");
                                            int intValue5 = integer2.intValue();
                                            kotlin.g.b.k.a((Object) action3, "actionName");
                                            paytmH5Activity3.a(createChooser2, intValue5, action3);
                                        }
                                        return true;
                                    }
                                }
                            } else {
                                a(H5Event.Error.FORBIDDEN, "Please request storage permission first");
                                break;
                            }
                        }
                    }
                    break;
                case 1739661707:
                    if (action.equals("paytmShareText")) {
                        e param4 = h5Event.getParam();
                        String string8 = param4.getString("subject");
                        String string9 = param4.getString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                        String string10 = param4.getString("title");
                        Intent intent4 = new Intent("android.intent.action.SEND");
                        intent4.setType("text/plain");
                        intent4.putExtra("android.intent.extra.SUBJECT", string8);
                        intent4.putExtra("android.intent.extra.TEXT", string9);
                        Activity activity4 = h5Event.getActivity();
                        if (!(activity4 == null || intent4.resolveActivity(activity4.getPackageManager()) == null)) {
                            CharSequence charSequence5 = string10;
                            if (!TextUtils.isEmpty(charSequence5)) {
                                activity4.startActivity(Intent.createChooser(intent4, charSequence5));
                                break;
                            } else {
                                activity4.startActivity(intent4);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return true;
    }

    private static boolean a(H5Event h5Event, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        boolean z = false;
        for (String a2 : arrayList) {
            if (androidx.core.content.b.a(h5Event.getActivity(), a2) == 0) {
                z = true;
            }
        }
        return z;
    }

    static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17008a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f17009b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17010c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Long f17011d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.alibaba.a.b f17012e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f17013f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Integer f17014g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f17015h;

        b(Activity activity, k kVar, int i2, Long l, com.alibaba.a.b bVar, String str, Integer num, String str2) {
            this.f17008a = activity;
            this.f17009b = kVar;
            this.f17010c = i2;
            this.f17011d = l;
            this.f17012e = bVar;
            this.f17013f = str;
            this.f17014g = num;
            this.f17015h = str2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e1, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            kotlin.f.a.a(r5, r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e5, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r14, java.lang.Object r15) {
            /*
                r13 = this;
                java.lang.String r14 = "Error!"
                net.one97.paytm.h5paytmsdk.b.k r0 = r13.f17009b
                boolean r1 = r15 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0140
                r1 = r15
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                int r1 = r1.size()
                int r2 = r13.f17010c
                if (r1 <= r2) goto L_0x001b
                com.alipay.mobile.h5container.api.H5Event$Error r14 = com.alipay.mobile.h5container.api.H5Event.Error.FORBIDDEN
                java.lang.String r15 = "Number of files exceeded"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r14, (java.lang.String) r15)
                return
            L_0x001b:
                com.alibaba.a.b r1 = new com.alibaba.a.b     // Catch:{ IOException -> 0x0136 }
                r1.<init>()     // Catch:{ IOException -> 0x0136 }
                java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ IOException -> 0x0136 }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ IOException -> 0x0136 }
            L_0x0026:
                boolean r2 = r15.hasNext()     // Catch:{ IOException -> 0x0136 }
                if (r2 == 0) goto L_0x0132
                java.lang.Object r2 = r15.next()     // Catch:{ IOException -> 0x0136 }
                java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0136 }
                if (r2 == 0) goto L_0x012a
                r4 = r2
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0136 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x0136 }
                com.alibaba.a.e r4 = new com.alibaba.a.e     // Catch:{ IOException -> 0x0120 }
                r4.<init>()     // Catch:{ IOException -> 0x0120 }
                r5 = 1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x0120 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0120 }
                java.lang.String r6 = "errorCode"
                java.lang.String r7 = "errorMessage"
                r8 = 0
                if (r2 == 0) goto L_0x0061
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                java.lang.String r5 = "Can't read this file"
                r2.put(r7, r5)     // Catch:{ IOException -> 0x0120 }
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                r5 = 4
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x0120 }
                r2.put(r6, r5)     // Catch:{ IOException -> 0x0120 }
                r5 = 0
            L_0x0061:
                long r9 = r3.length()     // Catch:{ IOException -> 0x0120 }
                java.lang.Long r2 = r13.f17011d     // Catch:{ IOException -> 0x0120 }
                long r11 = r2.longValue()     // Catch:{ IOException -> 0x0120 }
                int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r2 <= 0) goto L_0x0083
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                java.lang.String r5 = "File max size limit exceeded"
                r2.put(r7, r5)     // Catch:{ IOException -> 0x0120 }
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                r5 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x0120 }
                r2.put(r6, r5)     // Catch:{ IOException -> 0x0120 }
                r5 = 0
            L_0x0083:
                com.alibaba.a.b r2 = r13.f17012e     // Catch:{ IOException -> 0x0120 }
                if (r2 == 0) goto L_0x00b3
                java.lang.String r2 = kotlin.f.b.a(r3)     // Catch:{ IOException -> 0x0120 }
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x0120 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0120 }
                if (r2 != 0) goto L_0x00b3
                com.alibaba.a.b r2 = r13.f17012e     // Catch:{ IOException -> 0x0120 }
                java.lang.String r9 = kotlin.f.b.a(r3)     // Catch:{ IOException -> 0x0120 }
                boolean r2 = r2.contains(r9)     // Catch:{ IOException -> 0x0120 }
                if (r2 != 0) goto L_0x00b3
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                java.lang.String r5 = "Extension not supported"
                r2.put(r7, r5)     // Catch:{ IOException -> 0x0120 }
                r2 = r4
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x0120 }
                r5 = 3
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x0120 }
                r2.put(r6, r5)     // Catch:{ IOException -> 0x0120 }
                r5 = 0
            L_0x00b3:
                if (r5 == 0) goto L_0x00e6
                long r5 = r3.length()     // Catch:{ IOException -> 0x0120 }
                int r2 = (int) r5     // Catch:{ IOException -> 0x0120 }
                int r2 = r2 + 100
                byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0120 }
                java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0120 }
                r5.<init>(r3)     // Catch:{ IOException -> 0x0120 }
                java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ IOException -> 0x0120 }
                r6 = r5
                java.io.FileInputStream r6 = (java.io.FileInputStream) r6     // Catch:{ all -> 0x00df }
                int r6 = r6.read(r2)     // Catch:{ all -> 0x00df }
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r8, r6, r8)     // Catch:{ all -> 0x00df }
                r6 = r4
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00df }
                java.lang.String r7 = "base64"
                r6.put(r7, r2)     // Catch:{ all -> 0x00df }
                kotlin.x r2 = kotlin.x.f47997a     // Catch:{ all -> 0x00df }
                r2 = 0
                kotlin.f.a.a(r5, r2)     // Catch:{ IOException -> 0x0120 }
                goto L_0x00e6
            L_0x00df:
                r15 = move-exception
                throw r15     // Catch:{ all -> 0x00e1 }
            L_0x00e1:
                r1 = move-exception
                kotlin.f.a.a(r5, r15)     // Catch:{ IOException -> 0x0120 }
                throw r1     // Catch:{ IOException -> 0x0120 }
            L_0x00e6:
                com.alibaba.a.e r2 = new com.alibaba.a.e     // Catch:{ IOException -> 0x0120 }
                r2.<init>()     // Catch:{ IOException -> 0x0120 }
                r5 = r2
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ IOException -> 0x0120 }
                java.lang.String r6 = "fileName"
                java.lang.String r7 = r3.getName()     // Catch:{ IOException -> 0x0120 }
                r5.put(r6, r7)     // Catch:{ IOException -> 0x0120 }
                r5 = r2
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ IOException -> 0x0120 }
                java.lang.String r6 = "fileType"
                java.lang.String r7 = kotlin.f.b.a(r3)     // Catch:{ IOException -> 0x0120 }
                r5.put(r6, r7)     // Catch:{ IOException -> 0x0120 }
                r5 = r2
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ IOException -> 0x0120 }
                java.lang.String r6 = "fileSize"
                long r7 = r3.length()     // Catch:{ IOException -> 0x0120 }
                java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x0120 }
                r5.put(r6, r3)     // Catch:{ IOException -> 0x0120 }
                r3 = r4
                java.util.Map r3 = (java.util.Map) r3     // Catch:{ IOException -> 0x0120 }
                java.lang.String r5 = "meta"
                r3.put(r5, r2)     // Catch:{ IOException -> 0x0120 }
                r1.add(r4)     // Catch:{ IOException -> 0x0120 }
                goto L_0x0026
            L_0x0120:
                r15 = move-exception
                r15.printStackTrace()     // Catch:{ IOException -> 0x0136 }
                com.alipay.mobile.h5container.api.H5Event$Error r15 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR     // Catch:{ IOException -> 0x0136 }
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r15, (java.lang.String) r14)     // Catch:{ IOException -> 0x0136 }
                return
            L_0x012a:
                kotlin.u r15 = new kotlin.u     // Catch:{ IOException -> 0x0136 }
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
                r15.<init>(r1)     // Catch:{ IOException -> 0x0136 }
                throw r15     // Catch:{ IOException -> 0x0136 }
            L_0x0132:
                r0.a((java.lang.Object) r1)     // Catch:{ IOException -> 0x0136 }
                goto L_0x014f
            L_0x0136:
                r15 = move-exception
                r15.printStackTrace()
                com.alipay.mobile.h5container.api.H5Event$Error r15 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r15, (java.lang.String) r14)
                goto L_0x014f
            L_0x0140:
                java.lang.Boolean r14 = java.lang.Boolean.FALSE
                boolean r14 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r14)
                if (r14 == 0) goto L_0x014f
                com.alipay.mobile.h5container.api.H5Event$Error r14 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                java.lang.String r15 = "action cancelled!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r14, (java.lang.String) r15)
            L_0x014f:
                android.app.Activity r14 = r13.f17008a
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r14 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r14
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$g r14 = r14.f17106d
                java.util.Observable r14 = (java.util.Observable) r14
                r14.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.k.b.update(java.util.Observable, java.lang.Object):void");
        }
    }

    static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17016a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f17017b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Intent f17018c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17019d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Integer f17020e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f17021f;

        c(Activity activity, k kVar, Intent intent, String str, Integer num, String str2) {
            this.f17016a = activity;
            this.f17017b = kVar;
            this.f17018c = intent;
            this.f17019d = str;
            this.f17020e = num;
            this.f17021f = str2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0095, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            kotlin.f.a.a(r2, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0099, code lost:
            throw r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r8, java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r8 = "base64"
                net.one97.paytm.h5paytmsdk.b.k r0 = r7.f17017b
                boolean r1 = r9 instanceof java.lang.String
                if (r1 == 0) goto L_0x00ae
                java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x00a2 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x00a2 }
                r1.<init>(r9)     // Catch:{ IOException -> 0x00a2 }
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a2 }
                r9.<init>(r1)     // Catch:{ IOException -> 0x00a2 }
                android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x00a2 }
                r2.<init>()     // Catch:{ IOException -> 0x00a2 }
                r3 = 1
                r2.inJustDecodeBounds = r3     // Catch:{ IOException -> 0x00a2 }
                r3 = r9
                java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ IOException -> 0x00a2 }
                r4 = 0
                android.graphics.BitmapFactory.decodeStream(r3, r4, r2)     // Catch:{ IOException -> 0x00a2 }
                r9.close()     // Catch:{ IOException -> 0x00a2 }
                java.lang.String r9 = r2.outMimeType     // Catch:{ IOException -> 0x00a2 }
                if (r9 == 0) goto L_0x009a
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ IOException -> 0x00a2 }
                java.lang.String r2 = "image"
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IOException -> 0x00a2 }
                boolean r9 = kotlin.m.p.c((java.lang.CharSequence) r9, (java.lang.CharSequence) r2)     // Catch:{ IOException -> 0x00a2 }
                if (r9 == 0) goto L_0x009a
                long r2 = r1.length()     // Catch:{ IOException -> 0x00a2 }
                int r9 = (int) r2     // Catch:{ IOException -> 0x00a2 }
                int r9 = r9 + 100
                byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x00a2 }
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a2 }
                r2.<init>(r1)     // Catch:{ IOException -> 0x00a2 }
                java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ IOException -> 0x00a2 }
                r3 = r2
                java.io.FileInputStream r3 = (java.io.FileInputStream) r3     // Catch:{ all -> 0x0093 }
                int r3 = r3.read(r9)     // Catch:{ all -> 0x0093 }
                r5 = 0
                java.lang.String r9 = android.util.Base64.encodeToString(r9, r5, r3, r5)     // Catch:{ all -> 0x0093 }
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)     // Catch:{ all -> 0x0093 }
                r0.a((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0093 }
                com.alibaba.a.e r8 = new com.alibaba.a.e     // Catch:{ all -> 0x0093 }
                r8.<init>()     // Catch:{ all -> 0x0093 }
                r9 = r8
                java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x0093 }
                java.lang.String r3 = "imageName"
                java.lang.String r5 = r1.getName()     // Catch:{ all -> 0x0093 }
                r9.put(r3, r5)     // Catch:{ all -> 0x0093 }
                r9 = r8
                java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x0093 }
                java.lang.String r3 = "imageType"
                java.lang.String r5 = kotlin.f.b.a(r1)     // Catch:{ all -> 0x0093 }
                r9.put(r3, r5)     // Catch:{ all -> 0x0093 }
                r9 = r8
                java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x0093 }
                java.lang.String r3 = "imageSize"
                long r5 = r1.length()     // Catch:{ all -> 0x0093 }
                java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0093 }
                r9.put(r3, r1)     // Catch:{ all -> 0x0093 }
                java.lang.String r9 = "meta"
                r0.a((java.lang.String) r9, (java.lang.Object) r8)     // Catch:{ all -> 0x0093 }
                r0.a((java.lang.Object) null)     // Catch:{ all -> 0x0093 }
                kotlin.x r8 = kotlin.x.f47997a     // Catch:{ all -> 0x0093 }
                kotlin.f.a.a(r2, r4)     // Catch:{ IOException -> 0x00a2 }
                goto L_0x00bd
            L_0x0093:
                r8 = move-exception
                throw r8     // Catch:{ all -> 0x0095 }
            L_0x0095:
                r9 = move-exception
                kotlin.f.a.a(r2, r8)     // Catch:{ IOException -> 0x00a2 }
                throw r9     // Catch:{ IOException -> 0x00a2 }
            L_0x009a:
                com.alipay.mobile.h5container.api.H5Event$Error r8 = com.alipay.mobile.h5container.api.H5Event.Error.FORBIDDEN     // Catch:{ IOException -> 0x00a2 }
                java.lang.String r9 = "Not an image file!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x00a2 }
                goto L_0x00bd
            L_0x00a2:
                r8 = move-exception
                r8.printStackTrace()
                com.alipay.mobile.h5container.api.H5Event$Error r8 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                java.lang.String r9 = "Error!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r8, (java.lang.String) r9)
                goto L_0x00bd
            L_0x00ae:
                java.lang.Boolean r8 = java.lang.Boolean.FALSE
                boolean r8 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
                if (r8 == 0) goto L_0x00bd
                com.alipay.mobile.h5container.api.H5Event$Error r8 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                java.lang.String r9 = "action cancelled!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r8, (java.lang.String) r9)
            L_0x00bd:
                android.app.Activity r8 = r7.f17016a
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r8 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r8
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$h r8 = r8.f17105c
                java.util.Observable r8 = (java.util.Observable) r8
                r8.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.k.c.update(java.util.Observable, java.lang.Object):void");
        }
    }

    private final void c(H5Event h5Event) {
        File file;
        e param = h5Event.getParam();
        String action = h5Event.getAction();
        Integer integer = param.getInteger("requestCode");
        param.getString("title");
        Boolean bool = param.getBoolean("useFrontCamera");
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Activity activity = h5Event.getActivity();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        kotlin.g.b.k.a((Object) activity, "activity");
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            a(H5Event.Error.UNKNOWN_ERROR, "No matching activity found");
        } else if (intent.resolveActivity(activity.getPackageManager()) != null) {
            Uri uri = null;
            try {
                net.one97.paytm.h5paytmsdk.d.c cVar = net.one97.paytm.h5paytmsdk.d.c.f17098a;
                file = net.one97.paytm.h5paytmsdk.d.c.a(activity, (String) null, ".jpg", 2);
            } catch (IOException e2) {
                e2.printStackTrace();
                a(H5Event.Error.UNKNOWN_ERROR, "Exception while creating file");
                file = null;
            }
            if (file != null) {
                try {
                    uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    a(H5Event.Error.UNKNOWN_ERROR, "Exception while getting uri for file");
                }
                if (uri != null) {
                    intent.putExtra("output", uri);
                    for (ResolveInfo resolveInfo : activity.getPackageManager().queryIntentActivities(intent, 65536)) {
                        activity.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
                    }
                    if (activity instanceof PaytmH5Activity) {
                        PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                        paytmH5Activity.f17104b.addObserver(new a(file, intent, this, activity, booleanValue, integer, action));
                        if (booleanValue) {
                            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                            intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                        }
                        kotlin.g.b.k.a((Object) integer, "requestCode");
                        int intValue = integer.intValue();
                        kotlin.g.b.k.a((Object) action, "actionName");
                        paytmH5Activity.a(intent, intValue, action);
                    }
                }
            }
        }
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f17001a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f17002b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f17003c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f17004d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f17005e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Integer f17006f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f17007g;

        a(File file, Intent intent, k kVar, Activity activity, boolean z, Integer num, String str) {
            this.f17001a = file;
            this.f17002b = intent;
            this.f17003c = kVar;
            this.f17004d = activity;
            this.f17005e = z;
            this.f17006f = num;
            this.f17007g = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            kotlin.f.a.a(r1, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
            throw r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(java.util.Observable r6, java.lang.Object r7) {
            /*
                r5 = this;
                java.lang.String r6 = "base64"
                net.one97.paytm.h5paytmsdk.b.k r0 = r5.f17003c
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r1)
                if (r7 == 0) goto L_0x0087
                java.io.File r7 = r5.f17001a     // Catch:{ IOException -> 0x007b }
                long r1 = r7.length()     // Catch:{ IOException -> 0x007b }
                int r7 = (int) r1     // Catch:{ IOException -> 0x007b }
                int r7 = r7 + 100
                byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x007b }
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x007b }
                java.io.File r2 = r5.f17001a     // Catch:{ IOException -> 0x007b }
                r1.<init>(r2)     // Catch:{ IOException -> 0x007b }
                java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ IOException -> 0x007b }
                r2 = r1
                java.io.FileInputStream r2 = (java.io.FileInputStream) r2     // Catch:{ all -> 0x0074 }
                int r2 = r2.read(r7)     // Catch:{ all -> 0x0074 }
                r3 = 0
                java.lang.String r7 = android.util.Base64.encodeToString(r7, r3, r2, r3)     // Catch:{ all -> 0x0074 }
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)     // Catch:{ all -> 0x0074 }
                r0.a((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0074 }
                com.alibaba.a.e r6 = new com.alibaba.a.e     // Catch:{ all -> 0x0074 }
                r6.<init>()     // Catch:{ all -> 0x0074 }
                r7 = r6
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x0074 }
                java.lang.String r2 = "imageName"
                java.io.File r3 = r5.f17001a     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0074 }
                r7.put(r2, r3)     // Catch:{ all -> 0x0074 }
                r7 = r6
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x0074 }
                java.lang.String r2 = "imageType"
                java.io.File r3 = r5.f17001a     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = kotlin.f.b.a(r3)     // Catch:{ all -> 0x0074 }
                r7.put(r2, r3)     // Catch:{ all -> 0x0074 }
                r7 = r6
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x0074 }
                java.lang.String r2 = "imageSize"
                java.io.File r3 = r5.f17001a     // Catch:{ all -> 0x0074 }
                long r3 = r3.length()     // Catch:{ all -> 0x0074 }
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0074 }
                r7.put(r2, r3)     // Catch:{ all -> 0x0074 }
                java.lang.String r7 = "meta"
                r0.a((java.lang.String) r7, (java.lang.Object) r6)     // Catch:{ all -> 0x0074 }
                r0.a((java.lang.Object) null)     // Catch:{ all -> 0x0074 }
                kotlin.x r6 = kotlin.x.f47997a     // Catch:{ all -> 0x0074 }
                r6 = 0
                kotlin.f.a.a(r1, r6)     // Catch:{ IOException -> 0x007b }
                goto L_0x008e
            L_0x0074:
                r6 = move-exception
                throw r6     // Catch:{ all -> 0x0076 }
            L_0x0076:
                r7 = move-exception
                kotlin.f.a.a(r1, r6)     // Catch:{ IOException -> 0x007b }
                throw r7     // Catch:{ IOException -> 0x007b }
            L_0x007b:
                r6 = move-exception
                r6.printStackTrace()
                com.alipay.mobile.h5container.api.H5Event$Error r6 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                java.lang.String r7 = "Error!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r6, (java.lang.String) r7)
                goto L_0x008e
            L_0x0087:
                com.alipay.mobile.h5container.api.H5Event$Error r6 = com.alipay.mobile.h5container.api.H5Event.Error.UNKNOWN_ERROR
                java.lang.String r7 = "action cancelled!"
                r0.a((com.alipay.mobile.h5container.api.H5Event.Error) r6, (java.lang.String) r7)
            L_0x008e:
                android.app.Activity r6 = r5.f17004d
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r6 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r6
                net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$d r6 = r6.f17104b
                java.util.Observable r6 = (java.util.Observable) r6
                r6.deleteObservers()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.k.a.update(java.util.Observable, java.lang.Object):void");
        }
    }
}
