package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import androidx.navigation.l;
import java.util.HashMap;
import net.one97.paytm.oauth.R;

public final class cb {
    public static b a() {
        return new b((byte) 0);
    }

    public static a b() {
        return new a((byte) 0);
    }

    public static c c() {
        return new c((byte) 0);
    }

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56561a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56561a = new HashMap();
        }

        public final b a(String str) {
            this.f56561a.put("stateToken", str);
            return this;
        }

        public final b b(String str) {
            this.f56561a.put("previous_screen_name", str);
            return this;
        }

        public final b c(String str) {
            this.f56561a.put("verifyFlow", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56561a.containsKey("stateToken")) {
                bundle.putString("stateToken", (String) this.f56561a.get("stateToken"));
            }
            if (this.f56561a.containsKey("previous_screen_name")) {
                bundle.putString("previous_screen_name", (String) this.f56561a.get("previous_screen_name"));
            }
            if (this.f56561a.containsKey("verifyFlow")) {
                bundle.putString("verifyFlow", (String) this.f56561a.get("verifyFlow"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionEnterNewNumber;
        }

        private String c() {
            return (String) this.f56561a.get("stateToken");
        }

        private String d() {
            return (String) this.f56561a.get("previous_screen_name");
        }

        private String e() {
            return (String) this.f56561a.get("verifyFlow");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56561a.containsKey("stateToken") != bVar.f56561a.containsKey("stateToken")) {
                return false;
            }
            if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
                return false;
            }
            if (this.f56561a.containsKey("previous_screen_name") != bVar.f56561a.containsKey("previous_screen_name")) {
                return false;
            }
            if (d() == null ? bVar.d() != null : !d().equals(bVar.d())) {
                return false;
            }
            if (this.f56561a.containsKey("verifyFlow") != bVar.f56561a.containsKey("verifyFlow")) {
                return false;
            }
            if (e() == null ? bVar.e() != null : !e().equals(bVar.e())) {
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

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56560a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56560a = new HashMap();
        }

        public final a a(String str) {
            this.f56560a.put("meta", str);
            return this;
        }

        public final a b(String str) {
            this.f56560a.put("stateToken", str);
            return this;
        }

        public final a c(String str) {
            this.f56560a.put("mode", str);
            return this;
        }

        public final a d(String str) {
            this.f56560a.put("previous_screen_name", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56560a.containsKey("meta")) {
                bundle.putString("meta", (String) this.f56560a.get("meta"));
            }
            if (this.f56560a.containsKey("stateToken")) {
                bundle.putString("stateToken", (String) this.f56560a.get("stateToken"));
            }
            if (this.f56560a.containsKey("mobileNo")) {
                bundle.putString("mobileNo", (String) this.f56560a.get("mobileNo"));
            }
            if (this.f56560a.containsKey("mode")) {
                bundle.putString("mode", (String) this.f56560a.get("mode"));
            }
            if (this.f56560a.containsKey("is_update_email")) {
                bundle.putBoolean("is_update_email", ((Boolean) this.f56560a.get("is_update_email")).booleanValue());
            }
            if (this.f56560a.containsKey("previous_screen_name")) {
                bundle.putString("previous_screen_name", (String) this.f56560a.get("previous_screen_name"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionEmailOtp;
        }

        private String c() {
            return (String) this.f56560a.get("meta");
        }

        private String d() {
            return (String) this.f56560a.get("stateToken");
        }

        private String e() {
            return (String) this.f56560a.get("mobileNo");
        }

        private String f() {
            return (String) this.f56560a.get("mode");
        }

        private boolean g() {
            return ((Boolean) this.f56560a.get("is_update_email")).booleanValue();
        }

        private String h() {
            return (String) this.f56560a.get("previous_screen_name");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56560a.containsKey("meta") != aVar.f56560a.containsKey("meta")) {
                return false;
            }
            if (c() == null ? aVar.c() != null : !c().equals(aVar.c())) {
                return false;
            }
            if (this.f56560a.containsKey("stateToken") != aVar.f56560a.containsKey("stateToken")) {
                return false;
            }
            if (d() == null ? aVar.d() != null : !d().equals(aVar.d())) {
                return false;
            }
            if (this.f56560a.containsKey("mobileNo") != aVar.f56560a.containsKey("mobileNo")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            if (this.f56560a.containsKey("mode") != aVar.f56560a.containsKey("mode")) {
                return false;
            }
            if (f() == null ? aVar.f() != null : !f().equals(aVar.f())) {
                return false;
            }
            if (this.f56560a.containsKey("is_update_email") != aVar.f56560a.containsKey("is_update_email") || g() != aVar.g() || this.f56560a.containsKey("previous_screen_name") != aVar.f56560a.containsKey("previous_screen_name")) {
                return false;
            }
            if (h() == null ? aVar.h() != null : !h().equals(aVar.h())) {
                return false;
            }
            int i2 = R.id.navActionEmailOtp;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((((((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (e() != null ? e().hashCode() : 0)) * 31) + (f() != null ? f().hashCode() : 0)) * 31) + (g() ? 1 : 0)) * 31;
            if (h() != null) {
                i2 = h().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionEmailOtp;
        }

        public final String toString() {
            return "NavActionEmailOtp(actionId=" + R.id.navActionEmailOtp + "){meta=" + c() + ", stateToken=" + d() + ", mobileNo=" + e() + ", mode=" + f() + ", isUpdateEmail=" + g() + ", previousScreenName=" + h() + "}";
        }
    }

    public static class c implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56562a;

        /* synthetic */ c(byte b2) {
            this();
        }

        private c() {
            this.f56562a = new HashMap();
        }

        public final c a(String str) {
            this.f56562a.put("stateToken", str);
            return this;
        }

        public final c b(String str) {
            this.f56562a.put("verifierId", str);
            return this;
        }

        public final c c(String str) {
            this.f56562a.put("previous_screen_name", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56562a.containsKey("stateToken")) {
                bundle.putString("stateToken", (String) this.f56562a.get("stateToken"));
            }
            if (this.f56562a.containsKey("verifierId")) {
                bundle.putString("verifierId", (String) this.f56562a.get("verifierId"));
            }
            if (this.f56562a.containsKey("previous_screen_name")) {
                bundle.putString("previous_screen_name", (String) this.f56562a.get("previous_screen_name"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionSavedCardList;
        }

        private String c() {
            return (String) this.f56562a.get("stateToken");
        }

        private String d() {
            return (String) this.f56562a.get("verifierId");
        }

        private String e() {
            return (String) this.f56562a.get("previous_screen_name");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f56562a.containsKey("stateToken") != cVar.f56562a.containsKey("stateToken")) {
                return false;
            }
            if (c() == null ? cVar.c() != null : !c().equals(cVar.c())) {
                return false;
            }
            if (this.f56562a.containsKey("verifierId") != cVar.f56562a.containsKey("verifierId")) {
                return false;
            }
            if (d() == null ? cVar.d() != null : !d().equals(cVar.d())) {
                return false;
            }
            if (this.f56562a.containsKey("previous_screen_name") != cVar.f56562a.containsKey("previous_screen_name")) {
                return false;
            }
            if (e() == null ? cVar.e() != null : !e().equals(cVar.e())) {
                return false;
            }
            int i2 = R.id.navActionSavedCardList;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31;
            if (e() != null) {
                i2 = e().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionSavedCardList;
        }

        public final String toString() {
            return "NavActionSavedCardList(actionId=" + R.id.navActionSavedCardList + "){stateToken=" + c() + ", verifierId=" + d() + ", previousScreenName=" + e() + "}";
        }
    }
}
