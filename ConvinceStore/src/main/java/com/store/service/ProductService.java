package com.store.service;

import com.store.definition.Product;
import com.store.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public void findAllProduct() {
        ArrayList<Product> findProducts = productRepository.selectAllProducts();

        for (Product product : findProducts) {
            System.out.println("product : " + product);
        }
    }

//    public void findProductByNo(int no) {
//        Product selectedProduct = productRepository.selectProductByNo(no);
//
//        if(selectedProduct != null) {
//            System.out.println(selectedProduct);
//        } else {
//            System.out.println("해당 번호를 가진 제품은 없습니다.");
//        }
//    }

    public void findProductByName(String name) {
        Product selectedProduct = productRepository.selectProductByName(name);

        if(selectedProduct != null) {
            System.out.println(selectedProduct);
        } else {
            System.out.println("해당 이름을 가진 제품은 없습니다.");
        }
    }

    public void regisProduct(Product product) {

        int lastGoodsNo = productRepository.selectLastProductNo();
        product.setNumber(lastGoodsNo + 1);

        int result = productRepository.insertProduct(product);

        if(result == 1)
            System.out.println(product.getName() + " 제품 등록이 완료 되었습니다.");
    }

    public void removeProduct(String name) {
        String result = productRepository.deleteProduct(name);

        if(result == null) {
            System.out.println("제품 삭제가 완료 되었습니다.");
        } else {
            System.out.println("입력하신 제품 이름에 해당하는 제품이 없습니다.");
        }
    }

//    public void increaseProduct(Product product) {
//
//        product.setStock(product.getStock() + 1);
//
//        int result = productRepository.updateProduct(product);
//
//        if(result == 1)
//            System.out.println(product.getName() + " 제품 수량 증가가 완료 되었습니다.");
//    }
//
//    public void decreaseProduct(Product product) {
//
//        product.setStock(product.getStock() - 1);
//
//        int result = productRepository.updateProduct(product);
//
//        if(result == 1)
//            System.out.println(product.getName() + " 제품 수량 감소가 완료 되었습니다.");
//    }

    public boolean isExpiredProduct(Product product) {

        return LocalDate.now().isAfter(product.getEndDay());
    }

    public void discardExpiredItems(String name) {

        Product selectedProducts = productRepository.selectProductByName(name);

        if (isExpiredProduct(selectedProducts)) {
            System.out.println(selectedProducts.getName() + " 기간이 만료되어 폐기될 예정입니다.");
            selectedProducts.setStock(selectedProducts.getStock() - 1);
        }
    }

//    public void discardExpiredItems(Product product) {
//        if (isExpiredProduct(product)) {
//            System.out.println(product.getName() + " 기간이 만료되어 폐기될 예정입니다.");
//            product.setStock(product.getStock() - 1);
//        }
//    }

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

    public void modifyProduct(Product product) {
        int result = productRepository.updateProduct(product);

        if(result == 1) {
            System.out.println("제품 정보 수정이 완료 되었습니다.");
        } else {
            System.out.println("입력하신 제품 이름에 해당하는 제품이 없습니다.");
        }
    }
}