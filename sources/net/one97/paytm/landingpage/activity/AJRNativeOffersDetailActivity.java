package net.one97.paytm.landingpage.activity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJRTnCModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRLandingPageMetaData;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.j;

public class AJRNativeOffersDetailActivity extends PaytmActivity implements View.OnClickListener, AppBarLayout.b, b {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f52687a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f52688b;

    /* renamed from: c  reason: collision with root package name */
    private AppBarLayout f52689c;

    /* renamed from: d  reason: collision with root package name */
    private int f52690d;

    /* renamed from: e  reason: collision with root package name */
    private CollapsingToolbarLayout f52691e;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f52692f;

    /* renamed from: g  reason: collision with root package name */
    private CJRLandingPageMetaData f52693g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f52694h;

    /* renamed from: i  reason: collision with root package name */
    private Button f52695i;
    private Button j;
    private Button k;
    private LinearLayout l;
    private TextView m;
    private RelativeLayout n;
    private final int o = 5;
    private CJRTnCModel p;
    private ProgressBar q;
    private TextView r;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        setContentView((int) R.layout.native_offer_activity);
        this.f52693g = (CJRLandingPageMetaData) getIntent().getSerializableExtra("lpmetaData");
        this.f52692f = (Toolbar) findViewById(R.id.toolbar);
        this.f52691e = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        this.f52691e.setTitle(" ");
        this.f52689c = (AppBarLayout) findViewById(R.id.appbar);
        this.f52689c.setExpanded(true);
        this.f52687a = (RelativeLayout) findViewById(R.id.lyt_promocode_sticky);
        this.f52687a.setVisibility(8);
        this.f52689c.a((AppBarLayout.b) this);
        findViewById(R.id.lyt_copy_code).setOnClickListener(this);
        findViewById(R.id.txt_copy_toolbar).setOnClickListener(this);
        findViewById(R.id.img_offers_detail_back).setOnClickListener(this);
        findViewById(R.id.img_back_offers_toolbar).setOnClickListener(this);
        this.f52688b = (TextView) findViewById(R.id.bannerDes);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.bannerProgressBar1);
        ImageView imageView = (ImageView) findViewById(R.id.banner_image);
        this.f52694h = (LinearLayout) findViewById(R.id.lyt_btn_offers);
        this.f52695i = (Button) findViewById(R.id.btn_offers_book_0);
        this.f52695i.setOnClickListener(this);
        this.j = (Button) findViewById(R.id.btn_offers_book_1);
        this.j.setOnClickListener(this);
        this.k = (Button) findViewById(R.id.btn_offers_book_2);
        this.k.setOnClickListener(this);
        this.l = (LinearLayout) findViewById(R.id.lyt_lucky_winners_subheading);
        this.m = (TextView) findViewById(R.id.doc_heading);
        CJRLandingPageMetaData cJRLandingPageMetaData = this.f52693g;
        if (cJRLandingPageMetaData != null && !TextUtils.isEmpty(cJRLandingPageMetaData.getImageUrl())) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(getApplicationContext());
            a2.f43753a = this.f52693g.getImageUrl();
            b.a.C0750a.a(a2.a(progressBar), imageView, (com.paytm.utility.b.b.b) null, 2);
        }
        this.q = (ProgressBar) findViewById(R.id.bannerProgressBar);
        this.r = (TextView) findViewById(R.id.offer_details_heading);
        this.n = (RelativeLayout) findViewById(R.id.relative_read_more);
        this.n.setOnClickListener(this);
        this.q.setVisibility(0);
        c.a();
        String a3 = c.a("promoSearchUrl", (String) null);
        if (this.f52693g == null || TextUtils.isEmpty(a3) || this.f52693g.getPromocode() == null || TextUtils.isEmpty(this.f52693g.getPromocode().getText())) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            d.a(this, String.format(a3, new Object[]{this.f52693g.getPromocode().getText()}), this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRTnCModel(), a.c.HOME, a.b.SILENT).a();
        }
        String title = this.f52693g.getTitle();
        String subtitle = this.f52693g.getSubtitle();
        ((TextView) findViewById(R.id.txt_offer_detail_title)).setText(title);
        ((TextView) findViewById(R.id.txt_offer_detail_desc)).setText(subtitle);
        CJRLandingPageMetaData cJRLandingPageMetaData2 = this.f52693g;
        if (cJRLandingPageMetaData2 == null || cJRLandingPageMetaData2.getPromocode() == null || TextUtils.isEmpty(this.f52693g.getPromocode().getVisibility()) || !this.f52693g.getPromocode().getVisibility().equalsIgnoreCase("1")) {
            findViewById(R.id.promo_oofer_lyout).setVisibility(8);
            findViewById(R.id.txt_copy_toolbar).setVisibility(8);
            ((TextView) findViewById(R.id.txt_offer_detail_promo_toolbar)).setText(this.f52693g.getTitle());
        } else {
            String text = this.f52693g.getPromocode().getText();
            ((TextView) findViewById(R.id.txt_offer_detail_promo_toolbar)).setText(text);
            ((TextView) findViewById(R.id.txt_offer_detail_promo_copy)).setText(text);
            ((TextView) findViewById(R.id.txt_offer_detail_promo_copied)).setText(text);
        }
        CJRLandingPageMetaData cJRLandingPageMetaData3 = this.f52693g;
        if (!(cJRLandingPageMetaData3 == null || cJRLandingPageMetaData3.getButtons() == null)) {
            this.f52694h.setVisibility(0);
            if (this.f52693g.getButtons().getBtnOne() != null && this.f52693g.getButtons().getBtnOne().getVisibility() != null && this.f52693g.getButtons().getBtnOne().getVisibility().trim().equalsIgnoreCase("1") && this.f52693g.getButtons().getBtnTwo() != null && this.f52693g.getButtons().getBtnTwo().getVisibility() != null && this.f52693g.getButtons().getBtnTwo().getVisibility().trim().equalsIgnoreCase("1")) {
                this.j.setVisibility(0);
                this.j.setText(this.f52693g.getButtons().getBtnOne().getText());
                if (!TextUtils.isEmpty(this.f52693g.getButtons().getBtnOne().getUrl())) {
                    this.j.setTag(this.f52693g.getButtons().getBtnOne().getUrl());
                }
                this.k.setVisibility(0);
                this.k.setText(this.f52693g.getButtons().getBtnTwo().getText());
                if (!TextUtils.isEmpty(this.f52693g.getButtons().getBtnTwo().getUrl())) {
                    this.k.setTag(this.f52693g.getButtons().getBtnTwo().getUrl());
                }
            } else if (this.f52693g.getButtons().getBtnOne() != null && this.f52693g.getButtons().getBtnOne().getVisibility() != null && this.f52693g.getButtons().getBtnOne().getVisibility().trim().equalsIgnoreCase("1")) {
                this.f52695i.setVisibility(0);
                this.f52695i.setText(this.f52693g.getButtons().getBtnOne().getText());
                if (!TextUtils.isEmpty(this.f52693g.getButtons().getBtnOne().getUrl())) {
                    this.f52695i.setTag(this.f52693g.getButtons().getBtnOne().getUrl());
                }
            } else if (!(this.f52693g.getButtons().getBtnTwo() == null || this.f52693g.getButtons().getBtnTwo().getVisibility() == null || !this.f52693g.getButtons().getBtnTwo().getVisibility().trim().equalsIgnoreCase("1"))) {
                this.f52695i.setVisibility(0);
                this.f52695i.setText(this.f52693g.getButtons().getBtnTwo().getText());
                if (!TextUtils.isEmpty(this.f52693g.getButtons().getBtnTwo().getUrl())) {
                    this.f52695i.setTag(this.f52693g.getButtons().getBtnTwo().getUrl());
                }
            }
        }
        CJRLandingPageMetaData cJRLandingPageMetaData4 = this.f52693g;
        if (cJRLandingPageMetaData4 != null && cJRLandingPageMetaData4.getDoc() != null) {
            this.m.setText(this.f52693g.getDoc().getHeading());
            if (!TextUtils.isEmpty(this.f52693g.getDoc().getUrl())) {
                this.m.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.m.setOnClickListener(this);
                this.m.setTag(this.f52693g.getDoc().getUrl());
            }
            CJRLandingPageMetaData.Subheadings subheadings = this.f52693g.getDoc().getSubheadings();
            if (subheadings != null) {
                if (subheadings.getSubHeading1() != null && subheadings.getSubHeading1().getVisibility().equalsIgnoreCase("1")) {
                    this.l.addView(a(subheadings.getSubHeading1().getText(), subheadings.getSubHeading1().getUrl()));
                }
                if (subheadings.getSubHeading2() != null && subheadings.getSubHeading2().getVisibility().equalsIgnoreCase("1")) {
                    this.l.addView(a(subheadings.getSubHeading2().getText(), subheadings.getSubHeading2().getUrl()));
                }
                if (subheadings.getSubHeading3() != null && subheadings.getSubHeading3().getVisibility().equalsIgnoreCase("1")) {
                    this.l.addView(a(subheadings.getSubHeading3().getText(), subheadings.getSubHeading3().getUrl()));
                }
                if (subheadings.getSubHeading4() != null && subheadings.getSubHeading4().getVisibility().equalsIgnoreCase("1")) {
                    this.l.addView(a(subheadings.getSubHeading4().getText(), subheadings.getSubHeading4().getUrl()));
                }
                if (subheadings.getSubHeading5() != null && subheadings.getSubHeading5().getVisibility().equalsIgnoreCase("1")) {
                    this.l.addView(a(subheadings.getSubHeading5().getText(), subheadings.getSubHeading5().getUrl()));
                }
            }
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        this.f52690d = i2;
        int totalScrollRange = this.f52689c.getTotalScrollRange();
        if (totalScrollRange == 0 || Math.abs(this.f52690d) != totalScrollRange) {
            this.f52691e.setStatusBarScrimColor(androidx.core.content.b.c(this, 17170445));
            this.f52687a.setVisibility(8);
            a("#00000000");
            return;
        }
        this.f52691e.setStatusBarScrimColor(androidx.core.content.b.c(this, R.color.app_theme_color));
        this.f52687a.setVisibility(0);
        a("#FF012B72");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        boolean z = false;
        switch (view.getId()) {
            case R.id.btn_offers_book_0:
            case R.id.btn_offers_book_1:
            case R.id.btn_offers_book_2:
                b((String) view.getTag());
                return;
            case R.id.doc_heading:
                Uri parse = Uri.parse((String) view.getTag());
                String heading = this.f52693g.getDoc().getHeading();
                int applicationEnabledSetting = getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
                if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                    try {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage(getResources().getString(R.string.enable_download_manager_permission_alert_msg));
                        builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ boolean f52697a = false;

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                if (this.f52697a) {
                                    s.b((Context) AJRNativeOffersDetailActivity.this);
                                    AJRNativeOffersDetailActivity.this.finish();
                                    return;
                                }
                                try {
                                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                    intent.setData(Uri.parse("package:com.android.providers.downloads"));
                                    AJRNativeOffersDetailActivity.this.startActivity(intent);
                                } catch (ActivityNotFoundException e2) {
                                    q.b(e2.getMessage());
                                    AJRNativeOffersDetailActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                                }
                            }
                        });
                        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        builder.show();
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.b(e2.getMessage());
                        }
                    }
                } else {
                    z = true;
                }
                if (z && "mounted".equals(Environment.getExternalStorageState())) {
                    DownloadManager.Request request = new DownloadManager.Request(parse);
                    request.setTitle(heading);
                    request.setDescription("Downloading...");
                    String str = Environment.DIRECTORY_DOWNLOADS;
                    request.setDestinationInExternalFilesDir(this, str, heading + ".pdf");
                    request.setNotificationVisibility(1);
                    ((DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD)).enqueue(request);
                    return;
                }
                return;
            case R.id.img_back_offers_toolbar:
            case R.id.img_offers_detail_back:
                finish();
                return;
            case R.id.lyt_copy_code:
            case R.id.txt_copy_toolbar:
                Toast.makeText(this, "PromoCode Copied!", 0).show();
                String text = this.f52693g.getPromocode().getText();
                if (Build.VERSION.SDK_INT < 11) {
                    ((ClipboardManager) getSystemService("clipboard")).setText(text);
                } else {
                    ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(text, text));
                }
                findViewById(R.id.lyt_copy_code).setVisibility(8);
                findViewById(R.id.lyt_copied_code).setVisibility(0);
                ((TextView) findViewById(R.id.txt_copy_toolbar)).setText(getString(R.string.copied_caps));
                ((TextView) findViewById(R.id.txt_copy_toolbar)).setTextColor(androidx.core.content.b.c(this, R.color.color_21c17a));
                return;
            case R.id.relative_read_more:
                a(this.p, true);
                return;
            default:
                return;
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRTnCModel) {
            this.p = (CJRTnCModel) iJRPaytmDataModel;
            ProgressBar progressBar = this.q;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            a(this.p, false);
        }
    }

    private void a(CJRTnCModel cJRTnCModel, boolean z) {
        if (cJRTnCModel != null && !TextUtils.isEmpty(cJRTnCModel.getTerms().trim())) {
            String[] split = cJRTnCModel.getTerms().split("<br>");
            if (split == null || split.length <= 0) {
                this.r.setVisibility(8);
                return;
            }
            List asList = Arrays.asList(split);
            if (!z) {
                a((List<String>) asList, false);
            } else {
                a((List<String>) asList, true);
            }
        }
    }

    private void a(List<String> list, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i2 = 5;
        if (z || 5 >= list.size()) {
            i2 = list.size();
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            String str = list.get(i3);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                if (str.contains("<br>")) {
                    str = str.replaceAll("<br>", "");
                }
                sb.append(str);
                sb.append("\n\n");
            }
        }
        this.f52688b.setText(sb.toString());
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ProgressBar progressBar = this.q;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private View a(String str, String str2) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.winner_list_item, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.txt_subheading)).setText(str);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.heading_lyout);
        linearLayout.setTag(str2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRNativeOffersDetailActivity.this.b((String) view.getTag());
            }
        });
        return inflate;
    }

    private void a(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(Integer.MIN_VALUE);
            window.addFlags(67108864);
            window.setStatusBarColor(Color.parseColor(str));
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!TextUtils.isEmpty(str) && str.trim().startsWith("paytmmp://")) {
            CJRHomePageItem a2 = ac.a(this, str.trim());
            if (a2 != null) {
                j.a((Context) this, a2.getURLType(), (IJRDataModel) a2, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (net.one97.paytm.c) null);
            }
        } else if (!TextUtils.isEmpty(str) && URLUtil.isValidUrl(str.trim())) {
            c(str);
        }
    }

    private void c(String str) {
        Intent intent = new Intent(this, AJREmbedWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "");
        startActivity(intent);
    }
}
