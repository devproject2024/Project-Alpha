package com.google.firebase.installations.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final File f38936a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.c f38937b;

    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(com.google.firebase.c cVar) {
        File filesDir = cVar.a().getFilesDir();
        this.f38936a = new File(filesDir, "PersistedInstallation." + cVar.h() + ".json");
        this.f38937b = cVar;
    }

    public final d a() {
        JSONObject b2 = b();
        String optString = b2.optString("Fid", (String) null);
        int optInt = b2.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = b2.optString("AuthToken", (String) null);
        String optString3 = b2.optString("RefreshToken", (String) null);
        long optLong = b2.optLong("TokenCreationEpochInSecs", 0);
        long optLong2 = b2.optLong("ExpiresInSecs", 0);
        return d.m().a(optString).a(a.values()[optInt]).b(optString2).c(optString3).b(optLong).a(optLong2).d(b2.optString("FisError", (String) null)).a();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject b() {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException | JSONException -> 0x002d }
            java.io.File r4 = r6.f38936a     // Catch:{ IOException | JSONException -> 0x002d }
            r3.<init>(r4)     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x0010:
            r4 = 0
            int r5 = r3.read(r2, r4, r1)     // Catch:{ all -> 0x0028 }
            if (r5 < 0) goto L_0x001b
            r0.write(r2, r4, r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0010
        L_0x001b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0028 }
            r1.<init>(r0)     // Catch:{ all -> 0x0028 }
            r3.close()     // Catch:{ IOException | JSONException -> 0x002d }
            return r1
        L_0x0028:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x002c }
        L_0x002c:
            throw r0     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x002d:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.a.c.b():org.json.JSONObject");
    }

    public final d a(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.a());
            jSONObject.put("Status", dVar.b().ordinal());
            jSONObject.put("AuthToken", dVar.c());
            jSONObject.put("RefreshToken", dVar.d());
            jSONObject.put("TokenCreationEpochInSecs", dVar.f());
            jSONObject.put("ExpiresInSecs", dVar.e());
            jSONObject.put("FisError", dVar.g());
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f38937b.a().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(AppConstants.UTF_8));
            fileOutputStream.close();
            if (createTempFile.renameTo(this.f38936a)) {
                return dVar;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }
}
