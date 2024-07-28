package net.one97.paytm.upi.mandate.update;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.e.n;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.update.d;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.v;
import net.one97.paytm.upi.mandate.utils.w;
import net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity;
import net.one97.paytm.upi.mandate.view.model.CreateMandateUiModel;
import net.one97.paytm.upi.mandate.view.model.UpdateInfo;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class b extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67346a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private v f67347b;

    /* renamed from: c  reason: collision with root package name */
    private MandateItem f67348c;

    /* renamed from: d  reason: collision with root package name */
    private d f67349d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f67350e;

    public final void b() {
        HashMap hashMap = this.f67350e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    /* renamed from: net.one97.paytm.upi.mandate.update.b$b  reason: collision with other inner class name */
    static final class C1371b<T> implements z<r<MandateDefaultResponseModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67351a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f67352b;

        C1371b(b bVar, n nVar) {
            this.f67351a = bVar;
            this.f67352b = nVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            int i2 = c.f67365a[rVar.f67411a.ordinal()];
            if (i2 == 1) {
                b.a(true, this.f67352b);
            } else if (i2 == 2) {
                b bVar = this.f67351a;
                T t = rVar.f67412b;
                if (t == null) {
                    k.a();
                }
                b.a(bVar, (MandateDefaultResponseModel) t, this.f67352b);
            } else if (i2 == 3) {
                b bVar2 = this.f67351a;
                t tVar = rVar.f67413c;
                if (tVar == null) {
                    k.a();
                }
                b.a(bVar2, tVar, this.f67352b);
            }
        }
    }

    public static final /* synthetic */ d b(b bVar) {
        d dVar = bVar.f67349d;
        if (dVar == null) {
            k.a("updateMandateViewModel");
        }
        return dVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("mandate_item");
        if (serializable != null) {
            this.f67348c = (MandateItem) serializable;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            Serializable serializable2 = arguments2.getSerializable("update_type");
            if (serializable2 != null) {
                this.f67347b = (v) serializable2;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.utils.UpdateType");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
    }

    public final int a() {
        return R.layout.bottom_sheet_update_mandate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0274  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r17, android.os.Bundle r18) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = "view"
            r2 = r17
            kotlin.g.b.k.c(r2, r1)
            super.onViewCreated(r17, r18)
            net.one97.paytm.upi.e.n r1 = net.one97.paytm.upi.e.n.a(r17)
            java.lang.String r2 = "BottomSheetUpdateMandateBinding.bind(view)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = r0
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            net.one97.paytm.upi.mandate.utils.o r3 = new net.one97.paytm.upi.mandate.utils.o
            r3.<init>()
            androidx.lifecycle.al$b r3 = (androidx.lifecycle.al.b) r3
            androidx.lifecycle.al r2 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r2, (androidx.lifecycle.al.b) r3)
            java.lang.Class<net.one97.paytm.upi.mandate.update.d> r3 = net.one97.paytm.upi.mandate.update.d.class
            androidx.lifecycle.ai r2 = r2.a(r3)
            java.lang.String r3 = "ViewModelProviders.of(fr…, factory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.upi.mandate.update.d r2 = (net.one97.paytm.upi.mandate.update.d) r2
            r0.f67349d = r2
            net.one97.paytm.upi.mandate.update.d r2 = r0.f67349d
            java.lang.String r3 = "updateMandateViewModel"
            if (r2 != 0) goto L_0x003b
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x003b:
            net.one97.paytm.upi.mandate.utils.v r4 = r0.f67347b
            java.lang.String r5 = "updateType"
            if (r4 != 0) goto L_0x0044
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0044:
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r0.f67348c
            java.lang.String r7 = "mandateItem"
            if (r6 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x004d:
            kotlin.g.b.k.c(r4, r5)
            kotlin.g.b.k.c(r6, r7)
            r2.f67369a = r6
            r2.f67375g = r4
            java.lang.String r4 = r6.getAmount()
            java.lang.String r8 = ""
            if (r4 != 0) goto L_0x0060
            r4 = r8
        L_0x0060:
            r2.f67374f = r4
            java.lang.String r4 = r6.getValidityEndDate()
            r2.f67371c = r4
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r6 = "ddMMyyyy"
            r4.<init>(r6)
            java.util.Date r9 = new java.util.Date
            r9.<init>()
            long r9 = r9.getTime()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r4 = r4.format(r9)
            r2.f67372d = r4
            net.one97.paytm.upi.mandate.update.d r2 = r0.f67349d
            if (r2 != 0) goto L_0x0089
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0089:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.utils.r<net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel>> r2 = r2.f67370b
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            androidx.lifecycle.q r4 = r16.getViewLifecycleOwner()
            net.one97.paytm.upi.mandate.update.b$b r9 = new net.one97.paytm.upi.mandate.update.b$b
            r9.<init>(r0, r1)
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r2.observe(r4, r9)
            android.widget.TextView r2 = r1.y
            java.lang.String r4 = "tvImportantLabel"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r4 = net.one97.paytm.upi.R.drawable.upi_ic_important
            net.one97.paytm.upi.f.a((android.widget.TextView) r2, (int) r4)
            android.widget.TextView r2 = r1.r
            java.lang.String r4 = "payeeName"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r0.f67348c
            if (r4 != 0) goto L_0x00b5
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00b5:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r4 = r4.getPayee()
            java.lang.String r4 = r4.getUserName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            android.widget.TextView r2 = r1.s
            java.lang.String r4 = "payeeVpa"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            int r4 = net.one97.paytm.upi.R.string.money_transfer_upi_without_bold
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            net.one97.paytm.upi.mandate.data.model.MandateItem r11 = r0.f67348c
            if (r11 != 0) goto L_0x00d5
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00d5:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r11 = r11.getPayee()
            java.lang.String r11 = r11.getVpa()
            r12 = 0
            r10[r12] = r11
            java.lang.String r4 = r0.getString(r4, r10)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            android.widget.TextView r2 = r1.A
            java.lang.String r4 = "validityText"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.upi.mandate.data.model.MandateItem r4 = r0.f67348c
            if (r4 != 0) goto L_0x00f7
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00f7:
            java.lang.String r4 = r4.getType()
            java.lang.String r10 = "RECURRING"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r10)
            java.lang.String r10 = "dd MMM yyyy"
            r11 = 2
            if (r4 == 0) goto L_0x017a
            int r4 = net.one97.paytm.upi.R.string.upi_recurring_payment_till
            java.lang.Object[] r13 = new java.lang.Object[r11]
            net.one97.paytm.upi.mandate.d.a r14 = net.one97.paytm.upi.mandate.d.a.f67112a
            android.content.Context r14 = r16.getContext()
            if (r14 != 0) goto L_0x0115
            kotlin.g.b.k.a()
        L_0x0115:
            java.lang.String r15 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            net.one97.paytm.upi.mandate.data.model.MandateItem r15 = r0.f67348c
            if (r15 != 0) goto L_0x0121
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0121:
            java.lang.String r15 = r15.getRecurrenceRule()
            if (r15 != 0) goto L_0x012a
            kotlin.g.b.k.a()
        L_0x012a:
            net.one97.paytm.upi.mandate.data.model.MandateItem r11 = r0.f67348c
            if (r11 != 0) goto L_0x0131
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0131:
            java.lang.String r11 = r11.getRecurrence()
            if (r11 != 0) goto L_0x013a
            kotlin.g.b.k.a()
        L_0x013a:
            net.one97.paytm.upi.mandate.data.model.MandateItem r9 = r0.f67348c
            if (r9 != 0) goto L_0x0141
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0141:
            java.lang.String r9 = r9.getRecurrenceType()
            if (r9 != 0) goto L_0x014a
            kotlin.g.b.k.a()
        L_0x014a:
            net.one97.paytm.upi.mandate.data.model.MandateItem r12 = r0.f67348c
            if (r12 != 0) goto L_0x0151
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0151:
            java.lang.String r12 = r12.getValidityStartDate()
            if (r12 != 0) goto L_0x015a
            kotlin.g.b.k.a()
        L_0x015a:
            java.lang.String r9 = net.one97.paytm.upi.mandate.d.a.a(r14, r15, r11, r9, r12)
            r11 = 0
            r13[r11] = r9
            net.one97.paytm.upi.mandate.data.model.MandateItem r9 = r0.f67348c
            if (r9 != 0) goto L_0x0168
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0168:
            java.lang.String r9 = r9.getValidityEndDate()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiUtils.convertDateFromTo(r6, r10, r9)
            r9 = 1
            r13[r9] = r6
            java.lang.String r4 = r0.getString(r4, r13)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            goto L_0x01a9
        L_0x017a:
            int r4 = net.one97.paytm.upi.R.string.mandate_starting_up_to_end
            r9 = 2
            java.lang.Object[] r11 = new java.lang.Object[r9]
            net.one97.paytm.upi.mandate.data.model.MandateItem r9 = r0.f67348c
            if (r9 != 0) goto L_0x0186
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0186:
            java.lang.String r9 = r9.getValidityStartDate()
            java.lang.String r9 = net.one97.paytm.upi.util.UpiUtils.convertDateFromTo(r6, r10, r9)
            r12 = 0
            r11[r12] = r9
            net.one97.paytm.upi.mandate.data.model.MandateItem r9 = r0.f67348c
            if (r9 != 0) goto L_0x0198
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0198:
            java.lang.String r9 = r9.getValidityEndDate()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiUtils.convertDateFromTo(r6, r10, r9)
            r9 = 1
            r11[r9] = r6
            java.lang.String r4 = r0.getString(r4, r11)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x01a9:
            r2.setText(r4)
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r0.f67348c
            if (r2 != 0) goto L_0x01b3
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x01b3:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r2 = r2.getImageUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x01c8
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x01c6
            goto L_0x01c8
        L_0x01c6:
            r2 = 0
            goto L_0x01c9
        L_0x01c8:
            r2 = 1
        L_0x01c9:
            java.lang.String r4 = "nameInitials"
            if (r2 != 0) goto L_0x0202
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r0.f67348c
            if (r2 != 0) goto L_0x01d4
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x01d4:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r2 = r2.getImageUrl()
            boolean r2 = android.webkit.URLUtil.isValidUrl(r2)
            if (r2 != 0) goto L_0x01e3
            goto L_0x0202
        L_0x01e3:
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r0.f67348c
            if (r6 != 0) goto L_0x01ee
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x01ee:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r6 = r6.getPayee()
            java.lang.String r6 = r6.getImageUrl()
            com.squareup.picasso.aa r2 = r2.a((java.lang.String) r6)
            net.one97.paytm.upi.util.CircularImageView r6 = r1.m
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r2.a((android.widget.ImageView) r6)
            goto L_0x0236
        L_0x0202:
            net.one97.paytm.upi.util.CircularImageView r2 = r1.m
            int r6 = net.one97.paytm.upi.R.color.paytm_blue
            r2.setImageResource(r6)
            android.widget.TextView r2 = r1.p
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r0.f67348c
            if (r6 != 0) goto L_0x0215
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0215:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r6 = r6.getPayee()
            java.lang.String r6 = r6.getUserName()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiUtils.getNameInitials(r6)
            java.lang.String r9 = "UpiUtils.getNameInitials…ndateItem.payee.userName)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            if (r6 == 0) goto L_0x04c8
            java.lang.String r6 = r6.toUpperCase()
            java.lang.String r9 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x0236:
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f66854a
            net.one97.paytm.upi.mandate.data.model.MandateItem r6 = r0.f67348c
            if (r6 != 0) goto L_0x023f
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x023f:
            java.lang.String r6 = r6.getAmount()
            java.lang.String r6 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f66854a
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r6 = r1.f66854a
            java.lang.String r9 = "amountEditText"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            android.text.Editable r6 = r6.getText()
            if (r6 == 0) goto L_0x0260
            int r12 = r6.length()
            goto L_0x0261
        L_0x0260:
            r12 = 0
        L_0x0261:
            r2.setSelection(r12)
            android.widget.TextView r2 = r1.f66855b
            java.lang.String r6 = "amountInWords"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            int r6 = net.one97.paytm.upi.R.string.mt_amount_in_words_placeholder
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]
            net.one97.paytm.upi.mandate.data.model.MandateItem r10 = r0.f67348c
            if (r10 != 0) goto L_0x0277
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0277:
            java.lang.String r10 = r10.getAmount()
            java.lang.String r10 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r10)
            r12 = 0
            r11[r12] = r10
            java.lang.String r6 = r0.getString(r6, r11)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            android.widget.ImageView r2 = r1.f66860g
            net.one97.paytm.upi.mandate.update.b$e r6 = new net.one97.paytm.upi.mandate.update.b$e
            r6.<init>(r0, r1)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
            android.widget.TextView r2 = r1.t
            net.one97.paytm.upi.mandate.update.b$f r6 = new net.one97.paytm.upi.mandate.update.b$f
            r6.<init>(r1, r0, r1)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
            android.widget.TextView r2 = r1.f66862i
            net.one97.paytm.upi.mandate.update.b$g r6 = new net.one97.paytm.upi.mandate.update.b$g
            r6.<init>(r0, r1)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r2.setOnClickListener(r6)
            net.one97.paytm.upi.mandate.utils.v r2 = r0.f67347b
            if (r2 != 0) goto L_0x02b6
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x02b6:
            int[] r5 = net.one97.paytm.upi.mandate.update.c.f67366b
            int r2 = r2.ordinal()
            r2 = r5[r2]
            java.lang.String r5 = "updatePaymentTitle"
            java.lang.String r6 = "dd MMM''yy"
            r10 = 1
            if (r2 == r10) goto L_0x044a
            java.lang.String r11 = "binding.importantMessage"
            java.lang.String r13 = "binding.updatePaymentTitle"
            r14 = 2
            if (r2 == r14) goto L_0x0426
            r14 = 3
            if (r2 == r14) goto L_0x0401
            r14 = 4
            if (r2 == r14) goto L_0x02d4
            goto L_0x04b6
        L_0x02d4:
            android.widget.TextView r2 = r1.z
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            int r13 = net.one97.paytm.upi.R.string.update_scheduled_payment
            java.lang.String r13 = r0.getString(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r2.setText(r13)
            android.widget.TextView r2 = r1.l
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            int r11 = net.one97.paytm.upi.R.string.mandate_important_note
            java.lang.String r11 = r0.getString(r11)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2.setText(r11)
            androidx.constraintlayout.widget.Group r2 = r1.q
            java.lang.String r11 = "pauseGroup"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            android.widget.TextView r2 = r1.z
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            int r5 = net.one97.paytm.upi.R.string.update_scheduled_payment
            java.lang.String r5 = r0.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            android.widget.TextView r2 = r1.v
            java.lang.String r5 = "startDate"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.upi.mandate.update.d r5 = r0.f67349d
            if (r5 != 0) goto L_0x031e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x031e:
            net.one97.paytm.upi.mandate.data.model.MandateItem r5 = r0.f67348c
            if (r5 != 0) goto L_0x0325
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0325:
            java.lang.String r5 = r5.getValidityStartDate()
            if (r5 != 0) goto L_0x032c
            r5 = r8
        L_0x032c:
            java.lang.String r5 = net.one97.paytm.upi.mandate.update.d.a((java.lang.String) r6, (java.lang.String) r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            android.widget.TextView r2 = r1.f66862i
            java.lang.String r5 = "endDate"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.upi.mandate.update.d r5 = r0.f67349d
            if (r5 != 0) goto L_0x0343
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0343:
            net.one97.paytm.upi.mandate.data.model.MandateItem r3 = r0.f67348c
            if (r3 != 0) goto L_0x034a
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x034a:
            java.lang.String r3 = r3.getValidityEndDate()
            if (r3 != 0) goto L_0x0351
            r3 = r8
        L_0x0351:
            java.lang.String r3 = net.one97.paytm.upi.mandate.update.d.a((java.lang.String) r6, (java.lang.String) r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.l
            java.lang.String r3 = "importantMessage"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.upi.R.string.mandate_important_note
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.w
            java.lang.String r3 = "startDatePlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.upi.R.string.start_date_of_payment
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.j
            java.lang.String r3 = "endDatePlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.upi.R.string.end_date_of_payment
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            net.one97.paytm.upi.mandate.data.model.MandateItem r2 = r0.f67348c
            if (r2 != 0) goto L_0x0397
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0397:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r2 = r2.getPayee()
            java.lang.String r2 = r2.getImageUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x03ab
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x03aa
            goto L_0x03ab
        L_0x03aa:
            r10 = 0
        L_0x03ab:
            if (r10 == 0) goto L_0x03d7
            net.one97.paytm.upi.util.CircularImageView r2 = r1.m
            int r3 = net.one97.paytm.upi.R.color.paytm_blue
            r2.setImageResource(r3)
            android.widget.TextView r2 = r1.p
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.upi.mandate.data.model.MandateItem r3 = r0.f67348c
            if (r3 != 0) goto L_0x03c0
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03c0:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r3 = r3.getPayee()
            java.lang.String r3 = r3.getUserName()
            java.lang.String r3 = net.one97.paytm.upi.f.a((java.lang.String) r3)
            java.lang.String r3 = net.one97.paytm.upi.util.UpiUtils.getNameInitials(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x04b6
        L_0x03d7:
            android.widget.TextView r2 = r1.p
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.mandate.data.model.MandateItem r3 = r0.f67348c
            if (r3 != 0) goto L_0x03ec
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x03ec:
            net.one97.paytm.upi.mandate.data.model.MandatePayee r3 = r3.getPayee()
            java.lang.String r3 = r3.getImageUrl()
            com.squareup.picasso.aa r2 = r2.a((java.lang.String) r3)
            net.one97.paytm.upi.util.CircularImageView r3 = r1.m
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r2.a((android.widget.ImageView) r3)
            goto L_0x04b6
        L_0x0401:
            b((net.one97.paytm.upi.e.n) r1)
            android.widget.TextView r2 = r1.z
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            int r3 = net.one97.paytm.upi.R.string.cancel_scheduled_payment
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.l
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            int r3 = net.one97.paytm.upi.R.string.mandate_cancel_imp_message
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x04b6
        L_0x0426:
            b((net.one97.paytm.upi.e.n) r1)
            android.widget.TextView r2 = r1.z
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            int r3 = net.one97.paytm.upi.R.string.resume_scheduled_payment
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.l
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            int r3 = net.one97.paytm.upi.R.string.mandate_resume_imp_message
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            goto L_0x04b6
        L_0x044a:
            b((net.one97.paytm.upi.e.n) r1)
            android.widget.TextView r2 = r1.z
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            int r4 = net.one97.paytm.upi.R.string.pause_scheduled_payment
            java.lang.String r4 = r0.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            androidx.constraintlayout.widget.Group r2 = r1.q
            java.lang.String r4 = "pauseGroup"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.upi.f.b((android.view.View) r2)
            android.widget.TextView r2 = r1.v
            java.lang.String r4 = "startDate"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.upi.mandate.update.d r4 = r0.f67349d
            if (r4 != 0) goto L_0x0477
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0477:
            java.lang.String r3 = r4.f67372d
            if (r3 != 0) goto L_0x047e
            kotlin.g.b.k.a()
        L_0x047e:
            java.lang.String r3 = net.one97.paytm.upi.mandate.update.d.a((java.lang.String) r6, (java.lang.String) r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.f66862i
            java.lang.String r3 = "endDate"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.upi.R.string.select_date
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r1.f66862i
            java.lang.String r3 = "#8ba6c1"
            int r3 = net.one97.paytm.upi.f.c((java.lang.String) r3)
            r2.setTextColor(r3)
            android.widget.TextView r2 = r1.l
            java.lang.String r3 = "importantMessage"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.upi.R.string.mandate_pause_imp_message
            java.lang.String r3 = r0.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x04b6:
            net.one97.paytm.upi.common.CustomAmountTextInputEditText r2 = r1.f66854a
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            android.widget.TextView r2 = (android.widget.TextView) r2
            net.one97.paytm.upi.mandate.update.b$d r3 = new net.one97.paytm.upi.mandate.update.b$d
            r3.<init>(r1, r0, r1)
            android.text.TextWatcher r3 = (android.text.TextWatcher) r3
            r2.addTextChangedListener(r3)
            return
        L_0x04c8:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.update.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    private static void b(n nVar) {
        View view = nVar.f66856c;
        k.a((Object) view, "amountUnderLine");
        net.one97.paytm.upi.f.a(view);
        CustomAmountTextInputEditText customAmountTextInputEditText = nVar.f66854a;
        k.a((Object) customAmountTextInputEditText, "amountEditText");
        customAmountTextInputEditText.setClickable(false);
        CustomAmountTextInputEditText customAmountTextInputEditText2 = nVar.f66854a;
        k.a((Object) customAmountTextInputEditText2, "amountEditText");
        customAmountTextInputEditText2.setFocusable(false);
        CustomAmountTextInputEditText customAmountTextInputEditText3 = nVar.f66854a;
        k.a((Object) customAmountTextInputEditText3, "amountEditText");
        customAmountTextInputEditText3.setFocusableInTouchMode(false);
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f67355a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f67356b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f67357c;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public d(n nVar, b bVar, n nVar2) {
            this.f67355a = nVar;
            this.f67356b = bVar;
            this.f67357c = nVar2;
        }

        public final void afterTextChanged(Editable editable) {
            CharSequence charSequence = editable;
            if (charSequence == null || p.a(charSequence)) {
                TextView textView = this.f67355a.f66855b;
                k.a((Object) textView, "amountInWords");
                textView.setText("");
                return;
            }
            TextView textView2 = this.f67355a.f66855b;
            k.a((Object) textView2, "amountInWords");
            b bVar = this.f67356b;
            int i2 = R.string.mt_amount_in_words_placeholder;
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f67357c.f66854a;
            k.a((Object) customAmountTextInputEditText, "binding.amountEditText");
            textView2.setText(bVar.getString(i2, EnglishNumberToWords.convert(customAmountTextInputEditText.getCleanString())));
            this.f67355a.f66855b.setTextColor(net.one97.paytm.upi.f.c("#8ba6c1"));
            this.f67355a.f66856c.setBackgroundColor(net.one97.paytm.upi.f.c("#dde5ed"));
        }
    }

    /* access modifiers changed from: private */
    public static void a(boolean z, n nVar) {
        TextView textView = nVar.t;
        k.a((Object) textView, "binding.proceedButton");
        net.one97.paytm.upi.f.a((View) textView, !z);
        FrameLayout frameLayout = nVar.o;
        k.a((Object) frameLayout, "binding.lottieRootLayout");
        net.one97.paytm.upi.f.a((View) frameLayout, z);
        if (z) {
            AnimationFactory.startWalletLoader(nVar.n);
        } else {
            AnimationFactory.stopWalletLoader(nVar.n);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67358a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f67359b;

        e(b bVar, n nVar) {
            this.f67358a = bVar;
            this.f67359b = nVar;
        }

        public final void onClick(View view) {
            this.f67358a.dismiss();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f67360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f67361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f67362c;

        f(n nVar, b bVar, n nVar2) {
            this.f67360a = nVar;
            this.f67361b = bVar;
            this.f67362c = nVar2;
        }

        public final void onClick(View view) {
            b.a(this.f67361b);
            d b2 = b.b(this.f67361b);
            CustomAmountTextInputEditText customAmountTextInputEditText = this.f67360a.f66854a;
            k.a((Object) customAmountTextInputEditText, "amountEditText");
            String cleanString = customAmountTextInputEditText.getCleanString();
            k.a((Object) cleanString, "amountEditText.cleanString");
            k.c(cleanString, "updatedAmount");
            if (cleanString.length() == 0) {
                v vVar = b2.f67375g;
                if (vVar == null) {
                    k.a("updateType");
                }
                if (vVar == v.UPDATE) {
                    b2.f67370b.setValue(new r(net.one97.paytm.upi.mandate.utils.u.ERROR, (Object) null, new t.b(new w.a("")), false, 10));
                    return;
                }
            }
            if (b2.f67373e == null) {
                v vVar2 = b2.f67375g;
                if (vVar2 == null) {
                    k.a("updateType");
                }
                if (vVar2 == v.PAUSE) {
                    b2.f67370b.setValue(new r(net.one97.paytm.upi.mandate.utils.u.ERROR, (Object) null, new t.b(new w.b("")), false, 10));
                    return;
                }
            }
            b2.f67374f = cleanString;
            MandateItem mandateItem = b2.f67369a;
            if (mandateItem == null) {
                k.a("mandateItem");
            }
            String bankAccount = mandateItem.getPayer().getBankAccount();
            if (bankAccount == null) {
                k.a();
            }
            k.c(bankAccount, "bankAccount");
            b2.f67370b.setValue(new r(net.one97.paytm.upi.mandate.utils.u.LOADING, (Object) null, (t) null, false, 14));
            b2.j.a(new d.a(b2, bankAccount), "", "");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67363a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f67364b;

        g(b bVar, n nVar) {
            this.f67363a = bVar;
            this.f67364b = nVar;
        }

        public final void onClick(View view) {
            b.a(this.f67363a, this.f67364b);
        }
    }

    static final class c implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f67353a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f67354b;

        c(b bVar, n nVar) {
            this.f67353a = bVar;
            this.f67354b = nVar;
        }

        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            d b2 = b.b(this.f67353a);
            Calendar instance = Calendar.getInstance();
            instance.set(1, i2);
            instance.set(2, i3);
            instance.set(5, i4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
            k.a((Object) instance, "calendar");
            String format = simpleDateFormat.format(Long.valueOf(instance.getTimeInMillis()));
            v vVar = b2.f67375g;
            if (vVar == null) {
                k.a("updateType");
            }
            int i5 = e.f67382a[vVar.ordinal()];
            if (i5 == 1) {
                b2.f67373e = format;
            } else if (i5 != 2) {
                b2.f67371c = null;
                b2.f67373e = null;
            } else {
                b2.f67371c = format;
            }
            k.a((Object) format, "updatedDate");
            String a2 = d.a("dd MMM''yy", format);
            TextView textView = this.f67354b.f66862i;
            k.a((Object) textView, "binding.endDate");
            textView.setText(a2);
            this.f67354b.f66862i.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
            this.f67354b.k.setBackgroundColor(net.one97.paytm.upi.f.c("#dde5ed"));
            TextView textView2 = this.f67354b.f66861h;
            k.a((Object) textView2, "binding.dateError");
            net.one97.paytm.upi.f.a((View) textView2);
            b.c(this.f67353a);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(b bVar, MandateDefaultResponseModel mandateDefaultResponseModel, n nVar) {
        a(false, nVar);
        MandatePostTransactionActivity.a aVar = MandatePostTransactionActivity.f67445a;
        Context requireContext = bVar.requireContext();
        k.a((Object) requireContext, "requireContext()");
        d dVar = bVar.f67349d;
        if (dVar == null) {
            k.a("updateMandateViewModel");
        }
        String str = dVar.f67374f;
        MandateItem mandateItem = dVar.f67369a;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        String vpa = mandateItem.getPayee().getVpa();
        MandateItem mandateItem2 = dVar.f67369a;
        if (mandateItem2 == null) {
            k.a("mandateItem");
        }
        String userName = mandateItem2.getPayee().getUserName();
        MandateItem mandateItem3 = dVar.f67369a;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        String note = mandateItem3.getNote();
        MandateItem mandateItem4 = dVar.f67369a;
        if (mandateItem4 == null) {
            k.a("mandateItem");
        }
        String mcc = mandateItem4.getPayee().getMcc();
        MandateItem mandateItem5 = dVar.f67369a;
        if (mandateItem5 == null) {
            k.a("mandateItem");
        }
        String category = mandateItem5.getCategory();
        MandateItem mandateItem6 = dVar.f67369a;
        if (mandateItem6 == null) {
            k.a("mandateItem");
        }
        String vpa2 = mandateItem6.getPayer().getVpa();
        MandateItem mandateItem7 = dVar.f67369a;
        if (mandateItem7 == null) {
            k.a("mandateItem");
        }
        String bankIfsc = mandateItem7.getPayer().getBankIfsc();
        BankAccountDetails.BankAccount bankAccount = dVar.f67376h;
        if (bankAccount == null) {
            k.a("selectedBankAcc");
        }
        String bankName = bankAccount.getBankName();
        BankAccountDetails.BankAccount bankAccount2 = dVar.f67376h;
        if (bankAccount2 == null) {
            k.a("selectedBankAcc");
        }
        String account = bankAccount2.getAccount();
        BankAccountDetails.BankAccount bankAccount3 = dVar.f67376h;
        if (bankAccount3 == null) {
            k.a("selectedBankAcc");
        }
        BankAccountDetails.CredsAllowed credsAllowed = bankAccount3.getCredsAllowed();
        k.a((Object) credsAllowed, "selectedBankAcc.credsAllowed");
        List<BankAccountDetails.BankAccountCredentials> child = credsAllowed.getChild();
        MandateItem mandateItem8 = dVar.f67369a;
        if (mandateItem8 == null) {
            k.a("mandateItem");
        }
        String validityStartDate = mandateItem8.getValidityStartDate();
        MandateItem mandateItem9 = dVar.f67369a;
        if (mandateItem9 == null) {
            k.a("mandateItem");
        }
        String validityEndDate = mandateItem9.getValidityEndDate();
        MandateItem mandateItem10 = dVar.f67369a;
        if (mandateItem10 == null) {
            k.a("mandateItem");
        }
        String umn = mandateItem10.getUmn();
        MandateItem mandateItem11 = dVar.f67369a;
        if (mandateItem11 == null) {
            k.a("mandateItem");
        }
        String refUrl = mandateItem11.getRefUrl();
        MandateItem mandateItem12 = dVar.f67369a;
        if (mandateItem12 == null) {
            k.a("mandateItem");
        }
        String refCategory = mandateItem12.getRefCategory();
        net.one97.paytm.upi.mandate.d.a aVar2 = net.one97.paytm.upi.mandate.d.a.f67112a;
        MandateItem mandateItem13 = dVar.f67369a;
        if (mandateItem13 == null) {
            k.a("mandateItem");
        }
        MandateConfirmationUiModel a2 = net.one97.paytm.upi.mandate.d.a.a(mandateItem13, (String) null);
        String str2 = dVar.f67371c;
        String str3 = dVar.f67372d;
        String str4 = dVar.f67373e;
        v vVar = dVar.f67375g;
        if (vVar == null) {
            k.a("updateType");
        }
        MandatePostTransactionActivity.a.a(requireContext, mandateDefaultResponseModel, new CreateMandateUiModel(str, vpa, userName, note, mcc, (String) null, category, vpa2, bankIfsc, bankName, account, child, validityStartDate, validityEndDate, umn, "", refUrl, refCategory, (String) null, (w.a) null, (w.b) null, a2, new UpdateInfo(str2, str3, str4, vVar, dVar.f67374f), (String) null, 8650752, (kotlin.g.b.g) null), net.one97.paytm.upi.mandate.utils.k.PAYER_UPDATE);
        bVar.dismiss();
    }

    public static final /* synthetic */ void a(b bVar, t tVar, n nVar) {
        a(false, nVar);
        if (tVar instanceof t.a) {
            String str = ((t.a) tVar).f67420a;
            if (str == null) {
                str = bVar.getString(R.string.upi_some_went_wrong);
                k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
            }
            Context context = bVar.getContext();
            if (context != null) {
                net.one97.paytm.upi.f.a(context, str, 1);
            }
        } else if ((tVar instanceof t.k) || k.a((Object) tVar, (Object) t.h.f67427a)) {
            Context context2 = bVar.getContext();
            if (context2 != null) {
                net.one97.paytm.upi.f.a(context2, R.string.error_fetching_profile_details, 1);
            }
        } else if (tVar instanceof t.i) {
            CustomDialog.showAlert(bVar.getActivity(), bVar.getResources().getString(R.string.no_connection), bVar.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.f) {
            Context context3 = bVar.getContext();
            if (context3 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = bVar.getString(R.string.something_went_wrong);
                    k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                net.one97.paytm.upi.f.a(context3, str2, 1);
            }
        } else if (tVar instanceof t.j) {
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateConfirmationDetailActivity.class.getName();
            a2.b().e(bVar.getActivity());
        } else if (tVar instanceof t.g) {
            Context context4 = bVar.getContext();
            if (context4 != null) {
                net.one97.paytm.upi.f.a(context4, R.string.something_went_wrong, 1);
            }
        } else if (tVar instanceof t.c) {
            Intent intent = new Intent(bVar.getContext(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            bVar.startActivityForResult(intent, 80);
        } else if (!(tVar instanceof t.b)) {
        } else {
            if (((t.b) tVar).f67421a instanceof w.b) {
                TextView textView = nVar.f66861h;
                k.a((Object) textView, "binding.dateError");
                net.one97.paytm.upi.f.b((View) textView);
                nVar.k.setBackgroundColor(net.one97.paytm.upi.f.a((Fragment) bVar, R.color.error_separator_view_color));
                return;
            }
            nVar.f66856c.setBackgroundColor(net.one97.paytm.upi.f.a((Fragment) bVar, R.color.error_separator_view_color));
            nVar.f66855b.setTextColor(net.one97.paytm.upi.f.a((Fragment) bVar, R.color.error_separator_view_color));
            TextView textView2 = nVar.f66855b;
            k.a((Object) textView2, "binding.amountInWords");
            textView2.setText(bVar.getString(R.string.upi_empty_amount_error));
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        b bVar2 = bVar;
        v vVar = bVar2.f67347b;
        if (vVar == null) {
            k.a("updateType");
        }
        int i2 = c.f67367c[vVar.ordinal()];
        if (i2 == 1) {
            Context requireContext = bVar.requireContext();
            MandateItem mandateItem = bVar2.f67348c;
            if (mandateItem == null) {
                k.a("mandateItem");
            }
            String state = mandateItem.getState();
            MandateItem mandateItem2 = bVar2.f67348c;
            if (mandateItem2 == null) {
                k.a("mandateItem");
            }
            String vpa = mandateItem2.getPayee().getVpa();
            MandateItem mandateItem3 = bVar2.f67348c;
            if (mandateItem3 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Pause_proceed_bottomsheet_clicked", state, "", "", vpa, mandateItem3.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_PAUSE_BS, "UPI");
        } else if (i2 == 2) {
            Context requireContext2 = bVar.requireContext();
            MandateItem mandateItem4 = bVar2.f67348c;
            if (mandateItem4 == null) {
                k.a("mandateItem");
            }
            String state2 = mandateItem4.getState();
            MandateItem mandateItem5 = bVar2.f67348c;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            String vpa2 = mandateItem5.getPayee().getVpa();
            MandateItem mandateItem6 = bVar2.f67348c;
            if (mandateItem6 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Resume_proceed_bottomsheet_clicked", state2, "", "", vpa2, mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_RESUME_BS, "UPI");
        } else if (i2 == 3) {
            Context requireContext3 = bVar.requireContext();
            MandateItem mandateItem7 = bVar2.f67348c;
            if (mandateItem7 == null) {
                k.a("mandateItem");
            }
            String state3 = mandateItem7.getState();
            MandateItem mandateItem8 = bVar2.f67348c;
            if (mandateItem8 == null) {
                k.a("mandateItem");
            }
            String vpa3 = mandateItem8.getPayee().getVpa();
            MandateItem mandateItem9 = bVar2.f67348c;
            if (mandateItem9 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Revoke_proceed_bottomsheet_clicked", state3, "", "", vpa3, mandateItem9.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_REVOKE_BS, "UPI");
        } else if (i2 == 4) {
            Context requireContext4 = bVar.requireContext();
            MandateItem mandateItem10 = bVar2.f67348c;
            if (mandateItem10 == null) {
                k.a("mandateItem");
            }
            String state4 = mandateItem10.getState();
            MandateItem mandateItem11 = bVar2.f67348c;
            if (mandateItem11 == null) {
                k.a("mandateItem");
            }
            String vpa4 = mandateItem11.getPayee().getVpa();
            MandateItem mandateItem12 = bVar2.f67348c;
            if (mandateItem12 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext4, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Payer-Update_proceed_bottomsheet_clicked", state4, "", "", vpa4, mandateItem12.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_PAYER_UPDATE_BS, "UPI");
        }
    }

    public static final /* synthetic */ void a(b bVar, n nVar) {
        UpiAppUtils.hideKeyboard(bVar.requireActivity());
        Context context = bVar.getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        net.one97.paytm.upi.mandate.utils.b bVar2 = new net.one97.paytm.upi.mandate.utils.b(context, new c(bVar, nVar), Calendar.getInstance().get(1), Calendar.getInstance().get(2), Calendar.getInstance().get(5), (byte) 0);
        DatePicker datePicker = bVar2.getDatePicker();
        k.a((Object) datePicker, "datePickerDialog.datePicker");
        datePicker.setMinDate(new Date().getTime());
        DatePicker datePicker2 = bVar2.getDatePicker();
        k.a((Object) datePicker2, "datePickerDialog.datePicker");
        d dVar = bVar.f67349d;
        if (dVar == null) {
            k.a("updateMandateViewModel");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
        MandateItem mandateItem = dVar.f67369a;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        Date parse = simpleDateFormat.parse(mandateItem.getValidityEndDate());
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "calendar");
        instance.setTime(parse);
        instance.add(5, -1);
        Date time = instance.getTime();
        k.a((Object) time, "calendar.time");
        datePicker2.setMaxDate(time.getTime());
        bVar2.show();
    }

    public static final /* synthetic */ void c(b bVar) {
        b bVar2 = bVar;
        v vVar = bVar2.f67347b;
        if (vVar == null) {
            k.a("updateType");
        }
        int i2 = c.f67368d[vVar.ordinal()];
        if (i2 == 1) {
            Context requireContext = bVar.requireContext();
            MandateItem mandateItem = bVar2.f67348c;
            if (mandateItem == null) {
                k.a("mandateItem");
            }
            String state = mandateItem.getState();
            MandateItem mandateItem2 = bVar2.f67348c;
            if (mandateItem2 == null) {
                k.a("mandateItem");
            }
            String vpa = mandateItem2.getPayee().getVpa();
            MandateItem mandateItem3 = bVar2.f67348c;
            if (mandateItem3 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Pause_Validity_End_Date", state, "", "", vpa, mandateItem3.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_PAUSE_BS, "UPI");
        } else if (i2 == 2) {
            Context requireContext2 = bVar.requireContext();
            MandateItem mandateItem4 = bVar2.f67348c;
            if (mandateItem4 == null) {
                k.a("mandateItem");
            }
            String state2 = mandateItem4.getState();
            MandateItem mandateItem5 = bVar2.f67348c;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            String vpa2 = mandateItem5.getPayee().getVpa();
            MandateItem mandateItem6 = bVar2.f67348c;
            if (mandateItem6 == null) {
                k.a("mandateItem");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Payer-Update_Validity_End_Date", state2, "", "", vpa2, mandateItem6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_PAYER_UPDATE_BS, "UPI");
        }
    }
}
