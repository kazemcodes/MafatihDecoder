package decoders

import models.ArticleItem
import org.jsoup.nodes.Element
import org.jsoup.parser.Tag

fun parseElements(element: Element) : ArticleItem {
    return when  {
        element.tag() == Tag.valueOf("h2") -> ArticleItem(element.text(), "Text")
        element.tag()==  Tag.valueOf("h3") -> ArticleItem(element.text(), "Translated")
        element.tag() == Tag.valueOf("p") && element.hasClass("RedT") -> ArticleItem(element.text(), "Title")
        else  -> ArticleItem(element.ownText(), "About")
    }
}