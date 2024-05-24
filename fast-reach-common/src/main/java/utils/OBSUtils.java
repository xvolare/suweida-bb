package utils;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.UUID;
@Slf4j
@Component
public class OBSUtils {
    private final String endPoint = "https://obs.cn-east-3.myhuaweicloud.com";
    private final String accessKeyId = "R49VXB11LOB0BQIYDLBN";
    private final String secetAccessKey = "d30sVoKTnpynKUU79QnDGQb5VbMlGsRH5K9a63B8";
    private final String bucketName = "disher-img";
    public String upload(MultipartFile file){
        ObsClient obsClient = new ObsClient(accessKeyId, secetAccessKey,endPoint);
        String fileName = UUID.randomUUID() +
                file.getOriginalFilename().
                        substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            // 上传字符串（byte数组）
            String content = "Hello OBS";
            obsClient.putObject(bucketName, fileName, file.getInputStream());
            log.info("上传成功");
        } catch (Exception e) {
            System.out.println("putObject failed");
            // 其他异常信息打印
            e.printStackTrace();
        }
        return "https://"+bucketName+"."+"obs.cn-east-3.myhuaweicloud.com"+"/"+fileName;
    }
}
