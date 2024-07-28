package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.l;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class r {
    public static a a() {
        return new a((byte) 0);
    }

    public static b b() {
        return new b((byte) 0);
    }

    public static class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56610a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56610a = new HashMap();
        }

        public final a c() {
            this.f56610a.put("isAccountBlockCase", Boolean.FALSE);
            return this;
        }

        public final a a(TerminalPageState terminalPageState) {
            if (terminalPageState != null) {
                this.f56610a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                return this;
            }
            throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56610a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56610a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56610a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56610a.get("net.one97.paytm.oauth.utils.TerminalPageState");
                if (Parcelable.class.isAssignableFrom(TerminalPageState.class) || terminalPageState == null) {
                    bundle.putParcelable("net.one97.paytm.oauth.utils.TerminalPageState", Parcelable.class.cast(terminalPageState));
                } else if (Serializable.class.isAssignableFrom(TerminalPageState.class)) {
                    bundle.putSerializable("net.one97.paytm.oauth.utils.TerminalPageState", Serializable.class.cast(terminalPageState));
                } else {
                    throw new UnsupportedOperationException(TerminalPageState.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountBlockTerminal;
        }

        private boolean d() {
            return ((Boolean) this.f56610a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56610a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56610a.containsKey("isAccountBlockCase") != aVar.f56610a.containsKey("isAccountBlockCase") || d() != aVar.d() || this.f56610a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != aVar.f56610a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                return false;
            }
            if (e() == null ? aVar.e() != null : !e().equals(aVar.e())) {
                return false;
            }
            int i2 = R.id.navActionAccountBlockTerminal;
            return true;
        }

        public final int hashCode() {
            return (((((d() ? 1 : 0) + true) * 31) + (e() != null ? e().hashCode() : 0)) * 31) + R.id.navActionAccountBlockTerminal;
        }

        public final String toString() {
            return "NavActionAccountBlockTerminal(actionId=" + R.id.navActionAccountBlockTerminal + "){isAccountBlockCase=" + d() + ", netOne97PaytmOauthUtilsTerminalPageState=" + e() + "}";
        }
    }

    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56611a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56611a = new HashMap();
        }

        public final b a(String str) {
            this.f56611a.put("stateCode", str);
            return this;
        }

        public final b b(String str) {
            this.f56611a.put("mobile", str);
            return this;
        }

        public final b c(String str) {
            this.f56611a.put("verifierId", str);
            return this;
        }

        public final b d(String str) {
            this.f56611a.put("lastFourDigit", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56611a.containsKey("stateCode")) {
                bundle.putString("stateCode", (String) this.f56611a.get("stateCode"));
            }
            if (this.f56611a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56611a.get("mobile"));
            }
            if (this.f56611a.containsKey("verifierId")) {
                bundle.putString("verifierId", (String) this.f56611a.get("verifierId"));
            }
            if (this.f56611a.containsKey("lastFourDigit")) {
                bundle.putString("lastFourDigit", (String) this.f56611a.get("lastFourDigit"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountUnblockSavedCard;
        }

        private String c() {
            return (String) this.f56611a.get("stateCode");
        }

        private String d() {
            return (String) this.f56611a.get("mobile");
        }

        private String e() {
            return (String) this.f56611a.get("verifierId");
        }

        private String f() {
            return (String) this.f56611a.get("lastFourDigit");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56611a.containsKey("stateCode") != bVar.f56611a.containsKey("stateCode")) {
                return false;
            }
            if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
                return false;
            }
            if (this.f56611a.containsKey("mobile") != bVar.f56611a.containsKey("mobile")) {
                return false;
            }
            if (d() == null ? bVar.d() != null : !d().equals(bVar.d())) {
                return false;
            }
            if (this.f56611a.containsKey("verifierId") != bVar.f56611a.containsKey("verifierId")) {
                return false;
            }
            if (e() == null ? bVar.e() != null : !e().equals(bVar.e())) {
                return false;
            }
            if (this.f56611a.containsKey("lastFourDigit") != bVar.f56611a.containsKey("lastFourDigit")) {
                return false;
            }
            if (f() == null ? bVar.f() != null : !f().equals(bVar.f())) {
                return false;
            }
            int i2 = R.id.navActionAccountUnblockSavedCard;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (e() != null ? e().hashCode() : 0)) * 31;
            if (f() != null) {
                i2 = f().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionAccountUnblockSavedCard;
        }

        public final String toString() {
            return "NavActionAccountUnblockSavedCard(actionId=" + R.id.navActionAccountUnblockSavedCard + "){stateCode=" + c() + ", mobile=" + d() + ", verifierId=" + e() + ", lastFourDigit=" + f() + "}";
        }
    }
}
