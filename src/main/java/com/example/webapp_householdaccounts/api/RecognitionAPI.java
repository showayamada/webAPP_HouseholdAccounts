package com.example.webapp_householdaccounts.api;

import com.example.webapp_householdaccounts.service.RecognitionResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.IOException;


@Repository
public class RecognitionAPI {

    // EC2の画像の送付先　application.propertiesファイルから読み込む
    @Value("${Recognition.api.url}")
    private String API_URL;

    // HTTPの表旧メッセージを作成
    private final RestTemplate restTemplate;

    public RecognitionAPI(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }



    public RecognitionResponse Recognition(Resource imageResource) {

        // HTTPのヘッダに"multipart/form-data"で送信することを設定
        HttpHeaders formHeaders = new HttpHeaders();
        formHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Map で送信データを定義
        MultiValueMap<String , Object> map = new LinkedMultiValueMap<>();
        map.add("file", imageResource);

        // ResourceからFileを取得
//        File file;
//        try{
//            file = ResourceUtils.getFile(imageResource.getURI());
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Invaild image resourse");
//        }


        // HTTPの要求メッセージを作成し、API_URLにPOST
        HttpEntity<MultiValueMap<String, Object>> formEntity =
                new HttpEntity<>(map, formHeaders);
        ResponseEntity<RecognitionResponse> response =
                restTemplate.postForEntity(API_URL, formEntity, RecognitionResponse.class);

        System.out.println(response.getBody());//できてない
        // HTTPの返答メッセージから返答データを取得
        return response.getBody();
    }

}
