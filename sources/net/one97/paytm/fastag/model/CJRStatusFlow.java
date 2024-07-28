package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRStatusFlow extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "colour")
    String mColor;
    @b(a = "created_at")
    String mCreatedAt;
    @b(a = "id")
    String mId;
    @b(a = "isCurrentStatus")
    boolean mIsCurrentStatus;
    @b(a = "is_sla_date")
    boolean mIsSLADate;
    @b(a = "sequence_number")
    String mSequenceNum;
    @b(a = "details")
    private CJRStatusDetails mStatusDetails;
    @b(a = "text")
    private String mText;

    public CJRStatusFlow(String str, String str2, String str3, String str4) {
        this.mId = str;
        this.mColor = str2;
        this.mText = str3;
        this.mCreatedAt = str4;
    }

    public String getId() {
        return this.mId;
    }

    public String getColor() {
        return this.mColor;
    }

    public String getmCreatedAt() {
        return this.mCreatedAt;
    }

    public String getText() {
        return this.mText;
    }

    public boolean ismIsCurrentStatus() {
        return this.mIsCurrentStatus;
    }

    public CJRStatusDetails getmStatusDetails() {
        return this.mStatusDetails;
    }

    public void setmStatusDetails(CJRStatusDetails cJRStatusDetails) {
        this.mStatusDetails = cJRStatusDetails;
    }
}
