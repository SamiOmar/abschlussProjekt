import java.io.File;
import javax.sound.sampled.*;

fun playSound(audioPath: String, shouldLoop: Boolean = false, volumeLevel: Float = 0.99f) {
    Thread {
        var clip: Clip? = null
        var audioInput: AudioInputStream? = null
        try {
            val audio: File = File(audioPath)
            audioInput = AudioSystem.getAudioInputStream(audio)
            clip = AudioSystem.getClip()
            clip.open(audioInput)

            val volume: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
            volume.value = volume.minimum + (volumeLevel * (volume.maximum - volume.minimum))

            if (shouldLoop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY)
            }

            clip.start()
            Thread.sleep(clip.microsecondLength / 1000)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            clip?.close()
            audioInput?.close()
        }
    }.start()
}
