package net.one97.paytm.phoenix.api;

import android.app.Activity;
import com.google.firebase.c;
import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class H5Event {
    private transient WeakReference<Activity> activityReference;
    private String bridgeName;
    private String callbackId;
    private boolean keepCallback;
    private String msgType;
    private JSONObject params;
    private Trace trace;

    public H5Event() {
        this((String) null, (String) null, (JSONObject) null, (String) null, false, 31, (g) null);
    }

    public static /* synthetic */ H5Event copy$default(H5Event h5Event, String str, String str2, JSONObject jSONObject, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = h5Event.bridgeName;
        }
        if ((i2 & 2) != 0) {
            str2 = h5Event.msgType;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            jSONObject = h5Event.params;
        }
        JSONObject jSONObject2 = jSONObject;
        if ((i2 & 8) != 0) {
            str3 = h5Event.callbackId;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            z = h5Event.keepCallback;
        }
        return h5Event.copy(str, str4, jSONObject2, str5, z);
    }

    public final String component1() {
        return this.bridgeName;
    }

    public final String component2() {
        return this.msgType;
    }

    public final JSONObject component3() {
        return this.params;
    }

    public final String component4() {
        return this.callbackId;
    }

    public final boolean component5() {
        return this.keepCallback;
    }

    public final H5Event copy(String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        return new H5Event(str, str2, jSONObject, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof H5Event) {
                H5Event h5Event = (H5Event) obj;
                if (k.a((Object) this.bridgeName, (Object) h5Event.bridgeName) && k.a((Object) this.msgType, (Object) h5Event.msgType) && k.a((Object) this.params, (Object) h5Event.params) && k.a((Object) this.callbackId, (Object) h5Event.callbackId)) {
                    if (this.keepCallback == h5Event.keepCallback) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.bridgeName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.msgType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.params;
        int hashCode3 = (hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        String str3 = this.callbackId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.keepCallback;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "H5Event(bridgeName=" + this.bridgeName + ", msgType=" + this.msgType + ", params=" + this.params + ", callbackId=" + this.callbackId + ", keepCallback=" + this.keepCallback + ")";
    }

    public H5Event(String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        this.bridgeName = str;
        this.msgType = str2;
        this.params = jSONObject;
        this.callbackId = str3;
        this.keepCallback = z;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final void setBridgeName(String str) {
        this.bridgeName = str;
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public final void setMsgType(String str) {
        this.msgType = str;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final void setCallbackId(String str) {
        this.callbackId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ H5Event(java.lang.String r4, java.lang.String r5, org.json.JSONObject r6, java.lang.String r7, boolean r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r8 = 0
            r9 = 0
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.api.H5Event.<init>(java.lang.String, java.lang.String, org.json.JSONObject, java.lang.String, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean getKeepCallback() {
        return this.keepCallback;
    }

    public final void setKeepCallback(boolean z) {
        this.keepCallback = z;
    }

    public final Activity getActivity() {
        WeakReference<Activity> weakReference = this.activityReference;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public final void setActivity(Activity activity) {
        k.c(activity, "activity");
        this.activityReference = new WeakReference<>(activity);
    }

    public final String getAction$phoenix_debug() {
        return this.bridgeName;
    }

    public final void startTrace() {
        getActivity();
        if (!c.d().isEmpty()) {
            a.a();
            Trace b2 = a.b("phoenix_bridge_execution_trace");
            k.a((Object) b2, "FirebasePerformance.getI…_bridge_execution_trace\")");
            this.trace = b2;
            Trace trace2 = this.trace;
            if (trace2 != null) {
                trace2.start();
            }
        }
    }

    public final void stopTrace() {
        Trace trace2;
        getActivity();
        if (!c.d().isEmpty()) {
            CharSequence charSequence = this.bridgeName;
            if (!(charSequence == null || charSequence.length() == 0) && (trace2 = this.trace) != null) {
                String str = this.bridgeName;
                if (str == null) {
                    k.a();
                }
                trace2.putAttribute("bridgeName", str);
            }
            Trace trace3 = this.trace;
            if (trace3 != null) {
                trace3.stop();
            }
            this.trace = null;
        }
    }

    public final void setResultAttribute(String str) {
        k.c(str, "result");
        Trace trace2 = this.trace;
        if (trace2 != null) {
            trace2.putAttribute("result", str);
        }
    }
}
