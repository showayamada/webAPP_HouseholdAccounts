package com.example.webapp_householdaccounts.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.webapp_householdaccounts.dto.ExpenseRequest;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.webapp_householdaccounts.entity.Expense;
import com.example.webapp_householdaccounts.service.ExpenseService;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;


/**
 * 支出情報コントローラー
 */
@Controller
public class ExpenseController {
    // 支出サービス
    @Autowired
    private ExpenseService expenseService;

    /**
     * 支出一覧画面を表示
     * @param model Model
     * @return 支出一覧画面
     */
    @GetMapping(value = "/expense/list")
    public String displayList(Model model) {
        List<Expense> expenseList = expenseService.searchAll();
        model.addAttribute("expenseList", expenseList);
        return "expense/list";
    }

    /**
     * 新規登録画面を表示
     * @param model Model
     * @return 支出一覧画面
     */
    @GetMapping(value = "/expense/register")
    public String displayRegister(Model model) {
        return "expense/register";
    }


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {

        // ファイル形式のチェック
        if(!file.getContentType().equals(MediaType.IMAGE_PNG_VALUE)){
            return "redirect:/expense/list";
        }

        // 一時ファイルとして保存
        Path tempFile = Files.createTempFile(null, null);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }

        // 画像からの登録
        Resource resource = new FileSystemResource(tempFile.toFile());
        expenseService.insert(resource);

        return "redirect:/expense/list";

    }


//    /**
//     * 支出新規登録
//     * @param expenseRequest リクエストデータ
//     * @param model Model
//     * @return 支出情報一覧画面
//     */
//    @RequestMapping(value = "/expense/create", method = RequestMethod.POST)
//    public String create(@Validated @ModelAttribute ExpenseRequest expenseRequest, BindingResult result, Model model) {
//
//        //入力エラー
//        if (result.hasErrors()){
//            List<String> errorList = new ArrayList<String>();
//            for (ObjectError error : result.getAllErrors()){
//                errorList.add(error.getDefaultMessage());
//            }
//            model.addAttribute("validationError", errorList);
//            model.addAttribute("expenseRequest", expenseRequest);
//            return "expense/register";
//        }
//
//        // 登録
//        expenseService.create(expenseRequest);
//        return "redirect:/expense/list";

//    }

    /**
     * 支出詳細画面（仮）を表示
     * @param id 表示する支出ID
     * @param model Model
     * @return 詳細画面
     */
    @GetMapping("/expense/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        return "expense/view";
    }


}
