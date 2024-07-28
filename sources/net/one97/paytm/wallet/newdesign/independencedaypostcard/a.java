package net.one97.paytm.wallet.newdesign.independencedaypostcard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.File;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRPostcardSentData;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.PostCardMainActivity;

public class a extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    RoboTextView f70954a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f70955b;

    /* renamed from: c  reason: collision with root package name */
    private C1436a f70956c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f70957d;

    /* renamed from: e  reason: collision with root package name */
    private IJRDataModel f70958e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70959f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f70960g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f70961h;

    /* renamed from: net.one97.paytm.wallet.newdesign.independencedaypostcard.a$a  reason: collision with other inner class name */
    public interface C1436a {
    }

    public static a a(CJRPostcardSentData cJRPostcardSentData) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", cJRPostcardSentData);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().getSerializable("data") != null) {
            this.f70958e = (IJRDataModel) getArguments().getSerializable("data");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_post_card_view_independence, viewGroup, false);
        this.f70957d = (ImageView) inflate.findViewById(R.id.iv_back_button);
        this.f70961h = (RelativeLayout) inflate.findViewById(R.id.rl_card_bg);
        this.f70957d.setOnClickListener(this);
        this.f70959f = (TextView) inflate.findViewById(R.id.tv_amount);
        this.f70960g = (TextView) inflate.findViewById(R.id.tv_from_name);
        this.f70954a = (RoboTextView) inflate.findViewById(R.id.tv_postcard_status);
        this.f70955b = (RoboTextView) inflate.findViewById(R.id.tv_expiry);
        this.f70954a.setOnClickListener(this);
        CJRPostcardSentData cJRPostcardSentData = (CJRPostcardSentData) this.f70958e;
        TextView textView = this.f70959f;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.rupee_symbol));
        String amount = cJRPostcardSentData.getAmount();
        if (!TextUtils.isEmpty(amount) && (amount.endsWith(".0") || amount.endsWith(".00"))) {
            String[] split = amount.split("\\.");
            if (split.length > 0) {
                amount = split[0];
            }
        }
        sb.append(amount);
        textView.setText(sb.toString());
        if (TextUtils.isEmpty(b.h((Context) getActivity())) || "null".equalsIgnoreCase(b.h((Context) getActivity()))) {
            cJRPostcardSentData.setName(b.l((Context) getActivity()));
        }
        this.f70960g.setText(cJRPostcardSentData.getName());
        String c2 = net.one97.paytm.wallet.utility.a.c((Context) getActivity());
        try {
            File file = new File(getActivity().getExternalCacheDir().toString(), c2.substring(c2.lastIndexOf("/")));
            if (file.exists()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile != null) {
                    this.f70961h.setBackground(new BitmapDrawable(decodeFile));
                } else {
                    a(c2);
                }
            } else {
                a(c2);
            }
        } catch (Exception unused) {
            a(c2);
        }
        inflate.findViewById(R.id.rl_content).setVisibility(0);
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof C1436a) {
                this.f70956c = (C1436a) context;
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f70956c = null;
    }

    public void onClick(View view) {
        if (this.f70957d == view) {
            getActivity().onBackPressed();
        } else if (view.getId() == R.id.tv_postcard_status) {
            startActivity(new Intent(getActivity(), PostCardMainActivity.class));
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }

    private void a(String str) {
        try {
            w.a().a(str).a((af) new af() {
                public final void onPrepareLoad(Drawable drawable) {
                }

                public final void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    if (a.this.getActivity() != null) {
                        a.this.f70961h.setBackground(new BitmapDrawable(bitmap));
                    }
                }

                public final void onBitmapFailed(Exception exc, Drawable drawable) {
                    if (a.this.getActivity() != null) {
                        a.this.f70961h.setBackground(new ColorDrawable(a.this.getActivity().getResources().getColor(R.color.white)));
                    }
                }
            });
        } catch (Exception unused) {
            if (getActivity() != null) {
                this.f70961h.setBackground(new ColorDrawable(getActivity().getResources().getColor(R.color.white)));
            }
        }
    }
}
