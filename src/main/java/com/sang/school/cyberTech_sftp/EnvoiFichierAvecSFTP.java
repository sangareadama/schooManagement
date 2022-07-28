package com.sang.school.cyberTech_sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class EnvoiFichierAvecSFTP {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * //les declarations et configurations
	 * 
	 * String localPathForPuting="C:/DossierArrive"; String
	 * localPathForGeting="C:/DossierDepart"; String fileName="monFichierLocal.txt";
	 * String stfpPath="fichier_test"; String stfpHost="sangshop.files.com"; String
	 * stfpPort="22"; String stfpUser="sangadam7407@gmail.com"; String
	 * stfpPassword="sangaRE/7930";
	 * 
	 * try { JSch jsch = new JSch();
	 * 
	 * //creation de la session et etablissement de ta connection avec le serveur
	 * sftp
	 * 
	 * Session session = jsch.getSession(stfpUser, stfpHost,
	 * Integer.valueOf(stfpPort)); session.setConfig("StrictHostKeyChecking", "no");
	 * session.setPassword(stfpPassword);
	 * System.out.println("connection en cours......."); session.connect();
	 * System.out.println("connection etablie !");
	 * 
	 * 
	 * Channel channel = session.openChannel("sftp"); ChannelSftp sftpChannel =
	 * (ChannelSftp) channel; sftpChannel.connect();
	 * 
	 * System.out.println("ouverture de sftp channel");
	 * 
	 * 
	 * // envoi de fichier
	 * 
	 * System.out.println("copie du fichier sur le serveur");
	 * sftpChannel.put(localPathForPuting+"/"+fileName,stfpPath);
	 * System.out.println("fichier copié sur le serveur !!!");
	 * 
	 * 
	 * 
	 * 
	 * //reception de fichier
	 * 
	 * System.out.println("copie du fichier du serveur a notre dossier locol ");
	 * sftpChannel.get(stfpPath+"/"+fileName,localPathForGeting);
	 * System.out.println("fichier copié dans le dossier local !!!");
	 * 
	 * //deconection
	 * 
	 * sftpChannel.disconnect(); session.disconnect();
	 * 
	 * System.out.println("deconnection du sftp");
	 * 
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * 
	 * }
	 */

}
