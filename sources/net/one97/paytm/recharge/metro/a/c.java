package net.one97.paytm.recharge.metro.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.f;
import net.one97.paytm.recharge.metro.f.b;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.metro.f.d;
import net.one97.paytm.upi.util.Events;

public class c extends androidx.viewpager.widget.a implements ViewPager.f, f.a, b.C1228b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f63148a;

    /* renamed from: b  reason: collision with root package name */
    protected String f63149b;

    /* renamed from: c  reason: collision with root package name */
    protected int f63150c;

    /* renamed from: d  reason: collision with root package name */
    protected View.OnClickListener f63151d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f63152e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63153f = false;

    /* renamed from: g  reason: collision with root package name */
    protected String f63154g;

    /* renamed from: h  reason: collision with root package name */
    private final String f63155h = TxNotifyData.UPI_STATUS_EXPIRED;

    /* renamed from: i  reason: collision with root package name */
    private CJRActiveMetroTicketModel f63156i;
    private List<CJRActiveMetroTicketQRItemModel> j;
    private f k;
    private boolean l;
    private ViewGroup m = null;

    public interface a {
        void a(View view, String str);

        void a(View view, CJRActiveMetroTicketModel cJRActiveMetroTicketModel);

        void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel);

        void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel, String str);
    }

    protected c() {
    }

    public c(Context context, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, String str, boolean z, String str2, boolean z2, View.OnClickListener onClickListener) {
        this.f63148a = context;
        this.f63149b = str;
        this.f63153f = z;
        this.f63151d = onClickListener;
        this.f63152e = z2;
        this.f63156i = cJRActiveMetroTicketModel;
        this.j = cJRActiveMetroTicketModel.getQrCodes();
        this.f63150c = net.one97.paytm.common.utility.a.a(AppConstants.READ_TIME_OUT, context);
        this.f63154g = str2;
    }

    public int getCount() {
        List<CJRActiveMetroTicketQRItemModel> list = this.j;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == ((NestedScrollView) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        this.m = viewGroup;
        return a(viewGroup, i2, this.f63156i, this.j.get(i2));
    }

    /* access modifiers changed from: protected */
    public final Object a(ViewGroup viewGroup, int i2, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel) {
        View view;
        int i3;
        int i4;
        final CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel2;
        final CJRActiveMetroTicketModel cJRActiveMetroTicketModel2;
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel3 = cJRActiveMetroTicketModel;
        CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel3 = cJRActiveMetroTicketQRItemModel;
        View inflate = LayoutInflater.from(this.f63148a).inflate(R.layout.metro_qrcode_details_fragment, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_metro_station);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.e_qr_image);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.layout_expired);
        TextView textView2 = (TextView) frameLayout.findViewById(R.id.tv_qr_expired);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_ticket_time);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_share_ticket);
        View findViewById = inflate.findViewById(R.id.view_before_share);
        View findViewById2 = inflate.findViewById(R.id.view_after_need_help);
        TextView textView5 = (TextView) inflate.findViewById(R.id.txt_trip_left);
        inflate.findViewById(R.id.penaltyText);
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_need_help);
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_view_ticket_details);
        String balanceAmount = cJRActiveMetroTicketModel.getBalanceAmount();
        if (TextUtils.isEmpty(balanceAmount)) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            balanceAmount = c.a.b(cJRActiveMetroTicketModel);
        }
        c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
        textView.setText(c.a.a(this.f63148a, TextUtils.isEmpty(cJRActiveMetroTicketModel.getSubType()) ? cJRActiveMetroTicketModel.getProductType() : cJRActiveMetroTicketModel.getSubType(), cJRActiveMetroTicketModel.getSource(), cJRActiveMetroTicketModel.getDestination(), balanceAmount, true));
        textView3.setText(cJRActiveMetroTicketQRItemModel.getExpiry());
        textView6.setText(this.f63148a.getString(R.string.metro_mumbai_help));
        if ((!TextUtils.isEmpty(this.f63154g) && this.f63154g.equalsIgnoreCase("Delhi Metro")) || TxNotifyData.UPI_STATUS_EXPIRED.equalsIgnoreCase(cJRActiveMetroTicketQRItemModel.getStatus())) {
            textView4.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if (c.e.TRIP_PASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.e.TP.getValue().equals(cJRActiveMetroTicketModel.getProductType()) || c.e.TRIP_PASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_10.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_30.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_45.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_10.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_30.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_45.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.e.TP.getValue().equals(cJRActiveMetroTicketModel.getSubType())) {
            c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
            if (net.one97.paytm.recharge.metro.f.c.l) {
                c.a aVar4 = net.one97.paytm.recharge.metro.f.c.f63576a;
                cJRActiveMetroTicketModel3.setBalanceTrip_2(c.a.c(cJRActiveMetroTicketModel).intValue());
            }
            view = inflate;
            i3 = 0;
            textView5.setText(this.f63148a.getString(R.string.metro_qr_trip_left, new Object[]{Integer.valueOf(cJRActiveMetroTicketModel.getBalanceTrip_2())}));
            textView5.setVisibility(0);
        } else {
            view = inflate;
            i3 = 0;
        }
        if ("PENALTY".equalsIgnoreCase(cJRActiveMetroTicketModel.getType()) || cJRActiveMetroTicketQRItemModel.isPenaltyTicket()) {
            i4 = 8;
            textView6.setVisibility(8);
            findViewById2.setVisibility(8);
        } else {
            textView6.setVisibility(i3);
            findViewById2.setVisibility(i3);
            i4 = 8;
        }
        if (TextUtils.isEmpty(balanceAmount)) {
            balanceAmount = "0";
        }
        final String str = balanceAmount;
        c.a aVar5 = net.one97.paytm.recharge.metro.f.c.f63576a;
        if (net.one97.paytm.recharge.metro.f.c.l) {
            textView6.setVisibility(i4);
            findViewById2.setVisibility(i4);
            textView4.setVisibility(i4);
            findViewById.setVisibility(i4);
        }
        if (c.e.SVP.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.e.STORE_VALUE.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.e.TP.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.e.TRIP_PASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_10.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_30.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS_45.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) || c.b.TRIPPASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_10.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_30.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.b.TRIPPASS_45.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.e.SVP.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.e.STORE_VALUE.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.e.TP.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType()) || c.e.TRIP_PASS.getValue().equalsIgnoreCase(cJRActiveMetroTicketModel.getSubType())) {
            textView4.setVisibility(8);
            findViewById.setVisibility(8);
            textView7.setText(R.string.metro_mumbai_view_pass_details);
        }
        String status = cJRActiveMetroTicketQRItemModel.getStatus();
        char c2 = 65535;
        int hashCode = status.hashCode();
        if (hashCode != -591252731) {
            if (hashCode == 1925346054 && status.equals("ACTIVE")) {
                c2 = 0;
            }
        } else if (status.equals(TxNotifyData.UPI_STATUS_EXPIRED)) {
            c2 = 1;
        }
        if (c2 == 0) {
            frameLayout.setVisibility(8);
        } else if (c2 != 1) {
            frameLayout.setVisibility(0);
            textView2.setText(R.string.metro_mumbai_btn_new_qr);
        } else {
            frameLayout.setVisibility(0);
            textView6.setVisibility(8);
            findViewById2.setVisibility(8);
            textView2.setText(R.string.metro_mumbai_btn_expired);
        }
        try {
            imageView.setImageBitmap(com.google.zxing.client.android.d.a.a(cJRActiveMetroTicketQRItemModel.getQrCode(), net.one97.paytm.common.utility.a.a(235, this.f63148a), net.one97.paytm.common.utility.a.a(243, this.f63148a), false));
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
        if (textView6.getVisibility() == 0) {
            final int i5 = i2;
            cJRActiveMetroTicketModel2 = cJRActiveMetroTicketModel;
            cJRActiveMetroTicketQRItemModel2 = cJRActiveMetroTicketQRItemModel;
            textView6.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!d.INSTANCE.validateIsAlreadyClicked(this)) {
                        if (c.this.f63151d instanceof a) {
                            c.a(c.this, i5, cJRActiveMetroTicketModel2, cJRActiveMetroTicketQRItemModel2);
                        }
                        if (TextUtils.isEmpty(c.this.f63149b)) {
                            return;
                        }
                        if (c.this.f63149b.equalsIgnoreCase("Metro QR Ticket")) {
                            c.this.a("/mumbai-metro/qr", "mumbai_metro_qr", Events.Action.NEED_HELP_CLICKED);
                        } else if (c.this.f63149b.equalsIgnoreCase("Trip Pass")) {
                            c.this.a("/mumbai-metro/tp", "mumbai_metro_tp", Events.Action.NEED_HELP_CLICKED);
                        } else if (c.this.f63149b.equalsIgnoreCase("Store Value Pass")) {
                            c.this.a("/mumbai-metro/svp", "mumbai_metro_svp", Events.Action.NEED_HELP_CLICKED);
                        }
                    }
                }
            });
        } else {
            cJRActiveMetroTicketModel2 = cJRActiveMetroTicketModel;
            cJRActiveMetroTicketQRItemModel2 = cJRActiveMetroTicketQRItemModel;
        }
        if (textView7.getVisibility() == 0) {
            textView7.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!d.INSTANCE.validateIsAlreadyClicked(this) && (c.this.f63151d instanceof a)) {
                        ((a) c.this.f63151d).a(cJRActiveMetroTicketModel2, cJRActiveMetroTicketQRItemModel2, str);
                    }
                }
            });
        }
        if (textView4.getVisibility() == 0) {
            textView4.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!d.INSTANCE.validateIsAlreadyClicked(this) && (c.this.f63151d instanceof a)) {
                        ((a) c.this.f63151d).a(view, "message");
                    }
                }
            });
        }
        View view2 = view;
        viewGroup.addView(view2);
        return view2;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view, int i2, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, b.C1228b bVar) {
        b bVar2 = new b(context, bVar);
        bVar2.f63572a = view;
        bVar2.a(cJRActiveMetroTicketModel);
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((NestedScrollView) obj);
    }

    public void transformPage(View view, float f2) {
        ViewPager viewPager = (ViewPager) view.getParent();
        float left = (((float) (((view.getLeft() - viewPager.getScrollX()) + (view.getMeasuredWidth() / 2)) - (viewPager.getMeasuredWidth() / 2))) * 0.1f) / ((float) viewPager.getMeasuredWidth());
        float abs = 1.0f - Math.abs(left);
        if (abs > 0.0f) {
            view.setScaleX(abs);
            view.setScaleY(abs);
            view.setTranslationX(((float) (-this.f63150c)) * left);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        View.OnClickListener onClickListener = this.f63151d;
        if (onClickListener instanceof a) {
            ((a) onClickListener).a(this.f63156i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r3 != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r2, boolean r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0028
            boolean r2 = r1.f63153f
            if (r2 != 0) goto L_0x0020
            net.one97.paytm.recharge.metro.f.c$a r2 = net.one97.paytm.recharge.metro.f.c.f63576a
            boolean r2 = net.one97.paytm.recharge.metro.f.c.l
            if (r2 != 0) goto L_0x0019
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r2 = net.one97.paytm.recharge.di.helper.c.ae()
            if (r2 == 0) goto L_0x0019
            if (r3 == 0) goto L_0x0019
            goto L_0x0020
        L_0x0019:
            net.one97.paytm.recharge.metro.c.f r2 = r1.k
            r3 = 0
            r2.a(r3)
            goto L_0x0028
        L_0x0020:
            net.one97.paytm.recharge.metro.c.f r2 = r1.k
            r0 = 1
            r2.a(r0)
            r1.l = r3
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.a.c.a(android.view.View, boolean):void");
    }

    public CharSequence getPageTitle(int i2) {
        return this.f63148a.getString(R.string.metro_passengers, new Object[]{Integer.valueOf(i2 + 1)});
    }

    public final void a(View view, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        View.OnClickListener onClickListener = this.f63151d;
        if (onClickListener instanceof a) {
            ((a) onClickListener).a(view, cJRActiveMetroTicketModel);
        }
    }

    public final void b(int i2) {
        this.k.dismiss();
        a(i2);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f63149b)) {
            return;
        }
        if (this.f63149b.equalsIgnoreCase("Metro QR Ticket")) {
            a("/mumbai-metro/qr", "mumbai_metro_qr", "need_help_closed");
        } else if (this.f63149b.equalsIgnoreCase("Trip Pass")) {
            a("/mumbai-metro/tp", "mumbai_metro_tp", "need_help_closed");
        } else if (this.f63149b.equalsIgnoreCase("Store Value Pass")) {
            a("/mumbai-metro/svp", "mumbai_metro_svp", "need_help_closed");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str2, str3, str) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return c.this.b(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
        hashMap.put("vertical_name", "recharges_utilities");
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, this.f63148a);
        return null;
    }

    static /* synthetic */ void a(c cVar, int i2, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("show_Cancel_option_Metro", !TxNotifyData.UPI_STATUS_EXPIRED.equalsIgnoreCase(cJRActiveMetroTicketQRItemModel.getStatus()) && !cVar.f63153f);
        bundle.putString(StringSet.operator, cVar.f63149b);
        bundle.putString("metroTicketVariant", cVar.f63154g);
        bundle.putInt("extra_intent_item_position", i2);
        bundle.putSerializable("extra.ticket", cJRActiveMetroTicketModel);
        bundle.putSerializable("extra.qr.code", cJRActiveMetroTicketQRItemModel);
        bundle.putBoolean("is_cancellable", cVar.f63152e);
        if (cVar.k == null) {
            cVar.k = new f();
        }
        cVar.k.setArguments(bundle);
        f fVar = cVar.k;
        fVar.f63327c = cVar;
        cVar.a(cVar.f63148a, fVar.f63325a, i2, cJRActiveMetroTicketModel, cVar);
        cVar.k.show(((AppCompatActivity) cVar.f63148a).getSupportFragmentManager(), f.class.getSimpleName());
    }
}
