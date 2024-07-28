package net.one97.paytm.recharge.domain.entities;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRAutomaticSubscriptionItemModel implements IJRDataModel {
    @b(a = "creation_date")
    private String creationDate;
    @b(a = "days_before_renewal")
    private int daysBeforeRenewal;
    @b(a = "due_amt")
    private String dueAmt;
    @b(a = "due_date")
    private String dueDate;
    @b(a = "history")
    private List<CJRAutomaticSubscriptionHistory> history;
    private String issuerDisplayName;
    @b(a = "nickname")
    private String nickname;
    @b(a = "parent_order_id")
    private final long parentOrderId;
    @b(a = "payment_bank")
    private String paymentBank;
    @b(a = "payment_date")
    private String paymentDate;
    @b(a = "paymentInfo")
    private AutomaticProductInfo paymentInfo;
    @b(a = "pay_mode")
    private String paymentMode;
    @b(a = "pg_subscription_id")
    private final String pgSubscriptionId;
    @b(a = "product")
    private final CJRAutomaticSubscriptionProductModel product;
    @b(a = "product_id")
    private long productId;
    @b(a = "recharge_number")
    private final String rechargeNumber;
    @b(a = "status")
    private int status;
    @b(a = "subscription_id")
    private final long subscriptionId;

    public static /* synthetic */ CJRAutomaticSubscriptionItemModel copy$default(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, List list, long j, long j2, String str, String str2, String str3, String str4, int i2, String str5, long j3, CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel, AutomaticProductInfo automaticProductInfo, String str6, String str7, int i3, String str8, String str9, String str10, int i4, Object obj) {
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel2 = cJRAutomaticSubscriptionItemModel;
        int i5 = i4;
        return cJRAutomaticSubscriptionItemModel.copy((i5 & 1) != 0 ? cJRAutomaticSubscriptionItemModel2.history : list, (i5 & 2) != 0 ? cJRAutomaticSubscriptionItemModel2.parentOrderId : j, (i5 & 4) != 0 ? cJRAutomaticSubscriptionItemModel2.subscriptionId : j2, (i5 & 8) != 0 ? cJRAutomaticSubscriptionItemModel2.pgSubscriptionId : str, (i5 & 16) != 0 ? cJRAutomaticSubscriptionItemModel2.rechargeNumber : str2, (i5 & 32) != 0 ? cJRAutomaticSubscriptionItemModel2.dueDate : str3, (i5 & 64) != 0 ? cJRAutomaticSubscriptionItemModel2.creationDate : str4, (i5 & 128) != 0 ? cJRAutomaticSubscriptionItemModel2.status : i2, (i5 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRAutomaticSubscriptionItemModel2.dueAmt : str5, (i5 & 512) != 0 ? cJRAutomaticSubscriptionItemModel2.productId : j3, (i5 & TarConstants.EOF_BLOCK) != 0 ? cJRAutomaticSubscriptionItemModel2.product : cJRAutomaticSubscriptionProductModel, (i5 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRAutomaticSubscriptionItemModel2.paymentInfo : automaticProductInfo, (i5 & 4096) != 0 ? cJRAutomaticSubscriptionItemModel2.nickname : str6, (i5 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRAutomaticSubscriptionItemModel2.paymentMode : str7, (i5 & 16384) != 0 ? cJRAutomaticSubscriptionItemModel2.daysBeforeRenewal : i3, (i5 & 32768) != 0 ? cJRAutomaticSubscriptionItemModel2.paymentDate : str8, (i5 & 65536) != 0 ? cJRAutomaticSubscriptionItemModel2.paymentBank : str9, (i5 & 131072) != 0 ? cJRAutomaticSubscriptionItemModel2.issuerDisplayName : str10);
    }

    public final List<CJRAutomaticSubscriptionHistory> component1() {
        return this.history;
    }

    public final long component10() {
        return this.productId;
    }

    public final CJRAutomaticSubscriptionProductModel component11() {
        return this.product;
    }

    public final AutomaticProductInfo component12() {
        return this.paymentInfo;
    }

    public final String component13() {
        return this.nickname;
    }

    public final String component14() {
        return this.paymentMode;
    }

    public final int component15() {
        return this.daysBeforeRenewal;
    }

    public final String component16() {
        return this.paymentDate;
    }

    public final String component17() {
        return this.paymentBank;
    }

    public final String component18() {
        return this.issuerDisplayName;
    }

    public final long component2() {
        return this.parentOrderId;
    }

    public final long component3() {
        return this.subscriptionId;
    }

    public final String component4() {
        return this.pgSubscriptionId;
    }

    public final String component5() {
        return this.rechargeNumber;
    }

    public final String component6() {
        return this.dueDate;
    }

    public final String component7() {
        return this.creationDate;
    }

    public final int component8() {
        return this.status;
    }

    public final String component9() {
        return this.dueAmt;
    }

    public final CJRAutomaticSubscriptionItemModel copy(List<CJRAutomaticSubscriptionHistory> list, long j, long j2, String str, String str2, String str3, String str4, int i2, String str5, long j3, CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel, AutomaticProductInfo automaticProductInfo, String str6, String str7, int i3, String str8, String str9, String str10) {
        List<CJRAutomaticSubscriptionHistory> list2 = list;
        k.c(str, "pgSubscriptionId");
        k.c(str2, "rechargeNumber");
        k.c(str4, "creationDate");
        k.c(cJRAutomaticSubscriptionProductModel, "product");
        k.c(str6, "nickname");
        k.c(str7, "paymentMode");
        return new CJRAutomaticSubscriptionItemModel(list, j, j2, str, str2, str3, str4, i2, str5, j3, cJRAutomaticSubscriptionProductModel, automaticProductInfo, str6, str7, i3, str8, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRAutomaticSubscriptionItemModel) {
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) obj;
                if (k.a((Object) this.history, (Object) cJRAutomaticSubscriptionItemModel.history)) {
                    if (this.parentOrderId == cJRAutomaticSubscriptionItemModel.parentOrderId) {
                        if ((this.subscriptionId == cJRAutomaticSubscriptionItemModel.subscriptionId) && k.a((Object) this.pgSubscriptionId, (Object) cJRAutomaticSubscriptionItemModel.pgSubscriptionId) && k.a((Object) this.rechargeNumber, (Object) cJRAutomaticSubscriptionItemModel.rechargeNumber) && k.a((Object) this.dueDate, (Object) cJRAutomaticSubscriptionItemModel.dueDate) && k.a((Object) this.creationDate, (Object) cJRAutomaticSubscriptionItemModel.creationDate)) {
                            if ((this.status == cJRAutomaticSubscriptionItemModel.status) && k.a((Object) this.dueAmt, (Object) cJRAutomaticSubscriptionItemModel.dueAmt)) {
                                if ((this.productId == cJRAutomaticSubscriptionItemModel.productId) && k.a((Object) this.product, (Object) cJRAutomaticSubscriptionItemModel.product) && k.a((Object) this.paymentInfo, (Object) cJRAutomaticSubscriptionItemModel.paymentInfo) && k.a((Object) this.nickname, (Object) cJRAutomaticSubscriptionItemModel.nickname) && k.a((Object) this.paymentMode, (Object) cJRAutomaticSubscriptionItemModel.paymentMode)) {
                                    if (!(this.daysBeforeRenewal == cJRAutomaticSubscriptionItemModel.daysBeforeRenewal) || !k.a((Object) this.paymentDate, (Object) cJRAutomaticSubscriptionItemModel.paymentDate) || !k.a((Object) this.paymentBank, (Object) cJRAutomaticSubscriptionItemModel.paymentBank) || !k.a((Object) this.issuerDisplayName, (Object) cJRAutomaticSubscriptionItemModel.issuerDisplayName)) {
                                        return false;
                                    }
                                }
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
        List<CJRAutomaticSubscriptionHistory> list = this.history;
        int i2 = 0;
        int hashCode = list != null ? list.hashCode() : 0;
        long j = this.parentOrderId;
        long j2 = this.subscriptionId;
        int i3 = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.pgSubscriptionId;
        int hashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.rechargeNumber;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.dueDate;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.creationDate;
        int hashCode5 = (((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.status) * 31;
        String str5 = this.dueAmt;
        int hashCode6 = str5 != null ? str5.hashCode() : 0;
        long j3 = this.productId;
        int i4 = (((hashCode5 + hashCode6) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel = this.product;
        int hashCode7 = (i4 + (cJRAutomaticSubscriptionProductModel != null ? cJRAutomaticSubscriptionProductModel.hashCode() : 0)) * 31;
        AutomaticProductInfo automaticProductInfo = this.paymentInfo;
        int hashCode8 = (hashCode7 + (automaticProductInfo != null ? automaticProductInfo.hashCode() : 0)) * 31;
        String str6 = this.nickname;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.paymentMode;
        int hashCode10 = (((hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.daysBeforeRenewal) * 31;
        String str8 = this.paymentDate;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.paymentBank;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.issuerDisplayName;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "CJRAutomaticSubscriptionItemModel(history=" + this.history + ", parentOrderId=" + this.parentOrderId + ", subscriptionId=" + this.subscriptionId + ", pgSubscriptionId=" + this.pgSubscriptionId + ", rechargeNumber=" + this.rechargeNumber + ", dueDate=" + this.dueDate + ", creationDate=" + this.creationDate + ", status=" + this.status + ", dueAmt=" + this.dueAmt + ", productId=" + this.productId + ", product=" + this.product + ", paymentInfo=" + this.paymentInfo + ", nickname=" + this.nickname + ", paymentMode=" + this.paymentMode + ", daysBeforeRenewal=" + this.daysBeforeRenewal + ", paymentDate=" + this.paymentDate + ", paymentBank=" + this.paymentBank + ", issuerDisplayName=" + this.issuerDisplayName + ")";
    }

    public CJRAutomaticSubscriptionItemModel(List<CJRAutomaticSubscriptionHistory> list, long j, long j2, String str, String str2, String str3, String str4, int i2, String str5, long j3, CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel, AutomaticProductInfo automaticProductInfo, String str6, String str7, int i3, String str8, String str9, String str10) {
        String str11 = str2;
        String str12 = str4;
        CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel2 = cJRAutomaticSubscriptionProductModel;
        String str13 = str6;
        String str14 = str7;
        k.c(str, "pgSubscriptionId");
        k.c(str11, "rechargeNumber");
        k.c(str12, "creationDate");
        k.c(cJRAutomaticSubscriptionProductModel2, "product");
        k.c(str13, "nickname");
        k.c(str14, "paymentMode");
        this.history = list;
        this.parentOrderId = j;
        this.subscriptionId = j2;
        this.pgSubscriptionId = str;
        this.rechargeNumber = str11;
        this.dueDate = str3;
        this.creationDate = str12;
        this.status = i2;
        this.dueAmt = str5;
        this.productId = j3;
        this.product = cJRAutomaticSubscriptionProductModel2;
        this.paymentInfo = automaticProductInfo;
        this.nickname = str13;
        this.paymentMode = str14;
        this.daysBeforeRenewal = i3;
        this.paymentDate = str8;
        this.paymentBank = str9;
        this.issuerDisplayName = str10;
    }

    public final List<CJRAutomaticSubscriptionHistory> getHistory() {
        return this.history;
    }

    public final void setHistory(List<CJRAutomaticSubscriptionHistory> list) {
        this.history = list;
    }

    public final long getParentOrderId() {
        return this.parentOrderId;
    }

    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getPgSubscriptionId() {
        return this.pgSubscriptionId;
    }

    public final String getRechargeNumber() {
        return this.rechargeNumber;
    }

    public final String getDueDate() {
        return this.dueDate;
    }

    public final void setDueDate(String str) {
        this.dueDate = str;
    }

    public final String getCreationDate() {
        return this.creationDate;
    }

    public final void setCreationDate(String str) {
        k.c(str, "<set-?>");
        this.creationDate = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public final String getDueAmt() {
        return this.dueAmt;
    }

    public final void setDueAmt(String str) {
        this.dueAmt = str;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final void setProductId(long j) {
        this.productId = j;
    }

    public final CJRAutomaticSubscriptionProductModel getProduct() {
        return this.product;
    }

    public final AutomaticProductInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    public final void setPaymentInfo(AutomaticProductInfo automaticProductInfo) {
        this.paymentInfo = automaticProductInfo;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        k.c(str, "<set-?>");
        this.nickname = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        k.c(str, "<set-?>");
        this.paymentMode = str;
    }

    public final int getDaysBeforeRenewal() {
        return this.daysBeforeRenewal;
    }

    public final void setDaysBeforeRenewal(int i2) {
        this.daysBeforeRenewal = i2;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final void setPaymentDate(String str) {
        this.paymentDate = str;
    }

    public final String getPaymentBank() {
        return this.paymentBank;
    }

    public final void setPaymentBank(String str) {
        this.paymentBank = str;
    }

    public final String getIssuerDisplayName() {
        return this.issuerDisplayName;
    }

    public final void setIssuerDisplayName(String str) {
        this.issuerDisplayName = str;
    }

    public final String getLastBillPaidDate() {
        List<CJRAutomaticSubscriptionHistory> list = this.history;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<CJRAutomaticSubscriptionHistory> list2 = this.history;
        if (list2 == null) {
            k.a();
        }
        return list2.get(0).getDate();
    }

    public final String getLastBillPaidAmount() {
        List<CJRAutomaticSubscriptionHistory> list = this.history;
        if (list == null || !(!list.isEmpty())) {
            return "";
        }
        List<CJRAutomaticSubscriptionHistory> list2 = this.history;
        if (list2 == null) {
            k.a();
        }
        return list2.get(0).getPayAmount();
    }

    public final int getPaymentStatusCode() {
        List<CJRAutomaticSubscriptionHistory> list = this.history;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        List<CJRAutomaticSubscriptionHistory> list2 = this.history;
        if (list2 == null) {
            k.a();
        }
        return list2.get(0).getPaymentStatusCode();
    }

    public final String getAutomaticPaymentStatusMessage(Context context) {
        String str;
        k.c(context, "context");
        if (!(this.dueDate == null || this.paymentDate == null || TextUtils.isEmpty(this.dueAmt))) {
            h.a aVar = h.f60252a;
            String str2 = this.dueAmt;
            if (str2 == null) {
                k.a();
            }
            if (h.a.a(str2)) {
                int i2 = R.string.subscription_amount_due;
                Object[] objArr = new Object[2];
                h.a aVar2 = h.f60252a;
                String str3 = this.dueAmt;
                if (str3 == null) {
                    k.a();
                }
                objArr[0] = h.a.b(str3);
                objArr[1] = this.dueDate;
                String string = context.getString(i2, objArr);
                k.a((Object) string, "context.getString(R.stri…cimal(dueAmt!!), dueDate)");
                return string;
            }
        }
        List<CJRAutomaticSubscriptionHistory> list = this.history;
        if (list != null) {
            if (list == null) {
                k.a();
            }
            if (list.size() != 0) {
                List<CJRAutomaticSubscriptionHistory> list2 = this.history;
                if (list2 == null) {
                    k.a();
                }
                int payStatusCode = list2.get(0).getPayStatusCode();
                if (payStatusCode != 1) {
                    if (payStatusCode != 2) {
                        if (payStatusCode == 3) {
                            int i3 = R.string.automatic_subscription_success_msg;
                            h.a aVar3 = h.f60252a;
                            str = context.getString(i3, new Object[]{h.a.c(getLastBillPaidAmount()), getLastBillPaidDate()});
                        } else if (payStatusCode != 4) {
                            int i4 = R.string.last_bill_paid_amount_on_date;
                            h.a aVar4 = h.f60252a;
                            str = context.getString(i4, new Object[]{h.a.c(getLastBillPaidAmount()), getLastBillPaidDate()});
                        }
                    }
                    Calendar instance = Calendar.getInstance();
                    k.a((Object) instance, "Calendar.getInstance()");
                    Date time = instance.getTime();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                    String str4 = null;
                    try {
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(context.getString(R.string.data_format_yy_mm_dd_hh_mm_ss), Locale.ENGLISH);
                        Date parse = simpleDateFormat.parse(simpleDateFormat.format(time));
                        if (!TextUtils.isEmpty(this.dueDate)) {
                            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
                            Date parse2 = simpleDateFormat.parse(simpleDateFormat.format(simpleDateFormat2.parse(this.dueDate)));
                            str4 = simpleDateFormat.format(simpleDateFormat2.parse(simpleDateFormat2.format(parse2)));
                            if (parse != null && parse2 != null && parse.compareTo(parse2) > 0 && !TextUtils.isEmpty(str4)) {
                                int i5 = R.string.automatic_subscription_late_payment_failed_msg;
                                h.a aVar5 = h.f60252a;
                                String string2 = context.getString(i5, new Object[]{h.a.c(getLastBillPaidAmount()), str4});
                                k.a((Object) string2, "context.getString(R.stri…unt()), dueDateFormatted)");
                                return string2;
                            }
                        }
                    } catch (Exception | ParseException unused) {
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        int i6 = R.string.automatic_subscription_payment_failed_msg;
                        h.a aVar6 = h.f60252a;
                        str = context.getString(i6, new Object[]{h.a.c(getLastBillPaidAmount()), str4});
                    } else {
                        str = context.getString(R.string.automatic_subscription_payment_attempted_msg, new Object[]{getLastBillPaidDate()});
                    }
                } else {
                    int i7 = R.string.automatic_subscription_pending_msg;
                    h.a aVar7 = h.f60252a;
                    str = context.getString(i7, new Object[]{h.a.c(getLastBillPaidAmount())});
                }
                k.a((Object) str, "if (history == null || h…          }\n            }");
                return str;
            }
        }
        str = context.getString(R.string.bill_and_due_date_to_be_generated);
        k.a((Object) str, "if (history == null || h…          }\n            }");
        return str;
    }

    public final void toggleStatus() {
        this.status = this.status == 0 ? 1 : 0;
    }

    public final String getOperatorNameWithCircle() {
        String str;
        if (!TextUtils.isEmpty(this.product.getPaytype())) {
            d dVar = d.f64967a;
            str = k.a(d.b(this.product.getPaytype()), (Object) AppConstants.COMMA);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(this.product.getOperator())) {
            str = str + " " + this.product.getOperator();
        }
        if (TextUtils.isEmpty(this.product.getCircle())) {
            return str;
        }
        return str + " " + this.product.getCircle();
    }

    public final String getPayType() {
        return this.product.getPaytype();
    }
}
