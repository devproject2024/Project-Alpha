package io.branch.referral;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    String f46479a = "";

    /* renamed from: b  reason: collision with root package name */
    int f46480b = -113;

    public f(String str, int i2) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (i2 == -113) {
            this.f46480b = -113;
            str2 = " Branch API Error: poor network connectivity. Please try again later.";
        } else if (i2 == -114) {
            this.f46480b = -114;
            str2 = " Branch API Error: Please enter your branch_key in your project's manifest file first.";
        } else if (i2 == -104) {
            this.f46480b = -104;
            str2 = " Did you forget to call init? Make sure you init the session before making Branch calls.";
        } else if (i2 == -101) {
            this.f46480b = -101;
            str2 = " Unable to initialize Branch. Check network connectivity or that your branch key is valid.";
        } else if (i2 == -102) {
            this.f46480b = -102;
            str2 = " Please add 'android.permission.INTERNET' in your applications manifest file.";
        } else if (i2 == -105) {
            this.f46480b = -105;
            str2 = " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner.";
        } else if (i2 == -106) {
            this.f46480b = -106;
            str2 = " That Branch referral code is already in use.";
        } else if (i2 == -107) {
            this.f46480b = -107;
            str2 = " Unable to redeem rewards. Please make sure you have credits available to redeem.";
        } else if (i2 == -108) {
            this.f46480b = -108;
            str2 = "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead.";
        } else if (i2 == -109) {
            this.f46480b = -109;
            str2 = "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp.";
        } else if (i2 == -110) {
            this.f46480b = -110;
            str2 = " Unable create share options. Couldn't find applications on device to share the link.";
        } else if (i2 == -111) {
            this.f46480b = -111;
            str2 = " Request to Branch server timed out. Please check your internet connectivity";
        } else if (i2 == -117) {
            this.f46480b = -117;
            str2 = " Tracking is disabled. Requested operation cannot be completed when tracking is disabled";
        } else if (i2 == -118) {
            this.f46480b = -118;
            str2 = " Session initialization already happened. To force a new session, set intent extra, \"branch_force_new_session\", to true.";
        } else if (i2 >= 500 || i2 == -112) {
            this.f46480b = -112;
            str2 = " Unable to reach the Branch servers, please try again shortly.";
        } else if (i2 == 409 || i2 == -115) {
            this.f46480b = -115;
            str2 = " A resource with this identifier already exists.";
        } else if (i2 >= 400 || i2 == -116) {
            this.f46480b = -116;
            str2 = " The request was invalid.";
        } else {
            this.f46480b = -113;
            str2 = " Check network connectivity and that you properly initialized.";
        }
        sb.append(str2);
        this.f46479a = sb.toString();
    }

    public final String toString() {
        return this.f46479a;
    }
}
