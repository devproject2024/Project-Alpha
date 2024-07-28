package net.one97.travelpass.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.c;
import com.one97.travelpass.a.d;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.travelpass.R;
import net.one97.travelpass.model.PassData;

public final class b extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private ConstraintLayout f30620a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30621b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30622c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        this.f30620a = (ConstraintLayout) view.findViewById(R.id.notify_container);
        this.f30621b = (TextView) view.findViewById(R.id.notify_me_text);
        this.f30622c = (TextView) view.findViewById(R.id.notify_btn);
    }

    public final void a(Context context, int i2, j jVar, c cVar) {
        k.c(jVar, "viewHolderModel");
        k.c(cVar, "itemClickListener");
        IJRPaytmDataModel b2 = jVar.b();
        if (!(b2 instanceof PassData)) {
            b2 = null;
        }
        PassData passData = (PassData) b2;
        if (passData != null) {
            TextView textView = this.f30621b;
            if (textView != null) {
                textView.setText(passData.getSubscriptionText());
            }
            TextView textView2 = this.f30622c;
            if (textView2 != null) {
                textView2.setText(passData.getSubscriptionButtonLabel());
            }
            TextView textView3 = this.f30622c;
            if (textView3 != null) {
                textView3.setOnClickListener(new a(cVar, jVar));
            }
            if (passData.isSubscribed()) {
                if (context != null) {
                    TextView textView4 = this.f30621b;
                    if (textView4 != null) {
                        textView4.setTextColor(androidx.core.content.b.c(context, R.color.textColor_222222));
                    }
                    TextView textView5 = this.f30622c;
                    if (textView5 != null) {
                        textView5.setTextColor(androidx.core.content.b.c(context, R.color.theme_accent_color));
                    }
                    TextView textView6 = this.f30622c;
                    if (textView6 != null) {
                        textView6.setBackgroundResource(R.drawable.oval_dde5ed_border);
                    }
                    ConstraintLayout constraintLayout = this.f30620a;
                    if (constraintLayout != null) {
                        constraintLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_ecf8ff));
                    }
                }
            } else if (context != null) {
                TextView textView7 = this.f30621b;
                if (textView7 != null) {
                    textView7.setTextColor(androidx.core.content.b.c(context, R.color.white));
                }
                TextView textView8 = this.f30622c;
                if (textView8 != null) {
                    textView8.setTextColor(androidx.core.content.b.c(context, R.color.white));
                }
                TextView textView9 = this.f30622c;
                if (textView9 != null) {
                    textView9.setBackgroundResource(R.drawable.oval_white_border);
                }
                ConstraintLayout constraintLayout2 = this.f30620a;
                if (constraintLayout2 != null) {
                    constraintLayout2.setBackgroundResource(R.drawable.button_gradient);
                }
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30624b;

        a(c cVar, j jVar) {
            this.f30623a = cVar;
            this.f30624b = jVar;
        }

        public final void onClick(View view) {
            c cVar = this.f30623a;
            if (cVar != null) {
                c.a.a(cVar, this.f30624b, (Integer) null, (Integer) null, 6);
            }
        }
    }
}
