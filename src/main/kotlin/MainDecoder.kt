import decoders.*
import kotlinx.serialization.json.Json

import kotlinx.serialization.json.encodeToJsonElement
import models.Article
import models.ArticleItem
import models.Chapter
import models.Section
import org.jsoup.Jsoup
import org.jsoup.parser.Tag
import util.getResourceFile
import java.io.File



val files = listOf(
    "باب اول" to "Babe1",
    "باب دوم" to "Babe2",
    "باب سوم" to "Babe3",
    "خاتمه 1" to "Khateme1",
    "خاتمه 2" to "Khateme2",
    "مقدمه" to "Moghadame",
    "ملحقه 1" to "Molhaghate1",
    "ملحقه 2" to "Molhaghate2",
)

private val json1 = Json



fun main() {

    val chapters = mutableSetOf<Chapter>()


    files.forEach { files ->



    val file = getResourceFile("${files.second}.htm")

    val docs = Jsoup.parse(file).html()
    val sectionsList = mutableSetOf<Section>()
    val sectionsArticleItemsList = mutableSetOf<ArticleItem>()

    val sections = parseSections(docs)
    sections.drop(1).map { sectionString ->
        val articlesList = mutableSetOf<Article>()
        val articlesItemList = mutableSetOf<ArticleItem>()
        val partTitle = getPartTitle(sectionString)

        val articles = parseArticles(sectionString)
        articles.drop(1).map { articleString ->
            val articleItems = parseArticleItems(articleString)
            articleItems.drop(1).map { item ->
                val articleItemsDoc = Jsoup.parse(item)
                articleItemsDoc.forEach { element ->
                    val aritem = parseElements(element)
                    if (aritem != null) {
                        articlesItemList.add(aritem)
                    }
                }
                val title = articleItemsDoc.select(".RedT").text()

            }

            val articleTitle = getArticleTitle(articleString)
            val article = Article(articleTitle, articlesItemList.toList())
            articlesList.add(article)
        }
        if (sectionsList.isEmpty()) {
            Jsoup.parse(sectionString).forEach { sectionsArticleItemsList.add(parseElements(it)) }
        }
        val section = Section(title = partTitle, articlesList.toList(),sectionsArticleItemsList.toList())
        sectionsList.add(section)

    }

    val chapter = Chapter(files.first, sections = sectionsList.toList())
    val filess = File("${files.second}.json")
    filess.createNewFile()
    val json = json1.encodeToJsonElement(chapter)
    filess.writeText(json.toString())
    chapters.add(Chapter(title = files.first,sections = sectionsList.toList()))
    }
    val finalFile = File("final_file.json")
    finalFile.createNewFile()
    val json = json1.encodeToJsonElement(chapters)
    finalFile.writeText(json.toString())
}

fun createString(data: String, endString: String, index: Int): String {
    return if (index != 0) endString + data else data
}


