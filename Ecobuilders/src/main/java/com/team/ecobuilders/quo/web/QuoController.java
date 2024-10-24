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
            , @RequestParam("quoId") String quoId // ���� ��
            , @RequestParam("quoDate") String quoDate // ���� ��
            , @RequestParam("quoStartdate") String quoStartdateStr // ���� ��
            , @RequestParam("quoEnddate") String quoEnddateStr // ���� ��
            , @RequestParam("itemName") List<String> itemNameList	// json���Ϸ� ��ȯ
            , @RequestParam("itemType") List<String> itemTypeList	// json���Ϸ� ��ȯ
            , @RequestParam("quantity") List<String> quantityList	// json���Ϸ� ��ȯ
            , @RequestParam("itemPrice") List<String> itemPriceList	// json���Ϸ� ��ȯ
            , @RequestParam("quoPrice") String quoPrice // ���� ��
            , @RequestParam("quoOpen") String quoOpen // ���� ��
//            , @RequestParam("estId") String estId // ���� ��
            , @RequestParam("entName") String entName // ���� ��
            , @RequestParam("remarks") List<String> remarksList) {
        
        QuoDTO quoDTO = new QuoDTO();
        System.out.println("request:"+request.getParameter("quoStartdate"));

        // ���� �ð��� �и��� ������ ���Ͽ� quo_id�� ����
        long millis = System.currentTimeMillis();
        String quoIdMillis = String.valueOf(millis);  // �и��ʸ� ���ڿ��� ��ȯ�Ͽ� ���
        quoDTO.setQuoId(quoIdMillis); // �и��� ���� quo_id�� �ο�

        // �ð� ���� ��¥
        if (quoStartdateStr != null && !quoStartdateStr.isEmpty()) {
            quoDTO.setquoStartdate(Date.valueOf(quoStartdateStr)); // ����: String -> Date ��ȯ
        } else {
            quoDTO.setquoStartdate(null);
        }

        // �ð� ���� ��¥
        if (quoEnddateStr != null && !quoEnddateStr.isEmpty()) {
            quoDTO.setquoEnddate(Date.valueOf(quoEnddateStr)); // ����: String -> Date ��ȯ
        } else {
            quoDTO.setquoEnddate(null);
        }
        

        // JSON Array ����
        JSONArray quoItemsArray = new JSONArray();

        // ǰ�� ������ JSON �迭�� �߰�
        if (itemNameList != null && !itemNameList.isEmpty() &&
            itemTypeList != null && !itemTypeList.isEmpty() &&
            quantityList != null && !quantityList.isEmpty() &&
            itemPriceList != null && !itemPriceList.isEmpty()) {
            
            for (int i = 0; i < itemNameList.size(); i++) {
                // �� �׸� üũ
                String itemName = itemNameList.get(i);
                String itemType = itemTypeList.get(i);
                String quantityStr = quantityList.get(i);
                String itemPriceStr = itemPriceList.get(i);

                // �Է°��� ��� �����ϴ� ��쿡�� �߰�
                if (itemName != null && !itemName.isEmpty() &&
                    itemType != null && !itemType.isEmpty() &&
                    quantityStr != null && !quantityStr.isEmpty() &&
                    itemPriceStr != null && !itemPriceStr.isEmpty()) {
                    
                    JSONObject jsonItems = new JSONObject();
                    jsonItems.put("itemName", itemName);
                    jsonItems.put("itemType", itemType);
                    jsonItems.put("quantity", quantityStr); 
                    jsonItems.put("itemPrice", itemPriceStr); 

                    // JSON ������ �迭�� �߰�
                    quoItemsArray.add(jsonItems);
                }
            }
        }

        quoDTO.setQuoItems(quoItemsArray.toString());
        quoDTO.setQuoPrice(quoPrice);
        quoDTO.setQuoOpen(quoOpen);
//        quoDTO.setEstId(estId);
        quoDTO.setEntBr(entName);
        
     // ��� ó��
        if (remarksList != null && !remarksList.isEmpty()) {
            StringBuilder remarksBuilder = new StringBuilder();
            for (int i = 0; i < remarksList.size(); i++) {
                remarksBuilder.append(remarksList.get(i));
                if (i < remarksList.size() - 1) {
                    remarksBuilder.append(", "); // �׸� ���̿� ��ǥ �߰�
                }
            }
            quoDTO.setRemarks(remarksBuilder.toString()); // ��� ��� �����Ͽ� ����
        }
        
        // quoOpen �� Ȯ��
        System.out.println("quoOpen: " + quoOpen);
        
        
        // ���� �޼��带 ȣ���Ͽ� �����ͺ��̽��� ����
        quoService.insertQuo(quoDTO);

        // ���� �� �����̷�Ʈ
        return "redirect:/"; // ������ URL�� �����̷�Ʈ
    }
}

