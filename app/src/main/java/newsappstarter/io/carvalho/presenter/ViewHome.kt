import newsappstarter.io.carvalho.data.model.Article

interface ViewHome {

    interface View {
        fun showProgressBar()

        fun showFailure(message: String)

        fun hideProgressBar()

        fun showArticles(articles: List<Article>)
    }
}
