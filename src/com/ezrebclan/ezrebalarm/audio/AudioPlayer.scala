package com.ezrebclan.ezrebalarm.audio

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.URL

import org.omg.CORBA.portable.InputStream

import javax.sound.sampled.Clip
import javax.sound.sampled.Mixer
import javazoom.jl.converter.Converter
import javazoom.jl.decoder.Decoder

class AudioPlayer {

  var mixer: Mixer = null
  var clip: Clip = null
  
  def playResource(rsrcPath: String, rsrcName: String, isMp3: Boolean): Int = {
    if(isMp3) {
      
    }
    5
  }
  def convertMp3(mp3URL: URL): Boolean = {
    var cnvtr = new Converter
    var acpd = new AudioConversionProgressDisplay
    acpd.setVisible(true)
    var pl = new AWTProgressListener(acpd, new File(mp3URL.getFile).length().toInt)
    var fis2 = mp3URL.openStream()
    acpd.updateProgress(acpd.getObtainingFileBar, new File(mp3URL.getFile).length().toInt, 0)
    var fos2 = new FileOutputStream(new File("obtained.wav"))
    var bytes2 = new Array[Byte](1)
    while(fis2.available() > 0)  {
      bytes2 = new Array[Byte](1)
      fis2.read(bytes2)
      fos2.write(bytes2)
      acpd.updateProgress(acpd.getObtainingFileBar, new File(mp3URL.getFile).length().toInt, acpd.getObtainingFileBar.getValue+1)
    }
    var mp3Stream = new FileInputStream(new File("obtained.wav"))
    acpd.updateProgress(acpd.getObtainingFileBar, 1, 1)
    cnvtr.convert(mp3Stream, "converted.wav", pl, Decoder.getDefaultParams)
    mp3Stream.close()
    acpd.updateProgress(acpd.getConvertingFileBar(), 1, 1);
    var fis = new FileInputStream(new File("converted.wav"))
    var fos = new FileOutputStream(new File("imported.wav"))
    var bytes = new Array[Byte](1)
    acpd.updateProgress(acpd.getImportingFileBar, 1, 0)
    while(fis.available() > 0)  {
      bytes = new Array[Byte](1)
      fis.read(bytes)
      fos.write(bytes)
      acpd.updateProgress(acpd.getImportingFileBar, new File("converted.wav").length().toInt, acpd.getImportingFileBar.getValue+1)
    }
      acpd.updateProgress(acpd.getImportingFileBar, 1, 1)
    true
  }
}