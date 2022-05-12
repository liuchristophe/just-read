package com.csid.justread.library.api;

import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.OrderDto;
import com.csid.justread.library.service.OrderService;
import com.csid.justread.library.service.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<OrderDto> getOrders(){
        return new Converter().mapAsList( this.orderService.getOrders(), OrderDto.class);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("uuid") UUID id ){
        return ResponseEntity.ok(
                new Converter().map( this.orderService.getOrderById(id), OrderDto.class)
        );
    }

    @GetMapping("/library/{uuid}")
    public ResponseEntity<OrderDto> getOrderByLibraryId(@PathVariable("uuid") UUID id ){
        return ResponseEntity.ok(
                new Converter().map( this.orderService.getOrderByLibraryId(id), OrderDto.class)
        );
    }

    @PatchMapping("/add")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto, @RequestParam UUID libraryID, @RequestParam String user){
        OrderDto result = new Converter().map( this.orderService.addOrder(
                new Converter().map(orderDto, Order.class), libraryID, user), OrderDto.class);

        if(result==null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(result);
    }
}
