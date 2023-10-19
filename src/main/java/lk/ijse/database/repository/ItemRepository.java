package lk.ijse.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.database.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    //custom query
    //@Query("SELECT * FROM items WHERE category_id=:categoryId ")
    @Query("SELECT item FROM Item item WHERE item.category.id = :categoryId")
    List<Item> findItemsByCategoryId(@Param("categoryId") Long categoryId);




   
    
}
