package com.etc;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
	public static void play (String filepath) {
		try{
		File soundFile=new File (filepath);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		AudioFormat format =audioInputStream.getFormat();
		
		SourceDataLine auline = null;
		DataLine.Info info =new DataLine.Info(SourceDataLine.class, format, 1024);
		auline = (SourceDataLine) AudioSystem.getLine(info);
		auline.open(format);
		auline.start();
		int nBytesRead =0;
		byte[]abData=new byte [1024];
		while(nBytesRead!=-1){
			nBytesRead=audioInputStream.read(abData, 0,abData.length);
			if(nBytesRead>=0)
				auline.write(abData, 0, nBytesRead);
		} 
		auline.drain();
		auline.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}

