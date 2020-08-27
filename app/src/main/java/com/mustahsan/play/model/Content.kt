package com.mustahsan.play.model

data class Content(
    val assetTypes: List<String>,
    val duration: Double,
    val format: String,
    val releases: List<Release>,
    val streamingUrl: String
)