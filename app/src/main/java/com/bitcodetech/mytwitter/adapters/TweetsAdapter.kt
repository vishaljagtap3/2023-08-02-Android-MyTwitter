package com.bitcodetech.mytwitter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bitcodetech.mytwitter.R
import com.bitcodetech.mytwitter.models.Advertisement
import com.bitcodetech.mytwitter.models.Tweet
import org.w3c.dom.Text

class TweetsAdapter(
    private val tweets : ArrayList<Tweet>,
    private val advertisements: ArrayList<Advertisement>
) : RecyclerView.Adapter<ViewHolder>() {

    val VIEW_TYPE_TWEET = 2
    val VIEW_TYPE_ADVERTISEMENT = 1

    class TweetViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgTweet : ImageView
        val txtBody : TextView
        val txtAuthor : TextView

        init {
            imgTweet = view.findViewById(R.id.imgTweet)
            txtBody = view.findViewById(R.id.txtBody)
            txtAuthor = view.findViewById(R.id.txtAuthor)
        }
    }

    class AdvertisementViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgAdvertisement : ImageView
        val txtTitle : TextView

        init {
            imgAdvertisement = view.findViewById(R.id.imgAdvertisement)
            txtTitle = view.findViewById(R.id.txtTitle)
        }
    }


    override fun getItemCount() = tweets.size + advertisements.size

    override fun getItemViewType(position: Int): Int {
        if(position % 2 == 1) {
            return VIEW_TYPE_ADVERTISEMENT
        }
        return VIEW_TYPE_TWEET
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        if(viewType == VIEW_TYPE_TWEET) {
            return TweetViewHolder(
                layoutInflater.inflate(R.layout.tweet_view, null)
            )
        }

        return AdvertisementViewHolder(
            layoutInflater.inflate(R.layout.advertisement_view, null)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //tweet
        if(position % 2 ==  0) {
            val tweet = tweets[position/2]
            val tweetViewHolder = holder as TweetViewHolder
            tweetViewHolder.imgTweet.setImageResource(tweet.imageId)
            tweetViewHolder.txtAuthor.text = tweet.author
                tweetViewHolder.txtBody.text = tweet.body
            return
        }

        //advertisement
        val advertisementViewHolder = holder as AdvertisementViewHolder
        val advertisement = advertisements[position/2]
        advertisementViewHolder.txtTitle.text = advertisement.title
        advertisementViewHolder.imgAdvertisement.setImageResource(advertisement.imageId)

    }
}


