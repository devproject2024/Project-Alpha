package net.one97.paytm.upi.mandate.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.upi.R;

public final class b extends DatePickerDialog {
    public /* synthetic */ b(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, byte b2) {
        this(context, onDateSetListener, i2, i3, i4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private b(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, R.style.datePicker, onDateSetListener, i2, i3, i4);
        k.c(context, "context");
        k.c(onDateSetListener, "datePickerListener");
        setButton(-1, Payload.RESPONSE_OK, this);
    }
}
