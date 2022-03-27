package com.bkc.myeducationapp.ModelClass.courcelist

data class Courcelist(
    val Package: Package,
    val `data`: List<Data>,
    val error: Boolean,
    val message: String
)