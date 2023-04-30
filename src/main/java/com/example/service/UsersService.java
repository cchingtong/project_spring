//package com.example.service;
//
//import com.example.entity.Users;
//import com.example.entity.projection.UsersProjection;
//import com.example.entity.response.Pagination;
//
//import java.util.List;
//
//
//public interface UsersService {
//
//    Users add(Users users);
//    Users update(Users users);
//    boolean deleteById(Long id);
//    Users findById(Long id);
//
//    UsersProjection findUsersProjectionById(Long id);
//
//    List<UsersProjection> findUsersProjectionByFirstnameContainingIgnoreCase(String firstname, Pagination pagination);
//}