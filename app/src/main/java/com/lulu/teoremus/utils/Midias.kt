package com.lulu.teoremus.utils


import android.content.Context
import android.media.MediaPlayer
import com.lulu.teoremus.enums.Escolhas

class Midias (e: Escolhas? = null, c: Context? = null){
    private var mp = MediaPlayer()
     var escolha = e
     var context = c


    fun criarMidia() {
        mp = MediaPlayer.create(context, escolha!!.som)
    }

    fun conferirMP() {
        if (mp.isPlaying)
            mp.stop()
    }

    fun start() {
        conferirMP()
        criarMidia()
        mp.start()
    }

    fun alterarEscolha(esc: Escolhas, cont: Context){
        escolha = esc
        context = cont
    }

}