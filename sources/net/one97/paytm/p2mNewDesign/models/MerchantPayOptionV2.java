package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantPayOptionV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "paymentModes")
    private ArrayList<PaymentModesV2> paymentModes;
    @b(a = "savedInstruments")
    private ArrayList<SavedInstrumentsV2> savedInstruments;
    @b(a = "upiProfile")
    private UPIProfileV2 upiProfile;
    @b(a = "userProfileSarvatra")
    private UserProfileSarvatraV2 userProfileSarvatra;

    public MerchantPayOptionV2() {
        this((ArrayList) null, (ArrayList) null, (UserProfileSarvatraV2) null, (UPIProfileV2) null, 15, (g) null);
    }

    public static /* synthetic */ MerchantPayOptionV2 copy$default(MerchantPayOptionV2 merchantPayOptionV2, ArrayList<SavedInstrumentsV2> arrayList, ArrayList<PaymentModesV2> arrayList2, UserProfileSarvatraV2 userProfileSarvatraV2, UPIProfileV2 uPIProfileV2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = merchantPayOptionV2.savedInstruments;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = merchantPayOptionV2.paymentModes;
        }
        if ((i2 & 4) != 0) {
            userProfileSarvatraV2 = merchantPayOptionV2.userProfileSarvatra;
        }
        if ((i2 & 8) != 0) {
            uPIProfileV2 = merchantPayOptionV2.upiProfile;
        }
        return merchantPayOptionV2.copy(arrayList, arrayList2, userProfileSarvatraV2, uPIProfileV2);
    }

    public final ArrayList<SavedInstrumentsV2> component1() {
        return this.savedInstruments;
    }

    public final ArrayList<PaymentModesV2> component2() {
        return this.paymentModes;
    }

    public final UserProfileSarvatraV2 component3() {
        return this.userProfileSarvatra;
    }

    public final UPIProfileV2 component4() {
        return this.upiProfile;
    }

    public final MerchantPayOptionV2 copy(ArrayList<SavedInstrumentsV2> arrayList, ArrayList<PaymentModesV2> arrayList2, UserProfileSarvatraV2 userProfileSarvatraV2, UPIProfileV2 uPIProfileV2) {
        return new MerchantPayOptionV2(arrayList, arrayList2, userProfileSarvatraV2, uPIProfileV2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantPayOptionV2)) {
            return false;
        }
        MerchantPayOptionV2 merchantPayOptionV2 = (MerchantPayOptionV2) obj;
        return k.a((Object) this.savedInstruments, (Object) merchantPayOptionV2.savedInstruments) && k.a((Object) this.paymentModes, (Object) merchantPayOptionV2.paymentModes) && k.a((Object) this.userProfileSarvatra, (Object) merchantPayOptionV2.userProfileSarvatra) && k.a((Object) this.upiProfile, (Object) merchantPayOptionV2.upiProfile);
    }

    public final int hashCode() {
        ArrayList<SavedInstrumentsV2> arrayList = this.savedInstruments;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<PaymentModesV2> arrayList2 = this.paymentModes;
        int hashCode2 = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        UserProfileSarvatraV2 userProfileSarvatraV2 = this.userProfileSarvatra;
        int hashCode3 = (hashCode2 + (userProfileSarvatraV2 != null ? userProfileSarvatraV2.hashCode() : 0)) * 31;
        UPIProfileV2 uPIProfileV2 = this.upiProfile;
        if (uPIProfileV2 != null) {
            i2 = uPIProfileV2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MerchantPayOptionV2(savedInstruments=" + this.savedInstruments + ", paymentModes=" + this.paymentModes + ", userProfileSarvatra=" + this.userProfileSarvatra + ", upiProfile=" + this.upiProfile + ")";
    }

    public MerchantPayOptionV2(ArrayList<SavedInstrumentsV2> arrayList, ArrayList<PaymentModesV2> arrayList2, UserProfileSarvatraV2 userProfileSarvatraV2, UPIProfileV2 uPIProfileV2) {
        this.savedInstruments = arrayList;
        this.paymentModes = arrayList2;
        this.userProfileSarvatra = userProfileSarvatraV2;
        this.upiProfile = uPIProfileV2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantPayOptionV2(ArrayList arrayList, ArrayList arrayList2, UserProfileSarvatraV2 userProfileSarvatraV2, UPIProfileV2 uPIProfileV2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : arrayList2, (i2 & 4) != 0 ? null : userProfileSarvatraV2, (i2 & 8) != 0 ? null : uPIProfileV2);
    }

    public final ArrayList<PaymentModesV2> getPaymentModes() {
        return this.paymentModes;
    }

    public final ArrayList<SavedInstrumentsV2> getSavedInstruments() {
        return this.savedInstruments;
    }

    public final UPIProfileV2 getUpiProfile() {
        return this.upiProfile;
    }

    public final UserProfileSarvatraV2 getUserProfileSarvatra() {
        return this.userProfileSarvatra;
    }

    public final void setPaymentModes(ArrayList<PaymentModesV2> arrayList) {
        this.paymentModes = arrayList;
    }

    public final void setSavedInstruments(ArrayList<SavedInstrumentsV2> arrayList) {
        this.savedInstruments = arrayList;
    }

    public final void setUpiProfile(UPIProfileV2 uPIProfileV2) {
        this.upiProfile = uPIProfileV2;
    }

    public final void setUserProfileSarvatra(UserProfileSarvatraV2 userProfileSarvatraV2) {
        this.userProfileSarvatra = userProfileSarvatraV2;
    }
}
