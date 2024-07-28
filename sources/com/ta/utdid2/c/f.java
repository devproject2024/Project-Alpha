package com.ta.utdid2.c;

import com.ta.utdid2.a.a.a;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.e;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f16171a;

    public f() {
        this.f16171a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f16171a = b.a(this.f16171a.getBytes(), 0);
    }

    public final String a(String str) {
        return a.b(this.f16171a, str);
    }

    public final String b(String str) {
        String b2 = a.b(this.f16171a, str);
        if (!e.a(b2)) {
            try {
                return new String(b.a(b2));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
