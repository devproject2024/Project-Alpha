package net.one97.paytm.nativesdk.walletOtp;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Body {
    @c(a = "authenticated")
    private final Boolean authenticated;
    @c(a = "resultInfo")
    private final ResultInfo resultInfo;

    public Body() {
        this((Boolean) null, (ResultInfo) null, 3, (g) null);
    }

    public static /* synthetic */ Body copy$default(Body body, Boolean bool, ResultInfo resultInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = body.authenticated;
        }
        if ((i2 & 2) != 0) {
            resultInfo2 = body.resultInfo;
        }
        return body.copy(bool, resultInfo2);
    }

    public final Boolean component1() {
        return this.authenticated;
    }

    public final ResultInfo component2() {
        return this.resultInfo;
    }

    public final Body copy(Boolean bool, ResultInfo resultInfo2) {
        return new Body(bool, resultInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.authenticated, (Object) body.authenticated) && k.a((Object) this.resultInfo, (Object) body.resultInfo);
    }

    public final int hashCode() {
        Boolean bool = this.authenticated;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        ResultInfo resultInfo2 = this.resultInfo;
        if (resultInfo2 != null) {
            i2 = resultInfo2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Body(authenticated=" + this.authenticated + ", resultInfo=" + this.resultInfo + ")";
    }

    public Body(Boolean bool, ResultInfo resultInfo2) {
        this.authenticated = bool;
        this.resultInfo = resultInfo2;
    }

    public final Boolean getAuthenticated() {
        return this.authenticated;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Body(Boolean bool, ResultInfo resultInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? null : resultInfo2);
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }
}
