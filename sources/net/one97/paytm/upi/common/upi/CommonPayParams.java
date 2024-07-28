package net.one97.paytm.upi.common.upi;

import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class CommonPayParams implements UpiBaseDataModel {
    private final HashMap<String, String> extendedInfo;
    private final String mid;
    private final String mode;
    private final String msid;
    private final String mtid;
    private final String orgid;
    private final String purpose;
    private final String refCategory;
    private final String sign;

    private CommonPayParams(Builder builder) {
        this.mode = builder.getMode();
        this.orgid = builder.getOrgid();
        this.sign = builder.getSign();
        this.mid = builder.getMid();
        this.msid = builder.getMsid();
        this.mtid = builder.getMtid();
        this.purpose = builder.getPurpose();
        this.refCategory = builder.getRefCategory();
        this.extendedInfo = builder.getExtendedInfo();
    }

    public /* synthetic */ CommonPayParams(Builder builder, g gVar) {
        this(builder);
    }

    public final HashMap<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getMsid() {
        return this.msid;
    }

    public final String getMtid() {
        return this.mtid;
    }

    public final String getOrgid() {
        return this.orgid;
    }

    public final String getPurpose() {
        return this.purpose;
    }

    public final String getRefCategory() {
        return this.refCategory;
    }

    public final String getSign() {
        return this.sign;
    }

    public static final class Builder {
        @Deprecated
        public static final a Companion = new a((byte) 0);
        public static final String FALLBACK = "combinationFallbackCase";
        public static final String MONEY_TRANSFER = "MONEY_TRANSFER";
        public static final String NO = "No";
        public static final String PAID_DEFAULT = "isPayedByDefaultOption";
        public static final String TXN_ENTRY_POINT = "transactionEntrypoint";
        public static final String YES = "Yes";
        private String entryPoint;
        private HashMap<String, String> extendedInfo;
        private Boolean isFallback;
        private Boolean isPaidByDefaultOption;
        private String mid;
        private String mode;
        private String msid;
        private String mtid;
        private String orgid;
        private Boolean pcrAvailable;
        private String purpose;
        private String refCategory;
        private String sign;

        public Builder(String str, String str2, String str3) {
            this.mode = str;
            this.sign = str2;
            this.orgid = str3;
        }

        public final String getMode() {
            return this.mode;
        }

        public final String getOrgid() {
            return this.orgid;
        }

        public final String getSign() {
            return this.sign;
        }

        public final void setMode(String str) {
            this.mode = str;
        }

        public final void setOrgid(String str) {
            this.orgid = str;
        }

        public final void setSign(String str) {
            this.sign = str;
        }

        static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public final String getMid() {
            return this.mid;
        }

        public final String getMsid() {
            return this.msid;
        }

        public final String getMtid() {
            return this.mtid;
        }

        public final String getPurpose() {
            return this.purpose;
        }

        public final String getRefCategory() {
            return this.refCategory;
        }

        public final void setMid(String str) {
            this.mid = str;
        }

        public final void setMsid(String str) {
            this.msid = str;
        }

        public final void setMtid(String str) {
            this.mtid = str;
        }

        public final void setPurpose(String str) {
            this.purpose = str;
        }

        public final void setRefCategory(String str) {
            this.refCategory = str;
        }

        public final HashMap<String, String> getExtendedInfo() {
            return this.extendedInfo;
        }

        public final void setExtendedInfo(HashMap<String, String> hashMap) {
            this.extendedInfo = hashMap;
        }

        public final CommonPayParams build() {
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, String> hashMap2 = this.extendedInfo;
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
            Map map = hashMap;
            String str = this.entryPoint;
            if (str == null) {
                str = MONEY_TRANSFER;
            }
            map.put(TXN_ENTRY_POINT, str);
            if (k.a((Object) Boolean.TRUE, (Object) this.isPaidByDefaultOption)) {
                map.put(PAID_DEFAULT, YES);
            } else {
                map.put(PAID_DEFAULT, NO);
            }
            if (k.a((Object) Boolean.TRUE, (Object) this.pcrAvailable)) {
                if (k.a((Object) Boolean.TRUE, (Object) this.isFallback)) {
                    map.put(FALLBACK, YES);
                } else {
                    map.put(FALLBACK, NO);
                }
            }
            this.extendedInfo = hashMap;
            return new CommonPayParams(this, (g) null);
        }

        public final Builder setMerchantId(String str) {
            this.mid = str;
            return this;
        }

        public final Builder setMerchantStoreId(String str) {
            this.msid = str;
            return this;
        }

        public final Builder setMerchantTerminalId(String str) {
            this.mtid = str;
            return this;
        }

        public final Builder setTxnPurpose(String str) {
            this.purpose = str;
            return this;
        }

        public final Builder setTxnRefCategory(String str) {
            this.refCategory = str;
            return this;
        }

        public final Builder setExtendedInfoRefId(HashMap<String, String> hashMap) {
            this.extendedInfo = hashMap;
            return this;
        }

        public final Builder setIsPaidByDefaultOption(boolean z) {
            this.isPaidByDefaultOption = Boolean.valueOf(z);
            return this;
        }

        public final Builder setIsFallback(Boolean bool) {
            this.isFallback = bool;
            return this;
        }

        public final Builder setIsPCRAvailable(boolean z) {
            this.pcrAvailable = Boolean.valueOf(z);
            return this;
        }

        public final Builder setEntryPoint(String str) {
            k.c(str, "source");
            this.entryPoint = str;
            return this;
        }
    }
}
