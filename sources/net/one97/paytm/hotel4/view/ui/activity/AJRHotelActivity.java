package net.one97.paytm.hotel4.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.travel.utils.h;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.hotel4.service.model.ScreenNavigationInfo;
import net.one97.paytm.hotel4.view.ui.a.aa;
import net.one97.paytm.hotel4.view.ui.a.ac;
import net.one97.paytm.hotel4.view.ui.a.b;
import net.one97.paytm.hotel4.view.ui.a.d;
import net.one97.paytm.hotel4.view.ui.a.e;
import net.one97.paytm.hotel4.view.ui.a.g;
import net.one97.paytm.hotel4.view.ui.a.i;
import net.one97.paytm.hotel4.view.ui.a.j;
import net.one97.paytm.hotel4.view.ui.a.m;
import net.one97.paytm.hotel4.view.ui.a.n;
import net.one97.paytm.hotel4.view.ui.a.r;
import net.one97.paytm.hotel4.view.ui.a.t;
import net.one97.paytm.hotel4.view.ui.a.u;
import net.one97.paytm.hotel4.view.ui.a.v;
import net.one97.paytm.hotel4.view.ui.a.w;
import net.one97.paytm.hotel4.view.ui.a.x;
import net.one97.paytm.hotel4.view.ui.a.y;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.bm;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class AJRHotelActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public SharedViewModel f29041a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f29042b;

    /* renamed from: c  reason: collision with root package name */
    private h f29043c = new h(750);

    static final class a<T> implements z<ScreenNavigationInfo> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRHotelActivity f29044a;

        a(AJRHotelActivity aJRHotelActivity) {
            this.f29044a = aJRHotelActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            AJRHotelActivity.a(this.f29044a, (ScreenNavigationInfo) obj);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = f.a(this, R.layout.h4_home_activity);
        k.a((Object) a2, "DataBindingUtil.setConte….layout.h4_home_activity)");
        q qVar = this;
        ((bm) a2).setLifecycleOwner(qVar);
        ai a3 = am.a((FragmentActivity) this).a(SharedViewModel.class);
        k.a((Object) a3, "ViewModelProviders.of(th…redViewModel::class.java)");
        this.f29041a = (SharedViewModel) a3;
        SharedViewModel sharedViewModel = this.f29041a;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        sharedViewModel.setContext(this);
        SharedViewModel sharedViewModel2 = this.f29041a;
        if (sharedViewModel2 == null) {
            k.a("sharedViewModel");
        }
        Intent intent = getIntent();
        k.a((Object) intent, "this.intent");
        sharedViewModel2.getDataFromIntent(intent);
        SharedViewModel sharedViewModel3 = this.f29041a;
        if (sharedViewModel3 == null) {
            k.a("sharedViewModel");
        }
        sharedViewModel3.getFragmentIndexToLoad().observe(qVar, new a(this));
        SharedViewModel sharedViewModel4 = this.f29041a;
        if (sharedViewModel4 == null) {
            k.a("sharedViewModel");
        }
        sharedViewModel4.postScreenNavigationEvent("0", "3");
    }

    private final boolean a() {
        SharedViewModel sharedViewModel = this.f29041a;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        ScreenNavigationInfo value = sharedViewModel.getFragmentIndexToLoad().getValue();
        if (value != null) {
            String screenName = value.getScreenName();
            int hashCode = screenName.hashCode();
            switch (hashCode) {
                case 50:
                    if (screenName.equals("2")) {
                    }
                    break;
                case 51:
                    if (screenName.equals("3")) {
                        return false;
                    }
                    break;
                case 52:
                    if (screenName.equals("4")) {
                        return true;
                    }
                    break;
                case 53:
                    if (screenName.equals("5")) {
                        return true;
                    }
                    break;
                case 54:
                    if (screenName.equals("6")) {
                        return true;
                    }
                    break;
                case 55:
                    if (screenName.equals("7")) {
                        return true;
                    }
                    break;
                case 56:
                    if (screenName.equals("8")) {
                        return true;
                    }
                    break;
                default:
                    switch (hashCode) {
                        case 1568:
                            if (screenName.equals("11")) {
                                SharedViewModel sharedViewModel2 = this.f29041a;
                                if (sharedViewModel2 == null) {
                                    k.a("sharedViewModel");
                                }
                                Boolean value2 = sharedViewModel2.isFromRoomSelection().getValue();
                                if (value2 == null) {
                                    k.a();
                                }
                                k.a((Object) value2, "sharedViewModel.isFromRoomSelection.value!!");
                                if (value2.booleanValue()) {
                                    return true;
                                }
                                return false;
                            }
                            break;
                        case 1600:
                            if (screenName.equals("22")) {
                                return true;
                            }
                            break;
                        case 1632:
                            if (screenName.equals("33")) {
                                return true;
                            }
                            break;
                        case 1664:
                            if (screenName.equals("44")) {
                                return true;
                            }
                            break;
                        case 1696:
                            if (screenName.equals("55")) {
                                return true;
                            }
                            break;
                        case 1728:
                            if (screenName.equals("66")) {
                                return true;
                            }
                            break;
                        case 1760:
                            if (screenName.equals("77")) {
                                return true;
                            }
                            break;
                        case 48657:
                            if (screenName.equals("111")) {
                                return true;
                            }
                            break;
                        case 50643:
                            if (screenName.equals("333")) {
                                return true;
                            }
                            break;
                        case 51636:
                            if (screenName.equals("444")) {
                                return true;
                            }
                            break;
                        case 53622:
                            if (screenName.equals("666")) {
                                return true;
                            }
                            break;
                        case 1477632:
                            if (screenName.equals("0000")) {
                                return true;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 1508416:
                                    if (screenName.equals(SDKConstants.UPI_LIMIT_EXCEED_ERROR)) {
                                        return true;
                                    }
                                    break;
                                case 1508417:
                                    if (screenName.equals(SDKConstants.UPI_DOWN_ERROR)) {
                                        return true;
                                    }
                                    break;
                                case 1508418:
                                    if (screenName.equals("1113")) {
                                        return true;
                                    }
                                    break;
                            }
                    }
            }
        }
        return false;
    }

    public final void onBackPressed(View view) {
        k.c(view, "view");
        onBackPressed();
    }

    private final void b() {
        Intent intent = new Intent();
        SharedViewModel sharedViewModel = this.f29041a;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput = sharedViewModel.getSearchInput();
        String str = null;
        intent.putExtra("city", searchInput != null ? searchInput.getCity() : null);
        SharedViewModel sharedViewModel2 = this.f29041a;
        if (sharedViewModel2 == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput2 = sharedViewModel2.getSearchInput();
        if (!TextUtils.isEmpty(searchInput2 != null ? searchInput2.getHotelId() : null)) {
            SharedViewModel sharedViewModel3 = this.f29041a;
            if (sharedViewModel3 == null) {
                k.a("sharedViewModel");
            }
            if (sharedViewModel3.isHotelSoldOut()) {
                intent.putExtra("hotelId", "");
                intent.putExtra("poi", "");
            } else {
                SharedViewModel sharedViewModel4 = this.f29041a;
                if (sharedViewModel4 == null) {
                    k.a("sharedViewModel");
                }
                CJRHotelSearchInput searchInput3 = sharedViewModel4.getSearchInput();
                intent.putExtra("hotelId", searchInput3 != null ? searchInput3.getHotelId() : null);
                SharedViewModel sharedViewModel5 = this.f29041a;
                if (sharedViewModel5 == null) {
                    k.a("sharedViewModel");
                }
                CJRHotelSearchInput searchInput4 = sharedViewModel5.getSearchInput();
                intent.putExtra("poi", searchInput4 != null ? searchInput4.getPoi() : null);
            }
        } else {
            intent.putExtra("hotelId", "");
            SharedViewModel sharedViewModel6 = this.f29041a;
            if (sharedViewModel6 == null) {
                k.a("sharedViewModel");
            }
            CJRHotelSearchInput searchInput5 = sharedViewModel6.getSearchInput();
            intent.putExtra("poi", searchInput5 != null ? searchInput5.getPoi() : null);
        }
        SharedViewModel sharedViewModel7 = this.f29041a;
        if (sharedViewModel7 == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput6 = sharedViewModel7.getSearchInput();
        intent.putExtra("checkInDate", searchInput6 != null ? searchInput6.getCheckInDate() : null);
        SharedViewModel sharedViewModel8 = this.f29041a;
        if (sharedViewModel8 == null) {
            k.a("sharedViewModel");
        }
        CJRHotelSearchInput searchInput7 = sharedViewModel8.getSearchInput();
        if (searchInput7 != null) {
            str = searchInput7.getCheckOutDate();
        }
        intent.putExtra("checkOutDate", str);
        setResult(111, intent);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment fragment = this.f29042b;
        if (fragment != null) {
            if (fragment == null) {
                k.a();
            }
            fragment.onActivityResult(i2, i3, intent);
        }
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        if (c.a() == null) {
            CJRHotelsUtilsLib.a(context);
        }
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ac, code lost:
        if (r0.isVisible() == false) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01d0, code lost:
        if (r0.isVisible() == false) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01f4, code lost:
        if (r0.isVisible() != false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01f6, code lost:
        r0 = r13.f29041a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f8, code lost:
        if (r0 != null) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01fa, code lost:
        kotlin.g.b.k.a("sharedViewModel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01fd, code lost:
        r0.postScreenNavigationEvent("44", "2");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0200, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBackPressed() {
        /*
            r13 = this;
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            java.lang.String r1 = "2"
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
            java.lang.String r2 = "event_label"
            java.lang.String r3 = "supportFragmentManager.f…ag(ScreenName.SRP_VIEW)!!"
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Any"
            r5 = 0
            java.lang.String r6 = "sharedViewModel"
            if (r0 == 0) goto L_0x0095
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x0095
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x0037
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0037:
            if (r7 == 0) goto L_0x0081
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x0040
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0040:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r7 = r7.getSearchInput()
            if (r7 == 0) goto L_0x0081
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x004d:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r7 = r7.getSearchInput()
            if (r7 != 0) goto L_0x0056
            kotlin.g.b.k.a()
        L_0x0056:
            java.lang.String r7 = r7.getCity()
            if (r7 == 0) goto L_0x0081
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r8 = r13.f29041a
            if (r8 != 0) goto L_0x0066
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0066:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r8 = r8.getSearchInput()
            if (r8 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            java.lang.String r8 = r8.getCity()
            if (r8 == 0) goto L_0x007b
            java.lang.Object r8 = (java.lang.Object) r8
            r7.put(r2, r8)
            goto L_0x0081
        L_0x007b:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r4)
            throw r0
        L_0x0081:
            net.one97.paytm.hotels2.utils.d r7 = net.one97.paytm.hotels2.utils.c.b()
            r12 = r0
            java.util.Map r12 = (java.util.Map) r12
            java.lang.String r8 = "customEvent"
            java.lang.String r9 = "Search Page"
            java.lang.String r10 = "hotels_srp"
            java.lang.String r11 = "back_tapped"
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x018e
        L_0x0095:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            java.lang.String r7 = "5"
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r7)
            if (r0 == 0) goto L_0x018e
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r7)
            if (r0 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            java.lang.String r7 = "supportFragmentManager.f…ScreenName.DETAIL_VIEW)!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x018e
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x00c5
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00c5:
            if (r7 == 0) goto L_0x010f
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x00ce
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00ce:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r7 = r7.getSearchInput()
            if (r7 == 0) goto L_0x010f
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x00db
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00db:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r7 = r7.getSearchInput()
            if (r7 != 0) goto L_0x00e4
            kotlin.g.b.k.a()
        L_0x00e4:
            java.lang.String r7 = r7.getCity()
            if (r7 == 0) goto L_0x010f
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r8 = r13.f29041a
            if (r8 != 0) goto L_0x00f4
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x00f4:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r8 = r8.getSearchInput()
            if (r8 != 0) goto L_0x00fd
            kotlin.g.b.k.a()
        L_0x00fd:
            java.lang.String r8 = r8.getCity()
            if (r8 == 0) goto L_0x0109
            java.lang.Object r8 = (java.lang.Object) r8
            r7.put(r2, r8)
            goto L_0x010f
        L_0x0109:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r4)
            throw r0
        L_0x010f:
            net.one97.paytm.hotel4.viewmodel.ViewModelFactory r2 = new net.one97.paytm.hotel4.viewmodel.ViewModelFactory
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r7 = r13.f29041a
            if (r7 != 0) goto L_0x0118
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0118:
            r2.<init>(r7)
            r7 = r13
            androidx.fragment.app.FragmentActivity r7 = (androidx.fragment.app.FragmentActivity) r7
            androidx.lifecycle.al$b r2 = (androidx.lifecycle.al.b) r2
            androidx.lifecycle.al r2 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r7, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.hotel4.viewmodel.SRPViewModel> r7 = net.one97.paytm.hotel4.viewmodel.SRPViewModel.class
            androidx.lifecycle.ai r2 = r2.a(r7)
            java.lang.String r7 = "ViewModelProviders.of(th…SRPViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r2 = (net.one97.paytm.hotel4.viewmodel.SRPViewModel) r2
            if (r2 == 0) goto L_0x017c
            androidx.lifecycle.y r7 = r2.getSelectedData()
            if (r7 == 0) goto L_0x017c
            androidx.lifecycle.y r7 = r2.getSelectedData()
            java.lang.Object r7 = r7.getValue()
            if (r7 == 0) goto L_0x017c
            androidx.lifecycle.y r7 = r2.getSelectedData()
            java.lang.Object r7 = r7.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r7 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r7
            if (r7 == 0) goto L_0x0154
            java.lang.String r7 = r7.getName()
            goto L_0x0155
        L_0x0154:
            r7 = r5
        L_0x0155:
            if (r7 == 0) goto L_0x017c
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.y r2 = r2.getSelectedData()
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r2 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r2
            if (r2 == 0) goto L_0x016b
            java.lang.String r2 = r2.getName()
            goto L_0x016c
        L_0x016b:
            r2 = r5
        L_0x016c:
            if (r2 == 0) goto L_0x0176
            java.lang.Object r2 = (java.lang.Object) r2
            java.lang.String r4 = "event_label2"
            r7.put(r4, r2)
            goto L_0x017c
        L_0x0176:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r4)
            throw r0
        L_0x017c:
            net.one97.paytm.hotels2.utils.d r7 = net.one97.paytm.hotels2.utils.c.b()
            r12 = r0
            java.util.Map r12 = (java.util.Map) r12
            java.lang.String r8 = "customEvent"
            java.lang.String r9 = "Hotel Details"
            java.lang.String r10 = "hotels_details"
            java.lang.String r11 = "back_tapped"
            r7.a(r8, r9, r10, r11, r12)
        L_0x018e:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
            if (r0 == 0) goto L_0x01ae
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
            if (r0 != 0) goto L_0x01a5
            kotlin.g.b.k.a()
        L_0x01a5:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            boolean r0 = r0.isVisible()
            if (r0 != 0) goto L_0x025e
        L_0x01ae:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            java.lang.String r2 = "44"
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r2)
            if (r0 == 0) goto L_0x01d2
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r2)
            if (r0 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            java.lang.String r3 = "supportFragmentManager.f…enName.SRP_FILTER_VIEW)!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            boolean r0 = r0.isVisible()
            if (r0 != 0) goto L_0x01f6
        L_0x01d2:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            java.lang.String r3 = "4"
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r3)
            if (r0 == 0) goto L_0x0201
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r3)
            if (r0 != 0) goto L_0x01eb
            kotlin.g.b.k.a()
        L_0x01eb:
            java.lang.String r3 = "supportFragmentManager.f…creenName.SRP_MAP_VIEW)!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x0201
        L_0x01f6:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r13.f29041a
            if (r0 != 0) goto L_0x01fd
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01fd:
            r0.postScreenNavigationEvent(r2, r1)
            return
        L_0x0201:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            java.lang.String r1 = "supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.f()
            if (r0 != 0) goto L_0x0211
            goto L_0x0237
        L_0x0211:
            androidx.fragment.app.j r0 = r13.getSupportFragmentManager()
            androidx.fragment.app.j r2 = r13.getSupportFragmentManager()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            int r1 = r2.f()
            int r1 = r1 + -1
            androidx.fragment.app.j$a r0 = r0.b((int) r1)
            java.lang.String r1 = "supportFragmentManager.g….backStackEntryCount - 1)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.g()
            androidx.fragment.app.j r1 = r13.getSupportFragmentManager()
            androidx.fragment.app.Fragment r5 = r1.c((java.lang.String) r0)
        L_0x0237:
            if (r5 == 0) goto L_0x0254
            boolean r0 = r5 instanceof com.google.android.material.bottomsheet.b
            if (r0 == 0) goto L_0x0243
            com.google.android.material.bottomsheet.b r5 = (com.google.android.material.bottomsheet.b) r5
            r5.dismiss()
            return
        L_0x0243:
            boolean r0 = r13.a()
            if (r0 == 0) goto L_0x024d
            super.onBackPressed()
            return
        L_0x024d:
            r13.b()
            r13.finish()
            return
        L_0x0254:
            boolean r0 = r13.a()
            if (r0 == 0) goto L_0x025e
            super.onBackPressed()
            return
        L_0x025e:
            r13.b()
            r13.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.view.ui.activity.AJRHotelActivity.onBackPressed():void");
    }

    public static final /* synthetic */ void a(AJRHotelActivity aJRHotelActivity, ScreenNavigationInfo screenNavigationInfo) {
        String str = null;
        String screenName = screenNavigationInfo != null ? screenNavigationInfo.getScreenName() : null;
        if (aJRHotelActivity.getSupportFragmentManager().b(screenName)) {
            StringBuilder sb = new StringBuilder("popBack ");
            if (screenNavigationInfo != null) {
                str = screenNavigationInfo.getFrom();
            }
            sb.append(str);
            sb.append(" To ");
            sb.append(screenName);
            return;
        }
        if (screenName != null) {
            int hashCode = screenName.hashCode();
            switch (hashCode) {
                case 50:
                    if (screenName.equals("2")) {
                        aJRHotelActivity.f29042b = new n();
                        break;
                    }
                    break;
                case 51:
                    if (screenName.equals("3")) {
                        aJRHotelActivity.f29042b = new x();
                        break;
                    }
                    break;
                case 52:
                    if (screenName.equals("4")) {
                        aJRHotelActivity.f29042b = new ac();
                        break;
                    }
                    break;
                case 53:
                    if (screenName.equals("5")) {
                        aJRHotelActivity.f29042b = new d();
                        break;
                    }
                    break;
                case 54:
                    if (screenName.equals("6")) {
                        aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.k();
                        break;
                    }
                    break;
                case 55:
                    if (screenName.equals("7")) {
                        aJRHotelActivity.f29042b = new v();
                        break;
                    }
                    break;
                case 56:
                    if (screenName.equals("8")) {
                        aJRHotelActivity.f29042b = new u();
                        break;
                    }
                    break;
                default:
                    switch (hashCode) {
                        case 1568:
                            if (screenName.equals("11")) {
                                aJRHotelActivity.f29042b = new e();
                                break;
                            }
                            break;
                        case 1600:
                            if (screenName.equals("22")) {
                                aJRHotelActivity.f29042b = new y();
                                break;
                            }
                            break;
                        case 1632:
                            if (screenName.equals("33")) {
                                aJRHotelActivity.f29042b = new g();
                                break;
                            }
                            break;
                        case 1664:
                            if (screenName.equals("44")) {
                                aJRHotelActivity.f29042b = new w();
                                break;
                            }
                            break;
                        case 1696:
                            if (screenName.equals("55")) {
                                aJRHotelActivity.f29042b = new j();
                                break;
                            }
                            break;
                        case 1728:
                            if (screenName.equals("66")) {
                                aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.h();
                                break;
                            }
                            break;
                        case 1760:
                            if (screenName.equals("77")) {
                                aJRHotelActivity.f29042b = new i();
                                break;
                            }
                            break;
                        case 48657:
                            if (screenName.equals("111")) {
                                aJRHotelActivity.f29042b = new r();
                                break;
                            }
                            break;
                        case 50643:
                            if (screenName.equals("333")) {
                                aJRHotelActivity.f29042b = new aa();
                                break;
                            }
                            break;
                        case 51636:
                            if (screenName.equals("444")) {
                                aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.a();
                                break;
                            }
                            break;
                        case 53622:
                            if (screenName.equals("666")) {
                                aJRHotelActivity.f29042b = new m();
                                break;
                            }
                            break;
                        case 1477632:
                            if (screenName.equals("0000")) {
                                aJRHotelActivity.f29042b = new t();
                                break;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 1508416:
                                    if (screenName.equals(SDKConstants.UPI_LIMIT_EXCEED_ERROR)) {
                                        aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.f();
                                        break;
                                    }
                                    break;
                                case 1508417:
                                    if (screenName.equals(SDKConstants.UPI_DOWN_ERROR)) {
                                        aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.q();
                                        break;
                                    }
                                    break;
                                case 1508418:
                                    if (screenName.equals("1113")) {
                                        aJRHotelActivity.f29042b = new net.one97.paytm.hotel4.view.ui.a.z();
                                        break;
                                    }
                                    break;
                            }
                    }
            }
        }
        if (aJRHotelActivity.f29042b == null) {
            aJRHotelActivity.f29042b = new b();
        }
        Fragment fragment = aJRHotelActivity.f29042b;
        if (fragment == null) {
            k.a();
        }
        if (screenNavigationInfo == null) {
            k.a();
        }
        boolean isAddtoBackStack = screenNavigationInfo.isAddtoBackStack();
        String screenName2 = screenNavigationInfo.getScreenName();
        androidx.fragment.app.j supportFragmentManager = aJRHotelActivity.getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        androidx.fragment.app.q a2 = supportFragmentManager.a();
        k.a((Object) a2, "manager.beginTransaction()");
        if (!(fragment instanceof x)) {
            a2.a(R.anim.hotel_enter_from_right, R.anim.hotel_exit_to_left, R.anim.hotel_enter_from_left, R.anim.hotel_exit_to_right);
        }
        if (isAddtoBackStack) {
            a2.a(screenName2);
        }
        if (!(fragment instanceof androidx.fragment.app.b)) {
            a2.b(R.id.fragment_continer, fragment, screenName2);
            a2.c();
        } else if (!aJRHotelActivity.f29043c.a(screenName2)) {
            ((androidx.fragment.app.b) fragment).show(a2, screenName2);
        }
    }
}
