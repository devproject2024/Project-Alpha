package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class ICAUpdateLeadResponse extends IJRPaytmDataModel {
    @b(a = "agentKycStatus")
    private final boolean agentKycStatus;
    @b(a = "agentTncStatus")
    private final boolean agentTncStatus;
    @b(a = "entityToSolutionsMap")
    private final EntityToSolutionsMap entityToSolutionsMap;
    @b(a = "errorCode")
    private final String errorCode;
    @b(a = "message")
    private final String message;

    public ICAUpdateLeadResponse() {
        this(false, false, (EntityToSolutionsMap) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ ICAUpdateLeadResponse copy$default(ICAUpdateLeadResponse iCAUpdateLeadResponse, boolean z, boolean z2, EntityToSolutionsMap entityToSolutionsMap2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = iCAUpdateLeadResponse.agentKycStatus;
        }
        if ((i2 & 2) != 0) {
            z2 = iCAUpdateLeadResponse.agentTncStatus;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            entityToSolutionsMap2 = iCAUpdateLeadResponse.entityToSolutionsMap;
        }
        EntityToSolutionsMap entityToSolutionsMap3 = entityToSolutionsMap2;
        if ((i2 & 8) != 0) {
            str = iCAUpdateLeadResponse.errorCode;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = iCAUpdateLeadResponse.message;
        }
        return iCAUpdateLeadResponse.copy(z, z3, entityToSolutionsMap3, str3, str2);
    }

    public final boolean component1() {
        return this.agentKycStatus;
    }

    public final boolean component2() {
        return this.agentTncStatus;
    }

    public final EntityToSolutionsMap component3() {
        return this.entityToSolutionsMap;
    }

    public final String component4() {
        return this.errorCode;
    }

    public final String component5() {
        return this.message;
    }

    public final ICAUpdateLeadResponse copy(boolean z, boolean z2, EntityToSolutionsMap entityToSolutionsMap2, String str, String str2) {
        k.c(entityToSolutionsMap2, "entityToSolutionsMap");
        k.c(str, CLConstants.FIELD_ERROR_CODE);
        k.c(str2, "message");
        return new ICAUpdateLeadResponse(z, z2, entityToSolutionsMap2, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ICAUpdateLeadResponse) {
                ICAUpdateLeadResponse iCAUpdateLeadResponse = (ICAUpdateLeadResponse) obj;
                if (this.agentKycStatus == iCAUpdateLeadResponse.agentKycStatus) {
                    if (!(this.agentTncStatus == iCAUpdateLeadResponse.agentTncStatus) || !k.a((Object) this.entityToSolutionsMap, (Object) iCAUpdateLeadResponse.entityToSolutionsMap) || !k.a((Object) this.errorCode, (Object) iCAUpdateLeadResponse.errorCode) || !k.a((Object) this.message, (Object) iCAUpdateLeadResponse.message)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.agentKycStatus;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.agentTncStatus;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        EntityToSolutionsMap entityToSolutionsMap2 = this.entityToSolutionsMap;
        int i4 = 0;
        int hashCode = (i3 + (entityToSolutionsMap2 != null ? entityToSolutionsMap2.hashCode() : 0)) * 31;
        String str = this.errorCode;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return hashCode2 + i4;
    }

    public final String toString() {
        return "ICAUpdateLeadResponse(agentKycStatus=" + this.agentKycStatus + ", agentTncStatus=" + this.agentTncStatus + ", entityToSolutionsMap=" + this.entityToSolutionsMap + ", errorCode=" + this.errorCode + ", message=" + this.message + ")";
    }

    public final boolean getAgentKycStatus() {
        return this.agentKycStatus;
    }

    public final boolean getAgentTncStatus() {
        return this.agentTncStatus;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ICAUpdateLeadResponse(boolean r4, boolean r5, net.one97.paytm.bankOpen.ica.model.EntityToSolutionsMap r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = 0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r0 = r5
        L_0x000e:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0019
            net.one97.paytm.bankOpen.ica.model.EntityToSolutionsMap r6 = new net.one97.paytm.bankOpen.ica.model.EntityToSolutionsMap
            r4 = 3
            r5 = 0
            r6.<init>(r5, r5, r4, r5)
        L_0x0019:
            r1 = r6
            r4 = r9 & 8
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0022
            r2 = r5
            goto L_0x0023
        L_0x0022:
            r2 = r7
        L_0x0023:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0029
            r9 = r5
            goto L_0x002a
        L_0x0029:
            r9 = r8
        L_0x002a:
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.model.ICAUpdateLeadResponse.<init>(boolean, boolean, net.one97.paytm.bankOpen.ica.model.EntityToSolutionsMap, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final EntityToSolutionsMap getEntityToSolutionsMap() {
        return this.entityToSolutionsMap;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public ICAUpdateLeadResponse(boolean z, boolean z2, EntityToSolutionsMap entityToSolutionsMap2, String str, String str2) {
        k.c(entityToSolutionsMap2, "entityToSolutionsMap");
        k.c(str, CLConstants.FIELD_ERROR_CODE);
        k.c(str2, "message");
        this.agentKycStatus = z;
        this.agentTncStatus = z2;
        this.entityToSolutionsMap = entityToSolutionsMap2;
        this.errorCode = str;
        this.message = str2;
    }
}
