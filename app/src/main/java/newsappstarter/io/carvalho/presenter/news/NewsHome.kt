import newsappstarter.io.carvalho.data.model.NewsResponse

interface NewsHome {

    interface Presenter {
        fun requestAll()

        fun onSuccess(newsResponse: NewsResponse)

        fun onError(message: String)

        fun onComplete()
    }
}