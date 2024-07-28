package net.one97.paytm.recharge.domain.entities;

import android.content.Context;
import android.graphics.Color;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.widgets.c.d;

public final class CJRAutomaticSubscriptionHistory implements IJRDataModel {
    public static final Companion Companion = new Companion((g) null);
    public static final String FAILURE = "Failure";
    public static final String PAYMENT_FAILURE = "Payment Failure";
    public static final String PROCESSING = "Processing";
    public static final String SUCCESS = "Success";
    private int colorCode;
    @b(a = "order_id")
    private final String orderId;
    @b(a = "pay_amt")
    private String payAmount;
    @b(a = "pay_date")
    private String payDate;
    @b(a = "pay_status")
    private String payStatus;
    @b(a = "pay_status_code")
    private int payStatusCode;
    private int position;
    private Integer statusColor;

    public static /* synthetic */ CJRAutomaticSubscriptionHistory copy$default(CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory, String str, String str2, String str3, String str4, int i2, int i3, Integer num, int i4, int i5, Object obj) {
        CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory2 = cJRAutomaticSubscriptionHistory;
        int i6 = i5;
        return cJRAutomaticSubscriptionHistory.copy((i6 & 1) != 0 ? cJRAutomaticSubscriptionHistory2.orderId : str, (i6 & 2) != 0 ? cJRAutomaticSubscriptionHistory2.payDate : str2, (i6 & 4) != 0 ? cJRAutomaticSubscriptionHistory2.payAmount : str3, (i6 & 8) != 0 ? cJRAutomaticSubscriptionHistory2.payStatus : str4, (i6 & 16) != 0 ? cJRAutomaticSubscriptionHistory2.payStatusCode : i2, (i6 & 32) != 0 ? cJRAutomaticSubscriptionHistory2.colorCode : i3, (i6 & 64) != 0 ? cJRAutomaticSubscriptionHistory2.statusColor : num, (i6 & 128) != 0 ? cJRAutomaticSubscriptionHistory2.position : i4);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.payDate;
    }

    public final String component3() {
        return this.payAmount;
    }

    public final String component4() {
        return this.payStatus;
    }

    public final int component5() {
        return this.payStatusCode;
    }

    public final int component6() {
        return this.colorCode;
    }

    public final Integer component7() {
        return this.statusColor;
    }

    public final int component8() {
        return this.position;
    }

    public final CJRAutomaticSubscriptionHistory copy(String str, String str2, String str3, String str4, int i2, int i3, Integer num, int i4) {
        k.c(str, "orderId");
        k.c(str2, "payDate");
        k.c(str3, "payAmount");
        k.c(str4, "payStatus");
        return new CJRAutomaticSubscriptionHistory(str, str2, str3, str4, i2, i3, num, i4);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRAutomaticSubscriptionHistory) {
                CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory = (CJRAutomaticSubscriptionHistory) obj;
                if (k.a((Object) this.orderId, (Object) cJRAutomaticSubscriptionHistory.orderId) && k.a((Object) this.payDate, (Object) cJRAutomaticSubscriptionHistory.payDate) && k.a((Object) this.payAmount, (Object) cJRAutomaticSubscriptionHistory.payAmount) && k.a((Object) this.payStatus, (Object) cJRAutomaticSubscriptionHistory.payStatus)) {
                    if (this.payStatusCode == cJRAutomaticSubscriptionHistory.payStatusCode) {
                        if ((this.colorCode == cJRAutomaticSubscriptionHistory.colorCode) && k.a((Object) this.statusColor, (Object) cJRAutomaticSubscriptionHistory.statusColor)) {
                            if (this.position == cJRAutomaticSubscriptionHistory.position) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payAmount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payStatus;
        int hashCode4 = (((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.payStatusCode) * 31) + this.colorCode) * 31;
        Integer num = this.statusColor;
        if (num != null) {
            i2 = num.hashCode();
        }
        return ((hashCode4 + i2) * 31) + this.position;
    }

    public final String toString() {
        return "CJRAutomaticSubscriptionHistory(orderId=" + this.orderId + ", payDate=" + this.payDate + ", payAmount=" + this.payAmount + ", payStatus=" + this.payStatus + ", payStatusCode=" + this.payStatusCode + ", colorCode=" + this.colorCode + ", statusColor=" + this.statusColor + ", position=" + this.position + ")";
    }

    public CJRAutomaticSubscriptionHistory(String str, String str2, String str3, String str4, int i2, int i3, Integer num, int i4) {
        k.c(str, "orderId");
        k.c(str2, "payDate");
        k.c(str3, "payAmount");
        k.c(str4, "payStatus");
        this.orderId = str;
        this.payDate = str2;
        this.payAmount = str3;
        this.payStatus = str4;
        this.payStatusCode = i2;
        this.colorCode = i3;
        this.statusColor = num;
        this.position = i4;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPayDate() {
        return this.payDate;
    }

    public final void setPayDate(String str) {
        k.c(str, "<set-?>");
        this.payDate = str;
    }

    public final String getPayAmount() {
        return this.payAmount;
    }

    public final void setPayAmount(String str) {
        k.c(str, "<set-?>");
        this.payAmount = str;
    }

    public final String getPayStatus() {
        return this.payStatus;
    }

    public final void setPayStatus(String str) {
        k.c(str, "<set-?>");
        this.payStatus = str;
    }

    public final int getPayStatusCode() {
        return this.payStatusCode;
    }

    public final void setPayStatusCode(int i2) {
        this.payStatusCode = i2;
    }

    public final int getColorCode() {
        return this.colorCode;
    }

    public final void setColorCode(int i2) {
        this.colorCode = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAutomaticSubscriptionHistory(String str, String str2, String str3, String str4, int i2, int i3, Integer num, int i4, int i5, g gVar) {
        this(str, str2, str3, str4, i2, i3, (i5 & 64) != 0 ? null : num, i4);
    }

    public final Integer getStatusColor() {
        return this.statusColor;
    }

    public final void setStatusColor(Integer num) {
        this.statusColor = num;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final int isVisible() {
        return Color.parseColor("#ffffff") != this.colorCode ? 1 : 0;
    }

    public final String getDate() {
        String str = this.payDate;
        int length = str.length();
        if (str != null) {
            String substring = str.substring(12, length);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String getPaymentText(Context context) {
        String str;
        k.c(context, "context");
        if (this.payStatus.equals(PAYMENT_FAILURE) || p.a(this.payStatus, "Failure", true)) {
            this.statusColor = Integer.valueOf(androidx.core.content.b.c(context, R.color.recharge_order_failed));
            str = context.getString(R.string.payment_status_failure);
        } else if (this.payStatus.equals("Success")) {
            this.statusColor = Integer.valueOf(androidx.core.content.b.c(context, R.color.recharge_order_success));
            str = context.getString(R.string.payment_status_success);
        } else {
            this.statusColor = Integer.valueOf(androidx.core.content.b.c(context, R.color.recharge_order_pending));
            str = context.getString(R.string.payment_staus_pending);
        }
        k.a((Object) str, "if(payStatus.equals(PAYM…_staus_pending)\n        }");
        int i2 = R.string.payment_history_status_tx;
        d dVar = d.f64967a;
        String string = context.getString(i2, new Object[]{d.a(this.payAmount, true, 0, false, 12), str});
        k.a((Object) string, "context.getString(R.stri…payAmount, true), status)");
        return string;
    }

    public final Integer getStatusIconBackGround() {
        return this.statusColor;
    }

    public final int getPaymentStatusCode() {
        int i2 = this.payStatusCode;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return this.payStatusCode;
        }
        if (p.a(PAYMENT_FAILURE, this.payStatus, true)) {
            return 4;
        }
        if (p.a("Success", this.payStatus, true)) {
            return 3;
        }
        if (p.a(PROCESSING, this.payStatus, true)) {
            return 1;
        }
        if (p.a("Failure", this.payStatus, true)) {
            return 2;
        }
        return 0;
    }
}
