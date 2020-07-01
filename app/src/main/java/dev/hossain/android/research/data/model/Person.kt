package dev.hossain.android.research.data.model

/**
 * A person containing basic info to be used as sample data in list views.
 */
data class Person constructor(
    val id: Int,
    val name: String,
    val phone: String,
    val company: String
) {
    val nameLetter: String
        get() = name[0].toString()
}