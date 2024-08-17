package com.store.service;

import com.store.definition.Product;
import com.store.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();
    // 모든 제품들의 목록을 출력하는 메소드
    public void findAllProduct() {
        ArrayList<Product> findProducts = productRepository.selectAllProducts();

        for (Product product : findProducts) {
            System.out.println("product : " + product);
        }
    }
    // 제품이 등록되어 있는지 확인하는 메소드
    public void findProductByName(String name) {
        Product selectedProduct = productRepository.selectProductByName(name);

        if(selectedProduct != null) {
            System.out.println(selectedProduct);
        } else {
            System.out.println("해당 이름을 가진 제품은 없습니다.");
        }
    }
    // 새로운 제품을 등록하는 메소드
    public void regisProduct(Product product) {

        int lastGoodsNo = productRepository.selectLastProductNo();
        product.setNumber(lastGoodsNo + 1);

        int result = productRepository.insertProduct(product);

        if(result == 1)
            System.out.println(product.getName() + " 제품 등록이 완료 되었습니다.");
    }
    // 제품에 대한 모든 정보를 삭제하는 메소드
    public void removeProduct(String name) {
        String result = productRepository.deleteProduct(name);

        if(result == null) {
            System.out.println("제품 삭제가 완료 되었습니다.");
        } else {
            System.out.println("입력하신 제품 이름에 해당하는 제품이 없습니다.");
        }
    }
    // 현재 날짜를 기준으로 제품의 유통 기한이 지났는지 확인하는 메소드
    public boolean isExpiredProduct(Product product) {

        return LocalDate.now().isAfter(product.getEndDay());
    }
    // 유통 기한이 지난 제품의 재고를 감소하는 메소드
    public void discardExpiredItems(String name) {

        Product selectedProducts = productRepository.selectProductByName(name);

        if (isExpiredProduct(selectedProducts)) {
            System.out.println(selectedProducts.getName() + " 기간이 만료되어 폐기될 예정입니다.");
            selectedProducts.setStock(selectedProducts.getStock() - 1);
        }
    }
    // 제품에 대한 정보를 수정하는 메소드
    public Product findProductForModify(String name) {

        Product selectedProduct = productRepository.selectProductByName(name);

        if(selectedProduct != null) {
            Product newInstance = new Product();
            newInstance.setNumber(selectedProduct.getNumber());
            newInstance.setName(selectedProduct.getName());
            newInstance.setStock(selectedProduct.getStock());
            newInstance.setPrice(selectedProduct.getPrice());
            newInstance.setEndDay(selectedProduct.getEndDay());
            return newInstance;
        }

        System.out.println("입력하신 제품 이름에 해당하는 제품이 없습니다.");
        return null;
    }
    // 수정된 제품의 정보를 시스템에 등록하는 메소드
    public void modifyProduct(Product product) {
        int result = productRepository.updateProduct(product);

        if(result == 1) {
            System.out.println("제품 정보 수정이 완료 되었습니다.");
        } else {
            System.out.println("입력하신 제품 이름에 해당하는 제품이 없습니다.");
        }
    }
}