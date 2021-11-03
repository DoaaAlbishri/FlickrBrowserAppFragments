package com.example.flickrbrowserappfragments

data class Image(var title: String, var link: String){
    companion object{
        var imageList= arrayListOf<Image>()
    }
}

