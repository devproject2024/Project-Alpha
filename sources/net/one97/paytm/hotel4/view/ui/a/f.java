package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.a.e;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.utils.b;
import net.one97.paytm.hotel4.view.ui.activity.AJRHotelsBookingStatusNew;
import net.one97.paytm.hotel4.viewmodel.CancelOrderViewModel;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.as;
import net.one97.paytm.hotels2.fragment.HotelHomeFragment;
import net.one97.paytm.i.g;

public final class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public SharedViewModel f28838a;

    /* renamed from: b  reason: collision with root package name */
    public ReviewViewModel f28839b;

    /* renamed from: c  reason: collision with root package name */
    private ErrorDialogViewModel f28840c;

    /* renamed from: d  reason: collision with root package name */
    private as f28841d;

    /* renamed from: e  reason: collision with root package name */
    private Fragment f28842e;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(ErrorDialogViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…logViewModel::class.java]");
            this.f28840c = (ErrorDialogViewModel) a2;
            ai a3 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…redViewModel::class.java]");
            this.f28838a = (SharedViewModel) a3;
            SharedViewModel sharedViewModel = this.f28838a;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a4 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(ReviewViewModel.class);
            k.a((Object) a4, "ViewModelProviders.of(it…iewViewModel::class.java)");
            this.f28839b = (ReviewViewModel) a4;
        }
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("tag", "") : null;
        String string2 = arguments != null ? arguments.getString(H5Logger.HEADER, "") : null;
        String string3 = arguments != null ? arguments.getString("error", "") : null;
        if (arguments != null) {
            str = arguments.getString("button", "");
        }
        if (string != null && (!k.a((Object) string, (Object) ""))) {
            b.a aVar = new b.a();
            aVar.a(String.valueOf(string2));
            aVar.b(String.valueOf(string3));
            aVar.c(String.valueOf(str));
            ErrorDialogViewModel errorDialogViewModel = this.f28840c;
            if (errorDialogViewModel == null) {
                k.a("errorDialogViewModel");
            }
            errorDialogViewModel.getTag().postValue(string);
            ErrorDialogViewModel errorDialogViewModel2 = this.f28840c;
            if (errorDialogViewModel2 == null) {
                k.a("errorDialogViewModel");
            }
            errorDialogViewModel2.getErrorObject().postValue(aVar);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        as a2 = as.a(LayoutInflater.from(getContext()));
        k.a((Object) a2, "H4FragmentErrorDialogBin…om(context), null, false)");
        this.f28841d = a2;
        as asVar = this.f28841d;
        if (asVar == null) {
            k.a("dialogFragmentBinding");
        }
        ErrorDialogViewModel errorDialogViewModel = this.f28840c;
        if (errorDialogViewModel == null) {
            k.a("errorDialogViewModel");
        }
        asVar.a(errorDialogViewModel);
        as asVar2 = this.f28841d;
        if (asVar2 == null) {
            k.a("dialogFragmentBinding");
        }
        asVar2.f29184a.setOnClickListener(new a(this));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        c.a aVar = new c.a(activity, R.style.H4BaseDialog);
        as asVar3 = this.f28841d;
        if (asVar3 == null) {
            k.a("dialogFragmentBinding");
        }
        c a3 = aVar.a(asVar3.getRoot()).a();
        k.a((Object) a3, "AlertDialog.Builder(acti…                .create()");
        Window window = a3.getWindow();
        if (window == null) {
            k.a();
        }
        window.setLayout(-1, -2);
        return a3;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f28843a;

        a(f fVar) {
            this.f28843a = fVar;
        }

        public final void onClick(View view) {
            f.a(this.f28843a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
            r2 = this;
            super.onResume()
            android.app.Dialog r0 = r2.getDialog()
            if (r0 == 0) goto L_0x0014
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0014
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r1 = -1
            r0.width = r1
        L_0x001a:
            if (r0 == 0) goto L_0x001f
            r1 = -2
            r0.height = r1
        L_0x001f:
            android.app.Dialog r1 = r2.getDialog()
            if (r1 == 0) goto L_0x0039
            android.view.Window r1 = r1.getWindow()
            if (r1 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x0031
            r1.setAttributes(r0)
            return
        L_0x0031:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.view.WindowManager.LayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.a.f.onResume():void");
    }

    public final void a(Fragment fragment) {
        k.c(fragment, "fragment");
        this.f28842e = fragment;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str = null;
        if (i2 == 800) {
            ReviewViewModel reviewViewModel = this.f28839b;
            if (reviewViewModel == null) {
                k.a("reviewViewModel");
            }
            e reviewRepository = reviewViewModel.getReviewRepository();
            if (!TextUtils.isEmpty(reviewRepository != null ? reviewRepository.d() : null)) {
                ReviewViewModel reviewViewModel2 = this.f28839b;
                if (reviewViewModel2 == null) {
                    k.a("reviewViewModel");
                }
                reviewViewModel2.setUserDetails();
                ReviewViewModel reviewViewModel3 = this.f28839b;
                if (reviewViewModel3 == null) {
                    k.a("reviewViewModel");
                }
                PromocodeDataItem applyPromoData = reviewViewModel3.getApplyPromoData();
                if (applyPromoData != null) {
                    ReviewViewModel reviewViewModel4 = this.f28839b;
                    if (reviewViewModel4 == null) {
                        k.a("reviewViewModel");
                    }
                    ReviewViewModel.onPromoCodeClick$default(reviewViewModel4, applyPromoData, false, 2, (Object) null);
                }
            }
        } else if (i2 == 801) {
            ReviewViewModel reviewViewModel5 = this.f28839b;
            if (reviewViewModel5 == null) {
                k.a("reviewViewModel");
            }
            e reviewRepository2 = reviewViewModel5.getReviewRepository();
            if (reviewRepository2 != null) {
                str = reviewRepository2.d();
            }
            if (!TextUtils.isEmpty(str)) {
                ReviewViewModel reviewViewModel6 = this.f28839b;
                if (reviewViewModel6 == null) {
                    k.a("reviewViewModel");
                }
                reviewViewModel6.getProcessToPayTapped().setValue(Boolean.FALSE);
                ReviewViewModel reviewViewModel7 = this.f28839b;
                if (reviewViewModel7 == null) {
                    k.a("reviewViewModel");
                }
                reviewViewModel7.onProcessToPayPressed();
            }
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        ReviewViewModel reviewViewModel = fVar.f28839b;
        if (reviewViewModel == null) {
            k.a("reviewViewModel");
        }
        String str = null;
        (reviewViewModel != null ? reviewViewModel.isErrorPopUpVisible() : null).postValue(Boolean.FALSE);
        Fragment fragment = fVar.f28842e;
        if (fragment instanceof HotelHomeFragment) {
            ErrorDialogViewModel errorDialogViewModel = fVar.f28840c;
            if (errorDialogViewModel == null) {
                k.a("errorDialogViewModel");
            }
            if (k.a((Object) errorDialogViewModel.getTag().getValue(), (Object) "8")) {
                Fragment fragment2 = fVar.f28842e;
                if (fragment2 != null) {
                    ((HotelHomeFragment) fragment2).openCitySearchActivity();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.hotels2.fragment.HotelHomeFragment");
                }
            }
        } else if (fragment instanceof s) {
            ErrorDialogViewModel errorDialogViewModel2 = fVar.f28840c;
            if (errorDialogViewModel2 == null) {
                k.a("errorDialogViewModel");
            }
            if (k.a((Object) errorDialogViewModel2.getTag().getValue(), (Object) "7")) {
                Fragment fragment3 = fVar.f28842e;
                if (fragment3 != null) {
                    s sVar = (s) fragment3;
                    Intent intent = new Intent(sVar.getContext(), AJRHotelsBookingStatusNew.class);
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    intent.addFlags(536870912);
                    CancelOrderViewModel cancelOrderViewModel = sVar.f28947b;
                    if (cancelOrderViewModel != null) {
                        str = cancelOrderViewModel.getOrderId();
                    }
                    intent.putExtra("order_id", str);
                    sVar.startActivity(intent);
                    FragmentActivity activity = sVar.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.view.ui.fragment.FJROderSummaryCancelScreen");
                }
            }
        }
        Dialog dialog = fVar.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }
}
