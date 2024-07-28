package net.one97.paytm.hotels2.entity.hoteldetail;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public final class ProviderPhoneNumber {
    @b(a = "name")
    private String name;
    @b(a = "numbers")
    private ArrayList<String> numbers;
    @b(a = "timing")
    private String timing;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getTiming() {
        return this.timing;
    }

    public final void setTiming(String str) {
        this.timing = str;
    }

    public final ArrayList<String> getNumbers() {
        return this.numbers;
    }

    public final void setNumbers(ArrayList<String> arrayList) {
        this.numbers = arrayList;
    }
}
