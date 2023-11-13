package com.example.apemain.service;

import com.example.apemain.domains.returns.MostSoldItem;
import com.example.apemain.domains.returns.ShopinCartItem;
import com.example.apemain.repository.ApeRepository;
import com.example.apemain.repository.ShopingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {
    private final ApeRepository apeRepository;
    private final ShopingRepository shopingRepository;

    public MostSoldItem getMostSoldItem(){
        try{
            return apeRepository.getMostSoldItem();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String putItemIntoCart(int userId,int itemId) {
        int saleId=checkIfCartExistsForUser(userId);
        try{
            shopingRepository.addToShopingCart(saleId,itemId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private int checkIfCartExistsForUser(int userId) {
        try {
            int shpoingCardNumber= shopingRepository.cheIfShopingCartExistsForUser(userId);
            if(shpoingCardNumber==0){
                return shopingRepository.createShopingCart(userId);
            }
            return shpoingCardNumber;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<ShopinCartItem> getShpoingCartItemsByUserId(final int userID) {
        try {
            return shopingRepository.getUsersShopingCartItems(userID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
