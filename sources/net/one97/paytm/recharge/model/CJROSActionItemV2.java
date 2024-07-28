package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public final class CJROSActionItemV2 extends CJROrderSummaryAction {
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_AUTOMATIC = ACTION_TYPE_AUTOMATIC;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_BILL_CONSENT = ACTION_TYPE_BILL_CONSENT;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_CANCEL = "cancel";
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_CANCEL_ORDER_ITEM = ACTION_TYPE_CANCEL_ORDER_ITEM;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_COPY_VOUCHER_CODE = ACTION_TYPE_COPY_VOUCHER_CODE;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_DOWNLOAD_INVOICE = ACTION_TYPE_DOWNLOAD_INVOICE;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_HELP = ACTION_TYPE_HELP;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_HTML_BOTTOM_SHEET = ACTION_TYPE_HTML_BOTTOM_SHEET;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_IMPS_REFUND = ACTION_TYPE_IMPS_REFUND;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_PAYMENT_DETAILS = ACTION_TYPE_PAYMENT_DETAILS;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_PAYMENT_NOT_SHOWING = ACTION_TYPE_PAYMENT_NOT_SHOWING;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_PRE_SHIP_CANCEL = ACTION_TYPE_PRE_SHIP_CANCEL;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_PRO_SHARE = ACTION_TYPE_PRO_SHARE;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_REDIRECT_TO_CATEGORY = ACTION_TYPE_REDIRECT_TO_CATEGORY;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_REPEAT = ACTION_TYPE_REPEAT;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_REPEAT_WITHOUT_AMOUNT = ACTION_TYPE_REPEAT_WITHOUT_AMOUNT;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_SHARE = ACTION_TYPE_SHARE;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_SHARE_VOUCHER_CODE = ACTION_TYPE_SHARE_VOUCHER_CODE;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_STORE_FRONT = ACTION_TYPE_STORE_FRONT;
    /* access modifiers changed from: private */
    public static final String ACTION_TYPE_VIEW_DETAILS = ACTION_TYPE_VIEW_DETAILS;
    /* access modifiers changed from: private */
    public static final int BUTTON_TYPE_BORDER = 2;
    /* access modifiers changed from: private */
    public static final int BUTTON_TYPE_FILL = 3;
    /* access modifiers changed from: private */
    public static final int BUTTON_TYPE_TEXT = 1;
    public static final Companion Companion = new Companion((g) null);
    @b(a = "actions")
    private List<CJROSActionItemV2> actions;
    @b(a = "button_type")
    private int buttonType = -1;
    @b(a = "message_html")
    private String htmlMessage;
    @b(a = "image_url_group_care")
    private String imageUrlGroupCare;
    @b(a = "image_url_share")
    private String imageUrlShare;
    private boolean isEnabled = true;
    @b(a = "paytype")
    private String payType;
    @b(a = "smartlink")
    private String smartlink;
    @b(a = "toolbar_visibility")
    private int toolbarVisibility = -1;
    @b(a = "visibility")
    private int visibility = -1;
    @b(a = "visibility_category_action")
    private int visibilityCategoryAction = -1;
    @b(a = "visibility_multi_item")
    private int visibilityMultiItem = -1;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getBUTTON_TYPE_TEXT() {
            return CJROSActionItemV2.BUTTON_TYPE_TEXT;
        }

        public final int getBUTTON_TYPE_BORDER() {
            return CJROSActionItemV2.BUTTON_TYPE_BORDER;
        }

        public final int getBUTTON_TYPE_FILL() {
            return CJROSActionItemV2.BUTTON_TYPE_FILL;
        }

        public final String getACTION_TYPE_AUTOMATIC() {
            return CJROSActionItemV2.ACTION_TYPE_AUTOMATIC;
        }

        public final String getACTION_TYPE_BILL_CONSENT() {
            return CJROSActionItemV2.ACTION_TYPE_BILL_CONSENT;
        }

        public final String getACTION_TYPE_CANCEL_ORDER_ITEM() {
            return CJROSActionItemV2.ACTION_TYPE_CANCEL_ORDER_ITEM;
        }

        public final String getACTION_TYPE_PRE_SHIP_CANCEL() {
            return CJROSActionItemV2.ACTION_TYPE_PRE_SHIP_CANCEL;
        }

        public final String getACTION_TYPE_CANCEL() {
            return CJROSActionItemV2.ACTION_TYPE_CANCEL;
        }

        public final String getACTION_TYPE_REPEAT() {
            return CJROSActionItemV2.ACTION_TYPE_REPEAT;
        }

        public final String getACTION_TYPE_REPEAT_WITHOUT_AMOUNT() {
            return CJROSActionItemV2.ACTION_TYPE_REPEAT_WITHOUT_AMOUNT;
        }

        public final String getACTION_TYPE_REDIRECT_TO_CATEGORY() {
            return CJROSActionItemV2.ACTION_TYPE_REDIRECT_TO_CATEGORY;
        }

        public final String getACTION_TYPE_VIEW_DETAILS() {
            return CJROSActionItemV2.ACTION_TYPE_VIEW_DETAILS;
        }

        public final String getACTION_TYPE_HELP() {
            return CJROSActionItemV2.ACTION_TYPE_HELP;
        }

        public final String getACTION_TYPE_PAYMENT_DETAILS() {
            return CJROSActionItemV2.ACTION_TYPE_PAYMENT_DETAILS;
        }

        public final String getACTION_TYPE_DOWNLOAD_INVOICE() {
            return CJROSActionItemV2.ACTION_TYPE_DOWNLOAD_INVOICE;
        }

        public final String getACTION_TYPE_IMPS_REFUND() {
            return CJROSActionItemV2.ACTION_TYPE_IMPS_REFUND;
        }

        public final String getACTION_TYPE_STORE_FRONT() {
            return CJROSActionItemV2.ACTION_TYPE_STORE_FRONT;
        }

        public final String getACTION_TYPE_PAYMENT_NOT_SHOWING() {
            return CJROSActionItemV2.ACTION_TYPE_PAYMENT_NOT_SHOWING;
        }

        public final String getACTION_TYPE_SHARE() {
            return CJROSActionItemV2.ACTION_TYPE_SHARE;
        }

        public final String getACTION_TYPE_PRO_SHARE() {
            return CJROSActionItemV2.ACTION_TYPE_PRO_SHARE;
        }

        public final String getACTION_TYPE_SHARE_VOUCHER_CODE() {
            return CJROSActionItemV2.ACTION_TYPE_SHARE_VOUCHER_CODE;
        }

        public final String getACTION_TYPE_COPY_VOUCHER_CODE() {
            return CJROSActionItemV2.ACTION_TYPE_COPY_VOUCHER_CODE;
        }

        public final String getACTION_TYPE_HTML_BOTTOM_SHEET() {
            return CJROSActionItemV2.ACTION_TYPE_HTML_BOTTOM_SHEET;
        }
    }

    public final int getVisibility() {
        return this.visibility;
    }

    public final void setVisibility(int i2) {
        this.visibility = i2;
    }

    public final int getToolbarVisibility() {
        return this.toolbarVisibility;
    }

    public final void setToolbarVisibility(int i2) {
        this.toolbarVisibility = i2;
    }

    public final int getVisibilityMultiItem() {
        return this.visibilityMultiItem;
    }

    public final void setVisibilityMultiItem(int i2) {
        this.visibilityMultiItem = i2;
    }

    public final int getVisibilityCategoryAction() {
        return this.visibilityCategoryAction;
    }

    public final void setVisibilityCategoryAction(int i2) {
        this.visibilityCategoryAction = i2;
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final void setButtonType(int i2) {
        this.buttonType = i2;
    }

    public final List<CJROSActionItemV2> getActions() {
        return this.actions;
    }

    public final String getHtmlMessage() {
        return this.htmlMessage;
    }

    public final void setHtmlMessage(String str) {
        this.htmlMessage = str;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final String getPayType() {
        return this.payType;
    }

    public final void setPayType(String str) {
        this.payType = str;
    }

    public final String getImageUrlGroupCare() {
        return this.imageUrlGroupCare;
    }

    public final void setImageUrlGroupCare(String str) {
        this.imageUrlGroupCare = str;
    }

    public final String getImageUrlShare() {
        return this.imageUrlShare;
    }

    public final void setImageUrlShare(String str) {
        this.imageUrlShare = str;
    }

    public final String getSmartlink() {
        return this.smartlink;
    }

    public final void setSmartlink(String str) {
        this.smartlink = str;
    }

    public final String toString() {
        String str = getmType();
        if (str == null) {
            str = getLabel();
        }
        return str == null ? "" : str;
    }

    public final int hashCode() {
        String str = getmType();
        if (str != null) {
            if (str != null) {
                String lowerCase = str.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase != null) {
                    return lowerCase.hashCode();
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CJROSActionItemV2) {
            return p.a(getmType(), ((CJROSActionItemV2) obj).getmType(), true);
        }
        return false;
    }
}
