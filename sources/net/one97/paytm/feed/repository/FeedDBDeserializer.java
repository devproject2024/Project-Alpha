package net.one97.paytm.feed.repository;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.u;
import net.one97.paytm.feed.b;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.livetv.FeedLiveTVData;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFrontData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedDbData;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedAppsData;
import net.one97.paytm.feed.repository.models.stories.StoryData;
import net.one97.paytm.feed.ui.feed.FeedFragment;

public final class FeedDBDeserializer implements k<FeedDataMinimal> {

    /* renamed from: a  reason: collision with root package name */
    private final String f34349a = "cardType";

    /* renamed from: b  reason: collision with root package name */
    private final String f34350b = "cardData";

    /* renamed from: c  reason: collision with root package name */
    private final String f34351c = "score";

    /* renamed from: d  reason: collision with root package name */
    private final String f34352d = "buckets";

    /* renamed from: e  reason: collision with root package name */
    private final String f34353e = "mlVersion";

    /* renamed from: f  reason: collision with root package name */
    private final String f34354f = "contentFormat";

    /* renamed from: g  reason: collision with root package name */
    private final String f34355g = "mlCategory";

    /* renamed from: h  reason: collision with root package name */
    private final String f34356h = "";

    /* renamed from: i  reason: collision with root package name */
    private final String f34357i = "animationOn";
    private final Context j;

    public FeedDBDeserializer(Context context) {
        kotlin.g.b.k.c(context, "ctx");
        this.j = context;
    }

    public final /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
        return a(lVar, jVar);
    }

    private FeedDataMinimal a(l lVar, j jVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        j jVar2 = jVar;
        if (lVar == null) {
            kotlin.g.b.k.a();
        }
        o h2 = lVar.h();
        l b2 = h2.b(this.f34349a);
        kotlin.g.b.k.a((Object) b2, "jsonObject.get(FEEDITEMTYPE)");
        String c2 = b2.c();
        l b3 = h2.b(this.f34350b);
        if (b3 != null) {
            o e2 = ((o) b3).e("mlProperties");
            l b4 = e2.b(this.f34352d);
            if (b4 == null || (b4 instanceof n)) {
                str = this.f34356h;
            } else {
                str = b4.c();
            }
            String str6 = str;
            l b5 = e2.b(this.f34351c);
            double d2 = (b5 == null || (b5 instanceof n)) ? 0.0d : b5.d();
            l b6 = e2.b(this.f34353e);
            if (b6 == null || (b6 instanceof n)) {
                str2 = this.f34356h;
            } else {
                str2 = b6.c();
            }
            String str7 = str2;
            l b7 = e2.b(this.f34354f);
            if (b7 == null || (b7 instanceof n)) {
                str3 = this.f34356h;
            } else {
                str3 = b7.c();
            }
            String str8 = str3;
            l b8 = e2.b(this.f34355g);
            if (b8 == null || (b8 instanceof n)) {
                str4 = this.f34356h;
            } else {
                str4 = b8.c();
            }
            String str9 = str4;
            if (jVar2 == null) {
                kotlin.g.b.k.a();
            }
            Object a2 = jVar2.a(h2.b(this.f34350b), FeedDataMinimal.class);
            if (a2 != null) {
                FeedDataMinimal feedDataMinimal = (FeedDataMinimal) a2;
                b bVar = b.f33792d;
                String a3 = b.a();
                FeedFragment.a aVar = FeedFragment.f34877i;
                if (kotlin.g.b.k.a((Object) a3, (Object) FeedFragment.z)) {
                    b bVar2 = b.f33792d;
                    feedDataMinimal.setFeedItemRank(b.q());
                } else {
                    b bVar3 = b.f33792d;
                    String a4 = b.a();
                    FeedFragment.a aVar2 = FeedFragment.f34877i;
                    if (kotlin.g.b.k.a((Object) a4, (Object) FeedFragment.B)) {
                        b bVar4 = b.f33792d;
                        feedDataMinimal.setProfileRank(b.s());
                    } else {
                        b bVar5 = b.f33792d;
                        String a5 = b.a();
                        FeedFragment.a aVar3 = FeedFragment.f34877i;
                        if (kotlin.g.b.k.a((Object) a5, (Object) FeedFragment.C)) {
                            b bVar6 = b.f33792d;
                            feedDataMinimal.setFollowingRank(b.t());
                        }
                    }
                }
                kotlin.g.b.k.a((Object) c2, "type");
                feedDataMinimal.setFeedItemType(c2);
                b bVar7 = b.f33792d;
                String a6 = b.a();
                FeedFragment.a aVar4 = FeedFragment.f34877i;
                if (kotlin.g.b.k.a((Object) a6, (Object) FeedFragment.A) && feedDataMinimal.getCommentList() != null) {
                    for (CommentResponse feedItemType : feedDataMinimal.getCommentList()) {
                        feedItemType.setFeedItemType(net.one97.paytm.feed.utility.k.COMMENTS.getType());
                    }
                    a aVar5 = a.f34359b;
                    List<CommentResponse> commentList = feedDataMinimal.getCommentList();
                    if (commentList != null) {
                        a.a((ArrayList<CommentResponse>) (ArrayList) commentList);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.feed.repository.models.comment.CommentResponse> /* = java.util.ArrayList<net.one97.paytm.feed.repository.models.comment.CommentResponse> */");
                    }
                }
                String str10 = "null cannot be cast to non-null type net.one97.paytm.feed.repository.models.FeedDataMinimal";
                if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType())) {
                    if (!TextUtils.isEmpty(feedDataMinimal.getStreamUrl())) {
                        feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.VIDEOS.getType());
                    } else {
                        feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.GENERIC.getType());
                    }
                    kotlin.g.b.k.a((Object) str6, "buckets");
                    kotlin.g.b.k.a((Object) str7, "mlVersion");
                    kotlin.g.b.k.a((Object) str8, "contentFormat");
                    kotlin.g.b.k.a((Object) str9, "category");
                    a(feedDataMinimal, str6, d2, str7, str8, str9);
                    return feedDataMinimal;
                }
                double d3 = d2;
                if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType()) || kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS_2.getType())) {
                    String str11 = "null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedDbData";
                    l b9 = h2.b(this.f34350b);
                    if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                        feedDataMinimal.setId(net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType() + System.currentTimeMillis());
                    }
                    Object a7 = jVar2.a(b9, NestedFeedDbData.class);
                    if (a7 != null) {
                        feedDataMinimal.recommendedList = ((NestedFeedDbData) a7).getGenericPostList();
                        b bVar8 = b.f33792d;
                        String a8 = b.a();
                        FeedFragment.a aVar6 = FeedFragment.f34877i;
                        if (kotlin.g.b.k.a((Object) a8, (Object) FeedFragment.z)) {
                            b bVar9 = b.f33792d;
                            feedDataMinimal.setFeedItemRank(b.q());
                        } else {
                            b bVar10 = b.f33792d;
                            feedDataMinimal.setFeedItemCategoryRank(b.r());
                        }
                        kotlin.g.b.k.a((Object) str6, "buckets");
                        kotlin.g.b.k.a((Object) str7, "mlVersion");
                        kotlin.g.b.k.a((Object) str8, "contentFormat");
                        kotlin.g.b.k.a((Object) str9, "category");
                        a(feedDataMinimal, str6, d3, str7, str8, str9);
                        return feedDataMinimal;
                    }
                    throw new u(str11);
                } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.BANNERS.getType())) {
                    l b10 = h2.b(this.f34350b);
                    if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(net.one97.paytm.feed.utility.k.BANNERS.getType());
                        sb.append("|");
                        str5 = "null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedDbData";
                        sb.append(System.currentTimeMillis());
                        feedDataMinimal.setId(sb.toString());
                    } else {
                        str5 = "null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedDbData";
                    }
                    Object a9 = jVar2.a(b10, NestedFeedDbData.class);
                    if (a9 != null) {
                        feedDataMinimal.recommendedList = ((NestedFeedDbData) a9).getGenericPostList();
                        b bVar11 = b.f33792d;
                        String a10 = b.a();
                        FeedFragment.a aVar7 = FeedFragment.f34877i;
                        if (kotlin.g.b.k.a((Object) a10, (Object) FeedFragment.z)) {
                            b bVar12 = b.f33792d;
                            feedDataMinimal.setFeedItemRank(b.q());
                        } else {
                            b bVar13 = b.f33792d;
                            feedDataMinimal.setFeedItemCategoryRank(b.r());
                        }
                        kotlin.g.b.k.a((Object) str6, "buckets");
                        kotlin.g.b.k.a((Object) str7, "mlVersion");
                        kotlin.g.b.k.a((Object) str8, "contentFormat");
                        kotlin.g.b.k.a((Object) str9, "category");
                        a(feedDataMinimal, str6, d3, str7, str8, str9);
                        return feedDataMinimal;
                    }
                    throw new u(str5);
                } else {
                    String str12 = "null cannot be cast to non-null type net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedDbData";
                    if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.POSTER.getType())) {
                        l b11 = h2.b(this.f34350b);
                        if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                            feedDataMinimal.setId(net.one97.paytm.feed.utility.k.POSTER.getType() + "|" + System.currentTimeMillis());
                        }
                        Object a11 = jVar2.a(b11, NestedFeedDbData.class);
                        if (a11 != null) {
                            feedDataMinimal.recommendedList = ((NestedFeedDbData) a11).getGenericPostList();
                            b bVar14 = b.f33792d;
                            String a12 = b.a();
                            FeedFragment.a aVar8 = FeedFragment.f34877i;
                            if (kotlin.g.b.k.a((Object) a12, (Object) FeedFragment.z)) {
                                b bVar15 = b.f33792d;
                                feedDataMinimal.setFeedItemRank(b.q());
                            } else {
                                b bVar16 = b.f33792d;
                                feedDataMinimal.setFeedItemCategoryRank(b.r());
                            }
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        }
                        throw new u(str12);
                    } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.PUBLISHER.getType())) {
                        l b12 = h2.b(this.f34350b);
                        if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                            feedDataMinimal.setId(net.one97.paytm.feed.utility.k.PUBLISHER.getType() + "|" + System.currentTimeMillis());
                        }
                        Object a13 = jVar2.a(b12, NestedFeedDbData.class);
                        if (a13 != null) {
                            feedDataMinimal.recommendedList = ((NestedFeedDbData) a13).getGenericPostList();
                            b bVar17 = b.f33792d;
                            String a14 = b.a();
                            FeedFragment.a aVar9 = FeedFragment.f34877i;
                            if (kotlin.g.b.k.a((Object) a14, (Object) FeedFragment.z)) {
                                b bVar18 = b.f33792d;
                                feedDataMinimal.setFeedItemRank(b.q());
                            } else {
                                b bVar19 = b.f33792d;
                                feedDataMinimal.setFeedItemCategoryRank(b.r());
                            }
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        }
                        throw new u(str12);
                    } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.TOPVIDEOS.getType())) {
                        l b13 = h2.b(this.f34350b);
                        if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                            feedDataMinimal.setId(net.one97.paytm.feed.utility.k.TOPVIDEOS.getType() + "|" + System.currentTimeMillis());
                        }
                        Object a15 = jVar2.a(b13, NestedFeedDbData.class);
                        if (a15 != null) {
                            feedDataMinimal.recommendedList = ((NestedFeedDbData) a15).getGenericPostList();
                            b bVar20 = b.f33792d;
                            String a16 = b.a();
                            FeedFragment.a aVar10 = FeedFragment.f34877i;
                            if (kotlin.g.b.k.a((Object) a16, (Object) FeedFragment.z)) {
                                b bVar21 = b.f33792d;
                                feedDataMinimal.setFeedItemRank(b.q());
                            } else {
                                b bVar22 = b.f33792d;
                                feedDataMinimal.setFeedItemCategoryRank(b.r());
                            }
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        }
                        throw new u(str12);
                    } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.COVERAGE.getType())) {
                        try {
                            l b14 = h2.b(this.f34357i);
                            kotlin.g.b.k.a((Object) b14, "jsonObject.get(ISKENBURN)");
                            boolean g2 = b14.g();
                            net.one97.paytm.feed.e.b bVar23 = net.one97.paytm.feed.e.b.f34268c;
                            net.one97.paytm.feed.e.b.e(g2);
                        } catch (Exception unused) {
                        }
                        l b15 = h2.b(this.f34350b);
                        if (TextUtils.isEmpty(feedDataMinimal.getId())) {
                            feedDataMinimal.setId(net.one97.paytm.feed.utility.k.COVERAGE.getType() + System.currentTimeMillis());
                        }
                        Object a17 = jVar2.a(b15, NestedFeedDbData.class);
                        if (a17 != null) {
                            feedDataMinimal.recommendedList = ((NestedFeedDbData) a17).getGenericPostList();
                            b bVar24 = b.f33792d;
                            String a18 = b.a();
                            FeedFragment.a aVar11 = FeedFragment.f34877i;
                            if (kotlin.g.b.k.a((Object) a18, (Object) FeedFragment.z)) {
                                b bVar25 = b.f33792d;
                                feedDataMinimal.setFeedItemRank(b.q());
                            } else {
                                b bVar26 = b.f33792d;
                                feedDataMinimal.setFeedItemCategoryRank(b.r());
                            }
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        }
                        throw new u(str12);
                    } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType())) {
                        l b16 = h2.b(this.f34350b);
                        Object a19 = jVar2.a(b16, FeedDataMinimal.class);
                        if (a19 != null) {
                            FeedDataMinimal feedDataMinimal2 = (FeedDataMinimal) a19;
                            Object a20 = jVar2.a(b16, FeedLiveTVData.class);
                            if (a20 != null) {
                                feedDataMinimal2.setFeedItemType(net.one97.paytm.feed.utility.k.LIVETV.getType());
                                feedDataMinimal2.channelList = ((FeedLiveTVData) a20).getChannels();
                                b bVar27 = b.f33792d;
                                String a21 = b.a();
                                FeedFragment.a aVar12 = FeedFragment.f34877i;
                                if (kotlin.g.b.k.a((Object) a21, (Object) FeedFragment.z)) {
                                    b bVar28 = b.f33792d;
                                    feedDataMinimal2.setFeedItemRank(b.q());
                                } else {
                                    b bVar29 = b.f33792d;
                                    feedDataMinimal2.setFeedItemCategoryRank(b.r());
                                }
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal2, str6, d3, str7, str8, str9);
                                return feedDataMinimal2;
                            }
                            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.livetv.FeedLiveTVData");
                        }
                        throw new u(str10);
                    } else {
                        String str13 = str10;
                        if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType())) {
                            feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.SHEROES.getType());
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                            feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType());
                            b bVar30 = b.f33792d;
                            String a22 = b.a();
                            FeedFragment.a aVar13 = FeedFragment.f34877i;
                            if (kotlin.g.b.k.a((Object) a22, (Object) FeedFragment.z)) {
                                b bVar31 = b.f33792d;
                                feedDataMinimal.setFeedItemRank(b.q());
                            } else {
                                b bVar32 = b.f33792d;
                                feedDataMinimal.setFeedItemCategoryRank(b.r());
                            }
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            return feedDataMinimal;
                        } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType())) {
                            l b17 = h2.b(this.f34350b);
                            Object a23 = jVar2.a(b17, FeedDataMinimal.class);
                            if (a23 != null) {
                                FeedDataMinimal feedDataMinimal3 = (FeedDataMinimal) a23;
                                Object a24 = jVar2.a(b17, FeedMerchantStoreFrontData.class);
                                if (a24 != null) {
                                    feedDataMinimal3.setFeedItemType(net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType());
                                    feedDataMinimal3.brands = ((FeedMerchantStoreFrontData) a24).getBrands();
                                    b bVar33 = b.f33792d;
                                    String a25 = b.a();
                                    FeedFragment.a aVar14 = FeedFragment.f34877i;
                                    if (kotlin.g.b.k.a((Object) a25, (Object) FeedFragment.z)) {
                                        b bVar34 = b.f33792d;
                                        feedDataMinimal3.setFeedItemRank(b.q());
                                    } else {
                                        b bVar35 = b.f33792d;
                                        feedDataMinimal3.setFeedItemCategoryRank(b.r());
                                    }
                                    kotlin.g.b.k.a((Object) str6, "buckets");
                                    kotlin.g.b.k.a((Object) str7, "mlVersion");
                                    kotlin.g.b.k.a((Object) str8, "contentFormat");
                                    kotlin.g.b.k.a((Object) str9, "category");
                                    a(feedDataMinimal3, str6, d3, str7, str8, str9);
                                    return feedDataMinimal3;
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFrontData");
                            }
                            throw new u(str13);
                        } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                            feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.SCORECARD.getType());
                            kotlin.g.b.k.a((Object) str6, "buckets");
                            kotlin.g.b.k.a((Object) str7, "mlVersion");
                            kotlin.g.b.k.a((Object) str8, "contentFormat");
                            kotlin.g.b.k.a((Object) str9, "category");
                            a(feedDataMinimal, str6, d3, str7, str8, str9);
                            feedDataMinimal.setId(net.one97.paytm.feed.utility.k.SCORECARD.getType() + System.currentTimeMillis());
                            return feedDataMinimal;
                        } else {
                            if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType())) {
                                Object a26 = jVar2.a(h2.b(this.f34350b), FeedRecommendedAppsData.class);
                                if (a26 != null) {
                                    feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType());
                                    feedDataMinimal.recommendedAppsList = ((FeedRecommendedAppsData) a26).getAppsList();
                                    b bVar36 = b.f33792d;
                                    String a27 = b.a();
                                    FeedFragment.a aVar15 = FeedFragment.f34877i;
                                    if (kotlin.g.b.k.a((Object) a27, (Object) FeedFragment.z)) {
                                        b bVar37 = b.f33792d;
                                        feedDataMinimal.setFeedItemRank(b.q());
                                    } else {
                                        b bVar38 = b.f33792d;
                                        feedDataMinimal.setFeedItemCategoryRank(b.r());
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedAppsData");
                                }
                            } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.WEATHERCARD.getType())) {
                                feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.WEATHERCARD.getType());
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal, str6, d3, str7, str8, str9);
                                feedDataMinimal.setId(net.one97.paytm.feed.utility.k.WEATHERCARD.getType() + System.currentTimeMillis());
                                return feedDataMinimal;
                            } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.GREETING.getType())) {
                                feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.GREETING.getType());
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal, str6, d3, str7, str8, str9);
                                feedDataMinimal.setId(net.one97.paytm.feed.utility.k.GREETING.getType() + System.currentTimeMillis());
                                return feedDataMinimal;
                            } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
                                try {
                                    l b18 = h2.b(this.f34357i);
                                    kotlin.g.b.k.a((Object) b18, "jsonObject.get(ISKENBURN)");
                                    boolean g3 = b18.g();
                                    net.one97.paytm.feed.e.b bVar39 = net.one97.paytm.feed.e.b.f34268c;
                                    net.one97.paytm.feed.e.b.d(g3);
                                } catch (Exception unused2) {
                                }
                                feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType());
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal, str6, d3, str7, str8, str9);
                                return feedDataMinimal;
                            } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.STORIES.getType())) {
                                feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.STORIES.getType());
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal, str6, d3, str7, str8, str9);
                                Object a28 = jVar2.a(h2.b(this.f34350b), StoryData.class);
                                if (a28 != null) {
                                    feedDataMinimal.storiesList = ((StoryData) a28).getStoryList();
                                    return feedDataMinimal;
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.stories.StoryData");
                            } else if (kotlin.g.b.k.a((Object) c2, (Object) net.one97.paytm.feed.utility.k.POLLS.getType())) {
                                feedDataMinimal.setFeedItemType(net.one97.paytm.feed.utility.k.POLLS.getType());
                                kotlin.g.b.k.a((Object) str6, "buckets");
                                kotlin.g.b.k.a((Object) str7, "mlVersion");
                                kotlin.g.b.k.a((Object) str8, "contentFormat");
                                kotlin.g.b.k.a((Object) str9, "category");
                                a(feedDataMinimal, str6, d3, str7, str8, str9);
                                Object a29 = jVar2.a(h2.b(this.f34350b), Polls.class);
                                if (a29 != null) {
                                    Polls polls = (Polls) a29;
                                    feedDataMinimal.pollsList = polls.getPollsList();
                                    feedDataMinimal.setLogoUrl(polls.getLogoUrl());
                                    return feedDataMinimal;
                                }
                                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.polls.Polls");
                            }
                            return feedDataMinimal;
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.FeedDataMinimal");
            }
        } else {
            throw new u("null cannot be cast to non-null type com.google.gson.JsonObject");
        }
    }

    private static void a(FeedDataMinimal feedDataMinimal, String str, double d2, String str2, String str3, String str4) {
        feedDataMinimal.setBuckets(str);
        feedDataMinimal.setScore(d2);
        feedDataMinimal.setMlVersion(str2);
        feedDataMinimal.setContentFormat(str3);
        feedDataMinimal.setMlCategory(str4);
    }
}
