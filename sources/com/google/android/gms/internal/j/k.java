package com.google.android.gms.internal.j;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafeBrowsingThreat;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k implements SafetyNetApi {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10337a = k.class.getSimpleName();

    static class a implements SafetyNetApi.zza {

        /* renamed from: a  reason: collision with root package name */
        private final Status f10338a;

        /* renamed from: b  reason: collision with root package name */
        private final zza f10339b;

        public a(Status status, zza zza) {
            this.f10338a = status;
            this.f10339b = zza;
        }

        public final Status a() {
            return this.f10338a;
        }

        public final String getJwsResult() {
            zza zza = this.f10339b;
            if (zza == null) {
                return null;
            }
            return zza.getJwsResult();
        }
    }

    static abstract class b extends f<SafetyNetApi.zza> {

        /* renamed from: d  reason: collision with root package name */
        protected g f10340d = new s(this);

        public b(com.google.android.gms.common.api.e eVar) {
            super(eVar);
        }

        public final /* synthetic */ l a(Status status) {
            return new a(status, (zza) null);
        }
    }

    static abstract class c extends f<SafetyNetApi.zzc> {

        /* renamed from: d  reason: collision with root package name */
        protected g f10341d = new t(this);

        public c(com.google.android.gms.common.api.e eVar) {
            super(eVar);
        }

        public final /* synthetic */ l a(Status status) {
            return new j(status, false);
        }
    }

    static abstract class d extends f<SafetyNetApi.zzb> {

        /* renamed from: d  reason: collision with root package name */
        protected final g f10342d = new u(this);

        public d(com.google.android.gms.common.api.e eVar) {
            super(eVar);
        }

        public final /* synthetic */ l a(Status status) {
            return new g(status, (zzd) null);
        }
    }

    static abstract class e extends f<SafetyNetApi.RecaptchaTokenResult> {

        /* renamed from: d  reason: collision with root package name */
        protected g f10343d = new v(this);

        public e(com.google.android.gms.common.api.e eVar) {
            super(eVar);
        }

        public final /* synthetic */ l a(Status status) {
            return new h(status, (zzf) null);
        }
    }

    static abstract class f extends f<SafetyNetApi.SafeBrowsingResult> {

        /* renamed from: d  reason: collision with root package name */
        protected g f10344d = new w(this);

        public f(com.google.android.gms.common.api.e eVar) {
            super(eVar);
        }

        public final /* synthetic */ l a(Status status) {
            return new i(status, (SafeBrowsingData) null);
        }
    }

    static class g implements SafetyNetApi.zzb {

        /* renamed from: a  reason: collision with root package name */
        private final Status f10345a;

        /* renamed from: b  reason: collision with root package name */
        private final zzd f10346b;

        public g(Status status, zzd zzd) {
            this.f10345a = status;
            this.f10346b = zzd;
        }

        public final Status a() {
            return this.f10345a;
        }

        public final List<HarmfulAppsData> getHarmfulAppsList() {
            zzd zzd = this.f10346b;
            return zzd == null ? Collections.emptyList() : Arrays.asList(zzd.zzg);
        }

        public final int getHoursSinceLastScanWithHarmfulApp() {
            zzd zzd = this.f10346b;
            if (zzd == null) {
                return -1;
            }
            return zzd.zzh;
        }

        public final long getLastScanTimeMs() {
            zzd zzd = this.f10346b;
            if (zzd == null) {
                return 0;
            }
            return zzd.zzf;
        }
    }

    static class h implements SafetyNetApi.RecaptchaTokenResult {

        /* renamed from: a  reason: collision with root package name */
        private final Status f10347a;

        /* renamed from: b  reason: collision with root package name */
        private final zzf f10348b;

        public h(Status status, zzf zzf) {
            this.f10347a = status;
            this.f10348b = zzf;
        }

        public final Status a() {
            return this.f10347a;
        }

        public final String getTokenResult() {
            zzf zzf = this.f10348b;
            if (zzf == null) {
                return null;
            }
            return zzf.getTokenResult();
        }
    }

    public static class i implements SafetyNetApi.SafeBrowsingResult {

        /* renamed from: a  reason: collision with root package name */
        private Status f10349a;

        /* renamed from: b  reason: collision with root package name */
        private final SafeBrowsingData f10350b;

        /* renamed from: c  reason: collision with root package name */
        private String f10351c = null;

        /* renamed from: d  reason: collision with root package name */
        private long f10352d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f10353e;

        public i(Status status, SafeBrowsingData safeBrowsingData) {
            this.f10349a = status;
            this.f10350b = safeBrowsingData;
            SafeBrowsingData safeBrowsingData2 = this.f10350b;
            if (safeBrowsingData2 != null) {
                this.f10351c = safeBrowsingData2.getMetadata();
                this.f10352d = this.f10350b.getLastUpdateTimeMs();
                this.f10353e = this.f10350b.getState();
            } else if (this.f10349a.c()) {
                this.f10349a = new Status(8);
            }
        }

        public final Status a() {
            return this.f10349a;
        }

        public final List<SafeBrowsingThreat> getDetectedThreats() {
            ArrayList arrayList = new ArrayList();
            String str = this.f10351c;
            if (str == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("matches");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        arrayList.add(new SafeBrowsingThreat(Integer.parseInt(jSONArray.getJSONObject(i2).getString("threat_type"))));
                    } catch (NumberFormatException | JSONException unused) {
                    }
                }
            } catch (JSONException unused2) {
            }
            return arrayList;
        }

        public final long getLastUpdateTimeMs() {
            return this.f10352d;
        }

        public final String getMetadata() {
            return this.f10351c;
        }

        public final byte[] getState() {
            return this.f10353e;
        }
    }

    static class j implements SafetyNetApi.zzc {

        /* renamed from: a  reason: collision with root package name */
        private Status f10354a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10355b;

        public j() {
        }

        public j(Status status, boolean z) {
            this.f10354a = status;
            this.f10355b = z;
        }

        public final Status a() {
            return this.f10354a;
        }

        public final boolean isVerifyAppsEnabled() {
            Status status = this.f10354a;
            if (status == null || !status.c()) {
                return false;
            }
            return this.f10355b;
        }
    }

    public static com.google.android.gms.common.api.g<SafetyNetApi.SafeBrowsingResult> a(com.google.android.gms.common.api.e eVar, String str, int i2, String str2, int... iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return eVar.a(new n(eVar, iArr, i2, str, str2));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public static com.google.android.gms.common.api.g<SafetyNetApi.zza> a(com.google.android.gms.common.api.e eVar, byte[] bArr, String str) {
        return eVar.a(new l(eVar, bArr, str));
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.zza> attest(com.google.android.gms.common.api.e eVar, byte[] bArr) {
        return a(eVar, bArr, (String) null);
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.zzc> enableVerifyApps(com.google.android.gms.common.api.e eVar) {
        return eVar.a(new p(eVar));
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.zzc> isVerifyAppsEnabled(com.google.android.gms.common.api.e eVar) {
        return eVar.a(new o(eVar));
    }

    public boolean isVerifyAppsEnabled(Context context) {
        com.google.android.gms.common.api.e a2 = new e.a(context).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) SafetyNet.API).a();
        try {
            boolean z = false;
            if (a2.a(TimeUnit.SECONDS).b()) {
                SafetyNetApi.zzc a3 = isVerifyAppsEnabled(a2).a(3, TimeUnit.SECONDS);
                if (a3 != null && a3.isVerifyAppsEnabled()) {
                    z = true;
                }
                return z;
            }
            a2.e();
            return false;
        } finally {
            a2.e();
        }
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.zzb> listHarmfulApps(com.google.android.gms.common.api.e eVar) {
        return eVar.a(new q(eVar));
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.SafeBrowsingResult> lookupUri(com.google.android.gms.common.api.e eVar, String str, String str2, int... iArr) {
        return a(eVar, str, 1, str2, iArr);
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.SafeBrowsingResult> lookupUri(com.google.android.gms.common.api.e eVar, List<Integer> list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return eVar.a(new m(eVar, list, str));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public com.google.android.gms.common.api.g<SafetyNetApi.RecaptchaTokenResult> verifyWithRecaptcha(com.google.android.gms.common.api.e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            return eVar.a(new r(eVar, str));
        }
        throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
    }
}
