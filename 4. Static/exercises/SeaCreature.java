package exercises;

/*
 * 1. Create a class called Ocean.
 * 2. There make make a SeaCreature called “Spongebob”. 
 * 3. Use the methods below to make him eat, and laugh.
 * 4. Make Patrick and Squidward and print their name, and make them laugh.
 */

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Mixer;

class Ocean{
	
	 public static void main(String[] args)
	 {
		 SeaCreature bob = new SeaCreature("spongebob");
		 bob.eat();
		 bob.laugh();
		 SeaCreature patrick = new SeaCreature("patrick");
		 patrick.eat();
		 patrick.laugh();
		 SeaCreature squidward = new SeaCreature("squidward");
		 squidward.eat();
		 squidward.laugh();
		 
		 
	 }
	
}

public class SeaCreature {
	
	private String name;

	SeaCreature(String name) {
		this.name = name;
	}

	public String getName() {
		return "My name is " + name;
	}

	public void eat() {
		System.out.println(name + " is eating krabby patties");
	}

	public void laugh() {
		System.out.println(this.name + " Laughed!");
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(
					"sounds/" + this.name + ".wav").toURI().toURL());
			//add format loop
			AudioFormat format = audioInputStream.getFormat();
			DataLine.Info lineInfo = new DataLine.Info(Clip.class, format);

			Mixer.Info selectedMixer = null;

			for (Mixer.Info mixerInfo : AudioSystem.getMixerInfo()) {
			    Mixer mixer = AudioSystem.getMixer(mixerInfo);
			    if (mixer.isLineSupported(lineInfo)) {
			        selectedMixer = mixerInfo;
			        break;
			    }
			}

			if (selectedMixer != null) {
				System.out.println("Playing laugh clip");
			    Clip clip = AudioSystem.getClip(selectedMixer); 
			    
				clip.open(audioInputStream);
				clip.start();
				Thread.sleep(3400);
			   
			}
			
			
			
//			Clip clip = AudioSystem.getClip();
//			clip.open(audioInputStream);
//			clip.start();
//			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
