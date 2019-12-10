package io.file;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
		File file = new File("c:\\");
		String[] fileList = file.list();
		//list() : 디렉토리의 파일목록(디렉토리 포함)을 String배열로 반환한다., 파일의 이름을 저장
		
		int fileCount=0;
		int dirCount=0;
		
		for(int i=0; i<fileList.length;i++) {
			System.out.println(fileList[i]);
		}
		
		//listFiles() : 디렉토리의 파일목록을 File배열로 반환한다.
		for(File f:file.listFiles()) {
			if(f.isDirectory()) {
				dirCount++;
				System.out.println("dir= " + f);
			} else {
				fileCount++;
				System.out.println("file: " + f);
			}
		}
		
		System.out.println(fileCount+"개");
		System.out.println(dirCount+"개");

		//간단하게 한번 해봐라~ 
		//
		System.out.println("===============");
		for(int i=0; i<fileList.length; i++) {
			if(fileList[i].contains("I")) {
				System.out.println(fileList[i]);
			}
		}
		System.out.println("===============");
		//이렇게하면 파이명, 폴더명만 알수있다!! 디렉토리및 파일의 위치로 확인해보자
		
		//경로를 가져온 다음 디렉토리의 경로에 I가 포함되면 출력, 파일의 경로에 s가 포함되면 출력
		for(File f:file.listFiles()) {
			if(f.isDirectory()) {
				if(f.getPath().contains("I")) {
					System.out.println(f.getPath());
				}
			} 
			if(f.isFile()) {
				if(f.getPath().contains("s")) {
					System.out.println(f.getPath());
				}
			}
		}
	}

}
