package net.one97.paytm.common.entity.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassBaseInstructionClass implements IJRDataModel {
    private final String heading;
    @b(a = "_id")
    private String id;
    private final String label;
    private final String type;

    public CJRMoviePassBaseInstructionClass() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public CJRMoviePassBaseInstructionClass(String str, String str2, String str3, String str4) {
        this.id = str;
        this.type = str2;
        this.heading = str3;
        this.label = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMoviePassBaseInstructionClass(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getLabel() {
        return this.label;
    }
}
