Exercice innso : 
A- Lancez la commande clone pour copier l'api sur dans votre machine 
B- Lancer la commande :  mvn clean install -Dmaven.test.skip=true
C-deplacer ver le dossier target
D- lancer le jar creé avec la commande : java -jar api-messages-0.0.1-SNAPSHOT.jar
E- maintenant , lorsque l'application se demarre , ovrez le lien suivant : http://localhost:8015/swagger-ui.html 
F- vous allez maintenant tester les different web service restfull :
    1- en utilisant le service "creer un message" : vous pouvez creer le message en tapant le non de l'auteur et le contenu du message (vous trouvez deux champs text input), 
    il va creer le message et l'enregistrer dans la base H2
    2- en utilisant le service "creer dossier et rattacher message precedent" : creez un dossier client , en tapant le nom du client , il va creer le dossier client , et il va affecter a ce dossier client le dernier message creé.
    3- creer l'autre message du Sonia Valentine , en utilisant le service dans "creer un message" .
    4- rattacher le message precedent avec un dossier client (le precedent par exemple ) avec le service : "rattacher un message à un dossier" , il faut saisir l'identifiant du dossier 
et l'identifiant du message
    5- modifier la reference du dossier en utilisant le service "modifier un dossier" : il faut mettre tous le corp de l'objet dossier client  
    6-recupere la liste des dossiers : avec le service "lister les dossiers"