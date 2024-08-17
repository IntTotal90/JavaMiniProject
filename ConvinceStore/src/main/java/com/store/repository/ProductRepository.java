package com.store.repository;

import com.store.definition.*;
import com.store.stream.MyObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductRepository {
    /* 상품 관리 ArrayList */
    private final ArrayList<Product> productList = new ArrayList<>();

    /* DB 역할 파일 경로 */
    private static final String FILE_PATH = "src/main/java/com/store/db/productDB.dat";

    /* 생성자 */
    public ProductRepository() {
        File file = new File(FILE_PATH);

        if(!file.exists()) {
            ArrayList<Product> product = new ArrayList<>();
            product.add(new Product(1, "포카칩", 1700, 10, LocalDate.of(2024, 10, 20)));
            product.add(new Product(2, "포스틱", 1700, 10, LocalDate.of(2024, 11, 20)));
            product.add(new Product(3, "허쉬초콜릿드링크", 1400, 10, LocalDate.of(2025, 3, 25)));
            product.add(new Product(4, "코카콜라", 2000, 10, LocalDate.of(2025, 4, 27)));
            product.add(new Product(5, "삼각김밥", 1200, 4, LocalDate.of(2024, 8, 20)));
            product.add(new Product(6, "소시지", 1200, 4, LocalDate.of(2024, 9, 25)));
            product.add(new Product(7, "박카스", 1300, 10, LocalDate.of(2024, 10, 20)));
            saveProduct(file, product);
        }
        loadProduct(file);
    }

    /* 파일 저장 메소드 */
    private void saveProduct(File file, ArrayList<Product> products) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            /* for문으로 돌려서 writeObject */
            for(Product product : products)
                stream.writeObject(product);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /* 파일 로드 메소드 */
    private void loadProduct(File file) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            while(true) {
                /* for문으로 돌려서 list에 추가 */
                productList.add((Product)stream.readObject());
            }
        } catch (EOFException e) {
            System.out.println("재고 정보를 다 로드하였습니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /* 재고 전부 조회 메소드 */
    public ArrayList<Product> selectAllProducts() {
        return productList;
    }

    /* 상품번호로 조회 메소드 */
    public Product selectProductByNo(int no) {
        for(Product product : productList) {
            if(product.getNumber() == no)
                return product;
        }
        return null;
    }

    /* 상품 이름으로 조회 메소드 */
    public Product selectProductByName(String name) {
        for(Product product : productList) {
            if(product.getName().equals(name))
                return product;
        }

        return null;
    }

    /* 상품번호로 맨 마지막 상품 조회 */
    public int selectLastProductNo() {
        Product lastProduct = productList.get(productList.size()-1);
        return lastProduct.getNumber();
    }

    /* 상품 추가 메소드 */
    public int insertProduct(Product product) {
        int result = 0;
        try(MyObjectOutputStream stream = new MyObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {

             /*
             * 1. 파일에 writeObject로 파일에 반영
             * 2. productList 에 추가
             * */
             stream.writeObject(product);
             productList.add(product);
             result = 1;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /* 상품 수정 메소드 */
    public int updateProduct(Product product) {
        int result = 0;
        for(int i=0; i < productList.size(); i++) {
            if(productList.get(i).getNumber() == product.getNumber()) {
                productList.set(i, product);
                /*
                * 1. list에 수정
                * 2. 파일에 저장
                * */
                File file = new File(FILE_PATH);
                saveProduct(file, productList);
                result = 1;
            }
        }
        return result;
    }

    /* 상품 삭제 메소드 */
    public String deleteProduct(String name) {
        String result = "";
        for(int i=0; i < productList.size(); i++) {
            if(productList.get(i).getName().equals(name)) {
                File file = new File(FILE_PATH);
                productList.remove(i);
                saveProduct(file, productList);
                result = null;

                return result;
            }
        }
        return result;
    }
}
