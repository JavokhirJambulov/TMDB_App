package uz.javokhirjambulov.tmdbclient.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import uz.javokhirjambulov.tmdbclient.R
import uz.javokhirjambulov.tmdbclient.databinding.ActivityHomeBinding
import uz.javokhirjambulov.tmdbclient.presentation.artist.ArtistActivity
import uz.javokhirjambulov.tmdbclient.presentation.movie.MovieActivity
import uz.javokhirjambulov.tmdbclient.presentation.tv.TvShowActivity

class HomeActivity : ComponentActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.tvButton.setOnClickListener{
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
        binding.movieButton.setOnClickListener{
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener{
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }


    }

}

