package com.store.run;

import com.store.definition.Product;
import com.store.definition.Snack;
import com.store.service.ProductService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Application {

    private static final ProductService productService = new ProductService();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(" ** 편의점 제품 관리 시스템 ** ");
            System.out.println("1. 모든 제품 보기");
            System.out.println("2. 제품 찾기");
            System.out.println("3. 제품 추가");
            System.out.println("4. 제품 수정");
            System.out.println("5. 제품 폐기");
            System.out.println("6. 제품 결제");
            System.out.println("0. 프로그램 종료");
            System.out.print("번호 선택 : ");
            int choice = scanner.nextInt();

            // 프로그램 번호 입력 시 프로그램 메뉴 실행
            switch(choice){
                case 1:
                    // 모든 제품 보기
                    productService.findAllProduct();
                    break;
                case 2:
                    // 제품 찾기 - 이름으로 찾기
                    productService.findProductByName(chooseName());
                    break;
                case 3:
                    // 제품 추가
                    productService.regisProduct(addProduct());
                    break;
                case 4:
                    // 제품 수정
                    Product selected = productService.modifyProduct(chooseName());
                    if(selected == null) continue;
                    productService.modifyProduct(reform(selected));
                    break;
                case 5:
                    // 제품 폐기
                    productService.removeProduct(chooseName());
                    break;
                case 6:
                    // 제품 결제
                    break;
                case 0:
                    System.out.println("편의점 제품 관리 프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("번호를 잘 못 입력했습니다.");

            }
        }
    }

    // 제품 정보 보기 기능
    private static String chooseName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("제품 이름 입력 : ");
        return scanner.nextLine();
    }

    // 제품 정보 수정 기능
    private static Product reform(Product selected){
        Product modifiedProduct = selected;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(" ** 편의점 제품 수정 **");
            System.out.println("1. 가격 수정");
            System.out.println("2. 재고 수정");
            System.out.println("3. 날짜 수정");
            System.out.println("0: 메인 메뉴로 돌아가기");
            System.out.print("번호를 선택해 주세요 : ");
            int chooseNo = scanner.nextInt();
            scanner.nextLine();

            switch (chooseNo){
                case 1:
                    System.out.print("수정 아이템 가격 입력: ");
                    modifiedProduct.setPrice(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("수정 아이템 재고 입력: ");
                    modifiedProduct.setStock(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("수정 아이템 날짜 입력: ");
                    modifiedProduct.setEndDay(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return selected;
                default:
                    System.out.println("번호를 다시 입력 바랍니다. ");

            }
            return modifiedProduct;
        }
        /* 제품 수정 구현중 */


    }

    // 제품 추가
    private static Product addProduct() {
        Product newProduct = null;

        Scanner sc = new Scanner(System.in);

        System.out.print("제품 번호를 입력하세요 : ");
        int number = sc.nextInt();

        System.out.print("제품명을 입력하세요 : ");
        String name = sc.nextLine();

        System.out.println("제품 가격을 입력하세요 : ");
        int price = sc.nextInt();

        System.out.print("제품 재고를 입력하세요 : ");
        int stock = sc.nextInt();

        System.out.print("제품 유통기한을 입력하세요 : ");
        LocalDate endDay = LocalDate.parse(sc.nextLine());


        newProduct = new Product(number, name, price, stock, endDay) {
        };

        return newProduct;
    }
}
