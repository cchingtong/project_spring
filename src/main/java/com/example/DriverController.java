package com.example.Controller;

import com.example.entity.Driver;
import com.example.service.DiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class DriverController {
    private DiverService diverService;
    @Autowired
    public DriverController(DiverService diverService){
        this.diverService = diverService;
    }

    @GetMapping("/name/{name}")
    public Driver findByName(@PathVariable Long name){
        return this.diverService.findById(name);
    }

    /*
    @Operation(summary = "Find Data")
    @Parameters({
            @Parameter(in = ParameterIn.QUERY
                    , description = "Page you want to retrieve (0..N)"
                    , name = "page"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))),
            @Parameter(in = ParameterIn.QUERY
                    , description = "Number of records per page."
                    , name = "size"
                    , content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
    })
     */
//    @GetMapping("/all")
//    public Map<String, Object> findByName(Pagination pagination){
//        List<CategoryProjection> cate = this.categoryService.findCategoryProjectionAll(pagination);
//        Map<String, Object> map = new HashMap<>();
//        map.put("data", cate);
//        map.put("pagination", pagination);
//        return map;
//    }

    @GetMapping
    public List<Driver> findByName(){

        return this.diverService.findAll();
    }

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver){

        return this.diverService.addDriver(driver);
    }

    @PutMapping
    public Driver updateDriver(@RequestBody Driver driver){
        return this.diverService.updateDriver(driver);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.diverService.deleteById(id);
    }
}
