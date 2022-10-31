package newsappstarter.io.carvalho.model.data

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)