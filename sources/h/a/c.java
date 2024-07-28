package h.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    String f46255a;

    /* renamed from: b  reason: collision with root package name */
    String f46256b;

    /* renamed from: c  reason: collision with root package name */
    int f46257c;

    /* renamed from: d  reason: collision with root package name */
    int f46258d;

    /* renamed from: e  reason: collision with root package name */
    private int f46259e = 20;

    public c(String str, String str2) {
        this.f46255a = str;
        this.f46256b = str2;
    }

    /* access modifiers changed from: package-private */
    public final String a(String str) {
        String str2;
        String str3 = "[" + str.substring(this.f46257c, (str.length() - this.f46258d) + 1) + "]";
        int i2 = this.f46257c;
        String str4 = AppConstants.DOTS;
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (this.f46257c > this.f46259e) {
                str2 = str4;
            } else {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(this.f46255a.substring(Math.max(0, this.f46257c - this.f46259e), this.f46257c));
            sb.append(sb2.toString());
            sb.append(str3);
            str3 = sb.toString();
        }
        if (this.f46258d <= 0) {
            return str3;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        int min = Math.min((this.f46255a.length() - this.f46258d) + 1 + this.f46259e, this.f46255a.length());
        StringBuilder sb4 = new StringBuilder();
        String str5 = this.f46255a;
        sb4.append(str5.substring((str5.length() - this.f46258d) + 1, min));
        if ((this.f46255a.length() - this.f46258d) + 1 >= this.f46255a.length() - this.f46259e) {
            str4 = "";
        }
        sb4.append(str4);
        sb3.append(sb4.toString());
        return sb3.toString();
    }
}
