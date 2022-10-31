import newsappstarter.io.carvalho.model.data.Article

interface ViewHome {

    interface View {
        fun showProgressBar()

        fun showFailure(message: String)

        fun hideProgressBar()

        fun showArticles(articles: List<Article>)
    }
}
