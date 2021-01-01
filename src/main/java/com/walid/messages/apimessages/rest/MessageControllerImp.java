package com.walid.messages.apimessages.rest;

import com.walid.messages.apimessages.model.DossierClient;
import com.walid.messages.apimessages.model.Message;
import com.walid.messages.apimessages.repository.DossierClientRepository;
import com.walid.messages.apimessages.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes;

@RestController
public class MessageControllerImp implements MessageController{

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    DossierClientRepository dossierClientRepository;

    @Override
    public Message creerMessage(String auteur , String contenuMessage) throws Exception {
        Message message =Message.builder()
                        .dateMessage(LocalDateTime.now())
                        .cotenueMessage(contenuMessage)
                        .auteur(auteur)
                        .build();
        return messageRepository.save(message);
    }

    @Override
    public DossierClient modifierDossier(DossierClient dossierClient) throws Exception {
        return dossierClientRepository.save(dossierClient) ;
    }

    @Override
    public DossierClient rattacheMessageAuDossier(long idMessage, long idDossier) throws Exception {
        Message m = messageRepository.getOne(idMessage);
        DossierClient d = dossierClientRepository.getOne(idDossier);
        if(d.getMessages().isEmpty()) {
            d.setMessages(new ArrayList<Message>());
        }
        d.getMessages().add(m);
        return  dossierClientRepository.save(d);
    }

    @Override
    public DossierClient creerDossierEtRattacherMessagePrecedent(String  client ) throws Exception {
        Optional<Message> m  =  messageRepository.findAll().stream().max(
                Comparator.comparing(Message::getDateMessage)
        );



        DossierClient dossierClient = DossierClient.builder()
                                .dateOuverture(LocalDateTime.now())
                                .nomClient(client)
                                .build();

        List <Message>  list = new ArrayList<Message>() ;
        if(m.isPresent()){
            list.add(m.get());
            dossierClient.setMessages(list);
        }
        return  dossierClientRepository.save(dossierClient);
    }

    @Override
    public DossierClient creerDossier(String client) throws Exception {
        DossierClient dossierClient = DossierClient.builder()
                .dateOuverture(LocalDateTime.now())
                .nomClient(client)
                .build();

        return dossierClientRepository.save(dossierClient);
    }

    @Override
    public List<Message> listMessages() throws Exception {
        return messageRepository.findAll() ;
    }
    @Override
    public List<DossierClient> listerDossiers() throws Exception {
        List<DossierClient>  list = dossierClientRepository.findAll();
        /*Optional<DossierClient> d  = list.stream().max(
                Comparator.comparing(DossierClient::getDateOuverture)
        );
        list = new ArrayList<DossierClient>();
        list.add(d.get()); */
        return  list;
    }



}
