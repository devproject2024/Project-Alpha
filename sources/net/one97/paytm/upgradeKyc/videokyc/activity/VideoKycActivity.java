package net.one97.paytm.upgradeKyc.videokyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.location.LocationResult;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.KYCWaitTimeResponse;
import net.one97.paytm.common.entity.upgradeKyc.VideoKYCLeadResponse;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.MyOrderApiResponse;
import net.one97.paytm.common.utility.h;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.b.b;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.videokyc.a.a;
import net.one97.paytm.upgradeKyc.videokyc.a.c;
import net.one97.paytm.upgradeKyc.videokyc.a.d;
import net.one97.paytm.upgradeKyc.videokyc.a.g;
import net.one97.paytm.upgradeKyc.videokyc.a.h;
import net.one97.paytm.upgradeKyc.videokyc.b.d;

public final class VideoKycActivity extends UpgradeKycBaseActivity implements h, a.b, c.b, d.b, g.b, h.b {

    /* renamed from: a  reason: collision with root package name */
    public static String f66430a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f66431b = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.videokyc.b.d f66432d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DeepLinkData f66433e;

    /* renamed from: f  reason: collision with root package name */
    private String f66434f = "EXTRA_DEEP_LINK_DATA";

    /* renamed from: g  reason: collision with root package name */
    private String f66435g = "proceed_video_kyc_internal";

    /* renamed from: h  reason: collision with root package name */
    private String f66436h = "vkycinternalH5Url";

    /* renamed from: i  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCWaitTimeResponse>> f66437i = new e(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<VideoKYCLeadResponse>> j = new d(this);
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> k = new c(this);
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    static final class c<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycActivity f66439a;

        c(VideoKycActivity videoKycActivity) {
            this.f66439a = videoKycActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f66455c[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66439a.a(R.id.wallet_loader));
                    String str = VideoKycActivity.a(this.f66439a).p;
                    int hashCode = str.hashCode();
                    if (hashCode != -270032864) {
                        if (hashCode != -92522254) {
                            if (hashCode == 200541423 && str.equals("user_missed_appointment")) {
                                VideoKycActivity.d(this.f66439a);
                                return;
                            }
                        } else if (str.equals("user_is_early_as_per_appointment_booked_time")) {
                            VideoKycActivity.c(this.f66439a);
                            return;
                        }
                    } else if (str.equals("user_ontime")) {
                        VideoKycActivity.d(this.f66439a);
                        return;
                    }
                    VideoKycActivity.d(this.f66439a);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66439a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66439a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66439a.a(R.id.wallet_loader));
                        VideoKycActivity videoKycActivity = this.f66439a;
                        String string = videoKycActivity.getString(R.string.some_went_wrong);
                        k.a((Object) string, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (RelativeLayout) videoKycActivity.a(R.id.video_kyc_parent), (CharSequence) string, -1).c();
                    }
                }
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<VideoKYCLeadResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycActivity f66440a;

        d(VideoKycActivity videoKycActivity) {
            this.f66440a = videoKycActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            VideoKYCLeadResponse videoKYCLeadResponse;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            DeepLinkData deepLinkData = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f66454b[dVar.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66440a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            k.a();
                        }
                        Integer statusCode = ((VideoKYCLeadResponse) resulttype).getStatusCode();
                        if (statusCode != null && statusCode.intValue() == 200) {
                            ResultType resulttype2 = bVar.f66169b;
                            if (resulttype2 == null) {
                                k.a();
                            }
                            CharSequence waitPageUrl = ((VideoKYCLeadResponse) resulttype2).getWaitPageUrl();
                            if (!(waitPageUrl == null || waitPageUrl.length() == 0)) {
                                if (this.f66440a.getSupportFragmentManager().c(R.id.fl_container) instanceof g) {
                                    this.f66440a.getSupportFragmentManager().e();
                                }
                                if (bVar != null) {
                                    videoKYCLeadResponse = (VideoKYCLeadResponse) bVar.f66169b;
                                } else {
                                    videoKYCLeadResponse = null;
                                }
                                if (videoKYCLeadResponse == null) {
                                    k.a();
                                }
                                if (videoKYCLeadResponse.isInternalRouting()) {
                                    ResultType resulttype3 = bVar.f66169b;
                                    if (resulttype3 == null) {
                                        k.a();
                                    }
                                    String waitPageUrl2 = ((VideoKYCLeadResponse) resulttype3).getWaitPageUrl();
                                    VideoKycActivity videoKycActivity = this.f66440a;
                                    net.one97.a.a aVar = net.one97.a.a.f48002a;
                                    Context context = this.f66440a;
                                    k.c(context, "context");
                                    DeepLinkData deepLinkData2 = new DeepLinkData();
                                    deepLinkData2.f50290h = null;
                                    CharSequence charSequence = waitPageUrl2;
                                    if (!(charSequence == null || charSequence.length() == 0)) {
                                        z = false;
                                    }
                                    if (!z) {
                                        if (waitPageUrl2 == null) {
                                            k.a();
                                        }
                                        deepLinkData = net.one97.a.a.a(context, waitPageUrl2, deepLinkData2);
                                    }
                                    videoKycActivity.f66433e = deepLinkData;
                                    VideoKycActivity videoKycActivity2 = this.f66440a;
                                    videoKycActivity2.c(videoKycActivity2.f66433e);
                                    return;
                                }
                                VideoKycActivity videoKycActivity3 = this.f66440a;
                                ResultType resulttype4 = bVar.f66169b;
                                if (resulttype4 == null) {
                                    k.a();
                                }
                                String waitPageUrl3 = ((VideoKYCLeadResponse) resulttype4).getWaitPageUrl();
                                k.a((Object) waitPageUrl3, "it.data!!.waitPageUrl");
                                VideoKycActivity.b(videoKycActivity3, waitPageUrl3);
                                return;
                            }
                        }
                    }
                    if (bVar.f66169b != null) {
                        ResultType resulttype5 = bVar.f66169b;
                        if (resulttype5 == null) {
                            k.a();
                        }
                        CharSequence displayMessage = ((VideoKYCLeadResponse) resulttype5).getDisplayMessage();
                        if (!(displayMessage == null || displayMessage.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            VideoKycActivity videoKycActivity4 = this.f66440a;
                            ResultType resulttype6 = bVar.f66169b;
                            if (resulttype6 == null) {
                                k.a();
                            }
                            String displayMessage2 = ((VideoKYCLeadResponse) resulttype6).getDisplayMessage();
                            k.a((Object) displayMessage2, "it.data!!.displayMessage");
                            Snackbar.a((View) (RelativeLayout) videoKycActivity4.a(R.id.video_kyc_parent), (CharSequence) displayMessage2, -1).c();
                            return;
                        }
                    }
                    VideoKycActivity videoKycActivity5 = this.f66440a;
                    String string = videoKycActivity5.getString(R.string.some_went_wrong);
                    k.a((Object) string, "getString(R.string.some_went_wrong)");
                    Snackbar.a((View) (RelativeLayout) videoKycActivity5.a(R.id.video_kyc_parent), (CharSequence) string, -1).c();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66440a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context2 = this.f66440a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context2, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66440a.a(R.id.wallet_loader));
                        VideoKycActivity videoKycActivity6 = this.f66440a;
                        String string2 = videoKycActivity6.getString(R.string.some_went_wrong);
                        k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (RelativeLayout) videoKycActivity6.a(R.id.video_kyc_parent), (CharSequence) string2, -1).c();
                    }
                }
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<KYCWaitTimeResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycActivity f66441a;

        e(VideoKycActivity videoKycActivity) {
            this.f66441a = videoKycActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            Boolean bool = null;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = c.f66453a[dVar.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66441a.a(R.id.wallet_loader));
                    if (bVar.f66169b != null) {
                        ResultType resulttype = bVar.f66169b;
                        if (resulttype == null) {
                            k.a();
                        }
                        Integer statusCode = ((KYCWaitTimeResponse) resulttype).getStatusCode();
                        if (statusCode != null && statusCode.intValue() == 200) {
                            ResultType resulttype2 = bVar.f66169b;
                            if (resulttype2 == null) {
                                k.a();
                            }
                            if (((KYCWaitTimeResponse) resulttype2).getWaitTimeInSec() != null) {
                                if (VideoKycActivity.a(this.f66441a) != null) {
                                    net.one97.paytm.upgradeKyc.videokyc.b.d a2 = VideoKycActivity.a(this.f66441a);
                                    ResultType resulttype3 = bVar.f66169b;
                                    if (resulttype3 == null) {
                                        k.a();
                                    }
                                    String routingSource = ((KYCWaitTimeResponse) resulttype3).getRoutingSource();
                                    k.a((Object) routingSource, "it.data!!.routingSource");
                                    k.c(routingSource, "routingSourceValue");
                                    a2.k = routingSource;
                                    net.one97.paytm.upgradeKyc.videokyc.b.d a3 = VideoKycActivity.a(this.f66441a);
                                    ResultType resulttype4 = bVar.f66169b;
                                    if (resulttype4 == null) {
                                        k.a();
                                    }
                                    a3.j = ((KYCWaitTimeResponse) resulttype4).isInternalRouting();
                                }
                                net.one97.paytm.upgradeKyc.videokyc.b.d a4 = VideoKycActivity.a(this.f66441a);
                                if (a4 != null) {
                                    bool = Boolean.valueOf(a4.m);
                                }
                                if (bool.booleanValue()) {
                                    net.one97.paytm.upgradeKyc.videokyc.b.d a5 = VideoKycActivity.a(this.f66441a);
                                    if (a5 != null) {
                                        a5.m = false;
                                    }
                                    this.f66441a.g();
                                    return;
                                }
                                VideoKycActivity videoKycActivity = this.f66441a;
                                ResultType resulttype5 = bVar.f66169b;
                                if (resulttype5 == null) {
                                    k.a();
                                }
                                Integer waitTimeInSec = ((KYCWaitTimeResponse) resulttype5).getWaitTimeInSec();
                                k.a((Object) waitTimeInSec, "it.data!!.waitTimeInSec");
                                VideoKycActivity.a(videoKycActivity, waitTimeInSec.intValue());
                                return;
                            }
                        }
                    }
                    if (bVar.f66169b != null) {
                        ResultType resulttype6 = bVar.f66169b;
                        if (resulttype6 == null) {
                            k.a();
                        }
                        CharSequence displayMessage = ((KYCWaitTimeResponse) resulttype6).getDisplayMessage();
                        if (!(displayMessage == null || displayMessage.length() == 0)) {
                            z = false;
                        }
                        if (!z) {
                            VideoKycActivity videoKycActivity2 = this.f66441a;
                            ResultType resulttype7 = bVar.f66169b;
                            if (resulttype7 == null) {
                                k.a();
                            }
                            String displayMessage2 = ((KYCWaitTimeResponse) resulttype7).getDisplayMessage();
                            k.a((Object) displayMessage2, "it.data!!.displayMessage");
                            Snackbar.a((View) (RelativeLayout) videoKycActivity2.a(R.id.video_kyc_parent), (CharSequence) displayMessage2, -1).c();
                            return;
                        }
                    }
                    VideoKycActivity videoKycActivity3 = this.f66441a;
                    String string = videoKycActivity3.getString(R.string.some_went_wrong);
                    k.a((Object) string, "getString(R.string.some_went_wrong)");
                    Snackbar.a((View) (RelativeLayout) videoKycActivity3.a(R.id.video_kyc_parent), (CharSequence) string, -1).c();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66441a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66441a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66441a.a(R.id.wallet_loader));
                        VideoKycActivity videoKycActivity4 = this.f66441a;
                        String string2 = videoKycActivity4.getString(R.string.some_went_wrong);
                        k.a((Object) string2, "getString(R.string.some_went_wrong)");
                        Snackbar.a((View) (RelativeLayout) videoKycActivity4.a(R.id.video_kyc_parent), (CharSequence) string2, -1).c();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.videokyc.b.d a(VideoKycActivity videoKycActivity) {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = videoKycActivity.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        return dVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        int i2;
        String str;
        super.onCreate(bundle);
        f66430a = "initial";
        this.f66432d = (net.one97.paytm.upgradeKyc.videokyc.b.d) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.videokyc.b.d.class);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        Integer num = null;
        int i3 = 2;
        if ((d.a.a() != null ? Integer.valueOf(net.one97.paytm.upgradeKyc.helper.d.b("kycPermissibleEarlyTime")) : null) == null) {
            i2 = 2;
        } else {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            Integer valueOf = d.a.a() != null ? Integer.valueOf(net.one97.paytm.upgradeKyc.helper.d.b("kycPermissibleEarlyTime")) : null;
            if (valueOf == null) {
                k.a();
            }
            i2 = valueOf.intValue();
        }
        dVar.f66476h = i2;
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66432d;
        if (dVar2 == null) {
            k.a("sharedViewModel");
        }
        d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if ((d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kycEventSlug") : null) == null) {
            str = "paytm-kyc-slot-booking";
        } else {
            d.a aVar4 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            str = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a("kycEventSlug") : null;
            if (str == null) {
                k.a();
            }
        }
        k.c(str, "<set-?>");
        dVar2.l = str;
        d.a aVar5 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            num = Integer.valueOf(net.one97.paytm.upgradeKyc.helper.d.b("kycAppointmentSlotDuration"));
        }
        if (!(num == null || num.intValue() == 0)) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66432d;
            if (dVar3 == null) {
                k.a("sharedViewModel");
            }
            dVar3.f66477i = num.intValue();
        }
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar4 = this.f66432d;
        if (dVar4 == null) {
            k.a("sharedViewModel");
        }
        if (l.b()) {
            i3 = 1;
        }
        dVar4.f66473e = i3;
        if (getIntent() != null && getIntent().hasExtra(this.f66434f)) {
            this.f66433e = (DeepLinkData) getIntent().getParcelableExtra(this.f66434f);
        }
        DeepLinkData deepLinkData = this.f66433e;
        if (deepLinkData != null) {
            if (deepLinkData == null) {
                k.a();
            }
            if (!TextUtils.isEmpty(deepLinkData.f50288f)) {
                DeepLinkData deepLinkData2 = this.f66433e;
                if (deepLinkData2 == null) {
                    k.a();
                }
                if (p.a(deepLinkData2.f50288f, this.f66435g, true)) {
                    DeepLinkData deepLinkData3 = this.f66433e;
                    if (deepLinkData3 == null) {
                        k.a();
                    }
                    c(deepLinkData3);
                    return;
                }
            }
        }
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar5 = this.f66432d;
        if (dVar5 == null) {
            k.a("sharedViewModel");
        }
        q qVar = this;
        dVar5.u.observe(qVar, this.f66437i);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar6 = this.f66432d;
        if (dVar6 == null) {
            k.a("sharedViewModel");
        }
        dVar6.o.observe(qVar, this.j);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar7 = this.f66432d;
        if (dVar7 == null) {
            k.a("sharedViewModel");
        }
        dVar7.s.observe(qVar, this.k);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar8 = this.f66432d;
        if (dVar8 == null) {
            k.a("sharedViewModel");
        }
        k.c("user_have_no_appointment_booked", "appointmentType");
        dVar8.p = "user_have_no_appointment_booked";
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar9 = this.f66432d;
        if (dVar9 == null) {
            k.a("sharedViewModel");
        }
        dVar9.f66470b = new net.one97.paytm.common.utility.g(this, this, bundle);
        ((Button) a(R.id.btn_locationsetting)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycActivity f66438a;

        b(VideoKycActivity videoKycActivity) {
            this.f66438a = videoKycActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.common.utility.g gVar;
            int i2 = VideoKycActivity.a(this.f66438a).f66471c;
            if (i2 == 1) {
                net.one97.paytm.common.utility.g gVar2 = VideoKycActivity.a(this.f66438a).f66470b;
                if (gVar2 != null) {
                    gVar2.e();
                }
            } else if (i2 == 2) {
                net.one97.paytm.common.utility.g gVar3 = VideoKycActivity.a(this.f66438a).f66470b;
                if (gVar3 != null) {
                    gVar3.f();
                }
            } else if (i2 == 3 && (gVar = VideoKycActivity.a(this.f66438a).f66470b) != null) {
                gVar.c();
            }
        }
    }

    public final int a() {
        return R.layout.activity_video_kyc;
    }

    public final void aE_() {
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        dVar.f66471c = 3;
    }

    public final void a(String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        Toast.makeText(this, str, 1).show();
    }

    public final void onResume() {
        super.onResume();
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar = dVar.f66470b;
        if (gVar != null) {
            gVar.b();
        }
    }

    public final void onStop() {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar = dVar.f66470b;
        if (gVar != null) {
            gVar.d();
        }
        super.onStop();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar = dVar.f66470b;
        if (gVar != null) {
            gVar.a(i2, i3);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar = dVar.f66470b;
        if (gVar != null) {
            gVar.a(i2, strArr, iArr);
        }
    }

    public final void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        k.c(bundle, "outState");
        k.c(persistableBundle, "outPersistentState");
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar = dVar.f66470b;
        if (gVar != null) {
            gVar.a(bundle);
        }
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public final void a(LocationResult locationResult) {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        if (dVar.f66469a == null && locationResult != null) {
            Collection b2 = locationResult.b();
            boolean z = true;
            if (!(b2 == null || b2.isEmpty())) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66432d;
                if (dVar2 == null) {
                    k.a("sharedViewModel");
                }
                dVar2.f66469a = locationResult.b().get(0);
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66432d;
                if (dVar3 == null) {
                    k.a("sharedViewModel");
                }
                Location location = dVar3.f66469a;
                String str = null;
                if (location == null || location.getLatitude() != 0.0d) {
                    net.one97.paytm.upgradeKyc.videokyc.b.d dVar4 = this.f66432d;
                    if (dVar4 == null) {
                        k.a("sharedViewModel");
                    }
                    Location location2 = dVar4.f66469a;
                    if (location2 == null || location2.getLongitude() != 0.0d) {
                        net.one97.paytm.upgradeKyc.videokyc.b.d dVar5 = this.f66432d;
                        if (dVar5 == null) {
                            k.a("sharedViewModel");
                        }
                        net.one97.paytm.common.utility.g gVar = dVar5.f66470b;
                        if (gVar != null) {
                            gVar.a();
                        }
                        View a2 = a(R.id.location_error);
                        k.a((Object) a2, "location_error");
                        a2.setVisibility(8);
                        FrameLayout frameLayout = (FrameLayout) a(R.id.fl_container);
                        k.a((Object) frameLayout, "fl_container");
                        frameLayout.setVisibility(0);
                        net.one97.paytm.upgradeKyc.videokyc.b.d dVar6 = this.f66432d;
                        if (dVar6 == null) {
                            k.a("sharedViewModel");
                        }
                        net.one97.paytm.upgradeKyc.kycV3.b.c cVar = dVar6.v;
                        y<net.one97.paytm.upgradeKyc.kycV3.b.b<MyOrderApiResponse>> yVar = dVar6.n;
                        k.c(yVar, "data");
                        b.a aVar = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                        yVar.setValue(b.a.a());
                        d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                        if (d.a.a() != null) {
                            str = net.one97.paytm.upgradeKyc.helper.d.a("myorders_search");
                        }
                        CharSequence charSequence = str;
                        if (!(charSequence == null || charSequence.length() == 0)) {
                            z = false;
                        }
                        if (z || !URLUtil.isValidUrl(str)) {
                            b.a aVar3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar.setValue(b.a.a(cVar.b()));
                        } else if (TextUtils.isEmpty(com.paytm.utility.d.a(cVar.f66175b))) {
                            b.a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                            yVar.setValue(b.a.a(cVar.b()));
                        } else {
                            String e2 = com.paytm.utility.b.e(cVar.f66175b, str);
                            Map hashMap = new HashMap();
                            String a3 = com.paytm.utility.d.a(cVar.f66175b);
                            k.a((Object) a3, "CJRNetUtility.getSSOToken(this.appContext)");
                            hashMap.put(AppConstants.SSO_TOKEN, a3);
                            Map hashMap2 = new HashMap();
                            String a4 = com.paytm.utility.d.a(cVar.f66175b);
                            k.a((Object) a4, "CJRNetUtility.getSSOToken(this.appContext)");
                            hashMap2.put(AppConstants.SSO_TOKEN, a4);
                            hashMap2.put("type", EventsModuleManager.MODULE_NAME);
                            a.C1317a aVar5 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                            com.paytm.network.a l2 = a.C1317a.a().a(cVar.f66175b).a(a.C0715a.GET).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new MyOrderApiResponse()).a(e2).b(hashMap2).c(VideoKycActivity.class.getName()).a(a.b.USER_FACING).a((com.paytm.network.listener.b) new c.C1326c(yVar)).l();
                            if (com.paytm.utility.b.c(cVar.f66175b)) {
                                l2.a();
                            } else {
                                b.a aVar6 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d;
                                yVar.setValue(b.a.a(cVar.c()));
                            }
                        }
                        dVar6.s.addSource(dVar6.n, new d.b(dVar6));
                        net.one97.paytm.upgradeKyc.videokyc.b.d dVar7 = this.f66432d;
                        if (dVar7 == null) {
                            k.a("sharedViewModel");
                        }
                        Location location3 = dVar7.f66469a;
                        if (location3 != null) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("event_label", Boolean.valueOf(location3.isFromMockProvider()));
                            UpgradeKycBaseActivity.a(this, "/kyc/videokyc-screen", "is_gps_location_mocking_on", hashMap3, (String) null, 8);
                            return;
                        }
                        return;
                    }
                }
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar8 = this.f66432d;
                if (dVar8 == null) {
                    k.a("sharedViewModel");
                }
                dVar8.f66469a = null;
                return;
            }
        }
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar9 = this.f66432d;
        if (dVar9 == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.common.utility.g gVar2 = dVar9.f66470b;
        if (gVar2 != null) {
            gVar2.a();
        }
    }

    private final void b(String str) {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        k.c(str, "userFlow");
        dVar.r.setValue(str);
    }

    public final void e() {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        String str = dVar.p;
        if (str.hashCode() == -270032864 && str.equals("user_ontime")) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66432d;
            if (dVar2 == null) {
                k.a("sharedViewModel");
            }
            if (dVar2 != null) {
                dVar2.m = true;
            }
            b("user_ontime");
            return;
        }
        b("user_normal_flow");
    }

    private static HashMap<String, String> a(DeepLinkData deepLinkData) {
        Uri uri;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!(deepLinkData == null || deepLinkData.f50289g == null)) {
            Uri uri2 = deepLinkData.f50289g;
            Set<String> queryParameterNames = uri2 != null ? uri2.getQueryParameterNames() : null;
            if (!ab.d(queryParameterNames)) {
                queryParameterNames = null;
            }
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    hashMap.put(str, (deepLinkData == null || (uri = deepLinkData.f50289g) == null) ? null : uri.getQueryParameter(str));
                }
            }
        }
        return hashMap;
    }

    private String m() {
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        String a2 = d.a.a() != null ? net.one97.paytm.upgradeKyc.helper.d.a(this.f66436h) : null;
        CharSequence charSequence = a2;
        return charSequence == null || charSequence.length() == 0 ? "https://vkyc-staging.paytmbank.com" : a2;
    }

    public final void g() {
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66432d;
        if (dVar2 == null) {
            k.a("sharedViewModel");
        }
        Location location = dVar2.f66469a;
        if (location == null) {
            k.a();
        }
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66432d;
        if (dVar3 == null) {
            k.a("sharedViewModel");
        }
        String str = dVar3.f66474f;
        if (str == null) {
            k.a();
        }
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar4 = this.f66432d;
        if (dVar4 == null) {
            k.a("sharedViewModel");
        }
        int i2 = dVar4.f66473e;
        k.c(location, "location");
        k.c(str, "userPrefLanguage");
        if (k.a((Object) dVar.p, (Object) "user_ontime")) {
            dVar.v.a(dVar.o, location, str, 1, "appointment", dVar.j, dVar.k);
        } else if (dVar.f66473e == 1) {
            dVar.v.a(dVar.o, location, str, i2, "cst", dVar.j, dVar.k);
        } else {
            dVar.v.a(dVar.o, location, str, i2, "organic", dVar.j, dVar.k);
        }
    }

    public final void aF_() {
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        dVar.f66471c = 2;
    }

    public final void aG_() {
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        dVar.f66471c = 1;
    }

    public final void d() {
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(8);
    }

    private void a(boolean z, String str) {
        k.c(str, "appointmentType");
        String str2 = z ? "BUSY" : "NA";
        androidx.fragment.app.q a2 = getSupportFragmentManager().a().a(net.one97.paytm.upgradeKyc.videokyc.a.a.class.getName());
        int i2 = R.id.fl_container;
        a.C1331a aVar = net.one97.paytm.upgradeKyc.videokyc.a.a.f66343d;
        a2.a(i2, (Fragment) a.C1331a.a(str2, str)).c();
    }

    public final void h() {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        dVar.f66472d = true;
        g();
    }

    public final void i() {
        e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
        e.a.b().a((Activity) this);
    }

    public final void j() {
        b("user_came_early");
    }

    public final void k() {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a().a(net.one97.paytm.upgradeKyc.videokyc.a.d.class.getCanonicalName());
        int i2 = R.id.fl_container;
        d.a aVar = net.one97.paytm.upgradeKyc.videokyc.a.d.f66366b;
        a2.a(i2, (Fragment) new net.one97.paytm.upgradeKyc.videokyc.a.d()).c();
    }

    public final net.one97.paytm.upgradeKyc.videokyc.b.d l() {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        return dVar;
    }

    public final void onBackPressed() {
        if (getSupportFragmentManager().c(R.id.fl_container) instanceof g) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
            if (dVar == null) {
                k.a("sharedViewModel");
            }
            if (!dVar.f66472d) {
                return;
            }
        }
        super.onBackPressed();
    }

    private String b(DeepLinkData deepLinkData) {
        String str;
        if (deepLinkData != null) {
            try {
                if (deepLinkData.f50289g != null) {
                    Uri uri = deepLinkData.f50289g;
                    if (uri != null) {
                        str = uri.getQueryParameter("url");
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        Uri uri2 = deepLinkData.f50289g;
                        if (uri2 == null) {
                            k.a();
                        }
                        String queryParameter = uri2.getQueryParameter("url");
                        if (TextUtils.isEmpty(queryParameter)) {
                            return m();
                        }
                        if (queryParameter == null) {
                            k.a();
                        }
                        return queryParameter;
                    }
                }
            } catch (Exception unused) {
                return m();
            }
        }
        return m();
    }

    /* access modifiers changed from: private */
    public final void c(DeepLinkData deepLinkData) {
        if (deepLinkData != null && deepLinkData.f50289g != null) {
            String b2 = b(deepLinkData);
            HashMap<String, String> a2 = a(deepLinkData);
            System.out.println("vkycccc__queryMappp===".concat(String.valueOf(a2)));
            net.one97.paytm.kych5.b.a aVar = net.one97.paytm.kych5.b.a.f51045a;
            net.one97.paytm.kych5.b.a.a(this, a2, b2);
        }
    }

    public final void f() {
        try {
            d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            if (d.a.a() == null) {
                k.a();
            }
            List<String> a2 = p.a((CharSequence) net.one97.paytm.upgradeKyc.helper.d.a("videoChatTimings"), new String[]{"to"});
            String str = a2.get(0);
            if (str != null) {
                Date parse = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).parse(p.b(str).toString());
                Calendar instance = Calendar.getInstance();
                k.a((Object) instance, "calendar1");
                instance.setTime(parse);
                instance.add(5, 1);
                String str2 = a2.get(1);
                if (str2 != null) {
                    Date parse2 = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).parse(p.b(str2).toString());
                    Calendar instance2 = Calendar.getInstance();
                    k.a((Object) instance2, "calendar2");
                    instance2.setTime(parse2);
                    instance2.add(5, 1);
                    Date parse3 = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).parse(new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date()));
                    Calendar instance3 = Calendar.getInstance();
                    k.a((Object) instance3, "calendar3");
                    instance3.setTime(parse3);
                    instance3.add(5, 1);
                    Date time = instance3.getTime();
                    if (!time.after(instance.getTime()) || !time.before(instance2.getTime())) {
                        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66432d;
                        if (dVar == null) {
                            k.a("sharedViewModel");
                        }
                        a(false, dVar.p);
                        return;
                    }
                    j supportFragmentManager = getSupportFragmentManager();
                    h.a aVar2 = net.one97.paytm.upgradeKyc.videokyc.a.h.f66400a;
                    if (supportFragmentManager.c(net.one97.paytm.upgradeKyc.videokyc.a.h.f66401i) == null) {
                        h.a aVar3 = net.one97.paytm.upgradeKyc.videokyc.a.h.f66400a;
                        j supportFragmentManager2 = getSupportFragmentManager();
                        k.a((Object) supportFragmentManager2, "supportFragmentManager");
                        k.c(supportFragmentManager2, "supportFragmentManager");
                        new net.one97.paytm.upgradeKyc.videokyc.a.h().show(supportFragmentManager2, net.one97.paytm.upgradeKyc.videokyc.a.h.f66401i);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        } catch (Exception e2) {
            e2.printStackTrace();
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66432d;
            if (dVar2 == null) {
                k.a("sharedViewModel");
            }
            a(true, dVar2.p);
        }
    }

    public static final /* synthetic */ void a(VideoKycActivity videoKycActivity, int i2) {
        try {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar = videoKycActivity.f66432d;
            if (dVar == null) {
                k.a("sharedViewModel");
            }
            String str = null;
            if (dVar.f66473e == 1) {
                d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() != null) {
                    str = net.one97.paytm.upgradeKyc.helper.d.a("CSTPriorityVideoKYCAgentRange");
                }
            } else {
                d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                if (d.a.a() != null) {
                    str = net.one97.paytm.upgradeKyc.helper.d.a("VideoKYCAgentRange");
                }
            }
            if (str == null) {
                k.a();
            }
            List<String> a2 = p.a((CharSequence) str, new String[]{com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA});
            if (i2 >= Integer.parseInt(a2.get(0)) && i2 <= Integer.parseInt(a2.get(1))) {
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = videoKycActivity.f66432d;
                if (dVar2 == null) {
                    k.a("sharedViewModel");
                }
                if (k.a((Object) (String) dVar2.r.getValue(), (Object) "user_came_early")) {
                    net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = videoKycActivity.f66432d;
                    if (dVar3 == null) {
                        k.a("sharedViewModel");
                    }
                    dVar3.a(true);
                    return;
                }
                videoKycActivity.g();
            } else if (i2 <= Integer.parseInt(a2.get(1)) || i2 >= Integer.parseInt(a2.get(2))) {
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar4 = videoKycActivity.f66432d;
                if (dVar4 == null) {
                    k.a("sharedViewModel");
                }
                if (k.a((Object) (String) dVar4.r.getValue(), (Object) "user_came_early")) {
                    net.one97.paytm.upgradeKyc.videokyc.b.d dVar5 = videoKycActivity.f66432d;
                    if (dVar5 == null) {
                        k.a("sharedViewModel");
                    }
                    dVar5.a(false);
                    return;
                }
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar6 = videoKycActivity.f66432d;
                if (dVar6 == null) {
                    k.a("sharedViewModel");
                }
                videoKycActivity.a(true, dVar6.p);
            } else {
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar7 = videoKycActivity.f66432d;
                if (dVar7 == null) {
                    k.a("sharedViewModel");
                }
                if (k.a((Object) (String) dVar7.r.getValue(), (Object) "user_came_early")) {
                    net.one97.paytm.upgradeKyc.videokyc.b.d dVar8 = videoKycActivity.f66432d;
                    if (dVar8 == null) {
                        k.a("sharedViewModel");
                    }
                    dVar8.a(true);
                    return;
                }
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar9 = videoKycActivity.f66432d;
                if (dVar9 == null) {
                    k.a("sharedViewModel");
                }
                dVar9.f66472d = false;
                androidx.fragment.app.q a3 = videoKycActivity.getSupportFragmentManager().a();
                int i3 = R.id.fl_container;
                g.a aVar3 = g.f66391b;
                g gVar = new g();
                Bundle bundle = new Bundle();
                bundle.putInt("waitTimeInSec", i2);
                gVar.setArguments(bundle);
                a3.a(i3, (Fragment) gVar).a(g.class.getName()).c();
            }
        } catch (Exception unused) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar10 = videoKycActivity.f66432d;
            if (dVar10 == null) {
                k.a("sharedViewModel");
            }
            if (k.a((Object) (String) dVar10.r.getValue(), (Object) "user_came_early")) {
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar11 = videoKycActivity.f66432d;
                if (dVar11 == null) {
                    k.a("sharedViewModel");
                }
                dVar11.a(false);
                return;
            }
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar12 = videoKycActivity.f66432d;
            if (dVar12 == null) {
                k.a("sharedViewModel");
            }
            videoKycActivity.a(true, dVar12.p);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity r4, java.lang.String r5) {
        /*
            r0 = -1
            com.google.androidbrowserhelper.trusted.d r1 = new com.google.androidbrowserhelper.trusted.d     // Catch:{ ActivityNotFoundException -> 0x002b, Exception -> 0x0013 }
            r2 = r4
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ ActivityNotFoundException -> 0x002b, Exception -> 0x0013 }
            java.lang.String r3 = "com.android.chrome"
            r1.<init>(r2, r3)     // Catch:{ ActivityNotFoundException -> 0x002b, Exception -> 0x0013 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ ActivityNotFoundException -> 0x002b, Exception -> 0x0013 }
            r1.a((android.net.Uri) r5)     // Catch:{ ActivityNotFoundException -> 0x002b, Exception -> 0x0013 }
            return
        L_0x0013:
            int r5 = net.one97.paytm.upgradeKyc.R.id.video_kyc_parent
            android.view.View r5 = r4.a((int) r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r1 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r4 = r4.getString(r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.google.android.material.snackbar.Snackbar r4 = com.google.android.material.snackbar.Snackbar.a((android.view.View) r5, (java.lang.CharSequence) r4, (int) r0)
            r4.c()
            return
        L_0x002b:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = "android.intent.action.VIEW"
            java.lang.String r2 = "https://play.google.com/store/apps/details?id=com.android.chrome"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r2)     // Catch:{ Exception -> 0x003c }
            r4.startActivity(r5)     // Catch:{ Exception -> 0x003c }
            return
        L_0x003c:
            int r5 = net.one97.paytm.upgradeKyc.R.id.video_kyc_parent
            android.view.View r5 = r4.a((int) r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r1 = net.one97.paytm.upgradeKyc.R.string.some_went_wrong
            java.lang.String r4 = r4.getString(r1)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.google.android.material.snackbar.Snackbar r4 = com.google.android.material.snackbar.Snackbar.a((android.view.View) r5, (java.lang.CharSequence) r4, (int) r0)
            r4.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity.b(net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity, java.lang.String):void");
    }

    public static final /* synthetic */ void c(VideoKycActivity videoKycActivity) {
        androidx.fragment.app.q a2 = videoKycActivity.getSupportFragmentManager().a();
        int i2 = R.id.fl_container;
        c.a aVar = net.one97.paytm.upgradeKyc.videokyc.a.c.f66356c;
        a2.a(i2, (Fragment) new net.one97.paytm.upgradeKyc.videokyc.a.c()).c();
    }

    public static final /* synthetic */ void d(VideoKycActivity videoKycActivity) {
        androidx.fragment.app.q a2 = videoKycActivity.getSupportFragmentManager().a();
        int i2 = R.id.fl_container;
        d.a aVar = net.one97.paytm.upgradeKyc.videokyc.a.d.f66366b;
        a2.a(i2, (Fragment) new net.one97.paytm.upgradeKyc.videokyc.a.d()).c();
    }
}
