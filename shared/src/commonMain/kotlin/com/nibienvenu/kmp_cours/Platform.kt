package com.nibienvenu.kmp_cours

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform