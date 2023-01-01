package decoders

import createString

fun parseArticleItems(docs:String) : List<String> {
    return docs.split("<p class=\"RedT\">")
        .mapIndexed { index, s -> createString(s, "<p class=\"RedT\">", index) }
}