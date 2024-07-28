package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.l;
import java.util.HashMap;
import net.one97.paytm.oauth.R;

public final class ak {
    public static a a() {
        return new a((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56346a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56346a = new HashMap();
        }

        public final a a(String str) {
            this.f56346a.put("mobileNumber", str);
            return this;
        }

        public final a b(String str) {
            this.f56346a.put("stateToken", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56346a.containsKey("mobileNumber")) {
                bundle.putString("mobileNumber", (String) this.f56346a.get("mobileNumber"));
            }
            if (this.f56346a.containsKey("stateToken")) {
                bundle.putString("stateToken", (String) this.f56346a.get("stateToken"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionEnterOtp;
        }

        private String c() {
            return (String) this.f56346a.get("mobileNumber");
        }

        private String d() {
            return (String) this.f56346a.get("stateToken");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56346a.containsKey("mobileNumber") != aVar.f56346a.containsKey("mobileNumber")) {
                return false;
            }
            if (c() == null ? aVar.c() != null : !c().equals(aVar.c())) {
                return false;
            }
            if (this.f56346a.containsKey("stateToken") != aVar.f56346a.containsKey("stateToken")) {
                return false;
            }
            if (d() == null ? aVar.d() != null : !d().equals(aVar.d())) {
                return false;
            }
            int i2 = R.id.navActionEnterOtp;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((c() != null ? c().hashCode() : 0) + 31) * 31;
            if (d() != null) {
                i2 = d().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionEnterOtp;
        }

        public final String toString() {
            return "NavActionEnterOtp(actionId=" + R.id.navActionEnterOtp + "){mobileNumber=" + c() + ", stateToken=" + d() + "}";
        }
    }
}
