package com.ezrebclan.ezrebalarm.alarm

import javax.sound.sampled.AudioSystem
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.TargetDataLine
import javax.sound.sampled.DataLine
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.Port
import javax.sound.sampled.Clip

trait SoundAlert extends Alarm {

  hasSoundAlert = true
  override def goOff(): Unit = {
    println("test2")
    super.goOff
  }
}