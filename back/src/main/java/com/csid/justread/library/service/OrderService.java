package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.OrderDao;
import com.csid.justread.library.infrastructure.entity.OrderEntity;
import com.csid.justread.library.service.model.Order;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final OrderDao orderDao;
    private final LibraryDao libraryDao;

    public OrderService(OrderDao orderDao, LibraryDao libraryDao) {
        this.orderDao = orderDao;
        this.libraryDao = libraryDao;
    }


    public List<Order> getOrders(){
        return new Converter().mapAsList( this.orderDao.findAll(), Order.class );
    }

    public Order getOrderById( UUID id ) {
        return new Converter().map( this.orderDao.findById( id ), Order.class );
    }

    public Order getOrderByLibraryId( UUID id ) {
        return new Converter().map( this.orderDao.getAllOrderByLibraryId( id ), Order.class );
    }

    public Order addOrder(Order order, UUID libraryId, String user){
        OrderEntity orderEntity = new Converter().map(order, OrderEntity.class);

        if(order==null) return null;
        orderEntity.setLibrary(libraryDao.findById(libraryId).orElse(null));

        if(orderEntity.getLibrary() == null) return null;

        return new Converter().map( this.orderDao.save(orderEntity), Order.class );
    }

}
