package net.one97.paytm.paymentsBank.nach.detailpage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.l;
import net.one97.paytm.paymentsBank.model.nach.NachTransactionDetailResponse;
import net.one97.paytm.paymentsBank.model.nach.Payload;

public class a extends l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final C0319a f18561a = new C0319a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private Payload f18562c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.nach.detailpage.a.a f18563d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f18564e;

    public final View a(int i2) {
        if (this.f18564e == null) {
            this.f18564e = new HashMap();
        }
        View view = (View) this.f18564e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18564e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onClick(View view) {
        if (view == null) {
            k.a();
        }
        int id = view.getId();
        if (id == R.id.tool_bar_back) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            activity.onBackPressed();
        } else if (id == R.id.back_arrow) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            activity2.onBackPressed();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_fragment_nach_detail_transaction_list, (ViewGroup) null, false);
    }

    public static final class b implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18565a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f18566b;

        /* renamed from: c  reason: collision with root package name */
        private int f18567c = -1;

        b(a aVar, float f2) {
            this.f18565a = aVar;
            this.f18566b = f2;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            k.c(appBarLayout, "appBarLayout");
            if (i2 == 0 || ((float) Math.abs(i2)) < this.f18566b) {
                Toolbar toolbar = (Toolbar) this.f18565a.a(R.id.toolbar);
                k.a((Object) toolbar, "toolbar");
                toolbar.setVisibility(8);
                return;
            }
            Toolbar toolbar2 = (Toolbar) this.f18565a.a(R.id.toolbar);
            k.a((Object) toolbar2, "toolbar");
            toolbar2.setVisibility(0);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        getView();
        Bundle arguments = getArguments();
        String str = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("key_payload") : null;
        if (serializable != null) {
            this.f18562c = (Payload) serializable;
            TextView textView = (TextView) a(R.id.bankName);
            k.a((Object) textView, "bankName");
            Payload payload = this.f18562c;
            if (payload == null) {
                k.a("payload");
            }
            textView.setText(payload.getCorporate());
            RoboTextView roboTextView = (RoboTextView) a(R.id.rupeesTv);
            k.a((Object) roboTextView, "rupeesTv");
            int i2 = R.string.pb_nach_rupee;
            Object[] objArr = new Object[1];
            Payload payload2 = this.f18562c;
            if (payload2 == null) {
                k.a("payload");
            }
            objArr[0] = net.one97.paytm.bankCommon.mapping.a.ac(payload2.getCurrentAmount());
            roboTextView.setText(getString(i2, objArr));
            Payload payload3 = this.f18562c;
            if (payload3 == null) {
                k.a("payload");
            }
            if (!TextUtils.isEmpty(payload3.getCurrentRecurringCode())) {
                Payload payload4 = this.f18562c;
                if (payload4 == null) {
                    k.a("payload");
                }
                if (k.a((Object) "OOFF", (Object) payload4.getCurrentRecurringCode())) {
                    ((RoboTextView) a(R.id.frequencyTv)).setText(R.string.pb_nach_one_time);
                } else {
                    RoboTextView roboTextView2 = (RoboTextView) a(R.id.frequencyTv);
                    k.a((Object) roboTextView2, "frequencyTv");
                    Payload payload5 = this.f18562c;
                    if (payload5 == null) {
                        k.a("payload");
                    }
                    roboTextView2.setText(payload5.getCurrentFrequency());
                }
            } else {
                RoboTextView roboTextView3 = (RoboTextView) a(R.id.frequencyTv);
                k.a((Object) roboTextView3, "frequencyTv");
                Payload payload6 = this.f18562c;
                if (payload6 == null) {
                    k.a("payload");
                }
                roboTextView3.setText(payload6.getCurrentFrequency());
            }
            Context context = getContext();
            String string = context != null ? context.getString(R.string.pb_nach_until_cancelled) : null;
            Payload payload7 = this.f18562c;
            if (payload7 == null) {
                k.a("payload");
            }
            if (!TextUtils.isEmpty(payload7.getCurrentEndDate())) {
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                int i3 = R.string.pb_nach_to;
                Object[] objArr2 = new Object[1];
                Payload payload8 = this.f18562c;
                if (payload8 == null) {
                    k.a("payload");
                }
                objArr2[0] = payload8.getCurrentEndDate();
                string = context2.getString(i3, objArr2);
            }
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.dateTv);
            k.a((Object) roboTextView4, "dateTv");
            Context context3 = getContext();
            if (context3 != null) {
                int i4 = R.string.pb_nach_to_from;
                Object[] objArr3 = new Object[2];
                Payload payload9 = this.f18562c;
                if (payload9 == null) {
                    k.a("payload");
                }
                objArr3[0] = payload9.getCurrentStartDate();
                objArr3[1] = string;
                str = context3.getString(i4, objArr3);
            }
            roboTextView4.setText(str);
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.regNoTv);
            k.a((Object) roboTextView5, "regNoTv");
            int i5 = R.string.pb_nach_ref_no;
            Object[] objArr4 = new Object[1];
            Payload payload10 = this.f18562c;
            if (payload10 == null) {
                k.a("payload");
            }
            objArr4[0] = payload10.getUmrn();
            roboTextView5.setText(getString(i5, objArr4));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
            RecyclerView recyclerView = (RecyclerView) a(R.id.transRV);
            k.a((Object) recyclerView, "transRV");
            recyclerView.setLayoutManager(linearLayoutManager);
            this.f18563d = new net.one97.paytm.paymentsBank.nach.detailpage.a.a(getActivity());
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.transRV);
            k.a((Object) recyclerView2, "transRV");
            net.one97.paytm.paymentsBank.nach.detailpage.a.a aVar = this.f18563d;
            if (aVar == null) {
                k.a("mandateListAdapter");
            }
            recyclerView2.setAdapter(aVar);
            TextView textView2 = (TextView) a(R.id.txt_user_name_toolbar);
            k.a((Object) textView2, "txt_user_name_toolbar");
            Payload payload11 = this.f18562c;
            if (payload11 == null) {
                k.a("payload");
            }
            textView2.setText(payload11.getCorporate());
            View view2 = getView();
            View.OnClickListener onClickListener = this;
            ((ImageView) a(R.id.tool_bar_back)).setOnClickListener(onClickListener);
            ((ImageView) a(R.id.back_arrow)).setOnClickListener(onClickListener);
            float dimension = getResources().getDimension(R.dimen.dimen_56dp);
            if (view2 == null) {
                k.a();
            }
            View findViewById = view2.findViewById(R.id.appbar);
            if (findViewById != null) {
                ((AppBarLayout) findViewById).a((AppBarLayout.b) new b(this, dimension));
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", "NachTransactionHistoryListFragment");
                Context activity = getActivity();
                g.b bVar = this;
                g.a aVar2 = this;
                Payload payload12 = this.f18562c;
                if (payload12 == null) {
                    k.a("payload");
                }
                f a2 = net.one97.paytm.paymentsBank.b.a.a(activity, (g.b<IJRPaytmDataModel>) bVar, aVar2, payload12.getUmrn(), a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
                k.a((Object) a2, "PaymentBankAPIRequestFac…dditionalParams\n        )");
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
                    k.a((Object) lottieAnimationView, "loader");
                    lottieAnimationView.setVisibility(0);
                    lottieAnimationView.setAnimation("Payments-Loader.json");
                    lottieAnimationView.loop(true);
                    lottieAnimationView.playAnimation();
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        k.a();
                    }
                    k.a((Object) activity2, "activity!!");
                    activity2.getApplicationContext();
                    c.a();
                    c.a(a2);
                    return;
                }
                a(a2);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.nach.Payload");
    }

    /* renamed from: net.one97.paytm.paymentsBank.nach.detailpage.b.a$a  reason: collision with other inner class name */
    public static final class C0319a {
        private C0319a() {
        }

        public /* synthetic */ C0319a(byte b2) {
            this();
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (isAdded()) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
            k.a((Object) lottieAnimationView, "loader");
            a(lottieAnimationView);
            if (iJRPaytmDataModel instanceof NachTransactionDetailResponse) {
                NachTransactionDetailResponse nachTransactionDetailResponse = (NachTransactionDetailResponse) iJRPaytmDataModel;
                if (nachTransactionDetailResponse.getMontranTransactionDataList() == null || nachTransactionDetailResponse.getMontranTransactionDataList().size() <= 0) {
                    net.one97.paytm.paymentsBank.nach.detailpage.a.a aVar = this.f18563d;
                    if (aVar == null) {
                        k.a("mandateListAdapter");
                    }
                    aVar.a();
                    RoboTextView roboTextView = (RoboTextView) a(R.id.noItemTv);
                    k.a((Object) roboTextView, "noItemTv");
                    roboTextView.setVisibility(0);
                    RecyclerView recyclerView = (RecyclerView) a(R.id.transRV);
                    k.a((Object) recyclerView, "transRV");
                    recyclerView.setVisibility(8);
                } else {
                    net.one97.paytm.paymentsBank.nach.detailpage.a.a aVar2 = this.f18563d;
                    if (aVar2 == null) {
                        k.a("mandateListAdapter");
                    }
                    aVar2.a();
                    net.one97.paytm.paymentsBank.nach.detailpage.a.a aVar3 = this.f18563d;
                    if (aVar3 == null) {
                        k.a("mandateListAdapter");
                    }
                    aVar3.a(nachTransactionDetailResponse.getMontranTransactionDataList());
                    RecyclerView recyclerView2 = (RecyclerView) a(R.id.transRV);
                    k.a((Object) recyclerView2, "transRV");
                    recyclerView2.setVisibility(0);
                    RoboTextView roboTextView2 = (RoboTextView) a(R.id.noItemTv);
                    k.a((Object) roboTextView2, "noItemTv");
                    roboTextView2.setVisibility(8);
                }
            }
            super.onResponse(iJRPaytmDataModel);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded()) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loader);
            k.a((Object) lottieAnimationView, "loader");
            a(lottieAnimationView);
            net.one97.paytm.bankCommon.utils.f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18564e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
