package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class PromoList implements Parcelable {
    public static final Parcelable.Creator<PromoList> CREATOR = new PromoList$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((g) null);
    private List<PromoListItem> codes;

    public PromoList() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ PromoList copy$default(PromoList promoList, List<PromoListItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = promoList.codes;
        }
        return promoList.copy(list);
    }

    public final List<PromoListItem> component1() {
        return this.codes;
    }

    public final PromoList copy(List<PromoListItem> list) {
        return new PromoList(list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PromoList) && k.a((Object) this.codes, (Object) ((PromoList) obj).codes);
        }
        return true;
    }

    public final int hashCode() {
        List<PromoListItem> list = this.codes;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PromoList(codes=" + this.codes + ")";
    }

    public PromoList(List<PromoListItem> list) {
        this.codes = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoList(List list, int i2, g gVar) {
        this((List<PromoListItem>) (i2 & 1) != 0 ? null : list);
    }

    public final List<PromoListItem> getCodes() {
        return this.codes;
    }

    public final void setCodes(List<PromoListItem> list) {
        this.codes = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PromoList(Parcel parcel) {
        this((List<PromoListItem>) parcel.createTypedArrayList(PromoListItem.CREATOR));
        k.c(parcel, "source");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "dest");
        parcel.writeTypedList(this.codes);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoList create(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            PromoList promoList = new PromoList((List) null, 1, (g) null);
            promoList.setCodes(PromoListItem.Companion.createPromoArray(jSONObject.getJSONArray("codes")));
            return promoList;
        }

        public final PromoList createPromoList(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return create(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }

        public final List<Freebie> updateFreebies(String str) {
            k.c(str, Payload.RESPONSE);
            try {
                return createFreebie(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }

        private final List<Freebie> createFreebie(JSONObject jSONObject) {
            return Freebie.createFreebieArray(jSONObject.getJSONArray("grid_layout"));
        }
    }
}
