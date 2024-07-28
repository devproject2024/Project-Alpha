package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class CJRFlightMBImportant extends IJRPaytmDataModel {
    @b(a = "notes")
    private List<CJRFlightMBImgNote> notes;
    @b(a = "title")
    private String title;

    public CJRFlightMBImportant() {
        this((String) null, (List) null, 3, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public CJRFlightMBImportant(String str, List<CJRFlightMBImgNote> list) {
        this.title = str;
        this.notes = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBImportant(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final List<CJRFlightMBImgNote> getNotes() {
        return this.notes;
    }

    public final void setNotes(List<CJRFlightMBImgNote> list) {
        this.notes = list;
    }
}
