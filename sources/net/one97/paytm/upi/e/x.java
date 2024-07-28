package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import net.one97.paytm.upi.R;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final Button f66923a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f66924b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f66925c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66926d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f66927e;

    private x(ConstraintLayout constraintLayout, Button button, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f66927e = constraintLayout;
        this.f66923a = button;
        this.f66924b = recyclerView;
        this.f66925c = textView;
        this.f66926d = textView2;
    }

    public final ConstraintLayout a() {
        return this.f66927e;
    }

    public static x a(View view) {
        String str;
        Button button = (Button) view.findViewById(R.id.addBankButton);
        if (button != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allBankList);
            if (recyclerView != null) {
                TextView textView = (TextView) view.findViewById(R.id.description);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.title);
                    if (textView2 != null) {
                        return new x((ConstraintLayout) view, button, recyclerView, textView, textView2);
                    }
                    str = "title";
                } else {
                    str = RequestConfirmationDialogFragment.KEY_DESCRIPTION;
                }
            } else {
                str = "allBankList";
            }
        } else {
            str = "addBankButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
