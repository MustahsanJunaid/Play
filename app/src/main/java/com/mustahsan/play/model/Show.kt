package com.mustahsan.play.model

data class Show(
    val layoutOrder: String,
    val layoutTitles: LayoutTitles,
    val moduleId: String,
    val moduleType: String,
    val pegImageType: String,
    val title: String
) {

    val posterThumbUrl: String?
        get() {
            val titles = layoutTitles.titles
            return if (titles.isNotEmpty()) {
                val englishTitle =
                    titles.firstOrNull { it.languages.contains("en") } ?: titles.first()
                when {
                    englishTitle.thumbnails.thumb1 != null -> {
                        englishTitle.thumbnails.thumb1.url
                    }
                    englishTitle.thumbnails.thumb2 != null -> {
                        englishTitle.thumbnails.thumb2.url
                    }
                    englishTitle.thumbnails.thumb3 != null -> {
                        englishTitle.thumbnails.thumb3.url
                    }
                    englishTitle.thumbnails.thumb4 != null -> {
                        englishTitle.thumbnails.thumb4.url
                    }
                    else -> {
                        englishTitle.thumbnails.thumb5?.url
                    }
                }
            } else {
                null
            }
        }

    val bannerThumbUrl: String?
        get() {
            val titles = layoutTitles.titles
            return if (titles.isNotEmpty()) {
                val englishTitle =
                    titles.firstOrNull { it.languages.contains("en") } ?: titles.first()
                when {
                    englishTitle.thumbnails.thumb5 != null -> {
                        englishTitle.thumbnails.thumb5.url
                    }
                    englishTitle.thumbnails.thumb4 != null -> {
                        englishTitle.thumbnails.thumb4.url
                    }
                    englishTitle.thumbnails.thumb3 != null -> {
                        englishTitle.thumbnails.thumb3.url
                    }
                    englishTitle.thumbnails.thumb2 != null -> {
                        englishTitle.thumbnails.thumb2.url
                    }
                    else -> {
                        englishTitle.thumbnails.thumb1?.url
                    }
                }
            } else {
                null
            }
        }
}