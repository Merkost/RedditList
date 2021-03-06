package com.merkost.redditlist.model.entity

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class CrosspostParentList (
    @SerializedName("approved_at_utc")
    val approvedAtUTC: Any? = null,

    val subreddit: String,
    val selftext: String,

    @SerializedName("author_fullname")
    val authorFullname: String,

    val saved: Boolean,

    @SerializedName("mod_reason_title")
    val modReasonTitle: Any? = null,

    val gilded: Long,
    val clicked: Boolean,
    val title: String,

    @SerializedName("link_flair_richtext")
    val linkFlairRichtext: List<Any?>,

    @SerializedName("subreddit_name_prefixed")
    val subredditNamePrefixed: String,

    val hidden: Boolean,
    val pwls: Long,

    @SerializedName("link_flair_css_class")
    val linkFlairCSSClass: String,

    val downs: Long,

    @SerializedName("thumbnail_height")
    val thumbnailHeight: Long,

    @SerializedName("top_awarded_type")
    val topAwardedType: Any? = null,

    @SerializedName("hide_score")
    val hideScore: Boolean,

    val name: String,
    val quarantine: Boolean,

    @SerializedName("link_flair_text_color")
    val linkFlairTextColor: LinkFlairTextColor,

    @SerializedName("upvote_ratio")
    val upvoteRatio: Double,

    @SerializedName("author_flair_background_color")
    val authorFlairBackgroundColor: Any? = null,

    @SerializedName("subreddit_type")
    val subredditType: SubredditType,

    val ups: Long,

    @SerializedName("total_awards_received")
    val totalAwardsReceived: Long,

    @SerializedName("media_embed")
    val mediaEmbed: MediaEmbed,

    @SerializedName("thumbnail_width")
    val thumbnailWidth: Long,

    @SerializedName("author_flair_template_id")
    val authorFlairTemplateID: Any? = null,

    @SerializedName("is_original_content")
    val isOriginalContent: Boolean,

    @SerializedName("user_reports")
    val userReports: List<Any?>,

    @SerializedName("secure_media")
    val secureMedia: CrosspostParentListMedia,

    @SerializedName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean,

    @SerializedName("is_meta")
    val isMeta: Boolean,

    val category: Any? = null,

    @SerializedName("secure_media_embed")
    val secureMediaEmbed: MediaEmbed,

    @SerializedName("link_flair_text")
    val linkFlairText: String,

    @SerializedName("can_mod_post")
    val canModPost: Boolean,

    val score: Long,

    @SerializedName("approved_by")
    val approvedBy: Any? = null,

    @SerializedName("is_created_from_ads_ui")
    val isCreatedFromAdsUI: Boolean,

    @SerializedName("author_premium")
    val authorPremium: Boolean,

    val thumbnail: String,
    val edited: Boolean,

    @SerializedName("author_flair_css_class")
    val authorFlairCSSClass: Any? = null,

    @SerializedName("author_flair_richtext")
    val authorFlairRichtext: List<Any?>,

    val gildings: VariantsClass,

    @SerializedName("post_hint")
    val postHint: PostHint,

    @SerializedName("content_categories")
    val contentCategories: Any? = null,

    @SerializedName("is_self")
    val isSelf: Boolean,

    @SerializedName("mod_note")
    val modNote: Any? = null,

    val created: Double,

    @SerializedName("link_flair_type")
    val linkFlairType: FlairType,

    val wls: Long,

    @SerializedName("removed_by_category")
    val removedByCategory: Any? = null,

    @SerializedName("banned_by")
    val bannedBy: Any? = null,

    @SerializedName("author_flair_type")
    val authorFlairType: FlairType,

    val domain: Domain,

    @SerializedName("allow_live_comments")
    val allowLiveComments: Boolean,

    @SerializedName("selftext_html")
    val selftextHTML: Any? = null,

    val likes: Any? = null,

    @SerializedName("suggested_sort")
    val suggestedSort: Any? = null,

    @SerializedName("banned_at_utc")
    val bannedAtUTC: Any? = null,

    @SerializedName("url_overridden_by_dest")
    val urlOverriddenByDest: String,

    @SerializedName("view_count")
    val viewCount: Any? = null,

    val archived: Boolean,

    @SerializedName("no_follow")
    val noFollow: Boolean,

    @SerializedName("is_crosspostable")
    val isCrosspostable: Boolean,

    val pinned: Boolean,

    @SerializedName("over_18")
    val over18: Boolean,

    val preview: CrosspostParentListPreview,

    @SerializedName("all_awardings")
    val allAwardings: List<AllAwarding>,

    val awarders: List<Any?>,

    @SerializedName("media_only")
    val mediaOnly: Boolean,

    @SerializedName("can_gild")
    val canGild: Boolean,

    val spoiler: Boolean,
    val locked: Boolean,

    @SerializedName("author_flair_text")
    val authorFlairText: Any? = null,

    @SerializedName("treatment_tags")
    val treatmentTags: List<Any?>,

    val visited: Boolean,

    @SerializedName("removed_by")
    val removedBy: Any? = null,

    @SerializedName("num_reports")
    val numReports: Any? = null,

    val distinguished: Any? = null,

    @SerializedName("subreddit_id")
    val subredditID: String,

    @SerializedName("author_is_blocked")
    val authorIsBlocked: Boolean,

    @SerializedName("mod_reason_by")
    val modReasonBy: Any? = null,

    @SerializedName("removal_reason")
    val removalReason: Any? = null,

    @SerializedName("link_flair_background_color")
    val linkFlairBackgroundColor: String,

    val id: String,

    @SerializedName("is_robot_indexable")
    val isRobotIndexable: Boolean,

    @SerializedName("report_reasons")
    val reportReasons: Any? = null,

    val author: String,

    @SerializedName("discussion_type")
    val discussionType: Any? = null,

    @SerializedName("num_comments")
    val numComments: Long,

    @SerializedName("send_replies")
    val sendReplies: Boolean,

    @SerializedName("whitelist_status")
    val whitelistStatus: String,

    @SerializedName("contest_mode")
    val contestMode: Boolean,

    @SerializedName("mod_reports")
    val modReports: List<Any?>,

    @SerializedName("author_patreon_flair")
    val authorPatreonFlair: Boolean,

    @SerializedName("author_flair_text_color")
    val authorFlairTextColor: Any? = null,

    val permalink: String,

    @SerializedName("parent_whitelist_status")
    val parentWhitelistStatus: String,

    val stickied: Boolean,
    val url: String,

    @SerializedName("subreddit_subscribers")
    val subredditSubscribers: Long,

    @SerializedName("created_utc")
    val createdUTC: Double,

    @SerializedName("num_crossposts")
    val numCrossposts: Long,

    val media: CrosspostParentListMedia,

    @SerializedName("is_video")
    val isVideo: Boolean
)

typealias VariantsClass = JsonObject