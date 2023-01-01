import decoders.getParts
import org.jsoup.Jsoup
import org.junit.jupiter.api.Test
import util.getResourceFile


class ApplicationTest() {
    @Test
    fun getPartsTest() {
        val file = getResourceFile("Babe1.htm")
        assert(getParts(Jsoup.parse(file)).size == 8)
    }

}

