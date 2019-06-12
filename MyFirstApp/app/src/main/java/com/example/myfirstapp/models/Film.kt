package com.example.myfirstapp.models

import android.icu.text.StringSearch

class Film(
    var title: String,
    var description: String,
    var boxOffice: String,
    var director: Director
)
class Director(
    var name: String,
    var surname: String,
    var filmCount: Int
)