package net.one97.paytm.hotels2.fragment;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.b.b.b;
import com.paytm.utility.b.b.c;
import kotlin.g.b.k;

public final class FJRContactHotelBottomFragment$addContactNumberAndIcons$1 implements b<Drawable> {
    final /* synthetic */ TextView $textView;
    final /* synthetic */ FJRContactHotelBottomFragment this$0;

    public final void onError(Exception exc) {
    }

    FJRContactHotelBottomFragment$addContactNumberAndIcons$1(FJRContactHotelBottomFragment fJRContactHotelBottomFragment, TextView textView) {
        this.this$0 = fJRContactHotelBottomFragment;
        this.$textView = textView;
    }

    public final void onSuccess(Drawable drawable, c cVar) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            k.a((Object) activity, "it");
            if (!activity.isFinishing()) {
                this.$textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
        }
    }
}
