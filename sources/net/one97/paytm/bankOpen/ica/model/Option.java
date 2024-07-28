package net.one97.paytm.bankOpen.ica.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class Option extends IJRPaytmDataModel {
    @b(a = "id")
    private final int id;
    @b(a = "optionAlias")
    private final String optionAlias;
    @b(a = "questionAlias")
    private final String questionAlias;
    @b(a = "text")
    private final String text;
    @b(a = "veto")
    private final boolean veto;

    public static /* synthetic */ Option copy$default(Option option, int i2, String str, String str2, boolean z, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = option.id;
        }
        if ((i3 & 2) != 0) {
            str = option.optionAlias;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = option.text;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            z = option.veto;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            str3 = option.questionAlias;
        }
        return option.copy(i2, str4, str5, z2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.optionAlias;
    }

    public final String component3() {
        return this.text;
    }

    public final boolean component4() {
        return this.veto;
    }

    public final String component5() {
        return this.questionAlias;
    }

    public final Option copy(int i2, String str, String str2, boolean z, String str3) {
        return new Option(i2, str, str2, z, str3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Option) {
                Option option = (Option) obj;
                if ((this.id == option.id) && k.a((Object) this.optionAlias, (Object) option.optionAlias) && k.a((Object) this.text, (Object) option.text)) {
                    if (!(this.veto == option.veto) || !k.a((Object) this.questionAlias, (Object) option.questionAlias)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.id * 31;
        String str = this.optionAlias;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.veto;
        if (z) {
            z = true;
        }
        int i4 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.questionAlias;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i4 + i3;
    }

    public final String toString() {
        return "Option(id=" + this.id + ", optionAlias=" + this.optionAlias + ", text=" + this.text + ", veto=" + this.veto + ", questionAlias=" + this.questionAlias + ")";
    }

    public final int getId() {
        return this.id;
    }

    public final String getOptionAlias() {
        return this.optionAlias;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getVeto() {
        return this.veto;
    }

    public final String getQuestionAlias() {
        return this.questionAlias;
    }

    public Option(int i2, String str, String str2, boolean z, String str3) {
        this.id = i2;
        this.optionAlias = str;
        this.text = str2;
        this.veto = z;
        this.questionAlias = str3;
    }
}
