package com.kyungbae.section03.view;

import com.kyungbae.section03.dto.CategoryDto;
import com.kyungbae.section03.dto.MenuDto;

import java.util.List;

public class ResultView {

    // 메뉴목록 결과화면 출력
    public static void displayMenuList(List<MenuDto> list){
        if (list.isEmpty()) {
            System.out.println("조회된 메뉴가 없습니다.");
        } else {
            for (MenuDto menu : list) {
                System.out.println(menu);
            }
        }
    }

    // 카테고리목록 출력화면
    public static void displayCategoryList(List<CategoryDto> list){

        int i = 1;
        for (CategoryDto category : list) {
            if (i % 5 == 0) {
                System.out.print("[ " + category.getCategoryCode() + ", " + category.getCategoryName() + " ]" + "  \n");
            } else {
                System.out.print("[ " + category.getCategoryCode()+ ", " + category.getCategoryName() + " ]" + "  ");
            }
            i++;
        }
        System.out.println();
    }

    // 한건의 메뉴 정보 출력해주는 화면
    public static void displayMenu(MenuDto menu){
        if (menu == null) {
            System.out.println("조회된 메뉴가 없습니다.");
        } else {
            System.out.println(menu);
        }
    }

    // CUD 결과 출력
    public static void displayResult(String type, int result){
        System.out.println(type + " " + (result > 0 ? "성공" : "실패"));
    }


}
