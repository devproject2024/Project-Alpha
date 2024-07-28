package net.one97.paytm.feed.repository.db.a;

import android.database.Cursor;
import androidx.a.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.g;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.appsflyer.share.Constants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedData;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.MlProperties;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.repository.models.polls.PollsData;
import net.one97.paytm.feed.repository.models.promobanner.Banner;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.stories.StoryIdConverter;
import net.one97.paytm.feed.repository.models.stories.User;
import net.one97.paytm.feed.repository.models.trending.Trending;

public final class b implements a {
    private final q A;
    private final q B;
    private final q C;
    private final q D;
    private final q E;
    private final q F;
    private final q G;
    private final q H;
    private final q I;
    private final q J;
    private final q K;
    private final q L;
    private final q M;
    private final q N;
    private final q O;
    private final q P;
    private final q Q;
    private final q R;
    private final q S;

    /* renamed from: a  reason: collision with root package name */
    final j f34655a;

    /* renamed from: b  reason: collision with root package name */
    final StoryIdConverter f34656b = new StoryIdConverter();

    /* renamed from: c  reason: collision with root package name */
    private final c f34657c;

    /* renamed from: d  reason: collision with root package name */
    private final c f34658d;

    /* renamed from: e  reason: collision with root package name */
    private final c f34659e;

    /* renamed from: f  reason: collision with root package name */
    private final c f34660f;

    /* renamed from: g  reason: collision with root package name */
    private final c f34661g;

    /* renamed from: h  reason: collision with root package name */
    private final c f34662h;

    /* renamed from: i  reason: collision with root package name */
    private final c f34663i;
    private final c j;
    private final c k;
    private final q l;
    private final q m;
    private final q n;
    private final q o;
    private final q p;
    private final q q;
    private final q r;
    private final q s;
    private final q t;
    private final q u;
    private final q v;
    private final q w;
    private final q x;
    private final q y;
    private final q z;

    public b(j jVar) {
        this.f34655a = jVar;
        this.f34657c = new c<FeedData>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `FeedData`(`id`,`uiId`,`rank`,`poweredBy`,`createdAt`,`imageUrl`,`width`,`height`,`title`,`webUrl`,`likeCount`,`commentCount`,`shareCount`,`isLiked`,`description`,`displayTime`,`url`,`streamUrl`,`duration`,`viewCount`,`canLike`,`canComment`,`canShare`,`isSensitive`,`isFlaggedByUser`,`deepLinkUrl`,`category`,`following`,`viewAllUrl`,`buckets`,`feedItemType`,`logoUrl`,`shareUrl`,`name`,`feedItemRank`,`feedItemCategoryRank`,`profileRank`,`followingRank`,`mute`,`mlVersion`,`contentFormat`,`mlCategory`,`score`,`isBookmarked`,`isFollowed`,`canFollow`,`likeCountDisplay`,`commentCountDisplay`,`shareCountDisplay`,`homeTeamAbbr`,`awayTeamAbbr`,`homeTeamLogo`,`awayTeamLogo`,`homeTeamId`,`awayTeamId`,`dataUrl`,`clickUrl`,`matchId`,`startTime`,`ctaImageUrl`,`ctaDisplayText`,`creatorId`,`createdByName`,`createdByImageUrl`,`createdByCanFollow`,`ItemScore`,`ItemBucket`,`ItemContentFormat`,`ItemMlVersion`,`ItemMlCategory`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                FeedData feedData = (FeedData) obj;
                if (feedData.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, feedData.getId());
                }
                if (feedData.getUiId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, (long) feedData.getUiId().intValue());
                }
                fVar.a(3, (long) feedData.getRank());
                if (feedData.getPoweredBy() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, feedData.getPoweredBy());
                }
                if (feedData.getCreatedAt() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, feedData.getCreatedAt());
                }
                if (feedData.getImageUrl() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, feedData.getImageUrl());
                }
                if (feedData.getWidth() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, feedData.getWidth());
                }
                if (feedData.getHeight() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, feedData.getHeight());
                }
                if (feedData.getTitle() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, feedData.getTitle());
                }
                if (feedData.getWebUrl() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, feedData.getWebUrl());
                }
                if (feedData.getLikeCount() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, (long) feedData.getLikeCount().intValue());
                }
                if (feedData.getCommentCount() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, (long) feedData.getCommentCount().intValue());
                }
                if (feedData.getShareCount() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, (long) feedData.getShareCount().intValue());
                }
                Integer num = null;
                Integer valueOf = feedData.isLiked() == null ? null : Integer.valueOf(feedData.isLiked().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, (long) valueOf.intValue());
                }
                if (feedData.getDescription() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, feedData.getDescription());
                }
                if (feedData.getDisplayTime() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, feedData.getDisplayTime());
                }
                if (feedData.getUrl() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, feedData.getUrl());
                }
                if (feedData.getStreamUrl() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, feedData.getStreamUrl());
                }
                if (feedData.getDuration() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, (long) feedData.getDuration().intValue());
                }
                if (feedData.getViewCount() == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, (long) feedData.getViewCount().intValue());
                }
                fVar.a(21, feedData.getCanLike() ? 1 : 0);
                Integer valueOf2 = feedData.getCanComment() == null ? null : Integer.valueOf(feedData.getCanComment().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, (long) valueOf2.intValue());
                }
                Integer valueOf3 = feedData.getCanShare() == null ? null : Integer.valueOf(feedData.getCanShare().booleanValue() ? 1 : 0);
                if (valueOf3 == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, (long) valueOf3.intValue());
                }
                Integer valueOf4 = feedData.isSensitive() == null ? null : Integer.valueOf(feedData.isSensitive().booleanValue() ? 1 : 0);
                if (valueOf4 == null) {
                    fVar.a(24);
                } else {
                    fVar.a(24, (long) valueOf4.intValue());
                }
                if (feedData.isFlaggedByUser() != null) {
                    num = Integer.valueOf(feedData.isFlaggedByUser().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    fVar.a(25);
                } else {
                    fVar.a(25, (long) num.intValue());
                }
                if (feedData.getDeepLinkUrl() == null) {
                    fVar.a(26);
                } else {
                    fVar.a(26, feedData.getDeepLinkUrl());
                }
                fVar.a(27, (long) feedData.getCategory());
                fVar.a(28, (long) feedData.getFollowing());
                if (feedData.getViewAllUrl() == null) {
                    fVar.a(29);
                } else {
                    fVar.a(29, feedData.getViewAllUrl());
                }
                if (feedData.getBuckets() == null) {
                    fVar.a(30);
                } else {
                    fVar.a(30, feedData.getBuckets());
                }
                if (feedData.getFeedItemType() == null) {
                    fVar.a(31);
                } else {
                    fVar.a(31, feedData.getFeedItemType());
                }
                if (feedData.getLogoUrl() == null) {
                    fVar.a(32);
                } else {
                    fVar.a(32, feedData.getLogoUrl());
                }
                if (feedData.getShareUrl() == null) {
                    fVar.a(33);
                } else {
                    fVar.a(33, feedData.getShareUrl());
                }
                if (feedData.getName() == null) {
                    fVar.a(34);
                } else {
                    fVar.a(34, feedData.getName());
                }
                fVar.a(35, (long) feedData.getFeedItemRank());
                fVar.a(36, (long) feedData.getFeedItemCategoryRank());
                fVar.a(37, (long) feedData.getProfileRank());
                fVar.a(38, (long) feedData.getFollowingRank());
                fVar.a(39, feedData.getMute() ? 1 : 0);
                if (feedData.getMlVersion() == null) {
                    fVar.a(40);
                } else {
                    fVar.a(40, feedData.getMlVersion());
                }
                if (feedData.getContentFormat() == null) {
                    fVar.a(41);
                } else {
                    fVar.a(41, feedData.getContentFormat());
                }
                if (feedData.getMlCategory() == null) {
                    fVar.a(42);
                } else {
                    fVar.a(42, feedData.getMlCategory());
                }
                fVar.a(43, feedData.getScore());
                fVar.a(44, feedData.isBookmarked() ? 1 : 0);
                fVar.a(45, feedData.isFollowed() ? 1 : 0);
                fVar.a(46, feedData.getCanFollow() ? 1 : 0);
                if (feedData.getLikeCountDisplay() == null) {
                    fVar.a(47);
                } else {
                    fVar.a(47, feedData.getLikeCountDisplay());
                }
                if (feedData.getCommentCountDisplay() == null) {
                    fVar.a(48);
                } else {
                    fVar.a(48, feedData.getCommentCountDisplay());
                }
                if (feedData.getShareCountDisplay() == null) {
                    fVar.a(49);
                } else {
                    fVar.a(49, feedData.getShareCountDisplay());
                }
                if (feedData.getHomeTeamAbbr() == null) {
                    fVar.a(50);
                } else {
                    fVar.a(50, feedData.getHomeTeamAbbr());
                }
                if (feedData.getAwayTeamAbbr() == null) {
                    fVar.a(51);
                } else {
                    fVar.a(51, feedData.getAwayTeamAbbr());
                }
                if (feedData.getHomeTeamLogo() == null) {
                    fVar.a(52);
                } else {
                    fVar.a(52, feedData.getHomeTeamLogo());
                }
                if (feedData.getAwayTeamLogo() == null) {
                    fVar.a(53);
                } else {
                    fVar.a(53, feedData.getAwayTeamLogo());
                }
                if (feedData.getHomeTeamId() == null) {
                    fVar.a(54);
                } else {
                    fVar.a(54, feedData.getHomeTeamId());
                }
                if (feedData.getAwayTeamId() == null) {
                    fVar.a(55);
                } else {
                    fVar.a(55, feedData.getAwayTeamId());
                }
                if (feedData.getDataUrl() == null) {
                    fVar.a(56);
                } else {
                    fVar.a(56, feedData.getDataUrl());
                }
                if (feedData.getClickUrl() == null) {
                    fVar.a(57);
                } else {
                    fVar.a(57, feedData.getClickUrl());
                }
                if (feedData.getMatchId() == null) {
                    fVar.a(58);
                } else {
                    fVar.a(58, feedData.getMatchId());
                }
                if (feedData.getStartTime() == null) {
                    fVar.a(59);
                } else {
                    fVar.a(59, feedData.getStartTime());
                }
                if (feedData.getCtaImageUrl() == null) {
                    fVar.a(60);
                } else {
                    fVar.a(60, feedData.getCtaImageUrl());
                }
                if (feedData.getCtaDisplayText() == null) {
                    fVar.a(61);
                } else {
                    fVar.a(61, feedData.getCtaDisplayText());
                }
                CreatedBy createdBy = feedData.getCreatedBy();
                if (createdBy != null) {
                    if (createdBy.getId() == null) {
                        fVar.a(62);
                    } else {
                        fVar.a(62, (long) createdBy.getId().intValue());
                    }
                    if (createdBy.getName() == null) {
                        fVar.a(63);
                    } else {
                        fVar.a(63, createdBy.getName());
                    }
                    if (createdBy.getImageUrl() == null) {
                        fVar.a(64);
                    } else {
                        fVar.a(64, createdBy.getImageUrl());
                    }
                    fVar.a(65, createdBy.getCanFollow() ? 1 : 0);
                } else {
                    fVar.a(62);
                    fVar.a(63);
                    fVar.a(64);
                    fVar.a(65);
                }
                MlProperties mlProperties = feedData.getMlProperties();
                if (mlProperties != null) {
                    if (mlProperties.getScore() == null) {
                        fVar.a(66);
                    } else {
                        fVar.a(66, mlProperties.getScore().doubleValue());
                    }
                    if (mlProperties.getBuckets() == null) {
                        fVar.a(67);
                    } else {
                        fVar.a(67, mlProperties.getBuckets());
                    }
                    if (mlProperties.getContentFormat() == null) {
                        fVar.a(68);
                    } else {
                        fVar.a(68, mlProperties.getContentFormat());
                    }
                    if (mlProperties.getMlVersion() == null) {
                        fVar.a(69);
                    } else {
                        fVar.a(69, mlProperties.getMlVersion());
                    }
                    if (mlProperties.getMlCategory() == null) {
                        fVar.a(70);
                    } else {
                        fVar.a(70, mlProperties.getMlCategory());
                    }
                } else {
                    fVar.a(66);
                    fVar.a(67);
                    fVar.a(68);
                    fVar.a(69);
                    fVar.a(70);
                }
            }
        };
        this.f34658d = new c<Channel>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Channel`(`id`,`channelId`,`channelName`,`channelThumbnailUrl`,`channelGenre`,`language`,`source`,`programName`,`programDescription`,`programUrl`,`programImageUrl`,`programStartTime`,`programEndTime`,`fid`,`height`,`width`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Channel channel = (Channel) obj;
                if (channel.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, channel.getId());
                }
                if (channel.getChannelId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, channel.getChannelId());
                }
                if (channel.getChannelName() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, channel.getChannelName());
                }
                if (channel.getChannelThumbnailUrl() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, channel.getChannelThumbnailUrl());
                }
                if (channel.getChannelGenre() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, channel.getChannelGenre());
                }
                if (channel.getLanguage() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, channel.getLanguage());
                }
                if (channel.getSource() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, channel.getSource());
                }
                if (channel.getProgramName() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, channel.getProgramName());
                }
                if (channel.getProgramDescription() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, channel.getProgramDescription());
                }
                if (channel.getProgramUrl() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, channel.getProgramUrl());
                }
                if (channel.getProgramImageUrl() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, channel.getProgramImageUrl());
                }
                if (channel.getProgramStartTime() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, channel.getProgramStartTime());
                }
                if (channel.getProgramEndTime() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, channel.getProgramEndTime());
                }
                if (channel.getFid() == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, channel.getFid());
                }
                if (channel.getHeight() == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, channel.getHeight());
                }
                if (channel.getWidth() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, channel.getWidth());
                }
            }
        };
        this.f34659e = new c<Banner>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Banner`(`id`,`bid`,`deepLink`,`imageUrl`,`webUrl`,`height`,`width`) VALUES (?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Banner banner = (Banner) obj;
                if (banner.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, banner.getId());
                }
                if (banner.getBid() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, banner.getBid());
                }
                if (banner.getDeepLink() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, banner.getDeepLink());
                }
                if (banner.getImageUrl() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, banner.getImageUrl());
                }
                if (banner.getWebUrl() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, banner.getWebUrl());
                }
                if (banner.getHeight() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, banner.getHeight());
                }
                if (banner.getWidth() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, banner.getWidth());
                }
            }
        };
        this.f34660f = new c<Trending>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Trending`(`id`,`tid`,`title`,`description`,`deepLink`,`imageUrl`,`webUrl`,`streamUrl`,`height`,`width`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Trending trending = (Trending) obj;
                if (trending.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, trending.getId());
                }
                if (trending.getTid() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, trending.getTid());
                }
                if (trending.getTitle() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, trending.getTitle());
                }
                if (trending.getDescription() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, trending.getDescription());
                }
                if (trending.getDeepLink() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, trending.getDeepLink());
                }
                if (trending.getImageUrl() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, trending.getImageUrl());
                }
                if (trending.getWebUrl() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, trending.getWebUrl());
                }
                if (trending.getStreamUrl() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, trending.getStreamUrl());
                }
                if (trending.getHeight() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, trending.getHeight());
                }
                if (trending.getWidth() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, trending.getWidth());
                }
            }
        };
        this.f34661g = new c<RecommendedApps>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `RecommendedApps`(`id`,`rid`,`bgColor`,`description`,`downloads`,`imageUrl`,`rating`,`title`,`packageName`,`category`,`appSize`,`type`,`url`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                RecommendedApps recommendedApps = (RecommendedApps) obj;
                if (recommendedApps.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, recommendedApps.getId());
                }
                if (recommendedApps.getRid() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, recommendedApps.getRid());
                }
                if (recommendedApps.getBgColor() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, recommendedApps.getBgColor());
                }
                if (recommendedApps.getDescription() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, recommendedApps.getDescription());
                }
                if (recommendedApps.getDownloads() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, recommendedApps.getDownloads());
                }
                if (recommendedApps.getImageUrl() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, recommendedApps.getImageUrl());
                }
                if (recommendedApps.getRating() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, recommendedApps.getRating());
                }
                if (recommendedApps.getTitle() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, recommendedApps.getTitle());
                }
                if (recommendedApps.getPackageName() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, recommendedApps.getPackageName());
                }
                if (recommendedApps.getCategory() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, recommendedApps.getCategory());
                }
                if (recommendedApps.getAppSize() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, recommendedApps.getAppSize());
                }
                if (recommendedApps.getType() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, recommendedApps.getType());
                }
                if (recommendedApps.getUrl() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, recommendedApps.getUrl());
                }
            }
        };
        this.f34662h = new c<Stories>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Stories`(`storyId`,`sid`,`completelySeen`,`storyUpdatedAt`,`storyposition`,`postIds`,`userCanFollow`,`userId`,`userImageUrl`,`userName`,`id`,`uiId`,`groupId`,`rank`,`poweredBy`,`createdAt`,`imageUrl`,`width`,`height`,`title`,`webUrl`,`likeCount`,`commentCount`,`shareCount`,`isLiked`,`description`,`displayTime`,`streamUrl`,`duration`,`viewCount`,`canLike`,`canComment`,`canShare`,`isSensitive`,`isFlaggedByUser`,`deepLink`,`category`,`following`,`mute`,`isBookmarked`,`isFollowed`,`canFollow`,`likeCountDisplay`,`commentCountDisplay`,`shareCountDisplay`,`buckets`,`feedItemType`,`feedItemRank`,`feedItemCategoryRank`,`profileRank`,`mlVersion`,`contentFormat`,`mlCategory`,`score`,`followingRank`,`ctaImageUrl`,`ctaDisplayText`,`creatorId`,`createdByName`,`createdByImageUrl`,`createdByCanFollow`,`ItemScore`,`ItemBucket`,`ItemContentFormat`,`ItemMlVersion`,`ItemMlCategory`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                f fVar2 = fVar;
                Stories stories = (Stories) obj;
                if (stories.getStoryId() == null) {
                    fVar2.a(1);
                } else {
                    fVar2.a(1, stories.getStoryId());
                }
                if (stories.getSid() == null) {
                    fVar2.a(2);
                } else {
                    fVar2.a(2, stories.getSid());
                }
                fVar2.a(3, stories.getCompletelySeen() ? 1 : 0);
                if (stories.getStoryUpdatedAt() == null) {
                    fVar2.a(4);
                } else {
                    fVar2.a(4, stories.getStoryUpdatedAt());
                }
                fVar2.a(5, (long) stories.getStoryposition());
                String listToJson = b.this.f34656b.listToJson(stories.getPostIds());
                if (listToJson == null) {
                    fVar2.a(6);
                } else {
                    fVar2.a(6, listToJson);
                }
                User user = stories.getUser();
                if (user != null) {
                    fVar2.a(7, user.getUserCanFollow() ? 1 : 0);
                    fVar2.a(8, (long) user.getUserId());
                    if (user.getUserImageUrl() == null) {
                        fVar2.a(9);
                    } else {
                        fVar2.a(9, user.getUserImageUrl());
                    }
                    if (user.getUserName() == null) {
                        fVar2.a(10);
                    } else {
                        fVar2.a(10, user.getUserName());
                    }
                } else {
                    fVar2.a(7);
                    fVar2.a(8);
                    fVar2.a(9);
                    fVar2.a(10);
                }
                FeedOfFeed data = stories.getData();
                if (data != null) {
                    if (data.getId() == null) {
                        fVar2.a(11);
                    } else {
                        fVar2.a(11, data.getId());
                    }
                    fVar2.a(12, (long) data.getUiId());
                    if (data.getGroupId() == null) {
                        fVar2.a(13);
                    } else {
                        fVar2.a(13, data.getGroupId());
                    }
                    fVar2.a(14, (long) data.getRank());
                    if (data.getPoweredBy() == null) {
                        fVar2.a(15);
                    } else {
                        fVar2.a(15, data.getPoweredBy());
                    }
                    if (data.getCreatedAt() == null) {
                        fVar2.a(16);
                    } else {
                        fVar2.a(16, data.getCreatedAt());
                    }
                    if (data.getImageUrl() == null) {
                        fVar2.a(17);
                    } else {
                        fVar2.a(17, data.getImageUrl());
                    }
                    if (data.getWidth() == null) {
                        fVar2.a(18);
                    } else {
                        fVar2.a(18, data.getWidth());
                    }
                    if (data.getHeight() == null) {
                        fVar2.a(19);
                    } else {
                        fVar2.a(19, data.getHeight());
                    }
                    if (data.getTitle() == null) {
                        fVar2.a(20);
                    } else {
                        fVar2.a(20, data.getTitle());
                    }
                    if (data.getWebUrl() == null) {
                        fVar2.a(21);
                    } else {
                        fVar2.a(21, data.getWebUrl());
                    }
                    if (data.getLikeCount() == null) {
                        fVar2.a(22);
                    } else {
                        fVar2.a(22, (long) data.getLikeCount().intValue());
                    }
                    if (data.getCommentCount() == null) {
                        fVar2.a(23);
                    } else {
                        fVar2.a(23, (long) data.getCommentCount().intValue());
                    }
                    if (data.getShareCount() == null) {
                        fVar2.a(24);
                    } else {
                        fVar2.a(24, (long) data.getShareCount().intValue());
                    }
                    Integer num = null;
                    Integer valueOf = data.isLiked() == null ? null : Integer.valueOf(data.isLiked().booleanValue() ? 1 : 0);
                    if (valueOf == null) {
                        fVar2.a(25);
                    } else {
                        fVar2.a(25, (long) valueOf.intValue());
                    }
                    if (data.getDescription() == null) {
                        fVar2.a(26);
                    } else {
                        fVar2.a(26, data.getDescription());
                    }
                    if (data.getDisplayTime() == null) {
                        fVar2.a(27);
                    } else {
                        fVar2.a(27, data.getDisplayTime());
                    }
                    if (data.getStreamUrl() == null) {
                        fVar2.a(28);
                    } else {
                        fVar2.a(28, data.getStreamUrl());
                    }
                    if (data.getDuration() == null) {
                        fVar2.a(29);
                    } else {
                        fVar2.a(29, (long) data.getDuration().intValue());
                    }
                    if (data.getViewCount() == null) {
                        fVar2.a(30);
                    } else {
                        fVar2.a(30, (long) data.getViewCount().intValue());
                    }
                    fVar2.a(31, data.getCanLike() ? 1 : 0);
                    Integer valueOf2 = data.getCanComment() == null ? null : Integer.valueOf(data.getCanComment().booleanValue() ? 1 : 0);
                    if (valueOf2 == null) {
                        fVar2.a(32);
                    } else {
                        fVar2.a(32, (long) valueOf2.intValue());
                    }
                    Integer valueOf3 = data.getCanShare() == null ? null : Integer.valueOf(data.getCanShare().booleanValue() ? 1 : 0);
                    if (valueOf3 == null) {
                        fVar2.a(33);
                    } else {
                        fVar2.a(33, (long) valueOf3.intValue());
                    }
                    Integer valueOf4 = data.isSensitive() == null ? null : Integer.valueOf(data.isSensitive().booleanValue() ? 1 : 0);
                    if (valueOf4 == null) {
                        fVar2.a(34);
                    } else {
                        fVar2.a(34, (long) valueOf4.intValue());
                    }
                    if (data.isFlaggedByUser() != null) {
                        num = Integer.valueOf(data.isFlaggedByUser().booleanValue() ? 1 : 0);
                    }
                    if (num == null) {
                        fVar2.a(35);
                    } else {
                        fVar2.a(35, (long) num.intValue());
                    }
                    if (data.getDeepLink() == null) {
                        fVar2.a(36);
                    } else {
                        fVar2.a(36, data.getDeepLink());
                    }
                    fVar2.a(37, (long) data.getCategory());
                    fVar2.a(38, (long) data.getFollowing());
                    fVar2.a(39, data.getMute() ? 1 : 0);
                    fVar2.a(40, data.isBookmarked() ? 1 : 0);
                    fVar2.a(41, data.isFollowed() ? 1 : 0);
                    fVar2.a(42, data.getCanFollow() ? 1 : 0);
                    if (data.getLikeCountDisplay() == null) {
                        fVar2.a(43);
                    } else {
                        fVar2.a(43, data.getLikeCountDisplay());
                    }
                    if (data.getCommentCountDisplay() == null) {
                        fVar2.a(44);
                    } else {
                        fVar2.a(44, data.getCommentCountDisplay());
                    }
                    if (data.getShareCountDisplay() == null) {
                        fVar2.a(45);
                    } else {
                        fVar2.a(45, data.getShareCountDisplay());
                    }
                    if (data.getBuckets() == null) {
                        fVar2.a(46);
                    } else {
                        fVar2.a(46, data.getBuckets());
                    }
                    if (data.getFeedItemType() == null) {
                        fVar2.a(47);
                    } else {
                        fVar2.a(47, data.getFeedItemType());
                    }
                    fVar2.a(48, (long) data.getFeedItemRank());
                    fVar2.a(49, (long) data.getFeedItemCategoryRank());
                    fVar2.a(50, (long) data.getProfileRank());
                    if (data.getMlVersion() == null) {
                        fVar2.a(51);
                    } else {
                        fVar2.a(51, data.getMlVersion());
                    }
                    if (data.getContentFormat() == null) {
                        fVar2.a(52);
                    } else {
                        fVar2.a(52, data.getContentFormat());
                    }
                    if (data.getMlCategory() == null) {
                        fVar2.a(53);
                    } else {
                        fVar2.a(53, data.getMlCategory());
                    }
                    if (data.getScore() == null) {
                        fVar2.a(54);
                    } else {
                        fVar2.a(54, data.getScore().doubleValue());
                    }
                    fVar2.a(55, (long) data.getFollowingRank());
                    if (data.getCtaImageUrl() == null) {
                        fVar2.a(56);
                    } else {
                        fVar2.a(56, data.getCtaImageUrl());
                    }
                    if (data.getCtaDisplayText() == null) {
                        fVar2.a(57);
                    } else {
                        fVar2.a(57, data.getCtaDisplayText());
                    }
                    CreatedBy createdBy = data.getCreatedBy();
                    if (createdBy != null) {
                        if (createdBy.getId() == null) {
                            fVar2.a(58);
                        } else {
                            fVar2.a(58, (long) createdBy.getId().intValue());
                        }
                        if (createdBy.getName() == null) {
                            fVar2.a(59);
                        } else {
                            fVar2.a(59, createdBy.getName());
                        }
                        if (createdBy.getImageUrl() == null) {
                            fVar2.a(60);
                        } else {
                            fVar2.a(60, createdBy.getImageUrl());
                        }
                        fVar2.a(61, createdBy.getCanFollow() ? 1 : 0);
                    } else {
                        fVar2.a(58);
                        fVar2.a(59);
                        fVar2.a(60);
                        fVar2.a(61);
                    }
                    MlProperties mlProperties = data.getMlProperties();
                    if (mlProperties != null) {
                        if (mlProperties.getScore() == null) {
                            fVar2.a(62);
                        } else {
                            fVar2.a(62, mlProperties.getScore().doubleValue());
                        }
                        if (mlProperties.getBuckets() == null) {
                            fVar2.a(63);
                        } else {
                            fVar2.a(63, mlProperties.getBuckets());
                        }
                        if (mlProperties.getContentFormat() == null) {
                            fVar2.a(64);
                        } else {
                            fVar2.a(64, mlProperties.getContentFormat());
                        }
                        if (mlProperties.getMlVersion() == null) {
                            fVar2.a(65);
                        } else {
                            fVar2.a(65, mlProperties.getMlVersion());
                        }
                        if (mlProperties.getMlCategory() == null) {
                            fVar2.a(66);
                        } else {
                            fVar2.a(66, mlProperties.getMlCategory());
                        }
                    } else {
                        fVar2.a(62);
                        fVar2.a(63);
                        fVar2.a(64);
                        fVar2.a(65);
                        fVar2.a(66);
                    }
                } else {
                    fVar2.a(11);
                    fVar2.a(12);
                    fVar2.a(13);
                    fVar2.a(14);
                    fVar2.a(15);
                    fVar2.a(16);
                    fVar2.a(17);
                    fVar2.a(18);
                    fVar2.a(19);
                    fVar2.a(20);
                    fVar2.a(21);
                    fVar2.a(22);
                    fVar2.a(23);
                    fVar2.a(24);
                    fVar2.a(25);
                    fVar2.a(26);
                    fVar2.a(27);
                    fVar2.a(28);
                    fVar2.a(29);
                    fVar2.a(30);
                    fVar2.a(31);
                    fVar2.a(32);
                    fVar2.a(33);
                    fVar2.a(34);
                    fVar2.a(35);
                    fVar2.a(36);
                    fVar2.a(37);
                    fVar2.a(38);
                    fVar2.a(39);
                    fVar2.a(40);
                    fVar2.a(41);
                    fVar2.a(42);
                    fVar2.a(43);
                    fVar2.a(44);
                    fVar2.a(45);
                    fVar2.a(46);
                    fVar2.a(47);
                    fVar2.a(48);
                    fVar2.a(49);
                    fVar2.a(50);
                    fVar2.a(51);
                    fVar2.a(52);
                    fVar2.a(53);
                    fVar2.a(54);
                    fVar2.a(55);
                    fVar2.a(56);
                    fVar2.a(57);
                    fVar2.a(58);
                    fVar2.a(59);
                    fVar2.a(60);
                    fVar2.a(61);
                    fVar2.a(62);
                    fVar2.a(63);
                    fVar2.a(64);
                    fVar2.a(65);
                    fVar2.a(66);
                }
            }
        };
        this.f34663i = new c<PollsData>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `PollsData`(`id`,`pollsId`,`title`,`totalCount`,`options`,`createdAt`,`isVoted`) VALUES (?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                PollsData pollsData = (PollsData) obj;
                if (pollsData.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, pollsData.getId());
                }
                if (pollsData.getPollsId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, pollsData.getPollsId());
                }
                if (pollsData.getTitle() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, pollsData.getTitle());
                }
                fVar.a(4, (long) pollsData.getTotalCount());
                String fromOptionsList = b.this.f34656b.fromOptionsList(pollsData.getOptions());
                if (fromOptionsList == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, fromOptionsList);
                }
                if (pollsData.getCreatedAt() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, pollsData.getCreatedAt());
                }
                fVar.a(7, pollsData.isVoted() ? 1 : 0);
            }
        };
        this.j = new c<FeedOfFeed>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `FeedOfFeed`(`id`,`uiId`,`groupId`,`rank`,`poweredBy`,`createdAt`,`imageUrl`,`width`,`height`,`title`,`webUrl`,`likeCount`,`commentCount`,`shareCount`,`isLiked`,`description`,`displayTime`,`streamUrl`,`duration`,`viewCount`,`canLike`,`canComment`,`canShare`,`isSensitive`,`isFlaggedByUser`,`deepLink`,`category`,`following`,`mute`,`isBookmarked`,`isFollowed`,`canFollow`,`likeCountDisplay`,`commentCountDisplay`,`shareCountDisplay`,`buckets`,`feedItemType`,`feedItemRank`,`feedItemCategoryRank`,`profileRank`,`mlVersion`,`contentFormat`,`mlCategory`,`score`,`followingRank`,`ctaImageUrl`,`ctaDisplayText`,`creatorId`,`createdByName`,`createdByImageUrl`,`createdByCanFollow`,`ItemScore`,`ItemBucket`,`ItemContentFormat`,`ItemMlVersion`,`ItemMlCategory`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                FeedOfFeed feedOfFeed = (FeedOfFeed) obj;
                if (feedOfFeed.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, feedOfFeed.getId());
                }
                fVar.a(2, (long) feedOfFeed.getUiId());
                if (feedOfFeed.getGroupId() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, feedOfFeed.getGroupId());
                }
                fVar.a(4, (long) feedOfFeed.getRank());
                if (feedOfFeed.getPoweredBy() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, feedOfFeed.getPoweredBy());
                }
                if (feedOfFeed.getCreatedAt() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, feedOfFeed.getCreatedAt());
                }
                if (feedOfFeed.getImageUrl() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, feedOfFeed.getImageUrl());
                }
                if (feedOfFeed.getWidth() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, feedOfFeed.getWidth());
                }
                if (feedOfFeed.getHeight() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, feedOfFeed.getHeight());
                }
                if (feedOfFeed.getTitle() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, feedOfFeed.getTitle());
                }
                if (feedOfFeed.getWebUrl() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, feedOfFeed.getWebUrl());
                }
                if (feedOfFeed.getLikeCount() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, (long) feedOfFeed.getLikeCount().intValue());
                }
                if (feedOfFeed.getCommentCount() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, (long) feedOfFeed.getCommentCount().intValue());
                }
                if (feedOfFeed.getShareCount() == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, (long) feedOfFeed.getShareCount().intValue());
                }
                Integer num = null;
                Integer valueOf = feedOfFeed.isLiked() == null ? null : Integer.valueOf(feedOfFeed.isLiked().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, (long) valueOf.intValue());
                }
                if (feedOfFeed.getDescription() == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, feedOfFeed.getDescription());
                }
                if (feedOfFeed.getDisplayTime() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, feedOfFeed.getDisplayTime());
                }
                if (feedOfFeed.getStreamUrl() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, feedOfFeed.getStreamUrl());
                }
                if (feedOfFeed.getDuration() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, (long) feedOfFeed.getDuration().intValue());
                }
                if (feedOfFeed.getViewCount() == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, (long) feedOfFeed.getViewCount().intValue());
                }
                fVar.a(21, feedOfFeed.getCanLike() ? 1 : 0);
                Integer valueOf2 = feedOfFeed.getCanComment() == null ? null : Integer.valueOf(feedOfFeed.getCanComment().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, (long) valueOf2.intValue());
                }
                Integer valueOf3 = feedOfFeed.getCanShare() == null ? null : Integer.valueOf(feedOfFeed.getCanShare().booleanValue() ? 1 : 0);
                if (valueOf3 == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, (long) valueOf3.intValue());
                }
                Integer valueOf4 = feedOfFeed.isSensitive() == null ? null : Integer.valueOf(feedOfFeed.isSensitive().booleanValue() ? 1 : 0);
                if (valueOf4 == null) {
                    fVar.a(24);
                } else {
                    fVar.a(24, (long) valueOf4.intValue());
                }
                if (feedOfFeed.isFlaggedByUser() != null) {
                    num = Integer.valueOf(feedOfFeed.isFlaggedByUser().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    fVar.a(25);
                } else {
                    fVar.a(25, (long) num.intValue());
                }
                if (feedOfFeed.getDeepLink() == null) {
                    fVar.a(26);
                } else {
                    fVar.a(26, feedOfFeed.getDeepLink());
                }
                fVar.a(27, (long) feedOfFeed.getCategory());
                fVar.a(28, (long) feedOfFeed.getFollowing());
                fVar.a(29, feedOfFeed.getMute() ? 1 : 0);
                fVar.a(30, feedOfFeed.isBookmarked() ? 1 : 0);
                fVar.a(31, feedOfFeed.isFollowed() ? 1 : 0);
                fVar.a(32, feedOfFeed.getCanFollow() ? 1 : 0);
                if (feedOfFeed.getLikeCountDisplay() == null) {
                    fVar.a(33);
                } else {
                    fVar.a(33, feedOfFeed.getLikeCountDisplay());
                }
                if (feedOfFeed.getCommentCountDisplay() == null) {
                    fVar.a(34);
                } else {
                    fVar.a(34, feedOfFeed.getCommentCountDisplay());
                }
                if (feedOfFeed.getShareCountDisplay() == null) {
                    fVar.a(35);
                } else {
                    fVar.a(35, feedOfFeed.getShareCountDisplay());
                }
                if (feedOfFeed.getBuckets() == null) {
                    fVar.a(36);
                } else {
                    fVar.a(36, feedOfFeed.getBuckets());
                }
                if (feedOfFeed.getFeedItemType() == null) {
                    fVar.a(37);
                } else {
                    fVar.a(37, feedOfFeed.getFeedItemType());
                }
                fVar.a(38, (long) feedOfFeed.getFeedItemRank());
                fVar.a(39, (long) feedOfFeed.getFeedItemCategoryRank());
                fVar.a(40, (long) feedOfFeed.getProfileRank());
                if (feedOfFeed.getMlVersion() == null) {
                    fVar.a(41);
                } else {
                    fVar.a(41, feedOfFeed.getMlVersion());
                }
                if (feedOfFeed.getContentFormat() == null) {
                    fVar.a(42);
                } else {
                    fVar.a(42, feedOfFeed.getContentFormat());
                }
                if (feedOfFeed.getMlCategory() == null) {
                    fVar.a(43);
                } else {
                    fVar.a(43, feedOfFeed.getMlCategory());
                }
                if (feedOfFeed.getScore() == null) {
                    fVar.a(44);
                } else {
                    fVar.a(44, feedOfFeed.getScore().doubleValue());
                }
                fVar.a(45, (long) feedOfFeed.getFollowingRank());
                if (feedOfFeed.getCtaImageUrl() == null) {
                    fVar.a(46);
                } else {
                    fVar.a(46, feedOfFeed.getCtaImageUrl());
                }
                if (feedOfFeed.getCtaDisplayText() == null) {
                    fVar.a(47);
                } else {
                    fVar.a(47, feedOfFeed.getCtaDisplayText());
                }
                CreatedBy createdBy = feedOfFeed.getCreatedBy();
                if (createdBy != null) {
                    if (createdBy.getId() == null) {
                        fVar.a(48);
                    } else {
                        fVar.a(48, (long) createdBy.getId().intValue());
                    }
                    if (createdBy.getName() == null) {
                        fVar.a(49);
                    } else {
                        fVar.a(49, createdBy.getName());
                    }
                    if (createdBy.getImageUrl() == null) {
                        fVar.a(50);
                    } else {
                        fVar.a(50, createdBy.getImageUrl());
                    }
                    fVar.a(51, createdBy.getCanFollow() ? 1 : 0);
                } else {
                    fVar.a(48);
                    fVar.a(49);
                    fVar.a(50);
                    fVar.a(51);
                }
                MlProperties mlProperties = feedOfFeed.getMlProperties();
                if (mlProperties != null) {
                    if (mlProperties.getScore() == null) {
                        fVar.a(52);
                    } else {
                        fVar.a(52, mlProperties.getScore().doubleValue());
                    }
                    if (mlProperties.getBuckets() == null) {
                        fVar.a(53);
                    } else {
                        fVar.a(53, mlProperties.getBuckets());
                    }
                    if (mlProperties.getContentFormat() == null) {
                        fVar.a(54);
                    } else {
                        fVar.a(54, mlProperties.getContentFormat());
                    }
                    if (mlProperties.getMlVersion() == null) {
                        fVar.a(55);
                    } else {
                        fVar.a(55, mlProperties.getMlVersion());
                    }
                    if (mlProperties.getMlCategory() == null) {
                        fVar.a(56);
                    } else {
                        fVar.a(56, mlProperties.getMlCategory());
                    }
                } else {
                    fVar.a(52);
                    fVar.a(53);
                    fVar.a(54);
                    fVar.a(55);
                    fVar.a(56);
                }
            }
        };
        this.k = new c<Brand>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Brand`(`deepLink`,`contractId`,`logoUrl`,`name`,`pid`) VALUES (?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Brand brand = (Brand) obj;
                if (brand.getDeepLink() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, brand.getDeepLink());
                }
                if (brand.getContractId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, brand.getContractId());
                }
                if (brand.getLogoUrl() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, brand.getLogoUrl());
                }
                if (brand.getName() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, brand.getName());
                }
                if (brand.getPid() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, brand.getPid());
                }
            }
        };
        this.l = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET isLiked = ?,likeCount=likeCount + 1  WHERE id = ?";
            }
        };
        this.m = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET isLiked = ?,likeCount=likeCount + 1  WHERE id = ?";
            }
        };
        this.n = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET isLiked = ?,likeCount=likeCount - 1  WHERE id = ?";
            }
        };
        this.o = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET isLiked = ?,likeCount=likeCount - 1  WHERE id = ?";
            }
        };
        this.p = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET mute = ?  WHERE feedItemType = ?";
            }
        };
        this.q = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET isFlaggedByUser = ?  WHERE id = ?";
            }
        };
        this.r = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET shareCount = shareCount+1  WHERE id = ?";
            }
        };
        this.s = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET shareCount = shareCount+1  WHERE id = ?";
            }
        };
        this.t = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET commentCount = commentCount+1  WHERE id = ?";
            }
        };
        this.u = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET commentCount = commentCount+1  WHERE id = ?";
            }
        };
        this.v = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET commentCount = commentCount-1  WHERE id = ?";
            }
        };
        this.w = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET commentCount = commentCount-1  WHERE id = ?";
            }
        };
        this.x = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedData";
            }
        };
        this.y = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedOfFeed";
            }
        };
        this.z = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedData WHERE id =?";
            }
        };
        this.A = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET category = 5 WHERE id = ?";
            }
        };
        this.B = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET following = 9,followingRank=?  WHERE id = ?";
            }
        };
        this.C = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET category = 1,feedItemRank=? WHERE id = ?";
            }
        };
        this.D = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET category = 7,feedItemCategoryRank=? WHERE id = ?";
            }
        };
        this.E = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedData WHERE category = 2";
            }
        };
        this.F = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedData WHERE category = 4";
            }
        };
        this.G = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM FeedData WHERE category = 6";
            }
        };
        this.H = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedData SET category = 1 WHERE category = 3";
            }
        };
        this.I = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedData SET category = 1 WHERE category = 5";
            }
        };
        this.J = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedData SET category = 1 WHERE category = 7";
            }
        };
        this.K = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM CHANNEL";
            }
        };
        this.L = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM BRAND";
            }
        };
        this.M = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM Banner";
            }
        };
        this.N = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM TRENDING";
            }
        };
        this.O = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM RECOMMENDEDAPPS";
            }
        };
        this.P = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET isFollowed =? WHERE creatorId = ?";
            }
        };
        this.Q = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET isFollowed =? WHERE creatorId = ?";
            }
        };
        this.R = new q(jVar) {
            public final String createQuery() {
                return "UPDATE feeddata SET isBookmarked =? WHERE id = ?";
            }
        };
        this.S = new q(jVar) {
            public final String createQuery() {
                return "UPDATE FeedOfFeed SET isBookmarked =? WHERE id = ?";
            }
        };
    }

    public final long a(FeedData feedData) {
        this.f34655a.beginTransaction();
        try {
            long insertAndReturnId = this.f34657c.insertAndReturnId(feedData);
            this.f34655a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(Channel channel) {
        this.f34655a.beginTransaction();
        try {
            this.f34658d.insert(channel);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(Banner banner) {
        this.f34655a.beginTransaction();
        try {
            this.f34659e.insert(banner);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(Trending trending) {
        this.f34655a.beginTransaction();
        try {
            this.f34660f.insert(trending);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(RecommendedApps recommendedApps) {
        this.f34655a.beginTransaction();
        try {
            this.f34661g.insert(recommendedApps);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(Stories stories) {
        this.f34655a.beginTransaction();
        try {
            this.f34662h.insert(stories);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(PollsData pollsData) {
        this.f34655a.beginTransaction();
        try {
            this.f34663i.insert(pollsData);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(FeedOfFeed feedOfFeed) {
        this.f34655a.beginTransaction();
        try {
            this.j.insert(feedOfFeed);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(Brand brand) {
        this.f34655a.beginTransaction();
        try {
            this.k.insert(brand);
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
        }
    }

    public final void a(String str, boolean z2) {
        f acquire = this.l.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.l.release(acquire);
        }
    }

    public final void b(String str, boolean z2) {
        f acquire = this.m.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.m.release(acquire);
        }
    }

    public final void c(String str, boolean z2) {
        f acquire = this.n.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.n.release(acquire);
        }
    }

    public final void d(String str, boolean z2) {
        f acquire = this.o.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.o.release(acquire);
        }
    }

    public final void a(boolean z2, String str) {
        f acquire = this.p.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.p.release(acquire);
        }
    }

    public final void a(String str) {
        f acquire = this.r.acquire();
        this.f34655a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f34655a.endTransaction();
                this.r.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f34655a.setTransactionSuccessful();
        this.f34655a.endTransaction();
        this.r.release(acquire);
    }

    public final void b(String str) {
        f acquire = this.s.acquire();
        this.f34655a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f34655a.endTransaction();
                this.s.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f34655a.setTransactionSuccessful();
        this.f34655a.endTransaction();
        this.s.release(acquire);
    }

    public final void c(String str) {
        f acquire = this.t.acquire();
        this.f34655a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f34655a.endTransaction();
                this.t.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f34655a.setTransactionSuccessful();
        this.f34655a.endTransaction();
        this.t.release(acquire);
    }

    public final void d(String str) {
        f acquire = this.v.acquire();
        this.f34655a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f34655a.endTransaction();
                this.v.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f34655a.setTransactionSuccessful();
        this.f34655a.endTransaction();
        this.v.release(acquire);
    }

    public final void g() {
        f acquire = this.x.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.x.release(acquire);
        }
    }

    public final void h() {
        f acquire = this.y.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.y.release(acquire);
        }
    }

    public final void e(String str) {
        f acquire = this.z.acquire();
        this.f34655a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f34655a.endTransaction();
                this.z.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f34655a.setTransactionSuccessful();
        this.f34655a.endTransaction();
        this.z.release(acquire);
    }

    public final void i() {
        f acquire = this.F.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.F.release(acquire);
        }
    }

    public final void j() {
        f acquire = this.G.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.G.release(acquire);
        }
    }

    public final void k() {
        f acquire = this.I.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.I.release(acquire);
        }
    }

    public final void l() {
        f acquire = this.J.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.J.release(acquire);
        }
    }

    public final void m() {
        f acquire = this.K.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.K.release(acquire);
        }
    }

    public final void n() {
        f acquire = this.L.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.L.release(acquire);
        }
    }

    public final void o() {
        f acquire = this.M.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.M.release(acquire);
        }
    }

    public final void p() {
        f acquire = this.N.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.N.release(acquire);
        }
    }

    public final void a(int i2, boolean z2) {
        f acquire = this.P.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            acquire.a(2, (long) i2);
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.P.release(acquire);
        }
    }

    public final void b(int i2, boolean z2) {
        f acquire = this.Q.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            acquire.a(2, (long) i2);
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.Q.release(acquire);
        }
    }

    public final void e(String str, boolean z2) {
        f acquire = this.R.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.R.release(acquire);
        }
    }

    public final void f(String str, boolean z2) {
        f acquire = this.S.acquire();
        this.f34655a.beginTransaction();
        try {
            acquire.a(1, (long) (z2 ? 1 : 0));
            if (str == null) {
                acquire.a(2);
            } else {
                acquire.a(2, str);
            }
            acquire.a();
            this.f34655a.setTransactionSuccessful();
        } finally {
            this.f34655a.endTransaction();
            this.S.release(acquire);
        }
    }

    public final LiveData<List<FeedDataMinimal>> a() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =1 OR category=3 ORDER BY feedItemRank ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34698i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x064e A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x0658 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x0678 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0682 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a2 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06ac A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cc A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d6 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f6 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0700 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0720 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072a A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074a A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0315 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0316 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03ce A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d0 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0420 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0422 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x042f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0431 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x043e A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0440 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x044d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x044f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x045d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x045f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f1 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f3 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x052d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x052f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053b A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x053f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x054f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0551 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0600 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0622 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x062e A[Catch:{ all -> 0x07cd }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34698i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$39$1 r0 = new net.one97.paytm.feed.repository.db.a.b$39$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34698i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34698i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r0.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r3.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r4.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r5.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r6.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r7.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r8.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r9.<init>()     // Catch:{ all -> 0x07d1 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07cd }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07cd }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07cd }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07cd }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07cd }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07cd }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07cd }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07cd }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07cd }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07cd }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07cd }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07cd }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07cd }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07cd }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07cd }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07cd }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07cd }
                    r15.<init>(r14)     // Catch:{ all -> 0x07cd }
                L_0x0292:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x078d
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07cd }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07cd }
                    if (r14 != 0) goto L_0x02b7
                    goto L_0x02c2
                L_0x02b7:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02f7
                L_0x02c2:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02cd
                    r83 = r0
                    r14 = r80
                    goto L_0x02d7
                L_0x02cd:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07cd }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07cd }
                    r83 = r0
                L_0x02d7:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07cd }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07cd }
                    if (r85 == 0) goto L_0x02ed
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f2
                L_0x02ed:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f2:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07cd }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07cd }
                L_0x02f7:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07cd }
                    if (r0 != 0) goto L_0x0316
                    goto L_0x0319
                L_0x0316:
                    r0 = r80
                    goto L_0x0342
                L_0x0319:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0322
                L_0x031f:
                    r88 = r80
                    goto L_0x032b
                L_0x0322:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07cd }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07cd }
                    goto L_0x031f
                L_0x032b:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07cd }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07cd }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07cd }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07cd }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07cd }
                L_0x0342:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07cd }
                    r3.<init>()     // Catch:{ all -> 0x07cd }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r3.setId(r4)     // Catch:{ all -> 0x07cd }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07cd }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07cd }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07cd }
                    r3.setRank(r4)     // Catch:{ all -> 0x07cd }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07cd }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07cd }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07cd }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07cd }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07cd }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07cd }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07cd }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07cd }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07cd }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07cd }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07cd }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07cd }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d0
                    r1 = 1
                    goto L_0x03d1
                L_0x03d0:
                    r1 = 0
                L_0x03d1:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07cd }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07cd }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07cd }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07cd }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07cd }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07cd }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r30 = r1
                    if (r29 == 0) goto L_0x0422
                    r1 = 1
                    goto L_0x0423
                L_0x0422:
                    r1 = 0
                L_0x0423:
                    r3.canLike = r1     // Catch:{ all -> 0x07cd }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r31 = r1
                    if (r29 == 0) goto L_0x0431
                    r1 = 1
                    goto L_0x0432
                L_0x0431:
                    r1 = 0
                L_0x0432:
                    r3.canComment = r1     // Catch:{ all -> 0x07cd }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r32 = r1
                    if (r29 == 0) goto L_0x0440
                    r1 = 1
                    goto L_0x0441
                L_0x0440:
                    r1 = 0
                L_0x0441:
                    r3.canShare = r1     // Catch:{ all -> 0x07cd }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r33 = r1
                    if (r29 == 0) goto L_0x044f
                    r1 = 1
                    goto L_0x0450
                L_0x044f:
                    r1 = 0
                L_0x0450:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r34 = r1
                    if (r29 == 0) goto L_0x045f
                    r1 = 1
                    goto L_0x0460
                L_0x045f:
                    r1 = 0
                L_0x0460:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07cd }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07cd }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07cd }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07cd }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07cd }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07cd }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07cd }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07cd }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setName(r1)     // Catch:{ all -> 0x07cd }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07cd }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07cd }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07cd }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f3
                    r1 = 1
                    goto L_0x04f4
                L_0x04f3:
                    r1 = 0
                L_0x04f4:
                    r3.setMute(r1)     // Catch:{ all -> 0x07cd }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07cd }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07cd }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07cd }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07cd }
                    r3.setScore(r6)     // Catch:{ all -> 0x07cd }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07cd }
                    if (r7 == 0) goto L_0x052f
                    r7 = 1
                    goto L_0x0530
                L_0x052f:
                    r7 = 0
                L_0x0530:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07cd }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07cd }
                    if (r52 == 0) goto L_0x053f
                    r52 = r1
                    r1 = 1
                    goto L_0x0542
                L_0x053f:
                    r52 = r1
                    r1 = 0
                L_0x0542:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r54 = r1
                    if (r53 == 0) goto L_0x0551
                    r1 = 1
                    goto L_0x0552
                L_0x0551:
                    r1 = 0
                L_0x0552:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07cd }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07cd }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07cd }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07cd }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07cd }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07cd }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07cd }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07cd }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07cd }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07cd }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07cd }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07cd }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07cd }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07cd }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07cd }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07cd }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0622
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07cd }
                    if (r23 != 0) goto L_0x061b
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r6.<init>()     // Catch:{ all -> 0x07cd }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07cd }
                    goto L_0x061f
                L_0x061b:
                    r80 = r6
                    r6 = r23
                L_0x061f:
                    r3.channelList = r6     // Catch:{ all -> 0x07cd }
                    goto L_0x0628
                L_0x0622:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x0628:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x064e
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07cd }
                    if (r22 != 0) goto L_0x0647
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r7.<init>()     // Catch:{ all -> 0x07cd }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07cd }
                    goto L_0x064b
                L_0x0647:
                    r23 = r7
                    r7 = r22
                L_0x064b:
                    r3.brands = r7     // Catch:{ all -> 0x07cd }
                    goto L_0x0652
                L_0x064e:
                    r23 = r7
                    r6 = r22
                L_0x0652:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0678
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07cd }
                    if (r21 != 0) goto L_0x0671
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r8.<init>()     // Catch:{ all -> 0x07cd }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07cd }
                    goto L_0x0675
                L_0x0671:
                    r22 = r8
                    r8 = r21
                L_0x0675:
                    r3.bannersList = r8     // Catch:{ all -> 0x07cd }
                    goto L_0x067c
                L_0x0678:
                    r22 = r8
                    r7 = r21
                L_0x067c:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06a2
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07cd }
                    if (r20 != 0) goto L_0x069b
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r9.<init>()     // Catch:{ all -> 0x07cd }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07cd }
                    goto L_0x069f
                L_0x069b:
                    r21 = r9
                    r9 = r20
                L_0x069f:
                    r3.trendingList = r9     // Catch:{ all -> 0x07cd }
                    goto L_0x06a6
                L_0x06a2:
                    r21 = r9
                    r8 = r20
                L_0x06a6:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06cc
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07cd }
                    if (r19 != 0) goto L_0x06c5
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r11.<init>()     // Catch:{ all -> 0x07cd }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07cd }
                    goto L_0x06c9
                L_0x06c5:
                    r20 = r11
                    r11 = r19
                L_0x06c9:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07cd }
                    goto L_0x06d0
                L_0x06cc:
                    r20 = r11
                    r9 = r19
                L_0x06d0:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06f6
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07cd }
                    if (r18 != 0) goto L_0x06ef
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r12.<init>()     // Catch:{ all -> 0x07cd }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07cd }
                    goto L_0x06f3
                L_0x06ef:
                    r19 = r12
                    r12 = r18
                L_0x06f3:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07cd }
                    goto L_0x06fa
                L_0x06f6:
                    r19 = r12
                    r11 = r18
                L_0x06fa:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0720
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07cd }
                    if (r17 != 0) goto L_0x0719
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r13.<init>()     // Catch:{ all -> 0x07cd }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07cd }
                    goto L_0x071d
                L_0x0719:
                    r18 = r13
                    r13 = r17
                L_0x071d:
                    r3.storiesList = r13     // Catch:{ all -> 0x07cd }
                    goto L_0x0724
                L_0x0720:
                    r18 = r13
                    r12 = r17
                L_0x0724:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x074a
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07cd }
                    if (r16 != 0) goto L_0x0743
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r10.<init>()     // Catch:{ all -> 0x07cd }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07cd }
                    goto L_0x0747
                L_0x0743:
                    r17 = r10
                    r10 = r16
                L_0x0747:
                    r3.pollsList = r10     // Catch:{ all -> 0x07cd }
                    goto L_0x074e
                L_0x074a:
                    r17 = r10
                    r13 = r16
                L_0x074e:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07cd }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07cd }
                    r15.add(r3)     // Catch:{ all -> 0x07cd }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0292
                L_0x078d:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.h(r13)     // Catch:{ all -> 0x07cb }
                    r2.close()
                    return r15
                L_0x07cb:
                    r0 = move-exception
                    goto L_0x07d3
                L_0x07cd:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d3
                L_0x07d1:
                    r0 = move-exception
                    r3 = r1
                L_0x07d3:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass39.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> b() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =6 OR category=7 ORDER BY feedItemCategoryRank ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34703i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x0651 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x065b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x067b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0685 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a5 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06af A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cf A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0703 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0723 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0318 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0319 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03d1 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d3 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0423 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0425 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0432 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0434 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0441 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0443 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0450 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0452 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0460 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0462 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f4 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f6 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0530 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0532 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053e A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0542 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0552 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0554 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0603 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0625 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0631 A[Catch:{ all -> 0x07d0 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34703i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$40$1 r0 = new net.one97.paytm.feed.repository.db.a.b$40$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34703i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34703i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r0.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r3.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r4.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r5.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r6.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r7.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r8.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r9.<init>()     // Catch:{ all -> 0x07d4 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07d0 }
                    r15.<init>(r14)     // Catch:{ all -> 0x07d0 }
                L_0x0295:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x0790
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07d0 }
                    if (r14 != 0) goto L_0x02ba
                    goto L_0x02c5
                L_0x02ba:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02fa
                L_0x02c5:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02d0
                    r83 = r0
                    r14 = r80
                    goto L_0x02da
                L_0x02d0:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07d0 }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07d0 }
                    r83 = r0
                L_0x02da:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07d0 }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07d0 }
                    if (r85 == 0) goto L_0x02f0
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f5
                L_0x02f0:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f5:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07d0 }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07d0 }
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07d0 }
                    if (r0 != 0) goto L_0x0319
                    goto L_0x031c
                L_0x0319:
                    r0 = r80
                    goto L_0x0345
                L_0x031c:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x0325
                L_0x0322:
                    r88 = r80
                    goto L_0x032e
                L_0x0325:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07d0 }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0322
                L_0x032e:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07d0 }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07d0 }
                L_0x0345:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07d0 }
                    r3.<init>()     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r3.setId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07d0 }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07d0 }
                    r3.setRank(r4)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07d0 }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07d0 }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07d0 }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07d0 }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07d0 }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07d0 }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07d0 }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d3
                    r1 = 1
                    goto L_0x03d4
                L_0x03d3:
                    r1 = 0
                L_0x03d4:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07d0 }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07d0 }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07d0 }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07d0 }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r30 = r1
                    if (r29 == 0) goto L_0x0425
                    r1 = 1
                    goto L_0x0426
                L_0x0425:
                    r1 = 0
                L_0x0426:
                    r3.canLike = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r31 = r1
                    if (r29 == 0) goto L_0x0434
                    r1 = 1
                    goto L_0x0435
                L_0x0434:
                    r1 = 0
                L_0x0435:
                    r3.canComment = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r32 = r1
                    if (r29 == 0) goto L_0x0443
                    r1 = 1
                    goto L_0x0444
                L_0x0443:
                    r1 = 0
                L_0x0444:
                    r3.canShare = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r33 = r1
                    if (r29 == 0) goto L_0x0452
                    r1 = 1
                    goto L_0x0453
                L_0x0452:
                    r1 = 0
                L_0x0453:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r34 = r1
                    if (r29 == 0) goto L_0x0462
                    r1 = 1
                    goto L_0x0463
                L_0x0462:
                    r1 = 0
                L_0x0463:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07d0 }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07d0 }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07d0 }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07d0 }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setName(r1)     // Catch:{ all -> 0x07d0 }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07d0 }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07d0 }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07d0 }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f6
                    r1 = 1
                    goto L_0x04f7
                L_0x04f6:
                    r1 = 0
                L_0x04f7:
                    r3.setMute(r1)     // Catch:{ all -> 0x07d0 }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07d0 }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07d0 }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07d0 }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setScore(r6)     // Catch:{ all -> 0x07d0 }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07d0 }
                    if (r7 == 0) goto L_0x0532
                    r7 = 1
                    goto L_0x0533
                L_0x0532:
                    r7 = 0
                L_0x0533:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07d0 }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07d0 }
                    if (r52 == 0) goto L_0x0542
                    r52 = r1
                    r1 = 1
                    goto L_0x0545
                L_0x0542:
                    r52 = r1
                    r1 = 0
                L_0x0545:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r54 = r1
                    if (r53 == 0) goto L_0x0554
                    r1 = 1
                    goto L_0x0555
                L_0x0554:
                    r1 = 0
                L_0x0555:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07d0 }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07d0 }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07d0 }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07d0 }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07d0 }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07d0 }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07d0 }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07d0 }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07d0 }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07d0 }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07d0 }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0625
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07d0 }
                    if (r23 != 0) goto L_0x061e
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r6.<init>()     // Catch:{ all -> 0x07d0 }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0622
                L_0x061e:
                    r80 = r6
                    r6 = r23
                L_0x0622:
                    r3.channelList = r6     // Catch:{ all -> 0x07d0 }
                    goto L_0x062b
                L_0x0625:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x062b:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0651
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07d0 }
                    if (r22 != 0) goto L_0x064a
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r7.<init>()     // Catch:{ all -> 0x07d0 }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07d0 }
                    goto L_0x064e
                L_0x064a:
                    r23 = r7
                    r7 = r22
                L_0x064e:
                    r3.brands = r7     // Catch:{ all -> 0x07d0 }
                    goto L_0x0655
                L_0x0651:
                    r23 = r7
                    r6 = r22
                L_0x0655:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x067b
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07d0 }
                    if (r21 != 0) goto L_0x0674
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r8.<init>()     // Catch:{ all -> 0x07d0 }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0678
                L_0x0674:
                    r22 = r8
                    r8 = r21
                L_0x0678:
                    r3.bannersList = r8     // Catch:{ all -> 0x07d0 }
                    goto L_0x067f
                L_0x067b:
                    r22 = r8
                    r7 = r21
                L_0x067f:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06a5
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07d0 }
                    if (r20 != 0) goto L_0x069e
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r9.<init>()     // Catch:{ all -> 0x07d0 }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a2
                L_0x069e:
                    r21 = r9
                    r9 = r20
                L_0x06a2:
                    r3.trendingList = r9     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a9
                L_0x06a5:
                    r21 = r9
                    r8 = r20
                L_0x06a9:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06cf
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07d0 }
                    if (r19 != 0) goto L_0x06c8
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r11.<init>()     // Catch:{ all -> 0x07d0 }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06cc
                L_0x06c8:
                    r20 = r11
                    r11 = r19
                L_0x06cc:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07d0 }
                    goto L_0x06d3
                L_0x06cf:
                    r20 = r11
                    r9 = r19
                L_0x06d3:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06f9
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07d0 }
                    if (r18 != 0) goto L_0x06f2
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r12.<init>()     // Catch:{ all -> 0x07d0 }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06f6
                L_0x06f2:
                    r19 = r12
                    r12 = r18
                L_0x06f6:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07d0 }
                    goto L_0x06fd
                L_0x06f9:
                    r19 = r12
                    r11 = r18
                L_0x06fd:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0723
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07d0 }
                    if (r17 != 0) goto L_0x071c
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r13.<init>()     // Catch:{ all -> 0x07d0 }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0720
                L_0x071c:
                    r18 = r13
                    r13 = r17
                L_0x0720:
                    r3.storiesList = r13     // Catch:{ all -> 0x07d0 }
                    goto L_0x0727
                L_0x0723:
                    r18 = r13
                    r12 = r17
                L_0x0727:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x074d
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07d0 }
                    if (r16 != 0) goto L_0x0746
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r10.<init>()     // Catch:{ all -> 0x07d0 }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07d0 }
                    goto L_0x074a
                L_0x0746:
                    r17 = r10
                    r10 = r16
                L_0x074a:
                    r3.pollsList = r10     // Catch:{ all -> 0x07d0 }
                    goto L_0x0751
                L_0x074d:
                    r17 = r10
                    r13 = r16
                L_0x0751:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07d0 }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07d0 }
                    r15.add(r3)     // Catch:{ all -> 0x07d0 }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0295
                L_0x0790:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.h(r13)     // Catch:{ all -> 0x07ce }
                    r2.close()
                    return r15
                L_0x07ce:
                    r0 = move-exception
                    goto L_0x07d6
                L_0x07d0:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d6
                L_0x07d4:
                    r0 = move-exception
                    r3 = r1
                L_0x07d6:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass40.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> c() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =1 OR category=3 ORDER BY feedItemRank LIMIT 10 ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34707i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x0651 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x065b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x067b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0685 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a5 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06af A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cf A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0703 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0723 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0318 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0319 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03d1 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d3 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0423 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0425 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0432 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0434 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0441 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0443 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0450 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0452 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0460 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0462 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f4 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f6 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0530 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0532 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053e A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0542 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0552 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0554 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0603 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0625 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0631 A[Catch:{ all -> 0x07d0 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34707i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$41$1 r0 = new net.one97.paytm.feed.repository.db.a.b$41$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34707i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34707i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r0.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r3.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r4.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r5.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r6.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r7.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r8.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r9.<init>()     // Catch:{ all -> 0x07d4 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07d0 }
                    r15.<init>(r14)     // Catch:{ all -> 0x07d0 }
                L_0x0295:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x0790
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07d0 }
                    if (r14 != 0) goto L_0x02ba
                    goto L_0x02c5
                L_0x02ba:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02fa
                L_0x02c5:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02d0
                    r83 = r0
                    r14 = r80
                    goto L_0x02da
                L_0x02d0:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07d0 }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07d0 }
                    r83 = r0
                L_0x02da:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07d0 }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07d0 }
                    if (r85 == 0) goto L_0x02f0
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f5
                L_0x02f0:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f5:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07d0 }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07d0 }
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07d0 }
                    if (r0 != 0) goto L_0x0319
                    goto L_0x031c
                L_0x0319:
                    r0 = r80
                    goto L_0x0345
                L_0x031c:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x0325
                L_0x0322:
                    r88 = r80
                    goto L_0x032e
                L_0x0325:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07d0 }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0322
                L_0x032e:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07d0 }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07d0 }
                L_0x0345:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07d0 }
                    r3.<init>()     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r3.setId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07d0 }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07d0 }
                    r3.setRank(r4)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07d0 }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07d0 }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07d0 }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07d0 }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07d0 }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07d0 }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07d0 }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d3
                    r1 = 1
                    goto L_0x03d4
                L_0x03d3:
                    r1 = 0
                L_0x03d4:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07d0 }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07d0 }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07d0 }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07d0 }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r30 = r1
                    if (r29 == 0) goto L_0x0425
                    r1 = 1
                    goto L_0x0426
                L_0x0425:
                    r1 = 0
                L_0x0426:
                    r3.canLike = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r31 = r1
                    if (r29 == 0) goto L_0x0434
                    r1 = 1
                    goto L_0x0435
                L_0x0434:
                    r1 = 0
                L_0x0435:
                    r3.canComment = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r32 = r1
                    if (r29 == 0) goto L_0x0443
                    r1 = 1
                    goto L_0x0444
                L_0x0443:
                    r1 = 0
                L_0x0444:
                    r3.canShare = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r33 = r1
                    if (r29 == 0) goto L_0x0452
                    r1 = 1
                    goto L_0x0453
                L_0x0452:
                    r1 = 0
                L_0x0453:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r34 = r1
                    if (r29 == 0) goto L_0x0462
                    r1 = 1
                    goto L_0x0463
                L_0x0462:
                    r1 = 0
                L_0x0463:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07d0 }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07d0 }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07d0 }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07d0 }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setName(r1)     // Catch:{ all -> 0x07d0 }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07d0 }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07d0 }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07d0 }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f6
                    r1 = 1
                    goto L_0x04f7
                L_0x04f6:
                    r1 = 0
                L_0x04f7:
                    r3.setMute(r1)     // Catch:{ all -> 0x07d0 }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07d0 }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07d0 }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07d0 }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setScore(r6)     // Catch:{ all -> 0x07d0 }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07d0 }
                    if (r7 == 0) goto L_0x0532
                    r7 = 1
                    goto L_0x0533
                L_0x0532:
                    r7 = 0
                L_0x0533:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07d0 }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07d0 }
                    if (r52 == 0) goto L_0x0542
                    r52 = r1
                    r1 = 1
                    goto L_0x0545
                L_0x0542:
                    r52 = r1
                    r1 = 0
                L_0x0545:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r54 = r1
                    if (r53 == 0) goto L_0x0554
                    r1 = 1
                    goto L_0x0555
                L_0x0554:
                    r1 = 0
                L_0x0555:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07d0 }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07d0 }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07d0 }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07d0 }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07d0 }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07d0 }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07d0 }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07d0 }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07d0 }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07d0 }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07d0 }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0625
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07d0 }
                    if (r23 != 0) goto L_0x061e
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r6.<init>()     // Catch:{ all -> 0x07d0 }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0622
                L_0x061e:
                    r80 = r6
                    r6 = r23
                L_0x0622:
                    r3.channelList = r6     // Catch:{ all -> 0x07d0 }
                    goto L_0x062b
                L_0x0625:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x062b:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0651
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07d0 }
                    if (r22 != 0) goto L_0x064a
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r7.<init>()     // Catch:{ all -> 0x07d0 }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07d0 }
                    goto L_0x064e
                L_0x064a:
                    r23 = r7
                    r7 = r22
                L_0x064e:
                    r3.brands = r7     // Catch:{ all -> 0x07d0 }
                    goto L_0x0655
                L_0x0651:
                    r23 = r7
                    r6 = r22
                L_0x0655:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x067b
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07d0 }
                    if (r21 != 0) goto L_0x0674
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r8.<init>()     // Catch:{ all -> 0x07d0 }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0678
                L_0x0674:
                    r22 = r8
                    r8 = r21
                L_0x0678:
                    r3.bannersList = r8     // Catch:{ all -> 0x07d0 }
                    goto L_0x067f
                L_0x067b:
                    r22 = r8
                    r7 = r21
                L_0x067f:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06a5
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07d0 }
                    if (r20 != 0) goto L_0x069e
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r9.<init>()     // Catch:{ all -> 0x07d0 }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a2
                L_0x069e:
                    r21 = r9
                    r9 = r20
                L_0x06a2:
                    r3.trendingList = r9     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a9
                L_0x06a5:
                    r21 = r9
                    r8 = r20
                L_0x06a9:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06cf
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07d0 }
                    if (r19 != 0) goto L_0x06c8
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r11.<init>()     // Catch:{ all -> 0x07d0 }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06cc
                L_0x06c8:
                    r20 = r11
                    r11 = r19
                L_0x06cc:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07d0 }
                    goto L_0x06d3
                L_0x06cf:
                    r20 = r11
                    r9 = r19
                L_0x06d3:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06f9
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07d0 }
                    if (r18 != 0) goto L_0x06f2
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r12.<init>()     // Catch:{ all -> 0x07d0 }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06f6
                L_0x06f2:
                    r19 = r12
                    r12 = r18
                L_0x06f6:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07d0 }
                    goto L_0x06fd
                L_0x06f9:
                    r19 = r12
                    r11 = r18
                L_0x06fd:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0723
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07d0 }
                    if (r17 != 0) goto L_0x071c
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r13.<init>()     // Catch:{ all -> 0x07d0 }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0720
                L_0x071c:
                    r18 = r13
                    r13 = r17
                L_0x0720:
                    r3.storiesList = r13     // Catch:{ all -> 0x07d0 }
                    goto L_0x0727
                L_0x0723:
                    r18 = r13
                    r12 = r17
                L_0x0727:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x074d
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07d0 }
                    if (r16 != 0) goto L_0x0746
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r10.<init>()     // Catch:{ all -> 0x07d0 }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07d0 }
                    goto L_0x074a
                L_0x0746:
                    r17 = r10
                    r10 = r16
                L_0x074a:
                    r3.pollsList = r10     // Catch:{ all -> 0x07d0 }
                    goto L_0x0751
                L_0x074d:
                    r17 = r10
                    r13 = r16
                L_0x0751:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07d0 }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07d0 }
                    r15.add(r3)     // Catch:{ all -> 0x07d0 }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0295
                L_0x0790:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.h(r13)     // Catch:{ all -> 0x07ce }
                    r2.close()
                    return r15
                L_0x07ce:
                    r0 = move-exception
                    goto L_0x07d6
                L_0x07d0:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d6
                L_0x07d4:
                    r0 = move-exception
                    r3 = r1
                L_0x07d6:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass41.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> d() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =2 OR category=3 ORDER BY feedItemCategoryRank ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34711i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x064e A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x0658 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x0678 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0682 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a2 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06ac A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cc A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d6 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f6 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0700 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0720 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072a A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074a A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0315 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0316 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03ce A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d0 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0420 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0422 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x042f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0431 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x043e A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0440 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x044d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x044f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x045d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x045f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f1 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f3 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x052d A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x052f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053b A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x053f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x054f A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0551 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0600 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0622 A[Catch:{ all -> 0x07cd }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x062e A[Catch:{ all -> 0x07cd }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34711i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$42$1 r0 = new net.one97.paytm.feed.repository.db.a.b$42$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34711i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34711i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r0.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r3.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r4.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r5.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r6.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r7.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r8.<init>()     // Catch:{ all -> 0x07d1 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d1 }
                    r9.<init>()     // Catch:{ all -> 0x07d1 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d1 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07cd }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07cd }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07cd }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07cd }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07cd }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07cd }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07cd }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07cd }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07cd }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07cd }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07cd }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07cd }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07cd }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07cd }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07cd }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07cd }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07cd }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07cd }
                    r15.<init>(r14)     // Catch:{ all -> 0x07cd }
                L_0x0292:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x078d
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07cd }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02c2
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07cd }
                    if (r14 != 0) goto L_0x02b7
                    goto L_0x02c2
                L_0x02b7:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02f7
                L_0x02c2:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07cd }
                    if (r14 == 0) goto L_0x02cd
                    r83 = r0
                    r14 = r80
                    goto L_0x02d7
                L_0x02cd:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07cd }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07cd }
                    r83 = r0
                L_0x02d7:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07cd }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07cd }
                    if (r85 == 0) goto L_0x02ed
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f2
                L_0x02ed:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f2:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07cd }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07cd }
                L_0x02f7:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0319
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07cd }
                    if (r0 != 0) goto L_0x0316
                    goto L_0x0319
                L_0x0316:
                    r0 = r80
                    goto L_0x0342
                L_0x0319:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07cd }
                    if (r0 == 0) goto L_0x0322
                L_0x031f:
                    r88 = r80
                    goto L_0x032b
                L_0x0322:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07cd }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07cd }
                    goto L_0x031f
                L_0x032b:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07cd }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07cd }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07cd }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07cd }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07cd }
                L_0x0342:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07cd }
                    r3.<init>()     // Catch:{ all -> 0x07cd }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r3.setId(r4)     // Catch:{ all -> 0x07cd }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07cd }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07cd }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07cd }
                    r3.setRank(r4)     // Catch:{ all -> 0x07cd }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07cd }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07cd }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07cd }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07cd }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07cd }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07cd }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07cd }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07cd }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07cd }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07cd }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07cd }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07cd }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d0
                    r1 = 1
                    goto L_0x03d1
                L_0x03d0:
                    r1 = 0
                L_0x03d1:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07cd }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07cd }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07cd }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07cd }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07cd }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07cd }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r30 = r1
                    if (r29 == 0) goto L_0x0422
                    r1 = 1
                    goto L_0x0423
                L_0x0422:
                    r1 = 0
                L_0x0423:
                    r3.canLike = r1     // Catch:{ all -> 0x07cd }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r31 = r1
                    if (r29 == 0) goto L_0x0431
                    r1 = 1
                    goto L_0x0432
                L_0x0431:
                    r1 = 0
                L_0x0432:
                    r3.canComment = r1     // Catch:{ all -> 0x07cd }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r32 = r1
                    if (r29 == 0) goto L_0x0440
                    r1 = 1
                    goto L_0x0441
                L_0x0440:
                    r1 = 0
                L_0x0441:
                    r3.canShare = r1     // Catch:{ all -> 0x07cd }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r33 = r1
                    if (r29 == 0) goto L_0x044f
                    r1 = 1
                    goto L_0x0450
                L_0x044f:
                    r1 = 0
                L_0x0450:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r34 = r1
                    if (r29 == 0) goto L_0x045f
                    r1 = 1
                    goto L_0x0460
                L_0x045f:
                    r1 = 0
                L_0x0460:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07cd }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07cd }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07cd }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07cd }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07cd }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07cd }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07cd }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07cd }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setName(r1)     // Catch:{ all -> 0x07cd }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07cd }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07cd }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07cd }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07cd }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f3
                    r1 = 1
                    goto L_0x04f4
                L_0x04f3:
                    r1 = 0
                L_0x04f4:
                    r3.setMute(r1)     // Catch:{ all -> 0x07cd }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07cd }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07cd }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07cd }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07cd }
                    r3.setScore(r6)     // Catch:{ all -> 0x07cd }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07cd }
                    if (r7 == 0) goto L_0x052f
                    r7 = 1
                    goto L_0x0530
                L_0x052f:
                    r7 = 0
                L_0x0530:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07cd }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07cd }
                    if (r52 == 0) goto L_0x053f
                    r52 = r1
                    r1 = 1
                    goto L_0x0542
                L_0x053f:
                    r52 = r1
                    r1 = 0
                L_0x0542:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07cd }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07cd }
                    r54 = r1
                    if (r53 == 0) goto L_0x0551
                    r1 = 1
                    goto L_0x0552
                L_0x0551:
                    r1 = 0
                L_0x0552:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07cd }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07cd }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07cd }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07cd }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07cd }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07cd }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07cd }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07cd }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07cd }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07cd }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07cd }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07cd }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07cd }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07cd }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07cd }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07cd }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07cd }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07cd }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0622
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07cd }
                    if (r23 != 0) goto L_0x061b
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r6.<init>()     // Catch:{ all -> 0x07cd }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07cd }
                    goto L_0x061f
                L_0x061b:
                    r80 = r6
                    r6 = r23
                L_0x061f:
                    r3.channelList = r6     // Catch:{ all -> 0x07cd }
                    goto L_0x0628
                L_0x0622:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x0628:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x064e
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07cd }
                    if (r22 != 0) goto L_0x0647
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r7.<init>()     // Catch:{ all -> 0x07cd }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07cd }
                    goto L_0x064b
                L_0x0647:
                    r23 = r7
                    r7 = r22
                L_0x064b:
                    r3.brands = r7     // Catch:{ all -> 0x07cd }
                    goto L_0x0652
                L_0x064e:
                    r23 = r7
                    r6 = r22
                L_0x0652:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0678
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07cd }
                    if (r21 != 0) goto L_0x0671
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r8.<init>()     // Catch:{ all -> 0x07cd }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07cd }
                    goto L_0x0675
                L_0x0671:
                    r22 = r8
                    r8 = r21
                L_0x0675:
                    r3.bannersList = r8     // Catch:{ all -> 0x07cd }
                    goto L_0x067c
                L_0x0678:
                    r22 = r8
                    r7 = r21
                L_0x067c:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06a2
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07cd }
                    if (r20 != 0) goto L_0x069b
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r9.<init>()     // Catch:{ all -> 0x07cd }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07cd }
                    goto L_0x069f
                L_0x069b:
                    r21 = r9
                    r9 = r20
                L_0x069f:
                    r3.trendingList = r9     // Catch:{ all -> 0x07cd }
                    goto L_0x06a6
                L_0x06a2:
                    r21 = r9
                    r8 = r20
                L_0x06a6:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06cc
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07cd }
                    if (r19 != 0) goto L_0x06c5
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r11.<init>()     // Catch:{ all -> 0x07cd }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07cd }
                    goto L_0x06c9
                L_0x06c5:
                    r20 = r11
                    r11 = r19
                L_0x06c9:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07cd }
                    goto L_0x06d0
                L_0x06cc:
                    r20 = r11
                    r9 = r19
                L_0x06d0:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x06f6
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07cd }
                    if (r18 != 0) goto L_0x06ef
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r12.<init>()     // Catch:{ all -> 0x07cd }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07cd }
                    goto L_0x06f3
                L_0x06ef:
                    r19 = r12
                    r12 = r18
                L_0x06f3:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07cd }
                    goto L_0x06fa
                L_0x06f6:
                    r19 = r12
                    r11 = r18
                L_0x06fa:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x0720
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07cd }
                    if (r17 != 0) goto L_0x0719
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r13.<init>()     // Catch:{ all -> 0x07cd }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07cd }
                    goto L_0x071d
                L_0x0719:
                    r18 = r13
                    r13 = r17
                L_0x071d:
                    r3.storiesList = r13     // Catch:{ all -> 0x07cd }
                    goto L_0x0724
                L_0x0720:
                    r18 = r13
                    r12 = r17
                L_0x0724:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07cd }
                    if (r4 != 0) goto L_0x074a
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07cd }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07cd }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07cd }
                    if (r16 != 0) goto L_0x0743
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07cd }
                    r10.<init>()     // Catch:{ all -> 0x07cd }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07cd }
                    goto L_0x0747
                L_0x0743:
                    r17 = r10
                    r10 = r16
                L_0x0747:
                    r3.pollsList = r10     // Catch:{ all -> 0x07cd }
                    goto L_0x074e
                L_0x074a:
                    r17 = r10
                    r13 = r16
                L_0x074e:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07cd }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07cd }
                    r15.add(r3)     // Catch:{ all -> 0x07cd }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0292
                L_0x078d:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07cb }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07cb }
                    r0.h(r13)     // Catch:{ all -> 0x07cb }
                    r2.close()
                    return r15
                L_0x07cb:
                    r0 = move-exception
                    goto L_0x07d3
                L_0x07cd:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d3
                L_0x07d1:
                    r0 = move-exception
                    r3 = r1
                L_0x07d3:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass42.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> e() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =8 OR following=9 ORDER BY followingRank ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34715i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x0651 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x065b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x067b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0685 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a5 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06af A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cf A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0703 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0723 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0318 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0319 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03d1 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d3 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0423 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0425 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0432 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0434 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0441 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0443 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0450 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0452 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0460 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0462 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f4 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f6 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0530 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0532 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053e A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0542 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0552 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0554 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0603 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0625 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0631 A[Catch:{ all -> 0x07d0 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34715i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$43$1 r0 = new net.one97.paytm.feed.repository.db.a.b$43$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34715i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34715i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r0.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r3.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r4.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r5.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r6.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r7.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r8.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r9.<init>()     // Catch:{ all -> 0x07d4 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07d0 }
                    r15.<init>(r14)     // Catch:{ all -> 0x07d0 }
                L_0x0295:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x0790
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07d0 }
                    if (r14 != 0) goto L_0x02ba
                    goto L_0x02c5
                L_0x02ba:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02fa
                L_0x02c5:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02d0
                    r83 = r0
                    r14 = r80
                    goto L_0x02da
                L_0x02d0:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07d0 }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07d0 }
                    r83 = r0
                L_0x02da:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07d0 }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07d0 }
                    if (r85 == 0) goto L_0x02f0
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f5
                L_0x02f0:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f5:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07d0 }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07d0 }
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07d0 }
                    if (r0 != 0) goto L_0x0319
                    goto L_0x031c
                L_0x0319:
                    r0 = r80
                    goto L_0x0345
                L_0x031c:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x0325
                L_0x0322:
                    r88 = r80
                    goto L_0x032e
                L_0x0325:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07d0 }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0322
                L_0x032e:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07d0 }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07d0 }
                L_0x0345:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07d0 }
                    r3.<init>()     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r3.setId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07d0 }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07d0 }
                    r3.setRank(r4)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07d0 }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07d0 }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07d0 }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07d0 }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07d0 }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07d0 }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07d0 }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d3
                    r1 = 1
                    goto L_0x03d4
                L_0x03d3:
                    r1 = 0
                L_0x03d4:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07d0 }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07d0 }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07d0 }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07d0 }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r30 = r1
                    if (r29 == 0) goto L_0x0425
                    r1 = 1
                    goto L_0x0426
                L_0x0425:
                    r1 = 0
                L_0x0426:
                    r3.canLike = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r31 = r1
                    if (r29 == 0) goto L_0x0434
                    r1 = 1
                    goto L_0x0435
                L_0x0434:
                    r1 = 0
                L_0x0435:
                    r3.canComment = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r32 = r1
                    if (r29 == 0) goto L_0x0443
                    r1 = 1
                    goto L_0x0444
                L_0x0443:
                    r1 = 0
                L_0x0444:
                    r3.canShare = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r33 = r1
                    if (r29 == 0) goto L_0x0452
                    r1 = 1
                    goto L_0x0453
                L_0x0452:
                    r1 = 0
                L_0x0453:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r34 = r1
                    if (r29 == 0) goto L_0x0462
                    r1 = 1
                    goto L_0x0463
                L_0x0462:
                    r1 = 0
                L_0x0463:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07d0 }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07d0 }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07d0 }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07d0 }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setName(r1)     // Catch:{ all -> 0x07d0 }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07d0 }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07d0 }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07d0 }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f6
                    r1 = 1
                    goto L_0x04f7
                L_0x04f6:
                    r1 = 0
                L_0x04f7:
                    r3.setMute(r1)     // Catch:{ all -> 0x07d0 }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07d0 }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07d0 }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07d0 }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setScore(r6)     // Catch:{ all -> 0x07d0 }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07d0 }
                    if (r7 == 0) goto L_0x0532
                    r7 = 1
                    goto L_0x0533
                L_0x0532:
                    r7 = 0
                L_0x0533:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07d0 }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07d0 }
                    if (r52 == 0) goto L_0x0542
                    r52 = r1
                    r1 = 1
                    goto L_0x0545
                L_0x0542:
                    r52 = r1
                    r1 = 0
                L_0x0545:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r54 = r1
                    if (r53 == 0) goto L_0x0554
                    r1 = 1
                    goto L_0x0555
                L_0x0554:
                    r1 = 0
                L_0x0555:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07d0 }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07d0 }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07d0 }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07d0 }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07d0 }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07d0 }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07d0 }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07d0 }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07d0 }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07d0 }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07d0 }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0625
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07d0 }
                    if (r23 != 0) goto L_0x061e
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r6.<init>()     // Catch:{ all -> 0x07d0 }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0622
                L_0x061e:
                    r80 = r6
                    r6 = r23
                L_0x0622:
                    r3.channelList = r6     // Catch:{ all -> 0x07d0 }
                    goto L_0x062b
                L_0x0625:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x062b:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0651
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07d0 }
                    if (r22 != 0) goto L_0x064a
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r7.<init>()     // Catch:{ all -> 0x07d0 }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07d0 }
                    goto L_0x064e
                L_0x064a:
                    r23 = r7
                    r7 = r22
                L_0x064e:
                    r3.brands = r7     // Catch:{ all -> 0x07d0 }
                    goto L_0x0655
                L_0x0651:
                    r23 = r7
                    r6 = r22
                L_0x0655:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x067b
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07d0 }
                    if (r21 != 0) goto L_0x0674
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r8.<init>()     // Catch:{ all -> 0x07d0 }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0678
                L_0x0674:
                    r22 = r8
                    r8 = r21
                L_0x0678:
                    r3.bannersList = r8     // Catch:{ all -> 0x07d0 }
                    goto L_0x067f
                L_0x067b:
                    r22 = r8
                    r7 = r21
                L_0x067f:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06a5
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07d0 }
                    if (r20 != 0) goto L_0x069e
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r9.<init>()     // Catch:{ all -> 0x07d0 }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a2
                L_0x069e:
                    r21 = r9
                    r9 = r20
                L_0x06a2:
                    r3.trendingList = r9     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a9
                L_0x06a5:
                    r21 = r9
                    r8 = r20
                L_0x06a9:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06cf
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07d0 }
                    if (r19 != 0) goto L_0x06c8
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r11.<init>()     // Catch:{ all -> 0x07d0 }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06cc
                L_0x06c8:
                    r20 = r11
                    r11 = r19
                L_0x06cc:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07d0 }
                    goto L_0x06d3
                L_0x06cf:
                    r20 = r11
                    r9 = r19
                L_0x06d3:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06f9
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07d0 }
                    if (r18 != 0) goto L_0x06f2
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r12.<init>()     // Catch:{ all -> 0x07d0 }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06f6
                L_0x06f2:
                    r19 = r12
                    r12 = r18
                L_0x06f6:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07d0 }
                    goto L_0x06fd
                L_0x06f9:
                    r19 = r12
                    r11 = r18
                L_0x06fd:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0723
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07d0 }
                    if (r17 != 0) goto L_0x071c
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r13.<init>()     // Catch:{ all -> 0x07d0 }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0720
                L_0x071c:
                    r18 = r13
                    r13 = r17
                L_0x0720:
                    r3.storiesList = r13     // Catch:{ all -> 0x07d0 }
                    goto L_0x0727
                L_0x0723:
                    r18 = r13
                    r12 = r17
                L_0x0727:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x074d
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07d0 }
                    if (r16 != 0) goto L_0x0746
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r10.<init>()     // Catch:{ all -> 0x07d0 }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07d0 }
                    goto L_0x074a
                L_0x0746:
                    r17 = r10
                    r10 = r16
                L_0x074a:
                    r3.pollsList = r10     // Catch:{ all -> 0x07d0 }
                    goto L_0x0751
                L_0x074d:
                    r17 = r10
                    r13 = r16
                L_0x0751:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07d0 }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07d0 }
                    r15.add(r3)     // Catch:{ all -> 0x07d0 }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0295
                L_0x0790:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.h(r13)     // Catch:{ all -> 0x07ce }
                    r2.close()
                    return r15
                L_0x07ce:
                    r0 = move-exception
                    goto L_0x07d6
                L_0x07d0:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d6
                L_0x07d4:
                    r0 = move-exception
                    r3 = r1
                L_0x07d6:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass43.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> f() {
        final m a2 = m.a("SELECT * FROM feeddata WHERE category =4 OR category=5 ORDER BY profileRank ", 0);
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34719i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x0651 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x065b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x067b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0685 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a5 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06af A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cf A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0703 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0723 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0318 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0319 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03d1 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d3 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0423 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0425 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0432 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0434 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0441 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0443 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0450 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0452 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0460 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0462 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f4 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f6 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0530 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0532 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053e A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0542 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0552 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0554 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0603 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0625 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0631 A[Catch:{ all -> 0x07d0 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34719i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$44$1 r0 = new net.one97.paytm.feed.repository.db.a.b$44$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34719i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34719i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r0
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r0.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r3.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r4.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r5.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r6.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r7.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r8.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r9.<init>()     // Catch:{ all -> 0x07d4 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07d0 }
                    r15.<init>(r14)     // Catch:{ all -> 0x07d0 }
                L_0x0295:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x0790
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07d0 }
                    if (r14 != 0) goto L_0x02ba
                    goto L_0x02c5
                L_0x02ba:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02fa
                L_0x02c5:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02d0
                    r83 = r0
                    r14 = r80
                    goto L_0x02da
                L_0x02d0:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07d0 }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07d0 }
                    r83 = r0
                L_0x02da:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07d0 }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07d0 }
                    if (r85 == 0) goto L_0x02f0
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f5
                L_0x02f0:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f5:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07d0 }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07d0 }
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07d0 }
                    if (r0 != 0) goto L_0x0319
                    goto L_0x031c
                L_0x0319:
                    r0 = r80
                    goto L_0x0345
                L_0x031c:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x0325
                L_0x0322:
                    r88 = r80
                    goto L_0x032e
                L_0x0325:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07d0 }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0322
                L_0x032e:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07d0 }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07d0 }
                L_0x0345:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07d0 }
                    r3.<init>()     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r3.setId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07d0 }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07d0 }
                    r3.setRank(r4)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07d0 }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07d0 }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07d0 }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07d0 }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07d0 }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07d0 }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07d0 }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d3
                    r1 = 1
                    goto L_0x03d4
                L_0x03d3:
                    r1 = 0
                L_0x03d4:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07d0 }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07d0 }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07d0 }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07d0 }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r30 = r1
                    if (r29 == 0) goto L_0x0425
                    r1 = 1
                    goto L_0x0426
                L_0x0425:
                    r1 = 0
                L_0x0426:
                    r3.canLike = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r31 = r1
                    if (r29 == 0) goto L_0x0434
                    r1 = 1
                    goto L_0x0435
                L_0x0434:
                    r1 = 0
                L_0x0435:
                    r3.canComment = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r32 = r1
                    if (r29 == 0) goto L_0x0443
                    r1 = 1
                    goto L_0x0444
                L_0x0443:
                    r1 = 0
                L_0x0444:
                    r3.canShare = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r33 = r1
                    if (r29 == 0) goto L_0x0452
                    r1 = 1
                    goto L_0x0453
                L_0x0452:
                    r1 = 0
                L_0x0453:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r34 = r1
                    if (r29 == 0) goto L_0x0462
                    r1 = 1
                    goto L_0x0463
                L_0x0462:
                    r1 = 0
                L_0x0463:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07d0 }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07d0 }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07d0 }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07d0 }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setName(r1)     // Catch:{ all -> 0x07d0 }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07d0 }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07d0 }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07d0 }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f6
                    r1 = 1
                    goto L_0x04f7
                L_0x04f6:
                    r1 = 0
                L_0x04f7:
                    r3.setMute(r1)     // Catch:{ all -> 0x07d0 }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07d0 }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07d0 }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07d0 }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setScore(r6)     // Catch:{ all -> 0x07d0 }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07d0 }
                    if (r7 == 0) goto L_0x0532
                    r7 = 1
                    goto L_0x0533
                L_0x0532:
                    r7 = 0
                L_0x0533:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07d0 }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07d0 }
                    if (r52 == 0) goto L_0x0542
                    r52 = r1
                    r1 = 1
                    goto L_0x0545
                L_0x0542:
                    r52 = r1
                    r1 = 0
                L_0x0545:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r54 = r1
                    if (r53 == 0) goto L_0x0554
                    r1 = 1
                    goto L_0x0555
                L_0x0554:
                    r1 = 0
                L_0x0555:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07d0 }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07d0 }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07d0 }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07d0 }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07d0 }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07d0 }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07d0 }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07d0 }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07d0 }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07d0 }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07d0 }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0625
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07d0 }
                    if (r23 != 0) goto L_0x061e
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r6.<init>()     // Catch:{ all -> 0x07d0 }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0622
                L_0x061e:
                    r80 = r6
                    r6 = r23
                L_0x0622:
                    r3.channelList = r6     // Catch:{ all -> 0x07d0 }
                    goto L_0x062b
                L_0x0625:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x062b:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0651
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07d0 }
                    if (r22 != 0) goto L_0x064a
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r7.<init>()     // Catch:{ all -> 0x07d0 }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07d0 }
                    goto L_0x064e
                L_0x064a:
                    r23 = r7
                    r7 = r22
                L_0x064e:
                    r3.brands = r7     // Catch:{ all -> 0x07d0 }
                    goto L_0x0655
                L_0x0651:
                    r23 = r7
                    r6 = r22
                L_0x0655:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x067b
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07d0 }
                    if (r21 != 0) goto L_0x0674
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r8.<init>()     // Catch:{ all -> 0x07d0 }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0678
                L_0x0674:
                    r22 = r8
                    r8 = r21
                L_0x0678:
                    r3.bannersList = r8     // Catch:{ all -> 0x07d0 }
                    goto L_0x067f
                L_0x067b:
                    r22 = r8
                    r7 = r21
                L_0x067f:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06a5
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07d0 }
                    if (r20 != 0) goto L_0x069e
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r9.<init>()     // Catch:{ all -> 0x07d0 }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a2
                L_0x069e:
                    r21 = r9
                    r9 = r20
                L_0x06a2:
                    r3.trendingList = r9     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a9
                L_0x06a5:
                    r21 = r9
                    r8 = r20
                L_0x06a9:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06cf
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07d0 }
                    if (r19 != 0) goto L_0x06c8
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r11.<init>()     // Catch:{ all -> 0x07d0 }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06cc
                L_0x06c8:
                    r20 = r11
                    r11 = r19
                L_0x06cc:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07d0 }
                    goto L_0x06d3
                L_0x06cf:
                    r20 = r11
                    r9 = r19
                L_0x06d3:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06f9
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07d0 }
                    if (r18 != 0) goto L_0x06f2
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r12.<init>()     // Catch:{ all -> 0x07d0 }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06f6
                L_0x06f2:
                    r19 = r12
                    r12 = r18
                L_0x06f6:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07d0 }
                    goto L_0x06fd
                L_0x06f9:
                    r19 = r12
                    r11 = r18
                L_0x06fd:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0723
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07d0 }
                    if (r17 != 0) goto L_0x071c
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r13.<init>()     // Catch:{ all -> 0x07d0 }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0720
                L_0x071c:
                    r18 = r13
                    r13 = r17
                L_0x0720:
                    r3.storiesList = r13     // Catch:{ all -> 0x07d0 }
                    goto L_0x0727
                L_0x0723:
                    r18 = r13
                    r12 = r17
                L_0x0727:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x074d
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07d0 }
                    if (r16 != 0) goto L_0x0746
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r10.<init>()     // Catch:{ all -> 0x07d0 }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07d0 }
                    goto L_0x074a
                L_0x0746:
                    r17 = r10
                    r10 = r16
                L_0x074a:
                    r3.pollsList = r10     // Catch:{ all -> 0x07d0 }
                    goto L_0x0751
                L_0x074d:
                    r17 = r10
                    r13 = r16
                L_0x0751:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07d0 }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07d0 }
                    r15.add(r3)     // Catch:{ all -> 0x07d0 }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0295
                L_0x0790:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.h(r13)     // Catch:{ all -> 0x07ce }
                    r2.close()
                    return r15
                L_0x07ce:
                    r0 = move-exception
                    goto L_0x07d6
                L_0x07d0:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d6
                L_0x07d4:
                    r0 = move-exception
                    r3 = r1
                L_0x07d6:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass44.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<FeedDataMinimal> f(String str) {
        final m a2 = m.a("SELECT * FROM FeedData WHERE id = ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        return new d<FeedDataMinimal>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34724i;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v0, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v1, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v2, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v4, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r83v0, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r79v5, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX WARNING: type inference failed for: r79v3, types: [java.lang.Double] */
            /* access modifiers changed from: private */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x05b1 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x05ca A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x05d2 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x05eb A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x05f3 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x060c A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:123:0x0614 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:127:0x062d A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x0635 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x064e A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0656 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x066f A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x02f6 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x02f7 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x039b A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x039d A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x03df A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x03e1 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x03ec A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x03ee A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x03f9 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x03fb A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0406 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0408 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0414 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0416 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x048e A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x0490 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x04c0 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x04c2 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x04ce A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x04d0 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x04dc A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x04de A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x056f A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0588 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x0590 A[Catch:{ all -> 0x06b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x05a9 A[Catch:{ all -> 0x06b8 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.one97.paytm.feed.repository.models.FeedDataMinimal b() {
                /*
                    r88 = this;
                    r1 = r88
                    androidx.room.g$b r0 = r1.f34724i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$46$1 r0 = new net.one97.paytm.feed.repository.db.a.b$46$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "FeedData"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34724i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34724i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r1
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r0.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r3.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r4.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r5.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r6.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r7.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r8.<init>()     // Catch:{ all -> 0x06bc }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x06bc }
                    r9.<init>()     // Catch:{ all -> 0x06bc }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x06bc }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x06bc }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x06bc }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x06bc }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x06bc }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x06bc }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x06b8 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x06b8 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x06b8 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x06b8 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x06b8 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x06b8 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x06b8 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x06b8 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x06b8 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x06b8 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x06b8 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x06b8 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x06b8 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x06b8 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x06b8 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x06b8 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x06b8 }
                    boolean r78 = r2.moveToFirst()     // Catch:{ all -> 0x06b8 }
                    r79 = 0
                    if (r78 == 0) goto L_0x067a
                    boolean r78 = r2.isNull(r0)     // Catch:{ all -> 0x06b8 }
                    r80 = 1
                    r81 = 0
                    if (r78 == 0) goto L_0x02af
                    boolean r78 = r2.isNull(r3)     // Catch:{ all -> 0x06b8 }
                    if (r78 == 0) goto L_0x02af
                    boolean r78 = r2.isNull(r4)     // Catch:{ all -> 0x06b8 }
                    if (r78 == 0) goto L_0x02af
                    boolean r78 = r2.isNull(r5)     // Catch:{ all -> 0x06b8 }
                    if (r78 != 0) goto L_0x02aa
                    goto L_0x02af
                L_0x02aa:
                    r78 = r15
                    r15 = r79
                    goto L_0x02d8
                L_0x02af:
                    boolean r78 = r2.isNull(r0)     // Catch:{ all -> 0x06b8 }
                    if (r78 == 0) goto L_0x02b8
                    r0 = r79
                    goto L_0x02c0
                L_0x02b8:
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x06b8 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x06b8 }
                L_0x02c0:
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x06b8 }
                    int r5 = r2.getInt(r5)     // Catch:{ all -> 0x06b8 }
                    r78 = r15
                    if (r5 == 0) goto L_0x02d2
                    r5 = 1
                    goto L_0x02d3
                L_0x02d2:
                    r5 = 0
                L_0x02d3:
                    net.one97.paytm.feed.repository.models.CreatedBy r15 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x06b8 }
                    r15.<init>(r0, r3, r4, r5)     // Catch:{ all -> 0x06b8 }
                L_0x02d8:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x06b8 }
                    if (r0 == 0) goto L_0x02fa
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x06b8 }
                    if (r0 == 0) goto L_0x02fa
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x06b8 }
                    if (r0 == 0) goto L_0x02fa
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x06b8 }
                    if (r0 == 0) goto L_0x02fa
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x06b8 }
                    if (r0 != 0) goto L_0x02f7
                    goto L_0x02fa
                L_0x02f7:
                    r0 = r79
                    goto L_0x0323
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x06b8 }
                    if (r0 == 0) goto L_0x0303
                L_0x0300:
                    r83 = r79
                    goto L_0x030c
                L_0x0303:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x06b8 }
                    java.lang.Double r79 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x06b8 }
                    goto L_0x0300
                L_0x030c:
                    java.lang.String r84 = r2.getString(r7)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r85 = r2.getString(r8)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r86 = r2.getString(r9)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r87 = r2.getString(r1)     // Catch:{ all -> 0x06b8 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x06b8 }
                    r82 = r0
                    r82.<init>(r83, r84, r85, r86, r87)     // Catch:{ all -> 0x06b8 }
                L_0x0323:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r1 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x06b8 }
                    r1.<init>()     // Catch:{ all -> 0x06b8 }
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r1.setId(r3)     // Catch:{ all -> 0x06b8 }
                    int r3 = r2.getInt(r11)     // Catch:{ all -> 0x06b8 }
                    r1.setUiId(r3)     // Catch:{ all -> 0x06b8 }
                    int r3 = r2.getInt(r12)     // Catch:{ all -> 0x06b8 }
                    r1.setRank(r3)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r3 = r2.getString(r13)     // Catch:{ all -> 0x06b8 }
                    r1.setPoweredBy(r3)     // Catch:{ all -> 0x06b8 }
                    java.lang.String r3 = r2.getString(r14)     // Catch:{ all -> 0x06b8 }
                    r1.setCreatedAt(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r78
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setImageUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r77
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setWidth(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r76
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setHeight(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r75
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setTitle(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r74
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setWebUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r73
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setLikeCount(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r72
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setCommentCount(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r71
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setShareCount(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r70
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x039d
                    r3 = 1
                    goto L_0x039e
                L_0x039d:
                    r3 = 0
                L_0x039e:
                    r1.setLiked(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r24
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setDescription(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r25
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setDisplayTime(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r26
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r27
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setStreamUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r28
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setDuration(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r29
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setViewCount(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r30
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x03e1
                    r3 = 1
                    goto L_0x03e2
                L_0x03e1:
                    r3 = 0
                L_0x03e2:
                    r1.canLike = r3     // Catch:{ all -> 0x06b8 }
                    r3 = r31
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x03ee
                    r3 = 1
                    goto L_0x03ef
                L_0x03ee:
                    r3 = 0
                L_0x03ef:
                    r1.canComment = r3     // Catch:{ all -> 0x06b8 }
                    r3 = r32
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x03fb
                    r3 = 1
                    goto L_0x03fc
                L_0x03fb:
                    r3 = 0
                L_0x03fc:
                    r1.canShare = r3     // Catch:{ all -> 0x06b8 }
                    r3 = r33
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x0408
                    r3 = 1
                    goto L_0x0409
                L_0x0408:
                    r3 = 0
                L_0x0409:
                    r1.setSensitive(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r34
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x0416
                    r3 = 1
                    goto L_0x0417
                L_0x0416:
                    r3 = 0
                L_0x0417:
                    r1.setFlaggedByUser(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r35
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setDeepLinkUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r36
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setCategory(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r37
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setViewAllUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r38
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setBuckets(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r39
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setFeedItemType(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r40
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setLogoUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r41
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setShareUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r42
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setName(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r43
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setFeedItemRank(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r44
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setFeedItemCategoryRank(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r45
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setProfileRank(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r46
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setFollowingRank(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r47
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x0490
                    r3 = 1
                    goto L_0x0491
                L_0x0490:
                    r3 = 0
                L_0x0491:
                    r1.setMute(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r48
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setMlVersion(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r49
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setContentFormat(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r50
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setMlCategory(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r51
                    double r3 = r2.getDouble(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setScore(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r52
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x04c2
                    r3 = 1
                    goto L_0x04c3
                L_0x04c2:
                    r3 = 0
                L_0x04c3:
                    r1.setBookmarked(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r53
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x04d0
                    r3 = 1
                    goto L_0x04d1
                L_0x04d0:
                    r3 = 0
                L_0x04d1:
                    r1.setFollowed(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r54
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x06b8 }
                    if (r3 == 0) goto L_0x04de
                    r3 = 1
                    goto L_0x04df
                L_0x04de:
                    r3 = 0
                L_0x04df:
                    r1.setCanFollow(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r55
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setLikeCountDisplay(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r56
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setCommentCountDisplay(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r57
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setShareCountDisplay(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r58
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setHomeTeamAbbr(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r59
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setAwayTeamAbbr(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r60
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setHomeTeamLogo(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r61
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setAwayTeamLogo(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r62
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setHomeTeamId(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r63
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setAwayTeamId(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r64
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setDataUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r65
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setClickUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r66
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setMatchId(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r67
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setStartTime(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r68
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setCtaImageUrl(r3)     // Catch:{ all -> 0x06b8 }
                    r3 = r69
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x06b8 }
                    r1.setCtaDisplayText(r3)     // Catch:{ all -> 0x06b8 }
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x0588
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r4 = r23
                    java.lang.Object r5 = r4.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x06b8 }
                    if (r5 != 0) goto L_0x0585
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r5.<init>()     // Catch:{ all -> 0x06b8 }
                    r4.put(r3, r5)     // Catch:{ all -> 0x06b8 }
                L_0x0585:
                    r1.channelList = r5     // Catch:{ all -> 0x06b8 }
                    goto L_0x058a
                L_0x0588:
                    r4 = r23
                L_0x058a:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x05a9
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r5 = r22
                    java.lang.Object r6 = r5.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x06b8 }
                    if (r6 != 0) goto L_0x05a6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r6.<init>()     // Catch:{ all -> 0x06b8 }
                    r5.put(r3, r6)     // Catch:{ all -> 0x06b8 }
                L_0x05a6:
                    r1.brands = r6     // Catch:{ all -> 0x06b8 }
                    goto L_0x05ab
                L_0x05a9:
                    r5 = r22
                L_0x05ab:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x05ca
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r6 = r21
                    java.lang.Object r7 = r6.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x06b8 }
                    if (r7 != 0) goto L_0x05c7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r7.<init>()     // Catch:{ all -> 0x06b8 }
                    r6.put(r3, r7)     // Catch:{ all -> 0x06b8 }
                L_0x05c7:
                    r1.bannersList = r7     // Catch:{ all -> 0x06b8 }
                    goto L_0x05cc
                L_0x05ca:
                    r6 = r21
                L_0x05cc:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x05eb
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r7 = r20
                    java.lang.Object r8 = r7.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x06b8 }
                    if (r8 != 0) goto L_0x05e8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r8.<init>()     // Catch:{ all -> 0x06b8 }
                    r7.put(r3, r8)     // Catch:{ all -> 0x06b8 }
                L_0x05e8:
                    r1.trendingList = r8     // Catch:{ all -> 0x06b8 }
                    goto L_0x05ed
                L_0x05eb:
                    r7 = r20
                L_0x05ed:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x060c
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r8 = r19
                    java.lang.Object r9 = r8.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x06b8 }
                    if (r9 != 0) goto L_0x0609
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r9.<init>()     // Catch:{ all -> 0x06b8 }
                    r8.put(r3, r9)     // Catch:{ all -> 0x06b8 }
                L_0x0609:
                    r1.recommendedAppsList = r9     // Catch:{ all -> 0x06b8 }
                    goto L_0x060e
                L_0x060c:
                    r8 = r19
                L_0x060e:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x062d
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r9 = r18
                    java.lang.Object r11 = r9.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x06b8 }
                    if (r11 != 0) goto L_0x062a
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r11.<init>()     // Catch:{ all -> 0x06b8 }
                    r9.put(r3, r11)     // Catch:{ all -> 0x06b8 }
                L_0x062a:
                    r1.recommendedList = r11     // Catch:{ all -> 0x06b8 }
                    goto L_0x062f
                L_0x062d:
                    r9 = r18
                L_0x062f:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x064e
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r11 = r17
                    java.lang.Object r12 = r11.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x06b8 }
                    if (r12 != 0) goto L_0x064b
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r12.<init>()     // Catch:{ all -> 0x06b8 }
                    r11.put(r3, r12)     // Catch:{ all -> 0x06b8 }
                L_0x064b:
                    r1.storiesList = r12     // Catch:{ all -> 0x06b8 }
                    goto L_0x0650
                L_0x064e:
                    r11 = r17
                L_0x0650:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x06b8 }
                    if (r3 != 0) goto L_0x066f
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x06b8 }
                    r10 = r16
                    java.lang.Object r12 = r10.get(r3)     // Catch:{ all -> 0x06b8 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x06b8 }
                    if (r12 != 0) goto L_0x066c
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x06b8 }
                    r12.<init>()     // Catch:{ all -> 0x06b8 }
                    r10.put(r3, r12)     // Catch:{ all -> 0x06b8 }
                L_0x066c:
                    r1.pollsList = r12     // Catch:{ all -> 0x06b8 }
                    goto L_0x0671
                L_0x066f:
                    r10 = r16
                L_0x0671:
                    r1.setCreatedBy(r15)     // Catch:{ all -> 0x06b8 }
                    r1.setMlProperties(r0)     // Catch:{ all -> 0x06b8 }
                    r79 = r1
                    goto L_0x068a
                L_0x067a:
                    r10 = r16
                    r11 = r17
                    r9 = r18
                    r8 = r19
                    r7 = r20
                    r6 = r21
                    r5 = r22
                    r4 = r23
                L_0x068a:
                    r1 = r88
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r4)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r5)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r6)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r7)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r8)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r9)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r11)     // Catch:{ all -> 0x06bc }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x06bc }
                    r0.h(r10)     // Catch:{ all -> 0x06bc }
                    r2.close()
                    return r79
                L_0x06b8:
                    r0 = move-exception
                    r1 = r88
                    goto L_0x06bd
                L_0x06bc:
                    r0 = move-exception
                L_0x06bd:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass46.b():net.one97.paytm.feed.repository.models.FeedDataMinimal");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<FeedDataMinimal> g(String str) {
        final m a2 = m.a("SELECT * FROM FeedOfFeed WHERE id = ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        return new d<FeedDataMinimal>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34728i;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v0, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v1, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v2, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v4, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r67v0, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v5, resolved type: net.one97.paytm.feed.repository.models.FeedDataMinimal} */
            /* JADX WARNING: type inference failed for: r63v3, types: [java.lang.Double] */
            /* access modifiers changed from: private */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x049e A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x04b7 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x04bf A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x04d8 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x04e0 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x04f9 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:123:0x0501 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:127:0x051a A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x0522 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x053b A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0543 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x055c A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0273 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0274 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0318 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x031a A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0353 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0355 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x0360 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0362 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x036d A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x036f A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x037a A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x037c A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0388 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x038a A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x039f A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x03a1 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x03ad A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x03af A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x03bb A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x03bd A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x03c9 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x03cb A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x045c A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0475 A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x047d A[Catch:{ all -> 0x05a5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0496 A[Catch:{ all -> 0x05a5 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.one97.paytm.feed.repository.models.FeedDataMinimal b() {
                /*
                    r72 = this;
                    r1 = r72
                    androidx.room.g$b r0 = r1.f34728i
                    if (r0 != 0) goto L_0x002e
                    net.one97.paytm.feed.repository.db.a.b$47$1 r0 = new net.one97.paytm.feed.repository.db.a.b$47$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34728i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34728i
                    r0.b(r2)
                L_0x002e:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r1
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r0.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r3.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r4.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r5.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r6.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r7.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r8.<init>()     // Catch:{ all -> 0x05a9 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x05a9 }
                    r9.<init>()     // Catch:{ all -> 0x05a9 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x05a9 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x05a5 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x05a5 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x05a5 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x05a5 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x05a5 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x05a5 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x05a5 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x05a5 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r25 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r26 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r27 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r28 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r29 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r30 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r31 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r32 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r33 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r34 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r35 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r36 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r37 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r38 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r39 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r40 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r41 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r42 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r43 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r44 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r45 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r46 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r47 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r48 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r49 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r50 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r51 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r52 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r53 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x05a5 }
                    r54 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x05a5 }
                    r55 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x05a5 }
                    r56 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x05a5 }
                    r57 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x05a5 }
                    r58 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x05a5 }
                    r59 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x05a5 }
                    r60 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x05a5 }
                    r61 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x05a5 }
                    boolean r62 = r2.moveToFirst()     // Catch:{ all -> 0x05a5 }
                    r63 = 0
                    if (r62 == 0) goto L_0x0567
                    boolean r62 = r2.isNull(r0)     // Catch:{ all -> 0x05a5 }
                    r64 = 1
                    r65 = 0
                    if (r62 == 0) goto L_0x022c
                    boolean r62 = r2.isNull(r3)     // Catch:{ all -> 0x05a5 }
                    if (r62 == 0) goto L_0x022c
                    boolean r62 = r2.isNull(r4)     // Catch:{ all -> 0x05a5 }
                    if (r62 == 0) goto L_0x022c
                    boolean r62 = r2.isNull(r5)     // Catch:{ all -> 0x05a5 }
                    if (r62 != 0) goto L_0x0227
                    goto L_0x022c
                L_0x0227:
                    r62 = r15
                    r15 = r63
                    goto L_0x0255
                L_0x022c:
                    boolean r62 = r2.isNull(r0)     // Catch:{ all -> 0x05a5 }
                    if (r62 == 0) goto L_0x0235
                    r0 = r63
                    goto L_0x023d
                L_0x0235:
                    int r0 = r2.getInt(r0)     // Catch:{ all -> 0x05a5 }
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x05a5 }
                L_0x023d:
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x05a5 }
                    int r5 = r2.getInt(r5)     // Catch:{ all -> 0x05a5 }
                    r62 = r15
                    if (r5 == 0) goto L_0x024f
                    r5 = 1
                    goto L_0x0250
                L_0x024f:
                    r5 = 0
                L_0x0250:
                    net.one97.paytm.feed.repository.models.CreatedBy r15 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x05a5 }
                    r15.<init>(r0, r3, r4, r5)     // Catch:{ all -> 0x05a5 }
                L_0x0255:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x05a5 }
                    if (r0 == 0) goto L_0x0277
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x05a5 }
                    if (r0 == 0) goto L_0x0277
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x05a5 }
                    if (r0 == 0) goto L_0x0277
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x05a5 }
                    if (r0 == 0) goto L_0x0277
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x05a5 }
                    if (r0 != 0) goto L_0x0274
                    goto L_0x0277
                L_0x0274:
                    r0 = r63
                    goto L_0x02a0
                L_0x0277:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x05a5 }
                    if (r0 == 0) goto L_0x0280
                L_0x027d:
                    r67 = r63
                    goto L_0x0289
                L_0x0280:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x05a5 }
                    java.lang.Double r63 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x05a5 }
                    goto L_0x027d
                L_0x0289:
                    java.lang.String r68 = r2.getString(r7)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r69 = r2.getString(r8)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r70 = r2.getString(r9)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r71 = r2.getString(r1)     // Catch:{ all -> 0x05a5 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x05a5 }
                    r66 = r0
                    r66.<init>(r67, r68, r69, r70, r71)     // Catch:{ all -> 0x05a5 }
                L_0x02a0:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r1 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x05a5 }
                    r1.<init>()     // Catch:{ all -> 0x05a5 }
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r1.setId(r3)     // Catch:{ all -> 0x05a5 }
                    int r3 = r2.getInt(r11)     // Catch:{ all -> 0x05a5 }
                    r1.setUiId(r3)     // Catch:{ all -> 0x05a5 }
                    int r3 = r2.getInt(r12)     // Catch:{ all -> 0x05a5 }
                    r1.setRank(r3)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r3 = r2.getString(r13)     // Catch:{ all -> 0x05a5 }
                    r1.setPoweredBy(r3)     // Catch:{ all -> 0x05a5 }
                    java.lang.String r3 = r2.getString(r14)     // Catch:{ all -> 0x05a5 }
                    r1.setCreatedAt(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r62
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setImageUrl(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r61
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setWidth(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r60
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setHeight(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r59
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setTitle(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r58
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setWebUrl(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r57
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setLikeCount(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r56
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setCommentCount(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r55
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setShareCount(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r54
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x031a
                    r3 = 1
                    goto L_0x031b
                L_0x031a:
                    r3 = 0
                L_0x031b:
                    r1.setLiked(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r24
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setDescription(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r25
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setDisplayTime(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r26
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setStreamUrl(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r27
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setDuration(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r28
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setViewCount(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r29
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x0355
                    r3 = 1
                    goto L_0x0356
                L_0x0355:
                    r3 = 0
                L_0x0356:
                    r1.canLike = r3     // Catch:{ all -> 0x05a5 }
                    r3 = r30
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x0362
                    r3 = 1
                    goto L_0x0363
                L_0x0362:
                    r3 = 0
                L_0x0363:
                    r1.canComment = r3     // Catch:{ all -> 0x05a5 }
                    r3 = r31
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x036f
                    r3 = 1
                    goto L_0x0370
                L_0x036f:
                    r3 = 0
                L_0x0370:
                    r1.canShare = r3     // Catch:{ all -> 0x05a5 }
                    r3 = r32
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x037c
                    r3 = 1
                    goto L_0x037d
                L_0x037c:
                    r3 = 0
                L_0x037d:
                    r1.setSensitive(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r33
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x038a
                    r3 = 1
                    goto L_0x038b
                L_0x038a:
                    r3 = 0
                L_0x038b:
                    r1.setFlaggedByUser(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r34
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setCategory(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r35
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x03a1
                    r3 = 1
                    goto L_0x03a2
                L_0x03a1:
                    r3 = 0
                L_0x03a2:
                    r1.setMute(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r36
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x03af
                    r3 = 1
                    goto L_0x03b0
                L_0x03af:
                    r3 = 0
                L_0x03b0:
                    r1.setBookmarked(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r37
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x03bd
                    r3 = 1
                    goto L_0x03be
                L_0x03bd:
                    r3 = 0
                L_0x03be:
                    r1.setFollowed(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r38
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    if (r3 == 0) goto L_0x03cb
                    r3 = 1
                    goto L_0x03cc
                L_0x03cb:
                    r3 = 0
                L_0x03cc:
                    r1.setCanFollow(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r39
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setLikeCountDisplay(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r40
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setCommentCountDisplay(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r41
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setShareCountDisplay(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r42
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setBuckets(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r43
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setFeedItemType(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r44
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setFeedItemRank(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r45
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setFeedItemCategoryRank(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r46
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setProfileRank(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r47
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setMlVersion(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r48
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setContentFormat(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r49
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setMlCategory(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r50
                    double r3 = r2.getDouble(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setScore(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r51
                    int r3 = r2.getInt(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setFollowingRank(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r52
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setCtaImageUrl(r3)     // Catch:{ all -> 0x05a5 }
                    r3 = r53
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x05a5 }
                    r1.setCtaDisplayText(r3)     // Catch:{ all -> 0x05a5 }
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x0475
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r4 = r23
                    java.lang.Object r5 = r4.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x05a5 }
                    if (r5 != 0) goto L_0x0472
                    java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r5.<init>()     // Catch:{ all -> 0x05a5 }
                    r4.put(r3, r5)     // Catch:{ all -> 0x05a5 }
                L_0x0472:
                    r1.channelList = r5     // Catch:{ all -> 0x05a5 }
                    goto L_0x0477
                L_0x0475:
                    r4 = r23
                L_0x0477:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x0496
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r5 = r22
                    java.lang.Object r6 = r5.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x05a5 }
                    if (r6 != 0) goto L_0x0493
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r6.<init>()     // Catch:{ all -> 0x05a5 }
                    r5.put(r3, r6)     // Catch:{ all -> 0x05a5 }
                L_0x0493:
                    r1.brands = r6     // Catch:{ all -> 0x05a5 }
                    goto L_0x0498
                L_0x0496:
                    r5 = r22
                L_0x0498:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x04b7
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r6 = r21
                    java.lang.Object r7 = r6.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x05a5 }
                    if (r7 != 0) goto L_0x04b4
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r7.<init>()     // Catch:{ all -> 0x05a5 }
                    r6.put(r3, r7)     // Catch:{ all -> 0x05a5 }
                L_0x04b4:
                    r1.bannersList = r7     // Catch:{ all -> 0x05a5 }
                    goto L_0x04b9
                L_0x04b7:
                    r6 = r21
                L_0x04b9:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x04d8
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r7 = r20
                    java.lang.Object r8 = r7.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x05a5 }
                    if (r8 != 0) goto L_0x04d5
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r8.<init>()     // Catch:{ all -> 0x05a5 }
                    r7.put(r3, r8)     // Catch:{ all -> 0x05a5 }
                L_0x04d5:
                    r1.trendingList = r8     // Catch:{ all -> 0x05a5 }
                    goto L_0x04da
                L_0x04d8:
                    r7 = r20
                L_0x04da:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x04f9
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r8 = r19
                    java.lang.Object r9 = r8.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x05a5 }
                    if (r9 != 0) goto L_0x04f6
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r9.<init>()     // Catch:{ all -> 0x05a5 }
                    r8.put(r3, r9)     // Catch:{ all -> 0x05a5 }
                L_0x04f6:
                    r1.recommendedAppsList = r9     // Catch:{ all -> 0x05a5 }
                    goto L_0x04fb
                L_0x04f9:
                    r8 = r19
                L_0x04fb:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x051a
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r9 = r18
                    java.lang.Object r11 = r9.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x05a5 }
                    if (r11 != 0) goto L_0x0517
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r11.<init>()     // Catch:{ all -> 0x05a5 }
                    r9.put(r3, r11)     // Catch:{ all -> 0x05a5 }
                L_0x0517:
                    r1.recommendedList = r11     // Catch:{ all -> 0x05a5 }
                    goto L_0x051c
                L_0x051a:
                    r9 = r18
                L_0x051c:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x053b
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r11 = r17
                    java.lang.Object r12 = r11.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x05a5 }
                    if (r12 != 0) goto L_0x0538
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r12.<init>()     // Catch:{ all -> 0x05a5 }
                    r11.put(r3, r12)     // Catch:{ all -> 0x05a5 }
                L_0x0538:
                    r1.storiesList = r12     // Catch:{ all -> 0x05a5 }
                    goto L_0x053d
                L_0x053b:
                    r11 = r17
                L_0x053d:
                    boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x05a5 }
                    if (r3 != 0) goto L_0x055c
                    java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x05a5 }
                    r10 = r16
                    java.lang.Object r12 = r10.get(r3)     // Catch:{ all -> 0x05a5 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x05a5 }
                    if (r12 != 0) goto L_0x0559
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x05a5 }
                    r12.<init>()     // Catch:{ all -> 0x05a5 }
                    r10.put(r3, r12)     // Catch:{ all -> 0x05a5 }
                L_0x0559:
                    r1.pollsList = r12     // Catch:{ all -> 0x05a5 }
                    goto L_0x055e
                L_0x055c:
                    r10 = r16
                L_0x055e:
                    r1.setCreatedBy(r15)     // Catch:{ all -> 0x05a5 }
                    r1.setMlProperties(r0)     // Catch:{ all -> 0x05a5 }
                    r63 = r1
                    goto L_0x0577
                L_0x0567:
                    r10 = r16
                    r11 = r17
                    r9 = r18
                    r8 = r19
                    r7 = r20
                    r6 = r21
                    r5 = r22
                    r4 = r23
                L_0x0577:
                    r1 = r72
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r4)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r5)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r6)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r7)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r8)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r9)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r11)     // Catch:{ all -> 0x05a9 }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x05a9 }
                    r0.h(r10)     // Catch:{ all -> 0x05a9 }
                    r2.close()
                    return r63
                L_0x05a5:
                    r0 = move-exception
                    r1 = r72
                    goto L_0x05aa
                L_0x05a9:
                    r0 = move-exception
                L_0x05aa:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass47.b():net.one97.paytm.feed.repository.models.FeedDataMinimal");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    public final LiveData<List<FeedDataMinimal>> a(String str, String str2, String str3) {
        final m a2 = m.a("SELECT * FROM feeddata WHERE feedItemType = ? or feedItemType = ? or feedItemType = ?", 3);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        if (str2 == null) {
            a2.f4477f[2] = 1;
        } else {
            a2.a(2, str2);
        }
        if (str3 == null) {
            a2.f4477f[3] = 1;
        } else {
            a2.a(3, str3);
        }
        return new d<List<FeedDataMinimal>>(this.f34655a.getQueryExecutor()) {

            /* renamed from: i  reason: collision with root package name */
            private g.b f34732i;

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x0651 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x065b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x067b A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0685 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x06a5 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x06af A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x06cf A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x06d9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x06f9 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0703 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0723 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x072d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x074d A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x0318 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0319 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x03d1 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:50:0x03d3 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0423 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0425 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0432 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0434 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x0441 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0443 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x0450 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0452 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0460 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0462 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x04f4 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x04f6 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0530 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x0532 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x053e A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0542 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:85:0x0552 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0554 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:89:0x0603 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0625 A[Catch:{ all -> 0x07d0 }] */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x0631 A[Catch:{ all -> 0x07d0 }] */
            /* renamed from: c */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal> b() {
                /*
                    r93 = this;
                    r1 = r93
                    androidx.room.g$b r0 = r1.f34732i
                    if (r0 != 0) goto L_0x0030
                    net.one97.paytm.feed.repository.db.a.b$48$1 r0 = new net.one97.paytm.feed.repository.db.a.b$48$1
                    java.lang.String r2 = "Brand"
                    java.lang.String r3 = "Banner"
                    java.lang.String r4 = "Trending"
                    java.lang.String r5 = "RecommendedApps"
                    java.lang.String r6 = "FeedOfFeed"
                    java.lang.String r7 = "Stories"
                    java.lang.String r8 = "PollsData"
                    java.lang.String r9 = "feeddata"
                    java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
                    java.lang.String r3 = "Channel"
                    r0.<init>(r3, r2)
                    r1.f34732i = r0
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.g r0 = r0.getInvalidationTracker()
                    androidx.room.g$b r2 = r1.f34732i
                    r0.b(r2)
                L_0x0030:
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this
                    androidx.room.j r0 = r0.f34655a
                    androidx.room.m r2 = r1
                    android.database.Cursor r2 = r0.query(r2)
                    androidx.a.a r0 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r0.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r3 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r3.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r4 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r4.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r5 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r5.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r6 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r6.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r7 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r7.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r8 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r8.<init>()     // Catch:{ all -> 0x07d4 }
                    androidx.a.a r9 = new androidx.a.a     // Catch:{ all -> 0x07d4 }
                    r9.<init>()     // Catch:{ all -> 0x07d4 }
                    java.lang.String r10 = "id"
                    int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r11 = "uiId"
                    int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r12 = "rank"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r13 = "poweredBy"
                    int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r14 = "createdAt"
                    int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r15 = "imageUrl"
                    int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x07d4 }
                    java.lang.String r1 = "width"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r16 = r9
                    java.lang.String r9 = "height"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r17 = r8
                    java.lang.String r8 = "title"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r18 = r7
                    java.lang.String r7 = "webUrl"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r19 = r6
                    java.lang.String r6 = "likeCount"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r20 = r5
                    java.lang.String r5 = "commentCount"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r21 = r4
                    java.lang.String r4 = "shareCount"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r22 = r3
                    java.lang.String r3 = "isLiked"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r23 = r0
                    java.lang.String r0 = "description"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r24 = r0
                    java.lang.String r0 = "displayTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r25 = r0
                    java.lang.String r0 = "url"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r26 = r0
                    java.lang.String r0 = "streamUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r27 = r0
                    java.lang.String r0 = "duration"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r28 = r0
                    java.lang.String r0 = "viewCount"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r29 = r0
                    java.lang.String r0 = "canLike"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r30 = r0
                    java.lang.String r0 = "canComment"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r31 = r0
                    java.lang.String r0 = "canShare"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r32 = r0
                    java.lang.String r0 = "isSensitive"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r33 = r0
                    java.lang.String r0 = "isFlaggedByUser"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r34 = r0
                    java.lang.String r0 = "deepLinkUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r35 = r0
                    java.lang.String r0 = "category"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r36 = r0
                    java.lang.String r0 = "viewAllUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r37 = r0
                    java.lang.String r0 = "buckets"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r38 = r0
                    java.lang.String r0 = "feedItemType"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r39 = r0
                    java.lang.String r0 = "logoUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r40 = r0
                    java.lang.String r0 = "shareUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r41 = r0
                    java.lang.String r0 = "name"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r42 = r0
                    java.lang.String r0 = "feedItemRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r43 = r0
                    java.lang.String r0 = "feedItemCategoryRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r44 = r0
                    java.lang.String r0 = "profileRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r45 = r0
                    java.lang.String r0 = "followingRank"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r46 = r0
                    java.lang.String r0 = "mute"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r47 = r0
                    java.lang.String r0 = "mlVersion"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r48 = r0
                    java.lang.String r0 = "contentFormat"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r49 = r0
                    java.lang.String r0 = "mlCategory"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r50 = r0
                    java.lang.String r0 = "score"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r51 = r0
                    java.lang.String r0 = "isBookmarked"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r52 = r0
                    java.lang.String r0 = "isFollowed"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r53 = r0
                    java.lang.String r0 = "canFollow"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r54 = r0
                    java.lang.String r0 = "likeCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r55 = r0
                    java.lang.String r0 = "commentCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r56 = r0
                    java.lang.String r0 = "shareCountDisplay"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r57 = r0
                    java.lang.String r0 = "homeTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r58 = r0
                    java.lang.String r0 = "awayTeamAbbr"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r59 = r0
                    java.lang.String r0 = "homeTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r60 = r0
                    java.lang.String r0 = "awayTeamLogo"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r61 = r0
                    java.lang.String r0 = "homeTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r62 = r0
                    java.lang.String r0 = "awayTeamId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r63 = r0
                    java.lang.String r0 = "dataUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r64 = r0
                    java.lang.String r0 = "clickUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r65 = r0
                    java.lang.String r0 = "matchId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r66 = r0
                    java.lang.String r0 = "startTime"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r67 = r0
                    java.lang.String r0 = "ctaImageUrl"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r68 = r0
                    java.lang.String r0 = "ctaDisplayText"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r69 = r0
                    java.lang.String r0 = "creatorId"
                    int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x07d0 }
                    r70 = r3
                    java.lang.String r3 = "createdByName"
                    int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x07d0 }
                    r71 = r4
                    java.lang.String r4 = "createdByImageUrl"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ all -> 0x07d0 }
                    r72 = r5
                    java.lang.String r5 = "createdByCanFollow"
                    int r5 = r2.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x07d0 }
                    r73 = r6
                    java.lang.String r6 = "ItemScore"
                    int r6 = r2.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x07d0 }
                    r74 = r7
                    java.lang.String r7 = "ItemBucket"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x07d0 }
                    r75 = r8
                    java.lang.String r8 = "ItemContentFormat"
                    int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x07d0 }
                    r76 = r9
                    java.lang.String r9 = "ItemMlVersion"
                    int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    java.lang.String r1 = "ItemMlCategory"
                    int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x07d0 }
                    r78 = r15
                    java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r79 = r14
                    int r14 = r2.getCount()     // Catch:{ all -> 0x07d0 }
                    r15.<init>(r14)     // Catch:{ all -> 0x07d0 }
                L_0x0295:
                    boolean r14 = r2.moveToNext()     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x0790
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    r80 = 0
                    r81 = 1
                    r82 = 0
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r3)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r4)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02c5
                    boolean r14 = r2.isNull(r5)     // Catch:{ all -> 0x07d0 }
                    if (r14 != 0) goto L_0x02ba
                    goto L_0x02c5
                L_0x02ba:
                    r83 = r0
                    r84 = r3
                    r85 = r4
                    r86 = r5
                    r5 = r80
                    goto L_0x02fa
                L_0x02c5:
                    boolean r14 = r2.isNull(r0)     // Catch:{ all -> 0x07d0 }
                    if (r14 == 0) goto L_0x02d0
                    r83 = r0
                    r14 = r80
                    goto L_0x02da
                L_0x02d0:
                    int r14 = r2.getInt(r0)     // Catch:{ all -> 0x07d0 }
                    java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x07d0 }
                    r83 = r0
                L_0x02da:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x07d0 }
                    r84 = r3
                    java.lang.String r3 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    int r85 = r2.getInt(r5)     // Catch:{ all -> 0x07d0 }
                    if (r85 == 0) goto L_0x02f0
                    r85 = r4
                    r86 = r5
                    r4 = 1
                    goto L_0x02f5
                L_0x02f0:
                    r85 = r4
                    r86 = r5
                    r4 = 0
                L_0x02f5:
                    net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x07d0 }
                    r5.<init>(r14, r0, r3, r4)     // Catch:{ all -> 0x07d0 }
                L_0x02fa:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x031c
                    boolean r0 = r2.isNull(r1)     // Catch:{ all -> 0x07d0 }
                    if (r0 != 0) goto L_0x0319
                    goto L_0x031c
                L_0x0319:
                    r0 = r80
                    goto L_0x0345
                L_0x031c:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x07d0 }
                    if (r0 == 0) goto L_0x0325
                L_0x0322:
                    r88 = r80
                    goto L_0x032e
                L_0x0325:
                    double r3 = r2.getDouble(r6)     // Catch:{ all -> 0x07d0 }
                    java.lang.Double r80 = java.lang.Double.valueOf(r3)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0322
                L_0x032e:
                    java.lang.String r89 = r2.getString(r7)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r90 = r2.getString(r8)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r91 = r2.getString(r9)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r92 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    net.one97.paytm.feed.repository.models.MlProperties r0 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x07d0 }
                    r87 = r0
                    r87.<init>(r88, r89, r90, r91, r92)     // Catch:{ all -> 0x07d0 }
                L_0x0345:
                    net.one97.paytm.feed.repository.models.FeedDataMinimal r3 = new net.one97.paytm.feed.repository.models.FeedDataMinimal     // Catch:{ all -> 0x07d0 }
                    r3.<init>()     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r3.setId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r11)     // Catch:{ all -> 0x07d0 }
                    r3.setUiId(r4)     // Catch:{ all -> 0x07d0 }
                    int r4 = r2.getInt(r12)     // Catch:{ all -> 0x07d0 }
                    r3.setRank(r4)     // Catch:{ all -> 0x07d0 }
                    java.lang.String r4 = r2.getString(r13)     // Catch:{ all -> 0x07d0 }
                    r3.setPoweredBy(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r79
                    java.lang.String r14 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCreatedAt(r14)     // Catch:{ all -> 0x07d0 }
                    r14 = r78
                    r78 = r1
                    java.lang.String r1 = r2.getString(r14)     // Catch:{ all -> 0x07d0 }
                    r3.setImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r79 = r4
                    r1 = r77
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setWidth(r4)     // Catch:{ all -> 0x07d0 }
                    r77 = r1
                    r4 = r76
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHeight(r1)     // Catch:{ all -> 0x07d0 }
                    r76 = r4
                    r1 = r75
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setTitle(r4)     // Catch:{ all -> 0x07d0 }
                    r75 = r1
                    r4 = r74
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setWebUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r74 = r4
                    r1 = r73
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCount(r4)     // Catch:{ all -> 0x07d0 }
                    r73 = r1
                    r4 = r72
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCount(r1)     // Catch:{ all -> 0x07d0 }
                    r72 = r4
                    r1 = r71
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCount(r4)     // Catch:{ all -> 0x07d0 }
                    r4 = r70
                    int r70 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r71 = r1
                    if (r70 == 0) goto L_0x03d3
                    r1 = 1
                    goto L_0x03d4
                L_0x03d3:
                    r1 = 0
                L_0x03d4:
                    r3.setLiked(r1)     // Catch:{ all -> 0x07d0 }
                    r70 = r4
                    r1 = r24
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDescription(r4)     // Catch:{ all -> 0x07d0 }
                    r24 = r1
                    r4 = r25
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDisplayTime(r1)     // Catch:{ all -> 0x07d0 }
                    r25 = r4
                    r1 = r26
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r26 = r1
                    r4 = r27
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setStreamUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r27 = r4
                    r1 = r28
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDuration(r4)     // Catch:{ all -> 0x07d0 }
                    r28 = r1
                    r4 = r29
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setViewCount(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r30
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r30 = r1
                    if (r29 == 0) goto L_0x0425
                    r1 = 1
                    goto L_0x0426
                L_0x0425:
                    r1 = 0
                L_0x0426:
                    r3.canLike = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r31
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r31 = r1
                    if (r29 == 0) goto L_0x0434
                    r1 = 1
                    goto L_0x0435
                L_0x0434:
                    r1 = 0
                L_0x0435:
                    r3.canComment = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r32
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r32 = r1
                    if (r29 == 0) goto L_0x0443
                    r1 = 1
                    goto L_0x0444
                L_0x0443:
                    r1 = 0
                L_0x0444:
                    r3.canShare = r1     // Catch:{ all -> 0x07d0 }
                    r1 = r33
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r33 = r1
                    if (r29 == 0) goto L_0x0452
                    r1 = 1
                    goto L_0x0453
                L_0x0452:
                    r1 = 0
                L_0x0453:
                    r3.setSensitive(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r34
                    int r29 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r34 = r1
                    if (r29 == 0) goto L_0x0462
                    r1 = 1
                    goto L_0x0463
                L_0x0462:
                    r1 = 0
                L_0x0463:
                    r3.setFlaggedByUser(r1)     // Catch:{ all -> 0x07d0 }
                    r29 = r4
                    r1 = r35
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setDeepLinkUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r35 = r1
                    r4 = r36
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCategory(r1)     // Catch:{ all -> 0x07d0 }
                    r36 = r4
                    r1 = r37
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setViewAllUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r37 = r1
                    r4 = r38
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setBuckets(r1)     // Catch:{ all -> 0x07d0 }
                    r38 = r4
                    r1 = r39
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemType(r4)     // Catch:{ all -> 0x07d0 }
                    r39 = r1
                    r4 = r40
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setLogoUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r40 = r4
                    r1 = r41
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r41 = r1
                    r4 = r42
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setName(r1)     // Catch:{ all -> 0x07d0 }
                    r42 = r4
                    r1 = r43
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemRank(r4)     // Catch:{ all -> 0x07d0 }
                    r43 = r1
                    r4 = r44
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFeedItemCategoryRank(r1)     // Catch:{ all -> 0x07d0 }
                    r44 = r4
                    r1 = r45
                    int r4 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setProfileRank(r4)     // Catch:{ all -> 0x07d0 }
                    r45 = r1
                    r4 = r46
                    int r1 = r2.getInt(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setFollowingRank(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r47
                    int r46 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r47 = r1
                    if (r46 == 0) goto L_0x04f6
                    r1 = 1
                    goto L_0x04f7
                L_0x04f6:
                    r1 = 0
                L_0x04f7:
                    r3.setMute(r1)     // Catch:{ all -> 0x07d0 }
                    r46 = r4
                    r1 = r48
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlVersion(r4)     // Catch:{ all -> 0x07d0 }
                    r48 = r1
                    r4 = r49
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setContentFormat(r1)     // Catch:{ all -> 0x07d0 }
                    r49 = r4
                    r1 = r50
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setMlCategory(r4)     // Catch:{ all -> 0x07d0 }
                    r50 = r6
                    r4 = r51
                    r51 = r7
                    double r6 = r2.getDouble(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setScore(r6)     // Catch:{ all -> 0x07d0 }
                    r6 = r52
                    int r7 = r2.getInt(r6)     // Catch:{ all -> 0x07d0 }
                    if (r7 == 0) goto L_0x0532
                    r7 = 1
                    goto L_0x0533
                L_0x0532:
                    r7 = 0
                L_0x0533:
                    r3.setBookmarked(r7)     // Catch:{ all -> 0x07d0 }
                    r7 = r53
                    int r52 = r2.getInt(r7)     // Catch:{ all -> 0x07d0 }
                    if (r52 == 0) goto L_0x0542
                    r52 = r1
                    r1 = 1
                    goto L_0x0545
                L_0x0542:
                    r52 = r1
                    r1 = 0
                L_0x0545:
                    r3.setFollowed(r1)     // Catch:{ all -> 0x07d0 }
                    r1 = r54
                    int r53 = r2.getInt(r1)     // Catch:{ all -> 0x07d0 }
                    r54 = r1
                    if (r53 == 0) goto L_0x0554
                    r1 = 1
                    goto L_0x0555
                L_0x0554:
                    r1 = 0
                L_0x0555:
                    r3.setCanFollow(r1)     // Catch:{ all -> 0x07d0 }
                    r53 = r4
                    r1 = r55
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setLikeCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r55 = r1
                    r4 = r56
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCommentCountDisplay(r1)     // Catch:{ all -> 0x07d0 }
                    r56 = r4
                    r1 = r57
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setShareCountDisplay(r4)     // Catch:{ all -> 0x07d0 }
                    r57 = r1
                    r4 = r58
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamAbbr(r1)     // Catch:{ all -> 0x07d0 }
                    r58 = r4
                    r1 = r59
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamAbbr(r4)     // Catch:{ all -> 0x07d0 }
                    r59 = r1
                    r4 = r60
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamLogo(r1)     // Catch:{ all -> 0x07d0 }
                    r60 = r4
                    r1 = r61
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamLogo(r4)     // Catch:{ all -> 0x07d0 }
                    r61 = r1
                    r4 = r62
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setHomeTeamId(r1)     // Catch:{ all -> 0x07d0 }
                    r62 = r4
                    r1 = r63
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setAwayTeamId(r4)     // Catch:{ all -> 0x07d0 }
                    r63 = r1
                    r4 = r64
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setDataUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r64 = r4
                    r1 = r65
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setClickUrl(r4)     // Catch:{ all -> 0x07d0 }
                    r65 = r1
                    r4 = r66
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setMatchId(r1)     // Catch:{ all -> 0x07d0 }
                    r66 = r4
                    r1 = r67
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setStartTime(r4)     // Catch:{ all -> 0x07d0 }
                    r67 = r1
                    r4 = r68
                    java.lang.String r1 = r2.getString(r4)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaImageUrl(r1)     // Catch:{ all -> 0x07d0 }
                    r68 = r4
                    r1 = r69
                    java.lang.String r4 = r2.getString(r1)     // Catch:{ all -> 0x07d0 }
                    r3.setCtaDisplayText(r4)     // Catch:{ all -> 0x07d0 }
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0625
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r69 = r1
                    r1 = r23
                    java.lang.Object r23 = r1.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r23 = (java.util.ArrayList) r23     // Catch:{ all -> 0x07d0 }
                    if (r23 != 0) goto L_0x061e
                    r80 = r6
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r6.<init>()     // Catch:{ all -> 0x07d0 }
                    r1.put(r4, r6)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0622
                L_0x061e:
                    r80 = r6
                    r6 = r23
                L_0x0622:
                    r3.channelList = r6     // Catch:{ all -> 0x07d0 }
                    goto L_0x062b
                L_0x0625:
                    r69 = r1
                    r80 = r6
                    r1 = r23
                L_0x062b:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0651
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r6 = r22
                    java.lang.Object r22 = r6.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r22 = (java.util.ArrayList) r22     // Catch:{ all -> 0x07d0 }
                    if (r22 != 0) goto L_0x064a
                    r23 = r7
                    java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r7.<init>()     // Catch:{ all -> 0x07d0 }
                    r6.put(r4, r7)     // Catch:{ all -> 0x07d0 }
                    goto L_0x064e
                L_0x064a:
                    r23 = r7
                    r7 = r22
                L_0x064e:
                    r3.brands = r7     // Catch:{ all -> 0x07d0 }
                    goto L_0x0655
                L_0x0651:
                    r23 = r7
                    r6 = r22
                L_0x0655:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x067b
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r7 = r21
                    java.lang.Object r21 = r7.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r21 = (java.util.ArrayList) r21     // Catch:{ all -> 0x07d0 }
                    if (r21 != 0) goto L_0x0674
                    r22 = r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r8.<init>()     // Catch:{ all -> 0x07d0 }
                    r7.put(r4, r8)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0678
                L_0x0674:
                    r22 = r8
                    r8 = r21
                L_0x0678:
                    r3.bannersList = r8     // Catch:{ all -> 0x07d0 }
                    goto L_0x067f
                L_0x067b:
                    r22 = r8
                    r7 = r21
                L_0x067f:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06a5
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r8 = r20
                    java.lang.Object r20 = r8.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r20 = (java.util.ArrayList) r20     // Catch:{ all -> 0x07d0 }
                    if (r20 != 0) goto L_0x069e
                    r21 = r9
                    java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r9.<init>()     // Catch:{ all -> 0x07d0 }
                    r8.put(r4, r9)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a2
                L_0x069e:
                    r21 = r9
                    r9 = r20
                L_0x06a2:
                    r3.trendingList = r9     // Catch:{ all -> 0x07d0 }
                    goto L_0x06a9
                L_0x06a5:
                    r21 = r9
                    r8 = r20
                L_0x06a9:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06cf
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r9 = r19
                    java.lang.Object r19 = r9.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r19 = (java.util.ArrayList) r19     // Catch:{ all -> 0x07d0 }
                    if (r19 != 0) goto L_0x06c8
                    r20 = r11
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r11.<init>()     // Catch:{ all -> 0x07d0 }
                    r9.put(r4, r11)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06cc
                L_0x06c8:
                    r20 = r11
                    r11 = r19
                L_0x06cc:
                    r3.recommendedAppsList = r11     // Catch:{ all -> 0x07d0 }
                    goto L_0x06d3
                L_0x06cf:
                    r20 = r11
                    r9 = r19
                L_0x06d3:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x06f9
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r11 = r18
                    java.lang.Object r18 = r11.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r18 = (java.util.ArrayList) r18     // Catch:{ all -> 0x07d0 }
                    if (r18 != 0) goto L_0x06f2
                    r19 = r12
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r12.<init>()     // Catch:{ all -> 0x07d0 }
                    r11.put(r4, r12)     // Catch:{ all -> 0x07d0 }
                    goto L_0x06f6
                L_0x06f2:
                    r19 = r12
                    r12 = r18
                L_0x06f6:
                    r3.recommendedList = r12     // Catch:{ all -> 0x07d0 }
                    goto L_0x06fd
                L_0x06f9:
                    r19 = r12
                    r11 = r18
                L_0x06fd:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x0723
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r12 = r17
                    java.lang.Object r17 = r12.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r17 = (java.util.ArrayList) r17     // Catch:{ all -> 0x07d0 }
                    if (r17 != 0) goto L_0x071c
                    r18 = r13
                    java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r13.<init>()     // Catch:{ all -> 0x07d0 }
                    r12.put(r4, r13)     // Catch:{ all -> 0x07d0 }
                    goto L_0x0720
                L_0x071c:
                    r18 = r13
                    r13 = r17
                L_0x0720:
                    r3.storiesList = r13     // Catch:{ all -> 0x07d0 }
                    goto L_0x0727
                L_0x0723:
                    r18 = r13
                    r12 = r17
                L_0x0727:
                    boolean r4 = r2.isNull(r10)     // Catch:{ all -> 0x07d0 }
                    if (r4 != 0) goto L_0x074d
                    java.lang.String r4 = r2.getString(r10)     // Catch:{ all -> 0x07d0 }
                    r13 = r16
                    java.lang.Object r16 = r13.get(r4)     // Catch:{ all -> 0x07d0 }
                    java.util.ArrayList r16 = (java.util.ArrayList) r16     // Catch:{ all -> 0x07d0 }
                    if (r16 != 0) goto L_0x0746
                    r17 = r10
                    java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x07d0 }
                    r10.<init>()     // Catch:{ all -> 0x07d0 }
                    r13.put(r4, r10)     // Catch:{ all -> 0x07d0 }
                    goto L_0x074a
                L_0x0746:
                    r17 = r10
                    r10 = r16
                L_0x074a:
                    r3.pollsList = r10     // Catch:{ all -> 0x07d0 }
                    goto L_0x0751
                L_0x074d:
                    r17 = r10
                    r13 = r16
                L_0x0751:
                    r3.setCreatedBy(r5)     // Catch:{ all -> 0x07d0 }
                    r3.setMlProperties(r0)     // Catch:{ all -> 0x07d0 }
                    r15.add(r3)     // Catch:{ all -> 0x07d0 }
                    r16 = r13
                    r10 = r17
                    r13 = r18
                    r0 = r83
                    r3 = r84
                    r4 = r85
                    r5 = r86
                    r18 = r11
                    r17 = r12
                    r12 = r19
                    r11 = r20
                    r20 = r8
                    r19 = r9
                    r9 = r21
                    r8 = r22
                    r22 = r6
                    r21 = r7
                    r6 = r50
                    r7 = r51
                    r50 = r52
                    r51 = r53
                    r52 = r80
                    r53 = r23
                    r23 = r1
                    r1 = r78
                    r78 = r14
                    goto L_0x0295
                L_0x0790:
                    r3 = r93
                    r13 = r16
                    r12 = r17
                    r11 = r18
                    r9 = r19
                    r8 = r20
                    r7 = r21
                    r6 = r22
                    r1 = r23
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.a((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.livetv.Channel>>) r1)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.b((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.merchantstorefront.Brand>>) r6)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.c((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.promobanner.Banner>>) r7)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.d((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.trending.Trending>>) r8)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.e((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps>>) r9)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r11)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r12)     // Catch:{ all -> 0x07ce }
                    net.one97.paytm.feed.repository.db.a.b r0 = net.one97.paytm.feed.repository.db.a.b.this     // Catch:{ all -> 0x07ce }
                    r0.h(r13)     // Catch:{ all -> 0x07ce }
                    r2.close()
                    return r15
                L_0x07ce:
                    r0 = move-exception
                    goto L_0x07d6
                L_0x07d0:
                    r0 = move-exception
                    r3 = r93
                    goto L_0x07d6
                L_0x07d4:
                    r0 = move-exception
                    r3 = r1
                L_0x07d6:
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.AnonymousClass48.b():java.util.List");
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        }.f3657b;
    }

    /* access modifiers changed from: private */
    public void a(a<String, ArrayList<Channel>> aVar) {
        a<String, ArrayList<Channel>> aVar2;
        int i2;
        int i3;
        int i4;
        a<String, ArrayList<Channel>> aVar3 = aVar;
        while (true) {
            Set<String> keySet = aVar3.keySet();
            if (!keySet.isEmpty()) {
                if (aVar3.size() > 999) {
                    a<String, ArrayList<Channel>> aVar4 = new a<>(999);
                    int size = aVar3.size();
                    a<String, ArrayList<Channel>> aVar5 = aVar4;
                    int i5 = 0;
                    while (true) {
                        i4 = 0;
                        while (i5 < size) {
                            aVar5.put(aVar3.b(i5), aVar3.c(i5));
                            i5++;
                            i4++;
                            if (i4 == 999) {
                                a(aVar5);
                                aVar5 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i4 > 0) {
                        aVar3 = aVar5;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `id`,`channelId`,`channelName`,`channelThumbnailUrl`,`channelGenre`,`language`,`source`,`programName`,`programDescription`,`programUrl`,`programImageUrl`,`programStartTime`,`programEndTime`,`fid`,`height`,`width` FROM `Channel` WHERE `fid` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i6 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i6] = 1;
                        } else {
                            a3.a(i6, next);
                        }
                        i6++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex("fid");
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("channelId");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("channelName");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("channelThumbnailUrl");
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("channelGenre");
                            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("language");
                            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("source");
                            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("programName");
                            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("programDescription");
                            int columnIndexOrThrow10 = query.getColumnIndexOrThrow("programUrl");
                            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("programImageUrl");
                            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("programStartTime");
                            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("programEndTime");
                            int columnIndexOrThrow14 = query.getColumnIndexOrThrow("fid");
                            int columnIndexOrThrow15 = query.getColumnIndexOrThrow(StringSet.height);
                            int columnIndexOrThrow16 = query.getColumnIndexOrThrow(StringSet.width);
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex)) {
                                    int i7 = columnIndexOrThrow16;
                                    ArrayList arrayList = aVar3.get(query.getString(columnIndex));
                                    if (arrayList != null) {
                                        String string = query.getString(columnIndexOrThrow);
                                        String string2 = query.getString(columnIndexOrThrow2);
                                        String string3 = query.getString(columnIndexOrThrow3);
                                        String string4 = query.getString(columnIndexOrThrow4);
                                        String string5 = query.getString(columnIndexOrThrow5);
                                        String string6 = query.getString(columnIndexOrThrow6);
                                        String string7 = query.getString(columnIndexOrThrow7);
                                        String string8 = query.getString(columnIndexOrThrow8);
                                        String string9 = query.getString(columnIndexOrThrow9);
                                        String string10 = query.getString(columnIndexOrThrow10);
                                        String string11 = query.getString(columnIndexOrThrow11);
                                        aVar2 = aVar3;
                                        i3 = columnIndexOrThrow12;
                                        String string12 = query.getString(i3);
                                        String string13 = query.getString(columnIndexOrThrow13);
                                        i2 = columnIndexOrThrow13;
                                        int i8 = columnIndexOrThrow14;
                                        String string14 = query.getString(i8);
                                        columnIndexOrThrow14 = i8;
                                        int i9 = columnIndexOrThrow15;
                                        String string15 = query.getString(i9);
                                        columnIndexOrThrow15 = i9;
                                        int i10 = i7;
                                        i7 = i10;
                                        arrayList.add(new Channel(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, query.getString(i10)));
                                    } else {
                                        aVar2 = aVar3;
                                        i3 = columnIndexOrThrow12;
                                        i2 = columnIndexOrThrow13;
                                    }
                                    columnIndexOrThrow13 = i2;
                                    columnIndexOrThrow12 = i3;
                                    columnIndexOrThrow16 = i7;
                                } else {
                                    aVar2 = aVar3;
                                    int i11 = columnIndexOrThrow12;
                                }
                                aVar3 = aVar2;
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(a<String, ArrayList<Brand>> aVar) {
        ArrayList arrayList;
        int i2;
        a<String, ArrayList<Brand>> aVar2 = aVar;
        while (true) {
            Set<String> keySet = aVar2.keySet();
            if (!keySet.isEmpty()) {
                if (aVar2.size() > 999) {
                    a<String, ArrayList<Brand>> aVar3 = new a<>(999);
                    int size = aVar2.size();
                    a<String, ArrayList<Brand>> aVar4 = aVar3;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar4.put(aVar2.b(i3), aVar2.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                b(aVar4);
                                aVar4 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar2 = aVar4;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `deepLink`,`contractId`,`logoUrl`,`name`,`pid` FROM `Brand` WHERE `pid` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i4] = 1;
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex(Constants.URL_MEDIA_SOURCE);
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("deepLink");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("contractId");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("logoUrl");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("name");
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow(Constants.URL_MEDIA_SOURCE);
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex) && (arrayList = aVar2.get(query.getString(columnIndex))) != null) {
                                    arrayList.add(new Brand(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5)));
                                }
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(a<String, ArrayList<Banner>> aVar) {
        ArrayList arrayList;
        int i2;
        a<String, ArrayList<Banner>> aVar2 = aVar;
        while (true) {
            Set<String> keySet = aVar2.keySet();
            if (!keySet.isEmpty()) {
                if (aVar2.size() > 999) {
                    a<String, ArrayList<Banner>> aVar3 = new a<>(999);
                    int size = aVar2.size();
                    a<String, ArrayList<Banner>> aVar4 = aVar3;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar4.put(aVar2.b(i3), aVar2.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                c(aVar4);
                                aVar4 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar2 = aVar4;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `id`,`bid`,`deepLink`,`imageUrl`,`webUrl`,`height`,`width` FROM `Banner` WHERE `bid` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i4] = 1;
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex("bid");
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bid");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("deepLink");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("imageUrl");
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("webUrl");
                            int columnIndexOrThrow6 = query.getColumnIndexOrThrow(StringSet.height);
                            int columnIndexOrThrow7 = query.getColumnIndexOrThrow(StringSet.width);
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex) && (arrayList = aVar2.get(query.getString(columnIndex))) != null) {
                                    arrayList.add(new Banner(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7)));
                                }
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(a<String, ArrayList<Trending>> aVar) {
        ArrayList arrayList;
        int i2;
        a<String, ArrayList<Trending>> aVar2 = aVar;
        while (true) {
            Set<String> keySet = aVar2.keySet();
            if (!keySet.isEmpty()) {
                if (aVar2.size() > 999) {
                    a<String, ArrayList<Trending>> aVar3 = new a<>(999);
                    int size = aVar2.size();
                    a<String, ArrayList<Trending>> aVar4 = aVar3;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar4.put(aVar2.b(i3), aVar2.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                d(aVar4);
                                aVar4 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar2 = aVar4;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `id`,`tid`,`title`,`description`,`deepLink`,`imageUrl`,`webUrl`,`streamUrl`,`height`,`width` FROM `Trending` WHERE `tid` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i4] = 1;
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex("tid");
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("tid");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("title");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("deepLink");
                            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("imageUrl");
                            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("webUrl");
                            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("streamUrl");
                            int columnIndexOrThrow9 = query.getColumnIndexOrThrow(StringSet.height);
                            int columnIndexOrThrow10 = query.getColumnIndexOrThrow(StringSet.width);
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex) && (arrayList = aVar2.get(query.getString(columnIndex))) != null) {
                                    arrayList.add(new Trending(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7), query.getString(columnIndexOrThrow8), query.getString(columnIndexOrThrow9), query.getString(columnIndexOrThrow10)));
                                }
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void e(a<String, ArrayList<RecommendedApps>> aVar) {
        int i2;
        int i3;
        a<String, ArrayList<RecommendedApps>> aVar2 = aVar;
        while (true) {
            Set<String> keySet = aVar2.keySet();
            if (!keySet.isEmpty()) {
                if (aVar2.size() > 999) {
                    a<String, ArrayList<RecommendedApps>> aVar3 = new a<>(999);
                    int size = aVar2.size();
                    a<String, ArrayList<RecommendedApps>> aVar4 = aVar3;
                    int i4 = 0;
                    while (true) {
                        i3 = 0;
                        while (i4 < size) {
                            aVar4.put(aVar2.b(i4), aVar2.c(i4));
                            i4++;
                            i3++;
                            if (i3 == 999) {
                                e(aVar4);
                                aVar4 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i3 > 0) {
                        aVar2 = aVar4;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `id`,`rid`,`bgColor`,`description`,`downloads`,`imageUrl`,`rating`,`title`,`packageName`,`category`,`appSize`,`type`,`url` FROM `RecommendedApps` WHERE `rid` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i5 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i5] = 1;
                        } else {
                            a3.a(i5, next);
                        }
                        i5++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex("rid");
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("rid");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("bgColor");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow(RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("downloads");
                            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("imageUrl");
                            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("rating");
                            int columnIndexOrThrow8 = query.getColumnIndexOrThrow("title");
                            int columnIndexOrThrow9 = query.getColumnIndexOrThrow("packageName");
                            int columnIndexOrThrow10 = query.getColumnIndexOrThrow("category");
                            int columnIndexOrThrow11 = query.getColumnIndexOrThrow("appSize");
                            int columnIndexOrThrow12 = query.getColumnIndexOrThrow("type");
                            int columnIndexOrThrow13 = query.getColumnIndexOrThrow("url");
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex)) {
                                    int i6 = columnIndexOrThrow13;
                                    ArrayList arrayList = aVar2.get(query.getString(columnIndex));
                                    if (arrayList != null) {
                                        i2 = columnIndexOrThrow2;
                                        int i7 = i6;
                                        i6 = i7;
                                        arrayList.add(new RecommendedApps(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow5), query.getString(columnIndexOrThrow6), query.getString(columnIndexOrThrow7), query.getString(columnIndexOrThrow8), query.getString(columnIndexOrThrow9), query.getString(columnIndexOrThrow10), query.getString(columnIndexOrThrow11), query.getString(columnIndexOrThrow12), query.getString(i7)));
                                    } else {
                                        i2 = columnIndexOrThrow2;
                                    }
                                    columnIndexOrThrow13 = i6;
                                    columnIndexOrThrow2 = i2;
                                }
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x054e A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0555 A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0577 A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0579 A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0587 A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05b8 A[Catch:{ all -> 0x0652 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05cb A[Catch:{ all -> 0x0652 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>> r122) {
        /*
            r121 = this;
            r1 = r121
            java.lang.String r0 = "groupId"
            r2 = r122
        L_0x0006:
            java.util.Set r3 = r2.keySet()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0011
            return
        L_0x0011:
            int r4 = r2.size()
            r5 = 999(0x3e7, float:1.4E-42)
            r6 = 0
            if (r4 <= r5) goto L_0x0047
            androidx.a.a r3 = new androidx.a.a
            r3.<init>((int) r5)
            int r4 = r2.size()
            r8 = r3
            r3 = 0
        L_0x0025:
            r7 = 0
        L_0x0026:
            if (r3 >= r4) goto L_0x0042
            java.lang.Object r9 = r2.b((int) r3)
            java.lang.Object r10 = r2.c(r3)
            r8.put(r9, r10)
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r7 != r5) goto L_0x0026
            r1.f((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedOfFeed>>) r8)
            androidx.a.a r8 = new androidx.a.a
            r8.<init>((int) r5)
            goto L_0x0025
        L_0x0042:
            if (r7 <= 0) goto L_0x0046
            r2 = r8
            goto L_0x0006
        L_0x0046:
            return
        L_0x0047:
            java.lang.StringBuilder r4 = androidx.room.b.e.a()
            java.lang.String r5 = "SELECT `id`,`uiId`,`groupId`,`rank`,`poweredBy`,`createdAt`,`imageUrl`,`width`,`height`,`title`,`webUrl`,`likeCount`,`commentCount`,`shareCount`,`isLiked`,`description`,`displayTime`,`streamUrl`,`duration`,`viewCount`,`canLike`,`canComment`,`canShare`,`isSensitive`,`isFlaggedByUser`,`deepLink`,`category`,`following`,`mute`,`isBookmarked`,`isFollowed`,`canFollow`,`likeCountDisplay`,`commentCountDisplay`,`shareCountDisplay`,`buckets`,`feedItemType`,`feedItemRank`,`feedItemCategoryRank`,`profileRank`,`mlVersion`,`contentFormat`,`mlCategory`,`score`,`followingRank`,`ctaImageUrl`,`ctaDisplayText`,`creatorId`,`createdByName`,`createdByImageUrl`,`createdByCanFollow`,`ItemScore`,`ItemBucket`,`ItemContentFormat`,`ItemMlVersion`,`ItemMlCategory` FROM `FeedOfFeed` WHERE `groupId` IN ("
            r4.append(r5)
            int r5 = r3.size()
            androidx.room.b.e.a(r4, r5)
            java.lang.String r7 = ")"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            int r5 = r5 + r6
            androidx.room.m r4 = androidx.room.m.a((java.lang.String) r4, (int) r5)
            java.util.Iterator r3 = r3.iterator()
            r5 = 1
            r7 = 1
        L_0x006b:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0084
            java.lang.Object r8 = r3.next()
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x007e
            int[] r8 = r4.f4477f
            r8[r7] = r5
            goto L_0x0081
        L_0x007e:
            r4.a((int) r7, (java.lang.String) r8)
        L_0x0081:
            int r7 = r7 + 1
            goto L_0x006b
        L_0x0084:
            androidx.room.j r3 = r1.f34655a
            android.database.Cursor r3 = r3.query(r4)
            int r4 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x0652 }
            r7 = -1
            if (r4 != r7) goto L_0x0095
            r3.close()
            return
        L_0x0095:
            java.lang.String r7 = "id"
            int r7 = r3.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x0652 }
            java.lang.String r8 = "uiId"
            int r8 = r3.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x0652 }
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0652 }
            java.lang.String r9 = "rank"
            int r9 = r3.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x0652 }
            java.lang.String r10 = "poweredBy"
            int r10 = r3.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x0652 }
            java.lang.String r11 = "createdAt"
            int r11 = r3.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x0652 }
            java.lang.String r12 = "imageUrl"
            int r12 = r3.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x0652 }
            java.lang.String r13 = "width"
            int r13 = r3.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x0652 }
            java.lang.String r14 = "height"
            int r14 = r3.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x0652 }
            java.lang.String r15 = "title"
            int r15 = r3.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x0652 }
            java.lang.String r5 = "webUrl"
            int r5 = r3.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x0652 }
            java.lang.String r6 = "likeCount"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0652 }
            java.lang.String r1 = "commentCount"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r16 = r1
            java.lang.String r1 = "shareCount"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r17 = r1
            java.lang.String r1 = "isLiked"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r18 = r1
            java.lang.String r1 = "description"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r19 = r1
            java.lang.String r1 = "displayTime"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r20 = r1
            java.lang.String r1 = "streamUrl"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r21 = r1
            java.lang.String r1 = "duration"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r22 = r1
            java.lang.String r1 = "viewCount"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r23 = r1
            java.lang.String r1 = "canLike"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r24 = r1
            java.lang.String r1 = "canComment"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r25 = r1
            java.lang.String r1 = "canShare"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r26 = r1
            java.lang.String r1 = "isSensitive"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r27 = r1
            java.lang.String r1 = "isFlaggedByUser"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r28 = r1
            java.lang.String r1 = "deepLink"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r29 = r1
            java.lang.String r1 = "category"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r30 = r1
            java.lang.String r1 = "following"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r31 = r1
            java.lang.String r1 = "mute"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r32 = r1
            java.lang.String r1 = "isBookmarked"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r33 = r1
            java.lang.String r1 = "isFollowed"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r34 = r1
            java.lang.String r1 = "canFollow"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r35 = r1
            java.lang.String r1 = "likeCountDisplay"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r36 = r1
            java.lang.String r1 = "commentCountDisplay"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r37 = r1
            java.lang.String r1 = "shareCountDisplay"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r38 = r1
            java.lang.String r1 = "buckets"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r39 = r1
            java.lang.String r1 = "feedItemType"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r40 = r1
            java.lang.String r1 = "feedItemRank"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r41 = r1
            java.lang.String r1 = "feedItemCategoryRank"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r42 = r1
            java.lang.String r1 = "profileRank"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r43 = r1
            java.lang.String r1 = "mlVersion"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r44 = r1
            java.lang.String r1 = "contentFormat"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r45 = r1
            java.lang.String r1 = "mlCategory"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r46 = r1
            java.lang.String r1 = "score"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r47 = r1
            java.lang.String r1 = "followingRank"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r48 = r1
            java.lang.String r1 = "ctaImageUrl"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r49 = r1
            java.lang.String r1 = "ctaDisplayText"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r50 = r1
            java.lang.String r1 = "creatorId"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r51 = r1
            java.lang.String r1 = "createdByName"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r52 = r1
            java.lang.String r1 = "createdByImageUrl"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r53 = r1
            java.lang.String r1 = "createdByCanFollow"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r54 = r1
            java.lang.String r1 = "ItemScore"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r55 = r1
            java.lang.String r1 = "ItemBucket"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r56 = r1
            java.lang.String r1 = "ItemContentFormat"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r57 = r1
            java.lang.String r1 = "ItemMlVersion"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
            r58 = r1
            java.lang.String r1 = "ItemMlCategory"
            int r1 = r3.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0652 }
        L_0x0241:
            boolean r59 = r3.moveToNext()     // Catch:{ all -> 0x0652 }
            if (r59 == 0) goto L_0x064e
            boolean r59 = r3.isNull(r4)     // Catch:{ all -> 0x0652 }
            if (r59 != 0) goto L_0x0634
            r59 = r1
            java.lang.String r1 = r3.getString(r4)     // Catch:{ all -> 0x0652 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0652 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x0652 }
            if (r1 == 0) goto L_0x05fc
            java.lang.String r61 = r3.getString(r7)     // Catch:{ all -> 0x0652 }
            int r62 = r3.getInt(r8)     // Catch:{ all -> 0x0652 }
            java.lang.String r63 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            int r64 = r3.getInt(r9)     // Catch:{ all -> 0x0652 }
            java.lang.String r67 = r3.getString(r10)     // Catch:{ all -> 0x0652 }
            java.lang.String r68 = r3.getString(r11)     // Catch:{ all -> 0x0652 }
            java.lang.String r69 = r3.getString(r12)     // Catch:{ all -> 0x0652 }
            java.lang.String r70 = r3.getString(r13)     // Catch:{ all -> 0x0652 }
            java.lang.String r71 = r3.getString(r14)     // Catch:{ all -> 0x0652 }
            java.lang.String r72 = r3.getString(r15)     // Catch:{ all -> 0x0652 }
            java.lang.String r73 = r3.getString(r5)     // Catch:{ all -> 0x0652 }
            boolean r60 = r3.isNull(r6)     // Catch:{ all -> 0x0652 }
            r65 = 0
            if (r60 == 0) goto L_0x0296
            r110 = r0
            r0 = r16
            r74 = r65
            goto L_0x02a4
        L_0x0296:
            int r60 = r3.getInt(r6)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r60 = java.lang.Integer.valueOf(r60)     // Catch:{ all -> 0x0652 }
            r110 = r0
            r0 = r16
            r74 = r60
        L_0x02a4:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x02b1
            r111 = r0
            r0 = r17
            r75 = r65
            goto L_0x02bf
        L_0x02b1:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r111 = r0
            r75 = r16
            r0 = r17
        L_0x02bf:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x02cc
            r17 = r0
            r0 = r18
            r76 = r65
            goto L_0x02da
        L_0x02cc:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r17 = r0
            r76 = r16
            r0 = r18
        L_0x02da:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x02e3
            r16 = r65
            goto L_0x02eb
        L_0x02e3:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
        L_0x02eb:
            if (r16 != 0) goto L_0x02f4
            r18 = r0
            r0 = r19
            r77 = r65
            goto L_0x0309
        L_0x02f4:
            int r16 = r16.intValue()     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x02fd
            r16 = 1
            goto L_0x02ff
        L_0x02fd:
            r16 = 0
        L_0x02ff:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r18 = r0
            r77 = r16
            r0 = r19
        L_0x0309:
            java.lang.String r78 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r19 = r0
            r0 = r20
            java.lang.String r79 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r20 = r0
            r0 = r21
            java.lang.String r80 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r21 = r0
            r0 = r22
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x032e
            r22 = r0
            r0 = r23
            r81 = r65
            goto L_0x033c
        L_0x032e:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r22 = r0
            r81 = r16
            r0 = r23
        L_0x033c:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x0349
            r23 = r0
            r0 = r24
            r82 = r65
            goto L_0x0357
        L_0x0349:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r23 = r0
            r82 = r16
            r0 = r24
        L_0x0357:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r24 = r0
            r0 = r25
            if (r16 == 0) goto L_0x0364
            r83 = 1
            goto L_0x0366
        L_0x0364:
            r83 = 0
        L_0x0366:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x036f
            r16 = r65
            goto L_0x0377
        L_0x036f:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
        L_0x0377:
            if (r16 != 0) goto L_0x0380
            r25 = r0
            r0 = r26
            r84 = r65
            goto L_0x0395
        L_0x0380:
            int r16 = r16.intValue()     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x0389
            r16 = 1
            goto L_0x038b
        L_0x0389:
            r16 = 0
        L_0x038b:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r25 = r0
            r84 = r16
            r0 = r26
        L_0x0395:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x039e
            r16 = r65
            goto L_0x03a6
        L_0x039e:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
        L_0x03a6:
            if (r16 != 0) goto L_0x03af
            r26 = r0
            r0 = r27
            r85 = r65
            goto L_0x03c4
        L_0x03af:
            int r16 = r16.intValue()     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x03b8
            r16 = 1
            goto L_0x03ba
        L_0x03b8:
            r16 = 0
        L_0x03ba:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r26 = r0
            r85 = r16
            r0 = r27
        L_0x03c4:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x03cd
            r16 = r65
            goto L_0x03d5
        L_0x03cd:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
        L_0x03d5:
            if (r16 != 0) goto L_0x03de
            r27 = r0
            r0 = r28
            r86 = r65
            goto L_0x03f3
        L_0x03de:
            int r16 = r16.intValue()     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x03e7
            r16 = 1
            goto L_0x03e9
        L_0x03e7:
            r16 = 0
        L_0x03e9:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r27 = r0
            r86 = r16
            r0 = r28
        L_0x03f3:
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x03fc
            r16 = r65
            goto L_0x0404
        L_0x03fc:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0652 }
        L_0x0404:
            if (r16 != 0) goto L_0x040d
            r28 = r0
            r0 = r29
            r87 = r65
            goto L_0x0422
        L_0x040d:
            int r16 = r16.intValue()     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x0416
            r16 = 1
            goto L_0x0418
        L_0x0416:
            r16 = 0
        L_0x0418:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x0652 }
            r28 = r0
            r87 = r16
            r0 = r29
        L_0x0422:
            java.lang.String r88 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r29 = r0
            r0 = r30
            int r89 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r30 = r0
            r0 = r31
            int r90 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r31 = r0
            r0 = r32
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r32 = r0
            r0 = r33
            if (r16 == 0) goto L_0x0447
            r91 = 1
            goto L_0x0449
        L_0x0447:
            r91 = 0
        L_0x0449:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r33 = r0
            r0 = r34
            if (r16 == 0) goto L_0x0456
            r92 = 1
            goto L_0x0458
        L_0x0456:
            r92 = 0
        L_0x0458:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r34 = r0
            r0 = r35
            if (r16 == 0) goto L_0x0465
            r93 = 1
            goto L_0x0467
        L_0x0465:
            r93 = 0
        L_0x0467:
            int r16 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r35 = r0
            r0 = r36
            if (r16 == 0) goto L_0x0474
            r94 = 1
            goto L_0x0476
        L_0x0474:
            r94 = 0
        L_0x0476:
            java.lang.String r95 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r36 = r0
            r0 = r37
            java.lang.String r96 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r37 = r0
            r0 = r38
            java.lang.String r97 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r38 = r0
            r0 = r39
            java.lang.String r98 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r39 = r0
            r0 = r40
            java.lang.String r99 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r40 = r0
            r0 = r41
            int r100 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r41 = r0
            r0 = r42
            int r101 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r42 = r0
            r0 = r43
            int r102 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r43 = r0
            r0 = r44
            java.lang.String r103 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r44 = r0
            r0 = r45
            java.lang.String r104 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r45 = r0
            r0 = r46
            java.lang.String r105 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r46 = r0
            r0 = r47
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x04db
            r47 = r0
            r0 = r48
            r106 = r65
            goto L_0x04e9
        L_0x04db:
            double r106 = r3.getDouble(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Double r16 = java.lang.Double.valueOf(r106)     // Catch:{ all -> 0x0652 }
            r47 = r0
            r106 = r16
            r0 = r48
        L_0x04e9:
            int r107 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            r48 = r0
            r0 = r49
            java.lang.String r108 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r49 = r0
            r0 = r50
            java.lang.String r109 = r3.getString(r0)     // Catch:{ all -> 0x0652 }
            r50 = r0
            r0 = r51
            boolean r16 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r16 == 0) goto L_0x053c
            r16 = r2
            r2 = r52
            boolean r51 = r3.isNull(r2)     // Catch:{ all -> 0x0652 }
            if (r51 == 0) goto L_0x0535
            r51 = r4
            r4 = r53
            boolean r52 = r3.isNull(r4)     // Catch:{ all -> 0x0652 }
            if (r52 == 0) goto L_0x0544
            r52 = r5
            r5 = r54
            boolean r53 = r3.isNull(r5)     // Catch:{ all -> 0x0652 }
            if (r53 != 0) goto L_0x0526
            goto L_0x0548
        L_0x0526:
            r54 = r0
            r112 = r2
            r113 = r4
            r114 = r5
            r53 = r6
            r0 = r55
            r5 = r65
            goto L_0x0581
        L_0x0535:
            r51 = r4
            r52 = r5
            r4 = r53
            goto L_0x0546
        L_0x053c:
            r16 = r2
            r51 = r4
            r2 = r52
            r4 = r53
        L_0x0544:
            r52 = r5
        L_0x0546:
            r5 = r54
        L_0x0548:
            boolean r53 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r53 == 0) goto L_0x0555
            r54 = r0
            r53 = r6
            r0 = r65
            goto L_0x0563
        L_0x0555:
            int r53 = r3.getInt(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Integer r53 = java.lang.Integer.valueOf(r53)     // Catch:{ all -> 0x0652 }
            r54 = r0
            r0 = r53
            r53 = r6
        L_0x0563:
            java.lang.String r6 = r3.getString(r2)     // Catch:{ all -> 0x0652 }
            r112 = r2
            java.lang.String r2 = r3.getString(r4)     // Catch:{ all -> 0x0652 }
            int r60 = r3.getInt(r5)     // Catch:{ all -> 0x0652 }
            r113 = r4
            r114 = r5
            if (r60 == 0) goto L_0x0579
            r4 = 1
            goto L_0x057a
        L_0x0579:
            r4 = 0
        L_0x057a:
            net.one97.paytm.feed.repository.models.CreatedBy r5 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x0652 }
            r5.<init>(r0, r6, r2, r4)     // Catch:{ all -> 0x0652 }
            r0 = r55
        L_0x0581:
            boolean r2 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r2 == 0) goto L_0x05b8
            r2 = r56
            boolean r4 = r3.isNull(r2)     // Catch:{ all -> 0x0652 }
            if (r4 == 0) goto L_0x05b5
            r4 = r57
            boolean r6 = r3.isNull(r4)     // Catch:{ all -> 0x0652 }
            if (r6 == 0) goto L_0x05b2
            r6 = r58
            boolean r55 = r3.isNull(r6)     // Catch:{ all -> 0x0652 }
            if (r55 == 0) goto L_0x05af
            r55 = r7
            r7 = r59
            boolean r56 = r3.isNull(r7)     // Catch:{ all -> 0x0652 }
            if (r56 != 0) goto L_0x05aa
            goto L_0x05c2
        L_0x05aa:
            r56 = r0
            r66 = r65
            goto L_0x05ef
        L_0x05af:
            r55 = r7
            goto L_0x05c0
        L_0x05b2:
            r55 = r7
            goto L_0x05be
        L_0x05b5:
            r55 = r7
            goto L_0x05bc
        L_0x05b8:
            r55 = r7
            r2 = r56
        L_0x05bc:
            r4 = r57
        L_0x05be:
            r6 = r58
        L_0x05c0:
            r7 = r59
        L_0x05c2:
            boolean r56 = r3.isNull(r0)     // Catch:{ all -> 0x0652 }
            if (r56 == 0) goto L_0x05cb
        L_0x05c8:
            r116 = r65
            goto L_0x05d4
        L_0x05cb:
            double r56 = r3.getDouble(r0)     // Catch:{ all -> 0x0652 }
            java.lang.Double r65 = java.lang.Double.valueOf(r56)     // Catch:{ all -> 0x0652 }
            goto L_0x05c8
        L_0x05d4:
            java.lang.String r117 = r3.getString(r2)     // Catch:{ all -> 0x0652 }
            java.lang.String r118 = r3.getString(r4)     // Catch:{ all -> 0x0652 }
            java.lang.String r119 = r3.getString(r6)     // Catch:{ all -> 0x0652 }
            java.lang.String r120 = r3.getString(r7)     // Catch:{ all -> 0x0652 }
            net.one97.paytm.feed.repository.models.MlProperties r56 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x0652 }
            r115 = r56
            r115.<init>(r116, r117, r118, r119, r120)     // Catch:{ all -> 0x0652 }
            r66 = r56
            r56 = r0
        L_0x05ef:
            net.one97.paytm.feed.repository.models.FeedOfFeed r0 = new net.one97.paytm.feed.repository.models.FeedOfFeed     // Catch:{ all -> 0x0652 }
            r60 = r0
            r65 = r5
            r60.<init>(r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109)     // Catch:{ all -> 0x0652 }
            r1.add(r0)     // Catch:{ all -> 0x0652 }
            goto L_0x061c
        L_0x05fc:
            r110 = r0
            r111 = r16
            r112 = r52
            r113 = r53
            r114 = r54
            r16 = r2
            r52 = r5
            r53 = r6
            r54 = r51
            r2 = r56
            r6 = r58
            r51 = r4
            r56 = r55
            r4 = r57
            r55 = r7
            r7 = r59
        L_0x061c:
            r57 = r4
            r58 = r6
            r1 = r7
            r4 = r51
            r5 = r52
            r6 = r53
            r51 = r54
            r7 = r55
            r55 = r56
            r0 = r110
            r52 = r112
            r53 = r113
            goto L_0x0644
        L_0x0634:
            r111 = r16
            r112 = r52
            r113 = r53
            r114 = r54
            r16 = r2
            r54 = r51
            r2 = r56
            r56 = r55
        L_0x0644:
            r54 = r114
            r56 = r2
            r2 = r16
            r16 = r111
            goto L_0x0241
        L_0x064e:
            r3.close()
            return
        L_0x0652:
            r0 = move-exception
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.f(androidx.a.a):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x069a A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x06fa A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x06fd A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x070d A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0710 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0720 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0727 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x073b A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x073e A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0748 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x074f A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0782 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0789 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x079d A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x07a4 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x07bc A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x07bf A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x07c7 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x07ca A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x07d4 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x07db A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x07f6 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x07f9 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0803 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x080a A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0825 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0828 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0832 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0839 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0854 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0857 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0861 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0868 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x089f A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x08a2 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x08ae A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x08b1 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x08bd A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x08c0 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x08cc A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x08cf A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x092f A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0936 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0962 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0998 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x09aa A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x09b0 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x09ce A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x09d4 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x09e8 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0a0a A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0a16 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0a19 A[Catch:{ all -> 0x0b25 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0324 A[Catch:{ all -> 0x0b25 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>> r142) {
        /*
            r141 = this;
            r1 = r141
            java.lang.String r0 = "sid"
            r2 = r142
        L_0x0007:
            java.util.Set r3 = r2.keySet()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0012
            return
        L_0x0012:
            int r4 = r2.size()
            r5 = 999(0x3e7, float:1.4E-42)
            r6 = 0
            if (r4 <= r5) goto L_0x0048
            androidx.a.a r3 = new androidx.a.a
            r3.<init>((int) r5)
            int r4 = r2.size()
            r8 = r3
            r3 = 0
        L_0x0026:
            r7 = 0
        L_0x0027:
            if (r3 >= r4) goto L_0x0043
            java.lang.Object r9 = r2.b((int) r3)
            java.lang.Object r10 = r2.c(r3)
            r8.put(r9, r10)
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r7 != r5) goto L_0x0027
            r1.g((androidx.a.a<java.lang.String, java.util.ArrayList<net.one97.paytm.feed.repository.models.stories.Stories>>) r8)
            androidx.a.a r8 = new androidx.a.a
            r8.<init>((int) r5)
            goto L_0x0026
        L_0x0043:
            if (r7 <= 0) goto L_0x0047
            r2 = r8
            goto L_0x0007
        L_0x0047:
            return
        L_0x0048:
            java.lang.StringBuilder r4 = androidx.room.b.e.a()
            java.lang.String r5 = "SELECT `storyId`,`sid`,`completelySeen`,`storyUpdatedAt`,`storyposition`,`postIds`,`userCanFollow`,`userId`,`userImageUrl`,`userName`,`id`,`uiId`,`groupId`,`rank`,`poweredBy`,`createdAt`,`imageUrl`,`width`,`height`,`title`,`webUrl`,`likeCount`,`commentCount`,`shareCount`,`isLiked`,`description`,`displayTime`,`streamUrl`,`duration`,`viewCount`,`canLike`,`canComment`,`canShare`,`isSensitive`,`isFlaggedByUser`,`deepLink`,`category`,`following`,`mute`,`isBookmarked`,`isFollowed`,`canFollow`,`likeCountDisplay`,`commentCountDisplay`,`shareCountDisplay`,`buckets`,`feedItemType`,`feedItemRank`,`feedItemCategoryRank`,`profileRank`,`mlVersion`,`contentFormat`,`mlCategory`,`score`,`followingRank`,`ctaImageUrl`,`ctaDisplayText`,`creatorId`,`createdByName`,`createdByImageUrl`,`createdByCanFollow`,`ItemScore`,`ItemBucket`,`ItemContentFormat`,`ItemMlVersion`,`ItemMlCategory` FROM `Stories` WHERE `sid` IN ("
            r4.append(r5)
            int r5 = r3.size()
            androidx.room.b.e.a(r4, r5)
            java.lang.String r7 = ")"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            int r5 = r5 + r6
            androidx.room.m r4 = androidx.room.m.a((java.lang.String) r4, (int) r5)
            java.util.Iterator r3 = r3.iterator()
            r5 = 1
            r7 = 1
        L_0x006c:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0085
            java.lang.Object r8 = r3.next()
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x007f
            int[] r8 = r4.f4477f
            r8[r7] = r5
            goto L_0x0082
        L_0x007f:
            r4.a((int) r7, (java.lang.String) r8)
        L_0x0082:
            int r7 = r7 + 1
            goto L_0x006c
        L_0x0085:
            androidx.room.j r3 = r1.f34655a
            android.database.Cursor r3 = r3.query(r4)
            int r4 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x0b25 }
            r7 = -1
            if (r4 != r7) goto L_0x0096
            r3.close()
            return
        L_0x0096:
            java.lang.String r7 = "storyId"
            int r7 = r3.getColumnIndexOrThrow(r7)     // Catch:{ all -> 0x0b25 }
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.String r8 = "completelySeen"
            int r8 = r3.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x0b25 }
            java.lang.String r9 = "storyUpdatedAt"
            int r9 = r3.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x0b25 }
            java.lang.String r10 = "storyposition"
            int r10 = r3.getColumnIndexOrThrow(r10)     // Catch:{ all -> 0x0b25 }
            java.lang.String r11 = "postIds"
            int r11 = r3.getColumnIndexOrThrow(r11)     // Catch:{ all -> 0x0b25 }
            java.lang.String r12 = "userCanFollow"
            int r12 = r3.getColumnIndexOrThrow(r12)     // Catch:{ all -> 0x0b25 }
            java.lang.String r13 = "userId"
            int r13 = r3.getColumnIndexOrThrow(r13)     // Catch:{ all -> 0x0b25 }
            java.lang.String r14 = "userImageUrl"
            int r14 = r3.getColumnIndexOrThrow(r14)     // Catch:{ all -> 0x0b25 }
            java.lang.String r15 = "userName"
            int r15 = r3.getColumnIndexOrThrow(r15)     // Catch:{ all -> 0x0b25 }
            java.lang.String r5 = "id"
            int r5 = r3.getColumnIndexOrThrow(r5)     // Catch:{ all -> 0x0b25 }
            java.lang.String r6 = "uiId"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r16 = r6
            java.lang.String r6 = "groupId"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r17 = r6
            java.lang.String r6 = "rank"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r18 = r6
            java.lang.String r6 = "poweredBy"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r19 = r6
            java.lang.String r6 = "createdAt"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r20 = r6
            java.lang.String r6 = "imageUrl"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r21 = r6
            java.lang.String r6 = "width"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r22 = r6
            java.lang.String r6 = "height"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r23 = r6
            java.lang.String r6 = "title"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r24 = r6
            java.lang.String r6 = "webUrl"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r25 = r6
            java.lang.String r6 = "likeCount"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r26 = r6
            java.lang.String r6 = "commentCount"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r27 = r6
            java.lang.String r6 = "shareCount"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r28 = r6
            java.lang.String r6 = "isLiked"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r29 = r6
            java.lang.String r6 = "description"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r30 = r6
            java.lang.String r6 = "displayTime"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r31 = r6
            java.lang.String r6 = "streamUrl"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r32 = r6
            java.lang.String r6 = "duration"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r33 = r6
            java.lang.String r6 = "viewCount"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r34 = r6
            java.lang.String r6 = "canLike"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r35 = r6
            java.lang.String r6 = "canComment"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r36 = r6
            java.lang.String r6 = "canShare"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r37 = r6
            java.lang.String r6 = "isSensitive"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r38 = r6
            java.lang.String r6 = "isFlaggedByUser"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r39 = r6
            java.lang.String r6 = "deepLink"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r40 = r6
            java.lang.String r6 = "category"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r41 = r6
            java.lang.String r6 = "following"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r42 = r6
            java.lang.String r6 = "mute"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r43 = r6
            java.lang.String r6 = "isBookmarked"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r44 = r6
            java.lang.String r6 = "isFollowed"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r45 = r6
            java.lang.String r6 = "canFollow"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r46 = r6
            java.lang.String r6 = "likeCountDisplay"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r47 = r6
            java.lang.String r6 = "commentCountDisplay"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r48 = r6
            java.lang.String r6 = "shareCountDisplay"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r49 = r6
            java.lang.String r6 = "buckets"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r50 = r6
            java.lang.String r6 = "feedItemType"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r51 = r6
            java.lang.String r6 = "feedItemRank"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r52 = r6
            java.lang.String r6 = "feedItemCategoryRank"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r53 = r6
            java.lang.String r6 = "profileRank"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r54 = r6
            java.lang.String r6 = "mlVersion"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r55 = r6
            java.lang.String r6 = "contentFormat"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r56 = r6
            java.lang.String r6 = "mlCategory"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r57 = r6
            java.lang.String r6 = "score"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r58 = r6
            java.lang.String r6 = "followingRank"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r59 = r6
            java.lang.String r6 = "ctaImageUrl"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r60 = r6
            java.lang.String r6 = "ctaDisplayText"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r61 = r6
            java.lang.String r6 = "creatorId"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r62 = r6
            java.lang.String r6 = "createdByName"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r63 = r6
            java.lang.String r6 = "createdByImageUrl"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r64 = r6
            java.lang.String r6 = "createdByCanFollow"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r65 = r6
            java.lang.String r6 = "ItemScore"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r66 = r6
            java.lang.String r6 = "ItemBucket"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r67 = r6
            java.lang.String r6 = "ItemContentFormat"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r68 = r6
            java.lang.String r6 = "ItemMlVersion"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
            r69 = r6
            java.lang.String r6 = "ItemMlCategory"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ all -> 0x0b25 }
        L_0x029b:
            boolean r70 = r3.moveToNext()     // Catch:{ all -> 0x0b25 }
            if (r70 == 0) goto L_0x0b21
            boolean r70 = r3.isNull(r4)     // Catch:{ all -> 0x0b25 }
            if (r70 != 0) goto L_0x0abd
            r70 = r6
            java.lang.String r6 = r3.getString(r4)     // Catch:{ all -> 0x0b25 }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0b25 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x0b25 }
            if (r6 == 0) goto L_0x0a54
            java.lang.String r72 = r3.getString(r7)     // Catch:{ all -> 0x0b25 }
            java.lang.String r73 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            int r71 = r3.getInt(r8)     // Catch:{ all -> 0x0b25 }
            if (r71 == 0) goto L_0x02c6
            r75 = 1
            goto L_0x02c8
        L_0x02c6:
            r75 = 0
        L_0x02c8:
            java.lang.String r76 = r3.getString(r9)     // Catch:{ all -> 0x0b25 }
            int r77 = r3.getInt(r10)     // Catch:{ all -> 0x0b25 }
            r80 = r0
            java.lang.String r0 = r3.getString(r11)     // Catch:{ all -> 0x0b25 }
            r81 = r2
            net.one97.paytm.feed.repository.models.stories.StoryIdConverter r2 = r1.f34656b     // Catch:{ all -> 0x0b25 }
            java.util.List r78 = r2.jsonToList(r0)     // Catch:{ all -> 0x0b25 }
            boolean r0 = r3.isNull(r12)     // Catch:{ all -> 0x0b25 }
            if (r0 == 0) goto L_0x02fe
            boolean r0 = r3.isNull(r13)     // Catch:{ all -> 0x0b25 }
            if (r0 == 0) goto L_0x02fe
            boolean r0 = r3.isNull(r14)     // Catch:{ all -> 0x0b25 }
            if (r0 == 0) goto L_0x02fe
            boolean r0 = r3.isNull(r15)     // Catch:{ all -> 0x0b25 }
            if (r0 != 0) goto L_0x02f7
            goto L_0x02fe
        L_0x02f7:
            r82 = r4
            r83 = r7
            r74 = 0
            goto L_0x031e
        L_0x02fe:
            int r0 = r3.getInt(r12)     // Catch:{ all -> 0x0b25 }
            if (r0 == 0) goto L_0x0306
            r0 = 1
            goto L_0x0307
        L_0x0306:
            r0 = 0
        L_0x0307:
            int r2 = r3.getInt(r13)     // Catch:{ all -> 0x0b25 }
            java.lang.String r1 = r3.getString(r14)     // Catch:{ all -> 0x0b25 }
            r82 = r4
            java.lang.String r4 = r3.getString(r15)     // Catch:{ all -> 0x0b25 }
            r83 = r7
            net.one97.paytm.feed.repository.models.stories.User r7 = new net.one97.paytm.feed.repository.models.stories.User     // Catch:{ all -> 0x0b25 }
            r7.<init>(r0, r2, r1, r4)     // Catch:{ all -> 0x0b25 }
            r74 = r7
        L_0x031e:
            boolean r0 = r3.isNull(r5)     // Catch:{ all -> 0x0b25 }
            if (r0 == 0) goto L_0x069a
            r0 = r16
            boolean r1 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r1 == 0) goto L_0x0673
            r1 = r17
            boolean r2 = r3.isNull(r1)     // Catch:{ all -> 0x0b25 }
            if (r2 == 0) goto L_0x064c
            r2 = r18
            boolean r4 = r3.isNull(r2)     // Catch:{ all -> 0x0b25 }
            if (r4 == 0) goto L_0x0624
            r4 = r19
            boolean r7 = r3.isNull(r4)     // Catch:{ all -> 0x0b25 }
            if (r7 == 0) goto L_0x0604
            r7 = r20
            boolean r16 = r3.isNull(r7)     // Catch:{ all -> 0x0b25 }
            if (r16 == 0) goto L_0x06a4
            r16 = r8
            r8 = r21
            boolean r17 = r3.isNull(r8)     // Catch:{ all -> 0x0b25 }
            if (r17 == 0) goto L_0x067f
            r17 = r9
            r9 = r22
            boolean r18 = r3.isNull(r9)     // Catch:{ all -> 0x0b25 }
            if (r18 == 0) goto L_0x065a
            r18 = r10
            r10 = r23
            boolean r19 = r3.isNull(r10)     // Catch:{ all -> 0x0b25 }
            if (r19 == 0) goto L_0x0634
            r19 = r11
            r11 = r24
            boolean r20 = r3.isNull(r11)     // Catch:{ all -> 0x0b25 }
            if (r20 == 0) goto L_0x0616
            r20 = r12
            r12 = r25
            boolean r21 = r3.isNull(r12)     // Catch:{ all -> 0x0b25 }
            if (r21 == 0) goto L_0x06b8
            r21 = r13
            r13 = r26
            boolean r22 = r3.isNull(r13)     // Catch:{ all -> 0x0b25 }
            if (r22 == 0) goto L_0x0693
            r22 = r14
            r14 = r27
            boolean r23 = r3.isNull(r14)     // Catch:{ all -> 0x0b25 }
            if (r23 == 0) goto L_0x066e
            r23 = r15
            r15 = r28
            boolean r24 = r3.isNull(r15)     // Catch:{ all -> 0x0b25 }
            if (r24 == 0) goto L_0x0648
            r24 = r6
            r6 = r29
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0600
            r29 = r6
            r6 = r30
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05fc
            r30 = r6
            r6 = r31
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05f8
            r31 = r6
            r6 = r32
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05f4
            r32 = r6
            r6 = r33
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05f0
            r33 = r6
            r6 = r34
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05ec
            r34 = r6
            r6 = r35
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05e8
            r35 = r6
            r6 = r36
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05e4
            r36 = r6
            r6 = r37
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05e0
            r37 = r6
            r6 = r38
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05dc
            r38 = r6
            r6 = r39
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05d8
            r39 = r6
            r6 = r40
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05d4
            r40 = r6
            r6 = r41
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05d0
            r41 = r6
            r6 = r42
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05cc
            r42 = r6
            r6 = r43
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05c8
            r43 = r6
            r6 = r44
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05c4
            r44 = r6
            r6 = r45
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05c0
            r45 = r6
            r6 = r46
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05bc
            r46 = r6
            r6 = r47
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05b8
            r47 = r6
            r6 = r48
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05b4
            r48 = r6
            r6 = r49
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05b0
            r49 = r6
            r6 = r50
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05ac
            r50 = r6
            r6 = r51
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05a8
            r51 = r6
            r6 = r52
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05a4
            r52 = r6
            r6 = r53
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x05a0
            r53 = r6
            r6 = r54
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x059c
            r54 = r6
            r6 = r55
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0598
            r55 = r6
            r6 = r56
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0594
            r56 = r6
            r6 = r57
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0590
            r57 = r6
            r6 = r58
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x058c
            r58 = r6
            r6 = r59
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0588
            r59 = r6
            r6 = r60
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0584
            r60 = r6
            r6 = r61
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0580
            r61 = r6
            r6 = r62
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x057c
            r62 = r6
            r6 = r63
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0578
            r63 = r6
            r6 = r64
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0574
            r64 = r6
            r6 = r65
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0570
            r65 = r6
            r6 = r66
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x056c
            r66 = r6
            r6 = r67
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0568
            r67 = r6
            r6 = r68
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0564
            r68 = r6
            r6 = r69
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0560
            r69 = r6
            r6 = r70
            boolean r25 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r25 != 0) goto L_0x0542
            goto L_0x06c8
        L_0x0542:
            r26 = r0
            r25 = r1
            r27 = r2
            r28 = r4
            r70 = r65
            r0 = r66
            r1 = r67
            r2 = r68
            r4 = r69
            r79 = 0
            r65 = r64
            r64 = r63
            r63 = r62
            r62 = r5
            goto L_0x0a45
        L_0x0560:
            r69 = r6
            goto L_0x06c6
        L_0x0564:
            r68 = r6
            goto L_0x06c6
        L_0x0568:
            r67 = r6
            goto L_0x06c6
        L_0x056c:
            r66 = r6
            goto L_0x06c6
        L_0x0570:
            r65 = r6
            goto L_0x06c6
        L_0x0574:
            r64 = r6
            goto L_0x06c6
        L_0x0578:
            r63 = r6
            goto L_0x06c6
        L_0x057c:
            r62 = r6
            goto L_0x06c6
        L_0x0580:
            r61 = r6
            goto L_0x06c6
        L_0x0584:
            r60 = r6
            goto L_0x06c6
        L_0x0588:
            r59 = r6
            goto L_0x06c6
        L_0x058c:
            r58 = r6
            goto L_0x06c6
        L_0x0590:
            r57 = r6
            goto L_0x06c6
        L_0x0594:
            r56 = r6
            goto L_0x06c6
        L_0x0598:
            r55 = r6
            goto L_0x06c6
        L_0x059c:
            r54 = r6
            goto L_0x06c6
        L_0x05a0:
            r53 = r6
            goto L_0x06c6
        L_0x05a4:
            r52 = r6
            goto L_0x06c6
        L_0x05a8:
            r51 = r6
            goto L_0x06c6
        L_0x05ac:
            r50 = r6
            goto L_0x06c6
        L_0x05b0:
            r49 = r6
            goto L_0x06c6
        L_0x05b4:
            r48 = r6
            goto L_0x06c6
        L_0x05b8:
            r47 = r6
            goto L_0x06c6
        L_0x05bc:
            r46 = r6
            goto L_0x06c6
        L_0x05c0:
            r45 = r6
            goto L_0x06c6
        L_0x05c4:
            r44 = r6
            goto L_0x06c6
        L_0x05c8:
            r43 = r6
            goto L_0x06c6
        L_0x05cc:
            r42 = r6
            goto L_0x06c6
        L_0x05d0:
            r41 = r6
            goto L_0x06c6
        L_0x05d4:
            r40 = r6
            goto L_0x06c6
        L_0x05d8:
            r39 = r6
            goto L_0x06c6
        L_0x05dc:
            r38 = r6
            goto L_0x06c6
        L_0x05e0:
            r37 = r6
            goto L_0x06c6
        L_0x05e4:
            r36 = r6
            goto L_0x06c6
        L_0x05e8:
            r35 = r6
            goto L_0x06c6
        L_0x05ec:
            r34 = r6
            goto L_0x06c6
        L_0x05f0:
            r33 = r6
            goto L_0x06c6
        L_0x05f4:
            r32 = r6
            goto L_0x06c6
        L_0x05f8:
            r31 = r6
            goto L_0x06c6
        L_0x05fc:
            r30 = r6
            goto L_0x06c6
        L_0x0600:
            r29 = r6
            goto L_0x06c6
        L_0x0604:
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
        L_0x0616:
            r24 = r6
            r20 = r12
            r21 = r13
            r22 = r14
            r23 = r15
            r12 = r25
            goto L_0x06c0
        L_0x0624:
            r16 = r8
            r17 = r9
            r18 = r10
            r4 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
        L_0x0634:
            r19 = r11
            r20 = r12
            r21 = r13
            r22 = r14
            r23 = r15
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r15 = r28
        L_0x0648:
            r24 = r6
            goto L_0x06c6
        L_0x064c:
            r16 = r8
            r17 = r9
            r2 = r18
            r4 = r19
            r7 = r20
            r8 = r21
            r9 = r22
        L_0x065a:
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r22 = r14
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
        L_0x066e:
            r24 = r6
            r23 = r15
            goto L_0x06c4
        L_0x0673:
            r16 = r8
            r1 = r17
            r2 = r18
            r4 = r19
            r7 = r20
            r8 = r21
        L_0x067f:
            r17 = r9
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
        L_0x0693:
            r24 = r6
            r22 = r14
            r23 = r15
            goto L_0x06c2
        L_0x069a:
            r0 = r16
            r1 = r17
            r2 = r18
            r4 = r19
            r7 = r20
        L_0x06a4:
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r20 = r12
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
        L_0x06b8:
            r24 = r6
            r21 = r13
            r22 = r14
            r23 = r15
        L_0x06c0:
            r13 = r26
        L_0x06c2:
            r14 = r27
        L_0x06c4:
            r15 = r28
        L_0x06c6:
            r6 = r70
        L_0x06c8:
            java.lang.String r85 = r3.getString(r5)     // Catch:{ all -> 0x0b25 }
            int r86 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.String r87 = r3.getString(r1)     // Catch:{ all -> 0x0b25 }
            int r88 = r3.getInt(r2)     // Catch:{ all -> 0x0b25 }
            java.lang.String r91 = r3.getString(r4)     // Catch:{ all -> 0x0b25 }
            java.lang.String r92 = r3.getString(r7)     // Catch:{ all -> 0x0b25 }
            java.lang.String r93 = r3.getString(r8)     // Catch:{ all -> 0x0b25 }
            java.lang.String r94 = r3.getString(r9)     // Catch:{ all -> 0x0b25 }
            java.lang.String r95 = r3.getString(r10)     // Catch:{ all -> 0x0b25 }
            java.lang.String r96 = r3.getString(r11)     // Catch:{ all -> 0x0b25 }
            java.lang.String r97 = r3.getString(r12)     // Catch:{ all -> 0x0b25 }
            boolean r25 = r3.isNull(r13)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x06fd
            r98 = 0
            goto L_0x0707
        L_0x06fd:
            int r25 = r3.getInt(r13)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r98 = r25
        L_0x0707:
            boolean r25 = r3.isNull(r14)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0710
            r99 = 0
            goto L_0x071a
        L_0x0710:
            int r25 = r3.getInt(r14)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r99 = r25
        L_0x071a:
            boolean r25 = r3.isNull(r15)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0727
            r26 = r0
            r0 = r29
            r100 = 0
            goto L_0x0735
        L_0x0727:
            int r25 = r3.getInt(r15)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r26 = r0
            r100 = r25
            r0 = r29
        L_0x0735:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x073e
            r25 = 0
            goto L_0x0746
        L_0x073e:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
        L_0x0746:
            if (r25 != 0) goto L_0x074f
            r29 = r0
            r0 = r30
            r101 = 0
            goto L_0x0764
        L_0x074f:
            int r25 = r25.intValue()     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0758
            r25 = 1
            goto L_0x075a
        L_0x0758:
            r25 = 0
        L_0x075a:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r29 = r0
            r101 = r25
            r0 = r30
        L_0x0764:
            java.lang.String r102 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r30 = r0
            r0 = r31
            java.lang.String r103 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r31 = r0
            r0 = r32
            java.lang.String r104 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r32 = r0
            r0 = r33
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0789
            r33 = r0
            r0 = r34
            r105 = 0
            goto L_0x0797
        L_0x0789:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r33 = r0
            r105 = r25
            r0 = r34
        L_0x0797:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x07a4
            r34 = r0
            r0 = r35
            r106 = 0
            goto L_0x07b2
        L_0x07a4:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r34 = r0
            r106 = r25
            r0 = r35
        L_0x07b2:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r35 = r0
            r0 = r36
            if (r25 == 0) goto L_0x07bf
            r107 = 1
            goto L_0x07c1
        L_0x07bf:
            r107 = 0
        L_0x07c1:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x07ca
            r25 = 0
            goto L_0x07d2
        L_0x07ca:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
        L_0x07d2:
            if (r25 != 0) goto L_0x07db
            r36 = r0
            r0 = r37
            r108 = 0
            goto L_0x07f0
        L_0x07db:
            int r25 = r25.intValue()     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x07e4
            r25 = 1
            goto L_0x07e6
        L_0x07e4:
            r25 = 0
        L_0x07e6:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r36 = r0
            r108 = r25
            r0 = r37
        L_0x07f0:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x07f9
            r25 = 0
            goto L_0x0801
        L_0x07f9:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
        L_0x0801:
            if (r25 != 0) goto L_0x080a
            r37 = r0
            r0 = r38
            r109 = 0
            goto L_0x081f
        L_0x080a:
            int r25 = r25.intValue()     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0813
            r25 = 1
            goto L_0x0815
        L_0x0813:
            r25 = 0
        L_0x0815:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r37 = r0
            r109 = r25
            r0 = r38
        L_0x081f:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0828
            r25 = 0
            goto L_0x0830
        L_0x0828:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
        L_0x0830:
            if (r25 != 0) goto L_0x0839
            r38 = r0
            r0 = r39
            r110 = 0
            goto L_0x084e
        L_0x0839:
            int r25 = r25.intValue()     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0842
            r25 = 1
            goto L_0x0844
        L_0x0842:
            r25 = 0
        L_0x0844:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r38 = r0
            r110 = r25
            r0 = r39
        L_0x084e:
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0857
            r25 = 0
            goto L_0x085f
        L_0x0857:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r25 = java.lang.Integer.valueOf(r25)     // Catch:{ all -> 0x0b25 }
        L_0x085f:
            if (r25 != 0) goto L_0x0868
            r39 = r0
            r0 = r40
            r111 = 0
            goto L_0x087d
        L_0x0868:
            int r25 = r25.intValue()     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0871
            r25 = 1
            goto L_0x0873
        L_0x0871:
            r25 = 0
        L_0x0873:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x0b25 }
            r39 = r0
            r111 = r25
            r0 = r40
        L_0x087d:
            java.lang.String r112 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r40 = r0
            r0 = r41
            int r113 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r41 = r0
            r0 = r42
            int r114 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r42 = r0
            r0 = r43
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r43 = r0
            r0 = r44
            if (r25 == 0) goto L_0x08a2
            r115 = 1
            goto L_0x08a4
        L_0x08a2:
            r115 = 0
        L_0x08a4:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r44 = r0
            r0 = r45
            if (r25 == 0) goto L_0x08b1
            r116 = 1
            goto L_0x08b3
        L_0x08b1:
            r116 = 0
        L_0x08b3:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r45 = r0
            r0 = r46
            if (r25 == 0) goto L_0x08c0
            r117 = 1
            goto L_0x08c2
        L_0x08c0:
            r117 = 0
        L_0x08c2:
            int r25 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r46 = r0
            r0 = r47
            if (r25 == 0) goto L_0x08cf
            r118 = 1
            goto L_0x08d1
        L_0x08cf:
            r118 = 0
        L_0x08d1:
            java.lang.String r119 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r47 = r0
            r0 = r48
            java.lang.String r120 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r48 = r0
            r0 = r49
            java.lang.String r121 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r49 = r0
            r0 = r50
            java.lang.String r122 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r50 = r0
            r0 = r51
            java.lang.String r123 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r51 = r0
            r0 = r52
            int r124 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r52 = r0
            r0 = r53
            int r125 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r53 = r0
            r0 = r54
            int r126 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r54 = r0
            r0 = r55
            java.lang.String r127 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r55 = r0
            r0 = r56
            java.lang.String r128 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r56 = r0
            r0 = r57
            java.lang.String r129 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r57 = r0
            r0 = r58
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0936
            r58 = r0
            r0 = r59
            r130 = 0
            goto L_0x0944
        L_0x0936:
            double r27 = r3.getDouble(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Double r25 = java.lang.Double.valueOf(r27)     // Catch:{ all -> 0x0b25 }
            r58 = r0
            r130 = r25
            r0 = r59
        L_0x0944:
            int r131 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            r59 = r0
            r0 = r60
            java.lang.String r132 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r60 = r0
            r0 = r61
            java.lang.String r133 = r3.getString(r0)     // Catch:{ all -> 0x0b25 }
            r61 = r0
            r0 = r62
            boolean r25 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r25 == 0) goto L_0x0998
            r25 = r1
            r1 = r63
            boolean r27 = r3.isNull(r1)     // Catch:{ all -> 0x0b25 }
            if (r27 == 0) goto L_0x0993
            r27 = r2
            r2 = r64
            boolean r28 = r3.isNull(r2)     // Catch:{ all -> 0x0b25 }
            if (r28 == 0) goto L_0x0990
            r28 = r4
            r4 = r65
            boolean r62 = r3.isNull(r4)     // Catch:{ all -> 0x0b25 }
            if (r62 != 0) goto L_0x0981
            goto L_0x09a4
        L_0x0981:
            r63 = r0
            r64 = r1
            r65 = r2
            r70 = r4
            r62 = r5
            r0 = r66
            r89 = 0
            goto L_0x09e2
        L_0x0990:
            r28 = r4
            goto L_0x09a2
        L_0x0993:
            r27 = r2
            r28 = r4
            goto L_0x09a0
        L_0x0998:
            r25 = r1
            r27 = r2
            r28 = r4
            r1 = r63
        L_0x09a0:
            r2 = r64
        L_0x09a2:
            r4 = r65
        L_0x09a4:
            boolean r62 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r62 == 0) goto L_0x09b0
            r63 = r0
            r62 = r5
            r0 = 0
            goto L_0x09be
        L_0x09b0:
            int r62 = r3.getInt(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Integer r62 = java.lang.Integer.valueOf(r62)     // Catch:{ all -> 0x0b25 }
            r63 = r0
            r0 = r62
            r62 = r5
        L_0x09be:
            java.lang.String r5 = r3.getString(r1)     // Catch:{ all -> 0x0b25 }
            r64 = r1
            java.lang.String r1 = r3.getString(r2)     // Catch:{ all -> 0x0b25 }
            int r65 = r3.getInt(r4)     // Catch:{ all -> 0x0b25 }
            if (r65 == 0) goto L_0x09d4
            r65 = r2
            r70 = r4
            r2 = 1
            goto L_0x09d9
        L_0x09d4:
            r65 = r2
            r70 = r4
            r2 = 0
        L_0x09d9:
            net.one97.paytm.feed.repository.models.CreatedBy r4 = new net.one97.paytm.feed.repository.models.CreatedBy     // Catch:{ all -> 0x0b25 }
            r4.<init>(r0, r5, r1, r2)     // Catch:{ all -> 0x0b25 }
            r89 = r4
            r0 = r66
        L_0x09e2:
            boolean r1 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r1 == 0) goto L_0x0a0a
            r1 = r67
            boolean r2 = r3.isNull(r1)     // Catch:{ all -> 0x0b25 }
            if (r2 == 0) goto L_0x0a0c
            r2 = r68
            boolean r4 = r3.isNull(r2)     // Catch:{ all -> 0x0b25 }
            if (r4 == 0) goto L_0x0a0e
            r4 = r69
            boolean r5 = r3.isNull(r4)     // Catch:{ all -> 0x0b25 }
            if (r5 == 0) goto L_0x0a10
            boolean r5 = r3.isNull(r6)     // Catch:{ all -> 0x0b25 }
            if (r5 != 0) goto L_0x0a07
            goto L_0x0a10
        L_0x0a07:
            r90 = 0
            goto L_0x0a3c
        L_0x0a0a:
            r1 = r67
        L_0x0a0c:
            r2 = r68
        L_0x0a0e:
            r4 = r69
        L_0x0a10:
            boolean r5 = r3.isNull(r0)     // Catch:{ all -> 0x0b25 }
            if (r5 == 0) goto L_0x0a19
            r135 = 0
            goto L_0x0a23
        L_0x0a19:
            double r66 = r3.getDouble(r0)     // Catch:{ all -> 0x0b25 }
            java.lang.Double r5 = java.lang.Double.valueOf(r66)     // Catch:{ all -> 0x0b25 }
            r135 = r5
        L_0x0a23:
            java.lang.String r136 = r3.getString(r1)     // Catch:{ all -> 0x0b25 }
            java.lang.String r137 = r3.getString(r2)     // Catch:{ all -> 0x0b25 }
            java.lang.String r138 = r3.getString(r4)     // Catch:{ all -> 0x0b25 }
            java.lang.String r139 = r3.getString(r6)     // Catch:{ all -> 0x0b25 }
            net.one97.paytm.feed.repository.models.MlProperties r5 = new net.one97.paytm.feed.repository.models.MlProperties     // Catch:{ all -> 0x0b25 }
            r134 = r5
            r134.<init>(r135, r136, r137, r138, r139)     // Catch:{ all -> 0x0b25 }
            r90 = r5
        L_0x0a3c:
            net.one97.paytm.feed.repository.models.FeedOfFeed r5 = new net.one97.paytm.feed.repository.models.FeedOfFeed     // Catch:{ all -> 0x0b25 }
            r84 = r5
            r84.<init>(r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133)     // Catch:{ all -> 0x0b25 }
            r79 = r5
        L_0x0a45:
            net.one97.paytm.feed.repository.models.stories.Stories r5 = new net.one97.paytm.feed.repository.models.stories.Stories     // Catch:{ all -> 0x0b25 }
            r71 = r5
            r71.<init>(r72, r73, r74, r75, r76, r77, r78, r79)     // Catch:{ all -> 0x0b25 }
            r66 = r0
            r0 = r24
            r0.add(r5)     // Catch:{ all -> 0x0b25 }
            goto L_0x0a9a
        L_0x0a54:
            r80 = r0
            r81 = r2
            r82 = r4
            r83 = r7
            r7 = r20
            r1 = r67
            r2 = r68
            r4 = r69
            r6 = r70
            r20 = r12
            r12 = r25
            r70 = r65
            r25 = r17
            r65 = r64
            r17 = r9
            r9 = r22
            r64 = r63
            r22 = r14
            r14 = r27
            r63 = r62
            r62 = r5
            r27 = r18
            r18 = r10
            r10 = r23
            r23 = r15
            r15 = r28
            r28 = r19
            r19 = r11
            r11 = r24
            r140 = r16
            r16 = r8
            r8 = r21
            r21 = r13
            r13 = r26
            r26 = r140
        L_0x0a9a:
            r67 = r1
            r68 = r2
            r69 = r4
            r24 = r11
            r11 = r19
            r19 = r28
            r5 = r62
            r62 = r63
            r63 = r64
            r64 = r65
            r65 = r70
            r0 = r80
            r2 = r81
            r4 = r82
            r1 = r141
            r28 = r15
            r15 = r23
            goto L_0x0afb
        L_0x0abd:
            r81 = r2
            r82 = r4
            r83 = r7
            r7 = r20
            r70 = r65
            r20 = r12
            r12 = r25
            r65 = r64
            r25 = r17
            r64 = r63
            r17 = r9
            r9 = r22
            r63 = r62
            r22 = r14
            r14 = r27
            r27 = r18
            r18 = r10
            r10 = r23
            r23 = r15
            r15 = r28
            r140 = r16
            r16 = r8
            r8 = r21
            r21 = r13
            r13 = r26
            r26 = r140
            r1 = r141
            r15 = r23
            r63 = r64
            r64 = r65
            r65 = r70
        L_0x0afb:
            r23 = r10
            r10 = r18
            r18 = r27
            r27 = r14
            r14 = r22
            r22 = r9
            r9 = r17
            r17 = r25
            r25 = r12
            r12 = r20
            r20 = r7
            r7 = r83
            r140 = r21
            r21 = r8
            r8 = r16
            r16 = r26
            r26 = r13
            r13 = r140
            goto L_0x029b
        L_0x0b21:
            r3.close()
            return
        L_0x0b25:
            r0 = move-exception
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.db.a.b.g(androidx.a.a):void");
    }

    /* access modifiers changed from: private */
    public void h(a<String, ArrayList<PollsData>> aVar) {
        int i2;
        a<String, ArrayList<PollsData>> aVar2 = aVar;
        while (true) {
            Set<String> keySet = aVar2.keySet();
            if (!keySet.isEmpty()) {
                if (aVar2.size() > 999) {
                    a<String, ArrayList<PollsData>> aVar3 = new a<>(999);
                    int size = aVar2.size();
                    a<String, ArrayList<PollsData>> aVar4 = aVar3;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar4.put(aVar2.b(i3), aVar2.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                h(aVar4);
                                aVar4 = new a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar2 = aVar4;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = e.a();
                    a2.append("SELECT `id`,`pollsId`,`title`,`totalCount`,`options`,`createdAt`,`isVoted` FROM `PollsData` WHERE `pollsId` IN (");
                    int size2 = keySet.size();
                    e.a(a2, size2);
                    a2.append(")");
                    m a3 = m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.f4477f[i4] = 1;
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor query = this.f34655a.query(a3);
                    try {
                        int columnIndex = query.getColumnIndex("pollsId");
                        if (columnIndex != -1) {
                            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
                            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("pollsId");
                            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("title");
                            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("totalCount");
                            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("options");
                            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("createdAt");
                            int columnIndexOrThrow7 = query.getColumnIndexOrThrow("isVoted");
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndex)) {
                                    ArrayList arrayList = aVar2.get(query.getString(columnIndex));
                                    if (arrayList != null) {
                                        arrayList.add(new PollsData(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), this.f34656b.toOptionsList(query.getString(columnIndexOrThrow5)), query.getString(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7) != 0));
                                    }
                                }
                            }
                            query.close();
                            return;
                        }
                        return;
                    } finally {
                        query.close();
                    }
                }
            } else {
                return;
            }
        }
    }
}
