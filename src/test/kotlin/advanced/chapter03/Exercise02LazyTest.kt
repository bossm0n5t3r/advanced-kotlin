package advanced.chapter03

import me.bossm0n5t3r.advanced.chapter03.Exercise02Lazy.Author
import me.bossm0n5t3r.advanced.chapter03.Exercise02Lazy.BlogPost
import kotlin.system.measureTimeMillis
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class Exercise02LazyTest {
    @Test
    fun run() {
        val post =
            BlogPost(
                title = "Hello, World!",
                content =
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed non risus. Suspendisse lectus tortor, dignissim sit amet, " +
                        "adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. " +
                        "Maecenas ligula massa, varius a, semper congue, euismod non, mi. " +
                        "Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, " +
                        "non fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, " +
                        "scelerisque vitae, consequat in, pretium a, enim. Pellentesque congue. " +
                        "Ut in risus volutpat libero pharetra tempor. Cras vestibulum bibendum " +
                        "augue. Praesent egestas leo in pede. Praesent blandit odio eu enim. " +
                        "Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum " +
                        "primis in faucibus orci luctus et ultrices posuere cubilia Curae; " +
                        "Aliquam nibh. Mauris ac mauris sed pede pellentesque fermentum. " +
                        "Maecenas adipiscing ante non diam sodales hendrerit.",
                author =
                    Author(
                        key = "alex",
                        name = "Alex",
                        surname = "Smith",
                    ),
            )

        assertEquals("Alex Smith", post.authorName)
        assertEquals(124, post.wordCount)
        assertFalse { post.isLongRead }
        assertEquals(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, d...",
            post.summary,
        )
    }

    @Test
    fun stressTest() {
        val author =
            Author(
                key = "alex",
                name = "Alex",
                surname = "Smith",
            )
        val longText =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, " +
                "dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, " +
                "varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, non " +
                "fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim. " +
                "Pellentesque congue. Ut in risus volutpat libero pharetra tempor. Cras vestibulum bibendum augue. Praesent egestas " +
                "leo in pede. Praesent blandit odio eu enim. Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum " +
                "primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed pede pellentesque " +
                "fermentum. Maecenas adipiscing ante non diam sodales hendrerit."

        measureTimeMillis {
            val post =
                BlogPost(
                    title = "Hello, World!",
                    content = longText,
                    author = author,
                )
            repeat(1_000_000) { post.authorName }
        }.let { println("Reading authorName 1 000 000 times from the same object took $it") }

        measureTimeMillis {
            repeat(1_000) {
                val post =
                    BlogPost(
                        title = "Hello, World!",
                        content = longText,
                        author = author,
                    )
                repeat(it % 11) { post.wordCount }
            }
        }.let { println("Reading wordCount from 1 000 objects from 0 to 10 times took $it") }

        measureTimeMillis {
            repeat(10_000) {
                val post =
                    BlogPost(
                        title = "Hello, World!",
                        content = longText,
                        author = author,
                    )
                repeat(if (it % 4 == 0) 1 else 0) { post.wordCount }
            }
        }.let { println("Reading isLongRead from 10 000 objects 0, 0, 0, or 1 times took $it") }

        measureTimeMillis {
            repeat(100) {
                val post =
                    BlogPost(
                        title = "Hello, World!",
                        content = longText,
                        author = author,
                    )
                repeat(it % 11) { post.summary }
            }
        }.let { println("Reading summary from 100 objects from 0 to 10 times took $it") }
    }
}
