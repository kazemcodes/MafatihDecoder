package models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String,
    val items: List<ArticleItem> = emptyList(),
    val articleItems: List<ArticleItem> = emptyList(),
)
