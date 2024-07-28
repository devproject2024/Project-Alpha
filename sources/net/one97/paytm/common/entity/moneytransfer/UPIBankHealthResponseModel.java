package net.one97.paytm.common.entity.moneytransfer;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class UPIBankHealthResponseModel extends IJRPaytmDataModel {
    private String action;
    private String bankDown;
    private String category;
    private String msg;
    private String note;
    private String npciHealthCategory;
    private String respCode;
    private String respMessage;
    private String seqNo;
    private String status;
    private List<UPISuggestedBankModel> suggestedBank;

    public static /* synthetic */ UPIBankHealthResponseModel copy$default(UPIBankHealthResponseModel uPIBankHealthResponseModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List list, int i2, Object obj) {
        UPIBankHealthResponseModel uPIBankHealthResponseModel2 = uPIBankHealthResponseModel;
        int i3 = i2;
        return uPIBankHealthResponseModel.copy((i3 & 1) != 0 ? uPIBankHealthResponseModel2.status : str, (i3 & 2) != 0 ? uPIBankHealthResponseModel2.respCode : str2, (i3 & 4) != 0 ? uPIBankHealthResponseModel2.respMessage : str3, (i3 & 8) != 0 ? uPIBankHealthResponseModel2.seqNo : str4, (i3 & 16) != 0 ? uPIBankHealthResponseModel2.action : str5, (i3 & 32) != 0 ? uPIBankHealthResponseModel2.category : str6, (i3 & 64) != 0 ? uPIBankHealthResponseModel2.bankDown : str7, (i3 & 128) != 0 ? uPIBankHealthResponseModel2.msg : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? uPIBankHealthResponseModel2.note : str9, (i3 & 512) != 0 ? uPIBankHealthResponseModel2.npciHealthCategory : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? uPIBankHealthResponseModel2.suggestedBank : list);
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.npciHealthCategory;
    }

    public final List<UPISuggestedBankModel> component11() {
        return this.suggestedBank;
    }

    public final String component2() {
        return this.respCode;
    }

    public final String component3() {
        return this.respMessage;
    }

    public final String component4() {
        return this.seqNo;
    }

    public final String component5() {
        return this.action;
    }

    public final String component6() {
        return this.category;
    }

    public final String component7() {
        return this.bankDown;
    }

    public final String component8() {
        return this.msg;
    }

    public final String component9() {
        return this.note;
    }

    public final UPIBankHealthResponseModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<UPISuggestedBankModel> list) {
        return new UPIBankHealthResponseModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UPIBankHealthResponseModel)) {
            return false;
        }
        UPIBankHealthResponseModel uPIBankHealthResponseModel = (UPIBankHealthResponseModel) obj;
        return k.a((Object) this.status, (Object) uPIBankHealthResponseModel.status) && k.a((Object) this.respCode, (Object) uPIBankHealthResponseModel.respCode) && k.a((Object) this.respMessage, (Object) uPIBankHealthResponseModel.respMessage) && k.a((Object) this.seqNo, (Object) uPIBankHealthResponseModel.seqNo) && k.a((Object) this.action, (Object) uPIBankHealthResponseModel.action) && k.a((Object) this.category, (Object) uPIBankHealthResponseModel.category) && k.a((Object) this.bankDown, (Object) uPIBankHealthResponseModel.bankDown) && k.a((Object) this.msg, (Object) uPIBankHealthResponseModel.msg) && k.a((Object) this.note, (Object) uPIBankHealthResponseModel.note) && k.a((Object) this.npciHealthCategory, (Object) uPIBankHealthResponseModel.npciHealthCategory) && k.a((Object) this.suggestedBank, (Object) uPIBankHealthResponseModel.suggestedBank);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.respCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.seqNo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.action;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.category;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.bankDown;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.msg;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.note;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.npciHealthCategory;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        List<UPISuggestedBankModel> list = this.suggestedBank;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "UPIBankHealthResponseModel(status=" + this.status + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", seqNo=" + this.seqNo + ", action=" + this.action + ", category=" + this.category + ", bankDown=" + this.bankDown + ", msg=" + this.msg + ", note=" + this.note + ", npciHealthCategory=" + this.npciHealthCategory + ", suggestedBank=" + this.suggestedBank + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final void setRespCode(String str) {
        this.respCode = str;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final void setRespMessage(String str) {
        this.respMessage = str;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final void setSeqNo(String str) {
        this.seqNo = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getBankDown() {
        return this.bankDown;
    }

    public final void setBankDown(String str) {
        this.bankDown = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final String getNote() {
        return this.note;
    }

    public final void setNote(String str) {
        this.note = str;
    }

    public final String getNpciHealthCategory() {
        return this.npciHealthCategory;
    }

    public final void setNpciHealthCategory(String str) {
        this.npciHealthCategory = str;
    }

    public UPIBankHealthResponseModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, List<UPISuggestedBankModel> list) {
        this.status = str;
        this.respCode = str2;
        this.respMessage = str3;
        this.seqNo = str4;
        this.action = str5;
        this.category = str6;
        this.bankDown = str7;
        this.msg = str8;
        this.note = str9;
        this.npciHealthCategory = str10;
        this.suggestedBank = list;
    }

    public final List<UPISuggestedBankModel> getSuggestedBank() {
        return this.suggestedBank;
    }

    public final void setSuggestedBank(List<UPISuggestedBankModel> list) {
        this.suggestedBank = list;
    }
}
