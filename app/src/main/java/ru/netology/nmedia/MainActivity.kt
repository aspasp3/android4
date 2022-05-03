package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.TransformNum

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewById<ImageButton>(R.id.likes_pic).setOnClickListener{
        //    println("clicked")
        // }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false
        )

        with(binding){
            author.text = post.author
            published.text = post.published
            content.text = post.content
            //avatar.setImageResource(@sample.posts_avatar.post_avatar_drawable)
            if(post.likedByMe) {
                likesPic?.setImageResource(R.drawable.ic_outline_favorite_border_24)
            }
            val TransformNum=TransformNum()
            likes?.text = post.likes.toString()
            share?.text = TransformNum.transformNum(post.shares)
            view?.text = TransformNum.transformNum(post.views)

            root.setOnClickListener{
                Log.d("stuff","stuff")
            }

            avatar.setOnClickListener{
                Log.d("stuff","avatar")
            }

            sharePic?.setOnClickListener{
                post.shares++
                share?.text = TransformNum.transformNum(post.shares)
            }

            likesPic?.setOnClickListener{
                Log.d("stuff","like")
                post.likedByMe = !post.likedByMe
                likesPic.setImageResource(
                    if(post.likedByMe) R.drawable.ic_baseline_heart_broken_24 else R.drawable.ic_outline_favorite_border_24
                )
                if(post.likedByMe) post.likes++ else post.likes--
                likes?.text = post.likes.toString()
            }
        }

    }
}