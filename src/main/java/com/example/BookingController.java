package com.example.Controller;

import com.example.entity.Booking;
import com.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookingController {
    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping("/name/{name}")
    public Booking findByName(@PathVariable Long name){
        return this.bookingService.findById(name);
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
    public List<Booking> findByName(){

        return this.bookingService.findAll();
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking){

        return this.bookingService.addBooking(booking);
    }

    @PutMapping
    public Booking updateBooking(@RequestBody Booking booking){
        return this.bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return this.bookingService.deleteById(id);
    }
}
