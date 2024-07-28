package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CAQuestionDetailResponse extends IJRPaytmDataModel {
    @b(a = "agentTncStatus")
    private final Boolean agentTncStatus;
    @b(a = "entityType")
    private final String entityType;
    @b(a = "questionList")
    private final List<Question> questionList;
    @b(a = "solutionSubType")
    private final String solutionSubType;
    @b(a = "solutionType")
    private final String solutionType;

    public CAQuestionDetailResponse() {
        this((Boolean) null, (String) null, (List) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ CAQuestionDetailResponse copy$default(CAQuestionDetailResponse cAQuestionDetailResponse, Boolean bool, String str, List<Question> list, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = cAQuestionDetailResponse.agentTncStatus;
        }
        if ((i2 & 2) != 0) {
            str = cAQuestionDetailResponse.entityType;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            list = cAQuestionDetailResponse.questionList;
        }
        List<Question> list2 = list;
        if ((i2 & 8) != 0) {
            str2 = cAQuestionDetailResponse.solutionSubType;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = cAQuestionDetailResponse.solutionType;
        }
        return cAQuestionDetailResponse.copy(bool, str4, list2, str5, str3);
    }

    public final Boolean component1() {
        return this.agentTncStatus;
    }

    public final String component2() {
        return this.entityType;
    }

    public final List<Question> component3() {
        return this.questionList;
    }

    public final String component4() {
        return this.solutionSubType;
    }

    public final String component5() {
        return this.solutionType;
    }

    public final CAQuestionDetailResponse copy(Boolean bool, String str, List<Question> list, String str2, String str3) {
        return new CAQuestionDetailResponse(bool, str, list, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CAQuestionDetailResponse)) {
            return false;
        }
        CAQuestionDetailResponse cAQuestionDetailResponse = (CAQuestionDetailResponse) obj;
        return k.a((Object) this.agentTncStatus, (Object) cAQuestionDetailResponse.agentTncStatus) && k.a((Object) this.entityType, (Object) cAQuestionDetailResponse.entityType) && k.a((Object) this.questionList, (Object) cAQuestionDetailResponse.questionList) && k.a((Object) this.solutionSubType, (Object) cAQuestionDetailResponse.solutionSubType) && k.a((Object) this.solutionType, (Object) cAQuestionDetailResponse.solutionType);
    }

    public final int hashCode() {
        Boolean bool = this.agentTncStatus;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.entityType;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Question> list = this.questionList;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.solutionSubType;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.solutionType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CAQuestionDetailResponse(agentTncStatus=" + this.agentTncStatus + ", entityType=" + this.entityType + ", questionList=" + this.questionList + ", solutionSubType=" + this.solutionSubType + ", solutionType=" + this.solutionType + ")";
    }

    public final Boolean getAgentTncStatus() {
        return this.agentTncStatus;
    }

    public final String getEntityType() {
        return this.entityType;
    }

    public final List<Question> getQuestionList() {
        return this.questionList;
    }

    public final String getSolutionSubType() {
        return this.solutionSubType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CAQuestionDetailResponse(java.lang.Boolean r5, java.lang.String r6, java.util.List r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.ica.model.CAQuestionDetailResponse.<init>(java.lang.Boolean, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getSolutionType() {
        return this.solutionType;
    }

    public CAQuestionDetailResponse(Boolean bool, String str, List<Question> list, String str2, String str3) {
        this.agentTncStatus = bool;
        this.entityType = str;
        this.questionList = list;
        this.solutionSubType = str2;
        this.solutionType = str3;
    }
}
