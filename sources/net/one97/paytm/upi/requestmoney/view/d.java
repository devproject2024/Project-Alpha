package net.one97.paytm.upi.requestmoney.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.a.a;
import androidx.loader.b.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.upi.common.PaymentInstrumentationType;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.ReferralCodeResponse;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.referral.UpiReferralActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.requestmoney.a.b;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;
import net.one97.paytm.upi.requestmoney.view.c;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class d extends h implements a.C0056a<Cursor>, b.C1400b {

    /* renamed from: e  reason: collision with root package name */
    public static String f69405e = "section_header_title";

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ContactItemModel> f69406a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    TextView f69407b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutManager f69408c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public c f69409d;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f69410f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f69411g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f69412h;

    /* renamed from: i  reason: collision with root package name */
    private CustomWalletLoaderDialog f69413i;
    private String j;
    private ShimmerFrameLayout k;
    private FrameLayout l;
    private b.a m;
    /* access modifiers changed from: private */
    public b n;
    /* access modifiers changed from: private */
    public a o;
    /* access modifiers changed from: private */
    public String p;
    private String q;

    public interface b {
        void b(Bundle bundle);

        void c(boolean z);

        void k();

        void l();

        void m();
    }

    public final void a(c<Cursor> cVar) {
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && this.o == null) {
            this.o = new a(getActivity());
            this.o.execute(new Cursor[]{cursor});
        }
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.m = (b.a) obj;
    }

    public static d a(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(f69405e, i2);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) getActivity(), "android.permission.READ_CONTACTS") == 0) {
            getActivity().getSupportLoaderManager().a(100, (Bundle) null, this);
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 102);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getContext();
        this.m = new net.one97.paytm.upi.requestmoney.presenter.b(this, g.c());
        return layoutInflater.inflate(R.layout.fragment_request_money_contactlist, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f69410f = (RecyclerView) view.findViewById(R.id.contact_list);
        this.f69411g = (RelativeLayout) view.findViewById(R.id.parent_layout);
        this.f69407b = (TextView) view.findViewById(R.id.tv_search);
        this.k = (ShimmerFrameLayout) view.findViewById(R.id.contacts_shimmer_layout);
        this.l = (FrameLayout) view.findViewById(R.id.progress_layout_contacts);
        this.f69412h = (TextView) view.findViewById(R.id.tv_contacts);
        if (getArguments() != null) {
            this.f69412h.setText(getArguments().getInt(f69405e));
        }
        this.f69408c = new LinearLayoutManager(getActivity());
        this.f69410f.setLayoutManager(this.f69408c);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_contact_items);
        for (int i2 = 0; i2 < 50; i2++) {
            linearLayout.addView(getLayoutInflater().inflate(R.layout.upi_dummy_contact_list_item, (ViewGroup) null));
        }
        b(true);
        this.f69409d = new c(getActivity(), this.f69406a, new c.C1405c() {
            public final void onClick(String str, String str2) {
                d.this.a(str, str2);
            }
        });
        this.f69410f.setAdapter(this.f69409d);
        this.f69407b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.j = str2;
            if (UpiAppUtils.isNetworkAvailable(getActivity())) {
                this.m.a(str);
            } else {
                CustomDialog.showAlert(getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f69407b.setVisibility(8);
        this.n.c(true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof b) {
            this.n = (b) context;
        }
    }

    public final void a(boolean z) {
        try {
            if (this.f69413i == null) {
                this.f69413i = new CustomWalletLoaderDialog(getActivity());
            }
            if (z) {
                this.f69413i.setTitle(String.format(getString(R.string.money_transfer_contact_details_loader_msg), new Object[]{this.j}));
                this.f69413i.setSubTitle("");
                this.f69413i.showLoader();
                return;
            }
            this.f69413i.dismissLoader();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            d.class.getName();
            kVar.e(activity);
            return;
        }
        CustomDialog.showAlert(getActivity(), "Error", upiCustomVolleyError.getAlertMessage());
    }

    public final void a() {
        String str;
        if (getActivity() != null && !TextUtils.isEmpty(UpiGTMLoader.getInstance().getBankTransferInviteText())) {
            UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_PHONEBOOK_CLICKED_N_DIALOG_LOADED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "invite_dialog_loaded", "", "", "");
            View inflate = getLayoutInflater().inflate(R.layout.upi_bottom_sheet_invite_friend, (ViewGroup) null);
            final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getActivity());
            aVar.setContentView(inflate);
            final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                    UpiAppUtils.hideKeyboard(d.this.getActivity());
                }
            });
            from.setBottomSheetCallback(new BottomSheetBehavior.a() {
                public final void onStateChanged(View view, int i2) {
                }

                public final void onSlide(View view, float f2) {
                    aVar.cancel();
                    UpiAppUtils.hideKeyboard(d.this.getActivity());
                }
            });
            from.setState(2);
            from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels - UpiAppUtils.convertDpToPixel(150.0f, getActivity()));
            aVar.getWindow().setSoftInputMode(16);
            aVar.show();
            String string = getString(R.string.upi_invite_cashback_text);
            String string2 = getString(R.string.upi_invite_friends);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_close);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_invite);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_desc);
            ((TextView) inflate.findViewById(R.id.tv_heading)).setText(string2);
            if (!TextUtils.isEmpty(string)) {
                textView2.setVisibility(0);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                if (string.contains("https")) {
                    final String substring = string.substring(string.indexOf("https"), string.indexOf("'>"));
                    String substring2 = string.substring(string.indexOf("'>") + 2, string.indexOf("</"));
                    if (Build.VERSION.SDK_INT >= 24) {
                        str = Html.fromHtml(string, 0).toString();
                    } else {
                        str = Html.fromHtml(string).toString();
                    }
                    SpannableString spannableString = new SpannableString(str);
                    AnonymousClass6 r8 = new ClickableSpan() {
                        public final void onClick(View view) {
                            d.this.startActivity(new Intent(d.this.getActivity(), UpiReferralActivity.class));
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(Color.parseColor("#00b9f5"));
                        }
                    };
                    int indexOf = str.indexOf(substring2);
                    int length = substring2.length() + indexOf;
                    if (indexOf >= 0 && length >= 0) {
                        spannableString.setSpan(r8, indexOf, length, 33);
                    }
                    textView2.setText(spannableString);
                } else {
                    textView2.setText(string);
                }
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.b();
                    aVar.dismiss();
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.dismiss();
                }
            });
        }
    }

    public final void a(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        if (paymentOptionList.getDestinationPayment().getError() != null) {
            a(false);
            paymentOptionList.getDestinationPayment().getError().getMessage();
            a();
        } else if (paymentOptionList.getSourcePayment().getPaymentType().equalsIgnoreCase(PaymentInstrumentationType.UPI_LEAD.name())) {
            a(false);
        } else if (paymentOptionList.getDestinationPayment().getPaymentType().equalsIgnoreCase(PaymentInstrumentationType.UPI.name())) {
            a(false);
            String vpaId = paymentOptionList.getDestinationPayment().getVpaId();
            String displayName = paymentOptionList.getDestinationPayment().getDisplayName();
            Bundle bundle = new Bundle();
            bundle.putString("payee_vpa", vpaId);
            bundle.putString("payee_name", displayName);
            bundle.putString(UpiConstants.EXTRA_ACCOUNT_TYPE, "UPI");
            this.n.b(bundle);
        } else if (paymentOptionList.getDestinationPayment().getPaymentType().equalsIgnoreCase(PaymentInstrumentationType.BANK.name())) {
            a(false);
            Bundle bundle2 = new Bundle();
            bundle2.putString(UpiConstants.EXTRA_ACCOUNT_TYPE, SDKConstants.TYPE_BANK);
            bundle2.putString("payee_name", this.j);
            bundle2.putString(UpiConstants.EXTRA_PAYEE_ACC_NUMBER, paymentOptionList.getDestinationPayment().getBankAccountNumber());
            bundle2.putString(UpiConstants.EXTRA_IFSC, paymentOptionList.getDestinationPayment().getIfscCode());
            bundle2.putString(UpiConstants.EXTRA_BANK_NAME, paymentOptionList.getDestinationPayment().getBankName());
            UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SELECTED_CONTACT_STATUS, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "linked_bank", "", "", "");
            this.n.b(bundle2);
        }
    }

    public final androidx.loader.b.c<Cursor> a(Bundle bundle) {
        return new androidx.loader.b.b(getActivity(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1", "photo_uri"}, (String) null, (String[]) null, "display_name");
    }

    public void onDestroy() {
        a aVar = this.o;
        if (aVar != null) {
            aVar.cancel(true);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void b() {
        net.one97.paytm.upi.registration.b.a.b.a.a(getActivity().getApplicationContext()).d(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof ReferralCodeResponse) {
                    ReferralCodeResponse referralCodeResponse = (ReferralCodeResponse) upiBaseDataModel;
                    if (referralCodeResponse.getStatus().equalsIgnoreCase("success")) {
                        d dVar = d.this;
                        String unused = dVar.p = referralCodeResponse.getReferralContent() + StringUtility.NEW_LINE + referralCodeResponse.getReferralUrl();
                        d.b(d.this);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (upiCustomVolleyError == null || !upiCustomVolleyError.getmErrorCode().equals(UpiConstants.NETWORK_ERROR_CODE)) {
                    Toast.makeText(d.this.getActivity(), R.string.upi_some_went_wrong, 0).show();
                } else {
                    CustomDialog.showAlert(d.this.getContext(), d.this.getString(R.string.no_connection), d.this.getString(R.string.no_internet_new_message));
                }
            }
        }, "");
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && Character.isDigit(str.charAt(0))) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.l.setVisibility(0);
            this.k.startShimmerAnimation();
            return;
        }
        this.l.setVisibility(8);
        this.k.stopShimmerAnimation();
    }

    class a extends AsyncTask<Cursor, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Activity> f69426b;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (this.f69426b.get() != null && !isCancelled() && d.this.isAdded() && d.this.f69409d != null) {
                if (d.this.f69406a == null || d.this.f69406a.size() <= 0) {
                    d.this.b(false);
                    d.this.n.k();
                    return;
                }
                d.this.f69409d.a(d.this.f69406a);
                d.this.f69411g.setVisibility(0);
                d.this.b(false);
                d.this.n.l();
            }
        }

        public a(Activity activity) {
            this.f69426b = new WeakReference<>(activity);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(Cursor... cursorArr) {
            try {
                d.a(d.this, cursorArr[0]);
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
            if (this.f69426b.get() != null) {
                a unused = d.this.o = null;
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 102) {
            if (iArr.length > 0 && iArr[0] == 0) {
                getActivity().getSupportLoaderManager().a(100, (Bundle) null, this);
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    static /* synthetic */ void b(d dVar) {
        if (dVar.getActivity() == null) {
            return;
        }
        if (!dVar.p.isEmpty()) {
            FragmentActivity activity = dVar.getActivity();
            String str = dVar.p;
            String str2 = dVar.q;
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            activity.startActivity(Intent.createChooser(intent, "Share via"));
            return;
        }
        dVar.b();
    }

    static /* synthetic */ void a(d dVar, Cursor cursor) {
        try {
            ArrayList arrayList = new ArrayList();
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast() && (dVar.o == null || !dVar.o.isCancelled())) {
                    String string = cursor.getString(cursor.getColumnIndex("display_name"));
                    String string2 = cursor.getString(cursor.getColumnIndex("data1"));
                    String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                    String removeSpaceAndBracketP2P = UpiAppUtils.removeSpaceAndBracketP2P(dVar.getActivity(), string2);
                    if (removeSpaceAndBracketP2P.length() > 10) {
                        removeSpaceAndBracketP2P = UpiAppUtils.filterMobileNumberP2P(dVar.getActivity(), removeSpaceAndBracketP2P);
                    }
                    if (a(removeSpaceAndBracketP2P)) {
                        if ((!TextUtils.isEmpty(string) && Character.isLetter(string.charAt(0))) && !arrayList.contains(removeSpaceAndBracketP2P)) {
                            arrayList.add(removeSpaceAndBracketP2P);
                            dVar.f69406a.add(new ContactItemModel(string, removeSpaceAndBracketP2P, string3, false));
                            UpiAppUtils.getInitialsSingle(string);
                        }
                    }
                    cursor.moveToNext();
                }
            } else {
                dVar.n.m();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
