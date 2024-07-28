package net.one97.paytm.feed.repository.db;

import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.appsflyer.share.Constants;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sendbird.android.constant.StringSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.one97.paytm.feed.repository.db.a.a;

public final class FeedDatabase_Impl extends FeedDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile a f34612b;

    public final c createOpenHelper(androidx.room.a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `FeedData` (`id` TEXT NOT NULL, `uiId` INTEGER, `rank` INTEGER NOT NULL, `poweredBy` TEXT, `createdAt` TEXT, `imageUrl` TEXT, `width` TEXT, `height` TEXT, `title` TEXT, `webUrl` TEXT, `likeCount` INTEGER, `commentCount` INTEGER, `shareCount` INTEGER, `isLiked` INTEGER, `description` TEXT, `displayTime` TEXT, `url` TEXT, `streamUrl` TEXT, `duration` INTEGER, `viewCount` INTEGER, `canLike` INTEGER NOT NULL, `canComment` INTEGER, `canShare` INTEGER, `isSensitive` INTEGER, `isFlaggedByUser` INTEGER, `deepLinkUrl` TEXT, `category` INTEGER NOT NULL, `following` INTEGER NOT NULL, `viewAllUrl` TEXT, `buckets` TEXT, `feedItemType` TEXT NOT NULL, `logoUrl` TEXT, `shareUrl` TEXT, `name` TEXT, `feedItemRank` INTEGER NOT NULL, `feedItemCategoryRank` INTEGER NOT NULL, `profileRank` INTEGER NOT NULL, `followingRank` INTEGER NOT NULL, `mute` INTEGER NOT NULL, `mlVersion` TEXT NOT NULL, `contentFormat` TEXT NOT NULL, `mlCategory` TEXT NOT NULL, `score` REAL NOT NULL, `isBookmarked` INTEGER NOT NULL, `isFollowed` INTEGER NOT NULL, `canFollow` INTEGER NOT NULL, `likeCountDisplay` TEXT, `commentCountDisplay` TEXT, `shareCountDisplay` TEXT, `homeTeamAbbr` TEXT, `awayTeamAbbr` TEXT, `homeTeamLogo` TEXT, `awayTeamLogo` TEXT, `homeTeamId` TEXT, `awayTeamId` TEXT, `dataUrl` TEXT, `clickUrl` TEXT, `matchId` TEXT, `startTime` TEXT, `ctaImageUrl` TEXT, `ctaDisplayText` TEXT, `creatorId` INTEGER, `createdByName` TEXT, `createdByImageUrl` TEXT, `createdByCanFollow` INTEGER, `ItemScore` REAL, `ItemBucket` TEXT, `ItemContentFormat` TEXT, `ItemMlVersion` TEXT, `ItemMlCategory` TEXT, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `Channel` (`id` TEXT NOT NULL, `channelId` TEXT NOT NULL, `channelName` TEXT NOT NULL, `channelThumbnailUrl` TEXT NOT NULL, `channelGenre` TEXT NOT NULL, `language` TEXT NOT NULL, `source` TEXT NOT NULL, `programName` TEXT, `programDescription` TEXT, `programUrl` TEXT NOT NULL, `programImageUrl` TEXT NOT NULL, `programStartTime` TEXT, `programEndTime` TEXT, `fid` TEXT NOT NULL, `height` TEXT, `width` TEXT, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `Brand` (`deepLink` TEXT NOT NULL, `contractId` TEXT NOT NULL, `logoUrl` TEXT NOT NULL, `name` TEXT NOT NULL, `pid` TEXT NOT NULL, PRIMARY KEY(`contractId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `Banner` (`id` TEXT NOT NULL, `bid` TEXT, `deepLink` TEXT, `imageUrl` TEXT NOT NULL, `webUrl` TEXT, `height` TEXT NOT NULL, `width` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `Trending` (`id` TEXT NOT NULL, `tid` TEXT, `title` TEXT NOT NULL, `description` TEXT, `deepLink` TEXT, `imageUrl` TEXT NOT NULL, `webUrl` TEXT, `streamUrl` TEXT, `height` TEXT NOT NULL, `width` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `RecommendedApps` (`id` TEXT NOT NULL, `rid` TEXT, `bgColor` TEXT, `description` TEXT, `downloads` TEXT, `imageUrl` TEXT NOT NULL, `rating` TEXT, `title` TEXT NOT NULL, `packageName` TEXT, `category` TEXT, `appSize` TEXT, `type` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `FeedOfFeed` (`id` TEXT NOT NULL, `uiId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `groupId` TEXT, `rank` INTEGER NOT NULL, `poweredBy` TEXT, `createdAt` TEXT, `imageUrl` TEXT, `width` TEXT, `height` TEXT, `title` TEXT, `webUrl` TEXT, `likeCount` INTEGER, `commentCount` INTEGER, `shareCount` INTEGER, `isLiked` INTEGER, `description` TEXT, `displayTime` TEXT, `streamUrl` TEXT, `duration` INTEGER, `viewCount` INTEGER, `canLike` INTEGER NOT NULL, `canComment` INTEGER, `canShare` INTEGER, `isSensitive` INTEGER, `isFlaggedByUser` INTEGER, `deepLink` TEXT, `category` INTEGER NOT NULL, `following` INTEGER NOT NULL, `mute` INTEGER NOT NULL, `isBookmarked` INTEGER NOT NULL, `isFollowed` INTEGER NOT NULL, `canFollow` INTEGER NOT NULL, `likeCountDisplay` TEXT, `commentCountDisplay` TEXT, `shareCountDisplay` TEXT, `buckets` TEXT, `feedItemType` TEXT, `feedItemRank` INTEGER NOT NULL, `feedItemCategoryRank` INTEGER NOT NULL, `profileRank` INTEGER NOT NULL, `mlVersion` TEXT, `contentFormat` TEXT, `mlCategory` TEXT, `score` REAL, `followingRank` INTEGER NOT NULL, `ctaImageUrl` TEXT, `ctaDisplayText` TEXT, `creatorId` INTEGER, `createdByName` TEXT, `createdByImageUrl` TEXT, `createdByCanFollow` INTEGER, `ItemScore` REAL, `ItemBucket` TEXT, `ItemContentFormat` TEXT, `ItemMlVersion` TEXT, `ItemMlCategory` TEXT)");
                bVar.c("CREATE UNIQUE INDEX `index_FeedOfFeed_id_uiId` ON `FeedOfFeed` (`id`, `uiId`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `Stories` (`storyId` TEXT NOT NULL, `sid` TEXT NOT NULL, `completelySeen` INTEGER NOT NULL, `storyUpdatedAt` TEXT NOT NULL, `storyposition` INTEGER NOT NULL, `postIds` TEXT NOT NULL, `userCanFollow` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `userImageUrl` TEXT NOT NULL, `userName` TEXT NOT NULL, `id` TEXT NOT NULL, `uiId` INTEGER NOT NULL, `groupId` TEXT, `rank` INTEGER NOT NULL, `poweredBy` TEXT, `createdAt` TEXT, `imageUrl` TEXT, `width` TEXT, `height` TEXT, `title` TEXT, `webUrl` TEXT, `likeCount` INTEGER, `commentCount` INTEGER, `shareCount` INTEGER, `isLiked` INTEGER, `description` TEXT, `displayTime` TEXT, `streamUrl` TEXT, `duration` INTEGER, `viewCount` INTEGER, `canLike` INTEGER NOT NULL, `canComment` INTEGER, `canShare` INTEGER, `isSensitive` INTEGER, `isFlaggedByUser` INTEGER, `deepLink` TEXT, `category` INTEGER NOT NULL, `following` INTEGER NOT NULL, `mute` INTEGER NOT NULL, `isBookmarked` INTEGER NOT NULL, `isFollowed` INTEGER NOT NULL, `canFollow` INTEGER NOT NULL, `likeCountDisplay` TEXT, `commentCountDisplay` TEXT, `shareCountDisplay` TEXT, `buckets` TEXT, `feedItemType` TEXT, `feedItemRank` INTEGER NOT NULL, `feedItemCategoryRank` INTEGER NOT NULL, `profileRank` INTEGER NOT NULL, `mlVersion` TEXT, `contentFormat` TEXT, `mlCategory` TEXT, `score` REAL, `followingRank` INTEGER NOT NULL, `ctaImageUrl` TEXT, `ctaDisplayText` TEXT, `creatorId` INTEGER, `createdByName` TEXT, `createdByImageUrl` TEXT, `createdByCanFollow` INTEGER, `ItemScore` REAL, `ItemBucket` TEXT, `ItemContentFormat` TEXT, `ItemMlVersion` TEXT, `ItemMlCategory` TEXT, PRIMARY KEY(`storyId`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `PollsData` (`id` TEXT NOT NULL, `pollsId` TEXT NOT NULL, `title` TEXT NOT NULL, `totalCount` INTEGER NOT NULL, `options` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `isVoted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f70c0bb23fdc1ce0bb6c546cd7bb4ac7\")");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `FeedData`");
                bVar.c("DROP TABLE IF EXISTS `Channel`");
                bVar.c("DROP TABLE IF EXISTS `Brand`");
                bVar.c("DROP TABLE IF EXISTS `Banner`");
                bVar.c("DROP TABLE IF EXISTS `Trending`");
                bVar.c("DROP TABLE IF EXISTS `RecommendedApps`");
                bVar.c("DROP TABLE IF EXISTS `FeedOfFeed`");
                bVar.c("DROP TABLE IF EXISTS `Stories`");
                bVar.c("DROP TABLE IF EXISTS `PollsData`");
            }

            public final void onCreate(b bVar) {
                if (FeedDatabase_Impl.this.mCallbacks != null) {
                    int size = FeedDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        FeedDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = FeedDatabase_Impl.this.mDatabase = bVar;
                FeedDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (FeedDatabase_Impl.this.mCallbacks != null) {
                    int size = FeedDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) FeedDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void validateMigration(b bVar) {
                b bVar2 = bVar;
                HashMap hashMap = new HashMap(70);
                hashMap.put("id", new f.a("id", "TEXT", true, 1));
                hashMap.put("uiId", new f.a("uiId", "INTEGER", false, 0));
                hashMap.put("rank", new f.a("rank", "INTEGER", true, 0));
                hashMap.put("poweredBy", new f.a("poweredBy", "TEXT", false, 0));
                hashMap.put("createdAt", new f.a("createdAt", "TEXT", false, 0));
                hashMap.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0));
                hashMap.put(StringSet.width, new f.a(StringSet.width, "TEXT", false, 0));
                hashMap.put(StringSet.height, new f.a(StringSet.height, "TEXT", false, 0));
                hashMap.put("title", new f.a("title", "TEXT", false, 0));
                hashMap.put("webUrl", new f.a("webUrl", "TEXT", false, 0));
                hashMap.put("likeCount", new f.a("likeCount", "INTEGER", false, 0));
                hashMap.put("commentCount", new f.a("commentCount", "INTEGER", false, 0));
                hashMap.put("shareCount", new f.a("shareCount", "INTEGER", false, 0));
                hashMap.put("isLiked", new f.a("isLiked", "INTEGER", false, 0));
                hashMap.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, new f.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "TEXT", false, 0));
                hashMap.put("displayTime", new f.a("displayTime", "TEXT", false, 0));
                hashMap.put("url", new f.a("url", "TEXT", false, 0));
                hashMap.put("streamUrl", new f.a("streamUrl", "TEXT", false, 0));
                hashMap.put(AppConstants.DURATION, new f.a(AppConstants.DURATION, "INTEGER", false, 0));
                hashMap.put("viewCount", new f.a("viewCount", "INTEGER", false, 0));
                String str = "createdAt";
                hashMap.put("canLike", new f.a("canLike", "INTEGER", true, 0));
                hashMap.put("canComment", new f.a("canComment", "INTEGER", false, 0));
                hashMap.put("canShare", new f.a("canShare", "INTEGER", false, 0));
                hashMap.put("isSensitive", new f.a("isSensitive", "INTEGER", false, 0));
                hashMap.put("isFlaggedByUser", new f.a("isFlaggedByUser", "INTEGER", false, 0));
                hashMap.put("deepLinkUrl", new f.a("deepLinkUrl", "TEXT", false, 0));
                hashMap.put("category", new f.a("category", "INTEGER", true, 0));
                hashMap.put("following", new f.a("following", "INTEGER", true, 0));
                hashMap.put("viewAllUrl", new f.a("viewAllUrl", "TEXT", false, 0));
                hashMap.put("buckets", new f.a("buckets", "TEXT", false, 0));
                hashMap.put("feedItemType", new f.a("feedItemType", "TEXT", true, 0));
                hashMap.put("logoUrl", new f.a("logoUrl", "TEXT", false, 0));
                hashMap.put("shareUrl", new f.a("shareUrl", "TEXT", false, 0));
                hashMap.put("name", new f.a("name", "TEXT", false, 0));
                hashMap.put("feedItemRank", new f.a("feedItemRank", "INTEGER", true, 0));
                hashMap.put("feedItemCategoryRank", new f.a("feedItemCategoryRank", "INTEGER", true, 0));
                hashMap.put("profileRank", new f.a("profileRank", "INTEGER", true, 0));
                hashMap.put("followingRank", new f.a("followingRank", "INTEGER", true, 0));
                hashMap.put("mute", new f.a("mute", "INTEGER", true, 0));
                hashMap.put("mlVersion", new f.a("mlVersion", "TEXT", true, 0));
                hashMap.put("contentFormat", new f.a("contentFormat", "TEXT", true, 0));
                hashMap.put("mlCategory", new f.a("mlCategory", "TEXT", true, 0));
                String str2 = "streamUrl";
                hashMap.put("score", new f.a("score", "REAL", true, 0));
                hashMap.put("isBookmarked", new f.a("isBookmarked", "INTEGER", true, 0));
                hashMap.put("isFollowed", new f.a("isFollowed", "INTEGER", true, 0));
                hashMap.put("canFollow", new f.a("canFollow", "INTEGER", true, 0));
                hashMap.put("likeCountDisplay", new f.a("likeCountDisplay", "TEXT", false, 0));
                hashMap.put("commentCountDisplay", new f.a("commentCountDisplay", "TEXT", false, 0));
                hashMap.put("shareCountDisplay", new f.a("shareCountDisplay", "TEXT", false, 0));
                hashMap.put("homeTeamAbbr", new f.a("homeTeamAbbr", "TEXT", false, 0));
                hashMap.put("awayTeamAbbr", new f.a("awayTeamAbbr", "TEXT", false, 0));
                hashMap.put("homeTeamLogo", new f.a("homeTeamLogo", "TEXT", false, 0));
                hashMap.put("awayTeamLogo", new f.a("awayTeamLogo", "TEXT", false, 0));
                hashMap.put("homeTeamId", new f.a("homeTeamId", "TEXT", false, 0));
                hashMap.put("awayTeamId", new f.a("awayTeamId", "TEXT", false, 0));
                hashMap.put("dataUrl", new f.a("dataUrl", "TEXT", false, 0));
                hashMap.put("clickUrl", new f.a("clickUrl", "TEXT", false, 0));
                hashMap.put("matchId", new f.a("matchId", "TEXT", false, 0));
                hashMap.put("startTime", new f.a("startTime", "TEXT", false, 0));
                hashMap.put("ctaImageUrl", new f.a("ctaImageUrl", "TEXT", false, 0));
                hashMap.put("ctaDisplayText", new f.a("ctaDisplayText", "TEXT", false, 0));
                hashMap.put("creatorId", new f.a("creatorId", "INTEGER", false, 0));
                hashMap.put("createdByName", new f.a("createdByName", "TEXT", false, 0));
                hashMap.put("createdByImageUrl", new f.a("createdByImageUrl", "TEXT", false, 0));
                hashMap.put("createdByCanFollow", new f.a("createdByCanFollow", "INTEGER", false, 0));
                hashMap.put("ItemScore", new f.a("ItemScore", "REAL", false, 0));
                hashMap.put("ItemBucket", new f.a("ItemBucket", "TEXT", false, 0));
                hashMap.put("ItemContentFormat", new f.a("ItemContentFormat", "TEXT", false, 0));
                hashMap.put("ItemMlVersion", new f.a("ItemMlVersion", "TEXT", false, 0));
                hashMap.put("ItemMlCategory", new f.a("ItemMlCategory", "TEXT", false, 0));
                f fVar = new f("FeedData", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar2, "FeedData");
                if (fVar.equals(a2)) {
                    HashMap hashMap2 = new HashMap(16);
                    hashMap2.put("id", new f.a("id", "TEXT", true, 1));
                    hashMap2.put("channelId", new f.a("channelId", "TEXT", true, 0));
                    hashMap2.put("channelName", new f.a("channelName", "TEXT", true, 0));
                    hashMap2.put("channelThumbnailUrl", new f.a("channelThumbnailUrl", "TEXT", true, 0));
                    hashMap2.put("channelGenre", new f.a("channelGenre", "TEXT", true, 0));
                    hashMap2.put("language", new f.a("language", "TEXT", true, 0));
                    hashMap2.put("source", new f.a("source", "TEXT", true, 0));
                    hashMap2.put("programName", new f.a("programName", "TEXT", false, 0));
                    hashMap2.put("programDescription", new f.a("programDescription", "TEXT", false, 0));
                    hashMap2.put("programUrl", new f.a("programUrl", "TEXT", true, 0));
                    hashMap2.put("programImageUrl", new f.a("programImageUrl", "TEXT", true, 0));
                    hashMap2.put("programStartTime", new f.a("programStartTime", "TEXT", false, 0));
                    hashMap2.put("programEndTime", new f.a("programEndTime", "TEXT", false, 0));
                    hashMap2.put("fid", new f.a("fid", "TEXT", true, 0));
                    hashMap2.put(StringSet.height, new f.a(StringSet.height, "TEXT", false, 0));
                    hashMap2.put(StringSet.width, new f.a(StringSet.width, "TEXT", false, 0));
                    f fVar2 = new f("Channel", hashMap2, new HashSet(0), new HashSet(0));
                    f a3 = f.a(bVar2, "Channel");
                    if (fVar2.equals(a3)) {
                        HashMap hashMap3 = new HashMap(5);
                        hashMap3.put("deepLink", new f.a("deepLink", "TEXT", true, 0));
                        hashMap3.put("contractId", new f.a("contractId", "TEXT", true, 1));
                        String str3 = "\n Found:\n";
                        hashMap3.put("logoUrl", new f.a("logoUrl", "TEXT", true, 0));
                        hashMap3.put("name", new f.a("name", "TEXT", true, 0));
                        hashMap3.put(Constants.URL_MEDIA_SOURCE, new f.a(Constants.URL_MEDIA_SOURCE, "TEXT", true, 0));
                        f fVar3 = new f("Brand", hashMap3, new HashSet(0), new HashSet(0));
                        f a4 = f.a(bVar2, "Brand");
                        if (fVar3.equals(a4)) {
                            HashMap hashMap4 = new HashMap(7);
                            hashMap4.put("id", new f.a("id", "TEXT", true, 1));
                            hashMap4.put("bid", new f.a("bid", "TEXT", false, 0));
                            hashMap4.put("deepLink", new f.a("deepLink", "TEXT", false, 0));
                            hashMap4.put("imageUrl", new f.a("imageUrl", "TEXT", true, 0));
                            hashMap4.put("webUrl", new f.a("webUrl", "TEXT", false, 0));
                            hashMap4.put(StringSet.height, new f.a(StringSet.height, "TEXT", true, 0));
                            hashMap4.put(StringSet.width, new f.a(StringSet.width, "TEXT", true, 0));
                            f fVar4 = new f("Banner", hashMap4, new HashSet(0), new HashSet(0));
                            f a5 = f.a(bVar2, "Banner");
                            if (fVar4.equals(a5)) {
                                HashMap hashMap5 = new HashMap(10);
                                hashMap5.put("id", new f.a("id", "TEXT", true, 1));
                                hashMap5.put("tid", new f.a("tid", "TEXT", false, 0));
                                hashMap5.put("title", new f.a("title", "TEXT", true, 0));
                                hashMap5.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, new f.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "TEXT", false, 0));
                                hashMap5.put("deepLink", new f.a("deepLink", "TEXT", false, 0));
                                hashMap5.put("imageUrl", new f.a("imageUrl", "TEXT", true, 0));
                                hashMap5.put("webUrl", new f.a("webUrl", "TEXT", false, 0));
                                String str4 = str2;
                                hashMap5.put(str4, new f.a(str4, "TEXT", false, 0));
                                hashMap5.put(StringSet.height, new f.a(StringSet.height, "TEXT", true, 0));
                                hashMap5.put(StringSet.width, new f.a(StringSet.width, "TEXT", true, 0));
                                String str5 = "deepLink";
                                f fVar5 = new f("Trending", hashMap5, new HashSet(0), new HashSet(0));
                                f a6 = f.a(bVar2, "Trending");
                                if (fVar5.equals(a6)) {
                                    HashMap hashMap6 = new HashMap(13);
                                    hashMap6.put("id", new f.a("id", "TEXT", true, 1));
                                    hashMap6.put("rid", new f.a("rid", "TEXT", false, 0));
                                    hashMap6.put("bgColor", new f.a("bgColor", "TEXT", false, 0));
                                    hashMap6.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, new f.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "TEXT", false, 0));
                                    hashMap6.put("downloads", new f.a("downloads", "TEXT", false, 0));
                                    hashMap6.put("imageUrl", new f.a("imageUrl", "TEXT", true, 0));
                                    hashMap6.put("rating", new f.a("rating", "TEXT", false, 0));
                                    hashMap6.put("title", new f.a("title", "TEXT", true, 0));
                                    hashMap6.put("packageName", new f.a("packageName", "TEXT", false, 0));
                                    hashMap6.put("category", new f.a("category", "TEXT", false, 0));
                                    hashMap6.put("appSize", new f.a("appSize", "TEXT", false, 0));
                                    hashMap6.put("type", new f.a("type", "TEXT", true, 0));
                                    hashMap6.put("url", new f.a("url", "TEXT", true, 0));
                                    f fVar6 = new f("RecommendedApps", hashMap6, new HashSet(0), new HashSet(0));
                                    f a7 = f.a(bVar2, "RecommendedApps");
                                    if (fVar6.equals(a7)) {
                                        HashMap hashMap7 = new HashMap(56);
                                        hashMap7.put("id", new f.a("id", "TEXT", true, 0));
                                        hashMap7.put("uiId", new f.a("uiId", "INTEGER", true, 1));
                                        hashMap7.put("groupId", new f.a("groupId", "TEXT", false, 0));
                                        hashMap7.put("rank", new f.a("rank", "INTEGER", true, 0));
                                        hashMap7.put("poweredBy", new f.a("poweredBy", "TEXT", false, 0));
                                        String str6 = str;
                                        hashMap7.put(str6, new f.a(str6, "TEXT", false, 0));
                                        hashMap7.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0));
                                        hashMap7.put(StringSet.width, new f.a(StringSet.width, "TEXT", false, 0));
                                        hashMap7.put(StringSet.height, new f.a(StringSet.height, "TEXT", false, 0));
                                        hashMap7.put("title", new f.a("title", "TEXT", false, 0));
                                        hashMap7.put("webUrl", new f.a("webUrl", "TEXT", false, 0));
                                        hashMap7.put("likeCount", new f.a("likeCount", "INTEGER", false, 0));
                                        hashMap7.put("commentCount", new f.a("commentCount", "INTEGER", false, 0));
                                        hashMap7.put("shareCount", new f.a("shareCount", "INTEGER", false, 0));
                                        hashMap7.put("isLiked", new f.a("isLiked", "INTEGER", false, 0));
                                        hashMap7.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, new f.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "TEXT", false, 0));
                                        hashMap7.put("displayTime", new f.a("displayTime", "TEXT", false, 0));
                                        hashMap7.put(str4, new f.a(str4, "TEXT", false, 0));
                                        hashMap7.put(AppConstants.DURATION, new f.a(AppConstants.DURATION, "INTEGER", false, 0));
                                        hashMap7.put("viewCount", new f.a("viewCount", "INTEGER", false, 0));
                                        String str7 = str4;
                                        hashMap7.put("canLike", new f.a("canLike", "INTEGER", true, 0));
                                        hashMap7.put("canComment", new f.a("canComment", "INTEGER", false, 0));
                                        hashMap7.put("canShare", new f.a("canShare", "INTEGER", false, 0));
                                        hashMap7.put("isSensitive", new f.a("isSensitive", "INTEGER", false, 0));
                                        hashMap7.put("isFlaggedByUser", new f.a("isFlaggedByUser", "INTEGER", false, 0));
                                        String str8 = str5;
                                        hashMap7.put(str8, new f.a(str8, "TEXT", false, 0));
                                        hashMap7.put("category", new f.a("category", "INTEGER", true, 0));
                                        hashMap7.put("following", new f.a("following", "INTEGER", true, 0));
                                        hashMap7.put("mute", new f.a("mute", "INTEGER", true, 0));
                                        hashMap7.put("isBookmarked", new f.a("isBookmarked", "INTEGER", true, 0));
                                        hashMap7.put("isFollowed", new f.a("isFollowed", "INTEGER", true, 0));
                                        hashMap7.put("canFollow", new f.a("canFollow", "INTEGER", true, 0));
                                        hashMap7.put("likeCountDisplay", new f.a("likeCountDisplay", "TEXT", false, 0));
                                        hashMap7.put("commentCountDisplay", new f.a("commentCountDisplay", "TEXT", false, 0));
                                        hashMap7.put("shareCountDisplay", new f.a("shareCountDisplay", "TEXT", false, 0));
                                        hashMap7.put("buckets", new f.a("buckets", "TEXT", false, 0));
                                        hashMap7.put("feedItemType", new f.a("feedItemType", "TEXT", false, 0));
                                        hashMap7.put("feedItemRank", new f.a("feedItemRank", "INTEGER", true, 0));
                                        hashMap7.put("feedItemCategoryRank", new f.a("feedItemCategoryRank", "INTEGER", true, 0));
                                        hashMap7.put("profileRank", new f.a("profileRank", "INTEGER", true, 0));
                                        hashMap7.put("mlVersion", new f.a("mlVersion", "TEXT", false, 0));
                                        hashMap7.put("contentFormat", new f.a("contentFormat", "TEXT", false, 0));
                                        hashMap7.put("mlCategory", new f.a("mlCategory", "TEXT", false, 0));
                                        hashMap7.put("score", new f.a("score", "REAL", false, 0));
                                        hashMap7.put("followingRank", new f.a("followingRank", "INTEGER", true, 0));
                                        hashMap7.put("ctaImageUrl", new f.a("ctaImageUrl", "TEXT", false, 0));
                                        hashMap7.put("ctaDisplayText", new f.a("ctaDisplayText", "TEXT", false, 0));
                                        hashMap7.put("creatorId", new f.a("creatorId", "INTEGER", false, 0));
                                        hashMap7.put("createdByName", new f.a("createdByName", "TEXT", false, 0));
                                        hashMap7.put("createdByImageUrl", new f.a("createdByImageUrl", "TEXT", false, 0));
                                        hashMap7.put("createdByCanFollow", new f.a("createdByCanFollow", "INTEGER", false, 0));
                                        hashMap7.put("ItemScore", new f.a("ItemScore", "REAL", false, 0));
                                        hashMap7.put("ItemBucket", new f.a("ItemBucket", "TEXT", false, 0));
                                        hashMap7.put("ItemContentFormat", new f.a("ItemContentFormat", "TEXT", false, 0));
                                        hashMap7.put("ItemMlVersion", new f.a("ItemMlVersion", "TEXT", false, 0));
                                        hashMap7.put("ItemMlCategory", new f.a("ItemMlCategory", "TEXT", false, 0));
                                        HashSet hashSet = new HashSet(0);
                                        HashSet hashSet2 = new HashSet(1);
                                        List asList = Arrays.asList(new String[]{"id", "uiId"});
                                        String str9 = RequestConfirmationDialogFragment.KEY_DESCRIPTION;
                                        String str10 = "webUrl";
                                        hashSet2.add(new f.d("index_FeedOfFeed_id_uiId", true, asList));
                                        f fVar7 = new f("FeedOfFeed", hashMap7, hashSet, hashSet2);
                                        f a8 = f.a(bVar2, "FeedOfFeed");
                                        if (fVar7.equals(a8)) {
                                            HashMap hashMap8 = new HashMap(66);
                                            hashMap8.put("storyId", new f.a("storyId", "TEXT", true, 1));
                                            hashMap8.put("sid", new f.a("sid", "TEXT", true, 0));
                                            hashMap8.put("completelySeen", new f.a("completelySeen", "INTEGER", true, 0));
                                            hashMap8.put("storyUpdatedAt", new f.a("storyUpdatedAt", "TEXT", true, 0));
                                            hashMap8.put("storyposition", new f.a("storyposition", "INTEGER", true, 0));
                                            hashMap8.put("postIds", new f.a("postIds", "TEXT", true, 0));
                                            hashMap8.put("userCanFollow", new f.a("userCanFollow", "INTEGER", true, 0));
                                            hashMap8.put("userId", new f.a("userId", "INTEGER", true, 0));
                                            hashMap8.put("userImageUrl", new f.a("userImageUrl", "TEXT", true, 0));
                                            hashMap8.put("userName", new f.a("userName", "TEXT", true, 0));
                                            hashMap8.put("id", new f.a("id", "TEXT", true, 0));
                                            hashMap8.put("uiId", new f.a("uiId", "INTEGER", true, 0));
                                            hashMap8.put("groupId", new f.a("groupId", "TEXT", false, 0));
                                            hashMap8.put("rank", new f.a("rank", "INTEGER", true, 0));
                                            hashMap8.put("poweredBy", new f.a("poweredBy", "TEXT", false, 0));
                                            hashMap8.put(str6, new f.a(str6, "TEXT", false, 0));
                                            hashMap8.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0));
                                            hashMap8.put(StringSet.width, new f.a(StringSet.width, "TEXT", false, 0));
                                            hashMap8.put(StringSet.height, new f.a(StringSet.height, "TEXT", false, 0));
                                            hashMap8.put("title", new f.a("title", "TEXT", false, 0));
                                            String str11 = str10;
                                            hashMap8.put(str11, new f.a(str11, "TEXT", false, 0));
                                            hashMap8.put("likeCount", new f.a("likeCount", "INTEGER", false, 0));
                                            hashMap8.put("commentCount", new f.a("commentCount", "INTEGER", false, 0));
                                            hashMap8.put("shareCount", new f.a("shareCount", "INTEGER", false, 0));
                                            hashMap8.put("isLiked", new f.a("isLiked", "INTEGER", false, 0));
                                            String str12 = str9;
                                            hashMap8.put(str12, new f.a(str12, "TEXT", false, 0));
                                            hashMap8.put("displayTime", new f.a("displayTime", "TEXT", false, 0));
                                            String str13 = str7;
                                            hashMap8.put(str13, new f.a(str13, "TEXT", false, 0));
                                            hashMap8.put(AppConstants.DURATION, new f.a(AppConstants.DURATION, "INTEGER", false, 0));
                                            hashMap8.put("viewCount", new f.a("viewCount", "INTEGER", false, 0));
                                            hashMap8.put("canLike", new f.a("canLike", "INTEGER", true, 0));
                                            hashMap8.put("canComment", new f.a("canComment", "INTEGER", false, 0));
                                            hashMap8.put("canShare", new f.a("canShare", "INTEGER", false, 0));
                                            hashMap8.put("isSensitive", new f.a("isSensitive", "INTEGER", false, 0));
                                            hashMap8.put("isFlaggedByUser", new f.a("isFlaggedByUser", "INTEGER", false, 0));
                                            String str14 = str5;
                                            hashMap8.put(str14, new f.a(str14, "TEXT", false, 0));
                                            hashMap8.put("category", new f.a("category", "INTEGER", true, 0));
                                            hashMap8.put("following", new f.a("following", "INTEGER", true, 0));
                                            hashMap8.put("mute", new f.a("mute", "INTEGER", true, 0));
                                            hashMap8.put("isBookmarked", new f.a("isBookmarked", "INTEGER", true, 0));
                                            hashMap8.put("isFollowed", new f.a("isFollowed", "INTEGER", true, 0));
                                            hashMap8.put("canFollow", new f.a("canFollow", "INTEGER", true, 0));
                                            hashMap8.put("likeCountDisplay", new f.a("likeCountDisplay", "TEXT", false, 0));
                                            hashMap8.put("commentCountDisplay", new f.a("commentCountDisplay", "TEXT", false, 0));
                                            hashMap8.put("shareCountDisplay", new f.a("shareCountDisplay", "TEXT", false, 0));
                                            hashMap8.put("buckets", new f.a("buckets", "TEXT", false, 0));
                                            hashMap8.put("feedItemType", new f.a("feedItemType", "TEXT", false, 0));
                                            hashMap8.put("feedItemRank", new f.a("feedItemRank", "INTEGER", true, 0));
                                            hashMap8.put("feedItemCategoryRank", new f.a("feedItemCategoryRank", "INTEGER", true, 0));
                                            hashMap8.put("profileRank", new f.a("profileRank", "INTEGER", true, 0));
                                            hashMap8.put("mlVersion", new f.a("mlVersion", "TEXT", false, 0));
                                            hashMap8.put("contentFormat", new f.a("contentFormat", "TEXT", false, 0));
                                            hashMap8.put("mlCategory", new f.a("mlCategory", "TEXT", false, 0));
                                            hashMap8.put("score", new f.a("score", "REAL", false, 0));
                                            hashMap8.put("followingRank", new f.a("followingRank", "INTEGER", true, 0));
                                            hashMap8.put("ctaImageUrl", new f.a("ctaImageUrl", "TEXT", false, 0));
                                            hashMap8.put("ctaDisplayText", new f.a("ctaDisplayText", "TEXT", false, 0));
                                            hashMap8.put("creatorId", new f.a("creatorId", "INTEGER", false, 0));
                                            hashMap8.put("createdByName", new f.a("createdByName", "TEXT", false, 0));
                                            hashMap8.put("createdByImageUrl", new f.a("createdByImageUrl", "TEXT", false, 0));
                                            hashMap8.put("createdByCanFollow", new f.a("createdByCanFollow", "INTEGER", false, 0));
                                            hashMap8.put("ItemScore", new f.a("ItemScore", "REAL", false, 0));
                                            hashMap8.put("ItemBucket", new f.a("ItemBucket", "TEXT", false, 0));
                                            hashMap8.put("ItemContentFormat", new f.a("ItemContentFormat", "TEXT", false, 0));
                                            hashMap8.put("ItemMlVersion", new f.a("ItemMlVersion", "TEXT", false, 0));
                                            hashMap8.put("ItemMlCategory", new f.a("ItemMlCategory", "TEXT", false, 0));
                                            f fVar8 = new f("Stories", hashMap8, new HashSet(0), new HashSet(0));
                                            f a9 = f.a(bVar2, "Stories");
                                            if (fVar8.equals(a9)) {
                                                HashMap hashMap9 = new HashMap(7);
                                                hashMap9.put("id", new f.a("id", "TEXT", true, 1));
                                                hashMap9.put("pollsId", new f.a("pollsId", "TEXT", true, 0));
                                                hashMap9.put("title", new f.a("title", "TEXT", true, 0));
                                                hashMap9.put("totalCount", new f.a("totalCount", "INTEGER", true, 0));
                                                hashMap9.put("options", new f.a("options", "TEXT", true, 0));
                                                hashMap9.put(str6, new f.a(str6, "TEXT", true, 0));
                                                hashMap9.put("isVoted", new f.a("isVoted", "INTEGER", true, 0));
                                                f fVar9 = new f("PollsData", hashMap9, new HashSet(0), new HashSet(0));
                                                f a10 = f.a(bVar2, "PollsData");
                                                if (!fVar9.equals(a10)) {
                                                    throw new IllegalStateException("Migration didn't properly handle PollsData(net.one97.paytm.feed.repository.models.polls.PollsData).\n Expected:\n" + fVar9 + str3 + a10);
                                                }
                                                return;
                                            }
                                            throw new IllegalStateException("Migration didn't properly handle Stories(net.one97.paytm.feed.repository.models.stories.Stories).\n Expected:\n" + fVar8 + str3 + a9);
                                        }
                                        throw new IllegalStateException("Migration didn't properly handle FeedOfFeed(net.one97.paytm.feed.repository.models.FeedOfFeed).\n Expected:\n" + fVar7 + str3 + a8);
                                    }
                                    throw new IllegalStateException("Migration didn't properly handle RecommendedApps(net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps).\n Expected:\n" + fVar6 + str3 + a7);
                                }
                                throw new IllegalStateException("Migration didn't properly handle Trending(net.one97.paytm.feed.repository.models.trending.Trending).\n Expected:\n" + fVar5 + str3 + a6);
                            }
                            throw new IllegalStateException("Migration didn't properly handle Banner(net.one97.paytm.feed.repository.models.promobanner.Banner).\n Expected:\n" + fVar4 + str3 + a5);
                        }
                        throw new IllegalStateException("Migration didn't properly handle Brand(net.one97.paytm.feed.repository.models.merchantstorefront.Brand).\n Expected:\n" + fVar3 + str3 + a4);
                    }
                    throw new IllegalStateException("Migration didn't properly handle Channel(net.one97.paytm.feed.repository.models.livetv.Channel).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                throw new IllegalStateException("Migration didn't properly handle FeedData(net.one97.paytm.feed.repository.models.FeedData).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "f70c0bb23fdc1ce0bb6c546cd7bb4ac7", "f6388ad0f91ea49beea2adf185490acd");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, "FeedData", "Channel", "Brand", "Banner", "Trending", "RecommendedApps", "FeedOfFeed", "Stories", "PollsData");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `FeedData`");
            b2.c("DELETE FROM `Channel`");
            b2.c("DELETE FROM `Brand`");
            b2.c("DELETE FROM `Banner`");
            b2.c("DELETE FROM `Trending`");
            b2.c("DELETE FROM `RecommendedApps`");
            b2.c("DELETE FROM `FeedOfFeed`");
            b2.c("DELETE FROM `Stories`");
            b2.c("DELETE FROM `PollsData`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final a a() {
        a aVar;
        if (this.f34612b != null) {
            return this.f34612b;
        }
        synchronized (this) {
            if (this.f34612b == null) {
                this.f34612b = new net.one97.paytm.feed.repository.db.a.b(this);
            }
            aVar = this.f34612b;
        }
        return aVar;
    }
}
