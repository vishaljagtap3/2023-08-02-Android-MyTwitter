package com.bitcodetech.mytwitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bitcodetech.mytwitter.adapters.TweetsAdapter
import com.bitcodetech.mytwitter.models.Advertisement
import com.bitcodetech.mytwitter.models.Tweet

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerTweets: RecyclerView

    private val tweets = ArrayList<Tweet>()
    private val advertisements = ArrayList<Advertisement>()
    private lateinit var tweetsAdapter: TweetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataSources()

        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initDataSources() {
        tweets.add(Tweet(R.mipmap.ic_launcher, "Android is Great!", "@bitcodtech"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "iOS is not Great!", "@bitcodtech"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "Java is okay!", "@bitcodtech"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "Writing assignments is boring!", "@bitcodtech"))
        tweets.add(
            Tweet(
                R.mipmap.ic_launcher,
                "Everyone wants to zukerberg, but no one wants to work hard!",
                "@vishal"
            )
        )
        tweets.add(Tweet(R.mipmap.ic_launcher, "I am not feeling well today", "@vaibhav"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "BitCode is new Now!", "@bitcodtech"))
        tweets.add(
            Tweet(
                R.mipmap.ic_launcher,
                "Now is the time to work hard! is it?",
                "@bitcodtech"
            )
        )
        tweets.add(
            Tweet(
                R.mipmap.ic_launcher,
                "Dreams are free! Hustle is sold separately..",
                "@bitcodtech"
            )
        )
        tweets.add(Tweet(R.mipmap.ic_launcher, "Android is amazing!", "@bitcodtech"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "Android is Dynamic!", "@bitcodtech"))
        tweets.add(Tweet(R.mipmap.ic_launcher, "Android is updated everyday!", "@bitcodtech"))

        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 1"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 2"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 3"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 4"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 5"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 6"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 1"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 2"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 3"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 4"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 5"))
        advertisements.add(Advertisement(R.drawable.advertisement, "Buy product 6"))
    }

    private fun initViews() {
        recyclerTweets = findViewById(R.id.recyclerTweets)
        /*recyclerTweets.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)*/
       /* recyclerTweets.layoutManager = GridLayoutManager(
            this, 2
        )*/
        recyclerTweets.layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )
        tweetsAdapter = TweetsAdapter(tweets, advertisements)
        recyclerTweets.adapter = tweetsAdapter

    }
}