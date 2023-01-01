package models

import kotlinx.serialization.Serializable

@Serializable
data class ArticleItem(
    val content: String,
    val type: String,
)


