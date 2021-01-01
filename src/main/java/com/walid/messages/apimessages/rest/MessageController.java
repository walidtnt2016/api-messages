package com.walid.messages.apimessages.rest;

import com.walid.messages.apimessages.model.DossierClient;
import com.walid.messages.apimessages.model.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
@Api("Api messages")
public interface MessageController {

    @PostMapping("/creerMessage/{auteur}/{contenuMessage}")
    @ApiOperation("creer un message")
    public Message creerMessage(@PathVariable String auteur ,@PathVariable String contenuMessage ) throws Exception;

    @PostMapping("/creerDossierEtRattacherMessagePrecedent/{client}/")
    @ApiOperation("creer un dossier et rattacher message precedent")
    public DossierClient creerDossierEtRattacherMessagePrecedent(@PathVariable String client ) throws Exception;

    @PostMapping("/creerDossier/{client}/")
    @ApiOperation("creer un Dossier")
    public DossierClient creerDossier(@PathVariable String client ) throws Exception;

    @PutMapping("/modifierDossier")
    @ApiOperation("modifier un dossier")
    public DossierClient modifierDossier(@RequestBody DossierClient dossierClient) throws Exception;

    @PutMapping("/rattacheMessageAuDossier/{idMessage}/{idDossier}")
    @ApiOperation("rattacher un message à un dossier")
    public DossierClient rattacheMessageAuDossier(@PathVariable long idMessage ,@PathVariable long idDossier) throws Exception;


    @GetMapping("/listerDossiers")
    @ApiOperation("lister les dossiers")
    public List<DossierClient> listerDossiers() throws Exception;

    @GetMapping("/listMessages")
    @ApiOperation("lister les Messages")
    public List<Message> listMessages() throws Exception;


}
