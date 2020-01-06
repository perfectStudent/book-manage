package cn.wmkfe.bookmanage.controller.api.admin;

import cn.wmkfe.bookmanage.util.ApiResponseEnum;
import cn.wmkfe.bookmanage.util.MyUUIDUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadAPIController extends AbstractApiController {
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        Map<String, Object> map = null;
        HashMap<String, String> map2 = new HashMap<>();
        if (!uploadFile.isEmpty()) {
            //获取文件名后缀
            String originalFilename = uploadFile.getOriginalFilename();

            String suffix = uploadFile.getOriginalFilename().substring(originalFilename.lastIndexOf("."), originalFilename.length());

            if (suffix.equals(".bmp") || suffix.equals(".jpg") || suffix.equals(".png")
                    || suffix.equals(".tif") || suffix.equals(".gif")
                    || suffix.equals(".tga") || suffix.equals(".exif")
                    || suffix.equals(".fpx") || suffix.equals(".svg")
                    || suffix.equals(".psd") || suffix.equals(".pcd")
                    || suffix.equals(".dxf") || suffix.equals(".ufo")
                    || suffix.equals(".eps") || suffix.equals(".ai")
                    || suffix.equals(".WMF") || suffix.equals(".webp")) {
                //新文件名
//                String newFileName = UUID.randomUUID()+ uploadFile.getOriginalFilename();
                String newFileName = MyUUIDUtils.getUUID() + suffix;
                //文件保存目录
                String filePath = request.getServletContext().getRealPath("/images/");
                System.out.println(filePath);
                System.out.println(filePath + newFileName);
                File dest = new File(filePath);
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                uploadFile.transferTo(new File(filePath + newFileName));

                map2.put("src","/images/newFileName");

                return this.resultJson(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), map2);
            }
        }
        return this.resultJson(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), map2);
    }

}
