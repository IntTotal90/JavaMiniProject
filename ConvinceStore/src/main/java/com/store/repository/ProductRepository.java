package com.store.repository;

import com.store.definition.*;
import com.store.stream.MyObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductRepository {
    private final ArrayList<Product> productList = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/store/db/productDB.dat";

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

    private void saveProduct(File file, ArrayList<Product> products) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            for(Product product : products)
                stream.writeObject(product);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadProduct(File file) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            while(true) {
                productList.add((Product)stream.readObject());
            }
        } catch (EOFException e) {
            System.out.println("재고 정보를 다 로드하였습니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> selectAllProducts() {
        return productList;
    }

    public Product selectProductByNo(int no) {
        for(Product product : productList) {
            if(product.getNumber() == no)
                return product;
        }
        return null;
    }

    public Product selectProductByName(String name) {
        for(Product product : productList) {
            if(product.getName().equals(name))
                return product;
        }

        return null;
    }

    public int selectLastProductNo() {
        Product lastProduct = productList.get(productList.size()-1);
        return lastProduct.getNumber();
    }

    public int insertProduct(Product product) {
        int result = 0;
        try(MyObjectOutputStream stream = new MyObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
             stream.writeObject(product);
             productList.add(product);
             result = 1;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int updateProduct(Product product) {
        int result = 0;
        for(int i=0; i < productList.size(); i++) {
            if(productList.get(i).getNumber() == product.getNumber()) {
                productList.set(i, product);

                File file = new File(FILE_PATH);
                saveProduct(file, productList);
                result = 1;
            }
        }
        return result;
    }

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
