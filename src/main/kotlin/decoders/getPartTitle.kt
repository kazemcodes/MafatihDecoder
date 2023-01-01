package decoders

import org.jsoup.Jsoup

fun getPartTitle(sectionString:String) : String {
    return Jsoup.parse(sectionString).select(".PartTitle").first()!!.text()
}