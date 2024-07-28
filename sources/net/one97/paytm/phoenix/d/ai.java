package net.one97.paytm.phoenix.d;

import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.download.FileDownloadError;
import net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider;
import org.json.JSONObject;

public final class ai extends net.one97.paytm.phoenix.core.a {
    public ai() {
        super("paytmDownloadFile", "paytmGetFilePath", "paytmRemoveFile");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r12, net.one97.paytm.phoenix.api.b r13) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r13, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13)
            b(r12, r13)
            net.one97.paytm.phoenix.core.c r13 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r13 = r13.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider> r0 = net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixFileDownloadProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r13 = r13.a(r0)
            r0 = r13
            net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider r0 = (net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider) r0
            r13 = 1
            if (r0 == 0) goto L_0x011e
            java.lang.String r1 = r12.getAction$phoenix_debug()
            org.json.JSONObject r2 = r12.getParams()
            r3 = 0
            if (r2 == 0) goto L_0x003d
            java.lang.String r4 = "fileName"
            java.lang.String r4 = r2.optString(r4)
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            r5 = 0
            if (r2 == 0) goto L_0x0048
            java.lang.String r6 = "useExternalStorage"
            boolean r6 = r2.optBoolean(r6)
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            android.app.Activity r7 = r12.getActivity()
            if (r7 == 0) goto L_0x006d
            android.app.Activity r7 = r12.getActivity()
            if (r7 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            boolean r7 = r7 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r7 == 0) goto L_0x006d
            android.app.Activity r7 = r12.getActivity()
            if (r7 == 0) goto L_0x0065
            net.one97.paytm.phoenix.ui.PhoenixActivity r7 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r7
            goto L_0x006e
        L_0x0065:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r12.<init>(r13)
            throw r12
        L_0x006d:
            r7 = r3
        L_0x006e:
            if (r7 != 0) goto L_0x0071
            return r5
        L_0x0071:
            r8 = r4
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r9 = "value empty!"
            if (r8 == 0) goto L_0x0082
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r9)
            return r13
        L_0x0082:
            if (r1 != 0) goto L_0x0086
            goto L_0x011e
        L_0x0086:
            int r8 = r1.hashCode()
            r10 = -1959423658(0xffffffff8b359156, float:-3.496867E-32)
            if (r8 == r10) goto L_0x00e1
            r5 = 991648801(0x3b1b5c21, float:0.0023706036)
            if (r8 == r5) goto L_0x00cc
            r5 = 1836355045(0x6d748de5, float:4.7303676E27)
            if (r8 == r5) goto L_0x009b
            goto L_0x011e
        L_0x009b:
            java.lang.String r5 = "paytmDownloadFile"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x011e
            if (r2 == 0) goto L_0x00ac
            java.lang.String r1 = "fileDownloadUrl"
            java.lang.String r1 = r2.optString(r1)
            r3 = r1
        L_0x00ac:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00bb
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r9)
            return r13
        L_0x00bb:
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.phoenix.d.ai$a r2 = new net.one97.paytm.phoenix.d.ai$a
            r2.<init>(r11, r12)
            r5 = r2
            net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider$OnFileDownloadedInterface r5 = (net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider.OnFileDownloadedInterface) r5
            r2 = r4
            r4 = r6
            r0.enqueueFileDownload(r1, r2, r3, r4, r5)
            goto L_0x011e
        L_0x00cc:
            java.lang.String r2 = "paytmRemoveFile"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x011e
            android.content.Context r7 = (android.content.Context) r7
            net.one97.paytm.phoenix.d.ai$b r1 = new net.one97.paytm.phoenix.d.ai$b
            r1.<init>(r11, r12)
            net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider$OnFileDeletedInterface r1 = (net.one97.paytm.phoenix.provider.download.PhoenixFileDownloadProvider.OnFileDeletedInterface) r1
            r0.enqueueFileRemoval(r7, r4, r6, r1)
            goto L_0x011e
        L_0x00e1:
            java.lang.String r2 = "paytmGetFilePath"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x011e
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r0 = r0.getFilePath(r7, r6, r4)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "success"
            if (r0 == 0) goto L_0x0101
            java.lang.String r3 = "filePath"
            r1.put(r3, r0)
            r1.put(r2, r13)
            goto L_0x011b
        L_0x0101:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r3 = 6
            java.lang.String r4 = "code"
            r0.put(r4, r3)
            java.lang.String r3 = "message"
            java.lang.String r4 = "File not found."
            r0.put(r3, r4)
            java.lang.String r3 = "error"
            r1.put(r3, r0)
            r1.put(r2, r5)
        L_0x011b:
            r11.b(r12, r1)
        L_0x011e:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ai.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements PhoenixFileDownloadProvider.OnFileDownloadedInterface {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f59497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59498b;

        a(ai aiVar, H5Event h5Event) {
            this.f59497a = aiVar;
            this.f59498b = h5Event;
        }

        public final void onDownloadOperationFinished(String str, String str2, String str3, FileDownloadError fileDownloadError) {
            ai aiVar = this.f59497a;
            H5Event h5Event = this.f59498b;
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, str);
            }
            if (str2 != null) {
                jSONObject.put("fileDownloadUrl", str2);
            }
            if (str3 != null) {
                jSONObject.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, str3);
            }
            if (fileDownloadError != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", fileDownloadError.getCode());
                jSONObject2.put("message", fileDownloadError.getMessage());
                jSONObject.put("error", jSONObject2);
                jSONObject.put("success", false);
            } else {
                jSONObject.put("success", true);
            }
            aiVar.b(h5Event, jSONObject);
        }
    }

    public static final class b implements PhoenixFileDownloadProvider.OnFileDeletedInterface {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ai f59499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59500b;

        b(ai aiVar, H5Event h5Event) {
            this.f59499a = aiVar;
            this.f59500b = h5Event;
        }

        public final void onFileDeletionOperationFinished(String str, boolean z, FileDownloadError fileDownloadError) {
            JSONObject jSONObject = new JSONObject();
            if (fileDownloadError == null) {
                jSONObject.put("success", "true");
            } else {
                jSONObject.put("success", "false");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", fileDownloadError.getCode());
                jSONObject2.put("message", fileDownloadError.getMessage());
                jSONObject.put("error", jSONObject2);
            }
            this.f59499a.b(this.f59500b, jSONObject);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(H5Event h5Event, JSONObject jSONObject) {
        a("data", (Object) jSONObject);
        net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, true, 2);
    }
}
