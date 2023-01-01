package util

import java.io.File

fun getResourceText(path: String): String {
    return File(ClassLoader.getSystemResource(path).file).readText()
}

fun getResourceFile(path: String): File {
    return File(ClassLoader.getSystemResource(path).file)
}