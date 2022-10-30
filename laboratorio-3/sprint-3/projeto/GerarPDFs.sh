# Gerando todos os diagramas
java -jar plantuml/plantuml.jar -tpdf plantuml/*.plantuml ;
mv plantuml/*.pdf ../ ; 

# Gerando todos os diagramas de sequencia
java -jar plantuml/plantuml.jar -tpdf plantuml/sequencia/*.plantuml ;
mv plantuml/sequencia/*.pdf sequencia/ ; 

yay -S pdftk
pdftk sequencia/*.pdf cat output Sequencia.pdf




