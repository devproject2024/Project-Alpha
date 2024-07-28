package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RelationShipDetails implements IJRDataModel {
    @b(a = "action")
    private String action;
    @b(a = "firstName")
    private String firstName;
    @b(a = "lastName")
    private String lastName;
    @b(a = "relationShip")
    private String relationShip;

    public RelationShipDetails() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ RelationShipDetails copy$default(RelationShipDetails relationShipDetails, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = relationShipDetails.relationShip;
        }
        if ((i2 & 2) != 0) {
            str2 = relationShipDetails.firstName;
        }
        if ((i2 & 4) != 0) {
            str3 = relationShipDetails.action;
        }
        if ((i2 & 8) != 0) {
            str4 = relationShipDetails.lastName;
        }
        return relationShipDetails.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.relationShip;
    }

    public final String component2() {
        return this.firstName;
    }

    public final String component3() {
        return this.action;
    }

    public final String component4() {
        return this.lastName;
    }

    public final RelationShipDetails copy(String str, String str2, String str3, String str4) {
        return new RelationShipDetails(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelationShipDetails)) {
            return false;
        }
        RelationShipDetails relationShipDetails = (RelationShipDetails) obj;
        return k.a((Object) this.relationShip, (Object) relationShipDetails.relationShip) && k.a((Object) this.firstName, (Object) relationShipDetails.firstName) && k.a((Object) this.action, (Object) relationShipDetails.action) && k.a((Object) this.lastName, (Object) relationShipDetails.lastName);
    }

    public final int hashCode() {
        String str = this.relationShip;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.action;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastName;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "RelationShipDetails(relationShip=" + this.relationShip + ", firstName=" + this.firstName + ", action=" + this.action + ", lastName=" + this.lastName + ")";
    }

    public RelationShipDetails(String str, String str2, String str3, String str4) {
        this.relationShip = str;
        this.firstName = str2;
        this.action = str3;
        this.lastName = str4;
    }

    public final String getRelationShip() {
        return this.relationShip;
    }

    public final void setRelationShip(String str) {
        this.relationShip = str;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RelationShipDetails(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }
}
