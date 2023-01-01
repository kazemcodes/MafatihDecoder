package decoders

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


//should return a list of 8 elements
fun getParts(docs: Document): Elements {
    return docs.select(".Part")
}