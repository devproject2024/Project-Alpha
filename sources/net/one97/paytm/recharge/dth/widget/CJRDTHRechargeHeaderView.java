package net.one97.paytm.recharge.dth.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.w;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.model.v4.CJRDthRechargeHeaderModel;

public final class CJRDTHRechargeHeaderView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f62751a;

    /* renamed from: b  reason: collision with root package name */
    private final CJRDthRechargeHeaderModel f62752b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f62753c;

    public interface a {
        void R();
    }

    private View a(int i2) {
        if (this.f62753c == null) {
            this.f62753c = new HashMap();
        }
        View view = (View) this.f62753c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f62753c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRDTHRechargeHeaderView(Context context, CJRDthRechargeHeaderModel cJRDthRechargeHeaderModel, a aVar) {
        super(context);
        k.c(context, "context");
        k.c(cJRDthRechargeHeaderModel, "inputModel");
        k.c(aVar, "backListener");
        this.f62752b = cJRDthRechargeHeaderModel;
        this.f62751a = aVar;
        k.a((Object) LayoutInflater.from(context).inflate(R.layout.dth_recharge_header_view, this, true), "LayoutInflater.from(cont…_header_view, this, true)");
        ImageView imageView = (ImageView) a(R.id.ic_back);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) a(R.id.ic_back);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new b(this));
        }
        CJRDthRechargeHeaderModel cJRDthRechargeHeaderModel2 = this.f62752b;
        if (cJRDthRechargeHeaderModel2 != null) {
            String operatorImageUrl = cJRDthRechargeHeaderModel2.getOperatorImageUrl();
            if (operatorImageUrl != null) {
                w.a().a(operatorImageUrl).a((ImageView) a(R.id.operator_image));
            }
            if (TextUtils.isEmpty(cJRDthRechargeHeaderModel2.getOperator()) || TextUtils.isEmpty(cJRDthRechargeHeaderModel2.getOperatorId())) {
                String operator = cJRDthRechargeHeaderModel2.getOperator();
                if (operator != null) {
                    TextView textView = (TextView) a(R.id.operator_id);
                    k.a((Object) textView, "operator_id");
                    textView.setText(operator);
                    TextView textView2 = (TextView) a(R.id.operator_id);
                    k.a((Object) textView2, "operator_id");
                    ai.a(textView2);
                }
                String operatorId = cJRDthRechargeHeaderModel2.getOperatorId();
                if (operatorId != null) {
                    TextView textView3 = (TextView) a(R.id.operator_id);
                    k.a((Object) textView3, "operator_id");
                    textView3.setText(operatorId);
                    TextView textView4 = (TextView) a(R.id.operator_id);
                    k.a((Object) textView4, "operator_id");
                    ai.a(textView4);
                    return;
                }
                return;
            }
            TextView textView5 = (TextView) a(R.id.operator);
            k.a((Object) textView5, StringSet.operator);
            textView5.setText(cJRDthRechargeHeaderModel2.getOperator());
            TextView textView6 = (TextView) a(R.id.operator);
            k.a((Object) textView6, StringSet.operator);
            ai.a(textView6);
            TextView textView7 = (TextView) a(R.id.operator_id);
            k.a((Object) textView7, "operator_id");
            textView7.setText(cJRDthRechargeHeaderModel2.getOperatorId());
            TextView textView8 = (TextView) a(R.id.operator_id);
            k.a((Object) textView8, "operator_id");
            ai.a(textView8);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRDTHRechargeHeaderView f62754a;

        b(CJRDTHRechargeHeaderView cJRDTHRechargeHeaderView) {
            this.f62754a = cJRDTHRechargeHeaderView;
        }

        public final void onClick(View view) {
            a a2 = this.f62754a.f62751a;
            if (a2 != null) {
                a2.R();
            }
        }
    }
}
