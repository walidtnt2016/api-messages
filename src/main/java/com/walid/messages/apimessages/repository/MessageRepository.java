package com.walid.messages.apimessages.repository;

import com.walid.messages.apimessages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message ,Long> {
}