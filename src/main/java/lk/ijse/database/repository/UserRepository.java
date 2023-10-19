package lk.ijse.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.database.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
