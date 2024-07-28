package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;

public final class l {
    public static b a() {
        return new b((byte) 0);
    }

    public static a b() {
        return new a((byte) 0);
    }

    public static class b implements androidx.navigation.l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56603a;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.f56603a = new HashMap();
        }

        public final b a(String str) {
            this.f56603a.put("verifierId", str);
            return this;
        }

        public final b b(String str) {
            this.f56603a.put("mobile", str);
            return this;
        }

        public final b c(String str) {
            this.f56603a.put("stateCode", str);
            return this;
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56603a.containsKey("verifierId")) {
                bundle.putString("verifierId", (String) this.f56603a.get("verifierId"));
            }
            if (this.f56603a.containsKey("mobile")) {
                bundle.putString("mobile", (String) this.f56603a.get("mobile"));
            }
            if (this.f56603a.containsKey("stateCode")) {
                bundle.putString("stateCode", (String) this.f56603a.get("stateCode"));
            }
            return bundle;
        }

        public final int a() {
            return R.id.navActionAccountUnblockVerifyOtp;
        }

        private String c() {
            return (String) this.f56603a.get("verifierId");
        }

        private String d() {
            return (String) this.f56603a.get("mobile");
        }

        private String e() {
            return (String) this.f56603a.get("stateCode");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f56603a.containsKey("verifierId") != bVar.f56603a.containsKey("verifierId")) {
                return false;
            }
            if (c() == null ? bVar.c() != null : !c().equals(bVar.c())) {
                return false;
            }
            if (this.f56603a.containsKey("mobile") != bVar.f56603a.containsKey("mobile")) {
                return false;
            }
            if (d() == null ? bVar.d() != null : !d().equals(bVar.d())) {
                return false;
            }
            if (this.f56603a.containsKey("stateCode") != bVar.f56603a.containsKey("stateCode")) {
                return false;
            }
            if (e() == null ? bVar.e() != null : !e().equals(bVar.e())) {
                return false;
            }
            int i2 = R.id.navActionAccountUnblockVerifyOtp;
            return true;
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = ((((c() != null ? c().hashCode() : 0) + 31) * 31) + (d() != null ? d().hashCode() : 0)) * 31;
            if (e() != null) {
                i2 = e().hashCode();
            }
            return ((hashCode + i2) * 31) + R.id.navActionAccountUnblockVerifyOtp;
        }

        public final String toString() {
            return "NavActionAccountUnblockVerifyOtp(actionId=" + R.id.navActionAccountUnblockVerifyOtp + "){verifierId=" + c() + ", mobile=" + d() + ", stateCode=" + e() + "}";
        }
    }

    public static class a implements androidx.navigation.l {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap f56602a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f56602a = new HashMap();
        }

        public final a c() {
            this.f56602a.put("isAccountBlockCase", Boolean.FALSE);
            return this;
        }

        public final a a(TerminalPageState terminalPageState) {
            if (terminalPageState != null) {
                this.f56602a.put("net.one97.paytm.oauth.utils.TerminalPageState", terminalPageState);
                return this;
            }
            throw new IllegalArgumentException("Argument \"net.one97.paytm.oauth.utils.TerminalPageState\" is marked as non-null but was passed a null value.");
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            if (this.f56602a.containsKey("isAccountBlockCase")) {
                bundle.putBoolean("isAccountBlockCase", ((Boolean) this.f56602a.get("isAccountBlockCase")).booleanValue());
            }
            if (this.f56602a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
                TerminalPageState terminalPageState = (TerminalPageState) this.f56602a.get("net.one97.paytm.oauth.utils.TerminalPageState");
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
            return ((Boolean) this.f56602a.get("isAccountBlockCase")).booleanValue();
        }

        private TerminalPageState e() {
            return (TerminalPageState) this.f56602a.get("net.one97.paytm.oauth.utils.TerminalPageState");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f56602a.containsKey("isAccountBlockCase") != aVar.f56602a.containsKey("isAccountBlockCase") || d() != aVar.d() || this.f56602a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState") != aVar.f56602a.containsKey("net.one97.paytm.oauth.utils.TerminalPageState")) {
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
}
