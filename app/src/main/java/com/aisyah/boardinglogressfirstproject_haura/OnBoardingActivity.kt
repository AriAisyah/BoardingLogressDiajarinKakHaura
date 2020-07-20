package com.aisyah.boardinglogressfirstproject_haura

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Sunlight",
                "Sunlight is the light and energy that comes from the sun",
                R.drawable.image1
            ),
            IntroSlide(
                "Pay Online",
                "Electronic bill payment is a feature of online, mobile and telephone banking",
                R.drawable.image2
            ),
            IntroSlide(
                "Video Streaming",
                "Streaming media is multimedia that is constantly received by and presented to an end-user",
                R.drawable.image3
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        //panggil adapter nya di viewpager
        viewPager.adapter = introSliderAdapter

        //naro indicator
        setUpIndicators()

        //naro indicator sesuai posisinya
        setCurrentIndicators(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                setCurrentIndicators(position)
            }
        })
        btnNext.setOnClickListener {
            if (viewPager.currentItem +1 < introSliderAdapter.itemCount){
                viewPager.currentItem += 1
                //kalo view pagernya masih kurang 3, dia lanjut view pager selanjutnya.
            } else {
                Intent(applicationContext,MainActivity::class.java).also{
                    //
                    startActivity(it) // "it" intent
                    finish()
                }
            }
        }

        txtSkip.setOnClickListener{
            Intent(applicationContext,MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }
    }

    private fun setUpIndicators() {
        // indicator = nampung jumlah data
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    ) // naro di drawable inactivenya
                )
                this?.layoutParams = layoutParams
            }
            dots.addView(indicators[i])
        }
    }
    private fun setCurrentIndicators(index : Int){
        //childCount = buat ngitung widgetnya
        val childCount = dots.childCount
        //dikasih current indicator biar ga bingung di viewpager yang mana

        for (i in 0 until childCount){
            val imageView = dots.get(i) as ImageView

            //jika di posisi
            if (i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(application, R.drawable.indicator_active))
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.indicator_inactive))
            }
        }
    }
}
