package net.one97.paytm.games.model.pfg;

import com.google.gson.a.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.games.e.f;

public final class GameUserTransaction {
    @c(a = "amount")
    private String amount;
    @c(a = "createTime")
    private String createTime = "";
    @c(a = "createTimeStamp")
    private Long createTimeStamp;
    private String day;
    @c(a = "detailOrderId")
    private String detailOrderId;
    @c(a = "gameId")
    private String gameId;
    @c(a = "id")
    private String id;
    @c(a = "orderId")
    private String orderId;
    @c(a = "property")
    private String property;
    @c(a = "remark")
    private String remark;
    @c(a = "sourceSubaccountId")
    private String sourceSubaccountId;
    @c(a = "status")
    private Integer status;
    @c(a = "targetSubaccountId")
    private String targetSubaccountId;
    private String times = "";
    @c(a = "type")
    private Integer type;
    @c(a = "userId")
    private String userId;
    @c(a = "walletOrderId")
    private String walletOrderId;
    @c(a = "walletTransactionId")
    private String walletTransactionId;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final void setGameId(String str) {
        this.gameId = str;
    }

    public final String getProperty() {
        return this.property;
    }

    public final void setProperty(String str) {
        this.property = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    public final void setWalletTransactionId(String str) {
        this.walletTransactionId = str;
    }

    public final String getWalletOrderId() {
        return this.walletOrderId;
    }

    public final void setWalletOrderId(String str) {
        this.walletOrderId = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getSourceSubaccountId() {
        return this.sourceSubaccountId;
    }

    public final void setSourceSubaccountId(String str) {
        this.sourceSubaccountId = str;
    }

    public final String getDetailOrderId() {
        return this.detailOrderId;
    }

    public final void setDetailOrderId(String str) {
        this.detailOrderId = str;
    }

    public final String getTargetSubaccountId() {
        return this.targetSubaccountId;
    }

    public final void setTargetSubaccountId(String str) {
        this.targetSubaccountId = str;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final Long getCreateTimeStamp() {
        return this.createTimeStamp;
    }

    public final void setCreateTimeStamp(Long l) {
        this.createTimeStamp = l;
    }

    public final void setDay(String str) {
        this.day = str;
    }

    public final String getDay() {
        if (this.day == null) {
            this.day = f.a("MMM dd, yyyy", this.createTimeStamp);
        }
        return this.day;
    }

    public final void setTimes(String str) {
        k.c(str, "<set-?>");
        this.times = str;
    }

    public final String getTimes() {
        if (this.createTimeStamp == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a", Locale.ENGLISH);
        Long l = this.createTimeStamp;
        if (l == null) {
            k.a();
        }
        String format = simpleDateFormat.format(new Date(l.longValue()));
        k.a((Object) format, "SimpleDateFormat(\"HH:mm …(Date(createTimeStamp!!))");
        return format;
    }

    public final String getStatusName() {
        Integer num = this.status;
        if (num != null && num.intValue() == 1) {
            return "";
        }
        Integer num2 = this.status;
        return (num2 != null && num2.intValue() == 2) ? "Failure" : "In progress";
    }

    public final String getTypeName() {
        Integer num = this.type;
        if (num != null && num.intValue() == 1) {
            return "+";
        }
        Integer num2 = this.type;
        if (num2 != null && num2.intValue() == 4) {
            return "+";
        }
        Integer num3 = this.type;
        if (num3 != null && num3.intValue() == 5) {
            return "+";
        }
        Integer num4 = this.type;
        if (num4 != null && num4.intValue() == 6) {
            return "+";
        }
        Integer num5 = this.type;
        return (num5 != null && num5.intValue() == 12) ? "+" : "-";
    }
}
