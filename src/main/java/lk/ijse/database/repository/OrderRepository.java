package lk.ijse.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.database.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
