package net.one97.paytm.dynamic.module.cashback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.a;
import com.paytm.network.b;
import java.util.HashMap;
import net.one97.paytm.coins.activity.PaytmCoinLandingActivity;
import net.one97.paytm.coins.activity.PointsRewardListActivity;
import net.one97.paytm.common.entity.ContextResponse;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.v2.features.cashbackoffers.ui.OfferListActivity;
import net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity;
import net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity;
import net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity;
import net.one97.paytm.vipcashback.activity.CashbackVoucherDetailsActivity;
import net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity;
import net.one97.paytm.vipcashback.d.a;

public class CashbackInitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CashbackDataProvider.initCashbackModule(this);
        handleDeepLinkIntent(getIntent(), this);
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public static void handleDeepLinkIntent(Intent intent, Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        DeepLinkData deepLinkData;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        Intent intent2;
        Intent intent3;
        int i2;
        String str20;
        String str21;
        Intent intent4 = intent;
        Context context2 = context;
        if (intent4.getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            DeepLinkData deepLinkData2 = (DeepLinkData) intent4.getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            String stringExtra = intent4.getStringExtra("identifier");
            if (!TextUtils.isEmpty(stringExtra) && "referral".equalsIgnoreCase(stringExtra)) {
                net.one97.paytm.referral.c.a aVar = net.one97.paytm.referral.c.a.f20027a;
                net.one97.paytm.referral.c.a.a(context2, deepLinkData2);
            } else if (TextUtils.isEmpty(stringExtra) || (!"paytm_coins".equalsIgnoreCase(stringExtra) && !"redeem_coins".equalsIgnoreCase(stringExtra))) {
                if ("business-app".equals(deepLinkData2.f50284b)) {
                    if (deepLinkData2.f50289g != null) {
                        Uri uri = deepLinkData2.f50289g;
                        String queryParameter = uri.getQueryParameter("url");
                        String queryParameter2 = uri.getQueryParameter("channel");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            String str22 = "paytmmp://accept_money?featuretype=ump-web&url=" + queryParameter + "&channel=" + queryParameter2;
                            h.a aVar2 = h.f50349a;
                            h.a.a(context2, str22, (Bundle) null);
                        }
                    }
                } else if (deepLinkData2.f50290h != null || deepLinkData2.f50289g != null) {
                    String string = context2.getString(R.string.scratch_cards_get_cashback);
                    if (deepLinkData2.f50289g != null) {
                        Uri uri2 = deepLinkData2.f50289g;
                        String queryParameter3 = uri2.getQueryParameter("screen");
                        String queryParameter4 = uri2.getQueryParameter("gameid");
                        String queryParameter5 = uri2.getQueryParameter("campaignid");
                        String queryParameter6 = uri2.getQueryParameter("offertag");
                        String queryParameter7 = uri2.getQueryParameter("showHomeOnBack");
                        String str23 = queryParameter3;
                        String queryParameter8 = uri2.getQueryParameter("is_from_category");
                        String queryParameter9 = uri2.getQueryParameter(Utility.EVENT_CATEGORY_PROMOCODE);
                        String str24 = queryParameter8;
                        String queryParameter10 = uri2.getQueryParameter("vouchercode");
                        String queryParameter11 = uri2.getQueryParameter("siteid");
                        String str25 = queryParameter10;
                        String queryParameter12 = uri2.getQueryParameter("stageNumber");
                        String queryParameter13 = uri2.getQueryParameter("offerType");
                        String queryParameter14 = uri2.getQueryParameter("headerImg");
                        str = "showHomeOnBack";
                        str3 = queryParameter5;
                        str17 = queryParameter6;
                        str13 = str23;
                        str7 = queryParameter9;
                        str9 = str25;
                        str2 = queryParameter12;
                        str4 = queryParameter13;
                        str10 = uri2.getQueryParameter("activityName");
                        str6 = string;
                        str18 = queryParameter14;
                        String str26 = queryParameter11;
                        deepLinkData = deepLinkData2;
                        str16 = queryParameter7;
                        str8 = str26;
                        String str27 = queryParameter4;
                        str11 = "campaignid";
                        str15 = str27;
                        str12 = uri2.getQueryParameter("source");
                        str14 = str24;
                        str5 = "activityName";
                    } else {
                        Bundle bundle = deepLinkData2.f50290h;
                        String string2 = bundle.getString("screen", (String) null);
                        String string3 = bundle.getString("gameid", (String) null);
                        String string4 = bundle.getString("campaignid", (String) null);
                        String string5 = bundle.getString("offertag", (String) null);
                        String string6 = bundle.getString("showHomeOnBack", (String) null);
                        String string7 = bundle.getString(Utility.EVENT_CATEGORY_PROMOCODE, (String) null);
                        deepLinkData = deepLinkData2;
                        String string8 = bundle.getString("vouchercode", (String) null);
                        String str28 = string8;
                        str13 = string2;
                        str3 = string4;
                        str8 = bundle.getString("siteid", (String) null);
                        str2 = bundle.getString("stageNumber", (String) null);
                        str4 = bundle.getString("offerType", (String) null);
                        str10 = "";
                        str16 = string6;
                        str6 = string;
                        str18 = str10;
                        str11 = "campaignid";
                        str15 = string3;
                        str9 = str28;
                        str = "showHomeOnBack";
                        str17 = string5;
                        str7 = string7;
                        str5 = "activityName";
                        str12 = bundle.getString("source");
                        str14 = str18;
                    }
                    if (!TextUtils.isEmpty(str16)) {
                        str19 = str12;
                        str16.equalsIgnoreCase("false");
                    } else {
                        str19 = str12;
                    }
                    boolean z = !TextUtils.isEmpty(str14) && str14.equalsIgnoreCase("true");
                    if (!TextUtils.isEmpty(str13)) {
                        if (str13.equalsIgnoreCase("homescreen") || str13.equalsIgnoreCase("homescreenMerchant")) {
                            intent2 = new Intent(context2, AJRVIPCashBackActivity.class);
                            intent2.putExtra("KEY_FRAGMENT", 0);
                            intent2.putExtra("screen", str13);
                            intent2.putExtra("show_home_on_back", false);
                            if (str17 != null) {
                                intent2 = new Intent(context2, OfferListActivity.class);
                                intent2.putExtra("offertag", str17);
                                a.b.C0384a aVar3 = a.b.f20777a;
                                intent2.putExtra("offer_type_card", a.b.f20784h);
                            }
                        } else if (str13.equalsIgnoreCase("myoffers")) {
                            intent2 = new Intent(context2, AJRVIPCashBackActivity.class);
                            intent2.putExtra("screen", "homescreen");
                            intent2.putExtra("KEY_FRAGMENT", 1);
                            intent2.putExtra("show_home_on_back", true);
                        } else if (str13.equalsIgnoreCase("myvouchers")) {
                            intent2 = new Intent(context2, VoucherDealPagerActivity.class);
                            intent2.putExtra("KEY_FRAGMENT", 1);
                        } else {
                            if (str13.equalsIgnoreCase("history") || str13.equalsIgnoreCase("offerdetails") || str13.equalsIgnoreCase("completion") || str13.equalsIgnoreCase("supercampaigndetails")) {
                                String str29 = str;
                                String str30 = str11;
                                String str31 = str3;
                                intent3 = new Intent(context2, CashbackCompaignGameDetail.class);
                                if (!TextUtils.isEmpty(str15)) {
                                    intent3.putExtra("gameid", str15);
                                }
                                if (!TextUtils.isEmpty(str31)) {
                                    intent3.putExtra(str30, str31);
                                }
                                intent3.putExtra(str29, false);
                            } else if (str13.equalsIgnoreCase("topoffer") || str13.equalsIgnoreCase("campaigndetails")) {
                                String str32 = str;
                                String str33 = str11;
                                String str34 = str10;
                                String str35 = str5;
                                String str36 = str3;
                                intent2 = new Intent(context2, CashBackOfferDetailActivity.class);
                                if (!TextUtils.isEmpty(str36)) {
                                    intent2.putExtra(str33, str36);
                                }
                                intent2.putExtra(str32, false);
                                if (!TextUtils.isEmpty(str34)) {
                                    intent2.putExtra(str35, str34);
                                }
                            } else if (!str13.equalsIgnoreCase("voucherdetails")) {
                                String str37 = str8;
                                if (str13.equalsIgnoreCase("merchantCampaignDetail") || str13.equalsIgnoreCase("myOfferDetailMerchant")) {
                                    intent3 = new Intent(context2, MerchantCashbackOfferDetailActivity.class);
                                    intent3.putExtra(str11, str3);
                                    intent3.putExtra("gameid", str15);
                                    intent3.putExtra(str, false);
                                    intent3.putExtra("stageNumber", str2);
                                } else if (str13.equalsIgnoreCase("categoryNewOffers")) {
                                    intent2 = new Intent(context2, OfferListActivity.class);
                                    if (str17 != null) {
                                        intent2.putExtra("offertag", str17);
                                        intent2.putExtra("is_from_category", z);
                                        intent2.putExtra("header_image_url", str18);
                                        if (str19 == null || !str19.equalsIgnoreCase("cashbackLanding")) {
                                            String str38 = str5;
                                            if (!TextUtils.isEmpty(str10)) {
                                                intent2.putExtra(str38, str10);
                                            }
                                        } else {
                                            intent2.putExtra(str5, "net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity");
                                        }
                                    }
                                } else if (str13.equalsIgnoreCase("myvoucherdetails")) {
                                    intent2 = new Intent(context2, CashbackVoucherDetailsActivity.class);
                                    if (!TextUtils.isEmpty(str7)) {
                                        intent2.putExtra(Utility.EVENT_CATEGORY_PROMOCODE, str7);
                                        intent2.putExtra("siteid", str37);
                                    }
                                } else if (str13.equalsIgnoreCase("myscratchcards")) {
                                    intent2 = new Intent(context2, OfferListActivity.class);
                                    a.b.C0384a aVar4 = a.b.f20777a;
                                    intent2.putExtra("offer_type_card", a.b.j);
                                    intent2.putExtra("titleName", str6);
                                } else if (str13.equalsIgnoreCase("cashbacksummary") && !str4.isEmpty()) {
                                    intent2 = new Intent(context2, OfferListActivity.class);
                                    String str39 = str4;
                                    if (str39.equals("cashback")) {
                                        a.b.C0384a aVar5 = a.b.f20777a;
                                        i2 = a.b.f20778b;
                                    } else if (str39.equals("points")) {
                                        a.b.C0384a aVar6 = a.b.f20777a;
                                        i2 = a.b.f20779c;
                                    } else {
                                        i2 = 0;
                                    }
                                    intent2.putExtra("offer_type_card", i2);
                                } else if (str13.equalsIgnoreCase("appOpen")) {
                                    intent2 = new Intent(context2, AJRVIPCashBackActivity.class);
                                    intent2.putExtra("showScratchCardOnAppOPen", true);
                                } else {
                                    intent2 = null;
                                }
                            } else if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(str8)) {
                                intent3 = new Intent(context2, CashbackVoucherDetailsActivity.class);
                                intent3.putExtra(Utility.EVENT_CATEGORY_PROMOCODE, str9);
                                intent3.putExtra("siteid", str8);
                                intent3.putExtra("gameid", str15);
                            } else if (!TextUtils.isEmpty(str15)) {
                                intent2 = new Intent(context2, VoucherDealPagerActivity.class);
                                intent2.putExtra("KEY_FRAGMENT", 1);
                            } else {
                                return;
                            }
                            intent2 = intent3;
                        }
                        if (intent2 != null) {
                            if (deepLinkData.f50290h != null) {
                                intent2.addFlags(67108864);
                                intent2.addFlags(268435456);
                            }
                            context2.startActivity(intent2);
                            return;
                        }
                        Intent intent5 = new Intent(context2, AJRVIPCashBackActivity.class);
                        intent5.putExtra("screen", "homescreen");
                        intent5.putExtra("KEY_FRAGMENT", 0);
                        intent5.putExtra("show_home_on_back", true);
                        if (!(context2 instanceof Activity)) {
                            intent5.addFlags(268435456);
                        }
                        context2.startActivity(intent5);
                    }
                }
            } else if (deepLinkData2.f50290h != null || deepLinkData2.f50289g != null) {
                if ("paytmcoins".equals(deepLinkData2.f50284b)) {
                    context2.startActivity(new Intent(context2, PaytmCoinLandingActivity.class));
                } else if ("redeemcoins".equalsIgnoreCase(deepLinkData2.f50284b)) {
                    if (deepLinkData2.f50289g != null) {
                        Uri uri3 = deepLinkData2.f50289g;
                        str20 = uri3.getQueryParameter("flowType");
                        str21 = uri3.getQueryParameter("mId");
                    } else {
                        Bundle bundle2 = deepLinkData2.f50290h;
                        str20 = bundle2.getString("flowType");
                        str21 = bundle2.getString("mId");
                    }
                    if (TextUtils.isEmpty(str20)) {
                        context2.startActivity(new Intent(context2, PointsRewardListActivity.class));
                    } else if (str20.equalsIgnoreCase("merchant") && !TextUtils.isEmpty(str21)) {
                        Intent intent6 = new Intent(context2, PointsRewardListActivity.class);
                        intent6.putExtra("flowType", str20);
                        intent6.putExtra("mId", str21);
                        context2.startActivity(intent6);
                    } else if (str20.equalsIgnoreCase("merchant")) {
                        String stringFromGTM = net.one97.paytm.vipcashback.c.a.a().f20708b.getStringFromGTM("accept_payment_merchant_context");
                        if (!TextUtils.isEmpty(stringFromGTM)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-auth-ump", "umpapp-3754-36d-aqr-cn7");
                            hashMap.put("x-user-token", net.one97.paytm.vipcashback.c.a.a().f20708b.getSSOToken());
                            hashMap.put("Cookie", "XSRF-TOKEN=a182960c-acf5-49b8-8b43-0245577f32fd; SESSION=a9098618-be1a-4b27-8a73-e738cdffb361");
                            b bVar = new b();
                            bVar.f42879c = a.C0715a.GET;
                            bVar.f42880d = stringFromGTM;
                            bVar.f42882f = hashMap;
                            bVar.f42885i = new ContextResponse();
                            bVar.o = "PaytmCoinsDeepLinkHandler";
                            bVar.n = a.b.SILENT;
                            bVar.f42878b = a.c.CASHBACK;
                            bVar.f42877a = context2;
                            bVar.j = new com.paytm.network.listener.b(context2) {

                                /* renamed from: a */
                                final /* synthetic */ Context f16637a;

                                public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.coins.a.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes11.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.coins.a.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
                                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                
*/

                                public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.coins.a.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes11.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.coins.a.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
                                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                
*/
                            };
                            com.paytm.network.a l = bVar.l();
                            if (com.paytm.utility.a.m(context)) {
                                l.a();
                            }
                        }
                    }
                }
            }
        } else {
            Intent intent7 = new Intent(context2, AJRVIPCashBackActivity.class);
            intent7.putExtra("screen", "homescreen");
            intent7.putExtra("KEY_FRAGMENT", 0);
            intent7.putExtra("show_home_on_back", true);
            context2.startActivity(intent7);
        }
    }
}
