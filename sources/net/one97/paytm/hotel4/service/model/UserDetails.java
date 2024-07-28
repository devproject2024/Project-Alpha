package net.one97.paytm.hotel4.service.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UserDetails {
    private String email;
    private String firstname;
    private String lastname;
    private String mobile;
    private String title;

    public static /* synthetic */ UserDetails copy$default(UserDetails userDetails, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userDetails.title;
        }
        if ((i2 & 2) != 0) {
            str2 = userDetails.firstname;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = userDetails.lastname;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = userDetails.email;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = userDetails.mobile;
        }
        return userDetails.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.firstname;
    }

    public final String component3() {
        return this.lastname;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.mobile;
    }

    public final UserDetails copy(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "title");
        return new UserDetails(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDetails)) {
            return false;
        }
        UserDetails userDetails = (UserDetails) obj;
        return k.a((Object) this.title, (Object) userDetails.title) && k.a((Object) this.firstname, (Object) userDetails.firstname) && k.a((Object) this.lastname, (Object) userDetails.lastname) && k.a((Object) this.email, (Object) userDetails.email) && k.a((Object) this.mobile, (Object) userDetails.mobile);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstname;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastname;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mobile;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "UserDetails(title=" + this.title + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", mobile=" + this.mobile + ")";
    }

    public UserDetails(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "title");
        this.title = str;
        this.firstname = str2;
        this.lastname = str3;
        this.email = str4;
        this.mobile = str5;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final void setFirstname(String str) {
        this.firstname = str;
    }

    public final String getLastname() {
        return this.lastname;
    }

    public final void setLastname(String str) {
        this.lastname = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserDetails(String str, String str2, String str3, String str4, String str5, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5);
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }
}
