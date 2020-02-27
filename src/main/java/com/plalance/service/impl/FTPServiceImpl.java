package com.plalance.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.plalance.services.FTPService;

@Service
public class FTPServiceImpl implements FTPService {

	@Autowired
	private Environment env;

	@Override
	public List<String> getFilesList() {

		List<String> files = new ArrayList<String>();

		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(env.getProperty("ftp.host"));
			ftpClient.login(env.getProperty("ftp.user"), env.getProperty("ftp.password"));
			System.out.println("Connection established...");
			String[] names = ftpClient.listNames("/");
			
			for (String name : names) {
				files.add(name);
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return files;
	}
}
