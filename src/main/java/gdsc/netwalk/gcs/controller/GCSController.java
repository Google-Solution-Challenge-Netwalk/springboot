package gdsc.netwalk.gcs.controller;

import gdsc.netwalk.dto.common.CustomResponse;
import gdsc.netwalk.gcs.dto.GCSUploadFileRequest;
import gdsc.netwalk.gcs.service.GCSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/v1/gcs")
public class GCSController {
    @Autowired
    private GCSService gcsService;

    @ResponseBody
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<CustomResponse> uploadFile(@RequestPart("file") MultipartFile file,
                                                     GCSUploadFileRequest gcsUploadFileRequest) throws IOException {
        CustomResponse response = gcsService.uploadFile(file, gcsUploadFileRequest);
        return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
    }
}
