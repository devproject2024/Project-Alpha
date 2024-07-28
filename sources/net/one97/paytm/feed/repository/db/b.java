package net.one97.paytm.feed.repository.db;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.generic.FeedGenericData;
import net.one97.paytm.feed.repository.models.livetv.FeedLiveTV;
import net.one97.paytm.feed.repository.models.livetv.FeedLiveTVData;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchantData;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFront;
import net.one97.paytm.feed.repository.models.merchantstorefront.FeedMerchantStoreFrontData;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeed;
import net.one97.paytm.feed.repository.models.nestedfeed.NestedFeedData;
import net.one97.paytm.feed.repository.models.polls.Polls;
import net.one97.paytm.feed.repository.models.polls.PollsData;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedApps;
import net.one97.paytm.feed.repository.models.recommendedapps.FeedRecommendedAppsData;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.repository.models.sheroes.FeedSheroes;
import net.one97.paytm.feed.repository.models.sheroes.FeedSheroesData;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.stories.StoryData;
import net.one97.paytm.feed.repository.models.weather.FeedWeather;
import net.one97.paytm.feed.repository.models.weather.FeedWeatherData;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f34805a = new b();

    private b() {
    }

    public static List<FeedItem> a(List<? extends FeedDataMinimal> list) {
        Iterator<? extends FeedDataMinimal> it2;
        String title;
        String formatTime;
        int likeCount;
        int shareCount;
        String description;
        String imageUrl;
        boolean isLiked;
        boolean z;
        boolean z2;
        boolean isSensitive;
        String deepLinkUrl;
        String name;
        String logoUrl;
        String shareUrl;
        k.c(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends FeedDataMinimal> it3 = list.iterator();
        while (it3.hasNext()) {
            FeedDataMinimal feedDataMinimal = (FeedDataMinimal) it3.next();
            String feedItemType = feedDataMinimal.getFeedItemType();
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType())) {
                try {
                    FeedGeneric feedGeneric = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
                    feedGeneric.setFeedItemType(net.one97.paytm.feed.utility.k.GENERIC.getType());
                    feedGeneric.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                    feedGeneric.setFeedItemCategoryRank(feedDataMinimal.getFeedItemCategoryRank());
                    feedGeneric.setProfileRank(feedDataMinimal.getProfileRank());
                    feedGeneric.setFollowingRank(feedDataMinimal.getFollowingRank());
                    String id = feedDataMinimal.getId();
                    k.a((Object) id, "feed.id");
                    feedGeneric.setPid(id);
                    feedGeneric.setMlVersion(feedDataMinimal.getMlVersion());
                    feedGeneric.setScore(feedDataMinimal.getScore());
                    feedGeneric.setContentFormat(feedDataMinimal.getContentFormat());
                    feedGeneric.setMlCategory(feedDataMinimal.getMlCategory());
                    arrayList.add(feedGeneric);
                } catch (Exception unused) {
                }
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                FeedGeneric feedGeneric2 = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
                feedGeneric2.setFeedItemType(net.one97.paytm.feed.utility.k.VIDEOS.getType());
                feedGeneric2.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                feedGeneric2.setFeedItemCategoryRank(feedDataMinimal.getFeedItemCategoryRank());
                feedGeneric2.setProfileRank(feedDataMinimal.getProfileRank());
                feedGeneric2.setFollowingRank(feedDataMinimal.getFollowingRank());
                String id2 = feedDataMinimal.getId();
                k.a((Object) id2, "feed.id");
                feedGeneric2.setPid(id2);
                feedGeneric2.setMlVersion(feedDataMinimal.getMlVersion());
                feedGeneric2.setScore(feedDataMinimal.getScore());
                feedGeneric2.setContentFormat(feedDataMinimal.getContentFormat());
                feedGeneric2.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(feedGeneric2);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.LIVETV.getType())) {
                FeedLiveTV feedLiveTV = new FeedLiveTV(new FeedLiveTVData(feedDataMinimal.getDeepLinkUrl(), feedDataMinimal.channelList));
                feedLiveTV.setFeedItemType(net.one97.paytm.feed.utility.k.LIVETV.getType());
                String id3 = feedDataMinimal.getId();
                k.a((Object) id3, "feed.id");
                feedLiveTV.setPid(id3);
                feedLiveTV.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                feedLiveTV.setMlVersion(feedDataMinimal.getMlVersion());
                feedLiveTV.setScore(feedDataMinimal.getScore());
                feedLiveTV.setContentFormat(feedDataMinimal.getContentFormat());
                feedLiveTV.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(feedLiveTV);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType())) {
                String title2 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list2 = feedDataMinimal.recommendedList;
                k.a((Object) list2, "feed.recommendedList");
                NestedFeed nestedFeed = new NestedFeed(new NestedFeedData(title2, b(list2)), (Parcel) null);
                nestedFeed.setFeedItemType(net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS.getType());
                nestedFeed.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id4 = feedDataMinimal.getId();
                k.a((Object) id4, "feed.id");
                nestedFeed.setPid(id4);
                nestedFeed.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed.setScore(feedDataMinimal.getScore());
                nestedFeed.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS_2.getType())) {
                String title3 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list3 = feedDataMinimal.recommendedList;
                k.a((Object) list3, "feed.recommendedList");
                NestedFeed nestedFeed2 = new NestedFeed(new NestedFeedData(title3, b(list3)), (Parcel) null);
                nestedFeed2.setFeedItemType(net.one97.paytm.feed.utility.k.RECOMMENDEDPOSTS_2.getType());
                nestedFeed2.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id5 = feedDataMinimal.getId();
                k.a((Object) id5, "feed.id");
                nestedFeed2.setPid(id5);
                nestedFeed2.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed2.setScore(feedDataMinimal.getScore());
                nestedFeed2.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed2.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed2);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.BANNERS.getType())) {
                String title4 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list4 = feedDataMinimal.recommendedList;
                k.a((Object) list4, "feed.recommendedList");
                NestedFeed nestedFeed3 = new NestedFeed(new NestedFeedData(title4, b(list4)), (Parcel) null);
                nestedFeed3.setFeedItemType(net.one97.paytm.feed.utility.k.BANNERS.getType());
                nestedFeed3.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id6 = feedDataMinimal.getId();
                k.a((Object) id6, "feed.id");
                nestedFeed3.setPid(id6);
                nestedFeed3.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed3.setScore(feedDataMinimal.getScore());
                nestedFeed3.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed3.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed3);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.COVERAGE.getType())) {
                String title5 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list5 = feedDataMinimal.recommendedList;
                k.a((Object) list5, "feed.recommendedList");
                NestedFeed nestedFeed4 = new NestedFeed(new NestedFeedData(title5, b(list5)), (Parcel) null);
                nestedFeed4.setFeedItemType(net.one97.paytm.feed.utility.k.COVERAGE.getType());
                nestedFeed4.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id7 = feedDataMinimal.getId();
                k.a((Object) id7, "feed.id");
                nestedFeed4.setPid(id7);
                nestedFeed4.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed4.setScore(feedDataMinimal.getScore());
                nestedFeed4.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed4.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed4);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.POSTER.getType())) {
                String title6 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list6 = feedDataMinimal.recommendedList;
                k.a((Object) list6, "feed.recommendedList");
                NestedFeed nestedFeed5 = new NestedFeed(new NestedFeedData(title6, b(list6)), (Parcel) null);
                nestedFeed5.setFeedItemType(net.one97.paytm.feed.utility.k.POSTER.getType());
                nestedFeed5.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id8 = feedDataMinimal.getId();
                k.a((Object) id8, "feed.id");
                nestedFeed5.setPid(id8);
                nestedFeed5.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed5.setScore(feedDataMinimal.getScore());
                nestedFeed5.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed5.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed5);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.PUBLISHER.getType())) {
                String title7 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list7 = feedDataMinimal.recommendedList;
                k.a((Object) list7, "feed.recommendedList");
                NestedFeed nestedFeed6 = new NestedFeed(new NestedFeedData(title7, b(list7)), (Parcel) null);
                nestedFeed6.setFeedItemType(net.one97.paytm.feed.utility.k.PUBLISHER.getType());
                nestedFeed6.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id9 = feedDataMinimal.getId();
                k.a((Object) id9, "feed.id");
                nestedFeed6.setPid(id9);
                nestedFeed6.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed6.setScore(feedDataMinimal.getScore());
                nestedFeed6.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed6.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed6);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.TOPVIDEOS.getType())) {
                String title8 = feedDataMinimal.getTitle();
                List<FeedOfFeed> list8 = feedDataMinimal.recommendedList;
                k.a((Object) list8, "feed.recommendedList");
                NestedFeed nestedFeed7 = new NestedFeed(new NestedFeedData(title8, b(list8)), (Parcel) null);
                nestedFeed7.setFeedItemType(net.one97.paytm.feed.utility.k.TOPVIDEOS.getType());
                nestedFeed7.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id10 = feedDataMinimal.getId();
                k.a((Object) id10, "feed.id");
                nestedFeed7.setPid(id10);
                nestedFeed7.setMlVersion(feedDataMinimal.getMlVersion());
                nestedFeed7.setScore(feedDataMinimal.getScore());
                nestedFeed7.setContentFormat(feedDataMinimal.getContentFormat());
                nestedFeed7.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(nestedFeed7);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType())) {
                String title9 = feedDataMinimal.getTitle();
                k.a((Object) title9, "feed.title");
                List<RecommendedApps> list9 = feedDataMinimal.recommendedAppsList;
                k.a((Object) list9, "feed.recommendedAppsList");
                FeedRecommendedApps feedRecommendedApps = new FeedRecommendedApps(new FeedRecommendedAppsData(title9, (String) null, list9));
                feedRecommendedApps.setFeedItemType(net.one97.paytm.feed.utility.k.RECOMMENDEDAPPS_2.getType());
                feedRecommendedApps.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id11 = feedDataMinimal.getId();
                k.a((Object) id11, "feed.id");
                feedRecommendedApps.setPid(id11);
                feedRecommendedApps.setMlVersion(feedDataMinimal.getMlVersion());
                feedRecommendedApps.setScore(feedDataMinimal.getScore());
                feedRecommendedApps.setContentFormat(feedDataMinimal.getContentFormat());
                feedRecommendedApps.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(feedRecommendedApps);
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SHEROES.getType())) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                if (net.one97.paytm.feed.e.b.n()) {
                    arrayList.add(c(feedDataMinimal));
                } else {
                    c cVar = c.f34275a;
                    if (p.a("Female", c.c(), true)) {
                        arrayList.add(c(feedDataMinimal));
                    }
                }
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType())) {
                String viewAllUrl = feedDataMinimal.getViewAllUrl();
                k.a((Object) viewAllUrl, "feed.viewAllUrl");
                String title10 = feedDataMinimal.getTitle();
                k.a((Object) title10, "feed.title");
                List<Brand> list10 = feedDataMinimal.brands;
                k.a((Object) list10, "feed.brands");
                FeedMerchantStoreFront feedMerchantStoreFront = new FeedMerchantStoreFront(new FeedMerchantStoreFrontData(list10, title10, viewAllUrl));
                feedMerchantStoreFront.setFeedItemType(net.one97.paytm.feed.utility.k.MERCHANTSTOREFRONT.getType());
                String id12 = feedDataMinimal.getId();
                k.a((Object) id12, "feed.id");
                feedMerchantStoreFront.setPid(id12);
                feedMerchantStoreFront.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                feedMerchantStoreFront.setMlVersion(feedDataMinimal.getMlVersion());
                feedMerchantStoreFront.setScore(feedDataMinimal.getScore());
                feedMerchantStoreFront.setContentFormat(feedDataMinimal.getContentFormat());
                feedMerchantStoreFront.setMlCategory(feedDataMinimal.getMlCategory());
                arrayList.add(feedMerchantStoreFront);
            } else {
                if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType())) {
                    try {
                        title = feedDataMinimal.getTitle();
                        k.a((Object) title, "feed.title");
                        formatTime = feedDataMinimal.getFormatTime();
                        k.a((Object) formatTime, "feed.formatTime");
                        likeCount = feedDataMinimal.getLikeCount();
                        shareCount = feedDataMinimal.getShareCount();
                        description = feedDataMinimal.getDescription();
                        k.a((Object) description, "feed.description");
                        imageUrl = feedDataMinimal.getImageUrl();
                        k.a((Object) imageUrl, "feed.imageUrl");
                        isLiked = feedDataMinimal.isLiked();
                        z = feedDataMinimal.canShare;
                        z2 = feedDataMinimal.canLike;
                        isSensitive = feedDataMinimal.isSensitive();
                        deepLinkUrl = feedDataMinimal.getDeepLinkUrl();
                        k.a((Object) deepLinkUrl, "feed.deepLinkUrl");
                        name = feedDataMinimal.getName();
                        k.a((Object) name, "feed.name");
                        logoUrl = feedDataMinimal.getLogoUrl();
                        k.a((Object) logoUrl, "feed.logoUrl");
                        shareUrl = feedDataMinimal.getShareUrl();
                        it2 = it3;
                    } catch (Exception unused2) {
                        it2 = it3;
                    }
                    try {
                        k.a((Object) shareUrl, "feed.shareUrl");
                        boolean z3 = feedDataMinimal.canComment;
                        String str = name;
                        String id13 = feedDataMinimal.getId();
                        k.a((Object) id13, "feed.id");
                        String str2 = str;
                        String str3 = deepLinkUrl;
                        boolean z4 = z3;
                        String str4 = title;
                        FeedMerchant feedMerchant = new FeedMerchant(new FeedMerchantData(id13, z2, z, z4, description, formatTime, logoUrl, shareUrl, str3, str2, imageUrl, isLiked, isSensitive, likeCount, shareCount, 0, str4, feedDataMinimal.isFollowed(), feedDataMinimal.isCanFollow(), "", ""), (Parcel) null);
                        feedMerchant.setFeedItemType(net.one97.paytm.feed.utility.k.MERCHANTDEAL.getType());
                        String id14 = feedDataMinimal.getId();
                        k.a((Object) id14, "feed.id");
                        feedMerchant.setPid(id14);
                        feedMerchant.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                        feedMerchant.setMlVersion(feedDataMinimal.getMlVersion());
                        feedMerchant.setScore(feedDataMinimal.getScore());
                        feedMerchant.setContentFormat(feedDataMinimal.getContentFormat());
                        feedMerchant.setMlCategory(feedDataMinimal.getMlCategory());
                        arrayList.add(feedMerchant);
                    } catch (Exception unused3) {
                    }
                } else {
                    it2 = it3;
                    if (!k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.SCORECARD.getType())) {
                        if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.WEATHERCARD.getType())) {
                            String clickUrl = feedDataMinimal.getClickUrl();
                            String dataUrl = feedDataMinimal.getDataUrl();
                            k.a((Object) dataUrl, "feed.dataUrl");
                            FeedWeather feedWeather = new FeedWeather(new FeedWeatherData(dataUrl, clickUrl), (Parcel) null);
                            feedWeather.setFeedItemType(net.one97.paytm.feed.utility.k.WEATHERCARD.getType());
                            feedWeather.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                            String id15 = feedDataMinimal.getId();
                            k.a((Object) id15, "feed.id");
                            feedWeather.setPid(id15);
                            feedWeather.setMlVersion(feedDataMinimal.getMlVersion());
                            feedWeather.setScore(feedDataMinimal.getScore());
                            feedWeather.setContentFormat(feedDataMinimal.getContentFormat());
                            feedWeather.setMlCategory(feedDataMinimal.getMlCategory());
                            arrayList.add(feedWeather);
                        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GREETING.getType())) {
                            String clickUrl2 = feedDataMinimal.getClickUrl();
                            String dataUrl2 = feedDataMinimal.getDataUrl();
                            k.a((Object) dataUrl2, "feed.dataUrl");
                            FeedWeather feedWeather2 = new FeedWeather(new FeedWeatherData(dataUrl2, clickUrl2), (Parcel) null);
                            feedWeather2.setFeedItemType(net.one97.paytm.feed.utility.k.GREETING.getType());
                            feedWeather2.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                            String id16 = feedDataMinimal.getId();
                            k.a((Object) id16, "feed.id");
                            feedWeather2.setPid(id16);
                            feedWeather2.setMlVersion(feedDataMinimal.getMlVersion());
                            feedWeather2.setScore(feedDataMinimal.getScore());
                            feedWeather2.setContentFormat(feedDataMinimal.getContentFormat());
                            feedWeather2.setMlCategory(feedDataMinimal.getMlCategory());
                            arrayList.add(feedWeather2);
                        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
                            FeedGeneric feedGeneric3 = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
                            feedGeneric3.setFeedItemType(net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType());
                            feedGeneric3.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                            String id17 = feedDataMinimal.getId();
                            k.a((Object) id17, "feed.id");
                            feedGeneric3.setPid(id17);
                            feedGeneric3.setMlVersion(feedDataMinimal.getMlVersion());
                            feedGeneric3.setScore(feedDataMinimal.getScore());
                            feedGeneric3.setContentFormat(feedDataMinimal.getContentFormat());
                            feedGeneric3.setMlCategory(feedDataMinimal.getMlCategory());
                            arrayList.add(feedGeneric3);
                        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.STORIES.getType())) {
                            List<Stories> list11 = feedDataMinimal.storiesList;
                            k.a((Object) list11, "feed.storiesList");
                            StoryData storyData = new StoryData(list11);
                            storyData.setFeedItemType(net.one97.paytm.feed.utility.k.STORIES.getType());
                            storyData.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                            String id18 = feedDataMinimal.getId();
                            k.a((Object) id18, "feed.id");
                            storyData.setPid(id18);
                            storyData.setMlVersion(feedDataMinimal.getMlVersion());
                            storyData.setScore(feedDataMinimal.getScore());
                            storyData.setContentFormat(feedDataMinimal.getContentFormat());
                            storyData.setMlCategory(feedDataMinimal.getMlCategory());
                            arrayList.add(storyData);
                        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.POLLS.getType())) {
                            if (feedDataMinimal.pollsList.size() != 0) {
                                String title11 = feedDataMinimal.getTitle();
                                String logoUrl2 = feedDataMinimal.getLogoUrl();
                                List<PollsData> list12 = feedDataMinimal.pollsList;
                                k.a((Object) list12, "feed.pollsList");
                                Polls polls = new Polls(title11, logoUrl2, feedDataMinimal.pollsList.get(0).isVoted(), list12);
                                polls.setFeedItemType(net.one97.paytm.feed.utility.k.POLLS.getType());
                                polls.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                                String id19 = feedDataMinimal.getId();
                                k.a((Object) id19, "feed.id");
                                polls.setPid(id19);
                                polls.setMlVersion(feedDataMinimal.getMlVersion());
                                polls.setScore(feedDataMinimal.getScore());
                                polls.setContentFormat(feedDataMinimal.getContentFormat());
                                polls.setMlCategory(feedDataMinimal.getMlCategory());
                                arrayList.add(polls);
                            }
                        }
                    }
                }
                it3 = it2;
            }
        }
        return arrayList;
    }

    private static List<FeedGeneric> b(List<FeedOfFeed> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<FeedOfFeed> it2 = list.iterator();
        while (it2.hasNext()) {
            FeedOfFeed next = it2.next();
            next.setCreatedAt(net.one97.paytm.feed.utility.b.a(next.getCreatedAt()));
            String width = next.getWidth();
            String height = next.getHeight();
            String id = next.getId();
            String title = next.getTitle();
            String createdAt = next.getCreatedAt();
            Integer likeCount = next.getLikeCount();
            Integer shareCount = next.getShareCount();
            String description = next.getDescription();
            Integer commentCount = next.getCommentCount();
            String displayTime = next.getDisplayTime();
            String webUrl = next.getWebUrl();
            String imageUrl = next.getImageUrl();
            Boolean isLiked = next.isLiked();
            CreatedBy createdBy = next.getCreatedBy();
            String poweredBy = next.getPoweredBy();
            Boolean canShare = next.getCanShare();
            Boolean canComment = next.getCanComment();
            Boolean valueOf = Boolean.valueOf(next.getCanLike());
            Boolean isSensitive = next.isSensitive();
            boolean isBookmarked = next.isBookmarked();
            boolean isFollowed = next.isFollowed();
            Boolean valueOf2 = Boolean.valueOf(next.getCanFollow());
            String likeCountDisplay = next.getLikeCountDisplay();
            String commentCountDisplay = next.getCommentCountDisplay();
            String shareCountDisplay = next.getShareCountDisplay();
            String streamUrl = next.getStreamUrl();
            Integer duration = next.getDuration();
            String deepLink = next.getDeepLink();
            CreatedBy createdBy2 = next.getCreatedBy();
            Iterator<FeedOfFeed> it3 = it2;
            FeedGeneric feedGeneric = new FeedGeneric(new FeedGenericData(id, createdBy, next.getMlProperties(), poweredBy, createdAt, imageUrl, width, height, title, webUrl, likeCount, commentCount, shareCount, isLiked, description, displayTime, valueOf, canComment, canShare, isSensitive, isBookmarked, isFollowed, valueOf2, likeCountDisplay, commentCountDisplay, shareCountDisplay, deepLink, streamUrl, duration, "", createdBy2 != null ? createdBy2.getImageUrl() : null, true, next.getCtaImageUrl(), next.getCtaDisplayText()), (Parcel) null);
            if (!TextUtils.isEmpty(feedGeneric.getFeedGenericData().getStreamUrl())) {
                feedGeneric.setFeedItemType(net.one97.paytm.feed.utility.k.VIDEOS.getType());
            } else {
                feedGeneric.setFeedItemType(net.one97.paytm.feed.utility.k.GENERIC.getType());
            }
            feedGeneric.setPid(next.getId());
            arrayList.add(feedGeneric);
            it2 = it3;
        }
        return arrayList;
    }

    private static FeedGenericData b(FeedDataMinimal feedDataMinimal) {
        FeedDataMinimal feedDataMinimal2 = feedDataMinimal;
        String width = feedDataMinimal.getWidth();
        String height = feedDataMinimal.getHeight();
        String id = feedDataMinimal.getId();
        String str = id;
        k.a((Object) id, "feed.id");
        String title = feedDataMinimal.getTitle();
        String formatTime = feedDataMinimal.getFormatTime();
        Integer valueOf = Integer.valueOf(feedDataMinimal.getLikeCount());
        Integer valueOf2 = Integer.valueOf(feedDataMinimal.getShareCount());
        String description = feedDataMinimal.getDescription();
        Integer valueOf3 = Integer.valueOf(feedDataMinimal.getCommentCount());
        String displayTime = feedDataMinimal.getDisplayTime();
        String webUrl = feedDataMinimal.getWebUrl();
        String imageUrl = feedDataMinimal.getImageUrl();
        Boolean valueOf4 = Boolean.valueOf(feedDataMinimal.isLiked());
        CreatedBy createdBy = feedDataMinimal.getCreatedBy();
        String poweredBy = feedDataMinimal.getPoweredBy();
        Boolean valueOf5 = Boolean.valueOf(feedDataMinimal2.canShare);
        Boolean valueOf6 = Boolean.valueOf(feedDataMinimal2.canComment);
        Boolean valueOf7 = Boolean.valueOf(feedDataMinimal2.canLike);
        Boolean valueOf8 = Boolean.valueOf(feedDataMinimal.isSensitive());
        boolean isBookmarked = feedDataMinimal.isBookmarked();
        boolean isFollowed = feedDataMinimal.isFollowed();
        Boolean valueOf9 = Boolean.valueOf(feedDataMinimal.isCanFollow());
        String likeCountDisplay = feedDataMinimal.getLikeCountDisplay();
        String commentCountDisplay = feedDataMinimal.getCommentCountDisplay();
        String shareCountDisplay = feedDataMinimal.getShareCountDisplay();
        String streamUrl = feedDataMinimal.getStreamUrl();
        Integer valueOf10 = Integer.valueOf(feedDataMinimal.getDuration());
        String deepLinkUrl = feedDataMinimal.getDeepLinkUrl();
        String publisherImage = feedDataMinimal.getPublisherImage();
        return new FeedGenericData(str, createdBy, feedDataMinimal.getMlProperties(), poweredBy, formatTime, imageUrl, width, height, title, webUrl, valueOf, valueOf3, valueOf2, valueOf4, description, displayTime, valueOf7, valueOf6, valueOf5, valueOf8, isBookmarked, isFollowed, valueOf9, likeCountDisplay, commentCountDisplay, shareCountDisplay, deepLinkUrl, streamUrl, valueOf10, "", publisherImage, true, feedDataMinimal.getCtaImageUrl(), feedDataMinimal.getCtaDisplayText());
    }

    private static FeedSheroes c(FeedDataMinimal feedDataMinimal) {
        String deepLinkUrl = feedDataMinimal.getDeepLinkUrl();
        String imageUrl = feedDataMinimal.getImageUrl();
        k.a((Object) imageUrl, "feed.imageUrl");
        Boolean valueOf = Boolean.valueOf(feedDataMinimal.isSensitive());
        String width = feedDataMinimal.getWidth();
        k.a((Object) width, "feed.width");
        String height = feedDataMinimal.getHeight();
        k.a((Object) height, "feed.height");
        FeedSheroes feedSheroes = new FeedSheroes(new FeedSheroesData(deepLinkUrl, imageUrl, valueOf, height, width));
        feedSheroes.setFeedItemType(net.one97.paytm.feed.utility.k.SHEROES.getType());
        String id = feedDataMinimal.getId();
        k.a((Object) id, "feed.id");
        feedSheroes.setPid(id);
        feedSheroes.setFeedItemRank(feedDataMinimal.getFeedItemRank());
        feedSheroes.setMlVersion(feedDataMinimal.getMlVersion());
        feedSheroes.setScore(feedDataMinimal.getScore());
        feedSheroes.setContentFormat(feedDataMinimal.getContentFormat());
        feedSheroes.setMlCategory(feedDataMinimal.getMlCategory());
        return feedSheroes;
    }

    public static FeedItem a(FeedDataMinimal feedDataMinimal) {
        k.c(feedDataMinimal, "feed");
        String feedItemType = feedDataMinimal.getFeedItemType();
        FeedItem feedItem = null;
        if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType())) {
            try {
                FeedGeneric feedGeneric = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
                feedGeneric.setFeedItemType(net.one97.paytm.feed.utility.k.GENERIC.getType());
                feedGeneric.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                feedGeneric.setFeedItemCategoryRank(feedDataMinimal.getFeedItemCategoryRank());
                feedGeneric.setProfileRank(feedDataMinimal.getProfileRank());
                feedGeneric.setFollowingRank(feedDataMinimal.getFollowingRank());
                String id = feedDataMinimal.getId();
                k.a((Object) id, "feed.id");
                feedGeneric.setPid(id);
                feedGeneric.setMlVersion(feedDataMinimal.getMlVersion());
                feedGeneric.setScore(feedDataMinimal.getScore());
                feedGeneric.setContentFormat(feedDataMinimal.getContentFormat());
                feedGeneric.setMlCategory(feedDataMinimal.getMlCategory());
                return feedGeneric;
            } catch (Exception unused) {
            }
        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
            FeedGeneric feedGeneric2 = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
            feedGeneric2.setFeedItemType(net.one97.paytm.feed.utility.k.VIDEOS.getType());
            feedGeneric2.setFeedItemRank(feedDataMinimal.getFeedItemRank());
            feedGeneric2.setFeedItemCategoryRank(feedDataMinimal.getFeedItemCategoryRank());
            feedGeneric2.setProfileRank(feedDataMinimal.getProfileRank());
            feedGeneric2.setFollowingRank(feedDataMinimal.getFollowingRank());
            String id2 = feedDataMinimal.getId();
            k.a((Object) id2, "feed.id");
            feedGeneric2.setPid(id2);
            feedGeneric2.setMlVersion(feedDataMinimal.getMlVersion());
            feedGeneric2.setScore(feedDataMinimal.getScore());
            feedGeneric2.setContentFormat(feedDataMinimal.getContentFormat());
            feedGeneric2.setMlCategory(feedDataMinimal.getMlCategory());
            return feedGeneric2;
        } else {
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
                FeedGeneric feedGeneric3 = new FeedGeneric(b(feedDataMinimal), (Parcel) null);
                feedGeneric3.setFeedItemType(net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType());
                feedGeneric3.setFeedItemRank(feedDataMinimal.getFeedItemRank());
                String id3 = feedDataMinimal.getId();
                k.a((Object) id3, "feed.id");
                feedGeneric3.setPid(id3);
                feedGeneric3.setMlVersion(feedDataMinimal.getMlVersion());
                feedGeneric3.setScore(feedDataMinimal.getScore());
                feedGeneric3.setContentFormat(feedDataMinimal.getContentFormat());
                feedGeneric3.setMlCategory(feedDataMinimal.getMlCategory());
                feedItem = feedGeneric3;
            }
            return feedItem;
        }
    }
}
