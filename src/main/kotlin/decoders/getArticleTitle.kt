package decoders

import org.jsoup.Jsoup

fun getArticleTitle(articleString: String) : String {
    return Jsoup.parse(articleString).select(".MainTitle").first()!!.text()
}