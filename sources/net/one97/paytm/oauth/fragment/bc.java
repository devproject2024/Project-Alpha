package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.l;
import java.util.HashMap;
import net.one97.paytm.oauth.R;

public final class bc {
    public static a a() {
        return new a((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56404a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56404a = new HashMap();
        }

        public final a a(String str) {
            this.f56404a.put("stateToken", str);
            return this;
        }

        public final a b(String str) {
            this.f56404a.put("previous_screen_name", str);
            return this;
        }

        public final a c(String str) {
            this.f56404a.put("verifyFlow", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56404a.containsKey("stateToken")) {
                bundle.putString("stateToken", (String) this.f56404a.get("stateToken"));
            }
            if (this.f56404a.containsKey("previous_screen_name")) {
                bundle.putString("previous_screen_name", (String) this.f56404a.get("previous_screen_name"));
            }
            if (this.f56404a.containsKey("verifyFlow")) {
                bundle.putString("verifyFlow", (String) this.f56404a.get("verifyFlow"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionEnterNewNumber;
        }

        private String c() {
            return (String) this.f56404a.get("stateToken");
        }

        private String d() {
            return (String) this.f56404a.get("previous_screen_name");
        }

        private String e() {
            return (String) this.f56404a.get("verifyFlow");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56404a.containsKey("stateToken") != aVar.f56404a.containsKey("stateToken")) {
                return false;
            }
            if (c() == null ? aVar.c() != null : !c().equals(aVar.c())) {
                return false;
            }
            if (this.f56404a.containsKey("previous_screen_name") != aVar.f56404a.containsKey("previous_screen_name")) {
                return false;
            }
            if (d() == null ? aVar.d() != null : !d().equals(aVar.d())) {
                return false;
            }
            if (this.f56404a.containsKey("verifyFlow") != aVar.f56404a.containsKey("verifyFlow")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            int i2 = R.id.navActionEnterNewNumber;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31;
            if (e() != null) {
                i2 = e().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionEnterNewNumber;
        }

        public final String toString() {
            return "NavActionEnterNewNumber(actionId=" + R.id.navActionEnterNewNumber + "){stateToken=" + c() + ", previousScreenName=" + d() + ", verifyFlow=" + e() + "}";
        }
    }
}
