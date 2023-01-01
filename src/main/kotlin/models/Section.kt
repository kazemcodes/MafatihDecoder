package models

import kotlinx.serialization.Serializable

@Serializable
data class Section(
    val title: String,
    val articles: List<Article> = emptyList(),
    val articleItems: List<ArticleItem> = emptyList(),
)
