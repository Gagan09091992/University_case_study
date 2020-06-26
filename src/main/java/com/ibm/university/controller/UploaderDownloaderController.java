package com.ibm.university.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.university.entity.Photo;
import com.ibm.university.entity.Video;
import com.ibm.university.service.PhotoService;
import com.ibm.university.service.VideoService;


@RestController
@RequestMapping("/filestore")
public class UploaderDownloaderController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
    private PhotoService photoService;

	@GetMapping("/videos/{id}")
	public String getVideo(@PathVariable String id, Model model) throws IllegalStateException, IOException {
		Video video = videoService.getVideo(id);
		model.addAttribute("title", video.getTitle());
		model.addAttribute("url", "/videos/stream/" + id);
		return "videos";
	}

	@GetMapping("/videos/stream/{id}")
	public void streamVideo(@PathVariable String id, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Video video = videoService.getVideo(id);
		FileCopyUtils.copy(video.getStream(), response.getOutputStream());
	}

	 

	//add video to db
	@PostMapping("/videos/add")
	public String addVideo(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model)
			throws IOException {
		String id = videoService.addVideo(title, file);
		return "redirect:/videos/" + id;
	}
	
	//get photo from DB
    @GetMapping("/photos/{id}")
    public ResponseEntity getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        byte[] image = photo.getImage().getData();
	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        
    }

   //Uplaod to db
    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String id = photoService.addPhoto(title, image);
        return "redirect:/photos/" + id;
    }

}
