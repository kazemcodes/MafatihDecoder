package decoders

import createString

fun parseSections(docs: String) : List<String> {
    return docs.split("<p class=\"PartTitle\">")
        .mapIndexed { index, s -> createString(s, "<p class=\"PartTitle\">", index) }
}


