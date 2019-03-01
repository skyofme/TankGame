package entity;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class AePlayWave extends Thread {
	private String filename;	
	public AePlayWave(String wavfile){
		filename=wavfile;
	}
	public void run(){
		boolean init=false;
		
		File soundFile=new File (filename);
		AudioInputStream audioInputStream=null;
		try { 
			audioInputStream=AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		AudioFormat format =audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info =new DataLine.Info(SourceDataLine.class, format, 1024);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		auline.start();
		int nBytesRead =0;
		byte[]abData=new byte [1024];
			try {
				while(nBytesRead!=-1){
				nBytesRead=audioInputStream.read(abData, 0,abData.length);
				if(nBytesRead>=0)
					auline.write(abData, 0, nBytesRead);
			} 
		}catch (IOException e) {
				e.printStackTrace();
				return;
			}
			finally {
				auline.drain();
				auline.close();
			}
			this.stop();
		}
//		init=true;
	}
