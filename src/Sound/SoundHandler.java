package Sound;

import javafx.animation.Animation;
import javafx.scene.media.AudioClip;
import java.io.File;
import java.util.HashMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by NangTrongVuon on 17/8/16.
 */
public class SoundHandler
{

    HashMap<String,AudioClip> soundEffectsMap = new HashMap<>();
    MediaPlayer backgroundPlayer;

    // Loads sound from a
    public void loadSound(String id)
    {
        String audioClipPath = getClass().getResource("/" + id + ".wav").toExternalForm();
        System.out.println(audioClipPath);
        AudioClip sound = new AudioClip(audioClipPath);
        soundEffectsMap.put(id, sound);
    }

    public void playSound(String id)
    {
        if (!soundEffectsMap.get(id).isPlaying())
        {
            soundEffectsMap.get(id).play();
        }

    }

    public void playBackgroundMusic(String id)
    {
      String backgroundPath = getClass().getResource("../" + id + ".mp3").toExternalForm();
      Media backgroundFile = new Media(backgroundPath);
      this.backgroundPlayer = new MediaPlayer(backgroundFile);
      MediaPlayer background = this.backgroundPlayer;
      background.setCycleCount(Animation.INDEFINITE);
      background.setAutoPlay(true);
    }

}