# GUI_correcao_de_solos

Este projeto e um GUI para o projeto https://github.com/gabrielcostasilva/sa-soilcorrection.

Os calculos feitos não são os calculos utilizados no projeto original visto que os calculos ja estão feitos, os calculos presentes neste projeto server apenas para testar a conexão entre as telas.

Foi utilizado o JavaFX por ser a uma biblioteca na mesma linguagem do projeto original e por ser simples de se criar e alterar telas com a utilização do SceneBuilder.

Para os testes goi utilizado o testfx e o junit 5. O testfx é uma biblioteca criada para que se possa testar as telas do javafx com maior facilidade e menos repetição de codigo.

A arquitetura utilizada seria o MVC visto que é o projeto é um aplicativo desktop não achei necessario a utilização de uma arquitetura mais modular como uma arquitetura de micro serviços. 
Outro motivo para a arquitetura escolhida é a divisão entre os pacotes, visto que o codigo presente no projeto original fornecido pelo professor continha alguns atributos que estavam com acesso PROTECTED a arquitetura mvc garante que o MainController tenha acesso a esses atributos por estar no mesmo pacote que o resto da logica do programa.

Por conta de problemas no processo de enviar informações entre telas diferente escolhi criar uma unica tela que possua rolagem para que o usuario chegue a area que o mesmo quer utilizar. A tela ficou com um layout similar a o layout da tabela excel na qual o projeto inicial foi baseado.

Porem isso tras o problema te todo o codigo ficar contido em um unico arquivo, infelizmete não possuo o conhecimento necessario para resolver o problema e não fui capaz de encontrar uma solução viavel.

Abaixo estão as telas feitas para o projeto:
![Primeira parte da tela](https://i.imgur.com/0aTFyiE.png)


![Segunda parte da  tela](https://i.imgur.com/0LVrVcs.png)


![Terceira parte da  tela](https://i.imgur.com/fHIqkxb.png)


![Quarta parte da  tela](https://i.imgur.com/kQU3To3.png)

Cada parte da tela foi criada para mostrar uma correção diferente mostrada no projeto original.

## Completude

Em relação a completude da atividade, não fui capazde implementar os calculos de correção do calcio magnesio, ambos libre office e google sheets não foram capazes de executar os calculos da tabela e infelizmente não tenho acesso a o microsoft excel no linux. 
De qualquer forma tentei analizar os calculos feitos na tabela e não fui capaz de compreender como o calculo de calcio magnesio esta sendo feito, a parte que consegui compreender foi implementada porem não é o calculo completo, implementei tambem calculos de custo e o V% do calcio magnesio.

Em relação ao resto do trabalho acredito ter feito ele por completo, infelizmente não terei muito tempo para implementar o calculo restante por conta de uma viagem, caso eu consiga obviamente adicionarei o update ao repositorio. 

## Instalação
O software e a instalação foi testada manualmente em dois computadores, um utilizando linux debian-11.1.0 e outro utilizando linux ubuntu 20.04 LTS.

O programa utiliza java 14.0.2 e maven 3.8.1 que devem ser instalados antes da utilização do software.

Para instalar a bibliotecas utilize o comando "mvn clean install".

Apos isso as classes devem ser compiladas e o programa deve ser iniciado apartir do arquivo SoilCorrectionLauncher.

É recomendado que seja utilizado a IDE Intellij com o arquivo .idea de configuração presente no repository


## Autores

- [@Alysty](https://github.com/Alysty)
