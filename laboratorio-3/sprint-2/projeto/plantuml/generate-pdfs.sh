



java -jar plantuml.jar -tpdf classe.plantuml ;
java -jar plantuml.jar -tpdf implantacao.plantuml;
java -jar plantuml.jar -tpdf componente.plantuml;
java -jar plantuml.jar -tpdf caso-de-uso.plantuml;
java -jar plantuml.jar -tpdf DER.plantuml;


mv classe.pdf ../ ; 
mv implantacao.pdf ../ ; 
mv componente.pdf ../ ; 
mv caso-de-uso.pdf ../ ; 
mv DER.pdf ../ ; 



