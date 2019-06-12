package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.models.Director
import com.example.myfirstapp.models.Film
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var director: Director = Director("Quentin", "Tarantino", 205)
        var film: Film = Film("Inglourious Basterds", "World war II, in German-occupied France, a group of American Jewish soldiers terrorize the Nazis by brutally killing and scalping soldiers.", "$ 200 million", director)
        setFilmUi(film)
    }
    fun setFilmUi(f: Film)
    {
        filmTitle.text = f.title
        filmDescription.text = f.description
        filmBoxOffice.text = f.boxOffice
        setDirectorUi(f.director)
    }
    fun setDirectorUi(d: Director)
    {
        directorName.text = d.name
        directorSurname.text = d.surname
        directorFilmCount.text = d.filmCount.toString()
    }
}
