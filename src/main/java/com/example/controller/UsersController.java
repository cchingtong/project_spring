package com.example.controller;

import com.example.configuration.exceptions.TransactionException;
import com.example.entity.Users;
import com.example.entity.enums.GenderEnum;
import com.example.entity.projection.UsersProjection;
import com.example.entity.request.UsersFilter;
import com.example.entity.request.UsersReq;
import com.example.entity.response.ApiResponse;
import com.example.entity.response.ApiStatus;
import com.example.entity.response.Pagination;
import com.example.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.transaction.TransactionalException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Users")
public class UsersController {
    final UsersService usersService;

    @Autowired
    private UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/{id}")
    public ApiResponse findUserById(@PathVariable Long id){
        UsersProjection users = this.usersService.findUsersProjectionById(id);
        if (users != null) {
           return new ApiResponse<>(
                   ApiStatus.SUC_RETRIEVED.getCode(),
                   ApiStatus.SUC_RETRIEVED.getMessage(),
                   users
           );
        }
        return new ApiResponse<>(ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage());
    }


    @PostMapping
    public ApiResponse add(@RequestBody UsersReq req){
        Users users = new Users();
        users.setFirst_name(req.getFirst_name());
        users.setLast_name(req.getLast_name());
        users.setPhone_number(req.getPhone_number());
        users.setEmail(req.getEmail());
        users.setIs_verified(req.getIs_verified());
        BeanUtils.copyProperties(req, users);
        users.setGenderEnum(GenderEnum.valueOf(req.getGender()));

        Users insertedUsers = usersService.add(users);
        UsersProjection usersProjection = this.usersService.findUsersProjectionById(insertedUsers.getId());
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage()
        );
//        return this.usersService.add(users);

    }

    @PutMapping("/{id}")
    public ApiResponse update(@RequestBody UsersReq req, @PathVariable Long id) throws TransactionalException {
        Users users = new Users();
        UsersProjection usersProjection = null;
        try{
            BeanUtils.copyProperties(req, users);
            users.setId(id);
            users.setGenderEnum(GenderEnum.valueOf(req.getGender()));
//            return this.usersService.update(users);
            Users update = usersService.update(users);
            usersProjection = this.usersService.findUsersProjectionById(update.getId());
        } catch (Exception e){
            e.printStackTrace();
            throw new TransactionException(
                    ApiStatus.FAI_UPDATED.getCode(),
                    ApiStatus.FAI_UPDATED.getMessage());
        }
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage(),
                usersProjection);
    }

    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Long id ){
        this.usersService.deleteById(id);
        return new ApiResponse(ApiStatus.SUC_DELETED.getCode(), ApiStatus.SUC_DELETED.getMessage());
//        return "delete user";
    }

    @Operation(summary = "Find Data")
    @Parameters({
            @io.swagger.v3.oas.annotations.Parameter(in = ParameterIn.QUERY
                    , description = "Page you want to retrieve (1..N)"
                    , name = "page"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "1"))),
            @io.swagger.v3.oas.annotations.Parameter( in = ParameterIn.QUERY
                    , description = "Number of records per page."
                    , name = "size"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
    })
    @PostMapping("/filter")
    public ApiResponse<List<UsersProjection>> findUsersByFirstnameContaining(
            @RequestBody UsersFilter usersFilter,
            @Parameter(hidden = true)Pagination pagination){
        List<UsersProjection> users = this.usersService.findUsersProjectionByFirstnameContainingIgnoreCase(usersFilter.getFirst_name(), pagination);
        if (users != null){
            return new ApiResponse<>(
                    ApiStatus.SUC_RETRIEVED.getCode(),
                    ApiStatus.SUC_RETRIEVED.getMessage(),
                    users,
                    pagination
            );
        }
        return new ApiResponse<>(ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage());
    }


}
