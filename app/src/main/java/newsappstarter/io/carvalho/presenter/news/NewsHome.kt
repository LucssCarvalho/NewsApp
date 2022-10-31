package newsappstarter.io.carvalho.presenter.news

import newsappstarter.io.carvalho.model.data.NewsResponse

interface NewsHome {

    interface Presenter {
        fun requestAll()

        fun onSuccess(newsResponse: NewsResponse)

        fun onError(message: String)

        fun onComplete()
    }
}