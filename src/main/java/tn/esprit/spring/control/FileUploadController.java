package tn.esprit.spring.control;

import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.spring.entity.DatabaseFile;
import tn.esprit.spring.payloads.Response;
import tn.esprit.spring.service.DatabaseFileService;

@RestController
public class FileUploadController {
	@Autowired
	DatabaseFileService fileStorageService;

//	@PostMapping("/uploadFile/{postId}")
    @RequestMapping(path = "/uploadFile/{postId}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public Response uploadFile(@RequestParam("file") MultipartFile file, @RequestParam  int postId) {
		DatabaseFile filename = fileStorageService.storeFile(file, postId);
		String filedownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("downloadFile/")
				.path(filename.getFileName()).toString();
		return new Response(filename.getFileName(), filedownloadUri, file.getContentType(), file.getSize());

	}

	@PostMapping("/uploadMultiFiles")
	public List<Response> uploadMultiFiles(@RequestParam("files") MultipartFile[] files, @RequestParam int postId) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file, postId)).collect(Collectors.toList());
	}

}
