package advanced.chapter03

import me.bossm0n5t3r.advanced.chapter03.Exercise04PreferenceReader.FakePreferences
import me.bossm0n5t3r.advanced.chapter03.Exercise04PreferenceReader.Preferences
import kotlin.test.Test
import kotlin.test.assertEquals

class Exercise04PreferenceReaderTest {
    @Test
    fun `We can store or read values`() {
        // Store
        Preferences.token = "Test"
        Preferences.id = "Test"
        // Read
        Preferences.token
        Preferences.id
    }

    @Test
    fun `Retrieved value is the same as the one what was saved`() {
        val test1 = "Test"
        val test2 = "Test2"

        Preferences.token = test1
        Preferences.id = test1
        assertEquals(test1, Preferences.token)
        assertEquals(test1, Preferences.id)

        Preferences.token = test2
        assertEquals(test2, Preferences.token)
        assertEquals(test1, Preferences.id)

        Preferences.id = test2
        // Read
        assertEquals(test2, Preferences.token)
    }

    @Test
    fun `Storage and reading both use FakePreferences`() {
        val test1 = "Test"
        val test2 = "Test2"

        Preferences.token = test1
        assertEquals(test1, FakePreferences.preferences["UserPreferences" to "token"])

        FakePreferences.preferences += ("UserPreferences" to "token") to test2
        assertEquals(test2, Preferences.token)
    }
}
