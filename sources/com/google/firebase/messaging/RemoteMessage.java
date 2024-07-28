package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.a.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sendbird.android.constant.StringSet;
import java.util.Map;

public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    Bundle f38993a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f38994b;

    public RemoteMessage(Bundle bundle) {
        this.f38993a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        o.a(this, parcel);
    }

    public final String a() {
        return this.f38993a.getString("from");
    }

    public final Map<String, String> b() {
        if (this.f38994b == null) {
            Bundle bundle = this.f38993a;
            a aVar = new a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals(StringSet.message_type) && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            this.f38994b = aVar;
        }
        return this.f38994b;
    }

    public final String c() {
        String string = this.f38993a.getString("google.message_id");
        return string == null ? this.f38993a.getString(StringSet.message_id) : string;
    }

    public final long d() {
        Object obj = this.f38993a.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(valueOf);
            return 0;
        }
    }
}
