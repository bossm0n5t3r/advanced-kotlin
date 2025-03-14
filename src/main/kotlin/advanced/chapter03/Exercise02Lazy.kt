package me.bossm0n5t3r.advanced.chapter03

object Exercise02Lazy {
    data class BlogPost(
        val title: String,
        val content: String,
        val author: Author,
    ) {
        val authorName = "${author.name} ${author.surname}"
        val wordCount by lazy { calculateWordCount() }
        val isLongRead = calculateIsLongRead()
        val summary by lazy { generateSummary(content) }

        private fun calculateWordCount(): Int = content.split("\\s+".toRegex()).size

        private fun calculateIsLongRead(): Boolean = content.length > 1000

        private fun generateSummary(content: String): String = content.take(100) + "..."
    }

    data class Author(
        val key: String,
        val name: String,
        val surname: String,
    )
}
