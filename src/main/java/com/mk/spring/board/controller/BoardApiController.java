package com.mk.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mk.spring.board.model.service.BoardService;
import com.mk.spring.board.model.service.UploadFileService;
import com.mk.spring.board.model.vo.Board;

@Controller
public class BoardApiController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UploadFileService uploadFileService;
	
	
	// fetch에서 보낸 것
	@ResponseBody
	@PostMapping("/board")
	public Map<String,String> createBoard(Board vo, @RequestParam("file") MultipartFile file){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res_code", "404");
		map.put("res_msg", "게시글 등록 중 오류가 발생하였습니다.");
		
		String savedFileName = uploadFileService.upload(file);
		
		if(savedFileName != null) {
			vo.setOri_thumbnail(file.getOriginalFilename());
			vo.setNew_thumbnail(savedFileName);
			if(boardService.createBoard(vo) > 0) {
				map.put("res_code", "200");
				map.put("res_msg", "게시글이 성공적으로 등록되었습니다.");
				
			}
		} else {
			map.put("res_msg", "파일 업로드가 실패하였습니다.");
		}
		return map;
	}
	
	
	@ResponseBody
	@PostMapping("/board/{board_no}")
	public Map<String,String> updateBoard(Board vo, @RequestParam(name = "file", required = false) MultipartFile file){
		Map<String,String> map = new HashMap<String,String>();
		map.put("res_codde","404");
		map.put("res_msg", "게시글 수정 중 오류가 발생했습니다.");
		
		if(file != null && !"".equals(file.getOriginalFilename())) {
			String savedFileName = uploadFileService.upload(file);
			if(savedFileName != null) {
				vo.setOri_thumbnail(file.getOriginalFilename());
				vo.setNew_thumbnail(savedFileName);
			} else {
				map.put("res_msg", "파일 업로드 중 오류가 발생했습니다.");
			}
		}
		
		if(boardService.updateBoard(vo) > 0) {
			map.put("res_code", "200");
			map.put("res_msg", "게시글이 성공적으로 수정되었습니다.");
		}
		return map;
	}
	
}
