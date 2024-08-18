package com.mk.spring.board.model.service;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	public String upload(MultipartFile file) {
		String newFileName = "";
		try {
			// 1. 파일 저장
			String fileOriName = file.getOriginalFilename();
			
			// 2. 파일 자르기(.을 기준으로 파일명과 확장자 자르기)
			String fileExtension = fileOriName.substring(fileOriName.lastIndexOf("."),fileOriName.length());
			
			// 3. 파일 명칭 바꾸기 -> UUID(버전4)
			UUID uuid = UUID.randomUUID();
			
			// 4. 8자리마다 포함되는 하이픈 제거
			String uniqueName = uuid.toString().replaceAll("-", "");
			
			// 5. 새로운 파일명
			newFileName = uniqueName+fileExtension;
			
			// 6. 파일 저장 경로 설정
			String uploadDir = "C:\\board\\upload";
			
			// 7. 파일 껍데기 생성
			File saveFile = new File(uploadDir+"\\"+uniqueName+fileExtension);
			
			// 8. 경로 존재 여부 확인 -> 생성
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}
			
			// 9. 껍데기에 파일 정보 복제
			file.transferTo(saveFile);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return newFileName;
	}
}
