package net.one97.paytm.addmoney.utils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f48949a = "version";

    /* renamed from: b  reason: collision with root package name */
    public static String f48950b = "bin";

    /* renamed from: c  reason: collision with root package name */
    public static String f48951c = "body";

    /* renamed from: d  reason: collision with root package name */
    public static String f48952d = "head";

    /* renamed from: e  reason: collision with root package name */
    public static int f48953e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static String f48954f = "outerTab";

    /* renamed from: g  reason: collision with root package name */
    public static String f48955g = "app_rating";

    /* renamed from: h  reason: collision with root package name */
    public static String f48956h = "cross_button_clicked";

    /* renamed from: i  reason: collision with root package name */
    public static String f48957i = "Accept-Compression";
    public static String j = "ADD_MONEY";

    /* renamed from: net.one97.paytm.addmoney.utils.b$b  reason: collision with other inner class name */
    public enum C0862b {
        PPB,
        UPI,
        WALLET,
        BANK,
        UPI_LEAD,
        KYC
    }

    public enum a {
        PAYTM_BASIC_WALLET("PAYTM_BASIC_WALLET", "Basic"),
        PAYTM_MIN_KYC_LOCKED("PAYTM_MIN_KYC_LOCKED", "Min Kyc With Credit Freeze"),
        PAYTM_MIN_KYC("PAYTM_MIN_KYC", "Min Kyc"),
        PAYTM_MIN_KYC_EXPIRED("PAYTM_MIN_KYC_EXPIRED", "Min Kyc Expired"),
        PAYTM_ADHAAR_OTP_KYC("PAYTM_ADHAAR_OTP_KYC", "Adhaar OTP Kyc"),
        PAYTM_ADHAAR_OTP_KYC_EXPIRED("PAYTM_ADHAAR_OTP_KYC_EXPIRED", "Adhaar OTP Kyc expired"),
        PAYTM_PRIME_WALLET("PAYTM_PRIME_WALLET", "Premium"),
        PAYTM_PRIMITIVE("PAYTM_PRIMITIVE", "Primitive Account"),
        PAYTM_CLOSED("PAYTM_CLOSED", "Closed Account");
        
        private String mWalletUserState;
        private String mv2UserState;

        private a(String str, String str2) {
            this.mv2UserState = str;
            this.mWalletUserState = str2;
        }

        public final String getv2UserState() {
            return this.mv2UserState;
        }

        public final String getWalletUserState() {
            return this.mWalletUserState;
        }
    }
}
