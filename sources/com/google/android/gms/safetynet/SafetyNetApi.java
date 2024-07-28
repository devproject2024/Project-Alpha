package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import java.util.List;

public interface SafetyNetApi {

    public static class AttestationResponse extends k<zza> {
        public String getJwsResult() {
            return ((zza) getResult()).getJwsResult();
        }
    }

    public static class HarmfulAppsResponse extends k<zzb> {
        public List<HarmfulAppsData> getHarmfulAppsList() {
            return ((zzb) getResult()).getHarmfulAppsList();
        }

        public int getHoursSinceLastScanWithHarmfulApp() {
            return ((zzb) getResult()).getHoursSinceLastScanWithHarmfulApp();
        }

        public long getLastScanTimeMs() {
            return ((zzb) getResult()).getLastScanTimeMs();
        }
    }

    public static class RecaptchaTokenResponse extends k<RecaptchaTokenResult> {
        public String getTokenResult() {
            return ((RecaptchaTokenResult) getResult()).getTokenResult();
        }
    }

    @Deprecated
    public interface RecaptchaTokenResult extends l {
        String getTokenResult();
    }

    public static class SafeBrowsingResponse extends k<SafeBrowsingResult> {
        public List<SafeBrowsingThreat> getDetectedThreats() {
            return ((SafeBrowsingResult) getResult()).getDetectedThreats();
        }

        public long getLastUpdateTimeMs() {
            return ((SafeBrowsingResult) getResult()).getLastUpdateTimeMs();
        }

        public String getMetadata() {
            return ((SafeBrowsingResult) getResult()).getMetadata();
        }

        public byte[] getState() {
            return ((SafeBrowsingResult) getResult()).getState();
        }
    }

    @Deprecated
    public interface SafeBrowsingResult extends l {
        List<SafeBrowsingThreat> getDetectedThreats();

        long getLastUpdateTimeMs();

        String getMetadata();

        byte[] getState();
    }

    public static class VerifyAppsUserResponse extends k<zzc> {
        public boolean isVerifyAppsEnabled() {
            return ((zzc) getResult()).isVerifyAppsEnabled();
        }
    }

    @Deprecated
    public interface zza extends l {
        String getJwsResult();
    }

    @Deprecated
    public interface zzb extends l {
        List<HarmfulAppsData> getHarmfulAppsList();

        int getHoursSinceLastScanWithHarmfulApp();

        long getLastScanTimeMs();
    }

    @Deprecated
    public interface zzc extends l {
        boolean isVerifyAppsEnabled();
    }

    @Deprecated
    g<zza> attest(e eVar, byte[] bArr);

    @Deprecated
    g<zzc> enableVerifyApps(e eVar);

    @Deprecated
    g<zzc> isVerifyAppsEnabled(e eVar);

    @Deprecated
    boolean isVerifyAppsEnabled(Context context);

    @Deprecated
    g<zzb> listHarmfulApps(e eVar);

    @Deprecated
    g<SafeBrowsingResult> lookupUri(e eVar, String str, String str2, int... iArr);

    g<SafeBrowsingResult> lookupUri(e eVar, List<Integer> list, String str);

    @Deprecated
    g<RecaptchaTokenResult> verifyWithRecaptcha(e eVar, String str);
}
