package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightMBImgNote extends IJRPaytmDataModel {
    @b(a = "image")
    private String image;
    @b(a = "text")
    private String text;

    public CJRFlightMBImgNote() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public CJRFlightMBImgNote(String str, String str2) {
        this.image = str;
        this.text = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBImgNote(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
