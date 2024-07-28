package net.one97.paytm.quickpay.b;

import android.content.Context;
import java.util.ArrayList;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;

public final class a {
    public static void a(Context context, StandingInstructionList standingInstructionList) {
        d.a().a(context, standingInstructionList);
    }

    public static ArrayList<StandingInstructionList> a(Context context) {
        return d.a().s(context);
    }

    public static StandingInstructionList a(Context context, String str) {
        return d.a().c(context, str);
    }

    public static void b(Context context, String str) {
        d.a().b(context, str);
    }
}
