import com.google.gson.annotations.SerializedName


data class TumbltResponsePOJO (

	@SerializedName("meta")
	val meta : Meta,
	@SerializedName("response")
	val response : List<Response>,

){

	data class Response (

		@SerializedName("type") val type : String,
		@SerializedName("blog_name") val blog_name : String,
		@SerializedName("blog") val blog : Blog,
		@SerializedName("id") val id : Long,
		@SerializedName("id_string") val id_string : String,
		@SerializedName("post_url") val post_url : String,
		@SerializedName("slug") val slug : String,
		@SerializedName("date") val date : String,
		@SerializedName("timestamp") val timestamp : Int,
		@SerializedName("state") val state : String,
		@SerializedName("format") val format : String,
		@SerializedName("reblog_key") val reblog_reblog_key : String,
		@SerializedName("tags") val tags : List<String>,
		@SerializedName("short_url") val short_url : String,
		@SerializedName("summary") val summary : String,
		@SerializedName("should_open_in_legacy") val should_open_in_legacy : Boolean,
		@SerializedName("recommended_source") val recommended_source : String,
		@SerializedName("recommended_color") val recommended_color : String,
		@SerializedName("featured_in_tag") val featured_in_tag : List<String>,
		@SerializedName("featured_timestamp") val featured_timestamp : Int,
		@SerializedName("note_count") val note_count : Int,
		@SerializedName("caption") val caption : String,
		@SerializedName("reblog") val reblog : Reblog,
		@SerializedName("trail") val trail : List<Trail>,
		@SerializedName("photoset_layout") val photoset_layout : Int,
		@SerializedName("photos") val photos : List<Photos>?,
		@SerializedName("can_like") val can_like : Boolean,
		@SerializedName("interactability_reblog") val interactability_reblog : String,
		@SerializedName("can_reblog") val can_reblog : Boolean,
		@SerializedName("can_send_in_message") val can_send_in_message : Boolean,
		@SerializedName("can_reply") val can_reply : Boolean,
		@SerializedName("display_avatar") val display_avatar : Boolean
	)
	data class Alt_sizes (

		@SerializedName("url") val url : String,
		@SerializedName("width") val width : Int,
		@SerializedName("height") val height : Int
	)

	data class Blog (

		@SerializedName("name") val name : String,
		@SerializedName("active") val active : Boolean,
		@SerializedName("theme") val theme : Theme,
		@SerializedName("share_likes") val share_likes : Boolean,
		@SerializedName("share_following") val share_following : Boolean,
		@SerializedName("can_be_followed") val can_be_followed : Boolean
	)

	data class Meta (

		@SerializedName("status") val status : Int,
		@SerializedName("msg") val msg : String
	)
	data class Original_size (

		@SerializedName("url") val url : String,
		@SerializedName("width") val width : Int,
		@SerializedName("height") val height : Int
	)

	data class Photos (

		@SerializedName("caption") val caption : String,
		@SerializedName("original_size") val original_size : Original_size,
		@SerializedName("alt_sizes") val alt_sizes : List<Alt_sizes>
	)
	data class Reblog (

		@SerializedName("comment") val comment : String,
		@SerializedName("tree_html") val tree_html : String
	)



	data class Theme (

		@SerializedName("header_full_width") val header_full_width : Int,
		@SerializedName("header_full_height") val header_full_height : Int,
		@SerializedName("header_focus_width") val header_focus_width : Int,
		@SerializedName("header_focus_height") val header_focus_height : Int,
		@SerializedName("avatar_shape") val avatar_shape : String,
		@SerializedName("background_color") val background_color : String,
		@SerializedName("body_font") val body_font : String,
		@SerializedName("header_bounds") val header_bounds : String,
		@SerializedName("header_image") val header_image : String,
		@SerializedName("header_image_focused") val header_image_focused : String,
		@SerializedName("header_image_poster") val header_image_poster : String,
		@SerializedName("header_image_scaled") val header_image_scaled : String,
		@SerializedName("header_stretch") val header_stretch : Boolean,
		@SerializedName("link_color") val link_color : String,
		@SerializedName("show_avatar") val show_avatar : Boolean,
		@SerializedName("show_description") val show_description : Boolean,
		@SerializedName("show_header_image") val show_header_image : Boolean,
		@SerializedName("show_title") val show_title : Boolean,
		@SerializedName("title_color") val title_color : String,
		@SerializedName("title_font") val title_font : String,
		@SerializedName("title_font_weight") val title_font_weight : String
	)

	data class Trail (

		@SerializedName("blog") val blog : Blog,
		@SerializedName("post") val post : Post,
		@SerializedName("content_raw") val content_raw : String,
		@SerializedName("content") val content : String,
		@SerializedName("is_current_item") val is_current_item : Boolean,
		@SerializedName("is_root_item") val is_root_item : Boolean
	)

	data class Post (

		@SerializedName("id") val id : Long
	)
}
