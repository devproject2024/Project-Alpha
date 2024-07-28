package net.one97.paytm.feed;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.feed.b.ab;
import net.one97.paytm.feed.b.ad;
import net.one97.paytm.feed.b.af;
import net.one97.paytm.feed.b.ah;
import net.one97.paytm.feed.b.aj;
import net.one97.paytm.feed.b.al;
import net.one97.paytm.feed.b.an;
import net.one97.paytm.feed.b.ap;
import net.one97.paytm.feed.b.ar;
import net.one97.paytm.feed.b.at;
import net.one97.paytm.feed.b.av;
import net.one97.paytm.feed.b.ax;
import net.one97.paytm.feed.b.az;
import net.one97.paytm.feed.b.bb;
import net.one97.paytm.feed.b.bd;
import net.one97.paytm.feed.b.bf;
import net.one97.paytm.feed.b.bh;
import net.one97.paytm.feed.b.bj;
import net.one97.paytm.feed.b.bl;
import net.one97.paytm.feed.b.bn;
import net.one97.paytm.feed.b.bp;
import net.one97.paytm.feed.b.br;
import net.one97.paytm.feed.b.bt;
import net.one97.paytm.feed.b.bv;
import net.one97.paytm.feed.b.bx;
import net.one97.paytm.feed.b.bz;
import net.one97.paytm.feed.b.cb;
import net.one97.paytm.feed.b.cd;
import net.one97.paytm.feed.b.cf;
import net.one97.paytm.feed.b.ch;
import net.one97.paytm.feed.b.cj;
import net.one97.paytm.feed.b.cl;
import net.one97.paytm.feed.b.cn;
import net.one97.paytm.feed.b.cp;
import net.one97.paytm.feed.b.cr;
import net.one97.paytm.feed.b.ct;
import net.one97.paytm.feed.b.cv;
import net.one97.paytm.feed.b.cx;
import net.one97.paytm.feed.b.cz;
import net.one97.paytm.feed.b.db;
import net.one97.paytm.feed.b.dd;
import net.one97.paytm.feed.b.df;
import net.one97.paytm.feed.b.f;
import net.one97.paytm.feed.b.h;
import net.one97.paytm.feed.b.j;
import net.one97.paytm.feed.b.l;
import net.one97.paytm.feed.b.n;
import net.one97.paytm.feed.b.p;
import net.one97.paytm.feed.b.r;
import net.one97.paytm.feed.b.t;
import net.one97.paytm.feed.b.v;
import net.one97.paytm.feed.b.x;
import net.one97.paytm.feed.b.z;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYPROFILEDISCOVER = 1;
    private static final int LAYOUT_FEEDBANNER = 2;
    private static final int LAYOUT_FEEDBANNERITEM = 3;
    private static final int LAYOUT_FEEDCHANNELGRIDVIEW = 4;
    private static final int LAYOUT_FEEDCHANNELITEM = 5;
    private static final int LAYOUT_FEEDCOMMENT = 6;
    private static final int LAYOUT_FEEDCOMMENTITEM = 7;
    private static final int LAYOUT_FEEDCOVERAGE = 8;
    private static final int LAYOUT_FEEDCRICKETSCORE = 9;
    private static final int LAYOUT_FEEDFEEDBACKACTIONLAYOUT = 10;
    private static final int LAYOUT_FEEDFRAGMENT = 11;
    private static final int LAYOUT_FEEDFULLSCREENVIDEOACTIVITY = 12;
    private static final int LAYOUT_FEEDGENERIC = 13;
    private static final int LAYOUT_FEEDGREETING = 14;
    private static final int LAYOUT_FEEDHIDEPOST = 15;
    private static final int LAYOUT_FEEDHIGHLIGHTS = 16;
    private static final int LAYOUT_FEEDLANGUAGE = 17;
    private static final int LAYOUT_FEEDLANGUAGEGRIDITEM = 18;
    private static final int LAYOUT_FEEDLIVETV = 21;
    private static final int LAYOUT_FEEDLIVETVCATEGORY = 19;
    private static final int LAYOUT_FEEDLIVETVCATEGORYITEM = 20;
    private static final int LAYOUT_FEEDMERCHANT = 22;
    private static final int LAYOUT_FEEDMERCHANTSTOREFRONT = 23;
    private static final int LAYOUT_FEEDMERCHANTSTOREFRONTITEM = 24;
    private static final int LAYOUT_FEEDNOINTERNETLAYOUT = 25;
    private static final int LAYOUT_FEEDPOLLS = 26;
    private static final int LAYOUT_FEEDPOSTERITEM = 27;
    private static final int LAYOUT_FEEDPROGRESS = 28;
    private static final int LAYOUT_FEEDPROVIDER = 29;
    private static final int LAYOUT_FEEDPROVIDERLANDING = 30;
    private static final int LAYOUT_FEEDPUBLISHER = 31;
    private static final int LAYOUT_FEEDPUBLISHERITEM = 32;
    private static final int LAYOUT_FEEDRECOMMENDED1ITEM = 33;
    private static final int LAYOUT_FEEDRECOMMENDED2ITEM = 34;
    private static final int LAYOUT_FEEDRECOMMENDEDAPPS = 36;
    private static final int LAYOUT_FEEDRECOMMENDEDAPPSV2 = 37;
    private static final int LAYOUT_FEEDRECOMMENDEDITEMSV2 = 35;
    private static final int LAYOUT_FEEDRECOMMENDEDPOSTS1 = 38;
    private static final int LAYOUT_FEEDRECOMMENDEDPOSTS2 = 39;
    private static final int LAYOUT_FEEDSHAREPOST = 40;
    private static final int LAYOUT_FEEDSHEROES = 41;
    private static final int LAYOUT_FEEDSTORIES = 42;
    private static final int LAYOUT_FEEDSTORYITEM = 43;
    private static final int LAYOUT_FEEDSTORYVIEW = 44;
    private static final int LAYOUT_FEEDTOOLBAR = 45;
    private static final int LAYOUT_FEEDTOPVIDEO = 47;
    private static final int LAYOUT_FEEDTOPVIDEOITEM = 46;
    private static final int LAYOUT_FEEDTRAINPNR = 48;
    private static final int LAYOUT_FEEDTRAINPNRSTATUS = 49;
    private static final int LAYOUT_FEEDTVCATEGORY = 50;
    private static final int LAYOUT_FEEDVIDEO = 51;
    private static final int LAYOUT_FEEDWEATHER = 52;
    private static final int LAYOUT_RECOMMENDEDITEMS = 53;
    private static final int LAYOUT_VIEWHOLDERBOOKMARK = 54;
    private static final int LAYOUT_VIEWHOLDERFOLLOWING = 55;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(55);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_profile_discover, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_banner, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_banner_item, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_channel_grid_view, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_channel_item, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_comment, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_comment_item, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_coverage, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_cricket_score, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_feedback_action_layout, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_fragment, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_fullscreen_video_activity, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_generic, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_greeting, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_hide_post, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_highlights, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_language, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_language_grid_item, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_live_tv_category, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_live_tv_category_item, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_livetv, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_merchant, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_merchant_storefront, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_merchant_storefront_item, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_no_internet_layout, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_polls, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_poster_item, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_progress, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_provider, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_provider_landing, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_publisher, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_publisher_item, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommended_1_item, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommended_2_item, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommended_items_v2, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommendedapps, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommendedapps_v2, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommendedposts_1, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_recommendedposts_2, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_share_post, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_sheroes, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_stories, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_story_item, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_storyview, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_toolbar, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_top_video_item, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_topvideo, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_train_pnr, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_train_pnr_status, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_tv_category, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_video, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.feed_weather, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.recommended_items, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.view_holder_bookmark, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.view_holder_following, 55);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/activity_profile_discover_0".equals(obj)) {
                    return new net.one97.paytm.feed.b.b(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_profile_discover is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/feed_banner_0".equals(obj)) {
                    return new net.one97.paytm.feed.b.d(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/feed_banner_item_0".equals(obj)) {
                    return new f(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_banner_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/feed_channel_grid_view_0".equals(obj)) {
                    return new h(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_channel_grid_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/feed_channel_item_0".equals(obj)) {
                    return new j(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_channel_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/feed_comment_0".equals(obj)) {
                    return new l(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_comment is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/feed_comment_item_0".equals(obj)) {
                    return new n(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_comment_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/feed_coverage_0".equals(obj)) {
                    return new p(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_coverage is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/feed_cricket_score_0".equals(obj)) {
                    return new r(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_cricket_score is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/feed_feedback_action_layout_0".equals(obj)) {
                    return new t(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_feedback_action_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/feed_fragment_0".equals(obj)) {
                    return new v(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/feed_fullscreen_video_activity_0".equals(obj)) {
                    return new x(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_fullscreen_video_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/feed_generic_0".equals(obj)) {
                    return new z(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_generic is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/feed_greeting_0".equals(obj)) {
                    return new ab(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_greeting is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/feed_hide_post_0".equals(obj)) {
                    return new ad(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_hide_post is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/feed_highlights_0".equals(obj)) {
                    return new af(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_highlights is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/feed_language_0".equals(obj)) {
                    return new ah(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_language is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/feed_language_grid_item_0".equals(obj)) {
                    return new aj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_language_grid_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/feed_live_tv_category_0".equals(obj)) {
                    return new al(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_live_tv_category is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/feed_live_tv_category_item_0".equals(obj)) {
                    return new an(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_live_tv_category_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/feed_livetv_0".equals(obj)) {
                    return new ap(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_livetv is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/feed_merchant_0".equals(obj)) {
                    return new ar(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_merchant is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/feed_merchant_storefront_0".equals(obj)) {
                    return new at(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_merchant_storefront is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/feed_merchant_storefront_item_0".equals(obj)) {
                    return new av(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_merchant_storefront_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/feed_no_internet_layout_0".equals(obj)) {
                    return new ax(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_no_internet_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/feed_polls_0".equals(obj)) {
                    return new az(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_polls is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/feed_poster_item_0".equals(obj)) {
                    return new bb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_poster_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/feed_progress_0".equals(obj)) {
                    return new bd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_progress is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/feed_provider_0".equals(obj)) {
                    return new bf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_provider is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/feed_provider_landing_0".equals(obj)) {
                    return new bh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_provider_landing is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/feed_publisher_0".equals(obj)) {
                    return new bj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_publisher is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/feed_publisher_item_0".equals(obj)) {
                    return new bl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_publisher_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/feed_recommended_1_item_0".equals(obj)) {
                    return new bn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommended_1_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/feed_recommended_2_item_0".equals(obj)) {
                    return new bp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommended_2_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/feed_recommended_items_v2_0".equals(obj)) {
                    return new br(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommended_items_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/feed_recommendedapps_0".equals(obj)) {
                    return new bt(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommendedapps is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/feed_recommendedapps_v2_0".equals(obj)) {
                    return new bv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommendedapps_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/feed_recommendedposts_1_0".equals(obj)) {
                    return new bx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommendedposts_1 is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/feed_recommendedposts_2_0".equals(obj)) {
                    return new bz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_recommendedposts_2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/feed_share_post_0".equals(obj)) {
                    return new cb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_share_post is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/feed_sheroes_0".equals(obj)) {
                    return new cd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_sheroes is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/feed_stories_0".equals(obj)) {
                    return new cf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_stories is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/feed_story_item_0".equals(obj)) {
                    return new ch(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_story_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/feed_storyview_0".equals(obj)) {
                    return new cj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_storyview is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/feed_toolbar_0".equals(obj)) {
                    return new cl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_toolbar is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/feed_top_video_item_0".equals(obj)) {
                    return new cn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_top_video_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/feed_topvideo_0".equals(obj)) {
                    return new cp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_topvideo is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/feed_train_pnr_0".equals(obj)) {
                    return new cr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_train_pnr is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/feed_train_pnr_status_0".equals(obj)) {
                    return new ct(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_train_pnr_status is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/feed_tv_category_0".equals(obj)) {
                    return new cv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_tv_category is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/feed_video_0".equals(obj)) {
                    return new cx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_video is invalid. Received: ".concat(String.valueOf(obj)));
            case 52:
                if ("layout/feed_weather_0".equals(obj)) {
                    return new cz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for feed_weather is invalid. Received: ".concat(String.valueOf(obj)));
            case 53:
                if ("layout/recommended_items_0".equals(obj)) {
                    return new db(eVar, view);
                }
                throw new IllegalArgumentException("The tag for recommended_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 54:
                if ("layout/view_holder_bookmark_0".equals(obj)) {
                    return new dd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for view_holder_bookmark is invalid. Received: ".concat(String.valueOf(obj)));
            case 55:
                if ("layout/view_holder_following_0".equals(obj)) {
                    return new df(eVar, view);
                }
                throw new IllegalArgumentException("The tag for view_holder_following is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i4 = (i3 - 1) / 50;
            if (i4 == 0) {
                return internalGetViewDataBinding0(eVar, view, i3, tag);
            }
            if (i4 != 1) {
                return null;
            }
            return internalGetViewDataBinding1(eVar, view, i3, tag);
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f33773a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f33772a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f33772a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(36);
            f33772a = sparseArray;
            sparseArray.put(0, "_all");
            f33772a.put(1, "handler");
            f33772a.put(2, "data");
            f33772a.put(3, "viewAllUrl");
            f33772a.put(4, "bg");
            f33772a.put(5, "listener");
            f33772a.put(6, CLConstants.FIELD_ERROR_CODE);
            f33772a.put(7, "update");
            f33772a.put(8, "source");
            f33772a.put(9, "title");
            f33772a.put(10, "error");
            f33772a.put(11, "empty");
            f33772a.put(12, "storyCardPosition");
            f33772a.put(13, "actionsViewModel");
            f33772a.put(14, "blocked");
            f33772a.put(15, "feedCommentViewModel");
            f33772a.put(16, "loggedin");
            f33772a.put(17, "isKenburn");
            f33772a.put(18, "progressVisibility");
            f33772a.put(19, "pipe");
            f33772a.put(20, "messageToSend");
            f33772a.put(21, "vote");
            f33772a.put(22, "messageEmpty");
            f33772a.put(23, "item");
            f33772a.put(24, "feedViewModel");
            f33772a.put(25, "visibility");
            f33772a.put(26, "commentactivity");
            f33772a.put(27, "sensitive");
            f33772a.put(28, "url");
            f33772a.put(29, "merchantStoreFrontViewModel");
            f33772a.put(30, "viewModel");
            f33772a.put(31, H5Logger.HEADER);
            f33772a.put(32, CLPConstants.ARGUMENT_KEY_POSITION);
            f33772a.put(33, "feedhidden");
            f33772a.put(34, "handlerComment");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f33773a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(55);
            f33773a = hashMap;
            hashMap.put("layout/activity_profile_discover_0", Integer.valueOf(R.layout.activity_profile_discover));
            f33773a.put("layout/feed_banner_0", Integer.valueOf(R.layout.feed_banner));
            f33773a.put("layout/feed_banner_item_0", Integer.valueOf(R.layout.feed_banner_item));
            f33773a.put("layout/feed_channel_grid_view_0", Integer.valueOf(R.layout.feed_channel_grid_view));
            f33773a.put("layout/feed_channel_item_0", Integer.valueOf(R.layout.feed_channel_item));
            f33773a.put("layout/feed_comment_0", Integer.valueOf(R.layout.feed_comment));
            f33773a.put("layout/feed_comment_item_0", Integer.valueOf(R.layout.feed_comment_item));
            f33773a.put("layout/feed_coverage_0", Integer.valueOf(R.layout.feed_coverage));
            f33773a.put("layout/feed_cricket_score_0", Integer.valueOf(R.layout.feed_cricket_score));
            f33773a.put("layout/feed_feedback_action_layout_0", Integer.valueOf(R.layout.feed_feedback_action_layout));
            f33773a.put("layout/feed_fragment_0", Integer.valueOf(R.layout.feed_fragment));
            f33773a.put("layout/feed_fullscreen_video_activity_0", Integer.valueOf(R.layout.feed_fullscreen_video_activity));
            f33773a.put("layout/feed_generic_0", Integer.valueOf(R.layout.feed_generic));
            f33773a.put("layout/feed_greeting_0", Integer.valueOf(R.layout.feed_greeting));
            f33773a.put("layout/feed_hide_post_0", Integer.valueOf(R.layout.feed_hide_post));
            f33773a.put("layout/feed_highlights_0", Integer.valueOf(R.layout.feed_highlights));
            f33773a.put("layout/feed_language_0", Integer.valueOf(R.layout.feed_language));
            f33773a.put("layout/feed_language_grid_item_0", Integer.valueOf(R.layout.feed_language_grid_item));
            f33773a.put("layout/feed_live_tv_category_0", Integer.valueOf(R.layout.feed_live_tv_category));
            f33773a.put("layout/feed_live_tv_category_item_0", Integer.valueOf(R.layout.feed_live_tv_category_item));
            f33773a.put("layout/feed_livetv_0", Integer.valueOf(R.layout.feed_livetv));
            f33773a.put("layout/feed_merchant_0", Integer.valueOf(R.layout.feed_merchant));
            f33773a.put("layout/feed_merchant_storefront_0", Integer.valueOf(R.layout.feed_merchant_storefront));
            f33773a.put("layout/feed_merchant_storefront_item_0", Integer.valueOf(R.layout.feed_merchant_storefront_item));
            f33773a.put("layout/feed_no_internet_layout_0", Integer.valueOf(R.layout.feed_no_internet_layout));
            f33773a.put("layout/feed_polls_0", Integer.valueOf(R.layout.feed_polls));
            f33773a.put("layout/feed_poster_item_0", Integer.valueOf(R.layout.feed_poster_item));
            f33773a.put("layout/feed_progress_0", Integer.valueOf(R.layout.feed_progress));
            f33773a.put("layout/feed_provider_0", Integer.valueOf(R.layout.feed_provider));
            f33773a.put("layout/feed_provider_landing_0", Integer.valueOf(R.layout.feed_provider_landing));
            f33773a.put("layout/feed_publisher_0", Integer.valueOf(R.layout.feed_publisher));
            f33773a.put("layout/feed_publisher_item_0", Integer.valueOf(R.layout.feed_publisher_item));
            f33773a.put("layout/feed_recommended_1_item_0", Integer.valueOf(R.layout.feed_recommended_1_item));
            f33773a.put("layout/feed_recommended_2_item_0", Integer.valueOf(R.layout.feed_recommended_2_item));
            f33773a.put("layout/feed_recommended_items_v2_0", Integer.valueOf(R.layout.feed_recommended_items_v2));
            f33773a.put("layout/feed_recommendedapps_0", Integer.valueOf(R.layout.feed_recommendedapps));
            f33773a.put("layout/feed_recommendedapps_v2_0", Integer.valueOf(R.layout.feed_recommendedapps_v2));
            f33773a.put("layout/feed_recommendedposts_1_0", Integer.valueOf(R.layout.feed_recommendedposts_1));
            f33773a.put("layout/feed_recommendedposts_2_0", Integer.valueOf(R.layout.feed_recommendedposts_2));
            f33773a.put("layout/feed_share_post_0", Integer.valueOf(R.layout.feed_share_post));
            f33773a.put("layout/feed_sheroes_0", Integer.valueOf(R.layout.feed_sheroes));
            f33773a.put("layout/feed_stories_0", Integer.valueOf(R.layout.feed_stories));
            f33773a.put("layout/feed_story_item_0", Integer.valueOf(R.layout.feed_story_item));
            f33773a.put("layout/feed_storyview_0", Integer.valueOf(R.layout.feed_storyview));
            f33773a.put("layout/feed_toolbar_0", Integer.valueOf(R.layout.feed_toolbar));
            f33773a.put("layout/feed_top_video_item_0", Integer.valueOf(R.layout.feed_top_video_item));
            f33773a.put("layout/feed_topvideo_0", Integer.valueOf(R.layout.feed_topvideo));
            f33773a.put("layout/feed_train_pnr_0", Integer.valueOf(R.layout.feed_train_pnr));
            f33773a.put("layout/feed_train_pnr_status_0", Integer.valueOf(R.layout.feed_train_pnr_status));
            f33773a.put("layout/feed_tv_category_0", Integer.valueOf(R.layout.feed_tv_category));
            f33773a.put("layout/feed_video_0", Integer.valueOf(R.layout.feed_video));
            f33773a.put("layout/feed_weather_0", Integer.valueOf(R.layout.feed_weather));
            f33773a.put("layout/recommended_items_0", Integer.valueOf(R.layout.recommended_items));
            f33773a.put("layout/view_holder_bookmark_0", Integer.valueOf(R.layout.view_holder_bookmark));
            f33773a.put("layout/view_holder_following_0", Integer.valueOf(R.layout.view_holder_following));
        }
    }
}
