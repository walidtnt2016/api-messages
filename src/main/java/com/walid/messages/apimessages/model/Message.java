package com.walid.messages.apimessages.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walid.messages.apimessages.Canal.Canal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private LocalDateTime dateMessage;
    @Column
    private String cotenueMessage;
    @Column
    private String auteur;
    @Column
    private Canal canal ;

    @ManyToOne
    @JoinColumn(name="dossier_id")
    private DossierClient dossierClient ;

}
