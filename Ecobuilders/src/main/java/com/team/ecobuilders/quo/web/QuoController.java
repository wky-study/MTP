package com.team.ecobuilders.quo.web;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.ecobuilders.quo.dto.QuoDTO;
import com.team.ecobuilders.quo.service.QuoService;

@Controller
public class QuoController {

    @Autowired
    QuoService quoService;

    @PostMapping("/insertQuo")
    public String insertQuo(HttpServletRequest request
            , @RequestParam("quoId") String quoId // 단일 값
            , @RequestParam("quoDate") String quoDate // 단일 값
            , @RequestParam("quoStartdate") String quoStartdateStr // 단일 값
            , @RequestParam("quoEnddate") String quoEnddateStr // 단일 값
            , @RequestParam("itemName") List<String> itemNameList	// json파일로 변환
            , @RequestParam("itemType") List<String> itemTypeList	// json파일로 변환
            , @RequestParam("quantity") List<String> quantityList	// json파일로 변환
            , @RequestParam("itemPrice") List<String> itemPriceList	// json파일로 변환
            , @RequestParam("quoPrice") String quoPrice // 단일 값
            , @RequestParam("quoOpen") String quoOpen // 단일 값
//            , @RequestParam("estId") String estId // 단일 값
            , @RequestParam("entName") String entName // 단일 값
            , @RequestParam("remarks") List<String> remarksList) {
        
        QuoDTO quoDTO = new QuoDTO();
        System.out.println("request:"+request.getParameter("quoStartdate"));

        // 현재 시간을 밀리초 단위로 구하여 quo_id에 설정
        long millis = System.currentTimeMillis();
        String quoIdMillis = String.valueOf(millis);  // 밀리초를 문자열로 변환하여 사용
        quoDTO.setQuoId(quoIdMillis); // 밀리초 값을 quo_id에 부여

        // 시공 시작 날짜
        if (quoStartdateStr != null && !quoStartdateStr.isEmpty()) {
            quoDTO.setquoStartdate(Date.valueOf(quoStartdateStr)); // 예시: String -> Date 변환
        } else {
            quoDTO.setquoStartdate(null);
        }

        // 시공 종료 날짜
        if (quoEnddateStr != null && !quoEnddateStr.isEmpty()) {
            quoDTO.setquoEnddate(Date.valueOf(quoEnddateStr)); // 예시: String -> Date 변환
        } else {
            quoDTO.setquoEnddate(null);
        }
        

        // JSON Array 생성
        JSONArray quoItemsArray = new JSONArray();

        // 품목 정보를 JSON 배열로 추가
        if (itemNameList != null && !itemNameList.isEmpty() &&
            itemTypeList != null && !itemTypeList.isEmpty() &&
            quantityList != null && !quantityList.isEmpty() &&
            itemPriceList != null && !itemPriceList.isEmpty()) {
            
            for (int i = 0; i < itemNameList.size(); i++) {
                // 빈 항목 체크
                String itemName = itemNameList.get(i);
                String itemType = itemTypeList.get(i);
                String quantityStr = quantityList.get(i);
                String itemPriceStr = itemPriceList.get(i);

                // 입력값이 모두 존재하는 경우에만 추가
                if (itemName != null && !itemName.isEmpty() &&
                    itemType != null && !itemType.isEmpty() &&
                    quantityStr != null && !quantityStr.isEmpty() &&
                    itemPriceStr != null && !itemPriceStr.isEmpty()) {
                    
                    JSONObject jsonItems = new JSONObject();
                    jsonItems.put("itemName", itemName);
                    jsonItems.put("itemType", itemType);
                    jsonItems.put("quantity", quantityStr); 
                    jsonItems.put("itemPrice", itemPriceStr); 

                    // JSON 파일을 배열에 추가
                    quoItemsArray.add(jsonItems);
                }
            }
        }

        quoDTO.setQuoItems(quoItemsArray.toString());
        quoDTO.setQuoPrice(quoPrice);
        quoDTO.setQuoOpen(quoOpen);
//        quoDTO.setEstId(estId);
        quoDTO.setEntBr(entName);
        
     // 비고 처리
        if (remarksList != null && !remarksList.isEmpty()) {
            StringBuilder remarksBuilder = new StringBuilder();
            for (int i = 0; i < remarksList.size(); i++) {
                remarksBuilder.append(remarksList.get(i));
                if (i < remarksList.size() - 1) {
                    remarksBuilder.append(", "); // 항목 사이에 쉼표 추가
                }
            }
            quoDTO.setRemarks(remarksBuilder.toString()); // 모든 비고를 결합하여 설정
        }
        
        // quoOpen 값 확인
        System.out.println("quoOpen: " + quoOpen);
        
        
        // 서비스 메서드를 호출하여 데이터베이스에 저장
        quoService.insertQuo(quoDTO);

        // 저장 후 리다이렉트
        return "redirect:/"; // 적절한 URL로 리다이렉트
    }
}

