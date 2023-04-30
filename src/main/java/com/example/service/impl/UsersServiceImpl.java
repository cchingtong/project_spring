//package com.example.service.impl;
//
//import com.example.configuration.exceptions.NotFoundException;
//import com.example.configuration.exceptions.TransactionException;
//import com.example.entity.Users;
//import com.example.entity.projection.UsersProjection;
//import com.example.entity.response.ApiStatus;
//import com.example.entity.response.Pagination;
//import com.example.repository.UsersRepository;
//import com.example.service.UsersService;
//import jakarta.transaction.Transactional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.util.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UsersServiceImpl implements UsersService {
//private final UsersRepository usersRepository;
//
//    @Autowired
//    public UsersServiceImpl(UsersRepository usersRepository){
//        this.usersRepository = usersRepository;
//    }
//
//    @Override
//    public Users add(Users users) {
//        Users insertedUsers = null;
//        try{
//            insertedUsers = usersRepository.save(users);
//        }catch (Exception e){
//            throw new TransactionException(
//                    ApiStatus.FAI_CREATED.getCode(),
//                    ApiStatus.FAI_CREATED.getMessage());
//        }
//
////        return usersRepository.save(users);
//        return insertedUsers;
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        //...
//        Users us = usersRepository.findById(id).orElseThrow(() -> new NotFoundException(
//                ApiStatus.NOT_FOUND.getCode(),
//                ApiStatus.NOT_FOUND.getMessage()));
//        if (!ObjectUtils.isEmpty(us)) {
//            usersRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//    @Transactional
//    @Override
//    public Users update(Users users) {
//        //...
//        Users userToUpdate = usersRepository.findById(users.getId())
//                .orElseThrow(() -> new NotFoundException(
//                        ApiStatus.NOT_FOUND.getCode(),
//                        ApiStatus.NOT_FOUND.getMessage()));
//        try{
//            if (!ObjectUtils.isEmpty(users)){
//                userToUpdate.setFirst_name(users.getFirst_name());
//                userToUpdate.setLast_name(users.getLast_name());
//                userToUpdate.setAge(users.getAge());
//                userToUpdate.setEmail(users.getEmail());
//                userToUpdate.setGenderEnum(users.getGenderEnum());
//                userToUpdate.setIs_verified(users.getIs_verified());
//                userToUpdate.setPhone_number(users.getPhone_number());
//
//                return usersRepository.save(userToUpdate);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new TransactionException(
//                    ApiStatus.FAI_UPDATED.getCode(),
//                    ApiStatus.NOT_FOUND.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public Users findById(Long id) {
//        return this.usersRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException(
//                        ApiStatus.NOT_FOUND.getCode(),
//                        ApiStatus.NOT_FOUND.getMessage()));
//    }
//
//    @Override
//    public UsersProjection findUsersProjectionById(Long id) {
//        return this.usersRepository.findUserProjectionById(id)
//                .orElseThrow(() -> new NotFoundException(
//                                ApiStatus.NOT_FOUND.getCode(),
//                                ApiStatus.NOT_FOUND.getMessage()
//                        )
//                );
//    }
//
//    @Override
//    public List<UsersProjection> findUsersProjectionByFirstnameContainingIgnoreCase(String firstname, Pagination pagination) {
//        Page<UsersProjection> usersProjection = this.usersRepository.findUsersProjectionByFirstnameContainingIgnoreCase(
//                firstname, PageRequest.of(pagination.getPage()-1, pagination.getSize())
//        );
//        pagination.setTotalCounts((usersProjection.getTotalElements()));
//        return usersProjection.getContent();
//    }
//
//
//
//}