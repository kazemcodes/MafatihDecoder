package models

import kotlinx.serialization.Serializable
import models.Section
@Serializable
data class Chapter(
    val title: String,
    val sections: List<Section> = emptyList(),
    val articleItems: List<ArticleItem> = emptyList(),
)
