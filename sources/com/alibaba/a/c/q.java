package com.alibaba.a.c;

import com.alibaba.a.a;
import com.alibaba.a.d.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class q implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final q f6330a = new q();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        char[] cArr;
        ah ahVar2 = ahVar;
        ba baVar = ahVar2.f6266a;
        if (obj == null) {
            baVar.write("null");
        } else if (!baVar.b(bb.WriteClassName) || obj.getClass() == type) {
            Date date = (Date) obj;
            if (baVar.b(bb.WriteDateUseDateFormat)) {
                DateFormat a2 = ahVar.a();
                if (a2 == null) {
                    a2 = new SimpleDateFormat(a.DEFFAULT_DATE_FORMAT);
                }
                baVar.b(a2.format(date));
                return;
            }
            long time = date.getTime();
            if (ahVar2.b(bb.UseISO8601DateFormat)) {
                if (ahVar2.b(bb.UseSingleQuotes)) {
                    baVar.b('\'');
                } else {
                    baVar.b('\"');
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(time);
                int i2 = instance.get(1);
                int i3 = instance.get(2) + 1;
                int i4 = instance.get(5);
                int i5 = instance.get(11);
                int i6 = instance.get(12);
                int i7 = instance.get(13);
                int i8 = instance.get(14);
                if (i8 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    d.a((long) i8, 23, cArr);
                    d.a((long) i7, 19, cArr);
                    d.a((long) i6, 16, cArr);
                    d.a((long) i5, 13, cArr);
                    d.a((long) i4, 10, cArr);
                    d.a((long) i3, 7, cArr);
                    d.a((long) i2, 4, cArr);
                } else if (i7 == 0 && i6 == 0 && i5 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    d.a((long) i4, 10, cArr);
                    d.a((long) i3, 7, cArr);
                    d.a((long) i2, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    d.a((long) i7, 19, cArr);
                    d.a((long) i6, 16, cArr);
                    d.a((long) i5, 13, cArr);
                    d.a((long) i4, 10, cArr);
                    d.a((long) i3, 7, cArr);
                    d.a((long) i2, 4, cArr);
                }
                baVar.write(cArr);
                if (ahVar2.b(bb.UseSingleQuotes)) {
                    baVar.b('\'');
                } else {
                    baVar.b('\"');
                }
            } else {
                baVar.a(time);
            }
        } else if (obj.getClass() == Date.class) {
            baVar.write("new Date(");
            baVar.a(((Date) obj).getTime(), ')');
        } else {
            baVar.a('{');
            baVar.a(a.DEFAULT_TYPE_KEY, false);
            ahVar2.a(obj.getClass().getName());
            baVar.a("val", ((Date) obj).getTime());
            baVar.a('}');
        }
    }
}
