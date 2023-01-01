package decoders

import createString

fun parseArticles(docs:String) : List<String> {
    return docs.split("<p class=\"MainTitle\">")
        .mapIndexed { index, s -> createString(s, "<p class=\"MainTitle\">", index) }
}