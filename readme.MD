https://blog.engineering.publicissapient.fr/2014/04/22/construire-une-api-rest-avec-jersey-et-spring-sans-web-xml-ni-applicationcontext-xml-ni-getterssetters/

## Commandes

Pour lancer un Tomcat Embarqué :
	
	mvn tomcat7:run

## Si War non déployé sur tomcat / Tomcat ne voit rien 

right click -> properties -> Deployment Assembly

Ajouter les dépendances Maven sous WEB_INF/lib