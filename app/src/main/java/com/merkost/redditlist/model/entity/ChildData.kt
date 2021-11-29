package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class ChildData (
    @SerializedName("approved_at_utc")
    val approvedAtUTC: Any? = null,

    val subreddit: String = "",
    val selftext: String = "",

    @SerializedName("author_fullname")
    val authorFullname: String = "",

    val saved: Boolean = false,

    @SerializedName("mod_reason_title")
    val modReasonTitle: Any? = null,

    val gilded: Long = 0,
    val clicked: Boolean = false,
    val title: String = "",

    @SerializedName("link_flair_richtext")
    val linkFlairRichtext: List<Any?> = listOf(),

    @SerializedName("subreddit_name_prefixed")
    val subredditNamePrefixed: String = "",

    val hidden: Boolean = false,
    val pwls: Long = 0,

    @SerializedName("link_flair_css_class")
    val linkFlairCSSClass: String? = null,

    val downs: Long = 0,

    @SerializedName("thumbnail_height")
    val thumbnailHeight: Long? = null,

    @SerializedName("top_awarded_type")
    val topAwardedType: String? = null,

    @SerializedName("hide_score")
    val hideScore: Boolean = false,

    val name: String = "",
    val quarantine: Boolean = false,

    @SerializedName("link_flair_text_color")
    val linkFlairTextColor: LinkFlairTextColor? = null,

    @SerializedName("upvote_ratio")
    val upvoteRatio: Double = 0.0,

    @SerializedName("author_flair_background_color")
    val authorFlairBackgroundColor: String? = null,

    @SerializedName("subreddit_type")
    val subredditType: SubredditType? = null,

    val ups: Long = 0,

    @SerializedName("total_awards_received")
    val totalAwardsReceived: Long = 0,

    @SerializedName("media_embed")
    val mediaEmbed: MediaEmbed? = null,

    @SerializedName("thumbnail_width")
    val thumbnailWidth: Long? = null,

    @SerializedName("author_flair_template_id")
    val authorFlairTemplateID: Any? = null,

    @SerializedName("is_original_content")
    val isOriginalContent: Boolean = false,

    @SerializedName("user_reports")
    val userReports: List<Any?> = listOf(),

    @SerializedName("secure_media")
    val secureMedia: DataMedia? = null,

    @SerializedName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean = false,

    @SerializedName("is_meta")
    val isMeta: Boolean = false,

    val category: Any? = null,

    @SerializedName("secure_media_embed")
    val secureMediaEmbed: MediaEmbed? = null,

    @SerializedName("link_flair_text")
    val linkFlairText: Any? = null,

    @SerializedName("can_mod_post")
    val canModPost: Boolean = false,

    val score: Long = 0,

    @SerializedName("approved_by")
    val approvedBy: Any? = null,

    @SerializedName("is_created_from_ads_ui")
    val isCreatedFromAdsUI: Boolean = false,

    @SerializedName("author_premium")
    val authorPremium: Boolean = false,

    val thumbnail: String  = "",
    val edited: Boolean = false,

    @SerializedName("author_flair_css_class")
    val authorFlairCSSClass: String? = null,

    @SerializedName("author_flair_richtext")
    val authorFlairRichtext: List<Any?> = listOf(),

    val gildings: DataGildings? = null,

    @SerializedName("post_hint")
    val postHint: String? = null,

    @SerializedName("content_categories")
    val contentCategories: Any? = null,

    @SerializedName("is_self")
    val isSelf: Boolean = false,

    @SerializedName("mod_note")
    val modNote: Any? = null,

    val created: Double = 0.0,

    @SerializedName("link_flair_type")
    val linkFlairType: FlairType? = null,

    val wls: Long = 0,

    @SerializedName("removed_by_category")
    val removedByCategory: Any? = null,

    @SerializedName("banned_by")
    val bannedBy: Any? = null,

    @SerializedName("author_flair_type")
    val authorFlairType: FlairType? = null,

    val domain: Domain? = null,

    @SerializedName("allow_live_comments")
    val allowLiveComments: Boolean = false,

    @SerializedName("selftext_html")
    val selftextHTML: Any? = null,

    val likes: Any? = null,

    @SerializedName("suggested_sort")
    val suggestedSort: String? = null,

    @SerializedName("banned_at_utc")
    val bannedAtUTC: Any? = null,

    @SerializedName("url_overridden_by_dest")
    val urlOverriddenByDest: String  = "",

    @SerializedName("view_count")
    val viewCount: Any? = null,

    val archived: Boolean = false,

    @SerializedName("no_follow")
    val noFollow: Boolean = false,

    @SerializedName("is_crosspostable")
    val isCrosspostable: Boolean = false,

    val pinned: Boolean = false,

    @SerializedName("over_18")
    val over18: Boolean = false,

    val preview: DataPreview? = null,

    @SerializedName("all_awardings")
    val allAwardings: List<AllAwarding> = listOf(),

    val awarders: List<Any?> = listOf(),

    @SerializedName("media_only")
    val mediaOnly: Boolean = false,

    @SerializedName("can_gild")
    val canGild: Boolean = false,

    val spoiler: Boolean = false,
    val locked: Boolean = false,

    @SerializedName("author_flair_text")
    val authorFlairText: Any? = null,

    @SerializedName("treatment_tags")
    val treatmentTags: List<Any?>  = listOf(),

    val visited: Boolean = false,

    @SerializedName("removed_by")
    val removedBy: Any? = null,

    @SerializedName("num_reports")
    val numReports: Any? = null,

    val distinguished: Any? = null,

    @SerializedName("subreddit_id")
    val subredditID: String = "",

    @SerializedName("author_is_blocked")
    val authorIsBlocked: Boolean = false,

    @SerializedName("mod_reason_by")
    val modReasonBy: Any? = null,

    @SerializedName("removal_reason")
    val removalReason: Any? = null,

    @SerializedName("link_flair_background_color")
    val linkFlairBackgroundColor: String = "",

    val id: String = "",

    @SerializedName("is_robot_indexable")
    val isRobotIndexable: Boolean = false,

    @SerializedName("report_reasons")
    val reportReasons: Any? = null,

    val author: String = "",

    @SerializedName("discussion_type")
    val discussionType: Any? = null,

    @SerializedName("num_comments")
    val numComments: Long = 0,

    @SerializedName("send_replies")
    val sendReplies: Boolean = false,

    @SerializedName("whitelist_status")
    val whitelistStatus: String = "",

    @SerializedName("contest_mode")
    val contestMode: Boolean = false,

    @SerializedName("mod_reports")
    val modReports: List<Any?> = listOf(),

    @SerializedName("author_patreon_flair")
    val authorPatreonFlair: Boolean = false,

    @SerializedName("author_flair_text_color")
    val authorFlairTextColor: String? = null,

    val permalink: String = "",

    @SerializedName("parent_whitelist_status")
    val parentWhitelistStatus: String = "",

    val stickied: Boolean = false,
    val url: String = "",

    @SerializedName("subreddit_subscribers")
    val subredditSubscribers: Long = 0,

    @SerializedName("created_utc")
    val createdUTC: Double = 0.0,

    @SerializedName("num_crossposts")
    val numCrossposts: Long = 0,

    val media: DataMedia? = null,

    @SerializedName("is_video")
    val isVideo: Boolean = false,

    @SerializedName("is_gallery")
    val isGallery: Boolean? = null,

    @SerializedName("media_metadata")
    val mediaMetadata: Map<String, MediaMetadatum>? = null,

    @SerializedName("gallery_data")
    val galleryData: GalleryData? = null,

    @SerializedName("crosspost_parent_list")
    val crosspostParentList: List<CrosspostParentList>? = null,

    @SerializedName("crosspost_parent")
    val crosspostParent: String? = null
)