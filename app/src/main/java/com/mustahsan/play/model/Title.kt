package com.mustahsan.play.model

data class Title(
    val arAgeRating: String,
    val fourkProgramId: String,
    val friendlyTitle4Url: String,
    val has4K: String,
    val languages: List<String>,
    val media: List<Media>,
    val programType: String,
    val tagIds: List<String>,
    val tags: List<Tag>,
    val thumbnails: Thumbnails,
    val title: String,
    val titleCredits: List<Any>,
    val titleId: String,
    val titleLocalized: TitleLocalized,
    val year: Int
)